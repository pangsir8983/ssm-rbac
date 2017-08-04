package com.cy43.framework.rbac.menu.dao;

import java.util.List;
import com.cy43.framework.rbac.menu.model.Menu;
import com.cy43.framework.rbac.menu.model.MenuDTO;

public interface MenuDao {
	int delete(Integer menu_id);

	int add(Menu menu);

	Menu load(Integer menu_id);

	int update(Menu menu);

	List<Menu> getChildMenusByRoleId(Integer role_id);
	List<Menu> getParentMenusByRoleId(Integer role_id);

	List<Menu> getChildMenuAndFunctions();

	List<MenuDTO> getTreeNode();

	List<Menu> getParentNodeList();

	int getChildNodeCount(int parent_id);
	void deleteRoleMenu(int menu_id);
	void deleteMenu(int menu_id);
}