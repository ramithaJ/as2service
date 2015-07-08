package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jul 8, 2015 3:59:02 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Orders generated by hbm2java
 */
@Entity
@Table(name = "ORDERS")
public class Orders implements java.io.Serializable {

	private Integer orderId;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Products products;
	private Users usersByUserId;
	private OrderTypes orderTypes;
	private String orderStatus;
	private Date createdDate;
	private Date updatedDate;
	private OrderReference orderReference;

	public Orders() {
	}

	public Orders(Integer orderId) {
		this.orderId = orderId;
	}

	public Orders(Integer orderId, Users usersByCreatedBy,
			Users usersByUpdatedBy, Products products, Users usersByUserId,
			OrderTypes orderTypes, String orderStatus, Date createdDate,
			Date updatedDate, OrderReference orderReference) {
		this.orderId = orderId;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.products = products;
		this.usersByUserId = usersByUserId;
		this.orderTypes = orderTypes;
		this.orderStatus = orderStatus;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.orderReference = orderReference;
	}

	@Id
	@Column(name = "ORDER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
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
	@JoinColumn(name = "DH_ID")
	public Products getProducts() {
		return this.products;
	}

	public void setProducts(Products products) {
		this.products = products;
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
	@JoinColumn(name = "ORDER_TYPE_CD")
	public OrderTypes getOrderTypes() {
		return this.orderTypes;
	}

	public void setOrderTypes(OrderTypes orderTypes) {
		this.orderTypes = orderTypes;
	}

	@Column(name = "ORDER_STATUS", length = 300)
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
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

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "orders")
	public OrderReference getOrderReference() {
		return this.orderReference;
	}

	public void setOrderReference(OrderReference orderReference) {
		this.orderReference = orderReference;
	}

}
