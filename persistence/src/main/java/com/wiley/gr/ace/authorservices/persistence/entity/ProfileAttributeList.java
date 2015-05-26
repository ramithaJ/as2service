package com.wiley.gr.ace.authorservices.persistence.entity;

// Generated May 26, 2015 4:56:42 PM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * ProfileAttributeList generated by hbm2java
 */
public class ProfileAttributeList implements java.io.Serializable {

	private String profileAttribCd;
	private Users usersByCreatedBy;
	private Users usersByUpdatedBy;
	private String objName;
	private String objAttribute;
	private String displayName;
	private Date createdDate;
	private Date updatedDate;
	private Set<UserProfileAttribVisible> userProfileAttribVisibles = new HashSet<UserProfileAttribVisible>(
			0);

	public ProfileAttributeList() {
	}

	public ProfileAttributeList(String profileAttribCd) {
		this.profileAttribCd = profileAttribCd;
	}

	public ProfileAttributeList(String profileAttribCd, Users usersByCreatedBy,
			Users usersByUpdatedBy, String objName, String objAttribute,
			String displayName, Date createdDate, Date updatedDate,
			Set<UserProfileAttribVisible> userProfileAttribVisibles) {
		this.profileAttribCd = profileAttribCd;
		this.usersByCreatedBy = usersByCreatedBy;
		this.usersByUpdatedBy = usersByUpdatedBy;
		this.objName = objName;
		this.objAttribute = objAttribute;
		this.displayName = displayName;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.userProfileAttribVisibles = userProfileAttribVisibles;
	}

	public String getProfileAttribCd() {
		return this.profileAttribCd;
	}

	public void setProfileAttribCd(String profileAttribCd) {
		this.profileAttribCd = profileAttribCd;
	}

	public Users getUsersByCreatedBy() {
		return this.usersByCreatedBy;
	}

	public void setUsersByCreatedBy(Users usersByCreatedBy) {
		this.usersByCreatedBy = usersByCreatedBy;
	}

	public Users getUsersByUpdatedBy() {
		return this.usersByUpdatedBy;
	}

	public void setUsersByUpdatedBy(Users usersByUpdatedBy) {
		this.usersByUpdatedBy = usersByUpdatedBy;
	}

	public String getObjName() {
		return this.objName;
	}

	public void setObjName(String objName) {
		this.objName = objName;
	}

	public String getObjAttribute() {
		return this.objAttribute;
	}

	public void setObjAttribute(String objAttribute) {
		this.objAttribute = objAttribute;
	}

	public String getDisplayName() {
		return this.displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Set<UserProfileAttribVisible> getUserProfileAttribVisibles() {
		return this.userProfileAttribVisibles;
	}

	public void setUserProfileAttribVisibles(
			Set<UserProfileAttribVisible> userProfileAttribVisibles) {
		this.userProfileAttribVisibles = userProfileAttribVisibles;
	}

}
