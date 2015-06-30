package com.wiley.gr.ace.authorservices.model.external;


public class DiscountRequest {

	private String societyPromocode;
	private String society;
	private String institution;
	private String country;
	private String jrnlArcn;
	private String otherPromoCode;

	/**
	 * 
	 * @return The societyPromocode
	 */
	public String getSocietyPromocode() {
		return societyPromocode;
	}

	/**
	 * 
	 * @param societyPromocode
	 *            The societyPromocode
	 */
	public void setSocietyPromocode(String societyPromocode) {
		this.societyPromocode = societyPromocode;
	}

	/**
	 * 
	 * @return The society
	 */
	public String getSociety() {
		return society;
	}

	/**
	 * 
	 * @param society
	 *            The society
	 */
	public void setSociety(String society) {
		this.society = society;
	}

	/**
	 * 
	 * @return The institution
	 */
	public String getInstitution() {
		return institution;
	}

	/**
	 * 
	 * @param institution
	 *            The institution
	 */
	public void setInstitution(String institution) {
		this.institution = institution;
	}

	/**
	 * 
	 * @return The country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * 
	 * @param country
	 *            The country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * 
	 * @return The jrnlArcn
	 */
	public String getJrnlArcn() {
		return jrnlArcn;
	}

	/**
	 * 
	 * @param jrnlArcn
	 *            The jrnlArcn
	 */
	public void setJrnlArcn(String jrnlArcn) {
		this.jrnlArcn = jrnlArcn;
	}

	/**
	 * 
	 * @return The otherPromoCode
	 */
	public String getOtherPromoCode() {
		return otherPromoCode;
	}

	/**
	 * 
	 * @param otherPromoCode
	 *            The otherPromoCode
	 */
	public void setOtherPromoCode(String otherPromoCode) {
		this.otherPromoCode = otherPromoCode;
	}

	@Override
	public String toString() {
		return "DiscountRequest [societyPromocode=" + societyPromocode
				+ ", society=" + society + ", institution=" + institution
				+ ", country=" + country + ", jrnlArcn=" + jrnlArcn
				+ ", otherPromoCode=" + otherPromoCode + "]";
	}

	
	
}
