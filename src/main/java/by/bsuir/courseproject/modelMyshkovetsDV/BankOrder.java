package by.bsuir.courseproject.modelMyshkovetsDV;

import java.time.LocalDateTime;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * Заявка.
 */
@Entity(name = "bank_order")
public class BankOrder {

    /**
     * Уникальный идентификатор заявки.
     */
    @Id
    @Column(name = "id", columnDefinition = "char(36)", length = 36)
    @Basic(fetch = FetchType.EAGER)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    /**
     * Уникальный номер.
     */
    @Column(name = "number", nullable = false, unique = true)
    private int number;

    /**
     * Заголовок.
     */
    @Column(name = "title", nullable = false)
    private String title;

    /**
     * Описание проблемы.
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * Ответ на заявку.
     */
    @Column(name = "answer")
    private String answer;

    /**
     * Тема.
     */
    @Column(name = "theme", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderTheme theme;

    /**
     * Статус.
     */
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    /**
     * Дата и время создания.
     */
    @Column(name = "create_date_time", nullable = false)
    private LocalDateTime createDateTime;

    /**
     * Дата и время закрытия.
     */
    @Column(name = "close_date_time")
    private LocalDateTime closeDateTime;

    /**
     * Идентификатор пользователя, который создал заявку.
     */
    @Column(name = "user_id", nullable = false)
    private String userId;

    /**
     * Срочность заявки.
     */
    @Column(name = "quickly_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private QuicklyOrderStatus quicklyStatus;

    /**
     * Возвращает билдер класса.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Пустой конструктор для ORM.
     */
    public BankOrder() {
    }

    /**
     * Конструктор.
     *
     * @param builder билдер класса
     */
    private BankOrder(Builder builder) {
        this.id = builder.id;
        this.number = builder.number;
        this.title = builder.title;
        this.description = builder.description;
        this.answer = builder.answer;
        this.theme = builder.theme;
        this.status = builder.status;
        this.createDateTime = builder.createDateTime;
        this.closeDateTime = builder.closeDateTime;
        this.userId = builder.userId;
        this.quicklyStatus = builder.quicklyStatus;
    }

    public String getId() {
        return id;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public OrderTheme getTheme() {
        return theme;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public LocalDateTime getCloseDateTime() {
        return closeDateTime;
    }

    public void setCloseDateTime(LocalDateTime closeDateTime) {
        this.closeDateTime = closeDateTime;
    }

    public String getUserId() {
        return userId;
    }

    public QuicklyOrderStatus getQuicklyStatus() {
        return quicklyStatus;
    }

    /**
     * Билдер класса.
     */
    public static final class Builder {

        private String id;
        private int number;
        private String title;
        private String description;
        private String answer;
        private OrderTheme theme;
        private OrderStatus status;
        private LocalDateTime createDateTime;
        private LocalDateTime closeDateTime;
        private String userId;
        private QuicklyOrderStatus quicklyStatus;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder number(int number) {
            this.number = number;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder answer(String answer) {
            this.answer = answer;
            return this;
        }

        public Builder theme(OrderTheme theme) {
            this.theme = theme;
            return this;
        }

        public Builder status(OrderStatus status) {
            this.status = status;
            return this;
        }

        public Builder createDateTime(LocalDateTime createDateTime) {
            this.createDateTime = createDateTime;
            return this;
        }

        public Builder closeDateTime(LocalDateTime closeDateTime) {
            this.closeDateTime = closeDateTime;
            return this;
        }

        public Builder userId(String userId) {
            this.userId = userId;
            return this;
        }

        public Builder quicklyStatus(QuicklyOrderStatus quicklyStatus) {
            this.quicklyStatus = quicklyStatus;
            return this;
        }

        public BankOrder build() {
            return new BankOrder(this);
        }
    }

}
