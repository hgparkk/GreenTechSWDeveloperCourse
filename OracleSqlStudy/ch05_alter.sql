SELECT
    *
FROM
    bank;

ALTER TABLE bank ADD CONSTRAINT bank_pk PRIMARY KEY ( bank_account );

ALTER TABLE bank MODIFY
    bank_id NOT NULL;

ALTER TABLE bank ADD CONSTRAINT bank_ck CHECK (
    bank_money IS NOT NULL
);

ALTER TABLE bank DROP CONSTRAINT bank_ck;

ALTER TABLE bank ADD bank_vip VARCHAR2(10);

ALTER TABLE bank MODIFY (
    bank_vip VARCHAR2(100)
); -- 컬럼의 타입 바꾸기

ALTER TABLE bank RENAME COLUMN bank_vip TO bank_tier;

ALTER TABLE bank DROP COLUMN bank_tier;

ALTER TABLE bank RENAME TO bank_info;

SELECT
    *
FROM
    bank_info;