/**
 * RoleDao.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-08-01 09:34:31
 **/
package com.cy43.framework.rbac.role.dao;

import java.util.List;
import java.util.Map;
import com.cy43.framework.rbac.role.model.Role;
import com.cy43.framework.rbac.role.model.RolePermission;

public interface RoleDao {
	/**
	 * sys_role
	 * 方法描述:
	 * @param
	 * @return
	 * @throws
	 * @author 胖先生
	 * @date 2017-08-01 09:34:31
	 *
	 **/
	int delete(Integer role_id);

	/**
	 * sys_role
	 * 方法描述:
	 * @param
	 * @return
	 * @throws
	 * @author 胖先生
	 * @date 2017-08-01 09:34:31
	 *
	 **/
	int add(Role role);

	/**
	 * sys_role
	 * 方法描述:
	 * @param
	 * @return
	 * @throws
	 * @author 胖先生
	 * @date 2017-08-01 09:34:31
	 *
	 **/
	Role load(Integer role_id);

	/**
	 * sys_role
	 * 方法描述:
	 * @param
	 * @return
	 * @throws
	 * @author 胖先生
	 * @date 2017-08-01 09:34:31
	 *
	 **/
	int update(Role role);


	List<Role> list();

	int getCountByRoleKey(String role_key);

	void settingRoleIsNull(int role_id);
	void deleteMenusByRoleId(int role_id);
	void deleteRole(int role_id);

	List<Map<String,Object>> getRoleMenusFunctions(int role_id);

	void addRolePermission(List<RolePermission> rolePermissions);


}