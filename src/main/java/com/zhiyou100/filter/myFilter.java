package com.zhiyou100.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhiyou100.model.User;

public class myFilter implements Filter{

	
	
	
	
	public myFilter() {
		System.out.println("拦截器创建");
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("MyFilter  初始化");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		

		User user = (User) req.getSession().getAttribute("user");
		System.out.println("测试"+req.getRequestURI());
		if(user != null || req.getRequestURI().contains("login") 
				||req.getRequestURI().contains("js") ||req.getRequestURI().contains("css") 
				||req.getRequestURI().contains("assets")) {
			chain.doFilter(req, resp);
		}else {
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}
		
	}

	@Override
	public void destroy() {
		System.out.println("MyFilter  销毁");
		
	}




}
