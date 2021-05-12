package by.bsuir.courseproject.modelMyshkovetsDV;

/**
 * Темы заявки.
 */
public enum OrderTheme {

    THEME_1("Не работает русская раскладка в программе"),

    THEME_2("Заблокирована учетная запись в ПО"),

    THEME_3("Не печатаются документы из программы"),

    THEME_4("Проблема с отображением корректной информации"),

    THEME_5("Другое");

    /**
     * Текст, который будет отображаться на интерфейсе.
     */
    String displayText;

    OrderTheme(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }

}
