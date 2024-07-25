CREATE TABLE reply_tips (
    reply_no          NUMBER(5),
    tips_no           NUMBER(38),
    reply_parent_no   NUMBER(5),
    reply_title       VARCHAR2(1000),
    reply_author      VARCHAR2(10),
    reg_date          DATE
);

CREATE SEQUENCE reply_seq;

INSERT INTO reply_tips (
    reply_no,
    tips_no,
    reply_parent_no,
    reply_title,
    reply_author,
    reg_date
) VALUES (
    reply_seq.NEXTVAL,
    1,
    NULL,
    '좋은 팁 감사합니다',
    'sunlike',
    SYSDATE
);

INSERT INTO reply_tips (
    reply_no,
    tips_no,
    reply_parent_no,
    reply_title,
    reply_author,
    reg_date
) VALUES (
    reply_seq.NEXTVAL,
    1,
    1,
    '감사합니다.',
    'arrive43',
    SYSDATE
);

INSERT INTO reply_tips (
    reply_no,
    tips_no,
    reply_parent_no,
    reply_title,
    reply_author,
    reg_date
) VALUES (
    reply_seq.NEXTVAL,
    1,
    NULL,
    '버터는 아까운데.. 마가린도 되나요?',
    'biol09',
    SYSDATE
);

INSERT INTO reply_tips (
    reply_no,
    tips_no,
    reply_parent_no,
    reply_title,
    reply_author,
    reg_date
) VALUES (
    reply_seq.NEXTVAL,
    1,
    3,
    '성분이 달라서 안될 것 같습니다.',
    'arrive43',
    SYSDATE
);

INSERT INTO reply_tips (
    reply_no,
    tips_no,
    reply_parent_no,
    reply_title,
    reply_author,
    reg_date
) VALUES (
    reply_seq.NEXTVAL,
    1,
    4,
    '그럼 식물성 버터도 가능한가요?',
    'biol09',
    SYSDATE
);

SELECT
    reply_no,
    level AS reply_level,
    tips_no,
    reply_parent_no,
    LPAD(' ',LEVEL,' ')||reply_title,
    reply_author,
    reg_date
FROM
    reply_tips
START WITH
    reply_parent_no IS NULL -- 레벨이 시작되는 조건 설정
CONNECT BY
    PRIOR reply_no = reply_parent_no -- 어느 컬럼이 부모인지 알려주어 레벨을 계산
ORDER SIBLINGS BY reply_no;