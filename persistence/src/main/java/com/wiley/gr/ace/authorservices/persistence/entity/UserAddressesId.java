package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated May 26, 2015 2:39:51 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserAddressesId generated by hbm2java
 */
@Embeddable
public class UserAddressesId implements java.io.Serializable {

	private Integer userAddressId;
	private Integer userId;
	private Integer addressId;
	private String addType;
	private Date createdDate;
	private Integer createdBy;
	private Date updatedDate;
	private Integer updatedBy;

	public UserAddressesId() {
	}

	public UserAddressesId(Integer userAddressId, Integer userId,
			Integer addressId, String addType, Date createdDate,
			Integer createdBy, Date updatedDate, Integer updatedBy) {
		this.userAddressId = userAddressId;
		this.userId = userId;
		this.addressId = addressId;
		this.addType = addType;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	@Column(name = "USER_ADDRESS_ID", precision = 22, scale = 0)
	public Integer getUserAddressId() {
		return this.userAddressId;
	}

	public void setUserAddressId(Integer userAddressId) {
		this.userAddressId = userAddressId;
	}

	@Column(name = "USER_ID", precision = 22, scale = 0)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "ADDRESS_ID", precision = 22, scale = 0)
	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@Column(name = "ADD_TYPE", length = 30)
	public String getAddType() {
		return this.addType;
	}

	public void setAddType(String addType) {
		this.addType = addType;
	}

	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CREATED_BY", precision = 22, scale = 0)
	public Integer getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "UPDATED_DATE")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UPDATED_BY", precision = 22, scale = 0)
	public Integer getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof UserAddressesId))
			return false;
		UserAddressesId castOther = (UserAddressesId) other;

		return ((this.getUserAddressId() == castOther.getUserAddressId()) || (this
				.getUserAddressId() != null
				&& castOther.getUserAddressId() != null && this
				.getUserAddressId().equals(castOther.getUserAddressId())))
				&& ((this.getUserId() == castOther.getUserId()) || (this
						.getUserId() != null && castOther.getUserId() != null && this
						.getUserId().equals(castOther.getUserId())))
				&& ((this.getAddressId() == castOther.getAddressId()) || (this
						.getAddressId() != null
						&& castOther.getAddressId() != null && this
						.getAddressId().equals(castOther.getAddressId())))
				&& ((this.getAddType() == castOther.getAddType()) || (this
						.getAddType() != null && castOther.getAddType() != null && this
						.getAddType().equals(castOther.getAddType())))
				&& ((this.getCreatedDate() == castOther.getCreatedDate()) || (this
						.getCreatedDate() != null
						&& castOther.getCreatedDate() != null && this
						.getCreatedDate().equals(castOther.getCreatedDate())))
				&& ((this.getCreatedBy() == castOther.getCreatedBy()) || (this
						.getCreatedBy() != null
						&& castOther.getCreatedBy() != null && this
						.getCreatedBy().equals(castOther.getCreatedBy())))
				&& ((this.getUpdatedDate() == castOther.getUpdatedDate()) || (this
						.getUpdatedDate() != null
						&& castOther.getUpdatedDate() != null && this
						.getUpdatedDate().equals(castOther.getUpdatedDate())))
				&& ((this.getUpdatedBy() == castOther.getUpdatedBy()) || (this
						.getUpdatedBy() != null
						&& castOther.getUpdatedBy() != null && this
						.getUpdatedBy().equals(castOther.getUpdatedBy())));
	}

	public int hashCode() {
		int result = 17;

		result = 37
				* result
				+ (getUserAddressId() == null ? 0 : this.getUserAddressId()
						.hashCode());
		result = 37 * result
				+ (getUserId() == null ? 0 : this.getUserId().hashCode());
		result = 37 * result
				+ (getAddressId() == null ? 0 : this.getAddressId().hashCode());
		result = 37 * result
				+ (getAddType() == null ? 0 : this.getAddType().hashCode());
		result = 37
				* result
				+ (getCreatedDate() == null ? 0 : this.getCreatedDate()
						.hashCode());
		result = 37 * result
				+ (getCreatedBy() == null ? 0 : this.getCreatedBy().hashCode());
		result = 37
				* result
				+ (getUpdatedDate() == null ? 0 : this.getUpdatedDate()
						.hashCode());
		result = 37 * result
				+ (getUpdatedBy() == null ? 0 : this.getUpdatedBy().hashCode());
		return result;
	}

}
