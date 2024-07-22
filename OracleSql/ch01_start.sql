CREATE TABLE members (
    mem_id         VARCHAR2(100),
    mem_password   VARCHAR2(100),
    mem_name       VARCHAR2(100),
    mem_phone      VARCHAR2(100),
    mem_email      VARCHAR2(100)
);

CREATE TABLE books (
    book_name        VARCHAR2(100),
    book_author      VARCHAR2(100),
    book_publisher   VARCHAR2(100),
    book_price       NUMBER(10),
    book_repu        NUMBER(4,2),
    book_pdate       DATE
);