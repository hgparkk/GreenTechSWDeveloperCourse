package com.spring.study.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.study.board.dao.IBoardDAO;
import com.spring.study.board.dto.BoardDTO;
import com.spring.study.common.exception.BizNotFoundException;

@Service
public class BoardService {

	@Autowired
	IBoardDAO dao;

	public int insertBoard(BoardDTO board) {
		return dao.insertBoard(board);
	}

	public List<BoardDTO> getBoardList() {
		return dao.getBoardList();
	}

	public BoardDTO getBoard(int boardNo) throws BizNotFoundException {
		BoardDTO result = dao.getBoard(boardNo);
		if (result == null) {
			throw new BizNotFoundException("해당 게시글의 번호가 존재하지 않음.", "API_001");
		}
		return result;
	}

	public int updateBoard(BoardDTO board) {
		return dao.updateBoard(board);
	}

	public int deleteBoard(int no) {
		return dao.deleteBoard(no);
	}

	public int noMemberIdBoard(String memId) {
		return dao.noMemberIdBoard(memId);
	}
}
