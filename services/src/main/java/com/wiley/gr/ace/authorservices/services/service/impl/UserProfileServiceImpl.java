package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ParticipantError;
import com.wiley.gr.ace.authorservices.model.external.AlertElement;
import com.wiley.gr.ace.authorservices.services.service.UserProfileService;

public class UserProfileServiceImpl implements UserProfileService {

	@Autowired(required = true)
	ParticipantsInterfaceService participantsInterfaceService;

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

	@Override
	public Byte[] getProfileImage(String participantId) throws Exception {
		return participantsInterfaceService.getProfileImage(participantId);
	}

	@Override
	public boolean updateAlerts(String participantId, AlertElement alert)
			throws Exception {
		boolean isUpdated = false;
		ResponseEntity resposeEntity = participantsInterfaceService
				.updateAlerts(participantId, alert);
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

	@Override
	public List<AlertElement> getAlerts(String participantId) throws Exception {
		return participantsInterfaceService.getAlerts(participantId);
	}

}
