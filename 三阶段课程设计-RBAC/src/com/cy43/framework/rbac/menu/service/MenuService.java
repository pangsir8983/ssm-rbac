package com.cy43.framework.rbac.menu.service;

import java.util.List;
import com.cy43.framework.rbac.menu.model.Menu;

public interface MenuService {
	List<Menu> getChildMenusByRoleId(Integer role_id);
	List<Menu> getParentMenusByRoleId(Integer role_id);
}
