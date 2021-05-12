package by.bsuir.courseproject.repositoryMyshkovetsDV;

import java.util.Optional;

import by.bsuir.courseproject.modelMyshkovetsDV.User;

/**
 * Интерфейс взаимодействия с таблицей User в базе данных.
 */
public interface UserRepositoryMyshkovetsDV {

    /**
     * Сохраняет нового пользователя в базу данных.
     */
    void save(User user);

    /**
     * Возвращает пользователя с указанным логином.
     */
    Optional<User> findByLogin(String login);

    /**
     * Возвращает пользователя с указанным логином и паролем.
     */
    Optional<User> findByLoginAndPassword(String login, String password);

}
