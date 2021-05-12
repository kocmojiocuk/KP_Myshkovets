package by.bsuir.courseproject.repositoryMyshkovetsDV;

import java.util.List;
import java.util.Optional;

import by.bsuir.courseproject.modelMyshkovetsDV.BankOrder;
import by.bsuir.courseproject.modelMyshkovetsDV.OrderStatus;
import by.bsuir.courseproject.modelMyshkovetsDV.Role;

/**
 * Интерфейс взаимодействия с таблицей BANK_ORDER в базе данных.
 */
public interface BankOrderRepositoryMyshkovetsDV {

    /**
     * Сохраняет новую заявку в базу данных.
     */
    void save(BankOrder order);

    /**
     * Обновляет существующую заявку в базе данных.
     */
    void update(BankOrder order);

    /**
     * Возвращает список заявок с заданным статусом.
     */
    List<BankOrder> findByStatus(String userId, Role role, OrderStatus status);

    /**
     * Возвращает зявку с заданным номером.
     */
    Optional<BankOrder> findByNumber(String userId, Role role, int number);

    /**
     * Возвращает номер последней заявки.
     */
    Integer getLastOrderNumber();
}
