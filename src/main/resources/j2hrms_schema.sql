--DROP SCHEMA j2hrms;
--CREATE SCHEMA j2hrms;
--USE j2hrms;

CREATE TABLE IF NOT EXISTS role (
	id INT(11) NOT NULL AUTO_INCREMENT,
    code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    description TEXT NULL,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT code_uq UNIQUE KEY (code),
    CONSTRAINT name_uq UNIQUE KEY (name),
    CONSTRAINT role_id_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS employee (
	id int(11) NOT NULL AUTO_INCREMENT,
	last_name VARCHAR(255) NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    middle_name VARCHAR(255) NOT NULL,
    extension_name VARCHAR(255) NULL,
    created_at datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT employee_id_pk PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user (
	id INT(11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    employee_id INT(11) NOT NULL,
    role_id INT(11) NOT NULL,
    enabled TINYINT(1) NOT NULL DEFAULT 1,
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT username_uq UNIQUE KEY (username),
    CONSTRAINT employee_id_fk FOREIGN KEY (employee_id) REFERENCES employee (id),
    CONSTRAINT role_id_fk FOREIGN KEY (role_id) REFERENCES role (id),
    CONSTRAINT user_id_pk PRIMARY KEY (id)
);