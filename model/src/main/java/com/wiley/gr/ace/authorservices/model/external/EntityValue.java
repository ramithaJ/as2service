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

    private AddressData addressData;
    
    private AlertRequest alertRequest;

   

    public AlertRequest getAlertRequest() {
        return alertRequest;
    }

    public void setAlertRequest(AlertRequest alertRequest) {
        this.alertRequest = alertRequest;
    }

    public AddressData getAddressData() {
        return addressData;
    }

    public void setAddressData(AddressData addressData) {
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

}
