package com.spring.study.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.spring.study.member.dto.MemberDTO;

@Mapper
public interface IMemberDAO {
	int insertMember(MemberDTO member);
	MemberDTO loginMember(MemberDTO member);
	MemberDTO selectMember(String memId);
	int updateMember(MemberDTO member);
	int deleteMember(String memId);
}