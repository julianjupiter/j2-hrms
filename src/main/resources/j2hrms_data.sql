INSERT INTO role (id, code, name) VALUES
(1, 'ROLE_ADMIN', 'Administrator'),
(2, 'ROLE_USER', 'User'),
(3, 'ROLE_EMPLOYEE', 'Employee');

INSERT INTO employee (id, last_name, first_name, middle_name) VALUES
(1, 'Bonifacio', 'Andress', ''),
(2, 'Rizal', 'Jose', 'Protacio'),
(3, 'Aguinaldo', 'Emilio', ''),
(4, 'Mabini', 'Apolinario', '');

-- password = $2a$10$aD8zEhpUy10Yb/dyKuifkOkHPk0y47/l51lu6.EcZgxt5VDxx2V22
INSERT INTO user (id, employee_id, role_id, username, password) VALUES
(1, 1, 1, 'abonifacio', '$2a$10$aD8zEhpUy10Yb/dyKuifkOkHPk0y47/l51lu6.EcZgxt5VDxx2V22'),
(2, 1, 3, 'abonifacio2', '$2a$10$aD8zEhpUy10Yb/dyKuifkOkHPk0y47/l51lu6.EcZgxt5VDxx2V22'),
(3, 2, 2, 'jrizal', '$2a$10$aD8zEhpUy10Yb/dyKuifkOkHPk0y47/l51lu6.EcZgxt5VDxx2V22'),
(4, 2, 3, 'jrizal2', '$2a$10$aD8zEhpUy10Yb/dyKuifkOkHPk0y47/l51lu6.EcZgxt5VDxx2V22'),
(5, 3, 3, 'eaguinaldo', '$2a$10$aD8zEhpUy10Yb/dyKuifkOkHPk0y47/l51lu6.EcZgxt5VDxx2V22'),
(6, 4, 3, 'amabini', '$2a$10$aD8zEhpUy10Yb/dyKuifkOkHPk0y47/l51lu6.EcZgxt5VDxx2V22');