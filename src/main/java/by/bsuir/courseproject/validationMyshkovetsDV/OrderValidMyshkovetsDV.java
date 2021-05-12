package by.bsuir.courseproject.validationMyshkovetsDV;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс содержит методы для проверки параметров заявки.
 */
public class OrderValidMyshkovetsDV {

    /**
     * Карта ошибок валидации.
     */
    private Map<String, String> errors = new HashMap<>();

    /**
     * Главный метод для запуска проверок всех параметров при создании заявки.
     */
    public Map<String, String> validate(String title, String description){
        titleValidate(title);
        descriptionValidate(description);

        return errors;
    }

    /**
     * Проверяет, что при создании заявки был введён заголовок и его длина не более 50 символов.
     */
    private void titleValidate(String title) {
        if(title == null || title.isEmpty()){
            errors.put("titleErrorMessage", "Неверно задан заголовок.");
        }
    }

    /**
     * Проверяет, что при создании заявки было введено описание.
     */
    private void descriptionValidate(String description) {
        if(description == null || description.isEmpty() || description.length() > 50){
            errors.put("descriptionErrorMessage", "Неверно задано лписание.");
        }
    }

}
