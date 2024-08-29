package com.spring.study.member.dao;

import org.apache.ibatis.annotations.Mapper;

import com.spring.study.member.dto.MemberDTO;

// DAO (Data Access Object) ������ ���� ��ü -> DB�� ������ �����ϴ� �Ͱ� ������ �ִ� ��ü
// mapper�� member.xml ���ϰ� �����Ų��
@Mapper
public interface IMemberDAO {
	// �߻� �޼ҵ常 ����
	MemberDTO loginMember(MemberDTO member);

	// insert, update, delete�� ��� return Ÿ���� int �̴�
	int insertMember(MemberDTO member);
}
