package com.spring.study.reply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.reply.dao.IReplyDAO;
import com.spring.study.reply.dto.ReplyDTO;

@Service
public class ReplyService {
	
	@Autowired
	IReplyDAO dao;
	
	public int insertReply(ReplyDTO reply) {
		return dao.insertReply(reply);
	}
	
	public List<ReplyDTO> getReplyList(int boardNo){
		return dao.getReplyList(boardNo);
	}
	
	public ReplyDTO getReply(String replyNo) {
		return dao.getReply(replyNo);
	}
	
	public int deleteReply(String replyNo) {
		return dao.deleteReply(replyNo);
	}
}