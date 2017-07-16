package com.sxt.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.pojo.User;
import com.sxt.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	

	/**
	 * 用户登录
	 */
	@RequestMapping("/signIn")
	@ResponseBody
	public Map<String,Object> signIn(User user,HttpServletRequest request){
		return userService.login(user,request);
	}
	
	
}
