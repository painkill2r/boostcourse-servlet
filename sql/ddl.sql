CREATE TABLE boost_role
(
    role_id     INT(11) AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(100) NULL
) ENGINE = InnoDB;

INSERT INTO boost_role (description) VALUES ('ROLE_ADMIN');