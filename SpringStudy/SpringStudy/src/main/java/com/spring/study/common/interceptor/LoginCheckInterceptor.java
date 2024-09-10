package com.spring.study.common.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.spring.study.member.dto.MemberDTO;

public class LoginCheckInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();

		MemberDTO login = (MemberDTO) session.getAttribute("login");

		if (login == null) {
			response.sendRedirect(request.getContextPath() + "/loginView");
			return false;
		}
		return true;
	}
}