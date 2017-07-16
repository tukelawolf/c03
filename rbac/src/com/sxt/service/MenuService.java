package com.sxt.service;

import java.util.List;

import com.sxt.pojo.MenuResult;

public interface MenuService {

	List<MenuResult> findByUidAndPid(Integer userId);
}
