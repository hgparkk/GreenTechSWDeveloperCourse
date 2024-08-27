package com.spring.study.member.dao;

import org.apache.ibatis.annotations.Mapper;

// DAO (Data Access Object) 데이터 접근 객체 -> DB에 쿼리문 전송하는 것과 연관이 있는 객체
// mapper인 member.xml 파일과 연결시킨다
@Mapper
public interface IMemberDAO {
	//추상 메소드만 선언
	void showMember();
}
