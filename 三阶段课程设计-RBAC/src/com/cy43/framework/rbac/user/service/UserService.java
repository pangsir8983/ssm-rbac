package com.cy43.framework.rbac.user.service;

import com.cy43.framework.commons.model.Pager;
import com.cy43.framework.rbac.user.model.User;

public interface UserService {

	User login(String account,String password);

	void updateLogin(User user);

	Pager find(Pager pager);

	void validPassword(int user_id,String password);

	void updatePassword(String password,int user_id);

	void add(User user);

	void validAccount(String account);

	User load(int user_id);

	void deleteUser(int user_id);

	void update(User user);

	void updateUserRole(int user_id,int fk_role_id);
	void updateUserPhoto(int user_id,String photo);

}
