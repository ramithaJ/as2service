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
package com.wiley.gr.ace.authorservices.services.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.model.event.InvitationStartEventData;
import com.wiley.gr.ace.authorservices.persistence.entity.InvitationLog;
import com.wiley.gr.ace.authorservices.persistence.services.InvitationStartDAO;
import com.wiley.gr.ace.authorservices.services.service.SaveInvitationStartEventService;

/**
 * The Class SaveInvitationStartServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class SaveInvitationStartServiceImpl implements
		SaveInvitationStartEventService {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SaveInvitationStartServiceImpl.class);

	/** The invitation start dao. */

	@Autowired(required = true)
	private InvitationStartDAO invitationStartDAO;

	/**
	 * Parses the invitation start event.
	 *
	 * @param invitationStartEvent
	 *            the invitation start event data
	 * @throws Exception
	 *             the exception
	 */
	@Override
	public final void parseInvitationStartEvent(
			final InvitationStartEventData invitationStartEvent)
			throws Exception {
		LOGGER.info("inside parseInvitationStartEvent of SaveInvitationStartServiceImpl");
		if (!StringUtils.isEmpty(invitationStartEvent)) {
			//String articleId = invitationStartEvent.getArticleId();
			String email = invitationStartEvent.getEmail();
			//String userRole = invitationStartEvent.getUserRole();

			String guId = invitationStartEvent.getUserID();
			String notificationId = invitationStartEvent.getNotificationId();
			invitationStartDAO.updateInviteResetPWDLog(guId, email);
			InvitationLog invitationLog = new InvitationLog();
			invitationLog.setEmailAddr(email);
			invitationLog.setNotificationId(Long.parseLong(notificationId));
			invitationStartDAO.createInvitationLog(invitationLog);

		}

	}

}
