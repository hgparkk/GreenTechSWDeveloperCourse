CREATE TABLE user_info (
    user_id         VARCHAR2(100) NOT NULL,
    user_pw         VARCHAR2(100) NOT NULL,
    user_nickname   VARCHAR2(100) NOT NULL,
    user_email      VARCHAR2(100) NOT NULL,
    user_cdate      DATE NOT NULL,
    user_mdate      DATE NULL
);

CREATE TABLE notice (
    notice_num       NUMBER(10) NOT NULL,
    notice_author    VARCHAR2(100) NOT NULL,
    notice_title     VARCHAR2(100) NOT NULL,
    notice_content   VARCHAR2(1000) NOT NULL,
    notice_view      NUMBER(10) NOT NULL
);

CREATE TABLE faq (
    f_num       NUMBER(10) NOT NULL,
    f_title     VARCHAR2(100) NOT NULL,
    f_content   VARCHAR2(100) NOT NULL,
    f_answer    VARCHAR2(100) NOT NULL,
    f_cat       VARCHAR2(100) NOT NULL
);

CREATE TABLE more_tips (
    mt_num        NUMBER(10) NOT NULL,
    mt_author     VARCHAR2(100) NOT NULL,
    mt_title      VARCHAR2(100) NOT NULL,
    mt_contents   VARCHAR2(1000) NOT NULL,
    mt_cat        VARCHAR2(100) NOT NULL
);

CREATE TABLE recipe (
    rc_num          NUMBER(10) NOT NULL,
    rc_author       VARCHAR2(100) NOT NULL,
    rc_name         VARCHAR2(100) NOT NULL,
    rc_cat          VARCHAR2(100) NOT NULL,
    rc_for_people   NUMBER(10) NOT NULL,
    rc_ctime        VARCHAR2(100) NOT NULL,
    rc_level        VARCHAR2(100) NOT NULL,
    rc_ingredient   VARCHAR2(1000) NOT NULL,
    rc_sauce        VARCHAR2(1000) NOT NULL,
    rc_foreword     VARCHAR2(100) NOT NULL,
    rc_mainword     VARCHAR2(1000) NOT NULL,
    rc_more_tips    VARCHAR2(100) NOT NULL,
    rc_likes        NUMBER(10) NOT NULL,
    rc_view         NUMBER(10),
    rc_cdate        DATE NOT NULL
);

CREATE TABLE recipe_cat (
    rcc_num    NUMBER(10) NOT NULL,
    rc_num     NUMBER(10) NOT NULL,
    rcc_name   VARCHAR2(100) NOT NULL
);

ALTER TABLE user_info ADD CONSTRAINT pk_user_info PRIMARY KEY ( user_id );

ALTER TABLE notice ADD CONSTRAINT pk_notice PRIMARY KEY ( notice_num );

ALTER TABLE faq ADD CONSTRAINT pk_faq PRIMARY KEY ( f_num );

ALTER TABLE more_tips ADD CONSTRAINT pk_tips PRIMARY KEY ( mt_num );

ALTER TABLE recipe ADD CONSTRAINT pk_recipe PRIMARY KEY ( rc_num );

ALTER TABLE notice ADD CONSTRAINT pk_notice PRIMARY KEY ( notice_num );

ALTER TABLE recipe_cat ADD CONSTRAINT pk_recipe_cat PRIMARY KEY ( rcc_num );

ALTER TABLE notice
    ADD CONSTRAINT fk_user_info_to_notice FOREIGN KEY ( notice_author )
        REFERENCES user_info ( user_id );

ALTER TABLE more_tips
    ADD CONSTRAINT fk_user_info_to_tips FOREIGN KEY ( mt_author )
        REFERENCES user_info ( user_id );

ALTER TABLE recipe
    ADD CONSTRAINT fk_user_info_to_recipe FOREIGN KEY ( rc_author )
        REFERENCES user_info ( user_id );

ALTER TABLE recipe_cat
    ADD CONSTRAINT fk_recipe_to_recipe_cat FOREIGN KEY ( rc_num )
        REFERENCES recipe ( rc_num );