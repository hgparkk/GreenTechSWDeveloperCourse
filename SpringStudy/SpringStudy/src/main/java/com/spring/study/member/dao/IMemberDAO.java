package com.spring.study.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.spring.study.member.dto.MemberDTO;

// DAO (Data Access Object) 데이터 접근 객체 -> DB에 쿼리문 전송하는 것과 연관이 있는 객체
// mapper인 member.xml 파일과 연결시킨다
@Mapper
public interface IMemberDAO {
	// 추상 메소드만 선언
	// insert, update, delete의 경우 return 타입은 int 이다
	int insertMember(MemberDTO member);

	MemberDTO loginMember(MemberDTO member);

	MemberDTO getMember(String memId);

	int updateMember(MemberDTO member);

	int updateProfile(MemberDTO member);

	int deleteMember(String memId);
}
