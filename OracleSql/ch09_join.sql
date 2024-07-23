SELECT
    *
FROM
    members;

SELECT
    stu_name
FROM
    stu_info;

SELECT
    bank_name
FROM
    bank;

-- 합집합

SELECT
    stu_name
FROM
    stu_info
UNION
SELECT
    bank_name
FROM
    bank;

-- 교집합

SELECT
    stu_name
FROM
    stu_info
INTERSECT SELECT
    bank_name
FROM
    bank;

SELECT
    mem_name
FROM
    members
INTERSECT SELECT
    bank_name
FROM
    bank;
    
-- 차집합

SELECT
    stu_name
FROM
    students
MINUS
SELECT
    bank_name
FROM
    bank;

TRUNCATE TABLE stu_info; -- DELETE stu_info 와 같지만 DDL 문이라 따로 커밋할 필요가 없다.

SELECT DISTINCT
    stu_id,
    stu_name,
    stu_birth
FROM
    students
WHERE
    ROWNUM <= 4;

-- SELECT 문의 결과로 INSERT 하기

INSERT INTO stu_info ( SELECT DISTINCT
    stu_id,
    stu_name,
    stu_birth
FROM
    students
WHERE
    ROWNUM <= 4
);

TRUNCATE TABLE stu_score;

INSERT INTO stu_score ( SELECT DISTINCT
    stu_id,
    stu_grade,
    stu_kor,
    stu_eng,
    stu_math,
    stu_semester
FROM
    students
WHERE
        stu_id IN (
            SELECT
                stu_id
            FROM
                stu_info
        )
    AND
        stu_grade = 1
);

-- 교차 조인 (결합 할 수 있는 모든 경우의 수 조인)

SELECT
    *
FROM
    stu_info,
    stu_score;

SELECT
    a.stu_id,
    a.stu_name,
    b.stu_semester,
    b.stu_kor,
    b.stu_eng,
    b.stu_math
FROM
    stu_info a,
    stu_score b;

-- 내부 조인

SELECT
    a.stu_id,
    a.stu_name,
    b.stu_grade,
    b.stu_semester,
    b.stu_kor,
    b.stu_eng,
    b.stu_math
FROM
    stu_info a,
    stu_score b
WHERE
    a.stu_id = b.stu_id;

SELECT
    a.stu_id,
    a.stu_name,
    b.stu_grade,
    b.stu_semester,
    b.stu_kor,
    b.stu_eng,
    b.stu_math
FROM
    stu_info a
    INNER JOIN stu_score b ON a.stu_id = b.stu_id;
    
-- 자연 조인

SELECT
    stu_id,
    stu_name,
    stu_grade,
    stu_semester,
    stu_kor,
    stu_eng,
    stu_math
FROM
    stu_info
    NATURAL JOIN stu_score; -- 자동으로 이름이 같은 컬럼을 찾아 내부 조인을 한다.

SELECT
    a.tips_no,
    a.tips_title,
    a.tips_author,
    b.mem_name
FROM tips a, members b
WHERE a.tips_author = b.mem_id; -- 조인은 잘 되지만 컬럼의 이름이 다르기 때문에 자연 조인은 되지 않을 것이다.

ALTER TABLE members ADD CONSTRAINT pk_mem PRIMARY KEY (mem_id);
ALTER TABLE tips ADD CONSTRAINT fk_tips FOREIGN KEY (tips_author) REFERENCES members (mem_id);

