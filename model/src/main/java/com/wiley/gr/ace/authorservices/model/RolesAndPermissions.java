/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/

package com.wiley.gr.ace.authorservices.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sarmakumarap
 *
 */
public class RolesAndPermissions {
	
	private List<Role> rolesList = new ArrayList<Role>();
	
	private List<PermissionSection> sectionsList = new ArrayList<PermissionSection>();
	
	private Map<String, String> permissionsMap = new HashMap<String, String>();

	/**
	 * @return
	 */
	public List<Role> getRolesList() {
		return rolesList;
	}

	/**
	 * @param rolesList
	 */
	public void setRolesList(List<Role> rolesList) {
		this.rolesList = rolesList;
	}

	/**
	 * @return
	 */
	public List<PermissionSection> getSectionsList() {
		return sectionsList;
	}

	/**
	 * @param sectionsList
	 */
	public void setSectionsList(List<PermissionSection> sectionsList) {
		this.sectionsList = sectionsList;
	}

	/**
	 * @return
	 */
	public Map<String, String> getPermissionsMap() {
		return permissionsMap;
	}

	/**
	 * @param permissionsMap
	 */
	public void setPermissionsMap(Map<String, String> permissionsMap) {
		this.permissionsMap = permissionsMap;
	}

	

	


}
