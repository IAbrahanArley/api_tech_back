CREATE TABLE auth (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    account_non_expired BOOLEAN NOT NULL,
    account_non_locked BOOLEAN NOT NULL,
    credentials_non_expired BOOLEAN NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE tb_employee (
    id BIGINT PRIMARY KEY,
    name_employee VARCHAR(255) NOT NULL,
    CONSTRAINT fk_auth_employee FOREIGN KEY (id) REFERENCES auth (id)
);

CREATE TABLE tb_permission (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255) NOT NULL UNIQUE
);

CREATE TABLE auth_permission (
    auth_id BIGINT NOT NULL,
    permission_id BIGINT NOT NULL,
    PRIMARY KEY (auth_id, permission_id),
    CONSTRAINT fk_auth_permission_auth FOREIGN KEY (auth_id) REFERENCES auth (id),
    CONSTRAINT fk_auth_permission_permission FOREIGN KEY (permission_id) REFERENCES tb_permission (id)
);
