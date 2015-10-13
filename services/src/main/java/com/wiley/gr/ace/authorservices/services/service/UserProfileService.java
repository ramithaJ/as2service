package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.external.AlertElement;
import com.wiley.gr.ace.authorservices.model.external.Preferences;

public interface UserProfileService {
    boolean uploadProfileImage(String participantId, Byte[] imageFile)
            throws Exception;

    Byte[] getProfileImage(String participantId) throws Exception;

    boolean updateAlerts(String participantId, AlertElement alert)
            throws Exception;

    List<AlertElement> getAlerts(String participantId) throws Exception;

    List<Preferences> getWOAaccounts(String participantId);
}
