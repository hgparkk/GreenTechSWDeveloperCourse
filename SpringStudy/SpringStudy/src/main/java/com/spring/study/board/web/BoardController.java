package com.spring.study.board.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.study.board.dto.BoardDTO;
import com.spring.study.board.service.BoardService;
import com.spring.study.common.exception.BizNotFoundException;
import com.spring.study.member.dto.MemberDTO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	@RequestMapping("/boardWriteView")
	public String boardWriteView(HttpSession session) {

		if (session.getAttribute("login") == null) {
			return "redirect:/loginView";
		}

		return "board/boardWriteView";
	}

	@RequestMapping(value = "/boardWriteDo", method = RequestMethod.POST)
	public String boardWriteDo(BoardDTO board, HttpSession session) {

		System.out.println(board);

		// session.getAttribute는 반환 타입이 object 이기 때문에 형변환이 필요하다.
		MemberDTO login = (MemberDTO) session.getAttribute("login");

		String memId = login.getMemId();
		board.setMemId(memId);

		boardService.insertBoard(board);

		return "redirect:/boardView";
	}

	@RequestMapping("/boardView")
	public String boardView(Model model) {

		List<BoardDTO> boardList = boardService.getBoardList();

		model.addAttribute("keyBoardList", boardList);

		return "board/boardView";
	}

	@RequestMapping("boardDetailView")
	public String boardDetailView(int no, Model model) {

		BoardDTO board;
		try {
			board = boardService.getBoard(no);
		} catch (BizNotFoundException e) {
			model.addAttribute("errMsg", e.getMessage());
			return "errPage";
		}

		model.addAttribute("keyBoard", board);

		return "board/boardDetailView";
	}

	@RequestMapping(value = "/boardEditView", method = RequestMethod.POST)
	public String boardEditView(int boardNo, Model model) {

		BoardDTO board;
		try {
			board = boardService.getBoard(boardNo);
			model.addAttribute("keyBoard", board);
		} catch (BizNotFoundException e) {
			model.addAttribute("errMsg", e.getMessage());
			return "errPage";
		}

		return "board/boardEditView";
	}

	@RequestMapping(value = "/boardEditDo", method = RequestMethod.POST)
	public String boardEditDo(BoardDTO board, Model model) {

		boardService.editBoard(board);
		model.addAttribute("no", board.getBoardNo());

		return "redirect:/boardDetailView";
	}
}
