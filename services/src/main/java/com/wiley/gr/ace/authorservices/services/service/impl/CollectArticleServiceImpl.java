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

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.model.CollectArticle;
import com.wiley.gr.ace.authorservices.model.Ownerships;
import com.wiley.gr.ace.authorservices.model.SubOwnerships;
import com.wiley.gr.ace.authorservices.persistence.entity.OwnershipTypes;
import com.wiley.gr.ace.authorservices.persistence.services.CollectArticleDAO;
import com.wiley.gr.ace.authorservices.services.service.CollectArticleService;

/**
 * The Class CollectArticleServiceImpl.
 * 
 * * @author virtusa version 1.0
 */
public class CollectArticleServiceImpl implements CollectArticleService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CollectArticleServiceImpl.class);

    /** The collect article dao. */
    @Autowired(required = true)
    private CollectArticleDAO collectArticleDAO;

    /**
     * Gets the collect article obj.
     *
     * @return the collect article obj
     */

    @Override
    public final CollectArticle getCollectArticleObj() {
        LOGGER.info("inside getCollectArticleObj Method of CollectArticleServiceImpl");
        CollectArticle collectArticle = new CollectArticle();
        Set<OwnershipTypes> ownershipTypesSet = collectArticleDAO
                .getCollectArticle();
        Set<Ownerships> ownershipsSet = new HashSet<Ownerships>();
        for (OwnershipTypes ownershipTypes : ownershipTypesSet) {
            Ownerships ownerships = new Ownerships();
            ownerships.setCode(ownershipTypes.getTypeCd());
            ownerships.setName(ownershipTypes.getTypeName());
            Set<SubOwnerships> subOwnershipsSet = new HashSet<SubOwnerships>();
            ownerships.setSubOwnerships(subOwnershipsSet);
            ownershipsSet.add(ownerships);
        }
        collectArticle.setOwnerships(ownershipsSet);
        return collectArticle;

    }
}
