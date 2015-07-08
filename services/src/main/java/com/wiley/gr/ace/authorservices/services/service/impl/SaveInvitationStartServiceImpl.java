package com.wiley.gr.ace.authorservices.services.service.impl;

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.event.InvitationStartEventData;
import com.wiley.gr.ace.authorservices.persistence.entity.InvitationLog;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.services.InvitationStartDAO;
import com.wiley.gr.ace.authorservices.services.service.SaveInvitationStartEventService;

public class SaveInvitationStartServiceImpl implements
		SaveInvitationStartEventService {
	@Autowired(required = true)
	private SharedService sharedService;
	
	@Autowired(required = true)
	private InvitationStartDAO invitationStartDAO;
	
	@Override
	public void parseInvitationStartEvent(String StartNotificationEvent)
			throws Exception {

		if (null != StartNotificationEvent
				&& StartNotificationEvent.trim().length() > 0) {

			StringReader reader = new StringReader(StartNotificationEvent);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);

			JAXBContext invitationStartEventDataContext = JAXBContext
					.newInstance(InvitationStartEventData.class);
			InvitationStartEventData invitationStartEventData = (InvitationStartEventData) invitationStartEventDataContext
					.createUnmarshaller().unmarshal(reader);
			if (!StringUtils.isEmpty(invitationStartEventData)) {
				String articleId = invitationStartEventData.getArticleId();
				String email = invitationStartEventData.getEmail();
				String userRole = invitationStartEventData.getUserRole();
				String guId = invitationStartEventData.getUserID();
				String notificationId = invitationStartEventData.getNotificationId();
				invitationStartDAO.updateInviteResetPWDLog(guId, email);
				InvitationLog invitationLog = new InvitationLog();
				invitationLog.setEmailAddr(email);
				//invitationLog.setNotificationId(notificationId);
				invitationStartDAO.createInvitationLog(invitationLog);
			}

		}

	}

}
