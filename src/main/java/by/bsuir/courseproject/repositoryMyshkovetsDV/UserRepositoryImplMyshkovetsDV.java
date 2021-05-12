package by.bsuir.courseproject.repositoryMyshkovetsDV;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.transaction.annotation.Transactional;

import by.bsuir.courseproject.modelMyshkovetsDV.User;

/**
 * Реализация интерфейса взаимодействия с таблицей User в базе данных.
 */
public class UserRepositoryImplMyshkovetsDV implements UserRepositoryMyshkovetsDV{

    private final EntityManager entityManager;

    public UserRepositoryImplMyshkovetsDV(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(User user) {
        entityManager.persist(user);
    }

    @Override
    public Optional<User> findByLogin(String login) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login", User.class)
            .setParameter("login", login)
            .getResultList()
            .stream()
            .findFirst();
    }

    @Override
    public Optional<User> findByLoginAndPassword(String login, String password) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.login = :login AND u.password = :password", User.class)
            .setParameter("login", login)
            .setParameter("password", password)
            .getResultList()
            .stream()
            .findFirst();
    }

}
