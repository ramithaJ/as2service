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
 ******************************************************************************/
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.model.CollectArticle;
import com.wiley.gr.ace.authorservices.model.Ownerships;
import com.wiley.gr.ace.authorservices.model.SubOwnerships;
import com.wiley.gr.ace.authorservices.persistence.entity.OwnershipTypes;
import com.wiley.gr.ace.authorservices.persistence.entity.SubOwnershipTypes;
import com.wiley.gr.ace.authorservices.persistence.services.CollectArticleDAO;
import com.wiley.gr.ace.authorservices.services.service.CollectArticleService;

public class CollectArticleServiceImpl implements CollectArticleService {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(CollectArticleServiceImpl.class);

	@Autowired(required = true)
	private CollectArticleDAO collectArticleDAO;
	
	@Override
	public CollectArticle getCollectArticleObj() throws Exception {
		System.err.println("collectArticleDAOooooo"+collectArticleDAO);
		LOGGER.info("inside getCollectArticleObj Method of CollectArticleServiceImpl");
		CollectArticle collectArticle = new CollectArticle();
		List<OwnershipTypes> ownershipTypesList = collectArticleDAO
				.getCollectArticle();
		List<Ownerships> ownershipsList = new ArrayList<Ownerships>();
		for (OwnershipTypes ownershipTypes : ownershipTypesList) {
			Ownerships ownerships = new Ownerships();
			ownerships.setCode(ownershipTypes.getTypeCd());
			ownerships.setName(ownershipTypes.getTypeName());
			List<SubOwnerships> subOwnershipsList = new ArrayList<SubOwnerships>();
			List<SubOwnershipTypes> subOwnershipTypesList = (List<SubOwnershipTypes>) ownershipTypes
					.getSubOwnershipTypeses();
			for (SubOwnershipTypes subOwnershipTypes : subOwnershipTypesList) {
				SubOwnerships subOwnerships = new SubOwnerships();
				subOwnerships.setCode(subOwnershipTypes.getSubTypeCd());
				subOwnerships.setName(subOwnershipTypes.getSubTypeName());
				subOwnershipsList.add(subOwnerships);
			}
			ownerships.setSubOwnerships(subOwnershipsList);
			ownershipsList.add(ownerships);
		}
		collectArticle.setOwnerships(ownershipsList);
		System.err.println("collectArticle"+collectArticle);
		return collectArticle;

	}
}
