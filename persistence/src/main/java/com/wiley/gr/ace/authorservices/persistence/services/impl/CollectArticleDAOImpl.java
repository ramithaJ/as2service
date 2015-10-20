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
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import static com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection.getSessionFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.persistence.entity.OwnershipTypes;
import com.wiley.gr.ace.authorservices.persistence.services.CollectArticleDAO;

/**
 * The Class CollectArticleDAOImpl.
 * 
 * * @author virtusa version 1.0
 */
public class CollectArticleDAOImpl implements CollectArticleDAO {

    /**
     * This field holds the value of LOGGER
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(CollectArticleDAOImpl.class);

    /**
     * Gets the collect article.
     *
     * @return the collect article
     * @throws Exception
     *             the exception
     */
    @Override
    public final Set<OwnershipTypes> getCollectArticle() {
        List<OwnershipTypes> ownershipTypesList = null;
        Set<OwnershipTypes> ownershipTypesSet = null;
        Session session = null;
        try {

            session = getSessionFactory().openSession();
            String hql = "from OwnershipTypes";
            ownershipTypesList = session.createQuery(hql).list();
            ownershipTypesSet = new HashSet<OwnershipTypes>(ownershipTypesList);
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new UserException();
        } finally {
            if (!StringUtils.isEmpty(session)) {
                session.flush();
                session.close();
            }
        }
        return ownershipTypesSet;
    }

}
