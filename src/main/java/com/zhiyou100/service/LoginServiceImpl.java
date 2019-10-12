package com.zhiyou100.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.mapper.LoginMapper;
import com.zhiyou100.model.User;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginMapper mapper;
	
	@Override
	public User loginByUser(Map<String, String> map) {
		
		
		return mapper.loginByUser(map);
	}

}
