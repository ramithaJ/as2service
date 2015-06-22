package com.wiley.gr.ace.authorservices.model.external;


/**
 * The Class PdhJournalResponse.
 *
 * @author virtusa version 1.0
 */
public class PdhJournalResponse {

	private String journalId;
	private String title;
	private String pdmSalesModel;
	private String discountsAllowed;
	private String additionalDiscountAllowed;
	private String discountReason;

	/**
	 * 
	 * @return The journalId
	 */
	public String getJournalId() {
		return journalId;
	}

	/**
	 * 
	 * @param journalId
	 *            The journalId
	 */
	public void setJournalId(String journalId) {
		this.journalId = journalId;
	}

	/**
	 * 
	 * @return The title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 * @param title
	 *            The title
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 
	 * @return The pdmSalesModel
	 */
	public String getPdmSalesModel() {
		return pdmSalesModel;
	}

	/**
	 * 
	 * @param pdmSalesModel
	 *            The pdmSalesModel
	 */
	public void setPdmSalesModel(String pdmSalesModel) {
		this.pdmSalesModel = pdmSalesModel;
	}

	/**
	 * 
	 * @return The discountsAllowed
	 */
	public String getDiscountsAllowed() {
		return discountsAllowed;
	}

	/**
	 * 
	 * @param discountsAllowed
	 *            The discountsAllowed
	 */
	public void setDiscountsAllowed(String discountsAllowed) {
		this.discountsAllowed = discountsAllowed;
	}

	/**
	 * 
	 * @return The additionalDiscountAllowed
	 */
	public String getAdditionalDiscountAllowed() {
		return additionalDiscountAllowed;
	}

	/**
	 * 
	 * @param additionalDiscountAllowed
	 *            The additionalDiscountAllowed
	 */
	public void setAdditionalDiscountAllowed(String additionalDiscountAllowed) {
		this.additionalDiscountAllowed = additionalDiscountAllowed;
	}

	/**
	 * 
	 * @return The discountReason
	 */
	public String getDiscountReason() {
		return discountReason;
	}

	/**
	 * 
	 * @param discountReason
	 *            The discountReason
	 */
	public void setDiscountReason(String discountReason) {
		this.discountReason = discountReason;
	}

}