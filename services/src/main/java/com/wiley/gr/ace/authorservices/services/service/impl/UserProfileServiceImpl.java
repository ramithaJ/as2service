package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ParticipantError;
import com.wiley.gr.ace.authorservices.model.Alert;
import com.wiley.gr.ace.authorservices.model.AlertsList;
import com.wiley.gr.ace.authorservices.model.external.AlertElement;
import com.wiley.gr.ace.authorservices.model.external.AlertRequest;
import com.wiley.gr.ace.authorservices.model.external.AlertType;
import com.wiley.gr.ace.authorservices.model.external.PreferenceAlert;
import com.wiley.gr.ace.authorservices.model.external.PreferenceValue;
import com.wiley.gr.ace.authorservices.model.external.Preferences;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;

// TODO: Auto-generated Javadoc
/**
 * The Class UserProfileServiceImpl.
 */
public class UserProfileServiceImpl implements UserProfileService {

    /** The participants interface service. */
    @Autowired(required = true)
    ParticipantsInterfaceService participantsInterfaceService;

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.services.service.UserProfileService#uploadProfileImage(java.lang.String, java.lang.Byte[])
     */
    @Override
    public boolean uploadProfileImage(String participantId, Byte[] imageFile)
            throws Exception {
        boolean isUpdated = false;
        ResponseEntity resposeEntity = participantsInterfaceService
                .uploadProfileImage(participantId, imageFile);
        Integer code = resposeEntity.getStatusCode().value();
        if (code.equals(200)) {
            isUpdated = true;
        } else {
            isUpdated = false;
            ParticipantError participantError = (ParticipantError) resposeEntity
                    .getBody();
            throw new Exception(participantError.getMessage());
        }
        return isUpdated;
    }

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.services.service.UserProfileService#getProfileImage(java.lang.String)
     */
    @Override
    public Byte[] getProfileImage(String participantId) throws Exception {
        return participantsInterfaceService.getProfileImage(participantId);
    }

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.services.service.UserProfileService#updateAlerts(java.lang.String, com.wiley.gr.ace.authorservices.model.AlertsList)
     */
    @Override
    public boolean updateAlerts(String participantId,
            AlertsList alertList) throws Exception {
        boolean isUpdated = false;
        Integer code = null;
        AlertRequest alertRequest = new AlertRequest();
        alertRequest.setPreferredEmailId(alertList.getEmailsList().get(0));
        List<PreferenceAlert> preferList = new ArrayList<>();
        for(Alert alert : alertList.getAlertsList()){
            PreferenceAlert preferenceAlert = new PreferenceAlert();
            preferenceAlert.setPreferenceKey(alert.getAlertId());
            AlertType alertType = new AlertType();
            if(alert.isEmail()){
               alertType.setEmail("1"); 
            }else{
                alertType.setEmail("0");
            }
            if(alert.isOnScreen()){
                alertType.setOnscreen("1");
            }
            else{
                alertType.setOnscreen("0");
            }
          preferenceAlert.setAlertType(alertType);
          preferList.add(preferenceAlert);
        }
        alertRequest.setAlertList(preferList);
         ResponseEntity resposeEntity = participantsInterfaceService
                    .updateAlerts(participantId, alertRequest);
            code = resposeEntity.getStatusCode().value();
            if (!code.equals(200)) {
                isUpdated = false;
                ParticipantError participantError = (ParticipantError) resposeEntity
                        .getBody();
                throw new Exception(participantError.getMessage());
            }
 
        if (code.equals(200)) {
            isUpdated = true;
        }
        return isUpdated;
    }

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.services.service.UserProfileService#getAlerts(java.lang.String)
     */
    @Override
    public PreferenceValue getAlerts(String participantId)
            throws Exception {
        return participantsInterfaceService.getAlerts(participantId);
    }

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.services.service.UserProfileService#getWOAaccounts(java.lang.String)
     */
    @Override
    public List<Preferences> getWOAaccounts(final String participantId) {

        /*
         * final Preferences preference = participantsInterfaceService
         * .getPreferredJournals(participantId);
         */
        return null;
    }
}
