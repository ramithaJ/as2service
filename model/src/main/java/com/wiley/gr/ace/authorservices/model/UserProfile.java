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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class UserProfile.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class UserProfile {

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
    private Alerts alerts;

    /** The email for alerts. */
    private String emailForAlerts;

    /**
     * Gets the email for alerts.
     *
     * @return the email for alerts
     */
    public String getEmailForAlerts() {
        return emailForAlerts;
    }

    /**
     * Sets the email for alerts.
     *
     * @param emailForAlerts
     *            the new email for alerts
     */
    public void setEmailForAlerts(String emailForAlerts) {
        this.emailForAlerts = emailForAlerts;
    }

    /**
     * Gets the customer details.
     *
     * @return the customer details
     */
    public User getCustomerDetails() {
        return customerDetails;
    }

    /**
     * Sets the customer details.
     *
     * @param customerDetails
     *            the new customer details
     */
    public void setCustomerDetails(User customerDetails) {
        this.customerDetails = customerDetails;
    }

    /**
     * Gets the address details.
     *
     * @return the address details
     */
    public List<Addresses> getAddressDetails() {
        return addressDetails;
    }

    /**
     * Sets the address details.
     *
     * @param addressDetails
     *            the new address details
     */
    public void setAddressDetails(List<Addresses> addressDetails) {
        this.addressDetails = addressDetails;
    }

    /**
     * Gets the affiliations.
     *
     * @return the affiliations
     */
    public List<Affiliation> getAffiliations() {
        return affiliations;
    }

    /**
     * Sets the affiliations.
     *
     * @param affiliations
     *            the new affiliations
     */
    public void setAffiliations(List<Affiliation> affiliations) {
        this.affiliations = affiliations;
    }

    /**
     * Gets the research funders.
     *
     * @return the research funders
     */
    public List<ResearchFunder> getResearchFunders() {
        return researchFunders;
    }

    /**
     * Sets the research funders.
     *
     * @param researchFunders
     *            the new research funders
     */
    public void setResearchFunders(List<ResearchFunder> researchFunders) {
        this.researchFunders = researchFunders;
    }

    /**
     * Gets the societies.
     *
     * @return the societies
     */
    public List<Society> getSocieties() {
        return societies;
    }

    /**
     * Sets the societies.
     *
     * @param societies
     *            the new societies
     */
    public void setSocieties(List<Society> societies) {
        this.societies = societies;
    }

    /**
     * Gets the interests.
     *
     * @return the interests
     */
    public List<Interests> getInterests() {
        return interests;
    }

    /**
     * Sets the interests.
     *
     * @param interests
     *            the new interests
     */
    public void setInterests(List<Interests> interests) {
        this.interests = interests;
    }

    /**
     * Gets the co authors.
     *
     * @return the co authors
     */
    public List<CoAuthor> getCoAuthors() {
        return coAuthors;
    }

    /**
     * Sets the co authors.
     *
     * @param coAuthors
     *            the new co authors
     */
    public void setCoAuthors(List<CoAuthor> coAuthors) {
        this.coAuthors = coAuthors;
    }

    /**
     * Gets the preferred journals.
     *
     * @return the preferred journals
     */
    public List<PreferredJournals> getPreferredJournals() {
        return preferredJournals;
    }

    /**
     * Sets the preferred journals.
     *
     * @param preferredJournals
     *            the new preferred journals
     */
    public void setPreferredJournals(List<PreferredJournals> preferredJournals) {
        this.preferredJournals = preferredJournals;
    }

    /**
     * Gets the alerts.
     *
     * @return the alerts
     */
    public Alerts getAlerts() {
        return alerts;
    }

    /**
     * Sets the alerts.
     *
     * @param alerts
     *            the new alerts
     */
    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }

}