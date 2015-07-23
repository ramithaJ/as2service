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
 * @author yugandhark
 *
 */
public class CustomerProfile {

    @JsonProperty("CustomerDetails")
    private CustomerDetails customerDetails;

    @JsonProperty("AddressDetails")
    private AddressDetails addressDetails;

    @JsonProperty("AreaOfInterest")
    private AreaOfInterest areaOfInterest;

    @JsonProperty("ResearchFunders")
    private ResearchFunders researchFunders;

    @JsonProperty("FavoriteJournals")
    private FavoriteJournals favoriteJournals;

    @JsonProperty("CoAuthors")
    private CoAuthors coAuthors;

    @JsonProperty("Alerts")
    private Alerts alerts;

    @JsonProperty("Affiliations")
    private Affiliations affiliations;

    @JsonProperty("SocietyList")
    private SocietyList societyList;

    @JsonProperty("ProfileVisibility")
    private ProfileVisibility profileVisibility;

    public final CustomerDetails getCustomerDetails() {
        return customerDetails;
    }

    public final void setCustomerDetails(final CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }

    public final AddressDetails getAddressDetails() {
        return addressDetails;
    }

    public final void setAddressDetails(final AddressDetails addressDetails) {
        this.addressDetails = addressDetails;
    }

    public final AreaOfInterest getAreaOfInterest() {
        return areaOfInterest;
    }

    public final void setAreaOfInterest(final AreaOfInterest areaOfInterest) {
        this.areaOfInterest = areaOfInterest;
    }

    public final ResearchFunders getResearchFunders() {
        return researchFunders;
    }

    public final void setResearchFunders(final ResearchFunders researchFunders) {
        this.researchFunders = researchFunders;
    }

    public final FavoriteJournals getFavoriteJournals() {
        return favoriteJournals;
    }

    public final void setFavoriteJournals(
            final FavoriteJournals favoriteJournals) {
        this.favoriteJournals = favoriteJournals;
    }

    public final CoAuthors getCoAuthors() {
        return coAuthors;
    }

    public final void setCoAuthors(final CoAuthors coAuthors) {
        this.coAuthors = coAuthors;
    }

    public final Alerts getAlerts() {
        return alerts;
    }

    public final void setAlerts(final Alerts alerts) {
        this.alerts = alerts;
    }

    public final Affiliations getAffiliations() {
        return affiliations;
    }

    public final void setAffiliations(final Affiliations affiliations) {
        this.affiliations = affiliations;
    }

    public final SocietyList getSocietyList() {
        return societyList;
    }

    public final void setSocietyList(final SocietyList societyList) {
        this.societyList = societyList;
    }

    public final ProfileVisibility getProfileVisibility() {
        return profileVisibility;
    }

    public final void setProfileVisibility(
            final ProfileVisibility profileVisibility) {
        this.profileVisibility = profileVisibility;
    }

}
