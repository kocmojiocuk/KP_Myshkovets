package by.bsuir.courseproject.modelMyshkovetsDV;

/**
 * Срочность заявки.
 */
public enum QuicklyOrderStatus {

    /**
     * Низкая срочность.
     */
    LOW("Низкая"),

    /**
     * Средняя срочность.
     */
    MEDIUM("Средняя"),

    /**
     * Высокая срочность.
     */
    HIGH("Высокая");

    /**
     * Текст, который будет отображаться на интерфейсе.
     */
    String displayText;

    QuicklyOrderStatus(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
