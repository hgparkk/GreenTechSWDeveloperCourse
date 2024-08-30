package com.spring.study.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.study.board.dto.BoardDTO;

@Mapper
public interface IBoardDAO {
	int insertBoard(BoardDTO board);
	List<BoardDTO> getBoardList();
	BoardDTO getBoard(int boardNo);
	int updateBoard(BoardDTO board);
	int deleteBoard(int boardNo);
}
