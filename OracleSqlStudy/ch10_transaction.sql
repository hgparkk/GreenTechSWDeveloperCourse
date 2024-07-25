-- 은행 송금 예시
UPDATE bank
    SET
        bank_money = bank_money - 100000
WHERE
    bank_account = '422-2874-2763-910';

UPDATE bank
    SET
        bank_money = bank_money + 100000
WHERE
    bank_account = '883-9897-7648-51';
    
-- 트랜잭션 적용

BEGIN
    UPDATE bank
        SET
            bank_money = bank_money - 100000
    WHERE
        bank_account = '422-2874-2763-910';

    UPDATE bank
        SET
            bank_money = bank_money + 100000
    WHERE
        bank_account = '883-9897-7648-51';

    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
END;