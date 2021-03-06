package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Oct 19, 2015 4:16:00 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * OrderTypes generated by hbm2java
 */
@Entity
@Table(name = "order_types", catalog = "as2_app_db")
public class OrderTypes implements java.io.Serializable {

	private String orderTypeCd;
	private String orderTypeName;
	private Date createdDate;
	private UUID createdBy;
	private Date updatedDate;
	private UUID updatedBy;
	private Set<Orders> orderses = new HashSet<Orders>(0);

	public OrderTypes() {
	}

	public OrderTypes(String orderTypeCd) {
		this.orderTypeCd = orderTypeCd;
	}

	public OrderTypes(String orderTypeCd, String orderTypeName,
			Date createdDate, UUID createdBy, Date updatedDate, UUID updatedBy,
			Set<Orders> orderses) {
		this.orderTypeCd = orderTypeCd;
		this.orderTypeName = orderTypeName;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.orderses = orderses;
	}

	@Id
	@Column(name = "ORDER_TYPE_CD", unique = true, nullable = false, length = 15)
	public String getOrderTypeCd() {
		return this.orderTypeCd;
	}

	public void setOrderTypeCd(String orderTypeCd) {
		this.orderTypeCd = orderTypeCd;
	}

	@Column(name = "ORDER_TYPE_NAME", length = 250)
	public String getOrderTypeName() {
		return this.orderTypeName;
	}

	public void setOrderTypeName(String orderTypeName) {
		this.orderTypeName = orderTypeName;
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
	public UUID getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(UUID createdBy) {
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
	public UUID getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(UUID updatedBy) {
		this.updatedBy = updatedBy;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "orderTypes")
	public Set<Orders> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(Set<Orders> orderses) {
		this.orderses = orderses;
	}

}
