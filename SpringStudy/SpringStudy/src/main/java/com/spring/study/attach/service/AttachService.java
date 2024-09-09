package com.spring.study.attach.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.attach.dao.IAttachDAO;
import com.spring.study.attach.dto.AttachDTO;

@Service
public class AttachService {

	@Autowired
	IAttachDAO dao;
	
	public int insertAttach(AttachDTO attach) {
		return dao.insertAttach(attach);
	}
	
	public List<AttachDTO> getAttachList(int boardNo){
		return dao.getAttachList(boardNo);
	}
}