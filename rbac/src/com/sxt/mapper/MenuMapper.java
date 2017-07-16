package com.sxt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sxt.pojo.Menu;

public interface MenuMapper {

	
	//根据用户编号，查询菜单列表
	
	List<Menu> findByUidAndPid(@Param("userId") Integer userId ,@Param("pmenuId") Integer pmenuId);
	
}
