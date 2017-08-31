package com.cy43.framework.rbac.role.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy43.framework.commons.exception.ServiceException;
import com.cy43.framework.rbac.role.dao.RoleDao;
import com.cy43.framework.rbac.role.model.Role;
import com.cy43.framework.rbac.role.model.RolePermission;
import com.cy43.framework.rbac.role.service.RoleService;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public List<Role> list() {
		return this.roleDao.list();
	}
	@Override
	public void validRoleKey( String role_key ) {
		int count = this.roleDao.getCountByRoleKey(role_key.trim());
		if(count>0){
			throw new ServiceException("您设置的角色标识已经被使用,请重新设置");
		}

	}
	@Override
	public void add( Role role ) {
		try {
			this.roleDao.add(role);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException("新建角色失败!");
		}

	}
	@Override
	public Role load( int role_id ) {
		return this.roleDao.load(role_id);
	}
	@Override
	public void update( Role role ) {
		try {
			this.roleDao.update(role);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException("维护角色失败!");
		}

	}
	@Override
	public void removeRole( int role_id ) {
		try {
			this.roleDao.settingRoleIsNull(role_id);
			this.roleDao.deleteMenusByRoleId(role_id);
			this.roleDao.deleteRole(role_id);

		} catch (Exception  ex) {
			ex.printStackTrace();
			throw new ServiceException("注销角色失败!");
		}

	}
	@Override
	public List<Map<String, Object>> getRoleMenusFunctions( int role_id ) {
		return this.roleDao.getRoleMenusFunctions(role_id);
	}
	@Override
	public void addRolePermission( List<RolePermission> rolePermissions ) {
		try {
			if(rolePermissions!=null&&rolePermissions.size()>0){
				RolePermission rp = rolePermissions.get(0);
				int role_id = rp.getRole_id();
				//清除关系
				this.roleDao.deleteMenusByRoleId(role_id);
			}
			this.roleDao.addRolePermission(rolePermissions);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException("授权失败!");
		}


	}
	@Override
	public void deleteMenusByRoleId( int role_id ) {
		try {
			this.roleDao.deleteMenusByRoleId(role_id);
		} catch (Exception  ex) {
			ex.printStackTrace();
			throw new ServiceException("授权失败!");
		}

	}
	@Override
	public String getMenuFunctions( Integer role_id , Integer menu_id ) {
		return this.roleDao.getMenuFunctions(role_id, menu_id);
	}
	@Override
	public List<Role> getEnabledRoleList() {
		return this.roleDao.getEnabledRoleList();
	}

}
