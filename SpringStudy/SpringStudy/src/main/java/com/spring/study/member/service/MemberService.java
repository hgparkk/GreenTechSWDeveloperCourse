package com.spring.study.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.member.dao.IMemberDAO;
import com.spring.study.member.dto.MemberDTO;

@Service
public class MemberService {

	@Autowired
	IMemberDAO dao; // 메모리 주소에서 생성된 IMemberDAO의 객체를 가져온다 위 작업이 DI, 의존성 주입이다.

	public MemberDTO loginMember(MemberDTO member) {
		return dao.loginMember(member);
	}
	
	public int insertMember(MemberDTO member) {
		return dao.insertMember(member);
	}
}