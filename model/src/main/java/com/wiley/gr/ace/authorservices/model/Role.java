package com.wiley.gr.ace.authorservices.model;

/**
 * @author SarmaKumarap
 *
 */
public class Role {
	
	private String roleId;
	
	private String roleName;
	
	private String roleDescription;
	
	private boolean isAdminRole = false;

	/**
	 * @return
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return
	 */
	public boolean isAdminRole() {
		return isAdminRole;
	}

	/**
	 * @param isAdminRole
	 */
	public void setAdminRole(boolean isAdminRole) {
		this.isAdminRole = isAdminRole;
	}

	/**
	 * @return
	 */
	public String getRoleDescription() {
		return roleDescription;
	}

	/**
	 * @param roleDescription
	 */
	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}


}
