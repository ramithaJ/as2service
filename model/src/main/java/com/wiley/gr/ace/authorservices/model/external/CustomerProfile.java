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

package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class CustomerProfile.
 * 
 * @author virtusa version 1.0
 */
public class CustomerProfile {

    /** The alerts. */
    private Alerts alerts;

    /** The areaofinterest. */
    private AreaOfInterest areaofinterest;

    /** The researchfunders. */
    private ResearchFunders researchfunders;

    /** The affiliations. */
    private Affiliations affiliations;

    /** The favoritejournals. */
    private FavoriteJournals favoritejournals;

    /**
     * Gets the alerts.
     *
     * @return the alerts
     */
    public final Alerts getAlerts() {
        return alerts;
    }

    /**
     * Sets the alerts.
     *
     * @param alerts
     *            the alerts to set
     */
    public final void setAlerts(final Alerts alerts) {
        this.alerts = alerts;
    }

    /**
     * Gets the areaofinterest.
     *
     * @return the areaofinterest
     */
    public final AreaOfInterest getAreaofinterest() {
        return areaofinterest;
    }

    /**
     * Sets the areaofinterest.
     *
     * @param areaofinterest
     *            the areaofinterest to set
     */
    public final void setAreaofinterest(final AreaOfInterest areaofinterest) {
        this.areaofinterest = areaofinterest;
    }

    /**
     * Gets the researchfunders.
     *
     * @return the researchfunders
     */
    public final ResearchFunders getResearchfunders() {
        return researchfunders;
    }

    /**
     * Sets the researchfunders.
     *
     * @param researchfunders
     *            the researchfunders to set
     */
    public final void setResearchfunders(final ResearchFunders researchfunders) {
        this.researchfunders = researchfunders;
    }

    /**
     * Gets the affiliations.
     *
     * @return the affiliations
     */
    public final Affiliations getAffiliations() {
        return affiliations;
    }

    /**
     * Sets the affiliations.
     *
     * @param affiliations
     *            the affiliations to set
     */
    public final void setAffiliations(final Affiliations affiliations) {
        this.affiliations = affiliations;
    }

    /**
     * Gets the favoritejournals.
     *
     * @return the favoritejournals
     */
    public final FavoriteJournals getFavoritejournals() {
        return favoritejournals;
    }

    /**
     * Sets the favoritejournals.
     *
     * @param favoritejournals
     *            the favoritejournals to set
     */
    public final void setFavoritejournals(
            final FavoriteJournals favoritejournals) {
        this.favoritejournals = favoritejournals;
    }

    /**
     * Gets the addressdetails.
     *
     * @return the addressdetails
     */
    public final AddressDetails getAddressdetails() {
        return addressdetails;
    }

    /**
     * Sets the addressdetails.
     *
     * @param addressdetails
     *            the addressdetails to set
     */
    public final void setAddressdetails(final AddressDetails addressdetails) {
        this.addressdetails = addressdetails;
    }

    /**
     * Gets the societylist.
     *
     * @return the societylist
     */
    public final SocietyList getSocietylist() {
        return societylist;
    }

    /**
     * Sets the societylist.
     *
     * @param societylist
     *            the societylist to set
     */
    public final void setSocietylist(final SocietyList societylist) {
        this.societylist = societylist;
    }

    /**
     * Gets the coauthors.
     *
     * @return the coauthors
     */
    public final CoAuthors getCoauthors() {
        return coauthors;
    }

    /**
     * Sets the coauthors.
     *
     * @param coauthors
     *            the coauthors to set
     */
    public final void setCoauthors(final CoAuthors coauthors) {
        this.coauthors = coauthors;
    }

    /**
     * Gets the customerdetails.
     *
     * @return the customerdetails
     */
    public final CustomerDetails getCustomerdetails() {
        return customerdetails;
    }

    /**
     * Sets the customerdetails.
     *
     * @param customerdetails
     *            the customerdetails to set
     */
    public final void setCustomerdetails(final CustomerDetails customerdetails) {
        this.customerdetails = customerdetails;
    }

    /** The addressdetails. */
    private AddressDetails addressdetails;

    /** The societylist. */
    private SocietyList societylist;

    /** The coauthors. */
    private CoAuthors coauthors;

    /** The customerdetails. */
    private CustomerDetails customerdetails;

}
