package com.cy43.framework.rbac.user.service;

import com.cy43.framework.commons.model.Pager;
import com.cy43.framework.rbac.user.model.User;

public interface UserService {

	User login(String account,String password);

	void updateLogin(User user);

	Pager find(Pager pager);

}
