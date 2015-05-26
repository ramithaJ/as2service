package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated May 26, 2015 6:09:14 PM by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * UserAddresses generated by hbm2java
 */
@Entity
@Table(name = "USER_ADDRESSES")
public class UserAddresses implements java.io.Serializable {

	private UserAddressesId id;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Address address;
	private Users usersByUserId;

	public UserAddresses() {
	}

	public UserAddresses(UserAddressesId id) {
		this.id = id;
	}

	public UserAddresses(UserAddressesId id, Users usersByCreatedBy,
			Users usersByUpdatedBy, Address address, Users usersByUserId) {
		this.id = id;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.address = address;
		this.usersByUserId = usersByUserId;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "userAddressId", column = @Column(name = "USER_ADDRESS_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "userId", column = @Column(name = "USER_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "addressId", column = @Column(name = "ADDRESS_ID", precision = 22, scale = 0)),
			@AttributeOverride(name = "addType", column = @Column(name = "ADD_TYPE", length = 30)),
			@AttributeOverride(name = "createdDate", column = @Column(name = "CREATED_DATE")),
			@AttributeOverride(name = "createdBy", column = @Column(name = "CREATED_BY", precision = 22, scale = 0)),
			@AttributeOverride(name = "updatedDate", column = @Column(name = "UPDATED_DATE")),
			@AttributeOverride(name = "updatedBy", column = @Column(name = "UPDATED_BY", precision = 22, scale = 0)) })
	public UserAddressesId getId() {
		return this.id;
	}

	public void setId(UserAddressesId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CREATED_BY", insertable = false, updatable = false)
	public Users getUsersByCreatedBy() {
		return this.usersByCreatedBy;
	}

	public void setUsersByCreatedBy(Users usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UPDATED_BY", insertable = false, updatable = false)
	public Users getUsersByUpdatedBy() {
		return this.usersByUpdatedBy;
	}

	public void setUsersByUpdatedBy(Users usersByUpdatedBy) {
		this.usersByUpdatedBy = usersByUpdatedBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ADDRESS_ID", insertable = false, updatable = false)
	public Address getAddress() {
		return this.address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID", insertable = false, updatable = false)
	public Users getUsersByUserId() {
		return this.usersByUserId;
	}

	public void setUsersByUserId(Users usersByUserId) {
		this.usersByUserId = usersByUserId;
	}

}
