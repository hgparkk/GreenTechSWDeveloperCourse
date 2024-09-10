package com.spring.study.board.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.spring.study.attach.dto.AttachDTO;
import com.spring.study.attach.service.AttachService;
import com.spring.study.board.dto.BoardDTO;
import com.spring.study.board.service.BoardService;
import com.spring.study.common.exception.BizNotFoundException;
import com.spring.study.common.util.FileUploadUtils;
import com.spring.study.common.vo.SearchVO;
import com.spring.study.member.dto.MemberDTO;
import com.spring.study.reply.dto.ReplyDTO;
import com.spring.study.reply.service.ReplyService;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;

	@Autowired
	ReplyService replyService;

	@Autowired
	FileUploadUtils fileUploadUtils;

	@Autowired
	AttachService attachService;

	@RequestMapping("/boardWriteView")
	public String boardWriteView(HttpSession session) {

		if (session.getAttribute("login") == null) {
			return "redirect:/loginView";
		}

		return "board/boardWriteView";
	}

	@RequestMapping(value = "/boardWriteDo", method = RequestMethod.POST)
	public String boardWriteDo(@Valid BoardDTO board, HttpSession session, MultipartFile[] boardFile,
			BindingResult result) {

		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			return "redirect:/boardWriteView";
		}

		if (boardFile != null) {
			for (int i = 0; i < boardFile.length; i++) {
				try {
					AttachDTO fileHistoy = fileUploadUtils.saveFile(boardFile[i]);
					attachService.insertAttach(fileHistoy);
				} catch (IOException e) {
					e.printStackTrace();
					return "errPage";
				}
			}
		}

		// session.getAttribute는 반환 타입이 object 이기 때문에 형변환이 필요하다.
		MemberDTO login = (MemberDTO) session.getAttribute("login");

		String memId = login.getMemId();
		board.setMemId(memId);

		boardService.insertBoard(board);

		return "redirect:/boardView";
	}

	@RequestMapping("/boardView")
	public String boardView(Model model, SearchVO search) {

		search.setTotalInfo(boardService.getTotalCount(search));
		List<BoardDTO> boardList = boardService.getBoardList(search);

		model.addAttribute("keyBoardList", boardList);
		model.addAttribute("keySearch", search);

		return "board/boardView";
	}

	@RequestMapping("/boardDetailView")
	public String boardDetailView(int no, Model model) {

		BoardDTO board;
		try {
			board = boardService.getBoard(no);
		} catch (BizNotFoundException e) {
			model.addAttribute("errMsg", e.getMessage());
			return "errPage";
		}

		List<ReplyDTO> replyList = replyService.getReplyList(no);

		List<AttachDTO> attachList = attachService.getAttachList(no);

		model.addAttribute("keyBoard", board);
		model.addAttribute("keyReplyList", replyList);
		model.addAttribute("keyAttachList", attachList);

		return "board/boardDetailView";
	}

	@RequestMapping(value = "/boardEditView", method = RequestMethod.POST)
	public String boardEditView(int no, Model model) {

		BoardDTO board;
		try {
			board = boardService.getBoard(no);
			model.addAttribute("keyBoard", board);
		} catch (BizNotFoundException e) {
			model.addAttribute("errMsg", e.getMessage());
			return "errPage";
		}

		return "board/boardEditView";
	}

	@RequestMapping(value = "/boardEditDo", method = RequestMethod.POST)
	public String boardEditDo(BoardDTO board, Model model) {

		boardService.updateBoard(board);
		model.addAttribute("no", board.getBoardNo());

		return "redirect:/boardDetailView";
	}

	@RequestMapping(value = "/boardDeleteDo", method = RequestMethod.POST)
	public String boardDeleteDo(int no) {

		boardService.deleteBoard(no);

		return "redirect:/boardView";
	}
}
