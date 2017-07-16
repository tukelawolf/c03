package com.sxt.pojo;

public class Menu {
	//菜单主键
	private Integer menuId;
	//菜单名称
	private String menuname;
	//url
	private String menuurl;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Menu [menuId=");
		builder.append(menuId);
		builder.append(", menuname=");
		builder.append(menuname);
		builder.append(", menuurl=");
		builder.append(menuurl);
		builder.append("]");
		return builder.toString();
	}
	
	
}
