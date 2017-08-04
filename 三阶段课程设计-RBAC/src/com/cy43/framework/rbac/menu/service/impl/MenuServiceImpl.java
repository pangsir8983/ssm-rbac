package com.cy43.framework.rbac.menu.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy43.framework.commons.exception.ServiceException;
import com.cy43.framework.rbac.menu.dao.MenuDao;
import com.cy43.framework.rbac.menu.model.Menu;
import com.cy43.framework.rbac.menu.model.MenuDTO;
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

	@Override
	public List<Menu> getChildMenuAndFunctions() {
		return this.menuDao.getChildMenuAndFunctions();
	}

	@Override
	public List<MenuDTO> getTreeNode() {
		return this.menuDao.getTreeNode();
	}

	@Override
	public List<Menu> getParentNodeList() {
		return this.menuDao.getParentNodeList();
	}

	@Override
	public void add( Menu menu ) {
		try {
			this.menuDao.add(menu);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException("新建节点失败");
		}

	}

	@Override
	public Menu load( Integer menu_id ) {
		return this.menuDao.load(menu_id);
	}

	@Override
	public void update( Menu menu ) {
		try {
			this.menuDao.update(menu);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException("更新节点失败");
		}

	}

	@Override
	public void delete( String type , int menu_id ) {
		if("parent".equals(type)){
			int count = this.menuDao.getChildNodeCount(menu_id);
			if(count>0){
				throw new ServiceException("该节点无法进行删除操作,因为有还有显示的子节点!");
			}
		}
		try {
			if("child".equals(type)){
				this.menuDao.deleteRoleMenu(menu_id);
			}
			this.menuDao.deleteMenu(menu_id);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("删除节点失败!");
		}


	}

}
