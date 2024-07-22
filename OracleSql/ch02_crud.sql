INSERT INTO members (
    mem_id,
    mem_password,
    mem_name,
    mem_phone,
    mem_email
) VALUES (
    'a001',
    '123a',
    '호빵맨',
    '010-1234-5678',
    'a001@gmail.com'
);

ALTER TABLE members MODIFY
    mem_phone VARCHAR2(1000);

INSERT INTO members ( mem_id,mem_password,mem_name ) VALUES ( 'b001','123b','찐빵맨' );

INSERT INTO members VALUES (
    'c001',
    '123c',
    '꿀빵맨',
    '010-1234-5678',
    'a001@gmail.com'
);

SELECT
    mem_id,
    mem_password,
    mem_name,
    mem_phone,
    mem_email
FROM
    members;

SELECT
    mem_id,
    mem_name
FROM
    members;

SELECT
    *
FROM
    members;

UPDATE members
    SET
        mem_password = '1234'
WHERE
    mem_id = 'a001';

UPDATE members
    SET
        mem_password = '5678',
        mem_phone = '010-0000-0000'
WHERE
    mem_id = 'b001';

DELETE members;