SELECT
    bank_name,
    bank_money,
    TO_CHAR(bank_money,'FM999,999,999') -- 세 자리 마다 ,찍기
FROM
    bank;

SELECT
    stu_id,
    stu_name,
    ceil(stu_avg) AS 올림,
    floor(stu_avg) AS 내림,
    round(stu_avg) AS 반올림,
    round(stu_avg,2) AS 두자리반올림
FROM
    stu_view;

SELECT
    round(3.141592,3)
FROM
    dual; -- 공백의 테이블

SELECT
    SYSDATE -- 현재 시간
FROM
    dual;

SELECT
    dbms_random.value -- 랜덤값
FROM
    dual;

SELECT
    mod(10,4) -- 나머지
FROM
    dual;

SELECT
    TO_CHAR(SYSDATE,'YYYY-MM-DD HH24:MI:SS'),
    TO_CHAR(SYSDATE,'YYYY-MM-DD AM HH:MI:SS'),
    TO_CHAR(SYSDATE,'YYYY-MM-DD AM DAY HH:MI:SS')
FROM
    dual;

SELECT
    TO_DATE('980713','YYMMDD'),
    to_timestamp('2024-07-22 15:02','YYYY-MM-DD HH24:MI')
FROM
    dual;

SELECT
    SYSDATE + 1 -- 하루 더하기
FROM
    dual;

SELECT
    SYSDATE - 2 -- 이틀 빼기
FROM
    dual;

SELECT
    TO_CHAR(SYSDATE - 2,'MM/DD DAY HH24:MI')
FROM
    dual;

-- 달에 더하기

SELECT
    add_months(SYSDATE,6),
    add_months(SYSDATE,-6),
    add_months(SYSDATE,12 * 3)
FROM
    dual;

SELECT
    replace('불타는 월요일','월','일') -- 문자열 바꾸기
FROM
    dual;

SELECT
    replace('  공백 제거 ||   ',' ',''),
    TRIM('  공백 제거 ||  '),
    ltrim('  공백 제거 ||  '),
    rtrim('   공백 제거 ||  ')
FROM
    dual;

SELECT
    substr('ABCDEFG',1,4),
    substr('ABCDEFG',2,3),
    substr('ABCDEFG',4,2),
    substr('ABCDEFG',-5,3),
    substr('ABCDEFG',5)
FROM
    dual;

SELECT
    bank_id,
    bank_name,
        CASE
            WHEN substr(bank_id,8,1) IN (
                1,2
            ) THEN ( TO_CHAR(SYSDATE,'YYYY') - ( '19'
             || substr(bank_id,1,2) ) )
             || '세'
            WHEN substr(bank_id,8,1) IN (
                3,4
            ) THEN ( TO_CHAR(SYSDATE,'YYYY') - ( '20'
             || substr(bank_id,1,2) ) )
             || '세'
        END
    AS bank_age
FROM
    bank;

SELECT
    bank_id,
    bank_name,
        CASE
            WHEN mod(
                substr(bank_id,8,1),
                2
            ) = 0 THEN '여'
            WHEN mod(
                substr(bank_id,8,1),
                2
            ) = 1 THEN '남'
        END
    AS gender
FROM
    bank;

SELECT
    lpad(1,3,'0'),-- 자리 수 맞추기 자리 수가 비면 왼쪽에 '0'을 넣음
    lpad(12,3,'0'),
    lpad(123,3,'0'),
    lpad(1234,3,'0'),
    rpad(1,3,'0'),-- 자리 수가 비면 오른쪽에 '0'을 넣음
    rpad(1234,3,'0')
FROM
    dual;

SELECT
    bank_name,
    DECODE(
        bank_year,
        NULL,
        0,
        bank_year
    ) AS bank_year -- bank_year 값이 null 이면 0,null 이 아니면 그 값 유지
FROM
    bank;

SELECT
    bank_id,
    bank_name,
    bank_account,
    bank_money,
    nvl(bank_year,0) AS bank_year -- bank_year 값이 null 이면 0,null 이 아니면 그 값 유지
FROM
    bank;

SELECT
    bank_id,
    bank_name,
    bank_account,
    bank_money,
    TO_CHAR(SYSDATE,'YYYY') - nvl(bank_year,0) AS reg_date
FROM
    bank;

SELECT
    SUM(bank_money)
FROM
    bank;

SELECT
    stu_name,
    stu_total
FROM
    stu_view
WHERE
    stu_name = '김성호';

SELECT
    stu_name,
    SUM(stu_total)
FROM
    stu_view
WHERE
    stu_name = '김성호'
GROUP BY
    stu_name;

SELECT
    stu_name,
    SUM(stu_total)
FROM
    stu_view
WHERE
    stu_name IN (
        '김성호','박영선'
    )
GROUP BY
    stu_name
ORDER BY stu_name;

SELECT
    stu_name,
    SUM(stu_total)
FROM
    stu_view
GROUP BY
    stu_name
ORDER BY stu_name;

SELECT
    stu_name,
    SUM(stu_total),
    AVG(stu_avg)
FROM
    stu_view
GROUP BY
    stu_name
ORDER BY AVG(stu_avg) DESC;

SELECT
    stu_id,
    stu_name,
    SUM(stu_total),
    AVG(stu_avg)
FROM
    stu_view
GROUP BY
    stu_id,
    stu_name
ORDER BY stu_name;

SELECT
    stu_name,
    stu_grade,
    stu_semester,
    stu_avg
FROM
    stu_view
ORDER BY stu_name;

SELECT
    stu_name,
    stu_grade,
    AVG(stu_avg)
FROM
    stu_view
GROUP BY
    stu_name,
    stu_grade
ORDER BY stu_name;

SELECT
    stu_grade || '학년' AS stu_grade,
    AVG(stu_kor),
    AVG(stu_eng),
    AVG(stu_math)
FROM
    students
GROUP BY
    stu_grade;

SELECT
    stu_name,
    stu_grade,
    AVG(stu_avg)
FROM
    stu_view
GROUP BY
    ROLLUP(stu_name,stu_grade) -- 그룹화된 데이터의 통계 (SUM이면 SUM,AVG 면 AVG) 순서가 중요함
ORDER BY stu_name;

SELECT
    stu_name,
    stu_grade,
    AVG(stu_avg)
FROM
    stu_view
GROUP BY
    CUBE(stu_name,stu_grade); -- 그룹화 된 데이터의 모든 통계

SELECT
    COUNT(stu_name)
FROM
    students;

SELECT
    COUNT(*)
FROM
    bank;

SELECT
    MAX(bank_money)
FROM
    bank;

SELECT
    stu_name,
    MAX(stu_kor),
    MIN(stu_kor)
FROM
    students
GROUP BY
    stu_name
ORDER BY stu_name;

SELECT
    stu_name,
    round(AVG(stu_kor),1) AS avg_kor,
    round(AVG(stu_eng),1) AS avg_eng,
    round(AVG(stu_math),1) AS avg_math,
    round(
        (round(AVG(stu_kor),1) + round(AVG(stu_eng),1) + round(AVG(stu_math),1) ) / 3,
        1
    ) AS avg_total
FROM
    students
GROUP BY
    stu_name;