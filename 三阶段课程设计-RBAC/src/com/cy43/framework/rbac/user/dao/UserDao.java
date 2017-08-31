package com.cy43.framework.rbac.user.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.cy43.framework.commons.model.Pager;
import com.cy43.framework.rbac.user.model.User;

public interface UserDao {
	int delete(Integer user_id);

	int add(User user);
	User load(Integer user_id);

	int update(User user);


	User login(@Param("account")String account,@Param("password")String password);

	List<User> list(Pager pager);

	int getTotalCount(Pager pager);

	String getPassWordByUserId(int user_id);

	void updatePassword(@Param("password")String password,@Param("user_id")int user_id);

	int getAccountCount(String account);

	void deleteUser(int user_id);

	void updateUserRole(@Param("user_id") int user_id , @Param("fk_role_id") int fk_role_id);
	void updateUserPhoto(@Param("user_id") int user_id , @Param("photo") String photo);


}