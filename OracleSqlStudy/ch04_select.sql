CREATE TABLE students(
    stu_id VARCHAR2(12),
    stu_grade NUMBER(1),
    stu_semester NUMBER(1),
    stu_name VARCHAR2(10),
    stu_birth VARCHAR2(10),
    stu_kor NUMBER(3),
    stu_eng NUMBER(3),
    stu_math NUMBER(3),
    CONSTRAINTS stu_pk PRIMARY KEY (stu_id,stu_grade,stu_semester)
);

SELECT * FROM students;

SELECT 
    stu_id,
    stu_grade,
    stu_semester,
    stu_name,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math
FROM students
WHERE stu_name = '박영선';

SELECT 
    stu_id,
    stu_grade,
    stu_semester,
    stu_name,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math
FROM students
WHERE stu_kor >= 90;

SELECT 
    stu_id,
    stu_grade,
    stu_semester,
    stu_name,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math
FROM students
WHERE stu_name LIKE '김%';

SELECT 
    stu_id,
    stu_grade,
    stu_semester,
    stu_name,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math
FROM students
WHERE stu_grade = 2 AND stu_semester = 1;

SELECT 
    stu_id,
    stu_grade,
    stu_semester,
    stu_name,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math
FROM students
WHERE stu_eng LIKE '8_';

SELECT 
    stu_id,
    stu_grade,
    stu_semester,
    stu_name,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math
FROM students
WHERE stu_eng BETWEEN 80 AND 89;

SELECT 
    stu_id,
    stu_grade,
    stu_semester,
    stu_name,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math,
    stu_kor + stu_eng + stu_math,
    (stu_kor + stu_eng + stu_math) /3
FROM students;

SELECT 
    stu_id,
    stu_grade||'학년',
    stu_semester||'학기',
    stu_name ,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math,
    stu_kor + stu_eng + stu_math AS stu_total,
    (stu_kor + stu_eng + stu_math) /3 AS stu_avg
FROM students;

SELECT 
    stu_id,
    stu_grade||'학년',
    stu_semester||'학기',
    stu_name ,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math,
    stu_kor + stu_eng + stu_math AS stu_total,
    (stu_kor + stu_eng + stu_math) /3 AS stu_avg
FROM students
ORDER BY 10 DESC;

SELECT 
    stu_id,
    stu_grade,
    stu_semester,
    stu_name ,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math
FROM students
ORDER BY (stu_kor+stu_eng+stu_math) DESC;

SELECT 
    stu_id,
    stu_grade||'학년' AS stu_grade,
    stu_semester||'학기' AS stu_semester,
    stu_name ,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math,
    stu_kor + stu_eng + stu_math AS stu_total,
    (stu_kor + stu_eng + stu_math) /3 AS stu_avg
FROM students
ORDER BY stu_avg DESC, stu_id ASC;

SELECT 
    stu_id,
    stu_grade||'학년' AS stu_grade,
    stu_semester||'학기' AS stu_semester,
    stu_name ,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math,
    stu_kor + stu_eng + stu_math AS stu_total,
    (stu_kor + stu_eng + stu_math) /3 AS stu_avg
FROM students
ORDER BY stu_avg DESC, stu_id ASC;

-- SELECT 문의 결과를 테이블로 생성
CREATE TABLE new_students AS
SELECT 
    stu_id,
    stu_grade||'학년' AS stu_grade,
    stu_semester||'학기' AS stu_semester,
    stu_name ,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math,
    stu_kor + stu_eng + stu_math AS stu_total,
    (stu_kor + stu_eng + stu_math) /3 AS stu_avg
FROM students
ORDER BY stu_avg DESC, stu_id ASC;

SELECT 
    ROWNUM||'등' AS stu_rank,
    stu_id,
    stu_grade,
    stu_semester,
    stu_name ,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math,
    stu_total,
    stu_avg
FROM new_students;

DROP TABLE new_students;

--SELECT 문의 결과로 VIEW 생성
CREATE VIEW stu_view AS
SELECT 
    stu_id,
    stu_grade,
    stu_semester,
    stu_name,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math,
    stu_kor + stu_eng + stu_math AS stu_total,
    (stu_kor + stu_eng + stu_math) /3 AS stu_avg
FROM students
ORDER BY stu_avg DESC, stu_id ASC;

INSERT INTO students (
    stu_id,
    stu_grade,
    stu_semester,
    stu_name,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math
)VALUES(
    '2024001001',
    1,
    1,
    '호빵맨',
    '020414',
    100,
    95,
    90
);

SELECT 
    ROWNUM||'등' AS stu_rank,
    stu_id,
    stu_grade,
    stu_semester,
    stu_name,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math,
    stu_total,
    stu_avg
FROM stu_view;

SELECT
    stu_id,
    stu_grade,
    stu_semester,
    stu_name,
    stu_birth,
    stu_kor,
    stu_eng,
    stu_math,
    stu_kor + stu_eng + stu_math AS stu_total
FROM students
WHERE stu_grade = 2 AND stu_semester = 1
ORDER BY stu_total DESC;