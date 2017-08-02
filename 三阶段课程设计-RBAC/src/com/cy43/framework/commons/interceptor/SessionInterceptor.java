package com.cy43.framework.commons.interceptor;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SessionInterceptor extends HandlerInterceptorAdapter {
	private final static String SESSION_KEY = "session_user";
	@Override
	public boolean preHandle( HttpServletRequest request , HttpServletResponse response , Object handler )
			throws Exception {
		HttpSession session = request.getSession();
		if(session.getAttribute(SESSION_KEY)==null){//没有登录
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<script>alert('您没有登录');window.top.location.href='"+request.getContextPath()+"/sys/login';</script>");
			out.flush();
			out.close();
			return false;
		}
		return true;
	}



}
