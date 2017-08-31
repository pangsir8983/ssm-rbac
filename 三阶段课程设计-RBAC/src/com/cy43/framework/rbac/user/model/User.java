/**
 * User.java
 * ©2006-2016 四海兴唐科技有限公司
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-08-01 09:33:44
 **/
package com.cy43.framework.rbac.user.model;

import java.util.Date;

/**
 * sys_user 类
 * @Description :
 *
 * @author 胖先生
 * @version 1.0
 * 文件创建于: 2017-08-01 09:33:44
 **/
public class User {

	/**用户主键,所属表字段为 sys_user.user_id  */
	private Integer user_id;
	/**账号,唯一值,所属表字段为 sys_user.account  */
	private String account;
	/**密码需要加密,所属表字段为 sys_user.password  */
	private String password;
	/**姓名,所属表字段为 sys_user.user_name  */
	private String user_name;
	/**1可用 -1删除 2禁用,所属表字段为 sys_user.status  */
	private Integer status;
	/**登录的时间,所属表字段为 sys_user.login_time  */
	private Date login_time;
	/**登录的IP地址,所属表字段为 sys_user.ip  */
	private String ip;
	/**用户拥有的角色ID,所属表字段为 sys_user.fk_role_id  */
	private Integer fk_role_id;

	private String photo;

	/**
	 * 获取 用户主键 字段:sys_user.user_id
	 *
	 * @return  sys_user.user_id  ,用户主键
	 */
	public Integer getUser_id() {
		return this.user_id;
	}

	/**
	 * 设置 用户主键 字段:sys_user.user_id
	 *
	 * @param user_id  sys_user.user_id,用户主键
	 */
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	/**
	 * 获取 账号,唯一值 字段:sys_user.account
	 *
	 * @return  sys_user.account  ,账号,唯一值
	 */
	public String getAccount() {
		return this.account;
	}

	/**
	 * 设置 账号,唯一值 字段:sys_user.account
	 *
	 * @param account  sys_user.account,账号,唯一值
	 */
	public void setAccount(String account) {
		this.account = account == null ? null : account.trim();
	}

	/**
	 * 获取 密码需要加密 字段:sys_user.password
	 *
	 * @return  sys_user.password  ,密码需要加密
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 设置 密码需要加密 字段:sys_user.password
	 *
	 * @param password  sys_user.password,密码需要加密
	 */
	public void setPassword(String password) {
		this.password = password == null ? null : password.trim();
	}

	/**
	 * 获取 姓名 字段:sys_user.user_name
	 *
	 * @return  sys_user.user_name  ,姓名
	 */
	public String getUser_name() {
		return this.user_name;
	}

	/**
	 * 设置 姓名 字段:sys_user.user_name
	 *
	 * @param user_name  sys_user.user_name,姓名
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name == null ? null : user_name.trim();
	}

	/**
	 * 获取 1可用 -1删除 2禁用 字段:sys_user.status
	 *
	 * @return  sys_user.status  ,1可用 -1删除 2禁用
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * 设置 1可用 -1删除 2禁用 字段:sys_user.status
	 *
	 * @param status  sys_user.status,1可用 -1删除 2禁用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取 登录的时间 字段:sys_user.login_time
	 *
	 * @return  sys_user.login_time  ,登录的时间
	 */
	public Date getLogin_time() {
		return this.login_time;
	}

	/**
	 * 设置 登录的时间 字段:sys_user.login_time
	 *
	 * @param login_time  sys_user.login_time,登录的时间
	 */
	public void setLogin_time(Date login_time) {
		this.login_time = login_time;
	}

	/**
	 * 获取 登录的IP地址 字段:sys_user.ip
	 *
	 * @return  sys_user.ip  ,登录的IP地址
	 */
	public String getIp() {
		return this.ip;
	}

	/**
	 * 设置 登录的IP地址 字段:sys_user.ip
	 *
	 * @param ip  sys_user.ip,登录的IP地址
	 */
	public void setIp(String ip) {
		this.ip = ip == null ? null : ip.trim();
	}

	/**
	 * 获取 用户拥有的角色ID 字段:sys_user.fk_role_id
	 *
	 * @return  sys_user.fk_role_id  ,用户拥有的角色ID
	 */
	public Integer getFk_role_id() {
		return this.fk_role_id;
	}

	/**
	 * 设置 用户拥有的角色ID 字段:sys_user.fk_role_id
	 *
	 * @param fk_role_id  sys_user.fk_role_id,用户拥有的角色ID
	 */
	public void setFk_role_id(Integer fk_role_id) {
		this.fk_role_id = fk_role_id;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto( String photo ) {
		this.photo = photo == null ? null : photo.trim();
	}

}