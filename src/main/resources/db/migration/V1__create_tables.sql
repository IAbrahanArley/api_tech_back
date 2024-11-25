CREATE TABLE curso (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(255) NOT NULL,
    monthly_cost DECIMAL(10, 2) NOT NULL
);

CREATE TABLE aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    course_id BIGINT,
    CONSTRAINT fk_course FOREIGN KEY (course_id) REFERENCES curso (id)
);

CREATE TABLE professor (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE disciplina (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    professor_id BIGINT,
    CONSTRAINT fk_professor FOREIGN KEY (professor_id) REFERENCES professor (id)
);

CREATE TABLE financeiro_aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_id BIGINT,
    discount DOUBLE,
    due_date INT,
    status VARCHAR(255) NOT NULL,
    CONSTRAINT fk_student FOREIGN KEY (student_id) REFERENCES aluno (id)
);

CREATE TABLE fatura (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    student_financial_id BIGINT,
    due_date DATETIME NOT NULL,
    paid_on DATETIME,
    created_at DATETIME NOT NULL,
    CONSTRAINT fk_student_financial FOREIGN KEY (student_financial_id) REFERENCES financeiro_aluno (id)
);

CREATE TABLE matricula_aluno (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    grade1 DOUBLE,
    grade2 DOUBLE,
    student_id BIGINT,
    subject_id BIGINT,
    status VARCHAR(255) NOT NULL,
    CONSTRAINT fk_student_matricula FOREIGN KEY (student_id) REFERENCES aluno (id),
    CONSTRAINT fk_subject FOREIGN KEY (subject_id) REFERENCES disciplina (id)
);
