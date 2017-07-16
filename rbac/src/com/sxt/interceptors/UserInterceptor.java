package com.sxt.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sxt.pojo.User;

public class UserInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		User user = (User)request.getSession().getAttribute("currentUser");
		if(user==null){
			//重定向
			response.sendRedirect(request.getContextPath()+"/login");
			//返回false表示不会执行controller
			return false;
		}
		return true;	
	}

	
}
