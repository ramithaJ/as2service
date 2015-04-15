package com.wiley.gr.ace.authorservices.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_PROFILE_ATTRIB_VISIBLE")
public class UserProfileAttribVisible {
	@Id
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "PROFILE_VISIBILITY_FLG")
	private String profileVisibilityFlg;

	@Column(name = "LIST_OF_ATTRIBUTES_TOBE_VISIB")
	private String listOfAttributesToBeVisib;
	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private UserProfile userProfile;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getProfileVisibilityFlg() {
		return profileVisibilityFlg;
	}

	public void setProfileVisibilityFlg(String profileVisibilityFlg) {
		this.profileVisibilityFlg = profileVisibilityFlg;
	}

	public String getListOfAttributesToBeVisib() {
		return listOfAttributesToBeVisib;
	}

	public void setListOfAttributesToBeVisib(String listOfAttributesToBeVisib) {
		this.listOfAttributesToBeVisib = listOfAttributesToBeVisib;
	}

	public UserProfile getUserProfile() {
		return userProfile;
	}

	public void setUserProfile(UserProfile userProfile) {
		this.userProfile = userProfile;
	}

}
