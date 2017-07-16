package com.sxt.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sxt.pojo.MenuResult;
import com.sxt.pojo.User;
import com.sxt.service.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	
	@Autowired
	MenuService menuService;
	
	
	@RequestMapping("/findMenu")
	@ResponseBody
	public List<MenuResult> findMenu(HttpSession session){
		
		User user = (User)session.getAttribute("currentUser");
		
		return menuService.findByUidAndPid(user.getUserId());
	}
	
}
