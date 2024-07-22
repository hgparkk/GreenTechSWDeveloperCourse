SELECT
    bank_id,
    bank_name,
    bank_account,
    bank_money,
    bank_year
FROM bank;

-- 테이블에 COMMENT 달기
COMMENT ON TABLE bank IS '은행 고객 정보';

-- 컬럼에 COMMENT 달기
COMMENT ON COLUMN bank.bank_id IS '주민등록번호';
COMMENT ON COLUMN bank.bank_name IS '고객명';
COMMENT ON COLUMN bank.bank_account IS '계좌번호';
COMMENT ON COLUMN bank.bank_money IS '예금';
COMMENT ON COLUMN bank.bank_year IS '이용년수';

ㄴ딛ㅊㅅ