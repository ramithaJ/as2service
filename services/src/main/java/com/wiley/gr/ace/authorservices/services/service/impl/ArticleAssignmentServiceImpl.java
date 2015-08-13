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
import com.wiley.gr.ace.authorservices.model.external.ArticleInfoDetails;
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

    /**
     * this method will take emailId as in input and call external service (ESb)
     * to get article info.
     *
     * @param emailId
     *            the email id
     * @return the article info
     */
    @Override
    public final ArticleInfoDetails getArticleInfo(final String emailId) {
        return esbInterfaceService.getArticleInfo(emailId);
    }

    /**
     * this method will take emailId as in input and call external service
     * (ESb).
     *
     * @param articleAuthId
     *            the article auth id
     * @param userId
     *            the user id
     * @return true, if successful
     */
    @Override
    public final boolean confirmAssociation(final String articleAuthId,
            final String userId) {
        return esbInterfaceService.confirmAssociation();
    }

}
