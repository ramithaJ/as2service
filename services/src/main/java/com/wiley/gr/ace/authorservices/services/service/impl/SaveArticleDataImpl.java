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

import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.event.EventData;
import com.wiley.gr.ace.authorservices.persistence.services.SaveArticleDAO;
import com.wiley.gr.ace.authorservices.services.service.SaveArticleData;

// TODO: Auto-generated Javadoc
/**
 * The Class SaveArticleDataImpl.
 */
public class SaveArticleDataImpl implements SaveArticleData {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SaveArticleDataImpl.class);

	/** The shared services interface service. */
	@Autowired(required = true)
	private SharedService sharedService;

	/** The save article service dao. */
	@Autowired(required = true)
	private SaveArticleDAO saveArticleDAO;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.SaveArticleData#
	 * parseArticleEvent(java.lang.String)
	 */
	@Override
	public void parseArticleEvent(String articleEvent) throws Exception {

		LOGGER.info("Parsing article event ...");
		if (null != articleEvent && articleEvent.trim().length() > 0) {

			StringReader reader = new StringReader(articleEvent);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			dbf.setNamespaceAware(true);

			JAXBContext eventDataContext = JAXBContext
					.newInstance(EventData.class);
			EventData eventData = (EventData) eventDataContext
					.createUnmarshaller().unmarshal(reader);
			LOGGER.debug("Parsed article name :: "
					+ eventData.getArticleInfo().getArticleName());
			/**
			 * Call Author lookup service Primary Email, FN and LN.
			 */
			LOGGER.info("Calling author lookup service Pri Email, FN and LN ..");
			String firstName = eventData.getCorrespondingAuthor().getFullName();
			String lastName = eventData.getCorrespondingAuthor().getFullName();
			String email = eventData.getCorrespondingAuthor().getEmail();
			/**
			 * We should get below role from prop file.
			 */
			String role = "AUTHOR";
			boolean insertInLogTable = true;
			try {
				Service service = sharedService.authorLookup(firstName,
						lastName, email);
				if (null != service) {
					LOGGER.info("Processing lookup resonse...");
					if (null != service.getPayload()) {
						/*
						 * TODO Need to implement complete logic.
						 */
						insertInLogTable = false;

					}
				}
			} catch (Exception e) {
				LOGGER.error("Error while calling author look-up service ...");
				e.printStackTrace();
			}
			/*
			 * TODO This insert we have to repeat for co-author
			 */
			if (insertInLogTable) {
				LOGGER.info("Insert the record in INVITE_RESETPWD_LOG table ...");
				boolean status = saveArticleDAO.saveArticleInvitation(
						firstName, lastName, email, role);
				LOGGER.debug("Saved status :: "+status);
			}

		}

	}
}
