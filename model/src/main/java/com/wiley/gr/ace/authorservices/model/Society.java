package com.wiley.gr.ace.authorservices.model;

import java.util.Date;

/**
 * @author SarmaKumarap
 *
 */
public class Society {
	
	private String societyId;
	
	private String societyName;
	
	private String membershipNumber;
	
	private String promoCode;
	
	private Date startDate;
	
	private Date endDate;

	/**
	 * @return
	 */
	public String getSocietyId() {
		return societyId;
	}

	/**
	 * @param societyId
	 */
	public void setSocietyId(String societyId) {
		this.societyId = societyId;
	}

	/**
	 * @return
	 */
	public String getSocietyName() {
		return societyName;
	}

	/**
	 * @param societyName
	 */
	public void setSocietyName(String societyName) {
		this.societyName = societyName;
	}

	/**
	 * @return
	 */
	public String getMembershipNumber() {
		return membershipNumber;
	}

	/**
	 * @param membershipNumber
	 */
	public void setMembershipNumber(String membershipNumber) {
		this.membershipNumber = membershipNumber;
	}

	/**
	 * @return
	 */
	public String getPromoCode() {
		return promoCode;
	}

	/**
	 * @param promoCode
	 */
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
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
