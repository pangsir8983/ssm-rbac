/**
 * Role.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-08-01 09:34:31
 **/
package com.cy43.framework.rbac.role.model;

/**
 * sys_role 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-08-01 09:34:31
 **/
public class Role {

    /**角色主键ID,所属表字段为 sys_role.role_id  */
    private Integer role_id;
    /**角色名称,所属表字段为 sys_role.role_name  */
    private String role_name;
    /**唯一值,所属表字段为 sys_role.role_key  */
    private String role_key;
    /**1可用 -1禁用,所属表字段为 sys_role.status  */
    private Integer status;

    /**
     * 获取 角色主键ID 字段:sys_role.role_id
     *
     * @return  sys_role.role_id  ,角色主键ID
     */
    public Integer getRole_id() {
        return role_id;
    }

    /**
     * 设置 角色主键ID 字段:sys_role.role_id
     *
     * @param role_id  sys_role.role_id,角色主键ID
     */
    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    /**
     * 获取 角色名称 字段:sys_role.role_name
     *
     * @return  sys_role.role_name  ,角色名称
     */
    public String getRole_name() {
        return role_name;
    }

    /**
     * 设置 角色名称 字段:sys_role.role_name
     *
     * @param role_name  sys_role.role_name,角色名称
     */
    public void setRole_name(String role_name) {
        this.role_name = role_name == null ? null : role_name.trim();
    }

    /**
     * 获取 唯一值 字段:sys_role.role_key
     *
     * @return  sys_role.role_key  ,唯一值
     */
    public String getRole_key() {
        return role_key;
    }

    /**
     * 设置 唯一值 字段:sys_role.role_key
     *
     * @param role_key  sys_role.role_key,唯一值
     */
    public void setRole_key(String role_key) {
        this.role_key = role_key == null ? null : role_key.trim();
    }

    /**
     * 获取 1可用 -1禁用 字段:sys_role.status
     *
     * @return  sys_role.status  ,1可用 -1禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置 1可用 -1禁用 字段:sys_role.status
     *
     * @param status  sys_role.status,1可用 -1禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}