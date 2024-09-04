package com.spring.study.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.spring.study.board.dto.BoardDTO;
import com.spring.study.common.vo.SearchVO;

@Mapper
public interface IBoardDAO {
	int insertBoard(BoardDTO board);
	int getTotalCount(SearchVO search);
	List<BoardDTO> getBoardList(SearchVO search);
	BoardDTO getBoard(int boardNo);
	int updateBoard(BoardDTO board);
	int deleteBoard(int boardNo);
	int noMemberIdBoard(String memId);
}
