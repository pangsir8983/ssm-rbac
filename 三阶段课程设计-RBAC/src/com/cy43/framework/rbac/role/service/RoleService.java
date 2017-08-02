package com.cy43.framework.rbac.role.service;

import java.util.List;
import com.cy43.framework.rbac.role.model.Role;

public interface RoleService {
	List<Role> list();
	void validRoleKey(String role_key);
	void add(Role role);
	void update(Role role);
	Role load(int role_id);
}
