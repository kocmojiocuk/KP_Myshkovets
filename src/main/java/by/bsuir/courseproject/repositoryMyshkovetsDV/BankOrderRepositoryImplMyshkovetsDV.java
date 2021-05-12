package by.bsuir.courseproject.repositoryMyshkovetsDV;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import by.bsuir.courseproject.modelMyshkovetsDV.BankOrder;
import by.bsuir.courseproject.modelMyshkovetsDV.OrderStatus;
import by.bsuir.courseproject.modelMyshkovetsDV.Role;

public class BankOrderRepositoryImplMyshkovetsDV implements BankOrderRepositoryMyshkovetsDV {

    private final EntityManager entityManager;

    public BankOrderRepositoryImplMyshkovetsDV(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(BankOrder order) {
        entityManager.persist(order);
    }

    @Override
    @Transactional
    public void update(BankOrder order) {
        entityManager.merge(order);
    }

    @Override
    public List<BankOrder> findByStatus(String userId, Role role, OrderStatus status) {
        String userQuery = "SELECT b FROM bank_order b WHERE b.userId = :userId AND b.status = :status ORDER BY b.number";
        String adminQuery = "SELECT b FROM bank_order b WHERE b.status = :status ORDER BY b.number";

        TypedQuery<BankOrder> query = entityManager.createQuery(role == Role.USER ? userQuery : adminQuery, BankOrder.class)
            .setParameter("status", status);

        if (role == Role.USER) {
            query.setParameter("userId", userId);
        }

        return query.getResultList();
    }

    @Override
    public Optional<BankOrder> findByNumber(String userId, Role role, int number) {
        String userQuery = "SELECT b FROM bank_order b WHERE b.userId = :userId AND b.number = :number";
        String adminQuery = "SELECT b FROM bank_order b WHERE b.number = :number";

        TypedQuery<BankOrder> query = entityManager.createQuery(role == Role.USER ? userQuery : adminQuery, BankOrder.class)
            .setParameter("number", number);

        if (role == Role.USER) {
            query.setParameter("userId", userId);
        }

        return query.getResultList().stream().findFirst();
    }

    @Override
    public Integer getLastOrderNumber() {
        return entityManager.createQuery("SELECT MAX(b.number) FROM bank_order b", Integer.class)
            .getSingleResult();
    }

}
