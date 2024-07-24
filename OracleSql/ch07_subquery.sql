SELECT
    bank_id,
    bank_name,
    bank_year,
    bank_tier
FROM
    (
        SELECT
            bank_id,
            bank_name,
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
    ROWNUM,
    a.*
FROM
    (
        SELECT
            bank_id,
            bank_name,
            bank_account,
            bank_money,
            bank_year
        FROM
            bank
        ORDER BY bank_money DESC
    ) a
WHERE
    ROWNUM <= 5;

SELECT
    bank_id,
    bank_name,
    bank_account,
    bank_money,
    bank_year
FROM
    bank
WHERE
    bank_money >= (
        SELECT
            AVG(bank_money)
        FROM
            bank
    );

SELECT
    bank_id,
    bank_name,
    bank_account,
    bank_money,
    bank_year
FROM
    bank
WHERE
    bank_year = (
        SELECT
            MAX(bank_year)
        FROM
            bank
    );

SELECT
    stu_id
FROM
    (
        SELECT
            stu_id,
            SUM(stu_kor + stu_eng + stu_math) AS stu_total
        FROM
            students
        GROUP BY
            stu_id
        ORDER BY stu_total DESC
    )
WHERE
    ROWNUM <= 3;

SELECT
    *
FROM
    students
WHERE
    stu_id IN (
        SELECT
            stu_id
        FROM
            (
                SELECT
                    stu_id
                FROM
                    students
                GROUP BY
                    stu_id
                ORDER BY SUM(stu_kor + stu_eng + stu_math) DESC
            )
        WHERE
            ROWNUM <= 3
    )
ORDER BY stu_id,stu_grade,stu_semester;

SELECT
    *
FROM
    tips;

SELECT
    tips_no,
        CASE
            WHEN tips_like >= 30 THEN tips_title
             || ' (핫)'
            ELSE tips_title
        END
    AS tips_title,
    tips_like,
    tips_author,
    reg_date
FROM
    tips;

SELECT
    tips_no,
        CASE
            WHEN tips_no IN (
                SELECT
                    tips_no
                FROM
                    (
                        SELECT
                            tips_no
                        FROM
                            tips
                        ORDER BY tips_like DESC
                    )
                WHERE
                    ROWNUM <= 10
            ) THEN '(핫) '
             || tips_title
            ELSE tips_title
        END
    AS tips_title,
    tips_like,
    tips_author,
    reg_date
FROM
    tips;

SELECT
    COUNT(*) AS cnt,
    tips_author
FROM
    tips
GROUP BY
    tips_author
HAVING
    COUNT(*) IN (
        SELECT
            MAX(COUNT(*) )
        FROM
            tips
        GROUP BY
            tips_author
    );

SELECT
    SUM(tips_like),
    tips_author
FROM
    tips
GROUP BY
    tips_author
HAVING
    SUM(tips_like) IN (
        SELECT
            MAX(SUM(tips_like) )
        FROM
            tips
        GROUP BY
            tips_author
    );