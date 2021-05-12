package by.bsuir.courseproject.controllerMyshkovetsDV;

import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import by.bsuir.courseproject.modelMyshkovetsDV.Department;
import by.bsuir.courseproject.modelMyshkovetsDV.Role;
import by.bsuir.courseproject.modelMyshkovetsDV.User;
import by.bsuir.courseproject.serviceMyshkovetsDV.CourseProjectServiceMyshkovetsDV;
import by.bsuir.courseproject.validationMyshkovetsDV.RegistrationValidMyshkovetsDV;

@Controller
public class WebControllerMyshkovetsDV {

    @Autowired
    private CourseProjectServiceMyshkovetsDV service;

    @RequestMapping("")
    public String index() {
        return "index";
    }

    @RequestMapping("main")
    public String main() {
        return "main";
    }

    @RequestMapping("exit")
    public String exit(HttpSession session) {
        session.invalidate();
        return "redirect:";
    }

    @RequestMapping(value = "registration", method = RequestMethod.POST)
    public ModelAndView registration(String login, String password, String email, String fio, String phone, Department department) {
        ModelAndView model = new ModelAndView("index");

        //проверяем правильность ведённых данных при регистрации
        Map<String, String> errors = new RegistrationValidMyshkovetsDV().validate(login, password, email, fio, phone);
        if (!errors.isEmpty()) { //если есть ошибки в введённых данных, то возвращаем начальную страницу и выводим тексты ошибок
            model.addAllObjects(errors);
            return model;
        }

        //проверяем есть ли пользователь с таким логином, так как логин уникальный
        Optional<User> user = service.findUserByLogin(login);
        if (user.isPresent()) {
            model.addObject("loginErrorMessage", "Пользователь с таким логином уже существует!");
            return model;
        }

        //сохраняем нового пользователя
        service.saveUser(login, password, email, fio, phone, department);

        model.addObject("registrationSuccessMessage", "Новый пользователь успешно создан!");

        return model;
    }

    @RequestMapping(value = "authorization", method = RequestMethod.POST)
    public ModelAndView authorization(String login, String password, HttpSession session) {
        ModelAndView model = new ModelAndView("redirect:main");

        //проверяем есть ли пользователь с таким логином и паролем
        Optional<User> user = service.findUserByLoginAndPassword(login, password);
        if (!user.isPresent()) {
            model.addObject("authorizationErrorMessage", "Такого пользователя не существует!");
            model.setViewName("index");
            return model;
        }

        session.setAttribute("user", user.get());
        session.setAttribute("isUser", user.get().getRole() == Role.USER);

        return model;
    }

}
