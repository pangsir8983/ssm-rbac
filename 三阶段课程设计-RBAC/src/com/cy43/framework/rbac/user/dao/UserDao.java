/**
 * UserDao.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-08-01 09:33:44
 **/
package com.cy43.framework.rbac.user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.cy43.framework.commons.model.Pager;
import com.cy43.framework.rbac.user.model.User;

public interface UserDao {
	/**
	 * sys_user
	 * 方法描述:
	 * @param
	 * @return
	 * @throws
	 * @author 胖先生
	 * @date 2017-08-01 09:33:44
	 *
	 **/
	int delete(Integer user_id);

	/**
	 * sys_user
	 * 方法描述:
	 * @param
	 * @return
	 * @throws
	 * @author 胖先生
	 * @date 2017-08-01 09:33:44
	 *
	 **/
	int add(User user);

	/**
	 * sys_user
	 * 方法描述:
	 * @param
	 * @return
	 * @throws
	 * @author 胖先生
	 * @date 2017-08-01 09:33:44
	 *
	 **/
	User load(Integer user_id);

	/**
	 * sys_user
	 * 方法描述:
	 * @param
	 * @return
	 * @throws
	 * @author 胖先生
	 * @date 2017-08-01 09:33:44
	 *
	 **/
	int update(User user);



	User login(@Param("account")String account,@Param("password")String password);

	List<User> list(Pager pager);

	int getTotalCount(Pager pager);


}