package com.sxt.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.sxt.pojo.User;

public interface UserService {

	//登录
	public Map<String,Object> login(User user,HttpServletRequest request);
}
