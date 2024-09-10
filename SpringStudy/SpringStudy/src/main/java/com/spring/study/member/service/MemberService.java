package com.spring.study.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.member.dao.IMemberDAO;
import com.spring.study.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	IMemberDAO dao; // �޸� �ּҿ��� ������ IMemberDAO�� ��ü�� �����´� �� �۾��� DI, ������ �����̴�.
	
	public int insertMember(MemberDTO member) {
		return dao.insertMember(member);
	}
	
	public MemberDTO loginMember(MemberDTO member) {
		return dao.loginMember(member);
	}
	
	public MemberDTO getMember(String memId) {
		return dao.getMember(memId);
	}
	
	public int updateMember(MemberDTO member) {
		return dao.updateMember(member);
	}
	
	public int updateProfile(MemberDTO member) {
		return dao.updateProfile(member);
	}
	
	public int deleteMember(String memId) {
		return dao.deleteMember(memId);
	}
}