package com.spring.study.member.dao;

import org.apache.ibatis.annotations.Mapper;

// DAO (Data Access Object) ������ ���� ��ü -> DB�� ������ �����ϴ� �Ͱ� ������ �ִ� ��ü
// mapper�� member.xml ���ϰ� �����Ų��
@Mapper
public interface IMemberDAO {
	//�߻� �޼ҵ常 ����
	void showMember();
}
