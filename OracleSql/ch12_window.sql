SELECT
    *
FROM
    bjs;

SELECT
    bj_job,
    AVG(bj_income) AS avg_income
FROM
    bjs
GROUP BY
    bj_job
ORDER BY avg_income DESC;

SELECT
    bj_id,
    bj_name,
    bj_job,
    bj_income,
    AVG(
        bj_income
    ) OVER(PARTITION BY
        bj_job
    )
FROM
    bjs;

SELECT
    bj_id,
    bj_name,
    bj_job,
    bj_income,
    SUM(
        bj_income
    ) OVER(PARTITION BY
        bj_job
    )
FROM
    bjs;

SELECT
    bj_id,
    bj_name,
    bj_job,
    bj_income,
    SUM(
        bj_income
    ) OVER(PARTITION BY
        bj_job
        ORDER BY
            bj_income
    )
FROM
    bjs;

SELECT
    bj_id,
    bj_name,
    bj_job,
    bj_income,
    RANK() OVER(
        ORDER BY bj_income DESC
    )
FROM
    bjs;

SELECT
    bj_id,
    bj_name,
    bj_job,
    bj_income,
    RANK() OVER(PARTITION BY
        bj_job
        ORDER BY
            bj_income
        DESC
    )
FROM
    bjs;

SELECT
    bj_id,
    bj_name,
    bj_job,
    bj_income,
    DENSE_RANK() OVER(PARTITION BY
        bj_job
        ORDER BY
            bj_income
        DESC
    )
FROM
    bjs;

SELECT
    bj_id,
    bj_name,
    bj_job,
    bj_income,
    ROW_NUMBER() OVER(PARTITION BY
        bj_job
        ORDER BY
            bj_income
        DESC
    )
FROM
    bjs;

SELECT
    bj_id,
    bj_name,
    bj_job,
    bj_income,
    NTILE(
        10
    ) OVER(
        ORDER BY
            bj_income
        DESC
    )
FROM
    bjs;