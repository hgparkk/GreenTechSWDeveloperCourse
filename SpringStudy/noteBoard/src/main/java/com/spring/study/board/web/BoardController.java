package com.spring.study.board.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
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

	@RequestMapping(value = "/insertBoardView", method = RequestMethod.GET)
	public String boardWriteView(HttpSession session) {

		if (session.getAttribute("login") == null) {
			return "redirect:/loginView";
		}

		return "board/insertBoardView";
	}

	@RequestMapping(value = "/insertBoardDo", method = RequestMethod.POST)
	public String boardWriteDo(BoardDTO board, HttpSession session, HttpServletRequest request) {

		MemberDTO login = (MemberDTO) session.getAttribute("login");

		String memId = login.getcMemId();
		board.setcMemId(memId);

		boardService.insertBoard(board);

		request.setAttribute("msg", "새 글이 작성되었습니다.");
		request.setAttribute("url", "/boardListView");

		return "alert";
	}

	@RequestMapping(value = "/boardListView", method = RequestMethod.GET)
	public String boardListView(Model model) {

		List<BoardDTO> boardList = boardService.selectBoardList();

		model.addAttribute("keyBoardList", boardList);

		return "board/boardListView";
	}

	@RequestMapping(value = "/boardView", method = RequestMethod.GET)
	public String boardView(int no, Model model) {

		BoardDTO board;
		try {
			board = boardService.selectBoard(no);
		} catch (BizNotFoundException e) {
			model.addAttribute("errMsg", e.getMessage());
			return "errPage";
		}

		model.addAttribute("keyBoard", board);

		return "board/boardView";
	}

	@RequestMapping(value = "/updateBoardView", method = RequestMethod.POST)
	public String updateBoardView(int no, Model model) {

		BoardDTO board;
		try {
			board = boardService.selectBoard(no);
		} catch (BizNotFoundException e) {
			model.addAttribute("errMsg", e.getMessage());
			return "errPage";
		}

		model.addAttribute("keyBoard", board);

		return "board/updateBoardView";
	}

	@RequestMapping(value = "/updateBoardDo", method = RequestMethod.POST)
	public String updateBaordDo(BoardDTO board) {
		boardService.updateBoard(board);
		return "redirect:/boardView?no=" + board.getcBoardNo();
	}

	@RequestMapping(value = "/deleteBoardDo", method = RequestMethod.POST)
	public String deleteBoardDo(int no) {
		boardService.deleteBoard(no);
		return "redirect:/boardListView";
	}
}
