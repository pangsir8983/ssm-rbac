package com.cy43.framework.cms.content.model;

import java.util.Date;
public class Content {

	private Integer cms_id;
	private Integer type_id;
	private String title;
	private String author;
	private String remark;
	private String content;
	private String photo;
	/**-1 删除 1可用,所属表字段为 cms_content.status  */
	private Integer status;
	private Date create_date;
	private Integer view_num;

	/**
	 * 获取  字段:cms_content.cms_id
	 *
	 * @return  cms_content.cms_id
	 */
	public Integer getCms_id() {
		return this.cms_id;
	}

	/**
	 * 设置  字段:cms_content.cms_id
	 *
	 * @param cms_id  cms_content.cms_id
	 */
	public void setCms_id(Integer cms_id) {
		this.cms_id = cms_id;
	}

	/**
	 * 获取  字段:cms_content.type_id
	 *
	 * @return  cms_content.type_id
	 */
	public Integer getType_id() {
		return this.type_id;
	}

	/**
	 * 设置  字段:cms_content.type_id
	 *
	 * @param type_id  cms_content.type_id
	 */
	public void setType_id(Integer type_id) {
		this.type_id = type_id;
	}

	/**
	 * 获取  字段:cms_content.title
	 *
	 * @return  cms_content.title
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * 设置  字段:cms_content.title
	 *
	 * @param title  cms_content.title
	 */
	public void setTitle(String title) {
		this.title = title == null ? null : title.trim();
	}

	/**
	 * 获取  字段:cms_content.author
	 *
	 * @return  cms_content.author
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 * 设置  字段:cms_content.author
	 *
	 * @param author  cms_content.author
	 */
	public void setAuthor(String author) {
		this.author = author == null ? null : author.trim();
	}

	/**
	 * 获取  字段:cms_content.remark
	 *
	 * @return  cms_content.remark
	 */
	public String getRemark() {
		return this.remark;
	}

	/**
	 * 设置  字段:cms_content.remark
	 *
	 * @param remark  cms_content.remark
	 */
	public void setRemark(String remark) {
		this.remark = remark == null ? null : remark.trim();
	}

	/**
	 * 获取  字段:cms_content.content
	 *
	 * @return  cms_content.content
	 */
	public String getContent() {
		return this.content;
	}

	/**
	 * 设置  字段:cms_content.content
	 *
	 * @param content  cms_content.content
	 */
	public void setContent(String content) {
		this.content = content == null ? null : content.trim();
	}

	/**
	 * 获取  字段:cms_content.photo
	 *
	 * @return  cms_content.photo
	 */
	public String getPhoto() {
		return this.photo;
	}

	/**
	 * 设置  字段:cms_content.photo
	 *
	 * @param photo  cms_content.photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo == null ? null : photo.trim();
	}

	/**
	 * 获取 -1 删除 1可用 字段:cms_content.status
	 *
	 * @return  cms_content.status  ,-1 删除 1可用
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * 设置 -1 删除 1可用 字段:cms_content.status
	 *
	 * @param status  cms_content.status,-1 删除 1可用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 获取  字段:cms_content.create_date
	 *
	 * @return  cms_content.create_date
	 */
	public Date getCreate_date() {
		return this.create_date;
	}

	/**
	 * 设置  字段:cms_content.create_date
	 *
	 * @param create_date  cms_content.create_date
	 */
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	/**
	 * 获取  字段:cms_content.view_num
	 *
	 * @return  cms_content.view_num
	 */
	public Integer getView_num() {
		return this.view_num;
	}

	/**
	 * 设置  字段:cms_content.view_num
	 *
	 * @param view_num  cms_content.view_num
	 */
	public void setView_num(Integer view_num) {
		this.view_num = view_num;
	}
}