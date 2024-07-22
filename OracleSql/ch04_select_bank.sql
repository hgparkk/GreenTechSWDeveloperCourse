SELECT
    bank_id,
    bank_name,
    bank_account,
    bank_money,
    bank_year
FROM
    bank;

-- 테이블에 COMMENT 달기

COMMENT ON TABLE bank IS
    '은행 고객 정보';

-- 컬럼에 COMMENT 달기

COMMENT ON COLUMN bank.bank_id IS
    '주민등록번호';

COMMENT ON COLUMN bank.bank_name IS
    '고객명';

COMMENT ON COLUMN bank.bank_account IS
    '계좌번호';

COMMENT ON COLUMN bank.bank_money IS
    '예금';

COMMENT ON COLUMN bank.bank_year IS
    '이용년수';

SELECT
    bank_id,
    bank_name,
    bank_account,
    bank_money,
    bank_year,
        CASE
            WHEN bank_year >= 20 THEN '다이아'
            WHEN bank_year >= 10 THEN '골드'
            WHEN bank_year >= 5  THEN '실버'
            ELSE '브론즈'
        END
    AS bank_tier
FROM
    bank;

CREATE VIEW bank_view AS
    SELECT
        bank_id,
        bank_name,
        bank_account,
        bank_money,
        bank_year,
            CASE
                WHEN bank_year >= 20 THEN '다이아'
                WHEN bank_year >= 10 THEN '골드'
                WHEN bank_year >= 5  THEN '실버'
                ELSE '브론즈'
            END
        AS bank_tier
    FROM
        bank;

SELECT
    bank_id,
    bank_name,
    bank_account,
    bank_money,
    bank_year,
    bank_tier
FROM
    bank_view
WHERE
    bank_tier = '골드';

SELECT
    bank_id,
    bank_name,
    bank_account,
    bank_money,
    bank_year
FROM
    (
        SELECT
            bank_id,
            bank_name,
            bank_account,
            bank_money,
            bank_year,
                CASE
                    WHEN bank_year >= 20 THEN '다이아'
                    WHEN bank_year >= 10 THEN '골드'
                    WHEN bank_year >= 5  THEN '실버'
                    ELSE '브론즈'
                END
            AS bank_tier
        FROM
            bank
    )
WHERE
    bank_tier = '골드';

SELECT
    bank_id,
    bank_name,
    bank_account,
    bank_money,
    bank_year
FROM
    bank_view
WHERE
        bank_tier = '골드'
    OR
        bank_tier = '실버';

SELECT
    bank_id,
    bank_name,
    bank_account,
    bank_money,
    bank_year
FROM
    bank_view
WHERE
    bank_tier IN (
        '골드','실버'
    );

SELECT
    *
FROM
    bank
WHERE
    bank_year IS NULL;

SELECT
    *
FROM
    bank
WHERE
    bank_year IS NOT NULL;

SELECT
    ROWNUM || '등' AS rank,
    stu_id,
    stu_name,
    stu_birth,
    stu_eng,
    stu_math,
    stu_total,
    stu_avg,
    stu_degree
FROM
    (
        SELECT
            ROWNUM,
            stu_id,
            stu_name,
            stu_birth,
            stu_kor stu_eng,
            stu_math,
            stu_total,
            stu_avg,
                CASE
                    WHEN stu_avg >= 90 THEN 'A'
                    WHEN stu_avg >= 80 THEN 'B'
                    ELSE 'C'
                END
            AS stu_degree
        FROM
            (
                SELECT
                    stu_id,
                    stu_name,
                    stu_birth,
                    stu_kor,
                    stu_eng,
                    stu_math,
                    stu_kor + stu_eng + stu_math AS stu_total,
                    ( stu_kor + stu_eng + stu_math ) / 3 AS stu_avg
                FROM
                    students
            )
        ORDER BY stu_avg DESC
    )
WHERE
    stu_degree IN (
        'A','B'
    );