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

import java.util.List;

public class DropDown {

	List<Institution> institutions;
	List<Department> departments;
	List<ResearchFunder> researchFunders;
	List<Society> society;
	public List<Institution> getInstitutions() {
		return institutions;
	}
	public void setInstitutions(List<Institution> institutions) {
		this.institutions = institutions;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
	}
	public List<ResearchFunder> getResearchFunders() {
		return researchFunders;
	}
	public void setResearchFunders(List<ResearchFunder> researchFunders) {
		this.researchFunders = researchFunders;
	}
	public List<Society> getSociety() {
		return society;
	}
	public void setSociety(List<Society> society) {
		this.society = society;
	}

	
	
}
