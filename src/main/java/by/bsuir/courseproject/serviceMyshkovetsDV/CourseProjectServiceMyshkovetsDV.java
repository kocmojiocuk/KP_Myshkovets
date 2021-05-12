package by.bsuir.courseproject.serviceMyshkovetsDV;

import java.util.List;
import java.util.Optional;

import by.bsuir.courseproject.modelMyshkovetsDV.BankOrder;
import by.bsuir.courseproject.modelMyshkovetsDV.Department;
import by.bsuir.courseproject.modelMyshkovetsDV.OrderStatus;
import by.bsuir.courseproject.modelMyshkovetsDV.OrderTheme;
import by.bsuir.courseproject.modelMyshkovetsDV.QuicklyOrderStatus;
import by.bsuir.courseproject.modelMyshkovetsDV.User;

/**
 * Сервис приложения.
 * Содержит все методы доступные в данном приложении.
 */
public interface CourseProjectServiceMyshkovetsDV {

    /**
     * Формирует пользователя по переданным значениям и сохраняет его.
     */
    void saveUser(String login, String password, String email, String fio, String phone, Department department);

    /**
     * Возвращает пользователя с указанным логином.
     */
    Optional<User> findUserByLogin(String login);

    /**
     * Возвращает пользователя с указанным логином и паролем.
     */
    Optional<User> findUserByLoginAndPassword(String login, String password);

    /**
     * Формирует заявку по переданным значениям и сохраняет её.
     */
    void saveOrder(String title, String description, OrderTheme theme, QuicklyOrderStatus quickly);

    /**
     * Закрывает заявку.
     */
    void closeOrder(String answer, int orderNumber);

    /**
     * Возвращает список заявок с заданным статусом.
     */
    List<BankOrder> getOrdersByStatus(OrderStatus status);

    /**
     * Возвращает заявку с заданным номером.
     */
    Optional<BankOrder> getOrderByNumber(int number);

}
