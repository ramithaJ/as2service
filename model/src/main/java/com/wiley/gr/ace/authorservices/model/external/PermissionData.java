package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

/**
 * @author SarmaKumarap
 *
 */
public class PermissionData {
	
	private String permissionCd;
	
	private String permissionName;
	
	private List<String> groups;

	public String getPermissionCd() {
		return permissionCd;
	}

	public void setPermissionCd(String permissionCd) {
		this.permissionCd = permissionCd;
	}

	public String getPermissionName() {
		return permissionName;
	}

	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}

	public List<String> getGroups() {
		return groups;
	}

	public void setGroups(List<String> groups) {
		this.groups = groups;
	}
	

}
