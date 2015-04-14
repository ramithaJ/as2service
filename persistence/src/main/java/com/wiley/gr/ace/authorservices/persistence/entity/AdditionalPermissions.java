package com.wiley.gr.ace.authorservices.persistence.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADDITIONAL_PERMISSIONS")
public class AdditionalPermissions {
	@Id
	@Column(name = "USER_ID")
	private Integer userId;
	@Column(name = "ROLE_ID")
	private Integer roleId;
	@Column(name = "ARTICLE_ID")
	private Integer articleId;
	@Column(name = "PERMISSION_ID")
	private Integer permissionId;
	@Column(name = "SPL_PERMISSION_FLG")
	private String splPermissionFlg;
	@Column(name = "PERM_END_DT")
	private Date permEndDt;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Integer getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Integer permissionId) {
		this.permissionId = permissionId;
	}

	public String getSplPermissionFlg() {
		return splPermissionFlg;
	}

	public void setSplPermissionFlg(String splPermissionFlg) {
		this.splPermissionFlg = splPermissionFlg;
	}

	public Date getPermEndDt() {
		return permEndDt;
	}

	public void setPermEndDt(Date permEndDt) {
		this.permEndDt = permEndDt;
	}

}
