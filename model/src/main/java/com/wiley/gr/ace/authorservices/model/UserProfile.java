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
package com.wiley.gr.ace.authorservices.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class UserProfile.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class UserProfile implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The customer details. */
    private User customerDetails;

    /** The address details. */
    private List<Addresses> addressDetails;

    /** The affiliations. */
    private List<Affiliation> affiliations;

    /** The research funders. */
    private List<ResearchFunder> researchFunders;

    /** The societies. */
    private List<Society> societies;

    /** The interests. */
    private List<Interests> interests;

    /** The co authors. */
    private List<CoAuthor> coAuthors;

    /** The preferred journals. */
    private List<PreferredJournals> preferredJournals;

    /** The alerts. */
    private AlertsList alerts;

    /** The email for alerts. */
    private String emailForAlerts;

    /**
     * Gets the customer details.
     *
     * @return the customerDetails
     */
    public final User getCustomerDetails() {
        return customerDetails;
    }

    /**
     * Sets the customer details.
     *
     * @param customerDetails            the customerDetails to set
     */
    public final void setCustomerDetails(final User customerDetails) {
        this.customerDetails = customerDetails;
    }

    /**
     * Gets the address details.
     *
     * @return the addressDetails
     */
    public final List<Addresses> getAddressDetails() {
        return addressDetails;
    }

    /**
     * Sets the address details.
     *
     * @param addressDetails            the addressDetails to set
     */
    public final void setAddressDetails(final List<Addresses> addressDetails) {
        this.addressDetails = addressDetails;
    }

    /**
     * Gets the affiliations.
     *
     * @return the affiliations
     */
    public final List<Affiliation> getAffiliations() {
        return affiliations;
    }

    /**
     * Sets the affiliations.
     *
     * @param affiliations            the affiliations to set
     */
    public final void setAffiliations(final List<Affiliation> affiliations) {
        this.affiliations = affiliations;
    }

    /**
     * Gets the research funders.
     *
     * @return the researchFunders
     */
    public final List<ResearchFunder> getResearchFunders() {
        return researchFunders;
    }

    /**
     * Sets the research funders.
     *
     * @param researchFunders            the researchFunders to set
     */
    public final void setResearchFunders(
            final List<ResearchFunder> researchFunders) {
        this.researchFunders = researchFunders;
    }

    /**
     * Gets the societies.
     *
     * @return the societies
     */
    public final List<Society> getSocieties() {
        return societies;
    }

    /**
     * Sets the societies.
     *
     * @param societies            the societies to set
     */
    public final void setSocieties(final List<Society> societies) {
        this.societies = societies;
    }

    /**
     * Gets the interests.
     *
     * @return the interests
     */
    public final List<Interests> getInterests() {
        return interests;
    }

    /**
     * Sets the interests.
     *
     * @param interests            the interests to set
     */
    public final void setInterests(final List<Interests> interests) {
        this.interests = interests;
    }

    /**
     * Gets the co authors.
     *
     * @return the coAuthors
     */
    public final List<CoAuthor> getCoAuthors() {
        return coAuthors;
    }

    /**
     * Sets the co authors.
     *
     * @param coAuthors            the coAuthors to set
     */
    public final void setCoAuthors(final List<CoAuthor> coAuthors) {
        this.coAuthors = coAuthors;
    }

    /**
     * Gets the preferred journals.
     *
     * @return the preferredJournals
     */
    public final List<PreferredJournals> getPreferredJournals() {
        return preferredJournals;
    }

    /**
     * Sets the preferred journals.
     *
     * @param preferredJournals            the preferredJournals to set
     */
    public final void setPreferredJournals(
            final List<PreferredJournals> preferredJournals) {
        this.preferredJournals = preferredJournals;
    }

    /**
     * Gets the alerts.
     *
     * @return the alerts
     */
    public final AlertsList getAlerts() {
        return alerts;
    }

    /**
     * Sets the alerts.
     *
     * @param alerts            the alerts to set
     */
    public final void setAlerts(final AlertsList alerts) {
        this.alerts = alerts;
    }

    /**
     * Gets the email for alerts.
     *
     * @return the emailForAlerts
     */
    public final String getEmailForAlerts() {
        return emailForAlerts;
    }

    /**
     * Sets the email for alerts.
     *
     * @param emailForAlerts            the emailForAlerts to set
     */
    public final void setEmailForAlerts(final String emailForAlerts) {
        this.emailForAlerts = emailForAlerts;
    }

}
