package com.syj.spsound.interceptor;

import java.io.IOException;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class PermissionInterceptor implements HandlerInterceptor {
	
	public boolean preHandle(
			HttpServletRequest request
			, HttpServletResponse response
			, Object handler) throws IOException {
		
		HttpSession session = request.getSession();
		Integer userId = (Integer)session.getAttribute("userId");
		
		String uri = request.getRequestURI();

		if(userId == null) {
			
			if(uri.startsWith("/spsound")) {
				response.sendRedirect("/user/login-view");
				
				return false;
			}
		} else { 
			if(uri.startsWith("/user")) {
				response.sendRedirect("/spsound/main-view");
				
				return false;
			}
		}
		
		return true;
	}

}
