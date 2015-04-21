package com.wiley.gr.ace.authorservices.persistence.entity;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author RAVISINHA
 *
 */
@Embeddable
public class AdditionalPermissionsId implements java.io.Serializable {

	private BigDecimal userId;
	private BigDecimal articleId;
	private BigDecimal permissionId;

	public AdditionalPermissionsId() {
	}

	public AdditionalPermissionsId(BigDecimal userId, BigDecimal articleId,
			BigDecimal permissionId) {
		this.userId = userId;
		this.articleId = articleId;
		this.permissionId = permissionId;
	}

	@Column(name = "USER_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getUserId() {
		return this.userId;
	}

	public void setUserId(BigDecimal userId) {
		this.userId = userId;
	}

	@Column(name = "ARTICLE_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getArticleId() {
		return this.articleId;
	}

	public void setArticleId(BigDecimal articleId) {
		this.articleId = articleId;
	}

	@Column(name = "PERMISSION_ID", nullable = false, precision = 22, scale = 0)
	public BigDecimal getPermissionId() {
		return this.permissionId;
	}

	public void setPermissionId(BigDecimal permissionId) {
		this.permissionId = permissionId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AdditionalPermissionsId))
			return false;
		AdditionalPermissionsId castOther = (AdditionalPermissionsId) other;

		return ((this.getUserId() == castOther.getUserId()) || (this
				.getUserId() != null && castOther.getUserId() != null && this
				.getUserId().equals(castOther.getUserId())))
				&& ((this.getArticleId() == castOther.getArticleId()) || (this
						.getArticleId() != null
						&& castOther.getArticleId() != null && this
						.getArticleId().equals(castOther.getArticleId())))
				&& ((this.getPermissionId() == castOther.getPermissionId()) || (this
						.getPermissionId() != null
						&& castOther.getPermissionId() != null && this
						.getPermissionId().equals(castOther.getPermissionId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getArticleId() == null ? 0 : this.getArticleId().hashCode());
		result = 37
				* result
				+ (getPermissionId() == null ? 0 : this.getPermissionId()
						.hashCode());
		return result;
	}

}
