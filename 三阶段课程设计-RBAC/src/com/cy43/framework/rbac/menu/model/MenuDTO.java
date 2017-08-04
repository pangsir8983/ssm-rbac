package com.cy43.framework.rbac.menu.model;

import java.util.List;

public class MenuDTO {
	private Integer menu_id;
	private String menu_name;

	private List<MenuDTO> childMenuList;

	public Integer getMenu_id() {
		return this.menu_id;
	}

	public void setMenu_id( Integer menu_id ) {
		this.menu_id = menu_id;
	}

	public String getMenu_name() {
		return this.menu_name;
	}

	public void setMenu_name( String menu_name ) {
		this.menu_name = menu_name;
	}

	public List<MenuDTO> getChildMenuList() {
		return this.childMenuList;
	}

	public void setChildMenuList( List<MenuDTO> childMenuList ) {
		this.childMenuList = childMenuList;
	}


}
