package com.spring.study.member.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@RequestMapping("/registView")
	public String registView() {
		return "member/registView";
	}

	@RequestMapping(value = "/registDo", method = RequestMethod.POST)
	public String registDo(HttpServletRequest request) {

		MemberDTO member = new MemberDTO();
		member.setMemId(request.getParameter("id"));
		String encodePw = passwordEncoder.encode(request.getParameter("pw"));
		member.setMemPassword(encodePw);
		member.setMemName(request.getParameter("name"));
		member.setMemPhone(request.getParameter("phone"));
		member.setMemEmail(request.getParameter("email"));

		memberService.insertMember(member);

		return "redirect:/loginView";
	}

	@RequestMapping("/loginView")
	public String loginView(HttpServletRequest request, Model model) {
		String fromURL = request.getHeader("Referer");
		model.addAttribute("fromURL", fromURL);

		return "member/loginView";
	}

	@RequestMapping(value = "/loginDo", method = RequestMethod.POST)
	public String loginDo(MemberDTO member, boolean rememberId, Model model, String fromURL, HttpSession session,
			HttpServletResponse response, RedirectAttributes attr) {

		MemberDTO login = memberService.loginMember(member);

		if (login != null) {
			if (!passwordEncoder.matches(member.getMemPassword(), login.getMemPassword())) {
				attr.addFlashAttribute("failMsg", "���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
				return "redirect:/loginView";
			}
			session.setAttribute("login", login);
			if (rememberId) {
				Cookie cookie = new Cookie("rememberId", member.getMemId());
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("rememberId", "");
				// ��Ű�� ��ȿ�ð� 0, ���޽� �ٷ� ������
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			return "redirect:" + fromURL;
		} else {
			attr.addFlashAttribute("failMsg", "���̵� Ȥ�� ��й�ȣ�� �ùٸ��� �ʽ��ϴ�.");
			return "redirect:/loginView";
		}
	}

	@RequestMapping(value = "/logoutDo")
	public String logoutDo(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		String fromURL = request.getHeader("Referer");
		return "redirect:" + fromURL;
	}

	@RequestMapping(value = "/memberEditView")
	public String memberEditView() {
		return "member/memberEditView";
	}

	@RequestMapping(value = "/memberEditDo", method = RequestMethod.POST)
	public String memberEditDo(MemberDTO member, HttpSession session) {
		memberService.updateMember(member);
		session.setAttribute("login", memberService.getMember(member.getMemId()));
		return "redirect:/memberEditView";
	}

	@RequestMapping(value = "/memberDeleteDo", method = RequestMethod.POST)
	public String memberDeleteDo(String memId, HttpSession session) {
		boardService.noMemberIdBoard(memId);
		memberService.deleteMember(memId);
		session.invalidate();
		return "redirect:/";
	}
}
