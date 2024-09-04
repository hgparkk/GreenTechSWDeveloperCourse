package com.spring.study.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.study.board.dto.BoardDTO;

@Mapper
public interface IBoardDAO {
	int insertBoard(BoardDTO board);
	BoardDTO selectBoard(int boardNo);
	List<BoardDTO> selectBoardList();
	int updateBoard(BoardDTO board);
	int boardMemberInvalid(String memId);
	int deleteBoard(int boardNo);
}