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
 * @author yugandhark
 *
 */
public class ArticleAssignmentServiceImpl implements ArticleAssignmentService {
    /* getting bean of esbInterfaceService */
    @Autowired(required = true)
    ESBInterfaceService esbInterfaceService;

    /**
     * this method will take emailId as in input and call external service (ESb)
     * to get article info
     */
    @Override
    public ArticleInfoDetails getArticleInfo(String emailId) {
        return esbInterfaceService.getArticleInfo(emailId);
    }

    /**
     * this method will take emailId as in input and call external service (ESb)
     */
    @Override
    public boolean confirmAssociation(String articleAuthId, String userId) {
        return esbInterfaceService.confirmAssociation();
    }

}
