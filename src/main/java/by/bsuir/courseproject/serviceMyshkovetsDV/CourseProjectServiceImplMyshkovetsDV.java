package by.bsuir.courseproject.serviceMyshkovetsDV;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import by.bsuir.courseproject.modelMyshkovetsDV.BankOrder;
import by.bsuir.courseproject.modelMyshkovetsDV.Department;
import by.bsuir.courseproject.modelMyshkovetsDV.OrderStatus;
import by.bsuir.courseproject.modelMyshkovetsDV.OrderTheme;
import by.bsuir.courseproject.modelMyshkovetsDV.QuicklyOrderStatus;
import by.bsuir.courseproject.modelMyshkovetsDV.Role;
import by.bsuir.courseproject.modelMyshkovetsDV.User;
import by.bsuir.courseproject.repositoryMyshkovetsDV.BankOrderRepositoryMyshkovetsDV;
import by.bsuir.courseproject.repositoryMyshkovetsDV.UserRepositoryMyshkovetsDV;

/**
 * Реализация сервиса приложения.
 */
public class CourseProjectServiceImplMyshkovetsDV implements CourseProjectServiceMyshkovetsDV{

    private final UserRepositoryMyshkovetsDV userRepository;

    private final BankOrderRepositoryMyshkovetsDV orderRepository;

    @Autowired
    private HttpSession session;

    public CourseProjectServiceImplMyshkovetsDV(UserRepositoryMyshkovetsDV userRepository, BankOrderRepositoryMyshkovetsDV orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    public void saveUser(String login, String password, String email, String fio, String phone, Department department) {
        User user = User.builder()
            .login(login)
            .password(password)
            .email(email)
            .fio(fio)
            .role(Role.USER)
            .phone(phone)
            .department(department)
            .build();

        userRepository.save(user);
    }

    @Override
    public Optional<User> findUserByLogin(String login) {
        return userRepository.findByLogin(login);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) {
        return userRepository.findByLoginAndPassword(login, password);
    }

    @Override
    public void saveOrder(String title, String description, OrderTheme theme, QuicklyOrderStatus quickly) {
        Integer lastOrderNumber = orderRepository.getLastOrderNumber();

        BankOrder order = BankOrder.builder()
            .title(title)
            .description(description)
            .theme(theme)
            .status(OrderStatus.OPEN)
            .createDateTime(LocalDateTime.now())
            .userId(getUser().getId())
            .number(lastOrderNumber != null ? lastOrderNumber + 1 : 1)
            .quicklyStatus(quickly)
            .build();

        orderRepository.save(order);
    }

    @Override
    public void closeOrder(String answer, int orderNumber) {
        BankOrder order = getOrderByNumber(orderNumber).get();

        order.setAnswer(answer);
        order.setStatus(OrderStatus.CLOSE);
        order.setCloseDateTime(LocalDateTime.now());

        orderRepository.update(order);
    }

    @Override
    public List<BankOrder> getOrdersByStatus(OrderStatus status) {
        return orderRepository.findByStatus(getUser().getId(), getUser().getRole(), status);
    }

    @Override
    public Optional<BankOrder> getOrderByNumber(int number) {
        return orderRepository.findByNumber(getUser().getId(), getUser().getRole(), number);
    }

    /**
     * Возвращает идентификатор пользователя.
     */
    private User getUser(){
        return (User) session.getAttribute("user");
    }
}
