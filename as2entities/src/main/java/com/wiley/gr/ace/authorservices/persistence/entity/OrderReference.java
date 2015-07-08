package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jul 8, 2015 3:59:02 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * OrderReference generated by hbm2java
 */
@Entity
@Table(name = "ORDER_REFERENCE")
public class OrderReference implements java.io.Serializable {

	private Integer orderId;
	private Orders orders;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private Integer oouniqueId;
	private Integer ecoreSubscriptionNum;
	private Integer ecoreSequenceNum;
	private Date createdDate;
	private Date updatedDate;

	public OrderReference() {
	}

	public OrderReference(Orders orders) {
		this.orders = orders;
	}

	public OrderReference(Orders orders, Users usersByCreatedBy,
			Users usersByUpdatedBy, Integer oouniqueId,
			Integer ecoreSubscriptionNum, Integer ecoreSequenceNum,
			Date createdDate, Date updatedDate) {
		this.orders = orders;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.oouniqueId = oouniqueId;
		this.ecoreSubscriptionNum = ecoreSubscriptionNum;
		this.ecoreSequenceNum = ecoreSequenceNum;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "orders"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "ORDER_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
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

	@Column(name = "OOUNIQUE_ID", precision = 22, scale = 0)
	public Integer getOouniqueId() {
		return this.oouniqueId;
	}

	public void setOouniqueId(Integer oouniqueId) {
		this.oouniqueId = oouniqueId;
	}

	@Column(name = "ECORE_SUBSCRIPTION_NUM", precision = 22, scale = 0)
	public Integer getEcoreSubscriptionNum() {
		return this.ecoreSubscriptionNum;
	}

	public void setEcoreSubscriptionNum(Integer ecoreSubscriptionNum) {
		this.ecoreSubscriptionNum = ecoreSubscriptionNum;
	}

	@Column(name = "ECORE_SEQUENCE_NUM", precision = 22, scale = 0)
	public Integer getEcoreSequenceNum() {
		return this.ecoreSequenceNum;
	}

	public void setEcoreSequenceNum(Integer ecoreSequenceNum) {
		this.ecoreSequenceNum = ecoreSequenceNum;
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
