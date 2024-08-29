package com.spring.study.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.board.dao.IBoardDAO;
import com.spring.study.board.dto.BoardDTO;

@Service
public class BoardService {

	@Autowired
	IBoardDAO dao;

	public List<BoardDTO> getBoardList() {
		List<BoardDTO> result = dao.getBoardList();
		return result;
	}
	
	public int writeBoard(BoardDTO board) {
		int result = dao.writeBoard(board);
		return result;
	}
}
