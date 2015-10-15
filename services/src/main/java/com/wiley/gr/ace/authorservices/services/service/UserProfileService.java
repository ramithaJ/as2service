package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.AlertsList;
import com.wiley.gr.ace.authorservices.model.external.PreferenceValue;
import com.wiley.gr.ace.authorservices.model.external.Preferences;

/**
 * The Interface UserProfileService.
 */
public interface UserProfileService {

    /**
     * Upload profile image.
     *
     * @param participantId
     *            the participant id
     * @param imageFile
     *            the image file
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    boolean uploadProfileImage(String participantId, Byte[] imageFile)
            throws Exception;

    /**
     * Gets the profile image.
     *
     * @param participantId
     *            the participant id
     * @return the profile image
     * @throws Exception
     *             the exception
     */
    Byte[] getProfileImage(String participantId) throws Exception;

    /**
     * Update alerts.
     *
     * @param participantId
     *            the participant id
     * @param alertList
     *            the alert list
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    boolean updateAlerts(String participantId, AlertsList alertList)
            throws Exception;

    /**
     * Gets the alerts.
     *
     * @param participantId
     *            the participant id
     * @return the alerts
     * @throws Exception
     *             the exception
     */
    PreferenceValue getAlerts(String participantId) throws Exception;

    /**
     * Gets the WO aaccounts.
     *
     * @param participantId
     *            the participant id
     * @return the WO aaccounts
     */
    List<Preferences> getWOAaccounts(String participantId);
}
