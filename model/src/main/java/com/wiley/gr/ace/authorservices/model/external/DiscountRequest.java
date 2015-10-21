package com.wiley.gr.ace.authorservices.model.external;

/**
 * Discount Request.
 *
 * @author virtusa
 * @version 1.0
 */
public class DiscountRequest {

    /** The society promo code. */
    private String societyPromocode;

    /** The society promo code. */
    private String society;

    /** The institution code. */
    private String institutionCode;

    /** The country code. */
    private String countryCode;

    /** The jrnl arcn. */
    private String jrnlArcn;

    /** The base price. */
    private String basePrice;

    /**
     * @return the institutionCode
     */
    public String getInstitutionCode() {
        return institutionCode;
    }

    /**
     * @param institutionCode
     *            the institutionCode to set
     */
    public void setInstitutionCode(String institutionCode) {
        this.institutionCode = institutionCode;
    }

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
     * @return The country
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * 
     * @param country
     *            The country
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
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
    public String getBasePrice() {
        return basePrice;
    }

    /**
     * 
     * @param otherPromoCode
     *            The otherPromoCode
     */
    public void setBasePrice(String basePrice) {
        this.basePrice = basePrice;
    }

    @Override
    public String toString() {
        return "DiscountRequest [societyPromocode=" + societyPromocode
                + ", society=" + society + ", institutionCode="
                + institutionCode + ", countryCode=" + countryCode
                + ", jrnlArcn=" + jrnlArcn + ", basePrice=" + basePrice + "]";
    }

}
