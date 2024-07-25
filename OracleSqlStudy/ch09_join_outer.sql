UPDATE stu_score
    SET
        stu_id = '2021001005'
WHERE
    stu_id = '2021001004';

SELECT
    a.stu_id,
    a.stu_name,
    b.stu_grade,
    b.stu_semester,
    b.stu_kor,
    b.stu_eng,
    b.stu_math
FROM
    stu_score b
    FULL JOIN stu_info a ON a.stu_id = b.stu_id;

TRUNCATE TABLE stu_info;

TRUNCATE TABLE stu_score;

INSERT INTO stu_info ( SELECT DISTINCT
    stu_id,
    stu_name,
    stu_birth
FROM
    students
);

INSERT INTO stu_score ( SELECT
    stu_id,
    stu_grade,
    stu_semester,
    stu_kor,
    stu_eng,
    stu_math
FROM
    students
);

SELECT
    *
FROM
    stu_info
ORDER BY stu_id;

SELECT
    *
FROM
    stu_award;

SELECT
    a.stu_id,
    a.stu_name,
    b.award_id
FROM
    stu_info a
    LEFT OUTER JOIN stu_award b ON a.stu_id = b.award_stu_id;

SELECT
    a.stu_id,
    a.stu_name,
    b.award_id,
    c.award_item
FROM
    stu_info a
    LEFT OUTER JOIN
        stu_award b
        JOIN award_info c ON b.award_id = c.award_id
    ON a.stu_id = b.award_stu_id;

SELECT
    a.stu_id,
    a.stu_name,
    c.award_name,
    c.award_item
FROM
    stu_info a
    JOIN
        stu_award b
        JOIN award_info c ON b.award_id = c.award_id
    ON a.stu_id = b.award_stu_id
ORDER BY stu_id;

