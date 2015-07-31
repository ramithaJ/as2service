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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class CustomerProfile.
 *
 * @author yugandhark
 */
public class CustomerProfile {

    /** The customer details. */
    @JsonProperty("CustomerDetails")
    private CustomerDetails customerDetails;

    /** The address details. */
    @JsonProperty("AddressDetails")
    private AddressDetails addressDetails;

    /** The area of interest. */
    @JsonProperty("AreaOfInterest")
    private AreaOfInterest areaOfInterest;

    /** The research funders. */
    @JsonProperty("ResearchFunders")
    private ResearchFundersData researchFunders;

    /** The favorite journals. */
    @JsonProperty("FavoriteJournals")
    private FavoriteJournals favoriteJournals;

    /** The co authors. */
    @JsonProperty("CoAuthors")
    private CoAuthorsData coAuthors;

    /** The alerts. */
    @JsonProperty("Alerts")
    private AlertsData alerts;

    /**
     * @return the alerts
     */
    public final AlertsData getAlerts() {
        return alerts;
    }

    /**
     * @param alerts the alerts to set
     */
    public final void setAlerts(final AlertsData alerts) {
        this.alerts = alerts;
    }

    /** The affiliations. */
    @JsonProperty("Affiliations")
    private AffiliationsData affiliations;

    /** The society list. */
    @JsonProperty("SocietyList")
    private SocietyList societyList;

    /** The profile visibility. */
    @JsonProperty("ProfileVisibility")
    private ProfileVisibility profileVisibility;

    /**
     * Gets the customer details.
     *
     * @return the customer details
     */
    public final CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    /**
     * Sets the customer details.
     *
     * @param customerDetails the new customer details
     */
    public final void setCustomerDetails(final CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    /**
     * Gets the address details.
     *
     * @return the address details
     */
    public final AddressDetails getAddressDetails() {
        return addressDetails;
    }

    /**
     * Sets the address details.
     *
     * @param addressDetails the new address details
     */
    public final void setAddressDetails(final AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    /**
     * Gets the area of interest.
     *
     * @return the area of interest
     */
    public final AreaOfInterest getAreaOfInterest() {
        return areaOfInterest;
    }

    /**
     * Sets the area of interest.
     *
     * @param areaOfInterest the new area of interest
     */
    public final void setAreaOfInterest(final AreaOfInterest areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    /**
     * Gets the research funders.
     *
     * @return the research funders
     */
    public final ResearchFundersData getResearchFunders() {
        return researchFunders;
    }

    /**
     * Sets the research funders.
     *
     * @param researchFunders the new research funders
     */
    public final void setResearchFunders(final ResearchFundersData researchFunders) {
        this.researchFunders = researchFunders;
    }

    /**
     * Gets the favorite journals.
     *
     * @return the favorite journals
     */
    public final FavoriteJournals getFavoriteJournals() {
        return favoriteJournals;
    }

    /**
     * Sets the favorite journals.
     *
     * @param favoriteJournals the new favorite journals
     */
    public final void setFavoriteJournals(
            final FavoriteJournals favoriteJournals) {
        this.favoriteJournals = favoriteJournals;
    }

    /**
     * Gets the co authors.
     *
     * @return the co authors
     */
    public final CoAuthorsData getCoAuthors() {
        return coAuthors;
    }

    /**
     * Sets the co authors.
     *
     * @param coAuthors the new co authors
     */
    public final void setCoAuthors(final CoAuthorsData coAuthors) {
        this.coAuthors = coAuthors;
    }

  

    /**
     * Gets the affiliations.
     *
     * @return the affiliations
     */
    public final AffiliationsData getAffiliations() {
        return affiliations;
    }

    /**
     * Sets the affiliations.
     *
     * @param affiliations the new affiliations
     */
    public final void setAffiliations(final AffiliationsData affiliations) {
        this.affiliations = affiliations;
    }

    /**
     * Gets the society list.
     *
     * @return the society list
     */
    public final SocietyList getSocietyList() {
        return societyList;
    }

    /**
     * Sets the society list.
     *
     * @param societyList the new society list
     */
    public final void setSocietyList(final SocietyList societyList) {
        this.societyList = societyList;
    }

    /**
     * Gets the profile visibility.
     *
     * @return the profile visibility
     */
    public final ProfileVisibility getProfileVisibility() {
        return profileVisibility;
    }

    /**
     * Sets the profile visibility.
     *
     * @param profileVisibility the new profile visibility
     */
    public final void setProfileVisibility(
            final ProfileVisibility profileVisibility) {
        this.profileVisibility = profileVisibility;
    }

}
