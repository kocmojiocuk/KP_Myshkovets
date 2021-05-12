package by.bsuir.courseproject.modelMyshkovetsDV;

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
 * Пользователь.
 */
@Entity
public class User {

    /**
     * Уникальный идентификатор.
     */
    @Id
    @Column(name = "id", columnDefinition = "char(36)", length = 36)
    @Basic(fetch = FetchType.EAGER)
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    /**
     * Уникальный логин.
     */
    @Column(name="login", nullable = false, unique = true)
    private String login;

    /**
     * Пароль.
     */
    @Column(name="password", nullable = false)
    private String password;

    /**
     * Электронная почта.
     */
    @Column(name="email", nullable = false)
    private String email;

    /**
     * Роль.
     */
    @Column(name="role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    /**
     * Фамилия Имя Отчество.
     */
    @Column(name="fio", nullable = false)
    private String fio;

    /**
     * Номер телефона.
     */
    @Column(name="phone", nullable = false)
    private String phone;

    /**
     * Отдел в котором работает пользователь.
     */
    @Column(name="department", nullable = false)
    @Enumerated(EnumType.STRING)
    private Department department;

    /**
     * Возвращает билдер класса.
     */
    public static Builder builder() {
        return new Builder();
    }

    /**
     * Пустой конструктор для ORM.
     */
    public User() {
    }

    /**
     * Конструктор.
     *
     * @param builder билдер класса
     */
    private User(Builder builder) {
        this.id = builder.id;
        this.login = builder.login;
        this.password = builder.password;
        this.email = builder.email;
        this.role = builder.role;
        this.fio = builder.fio;
        this.phone = builder.phone;
        this.department = builder.department;
    }

    public String getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Role getRole() {
        return role;
    }

    public String getFio() {
        return fio;
    }

    public String getPhone() {
        return phone;
    }

    public Department getDepartment() {
        return department;
    }

    /**
     * Билдер класса.
     */
    public static final class Builder {

        private String id;
        private String login;
        private String password;
        private String email;
        private Role role;
        private String fio;
        private String phone;
        private Department department;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder login(String login) {
            this.login = login;
            return this;
        }

        public Builder password(String password) {
            this.password = password;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder role(Role role) {
            this.role = role;
            return this;
        }

        public Builder fio(String fio) {
            this.fio = fio;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder department(Department department) {
            this.department = department;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
