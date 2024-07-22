DROP TABLE members;

CREATE TABLE members (
    mem_id VARCHAR2(100) NOT NULL,
    mem_password VARCHAR2(100) NOT NULL,
    mem_name VARCHAR2(100) NOT NULL,
    mem_phone VARCHAR2(100) NOT NULL,
    mem_email VARCHAR2(100) NOT NULL
);

INSERT INTO members(
    mem_id,
    mem_password,
    mem_name,
    mem_phone,
    mem_email
) VALUES (
    'a001',
    '123a',
    NULL,
    '010-1234-5678',
    'a001@gmail.com'
);

CREATE TABLE members (
    mem_id VARCHAR2(100) NOT NULL,
    mem_password VARCHAR2(100) NOT NULL,
    mem_name VARCHAR2(100) NOT NULL,
    mem_phone VARCHAR2(100) DEFAULT '010-0000-0000',
    mem_email VARCHAR2(100) NOT NULL
);

INSERT INTO members(
    mem_id,
    mem_password,
    mem_name,
    mem_email
) VALUES (
    'a001',
    '123a',
    '호빵맨',
    'a001@gmail.com'
);

SELECT * FROM members;

CREATE TABLE members (
    mem_id VARCHAR2(100) UNIQUE,
    mem_password VARCHAR2(100) NOT NULL,
    mem_name VARCHAR2(100) NOT NULL,
    mem_phone VARCHAR2(100) UNIQUE,
    mem_email VARCHAR2(100) UNIQUE
);

INSERT INTO members(
    mem_id,
    mem_password,
    mem_phone,
    mem_name,
    mem_email
) VALUES (
    'a001',
    '123a',
    '010-0000-0000',
    '호빵맨',
    'a001@gmail.com'
);

CREATE TABLE members (
    mem_id VARCHAR2(100),
    mem_password VARCHAR2(100),
    mem_name VARCHAR2(100),
    mem_phone VARCHAR2(100),
    mem_email VARCHAR2(100),
    CONSTRAINT mem_pk PRIMARY KEY(mem_id)
);

CREATE TABLE spiders(
    spi_id VARCHAR2(20),
    spi_age NUMBER(2),
    spi_length NUMBER(2),
    CONSTRAINTS spiders_pk PRIMARY KEY (spi_id, spi_age)
);
