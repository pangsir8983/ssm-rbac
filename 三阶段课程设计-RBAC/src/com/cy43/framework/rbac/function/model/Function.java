/**
 * Function.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-08-03 10:04:04
 **/
package com.cy43.framework.rbac.function.model;

/**
 * sys_menu_function 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-08-03 10:04:04
 **/
public class Function {

    /**功能主键,所属表字段为 sys_menu_function.function_id  */
    private Integer function_id;
    /**功能显示名称,所属表字段为 sys_menu_function.function_name  */
    private String function_name;
    /**功能使用KEY,所属表字段为 sys_menu_function.function_key  */
    private String function_key;
    /**属于哪个菜单,所属表字段为 sys_menu_function.menu_id  */
    private Integer menu_id;
    /**图标,所属表字段为 sys_menu_function.icon  */
    private String icon;

    /**
     * 获取 功能主键 字段:sys_menu_function.function_id
     *
     * @return  sys_menu_function.function_id  ,功能主键
     */
    public Integer getFunction_id() {
        return function_id;
    }

    /**
     * 设置 功能主键 字段:sys_menu_function.function_id
     *
     * @param function_id  sys_menu_function.function_id,功能主键
     */
    public void setFunction_id(Integer function_id) {
        this.function_id = function_id;
    }

    /**
     * 获取 功能显示名称 字段:sys_menu_function.function_name
     *
     * @return  sys_menu_function.function_name  ,功能显示名称
     */
    public String getFunction_name() {
        return function_name;
    }

    /**
     * 设置 功能显示名称 字段:sys_menu_function.function_name
     *
     * @param function_name  sys_menu_function.function_name,功能显示名称
     */
    public void setFunction_name(String function_name) {
        this.function_name = function_name == null ? null : function_name.trim();
    }

    /**
     * 获取 功能使用KEY 字段:sys_menu_function.function_key
     *
     * @return  sys_menu_function.function_key  ,功能使用KEY
     */
    public String getFunction_key() {
        return function_key;
    }

    /**
     * 设置 功能使用KEY 字段:sys_menu_function.function_key
     *
     * @param function_key  sys_menu_function.function_key,功能使用KEY
     */
    public void setFunction_key(String function_key) {
        this.function_key = function_key == null ? null : function_key.trim();
    }

    /**
     * 获取 属于哪个菜单 字段:sys_menu_function.menu_id
     *
     * @return  sys_menu_function.menu_id  ,属于哪个菜单
     */
    public Integer getMenu_id() {
        return menu_id;
    }

    /**
     * 设置 属于哪个菜单 字段:sys_menu_function.menu_id
     *
     * @param menu_id  sys_menu_function.menu_id,属于哪个菜单
     */
    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    /**
     * 获取 图标 字段:sys_menu_function.icon
     *
     * @return  sys_menu_function.icon  ,图标
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置 图标 字段:sys_menu_function.icon
     *
     * @param icon  sys_menu_function.icon,图标
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}