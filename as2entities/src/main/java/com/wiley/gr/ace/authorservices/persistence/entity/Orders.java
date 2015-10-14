package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Oct 14, 2015 5:33:21 PM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Orders generated by hbm2java
 */
@Entity
@Table(name = "orders", catalog = "as2_app_db")
public class Orders implements java.io.Serializable {

	private long orderId;
	private OrderTypes orderTypes;
	private byte[] participantId;
	private Long dhId;
	private String orderStatus;
	private String paymentStatus;
	private Date createdDate;
	private byte[] createdBy;
	private Date updatedDate;
	private byte[] updatedBy;
	private OrderReference orderReference;

	public Orders() {
	}

	public Orders(long orderId) {
		this.orderId = orderId;
	}

	public Orders(long orderId, OrderTypes orderTypes, byte[] participantId,
			Long dhId, String orderStatus, String paymentStatus,
			Date createdDate, byte[] createdBy, Date updatedDate,
			byte[] updatedBy, OrderReference orderReference) {
		this.orderId = orderId;
		this.orderTypes = orderTypes;
		this.participantId = participantId;
		this.dhId = dhId;
		this.orderStatus = orderStatus;
		this.paymentStatus = paymentStatus;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.orderReference = orderReference;
	}

	@Id
	@Column(name = "ORDER_ID", unique = true, nullable = false)
	public long getOrderId() {
		return this.orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORDER_TYPE_CD")
	public OrderTypes getOrderTypes() {
		return this.orderTypes;
	}

	public void setOrderTypes(OrderTypes orderTypes) {
		this.orderTypes = orderTypes;
	}

	@Column(name = "PARTICIPANT_ID")
	public byte[] getParticipantId() {
		return this.participantId;
	}

	public void setParticipantId(byte[] participantId) {
		this.participantId = participantId;
	}

	@Column(name = "DH_ID")
	public Long getDhId() {
		return this.dhId;
	}

	public void setDhId(Long dhId) {
		this.dhId = dhId;
	}

	@Column(name = "ORDER_STATUS", length = 300)
	public String getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	@Column(name = "PAYMENT_STATUS", length = 25)
	public String getPaymentStatus() {
		return this.paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CREATED_BY")
	public byte[] getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(byte[] createdBy) {
		this.createdBy = createdBy;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", length = 19)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UPDATED_BY")
	public byte[] getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(byte[] updatedBy) {
		this.updatedBy = updatedBy;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "orders")
	public OrderReference getOrderReference() {
		return this.orderReference;
	}

	public void setOrderReference(OrderReference orderReference) {
		this.orderReference = orderReference;
	}

}
