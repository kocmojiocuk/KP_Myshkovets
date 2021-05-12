package by.bsuir.courseproject.modelMyshkovetsDV;

/**
 * Отделы в которых работают пользователи.
 */
public enum Department {

    DEPARTMENT_1("Отдел сопровождения кредитных продуктов"),

    DEPARTMENT_2("Отдел мониторинга"),

    DEPARTMENT_3("Отдел операционный"),

    DEPARTMENT_4("Отдел сопровождения казначейских операций"),

    DEPARTMENT_5("Отдел ИТ"),

    DEPARTMENT_6("Отдел финансовых услуг");

    /**
     * Текст, который будет отображаться на интерфейсе.
     */
    String displayText;

    Department(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }

}
