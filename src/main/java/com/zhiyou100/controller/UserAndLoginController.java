package com.zhiyou100.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.model.User;
import com.zhiyou100.service.LoginService;

@Controller
@RequestMapping("/user")
public class UserAndLoginController {
	
	@Autowired
	private LoginService service;
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		
		session.invalidate();
		return "redirect:/login.jsp";
		
	}
	
	
	
	
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String loginByUser(String username,String password,HttpSession session,Model model){
		Map<String,String> map = new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		User user = service.loginByUser(map);
		
		if(user != null ){
			
			session.setAttribute("user", user);
			model.addAttribute("user", user);
			return "index";
		}
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("/list")
	public String list(@RequestParam Map<String,String> map,Model model){
		
		
		return null;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
