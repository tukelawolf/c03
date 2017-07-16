package com.sxt.pojo;

import java.util.List;

public class MenuResult {
	//菜单主键
	private Integer menuId;
	//菜单名称
	private String menuname;
	//url
	private String menuurl;
	//子菜单
	private List<Menu> children;
	public Integer getMenuId() {
		return menuId;
	}
	public void setMenuId(Integer menuId) {
		this.menuId = menuId;
	}
	public String getMenuname() {
		return menuname;
	}
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public String getMenuurl() {
		return menuurl;
	}
	public void setMenuurl(String menuurl) {
		this.menuurl = menuurl;
	}
	public List<Menu> getChildren() {
		return children;
	}
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MenuResult [menuId=");
		builder.append(menuId);
		builder.append(", menuname=");
		builder.append(menuname);
		builder.append(", menuurl=");
		builder.append(menuurl);
		builder.append(", children=");
		builder.append(children);
		builder.append("]");
		return builder.toString();
	}
	
}
