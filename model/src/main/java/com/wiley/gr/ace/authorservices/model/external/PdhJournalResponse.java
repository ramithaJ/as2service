package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class PdhJournalResponse.
 *
 * @author virtusa version 1.0
 */
public class PdhJournalResponse {

    /** The journal id. */
    private String journalId;

    /** The title. */
    private String title;

    /** The pdm sales model. */
    private String pdmSalesModel;

    /** The discount allowed. */
    private String discountsAllowed;

    /** The additional discount allowed. */
    private String additionalDiscountAllowed;

    /** The discount reason. */
    private String discountReason;

    /** The journal print issn. */
    private String journalPrintISSN;

    /** The journal electronic issn. */
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
    public void setAdditionalDiscountAllowed(
            final String additionalDiscountAllowed) {
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

    /**
     * @return the journalPrintISSN
     */
    public String getJournalPrintISSN() {
        return journalPrintISSN;
    }

    /**
     * @param journalPrintISSN
     *            the journalPrintISSN to set
     */
    public void setJournalPrintISSN(String journalPrintISSN) {
        this.journalPrintISSN = journalPrintISSN;
    }

    /**
     * @return the journalElectronicISSN
     */
    public String getJournalElectronicISSN() {
        return journalElectronicISSN;
    }

    /**
     * @param journalElectronicISSN
     *            the journalElectronicISSN to set
     */
    public void setJournalElectronicISSN(String journalElectronicISSN) {
        this.journalElectronicISSN = journalElectronicISSN;
    }

}