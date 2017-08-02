/**
 * MenuDao.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-08-01 09:35:47
 **/
package com.cy43.framework.rbac.menu.dao;

import java.util.List;
import com.cy43.framework.rbac.menu.model.Menu;

public interface MenuDao {
	/**
	 * sys_menu
	 * 方法描述:
	 * @param
	 * @return
	 * @throws
	 * @author 胖先生
	 * @date 2017-08-01 09:35:47
	 *
	 **/
	int delete(Integer menu_id);

	/**
	 * sys_menu
	 * 方法描述:
	 * @param
	 * @return
	 * @throws
	 * @author 胖先生
	 * @date 2017-08-01 09:35:47
	 *
	 **/
	int add(Menu menu);

	/**
	 * sys_menu
	 * 方法描述:
	 * @param
	 * @return
	 * @throws
	 * @author 胖先生
	 * @date 2017-08-01 09:35:47
	 *
	 **/
	Menu load(Integer menu_id);

	/**
	 * sys_menu
	 * 方法描述:
	 * @param
	 * @return
	 * @throws
	 * @author 胖先生
	 * @date 2017-08-01 09:35:47
	 *
	 **/
	int update(Menu menu);

	List<Menu> getChildMenusByRoleId(Integer role_id);
	List<Menu> getParentMenusByRoleId(Integer role_id);
}