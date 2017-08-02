package com.cy43.framework.rbac.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cy43.framework.commons.exception.ServiceException;
import com.cy43.framework.commons.model.Pager;
import com.cy43.framework.commons.util.MD5Helper;
import com.cy43.framework.rbac.user.dao.UserDao;
import com.cy43.framework.rbac.user.exception.LoginException;
import com.cy43.framework.rbac.user.model.User;
import com.cy43.framework.rbac.user.service.UserService;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public User login( String account , String password ) {
		//对密码进行加密
		User user = this.userDao.login(account, MD5Helper.MD5(password, 10));
		if(user==null){
			throw new LoginException("用户名或者密码错误,请重新登录!");
		}else{
			if(user.getStatus()==-1){
				throw new LoginException("用户已经被注销,如需求请联系管理员!");
			}else if(user.getStatus()==2){
				throw new LoginException("用户已经被禁用,请等待解封!");
			}else{
				return user;
			}
		}
	}

	@Override
	public void updateLogin( User user ) {
		try {
			this.userDao.update(user);
		} catch (ServiceException ex) {
			ex.printStackTrace();
			throw new ServiceException("更新登录时间和IP地址失败");
		}

	}

	@Override
	public Pager find( Pager pager ) {
		//存储结果集
		pager.setDatas(this.userDao.list(pager));
		pager.setTotalCount(this.userDao.getTotalCount(pager));
		return pager;
	}

}
