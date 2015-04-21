package com.wiley.gr.ace.authorservices.persistence.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author RAVISINHA
 *
 */
@Entity
@Table(name = "ADMIN_DETAILS")
public class AdminDetails implements java.io.Serializable {

	private Integer adminId;
	private String firstName;
	private String lastName;
	private String emailAddr;
	private Serializable createdDate;
	private String createdBy;
	private Serializable updatedDate;
	private String updatedBy;

	public AdminDetails() {
	}

	public AdminDetails(Integer adminId) {
		this.adminId = adminId;
	}

	public AdminDetails(Integer adminId, String firstName, String lastName,
			String emailAddr, Serializable createdDate, String createdBy,
			Serializable updatedDate, String updatedBy) {
		this.adminId = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddr = emailAddr;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	@Id
	@Column(name = "ADMIN_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getAdminId() {
		return this.adminId;
	}

	public void setAdminId(Integer adminId) {
		this.adminId = adminId;
	}

	@Column(name = "FIRST_NAME", length = 250)
	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME", length = 250)
	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "EMAIL_ADDR", length = 200)
	public String getEmailAddr() {
		return this.emailAddr;
	}

	public void setEmailAddr(String emailAddr) {
		this.emailAddr = emailAddr;
	}

	@Column(name = "CREATED_DATE")
	public Serializable getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Serializable createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CREATED_BY", length = 50)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "UPDATED_DATE")
	public Serializable getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Serializable updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UPDATED_BY", length = 50)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}
