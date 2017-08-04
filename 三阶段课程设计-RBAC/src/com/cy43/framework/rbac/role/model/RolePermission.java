package com.cy43.framework.rbac.role.model;

public class RolePermission {

	private Integer role_id;
	private Integer menu_id;
	private String permission;
	public Integer getRole_id() {
		return this.role_id;
	}
	public void setRole_id( Integer role_id ) {
		this.role_id = role_id;
	}
	public Integer getMenu_id() {
		return this.menu_id;
	}
	public void setMenu_id( Integer menu_id ) {
		this.menu_id = menu_id;
	}
	public String getPermission() {
		return this.permission;
	}
	public void setPermission( String permission ) {
		this.permission = permission;
	}
	@Override
	public String toString() {
		return "RolePermission [role_id=" + this.role_id + ", menu_id=" + this.menu_id + ", permission="
				+ this.permission + "]";
	}



}
