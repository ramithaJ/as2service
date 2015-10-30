/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class EntityValue.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class EntityValue {

    /**
     * This field holds the value of profile.
     */
    private ProfileRequest profile;

    /** The journal. */
    private JournalElement journal;

    /** The address data. */
    private AddressData addressData;

    /** The alert request. */
    private AlertRequest alertList;

    private List<String> journalList;
    
    /**
    * Gets the alert list.
    *
    * @return the alert list
    */
   public AlertRequest getAlertList() {
       return alertList;
   }

   /**
    * Sets the alert list.
    *
    * @param alertList the new alert list
    */
   public void setAlertList(AlertRequest alertList) {
       this.alertList = alertList;
   }


    /**
     * Gets the address data.
     *
     * @return the address data
     */
    public final AddressData getAddressData() {
        return addressData;
    }

    /**
     * Sets the address data.
     *
     * @param addressData
     *            the new address data
     */
    public final void setAddressData(final AddressData addressData) {
        this.addressData = addressData;
    }

    /**
     * Gets the profile.
     *
     * @return the profile
     */
    public final ProfileRequest getProfile() {
        return profile;
    }

    /**
     * Sets the profile.
     *
     * @param profile
     *            the profile to set
     */
    public final void setProfile(final ProfileRequest profile) {
        this.profile = profile;
    }

    /**
     * Gets the journal.
     *
     * @return the journal
     */
    public final JournalElement getJournal() {
        return journal;
    }

    /**
     * Sets the journal.
     *
     * @param journal
     *            the new journal
     */
    public final void setJournal(final JournalElement journal) {
        this.journal = journal;
    }

    public final List<String> getJournalList() {
        return journalList;
    }

    public final void setJournalList(final List<String> journalList) {
        this.journalList = journalList;
    }

}
