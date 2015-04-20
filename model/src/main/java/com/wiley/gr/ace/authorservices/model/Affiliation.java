package com.wiley.gr.ace.authorservices.model;

import java.util.Date;

/**
 * @author SarmaKumarap
 *
 */
public class Affiliation {
	
	private String institutionId;
	
	private String departmentId;
	
	private String city;
	
	private String stateCode;
	
	private String countryCode;
	
	private Date startDate;
	
	private Date endDate;

	/**
	 * @return
	 */
	public String getInstitutionId() {
		return institutionId;
	}

	/**
	 * @param institutionId
	 */
	public void setInstitutionId(String institutionId) {
		this.institutionId = institutionId;
	}

	/**
	 * @return
	 */
	public String getDepartmentId() {
		return departmentId;
	}

	/**
	 * @param departmentId
	 */
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return
	 */
	public String getStateCode() {
		return stateCode;
	}

	/**
	 * @param stateCode
	 */
	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	/**
	 * @return
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * @param countryCode
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	/**
	 * @return
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
