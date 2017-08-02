package com.cy43.framework.rbac.menu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy43.framework.rbac.menu.dao.MenuDao;
import com.cy43.framework.rbac.menu.model.Menu;
import com.cy43.framework.rbac.menu.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuDao menuDao;

	@Override
	public List<Menu> getChildMenusByRoleId( Integer role_id ) {
		return this.menuDao.getChildMenusByRoleId(role_id);
	}

	@Override
	public List<Menu> getParentMenusByRoleId( Integer role_id ) {
		return this.menuDao.getParentMenusByRoleId(role_id);
	}

}
