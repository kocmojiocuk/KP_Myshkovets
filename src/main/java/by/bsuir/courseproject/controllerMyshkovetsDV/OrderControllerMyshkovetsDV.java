package by.bsuir.courseproject.controllerMyshkovetsDV;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.bsuir.courseproject.modelMyshkovetsDV.BankOrder;
import by.bsuir.courseproject.modelMyshkovetsDV.OrderStatus;
import by.bsuir.courseproject.modelMyshkovetsDV.OrderTheme;
import by.bsuir.courseproject.modelMyshkovetsDV.QuicklyOrderStatus;
import by.bsuir.courseproject.serviceMyshkovetsDV.CourseProjectServiceMyshkovetsDV;
import by.bsuir.courseproject.validationMyshkovetsDV.OrderValidMyshkovetsDV;

@Controller
public class OrderControllerMyshkovetsDV {

    @Autowired
    private CourseProjectServiceMyshkovetsDV service;

    @RequestMapping(value = "order", method = RequestMethod.GET)
    public ModelAndView order(HttpSession session) {
        ModelAndView model = new ModelAndView("newOrder");

        String createOrderSuccessMessage = (String)session.getAttribute("createOrderSuccessMessage");
        if(createOrderSuccessMessage != null){
            session.removeAttribute("createOrderSuccessMessage");
            model.addObject("createOrderSuccessMessage", createOrderSuccessMessage);
        }

        return model;
    }

    @RequestMapping(value = "createorder", method = RequestMethod.POST)
    public ModelAndView createOrder(String title, String description, OrderTheme theme, QuicklyOrderStatus quickly, HttpSession session) {
        ModelAndView model = new ModelAndView("redirect:order");

        //проверяем правильность ведённых данных при создании заявки
        Map<String, String> errors = new OrderValidMyshkovetsDV().validate(title, description);
        if (!errors.isEmpty()) {
            model.setViewName("newOrder");
            model.addAllObjects(errors);
            return model;
        }

        //сохраняем новую заявку
        service.saveOrder(title, description, theme, quickly);

        session.setAttribute("createOrderSuccessMessage", "Заявка успешно создана!");

        return model;
    }

    @RequestMapping(value = "closeorder", method = RequestMethod.POST)
    public ModelAndView closeOrder(String answer, int orderNumber) {
        ModelAndView model = new ModelAndView("redirect:openorders");

        service.closeOrder(answer, orderNumber);

        return model;
    }

    @RequestMapping(value = "openorders")
    public ModelAndView openOrders() {
        ModelAndView model = new ModelAndView("orders");

        List<BankOrder> orders = service.getOrdersByStatus(OrderStatus.OPEN);
        model.addObject("orders", orders);
        model.addObject("ordersTitle", "Список открытых заявок");
        model.addObject("status", OrderStatus.OPEN.name());

        return model;
    }

    @RequestMapping(value = "closeorders")
    public ModelAndView closeOrders() {
        ModelAndView model = new ModelAndView("orders");

        List<BankOrder> orders = service.getOrdersByStatus(OrderStatus.CLOSE);
        model.addObject("orders", orders);
        model.addObject("ordersTitle", "Список закрытых заявок");
        model.addObject("status", OrderStatus.CLOSE.name());

        return model;
    }

    @RequestMapping(value = "orderinfo")
    public ModelAndView orderInfo(int number) {
        ModelAndView model = new ModelAndView("orderInfo");

        try{
            BankOrder order = service.getOrderByNumber(number).get();
            model.addObject("order", order);
        }catch(Exception e){
            model.setViewName("redirect:");
        }

        return model;
    }

}
