package com.sxt.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sxt.mapper.UserMapper;
import com.sxt.pojo.User;
import com.sxt.service.UserService;
import com.sxt.utils.Md5Util;

@Service
public class UserServiceImpl implements UserService	{

	@Autowired
	UserMapper userMapper;
	
	@RequestMapping("/login")
	public Map<String,Object> login(User user,HttpServletRequest request){
		Map<String,Object> result = new HashMap<>();
		//md5加密
		String password = Md5Util.getMd5(user.getPassword());
		user.setPassword(password);
		User userDb = userMapper.login(user);
		if(userDb != null){
			result.put("code", "1000");
			result.put("msg", "登录成功");
			request.getSession().setAttribute("currentUser", userDb);
			return result;
		}
		request.getSession().removeAttribute("currentUser");
		result.put("code", "4000");
		result.put("msg", "用户名或者密码不正确");
		return result;
	}
}
