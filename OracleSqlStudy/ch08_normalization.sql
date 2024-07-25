CREATE TABLE stu_info
    AS
        SELECT DISTINCT
            stu_id,
            stu_name,
            stu_birth
        FROM
            students
        ORDER BY stu_name;

CREATE TABLE stu_score
    AS
        SELECT
            stu_id,
            stu_grade,
            stu_semester stu_kor,
            stu_eng,
            stu_math
        FROM
            students;

SELECT
    *
FROM
    classes;

CREATE TABLE class_teacher
    AS
        SELECT DISTINCT
            class_teacher_id AS teacher_id,
            class_teacher_name AS teacher_name
        FROM
            classes;

CREATE TABLE class_info
    AS
        SELECT DISTINCT
            class_no,
            class_title,
            class_teacher_id,
            class_week
        FROM
            classes
        ORDER BY class_no;

CREATE TABLE class_stu
    AS
        SELECT DISTINCT
            class_stu_id AS stu_id,
            class_stu_name AS stu_name
        FROM
            classes;

CREATE TABLE class_takes
    AS
        SELECT
            class_no,
            class_stu_id AS stu_id
        FROM
            classes;

CREATE TABLE class_week
    AS
        SELECT
            class_no,
            substr(class_week,1,1) AS class_day
        FROM
            classes;

CREATE TABLE class_week (
    class_no    NUMBER(3,0),
    class_day   VARCHAR2(10)
);

INSERT INTO class_week VALUES ( 1,'월' );

INSERT INTO class_week VALUES ( 2,'화' );

INSERT INTO class_week VALUES ( 3,'월' );

INSERT INTO class_week VALUES ( 4,'화' );

INSERT INTO class_week VALUES ( 5,'목' );

INSERT INTO class_week VALUES ( 6,'토' );

INSERT INTO class_week VALUES ( 7,'월' );

INSERT INTO class_week VALUES ( 8,'수' );

INSERT INTO class_week VALUES ( 1,'수' );

INSERT INTO class_week VALUES ( 2,'목' );

INSERT INTO class_week VALUES ( 3,'수' );

INSERT INTO class_week VALUES ( 4,'목' );

INSERT INTO class_week VALUES ( 5,'금' );

INSERT INTO class_week VALUES ( 7,'화' );

INSERT INTO class_week VALUES ( 8,'목' );

SELECT * FROM CLASS_INFO;
SELECT * FROM CLASS_STU;
SELECT * FROM CLASS_TAKES;
SELECT * FROM CLASS_TEACHER;
SELECT * FROM CLASS_WEEK;