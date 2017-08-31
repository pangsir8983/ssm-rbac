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

	@Override
	public void validPassword( int user_id , String password ) {
		String data_password = this.userDao.getPassWordByUserId(user_id);
		//对输入的密码进行加密
		password = MD5Helper.MD5(password, 10);
		if(!password.equals(data_password)){
			throw new ServiceException("您输入的密码不正确,请重新输入");
		}

	}

	@Override
	public void updatePassword( String password , int user_id ) {
		try {
			this.userDao.updatePassword(MD5Helper.MD5(password, 10),user_id);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException("设置密码错误,请联系管理员");
		}

	}
	@Override
	public void update( User user ) {
		try {
			this.userDao.update(user);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException("更新用户信息失败");
		}

	}


	@Override
	public void add( User user ) {
		try {
			user.setPassword(MD5Helper.MD5(user.getPassword(), 10));
			this.userDao.add(user);//变更数据库操作
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException("系统用户新建失败");
		}

	}

	@Override
	public void validAccount( String account ) {
		int count = this.userDao.getAccountCount(account);
		if(count>0){
			throw new ServiceException("该账号已经被注册,请重新设置");
		}
	}

	@Override
	public User load( int user_id ) {
		return this.userDao.load(user_id);
	}

	@Override
	public void deleteUser( int user_id ) {
		try {
			this.userDao.deleteUser(user_id);
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new ServiceException("系统用户删除失败");
		}

	}

	@Override
	public void updateUserRole( int user_id , int fk_role_id ) {
		try {
			this.userDao.updateUserRole(user_id, fk_role_id);
		} catch (ServiceException ex) {
			ex.printStackTrace();
			throw new ServiceException("分配角色失败啊!");
		}

	}

	@Override
	public void updateUserPhoto( int user_id , String photo ) {
		try {
			this.userDao.updateUserPhoto(user_id, photo);
		} catch (ServiceException ex) {
			ex.printStackTrace();
			throw new ServiceException("上传头像失败");
		}

	}

}
