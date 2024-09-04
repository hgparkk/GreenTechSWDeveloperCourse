CREATE TABLE c_members (
    c_mem_id     VARCHAR2(100),
    c_mem_pw     VARCHAR2(100),
    c_mem_name   VARCHAR2(100)
);

ALTER TABLE c_members ADD CONSTRAINT c_members_pk PRIMARY KEY ( c_mem_id );

CREATE TABLE c_boards (
    c_board_no        NUMBER(10),
    c_board_title     VARCHAR2(1000),
    c_mem_id          VARCHAR2(100),
    c_board_content   VARCHAR2(2000),
    c_board_date      DATE,
    c_del_yn VARCHAR2(2)
);

CREATE SEQUENCE c_board_no_seq START WITH 1 INCREMENT BY 1;

ALTER TABLE c_boards MODIFY c_del_yn DEFAULT 'N';

ALTER TABLE c_boards ADD CONSTRAINT c_boards_pk PRIMARY KEY ( c_board_no );

ALTER TABLE c_boards
    ADD CONSTRAINT c_boards_fk FOREIGN KEY ( c_mem_id )
        REFERENCES c_members ( c_mem_id );
        
select * from c_members;
select * from c_boards;