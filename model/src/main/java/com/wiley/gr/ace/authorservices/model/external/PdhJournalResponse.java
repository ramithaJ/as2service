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
	private String journalPrintISSN;
	private String journalElectronicISSN;

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
	public void setJournalId(final String journalId) {
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
	public void setTitle(final String title) {
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
	public void setPdmSalesModel(final String pdmSalesModel) {
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
	public void setDiscountsAllowed(final String discountsAllowed) {
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
	public void setAdditionalDiscountAllowed(final String additionalDiscountAllowed) {
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
	public void setDiscountReason(final String discountReason) {
		this.discountReason = discountReason;
	}

	public final String getJournalPrintISSN() {
		return journalPrintISSN;
	}

	public final void setJournalPrintISSN(final String journalPrintISSN) {
		this.journalPrintISSN = journalPrintISSN;
	}

	public final String getJournalElectronicISSN() {
		return journalElectronicISSN;
	}

	public final void setJournalElectronicISSN(final String journalElectronicISSN) {
		this.journalElectronicISSN = journalElectronicISSN;
	}

}