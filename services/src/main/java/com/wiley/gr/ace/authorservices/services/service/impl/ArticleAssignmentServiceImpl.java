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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
import com.wiley.gr.ace.authorservices.model.external.AssociationConfirmation;
import com.wiley.gr.ace.authorservices.model.external.ConfirmArticleData;
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;

/**
 * The Class ArticleAssignmentServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class ArticleAssignmentServiceImpl implements ArticleAssignmentService {

    /** The esb interface service. */
    @Autowired(required = true)
    private ESBInterfaceService esbInterfaceService;

    /** The Shared service. */
    @Autowired(required = true)
    private SharedService sharedService;

    /**
     * this method will take emailId as in input and call external service (ESb)
     * to get article info.
     *
     * @param emailId
     *            the email id
     * @return the article info
     * @throws Exception
     *             the exception
     */
    @Override
    public final ArticleInfoDetails getArticleInfo(final String emailId)
            throws Exception {
        return esbInterfaceService.getArticleInfo(emailId);
    }

    /**
     * Association confirmation.
     *
     * @param associationConfirmation
     *            the association confirmation
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean associationConfirmation(
            final AssociationConfirmation associationConfirmation)
            throws Exception {
        return sharedService.associationConfirmation(associationConfirmation);
    }

    /**
     * Gets the article confirmation data.
     *
     * @param emailId
     *            the email id
     * @return the article confirmation data
     * @throws Exception
     *             the exception
     */
    @Override
    public final ConfirmArticleData getArticleConfirmationData(
            final String emailId) throws Exception {
        return esbInterfaceService.getArticleConfirmationData(emailId);
    }

}
