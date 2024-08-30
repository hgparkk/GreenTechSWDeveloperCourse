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

import com.spring.study.member.dto.MemberDTO;
import com.spring.study.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

	@RequestMapping("/registView")
	public String registView() {
		return "member/registView";
	}

	@RequestMapping(value = "/registDo", method = RequestMethod.POST)
	public String registDo(HttpServletRequest request) {

		System.out.println(request.getParameter("id"));
		System.out.println(request.getParameter("pw"));
		System.out.println(request.getParameter("name"));
		System.out.println(request.getParameter("phone"));
		System.out.println(request.getParameter("email"));

		MemberDTO member = new MemberDTO();
		member.setMemId(request.getParameter("id"));
		member.setMemPassword(request.getParameter("pw"));
		member.setMemName(request.getParameter("name"));
		member.setMemPhone(request.getParameter("phone"));
		member.setMemEmail(request.getParameter("email"));

		memberService.insertMember(member);

		return "redirect:/loginView";
	}

	@RequestMapping("/loginView")
	public String loginView() {
		return "member/loginView";
	}

	@RequestMapping(value = "/loginDo", method = RequestMethod.POST)
	public String loginDo(MemberDTO member, boolean rememberId, Model model, HttpSession session,
			HttpServletResponse response, RedirectAttributes attr) {

		MemberDTO login = memberService.loginMember(member);

		if (login != null) {
			session.setAttribute("login", login);
			if (rememberId) {
				Cookie cookie = new Cookie("rememberId", member.getMemId());
				response.addCookie(cookie);
			} else {
				Cookie cookie = new Cookie("rememberId", "");
				// 쿠키의 유효시간 0, 전달시 바로 삭제됨
				cookie.setMaxAge(0);
				response.addCookie(cookie);
			}
			return "redirect:/";
		} else {
			attr.addFlashAttribute("failMsg", "아이디 혹은 비밀번호가 올바르지 않습니다.");
			return "redirect:/loginView";
		}
	}

	@RequestMapping(value = "/logoutDo")
	public String logoutDo(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
