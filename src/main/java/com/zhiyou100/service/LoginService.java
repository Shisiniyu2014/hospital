package com.zhiyou100.service;

import java.util.Map;

import com.zhiyou100.model.User;

public interface LoginService {

	User loginByUser(Map<String, String> map);

}
