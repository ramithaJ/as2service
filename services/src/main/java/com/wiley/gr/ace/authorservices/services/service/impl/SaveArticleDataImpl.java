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

import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.event.CoAuthorList;
import com.wiley.gr.ace.authorservices.model.event.EventData;
import com.wiley.gr.ace.authorservices.model.external.ProductPersonRelationObject;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.Products;
import com.wiley.gr.ace.authorservices.persistence.services.SaveArticleDAO;
import com.wiley.gr.ace.authorservices.persistence.services.SaveArticleInfoDAO;
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

    /** The save article info dao. */
    @Autowired(required = true)
    private SaveArticleInfoDAO saveArticleInfoDAO;

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.services.service.SaveArticleData#
     * parseArticleEvent(java.lang.String)
     */
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

            saveArticleData(eventData);
            saveJournalData(eventData);
            saveProductRelations(eventData);
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

            if (!isAuthorExisting) {
                final InviteResetpwdLog invite = new InviteResetpwdLog();
                invite.setFirstName(firstName);
                invite.setLastName(lastName);
                invite.setEmailAddress(email);
                invite.setUserType("AuthorServicesConstants.AUTHOR_ROLE_CD");

                final boolean status = saveArticleDAO
                        .saveArticleInvitation(invite);
                LOGGER.debug("Saved status :: " + status);
            }

            ProductPersonRelationObject productPersonRelationObject = new ProductPersonRelationObject();
            productPersonRelationObject.setDhId(articleDhId);
            productPersonRelationObject.setEmailId(email);
            productPersonRelationObject
                    .setProductRoleCd("AuthorServicesConstants.AUTHOR_ROLE_CD");
            Service service = sharedService
                    .saveProductPersonRelation(productPersonRelationObject);
            LOGGER.debug("Product person relation saved status: "
                    + service.getStatus());

        } catch (final Exception e) {
            LOGGER.error(e.getMessage());
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

                if (!isCoAuthorExisting) {
                    final InviteResetpwdLog invite = new InviteResetpwdLog();
                    invite.setFirstName(firstName);
                    invite.setLastName(lastName);
                    invite.setEmailAddress(email);
                    invite.setUserType("AuthorServicesConstants.COAUTHOR_ROLE_CD");

                    final boolean status = saveArticleDAO
                            .saveArticleInvitation(invite);
                    LOGGER.debug("Saved status :: " + status);
                }
                ProductPersonRelationObject productPersonRelationObject = new ProductPersonRelationObject();
                productPersonRelationObject.setDhId(articleDhId);
                productPersonRelationObject.setEmailId(email);
                productPersonRelationObject
                        .setProductRoleCd("AuthorServicesConstants.COAUTHOR_ROLE_CD");
                Service service = sharedService
                        .saveProductPersonRelation(productPersonRelationObject);
                LOGGER.debug("Product person relation saved status: "
                        + service.getStatus());
            } catch (final Exception e) {
                LOGGER.error(e.getMessage());
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
            LOGGER.error(e.getMessage());
        }
        return isAuthorCoAuthorExist;
    }

    /**
     * Save journal data.
     *
     * @param eventData
     *            the event data
     */
    private void saveJournalData(final EventData eventData) {
        final Products products = new Products();
        products.setDhId(Integer.parseInt(eventData.getJournalInfo()
                .getJournalID()));
        products.setDhTypeCd("JOURNAL");
        saveArticleInfoDAO.saveProductDetails(products);

    }

    /**
     * Save article data.
     *
     * @param eventData
     *            the event data
     */
    private void saveArticleData(final EventData eventData) {
        final Products products = new Products();
        products.setDhId(Integer.parseInt(eventData.getArticleInfo()
                .getArticleID()));
        products.setDhTypeCd("ARTICLE");
        saveArticleInfoDAO.saveProductDetails(products);
    }

    private void saveProductRelations(final EventData eventData) {
        final ProductRelations productRelations = new ProductRelations();
        final Products journalProduct = new Products();
        final Products artcleProduct = new Products();
        journalProduct.setDhId(Integer.parseInt(eventData.getJournalInfo()
                .getJournalID()));
        artcleProduct.setDhId(Integer.parseInt(eventData.getArticleInfo()
                .getArticleID()));
        productRelations.setDhTypeRelCd("JOURNAL-ARTICLE");//Will come from PDH
        productRelations.setProductsByParentDhId(journalProduct);
        productRelations.setProductsByChildDhId(artcleProduct);
        saveArticleInfoDAO.saveProductRelation(productRelations);
    }

}
