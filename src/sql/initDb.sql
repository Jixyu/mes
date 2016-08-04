DROP DATABASE IF EXISTS mes;
CREATE DATABASE mes;
USE mes;

DROP TABLE IF EXISTS sys_user_base;
CREATE TABLE sys_user_base (
  id             BIGINT AUTO_INCREMENT,
  login_name     VARCHAR(40) NOT NULL,
  real_name      VARCHAR(40) NOT NULL,
  work_telephone VARCHAR(30),
  email_address  VARCHAR(40),
  login_Password       VARCHAR(40),
  password_salt  VARCHAR(40),
  isdeleted      INT(1)      NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY uk_sys_user_base_loginname (login_name)
)
  ENGINE = InnoDB, DEFAULT CHARSET = utf8;