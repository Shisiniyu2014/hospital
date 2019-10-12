package com.zhiyou100.service;

import org.springframework.stereotype.Service;

@Service
public class AjaxServiceImpl implements AjaxService {
	
	
	
	
	
	@Override
	public String checkUser(String usernameJsonkey) {
		// 只要用户名不是admin,就可以
		String code = null;
		if(usernameJsonkey == null || usernameJsonkey == "" || usernameJsonkey.equals("admin")){
			// 已注册,返回404
			code = "{\"code\":\"404\"}";
		}else{
			// 可以注册.返回200
			code = "{\"code\":\"200\"}";
			
		}
		System.out.println("业务层返回结果 : "+code);
		return code;
	}

}
