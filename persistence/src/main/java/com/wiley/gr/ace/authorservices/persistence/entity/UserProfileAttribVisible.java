package com.wiley.gr.ace.authorservices.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author RAVISINHA
 *
 */
@Entity
@Table(name = "USER_PROFILE_ATTRIB_VISIBLE")
public class UserProfileAttribVisible implements java.io.Serializable {

	private Integer userProfileAttribId;
	private Integer userId;
	private String profileVisibilityFlg;
	private String listOfAttributesTobeVisib;

	public UserProfileAttribVisible() {
	}

	public UserProfileAttribVisible(Integer userProfileAttribId) {
		this.userProfileAttribId = userProfileAttribId;
	}

	public UserProfileAttribVisible(Integer userProfileAttribId,
			Integer userId, String profileVisibilityFlg,
			String listOfAttributesTobeVisib) {
		this.userProfileAttribId = userProfileAttribId;
		this.userId = userId;
		this.profileVisibilityFlg = profileVisibilityFlg;
		this.listOfAttributesTobeVisib = listOfAttributesTobeVisib;
	}

	@Id
	@Column(name = "USER_PROFILE_ATTRIB_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Integer getUserProfileAttribId() {
		return this.userProfileAttribId;
	}

	public void setUserProfileAttribId(Integer userProfileAttribId) {
		this.userProfileAttribId = userProfileAttribId;
	}

	@Column(name = "USER_ID", precision = 22, scale = 0)
	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	@Column(name = "PROFILE_VISIBILITY_FLG", length = 50)
	public String getProfileVisibilityFlg() {
		return this.profileVisibilityFlg;
	}

	public void setProfileVisibilityFlg(String profileVisibilityFlg) {
		this.profileVisibilityFlg = profileVisibilityFlg;
	}

	@Column(name = "LIST_OF_ATTRIBUTES_TOBE_VISIB", length = 3000)
	public String getListOfAttributesTobeVisib() {
		return this.listOfAttributesTobeVisib;
	}

	public void setListOfAttributesTobeVisib(String listOfAttributesTobeVisib) {
		this.listOfAttributesTobeVisib = listOfAttributesTobeVisib;
	}

}
