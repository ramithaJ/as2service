package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ParticipantError;
import com.wiley.gr.ace.authorservices.model.external.AlertElement;
import com.wiley.gr.ace.authorservices.model.external.Preferences;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;

public class UserProfileServiceImpl implements UserProfileService {

    @Autowired(required = true)
    ParticipantsInterfaceService participantsInterfaceService;

    @Override
    public boolean uploadProfileImage(final String participantId,
            final Byte[] imageFile) throws Exception {
        boolean isUpdated = false;
        final ResponseEntity resposeEntity = participantsInterfaceService
                .uploadProfileImage(participantId, imageFile);
        final Integer code = resposeEntity.getStatusCode().value();
        if (code.equals(200)) {
            isUpdated = true;
        } else {
            isUpdated = false;
            final ParticipantError participantError = (ParticipantError) resposeEntity
                    .getBody();
            throw new Exception(participantError.getMessage());
        }
        return isUpdated;
    }

    @Override
    public Byte[] getProfileImage(final String participantId) throws Exception {
        return participantsInterfaceService.getProfileImage(participantId);
    }

    @Override
    public boolean updateAlerts(final String participantId,
            final AlertElement alert) throws Exception {
        boolean isUpdated = false;
        final ResponseEntity resposeEntity = participantsInterfaceService
                .updateAlerts(participantId, alert);
        final Integer code = resposeEntity.getStatusCode().value();
        if (code.equals(200)) {
            isUpdated = true;
        } else {
            isUpdated = false;
            final ParticipantError participantError = (ParticipantError) resposeEntity
                    .getBody();
            throw new Exception(participantError.getMessage());
        }
        return isUpdated;
    }

    @Override
    public List<AlertElement> getAlerts(final String participantId)
            throws Exception {
        return participantsInterfaceService.getAlerts(participantId);
    }

    @Override
    public List<Preferences> getWOAaccounts(final String participantId) {

        /*
         * final Preferences preference = participantsInterfaceService
         * .getPreferredJournals(participantId);
         */
        return null;
    }
}
