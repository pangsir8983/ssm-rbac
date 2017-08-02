/**
 * Menu.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-08-01 09:35:47
 **/
package com.cy43.framework.rbac.menu.model;

/**
 * sys_menu 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-08-01 09:35:47
 **/
public class Menu {

    /**主键ID,所属表字段为 sys_menu.menu_id  */
    private Integer menu_id;
    /**父节点ID,所属表字段为 sys_menu.parent_id  */
    private Integer parent_id;
    /**节点名称,所属表字段为 sys_menu.menu_name  */
    private String menu_name;
    /**菜单的访问路径,所属表字段为 sys_menu.url  */
    private String url;
    /**显示目标的位置,所属表字段为 sys_menu.target  */
    private String target;
    private String icon;
    /**排序,所属表字段为 sys_menu.sort  */
    private Integer sort;
    /**-1:删除 1:显示: 2:不显示,所属表字段为 sys_menu.status  */
    private Integer status;

    /**
     * 获取 主键ID 字段:sys_menu.menu_id
     *
     * @return  sys_menu.menu_id  ,主键ID
     */
    public Integer getMenu_id() {
        return menu_id;
    }

    /**
     * 设置 主键ID 字段:sys_menu.menu_id
     *
     * @param menu_id  sys_menu.menu_id,主键ID
     */
    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    /**
     * 获取 父节点ID 字段:sys_menu.parent_id
     *
     * @return  sys_menu.parent_id  ,父节点ID
     */
    public Integer getParent_id() {
        return parent_id;
    }

    /**
     * 设置 父节点ID 字段:sys_menu.parent_id
     *
     * @param parent_id  sys_menu.parent_id,父节点ID
     */
    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    /**
     * 获取 节点名称 字段:sys_menu.menu_name
     *
     * @return  sys_menu.menu_name  ,节点名称
     */
    public String getMenu_name() {
        return menu_name;
    }

    /**
     * 设置 节点名称 字段:sys_menu.menu_name
     *
     * @param menu_name  sys_menu.menu_name,节点名称
     */
    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name == null ? null : menu_name.trim();
    }

    /**
     * 获取 菜单的访问路径 字段:sys_menu.url
     *
     * @return  sys_menu.url  ,菜单的访问路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置 菜单的访问路径 字段:sys_menu.url
     *
     * @param url  sys_menu.url,菜单的访问路径
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 获取 显示目标的位置 字段:sys_menu.target
     *
     * @return  sys_menu.target  ,显示目标的位置
     */
    public String getTarget() {
        return target;
    }

    /**
     * 设置 显示目标的位置 字段:sys_menu.target
     *
     * @param target  sys_menu.target,显示目标的位置
     */
    public void setTarget(String target) {
        this.target = target == null ? null : target.trim();
    }

    /**
     * 获取  字段:sys_menu.icon
     *
     * @return  sys_menu.icon
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置  字段:sys_menu.icon
     *
     * @param icon  sys_menu.icon
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    /**
     * 获取 排序 字段:sys_menu.sort
     *
     * @return  sys_menu.sort  ,排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置 排序 字段:sys_menu.sort
     *
     * @param sort  sys_menu.sort,排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取 -1:删除 1:显示: 2:不显示 字段:sys_menu.status
     *
     * @return  sys_menu.status  ,-1:删除 1:显示: 2:不显示
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置 -1:删除 1:显示: 2:不显示 字段:sys_menu.status
     *
     * @param status  sys_menu.status,-1:删除 1:显示: 2:不显示
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}