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
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;

/**
 * @author yugandhark
 *
 */
public class ArticleAssignmentServiceImpl implements ArticleAssignmentService {

	@Autowired(required = true)
	ESBInterfaceService esbInterfaceService;

	@Autowired(required = true)
	SharedService sharedService;

	@Override
	public ArticleInfoDetails getArticleInfo(String emailId) {
		return esbInterfaceService.getArticleInfo(emailId);
	}

	@Override
	public boolean associationConfirmation(
			AssociationConfirmation associationConfirmation) {
		return sharedService.associationConfirmation(associationConfirmation);
	}

}
