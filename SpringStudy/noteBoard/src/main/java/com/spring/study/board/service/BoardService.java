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

	public BoardDTO selectBoard(int boardNo) throws BizNotFoundException {

		BoardDTO result = dao.selectBoard(boardNo);

		if (result == null) {
			throw new BizNotFoundException("해당 게시글의 번호가 존재하지 않습니다", "API_001");
		}

		return result;
	}

	public List<BoardDTO> selectBoardList() {
		return dao.selectBoardList();
	}

	public int updateBoard(BoardDTO board) {
		return dao.updateBoard(board);
	}
	
	public int boardMemberInvalid(String memId) {
		return dao.boardMemberInvalid(memId);
	}
	
	public int deleteBoard(int boardNo) {
		return dao.deleteBoard(boardNo);
	}

}
