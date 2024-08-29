package com.spring.study.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.study.board.dto.BoardDTO;

@Mapper
public interface IBoardDAO {
	List<BoardDTO> getBoardList();
	int writeBoard(BoardDTO board);
}
