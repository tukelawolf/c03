package com.sxt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sxt.mapper.MenuMapper;
import com.sxt.pojo.Menu;
import com.sxt.pojo.MenuResult;
import com.sxt.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService{

	@Autowired
	MenuMapper menuMapper;
	
	
	@Override
	public List<MenuResult> findByUidAndPid(Integer userId) {
		List<MenuResult> resultList = new ArrayList<>();
		//查询一级菜单
		List<Menu> topMenuList = menuMapper.findByUidAndPid(userId, null);
		//根据一级菜单查询在菜单
		if(topMenuList!=null && topMenuList.size()>0){
			for(Menu top:topMenuList){
				MenuResult result = new MenuResult();
				
				BeanUtils.copyProperties(top, result);
				
				List<Menu> children = menuMapper.findByUidAndPid(userId, top.getMenuId());
				result.setChildren(children);
				resultList.add(result);
			}
		}
		return resultList;
	}

}
