package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jun 23, 2015 2:35:20 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserAddresses generated by hbm2java
 */
@Entity
@Table(name = "USER_ADDRESSES")
public class UserAddresses implements java.io.Serializable {

	private Integer userAddressId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Address address;
	private Users usersByUserId;
	private AddressType addressType;
	private Date createdDate;
	private Date updatedDate;

	public UserAddresses() {
	}

	public UserAddresses(Integer userAddressId) {
		this.userAddressId = userAddressId;
	}

	public UserAddresses(Integer userAddressId, Users usersByCreatedBy,
			Users usersByUpdatedBy, Address address, Users usersByUserId,
			AddressType addressType, Date createdDate, Date updatedDate) {
		this.userAddressId = userAddressId;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.address = address;
		this.usersByUserId = usersByUserId;
		this.addressType = addressType;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@Id
	@Column(name = "USER_ADDRESS_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getUserAddressId() {
		return this.userAddressId;
	}

	public void setUserAddressId(Integer userAddressId) {
		this.userAddressId = userAddressId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY")
	public Users getUsersByCreatedBy() {
		return this.usersByCreatedBy;
	}

	public void setUsersByCreatedBy(Users usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UPDATED_BY")
	public Users getUsersByUpdatedBy() {
		return this.usersByUpdatedBy;
	}

	public void setUsersByUpdatedBy(Users usersByUpdatedBy) {
		this.usersByUpdatedBy = usersByUpdatedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_ID")
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	public Users getUsersByUserId() {
		return this.usersByUserId;
	}

	public void setUsersByUserId(Users usersByUserId) {
		this.usersByUserId = usersByUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_TYPE_CD")
	public AddressType getAddressType() {
		return this.addressType;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}

	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "UPDATED_DATE")
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
