package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated Jun 18, 2015 11:29:00 AM by Hibernate Tools 4.0.0

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * AuditDetails generated by hbm2java
 */
@Entity
@Table(name = "AUDIT_DETAILS")
public class AuditDetails implements java.io.Serializable {

	private Integer auditId;
	private Actions actions;
	private Users usersByCreatedBy;
	private Users usersByUserId;
	private ObjectTypes objectTypes;
	private String objName;
	private String objAttribute;
	private Integer objectId;
	private String oldVal;
	private String newVal;
	private Date createdDate;

	public AuditDetails() {
	}

	public AuditDetails(Integer auditId) {
		this.auditId = auditId;
	}

	public AuditDetails(Integer auditId, Actions actions,
			Users usersByCreatedBy, Users usersByUserId,
			ObjectTypes objectTypes, String objName, String objAttribute,
			Integer objectId, String oldVal, String newVal, Date createdDate) {
		this.auditId = auditId;
		this.actions = actions;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUserId = usersByUserId;
		this.objectTypes = objectTypes;
		this.objName = objName;
		this.objAttribute = objAttribute;
		this.objectId = objectId;
		this.oldVal = oldVal;
		this.newVal = newVal;
		this.createdDate = createdDate;
	}

	
	@Id
	@Column(name = "AUDIT_ID", unique = true, nullable = false, precision = 22, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="AUDIT_SEQ")
    @SequenceGenerator(name="AUDIT_SEQ",sequenceName="AUDIT_SEQ",allocationSize=1)
	public Integer getAuditId() {
		return this.auditId;
	}

	public void setAuditId(Integer auditId) {
		this.auditId = auditId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACTION_CD")
	public Actions getActions() {
		return this.actions;
	}

	public void setActions(Actions actions) {
		this.actions = actions;
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
	@JoinColumn(name = "USER_ID")
	public Users getUsersByUserId() {
		return this.usersByUserId;
	}

	public void setUsersByUserId(Users usersByUserId) {
		this.usersByUserId = usersByUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OBJECT_TYPE_CD")
	public ObjectTypes getObjectTypes() {
		return this.objectTypes;
	}

	public void setObjectTypes(ObjectTypes objectTypes) {
		this.objectTypes = objectTypes;
	}

	@Column(name = "OBJ_NAME", length = 50)
	public String getObjName() {
		return this.objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	@Column(name = "OBJ_ATTRIBUTE", length = 50)
	public String getObjAttribute() {
		return this.objAttribute;
	}

	public void setObjAttribute(String objAttribute) {
		this.objAttribute = objAttribute;
	}

	@Column(name = "OBJECT_ID", precision = 22, scale = 0)
	public Integer getObjectId() {
		return this.objectId;
	}

	public void setObjectId(Integer objectId) {
		this.objectId = objectId;
	}

	@Column(name = "OLD_VAL", length = 250)
	public String getOldVal() {
		return this.oldVal;
	}

	public void setOldVal(String oldVal) {
		this.oldVal = oldVal;
	}

	@Column(name = "NEW_VAL", length = 250)
	public String getNewVal() {
		return this.newVal;
	}

	public void setNewVal(String newVal) {
		this.newVal = newVal;
	}

	@Column(name = "CREATED_DATE")
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
