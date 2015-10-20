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
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.event.CoAuthorList;
import com.wiley.gr.ace.authorservices.model.event.EventData;
import com.wiley.gr.ace.authorservices.model.external.ProductPersonRelationObject;
import com.wiley.gr.ace.authorservices.services.service.SaveArticleData;

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

    @Override
    public void parseArticleEvent(final String articleEvent) throws Exception {

        LOGGER.info("Parsing article event ...");
        if (null != articleEvent && articleEvent.trim().length() > 0) {

            final StringReader reader = new StringReader(articleEvent);
            final DocumentBuilderFactory dbf = DocumentBuilderFactory
                    .newInstance();
            dbf.setNamespaceAware(true);

            final JAXBContext eventDataContext = JAXBContext
                    .newInstance(EventData.class);
            final EventData eventData = (EventData) eventDataContext
                    .createUnmarshaller().unmarshal(reader);
            LOGGER.debug("Parsed article name :: "
                    + eventData.getArticleInfo().getArticleName());

            handleCorrenspondingAuthorDetails(eventData);
            handleCoAuthorDetails(eventData);
        }

    }

    /**
     * Handle corrensponding author details.
     *
     * @param eventData
     *            the event data
     */
    private void handleCorrenspondingAuthorDetails(final EventData eventData) {
        final String firstName = eventData.getCorrespondingAuthor()
                .getFullName();
        final String lastName = eventData.getCorrespondingAuthor()
                .getFullName();
        final String email = eventData.getCorrespondingAuthor().getEmail();
        final String articleDhId = eventData.getArticleInfo().getArticleID();
        try {
            final boolean isAuthorExisting = authorCoAuthorLookUp(firstName,
                    lastName, email);
            LOGGER.info("is author existed or not" + isAuthorExisting);

            ProductPersonRelationObject productPersonRelationObject = new ProductPersonRelationObject();
            productPersonRelationObject.setDhId(articleDhId);
            productPersonRelationObject.setEmailId(email);
            productPersonRelationObject
                    .setProductRoleCd(AuthorServicesConstants.AUTHOR_ROLE_CD);
            Service service = sharedService
                    .saveProductPersonRelation(productPersonRelationObject);
            LOGGER.debug("Product person relation saved status: "
                    + service.getStatus());

        } catch (final Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException();
        }
    }

    /**
     * Handle co author details.
     *
     * @param eventData
     *            the event data
     */
    private void handleCoAuthorDetails(final EventData eventData) {

        final String articleDhId = eventData.getArticleInfo().getArticleID();
        final List<CoAuthorList> coAuthorsList = eventData.getCoAuthorList();
        for (final CoAuthorList coAuthorList : coAuthorsList) {
            final String firstName = coAuthorList.getCoAuthFullName();
            final String lastName = coAuthorList.getCoAuthFullName();
            final String email = coAuthorList.getCoAuthEmail();
            try {
                final boolean isCoAuthorExisting = authorCoAuthorLookUp(
                        firstName, lastName, email);
                LOGGER.info("is author existing or not " + isCoAuthorExisting);

                ProductPersonRelationObject productPersonRelationObject = new ProductPersonRelationObject();
                productPersonRelationObject.setDhId(articleDhId);
                productPersonRelationObject.setEmailId(email);
                productPersonRelationObject
                        .setProductRoleCd(AuthorServicesConstants.COAUTHOR_ROLE_CD);
                Service service = sharedService
                        .saveProductPersonRelation(productPersonRelationObject);
                LOGGER.debug("Product person relation saved status: "
                        + service.getStatus());
            } catch (final Exception e) {
                LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
                throw new UserException();
            }
        }
    }

    /**
     * Author co author look up.
     *
     * @param firstName
     *            the first name
     * @param lastName
     *            the last name
     * @param email
     *            the email
     * @return true, if successful
     */
    private boolean authorCoAuthorLookUp(final String firstName,
            final String lastName, final String email) {
        boolean isAuthorCoAuthorExist = false;
        try {
            final Service service = sharedService.authorLookup(firstName,
                    lastName, email);
            if (!StringUtils.isEmpty(service)) {
                isAuthorCoAuthorExist = true;
            }
        } catch (final Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException();
        }
        return isAuthorCoAuthorExist;
    }

}
