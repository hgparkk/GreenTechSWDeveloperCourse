-- 테이블 스페이스 생성
CREATE TABLESPACE myts
DATAFILE 'C:\ORACLEXE\APP\ORACLE\ORADATA\XE\MYTS.DBF'
SIZE 100M AUTOEXTEND ON NEXT 5M;

-- 현재 Oracle DB 데이터가 담기는 위치 조회
SELECT file_name
FROM dba_data_files;

-- 사용자 계정 생성
CREATE USER sqld IDENTIFIED BY sqld -- 유저 아이디 sqld 비밀번호 sqld
DEFAULT TABLESPACE myts -- 기본적으로 저장될 테이블 스페이스
TEMPORARY TABLESPACE temp; -- 임시적으로 저장될 테이블 스페이스

-- 권한 부여
GRANT CONNECT, RESOURCE TO sqld;

GRANT CREATE VIEW TO sqld;