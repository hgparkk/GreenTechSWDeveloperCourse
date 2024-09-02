package com.spring.study.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.member.dao.IMemberDAO;
import com.spring.study.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	IMemberDAO dao;

	public int insertMember(MemberDTO member) {
		return dao.insertMember(member);
	}
	
	public MemberDTO loginMember(MemberDTO member) {
		return dao.loginMember(member);
	}
}