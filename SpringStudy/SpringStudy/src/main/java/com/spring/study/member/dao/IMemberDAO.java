package com.spring.study.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.spring.study.member.dto.MemberDTO;

// DAO (Data Access Object) ������ ���� ��ü -> DB�� ������ �����ϴ� �Ͱ� ������ �ִ� ��ü
// mapper�� member.xml ���ϰ� �����Ų��
@Mapper
public interface IMemberDAO {
	// �߻� �޼ҵ常 ����
	// insert, update, delete�� ��� return Ÿ���� int �̴�
	int insertMember(MemberDTO member);

	MemberDTO loginMember(MemberDTO member);

	MemberDTO getMember(String memId);

	int updateMember(MemberDTO member);

	int updateProfile(MemberDTO member);

	int deleteMember(String memId);
}
