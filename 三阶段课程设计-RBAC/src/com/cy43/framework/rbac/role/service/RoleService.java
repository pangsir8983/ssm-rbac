package com.cy43.framework.rbac.role.service;

import java.util.List;
import java.util.Map;
import com.cy43.framework.rbac.role.model.Role;
import com.cy43.framework.rbac.role.model.RolePermission;

public interface RoleService {
	List<Role> list();
	void validRoleKey(String role_key);
	void add(Role role);
	void update(Role role);
	Role load(int role_id);
	void removeRole(int role_id);
	List<Map<String,Object>> getRoleMenusFunctions(int role_id);

	void addRolePermission(List<RolePermission> rolePermissions);
	void deleteMenusByRoleId(int role_id);
	String getMenuFunctions(Integer role_id,Integer menu_id);
	List<Role> getEnabledRoleList();
}
