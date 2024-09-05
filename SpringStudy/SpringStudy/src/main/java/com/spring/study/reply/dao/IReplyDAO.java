package com.spring.study.reply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.study.reply.dto.ReplyDTO;

@Mapper
public interface IReplyDAO {
	int insertReply(ReplyDTO reply);
	List<ReplyDTO> getReplyList(int boardNo);
	ReplyDTO getReply(String replyNo);
	int deleteReply(String replyNo);
}