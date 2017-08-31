/**
 * Dict.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2017-08-08 09:03:52
 **/
package com.cy43.framework.rbac.dict.model;

/**
 * sys_dict 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2017-08-08 09:03:52
 **/
public class Dict {

    /**编号,所属表字段为 sys_dict.id  */
    private String id;
    /**数据值,所属表字段为 sys_dict.value  */
    private String value;
    /**标签名,所属表字段为 sys_dict.label  */
    private String label;
    /**类型,所属表字段为 sys_dict.type  */
    private String type;
    /**描述,所属表字段为 sys_dict.remark  */
    private String remark;
    /**排序（升序）,所属表字段为 sys_dict.sort  */
    private Integer sort;
    /**1 可用 -1 删除,所属表字段为 sys_dict.del_flag  */
    private Integer del_flag;

    /**
     * 获取 编号 字段:sys_dict.id
     *
     * @return  sys_dict.id  ,编号
     */
    public String getId() {
        return id;
    }

    /**
     * 设置 编号 字段:sys_dict.id
     *
     * @param id  sys_dict.id,编号
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取 数据值 字段:sys_dict.value
     *
     * @return  sys_dict.value  ,数据值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置 数据值 字段:sys_dict.value
     *
     * @param value  sys_dict.value,数据值
     */
    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    /**
     * 获取 标签名 字段:sys_dict.label
     *
     * @return  sys_dict.label  ,标签名
     */
    public String getLabel() {
        return label;
    }

    /**
     * 设置 标签名 字段:sys_dict.label
     *
     * @param label  sys_dict.label,标签名
     */
    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    /**
     * 获取 类型 字段:sys_dict.type
     *
     * @return  sys_dict.type  ,类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置 类型 字段:sys_dict.type
     *
     * @param type  sys_dict.type,类型
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 获取 描述 字段:sys_dict.remark
     *
     * @return  sys_dict.remark  ,描述
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置 描述 字段:sys_dict.remark
     *
     * @param remark  sys_dict.remark,描述
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取 排序（升序） 字段:sys_dict.sort
     *
     * @return  sys_dict.sort  ,排序（升序）
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置 排序（升序） 字段:sys_dict.sort
     *
     * @param sort  sys_dict.sort,排序（升序）
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取 1 可用 -1 删除 字段:sys_dict.del_flag
     *
     * @return  sys_dict.del_flag  ,1 可用 -1 删除
     */
    public Integer getDel_flag() {
        return del_flag;
    }

    /**
     * 设置 1 可用 -1 删除 字段:sys_dict.del_flag
     *
     * @param del_flag  sys_dict.del_flag,1 可用 -1 删除
     */
    public void setDel_flag(Integer del_flag) {
        this.del_flag = del_flag;
    }
}