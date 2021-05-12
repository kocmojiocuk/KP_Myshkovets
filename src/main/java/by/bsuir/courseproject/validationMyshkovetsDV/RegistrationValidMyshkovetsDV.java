package by.bsuir.courseproject.validationMyshkovetsDV;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс содержит методы для проверки параметров регистрации.
 */
public class RegistrationValidMyshkovetsDV {

    /**
     * Регулярное выражение для проверки правильности адреа электронной почты.
     */
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Регулярное выражение для проверки правильности номера телефона.
     */
    private static final String PHONE_PATTERN = "^(\\+375|80)(29|25|44|33)(\\d{3})(\\d{2})(\\d{2})$";

    /**
     * Карта ошибок валидации.
     */
    private Map<String, String> errors = new HashMap<>();

    /**
     * Главный метод для запуска проверок всех параметров при регистрации.
     */
    public Map<String, String> validate(String login, String password, String email, String fio, String phone){
        loginValidate(login);
        passwordValidate(password);
        emailValidate(email);
        fioValidate(fio);
        phoneValidate(phone);

        return errors;
    }

    /**
     * Проверяет, что при регистрации был введён логин и его длина не более 50 символов.
     */
    private void loginValidate(String login) {
        if(login == null || login.isEmpty() || login.length() > 50){
            errors.put("loginErrorMessage", "Неверно задан логин.");
        }
    }

    /**
     * Проверяет, что при регистрации был введён пароль и его длина не более 50 символов.
     */
    private void passwordValidate(String password) {
        if(password == null || password.isEmpty() || password.length() > 50){
            errors.put("passwordErrorMessage", "Неверно задан пароль.");
        }
    }

    /**
     * Проверяет, что при регистрации был введён email и он соответствует шаблону электронных адресов.
     */
    private void emailValidate(String email) {
        if(!email.matches(EMAIL_PATTERN)){
            errors.put("emailErrorMessage", "Неверно задан email.");
        }
    }

    /**
     * Проверяет, что при регистрации было введено ФИО и его длина не более 255 символов.
     */
    private void fioValidate(String fio) {
        if(fio == null || fio.isEmpty() || fio.length() > 255){
            errors.put("fioErrorMessage", "Неверно задано ФИО.");
        }
    }

    /**
     * Проверяет, что при регистрации был введен номер телефона и он соответствует шаблону номеров телефонов.
     */
    private void phoneValidate(String phone) {
        if(!phone.matches(PHONE_PATTERN)){
            errors.put("phoneErrorMessage", "Неверно задан номер телефона.");
        }
    }

}
