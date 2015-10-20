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
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import static com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection.getSessionFactory;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.persistence.entity.ArticleConfiguration;
import com.wiley.gr.ace.authorservices.persistence.services.SaveArticleInfoDAO;

/**
 * @author yugandhark
 *
 */
public class SaveArticleInfoDAOImpl implements SaveArticleInfoDAO {

    /**
     * This field holds the value of LOGGER
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(SaveArticleInfoDAOImpl.class);

    /**
     * Gets the article id.
     *
     * @param dhId
     *            the dh id
     * @return the article id
     */
    @Override
    public final Integer getArticleId(final String dhId) {
        Session session = null;
        Integer articleId = null;
        try {
            session = getSessionFactory().openSession();
            final String hql = "select ac.dhId from ArticleConfiguration ac where ac.dhId= :dhId";
            articleId = (Integer) session.createQuery(hql)
                    .setInteger("dhId", Integer.parseInt(dhId)).uniqueResult();
        } finally {
            if (!StringUtils.isEmpty(session)) {
                session.flush();
                session.close();
            }
        }
        return articleId;
    }

    /**
     * Save article info.
     *
     * @param articleConfiguration
     *            the article configuration
     * @return true, if successful
     */
    @Override
    public final boolean saveArticleInfo(
            final ArticleConfiguration articleConfiguration) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(articleConfiguration);
            session.getTransaction().commit();
            return true;

        } catch (final Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            return false;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

    }

}
