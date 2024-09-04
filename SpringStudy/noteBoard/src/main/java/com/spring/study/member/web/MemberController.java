package com.spring.study.member.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.study.board.service.BoardService;
import com.spring.study.member.dto.MemberDTO;
import com.spring.study.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	BoardService boardService;

	@RequestMapping(value = "/insertMemberView", method = RequestMethod.GET)
	public String insertMemberView() {
		return "member/insertMemberView";
	}

	@RequestMapping(value = "/insertMemberDo", method = RequestMethod.POST)
	public String insertMemberDo(MemberDTO member, HttpServletRequest request) {
		System.out.println(member);
		memberService.insertMember(member);
		request.setAttribute("msg", "회원가입이 완료되었습니다.");
		request.setAttribute("url", "/loginView");
		return "alert";
	}

	@RequestMapping(value = "/loginView", method = RequestMethod.GET)
	public String loginView(HttpServletRequest request, Model model) {

		String fromUrl = request.getHeader("Referer");
		model.addAttribute("fromUrl", fromUrl);

		return "member/loginView";
	}

	@RequestMapping(value = "/loginDo", method = RequestMethod.POST)
	public String loginDo(MemberDTO member, HttpSession session, boolean rememberId, HttpServletResponse response,
			String fromUrl, RedirectAttributes attr) {
		MemberDTO login = memberService.loginMember(member);
		session.setAttribute("login", login);

		if (login != null) {
			if (rememberId) {
				Cookie cookie = new Cookie("remeberId", member.getcMemId());
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("remeberId", "");
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}

			if (fromUrl.contains("/boardListView") || fromUrl.contains("/boardView")) {
				return "redirect:" + fromUrl;
			} else {
				return "redirect:/";
			}
		} else {
			attr.addFlashAttribute("failMsg", "아이디 혹은 비밀번호가 올바르지 않습니다.");
			return "redirect:/loginView";
		}
	}

	@RequestMapping(value = "/logoutDo", method = RequestMethod.GET)
	public String logoutDo(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		String fromUrl = request.getHeader("Referer");
		if (fromUrl.contains("boardListView") || fromUrl.contains("boardView")) {
			return "redirect:" + fromUrl;
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/updateMemberView", method = RequestMethod.GET)
	public String updateMemberView(HttpSession session) {

		if (session.getAttribute("login") == null) {
			return "redirect:/";
		}

		return "member/updateMemberView";
	}

	@RequestMapping(value = "/updateMemberDo", method = RequestMethod.POST)
	public String updateMemberDo(MemberDTO member, HttpSession session, HttpServletRequest request) {
		memberService.updateMember(member);
		session.setAttribute("login", memberService.selectMember(member.getcMemId()));
		request.setAttribute("msg", "회원정보가 수정되었습니다.");
		request.setAttribute("url", "/updateMemberView");
		return "alert";
	}

	@RequestMapping(value = "/deleteMemberDo", method = RequestMethod.POST)
	public String memberDeleteDo(String cMemId, HttpSession session, HttpServletRequest request) {
		boardService.boardMemberInvalid(cMemId);
		memberService.deleteMember(cMemId);
		session.invalidate();
		request.setAttribute("msg", "성공적으로 탈퇴되었습니다");
		request.setAttribute("url", "/");
		return "alert";
	}
}
