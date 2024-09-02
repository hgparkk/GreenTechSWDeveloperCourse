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

import com.spring.study.member.dto.MemberDTO;
import com.spring.study.member.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	MemberService memberService;

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
			String fromUrl) {
		MemberDTO login = memberService.loginMember(member);
		session.setAttribute("login", login);

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
	}

	@RequestMapping(value = "/logoutDo", method = RequestMethod.GET)
	public String logoutDo(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		String fromUrl = request.getHeader("Referer");
		if (fromUrl.contains("/boardListView") || fromUrl.contains("/boardView")) {
			return "redirect:" + fromUrl;
		} else {
			return "redirect:/";
		}
	}
}
