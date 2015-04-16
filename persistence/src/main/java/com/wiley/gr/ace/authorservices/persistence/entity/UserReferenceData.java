package com.wiley.gr.ace.authorservices.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_REFERENCE_DATA")
public class UserReferenceData {

	@Id
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "ECID")
	private String ecId;

	@Column(name = "ORCID")
	private String orcId;

	@Column(name = "ALMID")
	private String almId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getEcId() {
		return ecId;
	}

	public void setEcId(String ecId) {
		this.ecId = ecId;
	}

	public String getOrcId() {
		return orcId;
	}

	public void setOrcId(String orcId) {
		this.orcId = orcId;
	}

	public String getAlmId() {
		return almId;
	}

	public void setAlmId(String almId) {
		this.almId = almId;
	}

}
