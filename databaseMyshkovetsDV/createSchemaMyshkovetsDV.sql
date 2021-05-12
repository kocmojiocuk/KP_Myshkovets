DROP DATABASE IF EXISTS myshkovets_d_v;

CREATE DATABASE myshkovets_d_v;

USE myshkovets_d_v;

/**
 * Таблица пользователей приложения.
 *
 * id - уникальный идентификатор пользователя
 * login - уникальный логин
 * password - пароль
 * email - адрес электронной почты
 * role - роль пользователя (ADMIN, USER)
 * fio - фамилия имя отчество
 * phone - номер телефона
 * department - отдел в котором работает пользователь
 */
CREATE TABLE user(
    id         CHAR(36)     NOT NULL,
    login      VARCHAR(50)  NOT NULL UNIQUE,
    password   VARCHAR(50)  NOT NULL,
    email      VARCHAR(255) NOT NULL,
    role       VARCHAR(20)  NOT NULL,
    fio        VARCHAR(255) NOT NULL,
    phone      VARCHAR(13)  NOT NULL,
    department VARCHAR(50)  NOT NULL,
    PRIMARY KEY(id)
);

/**
 * Таблица заявок.
 *
 * id - уникальный идентификатор заявки
 * number - уникальный номер заявки
 * title - заголовок
 * description - описание проблемы
 * answer - ответ на заявку
 * theme - тема заявки
 * status - статус заявки
 * create_date_time - дата и время создания заявки
 * close_date_time - дата и время закрытия заявки
 * user_id - идентификатор пользователя, который создал заявку
 * quickly_status - срочность заявки
 */
CREATE TABLE bank_order(
    id               CHAR(36)      NOT NULL,
    number           INT           NOT NULL  UNIQUE,
    title            VARCHAR(50)   NOT NULL,
    description      VARCHAR(2000) NOT NULL,
    answer           VARCHAR(2000) NULL,
    theme            VARCHAR(50)   NOT NULL,
    status           VARCHAR(50)   NOT NULL,
    create_date_time DATETIME      NOT NULL,
    close_date_time  DATETIME,
    user_id          CHAR(36)      NOT NULL,
    quickly_status   VARCHAR(50)   NOT NULL,
    PRIMARY KEY (id)
);

/**
 * Тестовый набор пользователей.
 */
INSERT INTO user VALUES('7e25536f-7b69-467e-80e9-ed292c0a8411', '1', '1', '1', 'USER', '1', '+375291111111', 'DEPARTMENT_1');
INSERT INTO user VALUES('7e25536f-7b69-467e-80e9-ed292c0a8412', '2', '2', '2', 'ADMIN', '2', '+375292222222', 'DEPARTMENT_1');

INSERT INTO bank_order (id, number, title, description, theme, status, create_date_time, user_id, quickly_status)
VALUES('1', '1', '1', '1', 'THEME_1', 'OPEN', '2021-12-18 13:17:17', '7e25536f-7b69-467e-80e9-ed292c0a8411', 'LOW');
INSERT INTO bank_order (id, number, title, description, theme, status, create_date_time, user_id, quickly_status)
VALUES('3', '3', '3', '3', 'THEME_2', 'OPEN', '2021-12-18 13:17:17', '7e25536f-7b69-467e-80e9-ed292c0a8411', 'HIGH');
INSERT INTO bank_order (id, number, title, description, theme, status, create_date_time, user_id, quickly_status)
VALUES('4', '4', '4', '4', 'THEME_3', 'OPEN', '2021-12-18 13:17:17', '7e25536f-7b69-467e-80e9-ed292c0a8411', 'MEDIUM');
INSERT INTO bank_order (id, number, title, description, theme, status, create_date_time, user_id, quickly_status)
VALUES('8', '8', '8', '8', 'THEME_3', 'OPEN', '2021-12-18 13:17:17', '7e25536f-7b69-467e-80e9-ed292c0a8411', 'LOW');
INSERT INTO bank_order (id, number, title, description, theme, status, create_date_time, user_id, quickly_status)
VALUES('9', '9', '9', '9', 'THEME_1', 'OPEN', '2021-12-18 13:17:17', '7e25536f-7b69-467e-80e9-ed292c0a8411', 'LOW');
INSERT INTO bank_order (id, number, title, description, theme, status, create_date_time, user_id, quickly_status)
VALUES('11', '11', '11', '11', 'THEME_2', 'OPEN', '2021-12-18 13:17:17', '7e25536f-7b69-467e-80e9-ed292c0a8411', 'HIGH');

INSERT INTO bank_order (id, number, title, description, answer, theme, status, create_date_time, close_date_time, user_id, quickly_status)
VALUES('2', '2', '2', '2', '', 'THEME_2', 'CLOSE', '2021-12-18 13:17:17', '2021-12-18 13:17:17', '7e25536f-7b69-467e-80e9-ed292c0a8411', 'HIGH');
INSERT INTO bank_order (id, number, title, description, answer, theme, status, create_date_time, close_date_time, user_id, quickly_status)
VALUES('5', '5', '5', '5', '', 'THEME_1', 'CLOSE', '2021-12-18 13:17:17', '2021-12-18 13:17:17', '7e25536f-7b69-467e-80e9-ed292c0a8411', 'LOW');
INSERT INTO bank_order (id, number, title, description, answer, theme, status, create_date_time, close_date_time, user_id, quickly_status)
VALUES('6', '6', '6', '6', '', 'THEME_3', 'CLOSE', '2021-12-18 13:17:17', '2021-12-18 13:17:17', '7e25536f-7b69-467e-80e9-ed292c0a8411', 'HIGH');
INSERT INTO bank_order (id, number, title, description, answer, theme, status, create_date_time, close_date_time, user_id, quickly_status)
VALUES('7', '7', '7', '7', '', 'THEME_2', 'CLOSE', '2021-12-18 13:17:17', '2021-12-18 13:17:17', '7e25536f-7b69-467e-80e9-ed292c0a8411', 'MEDIUM');