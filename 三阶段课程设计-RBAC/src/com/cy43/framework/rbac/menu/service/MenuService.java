package com.cy43.framework.rbac.menu.service;

import java.util.List;
import com.cy43.framework.rbac.menu.model.Menu;
import com.cy43.framework.rbac.menu.model.MenuDTO;

public interface MenuService {
	List<Menu> getChildMenusByRoleId(Integer role_id);
	List<Menu> getParentMenusByRoleId(Integer role_id);
	List<Menu> getChildMenuAndFunctions();
	List<MenuDTO> getTreeNode();
	List<Menu> getParentNodeList();
	void add(Menu menu);

	Menu load(Integer menu_id);

	void update(Menu menu);

	void delete(String type,int menu_id);
}
