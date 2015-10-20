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
import com.wiley.gr.ace.authorservices.persistence.entity.JournalConfiguration;
import com.wiley.gr.ace.authorservices.persistence.services.SaveJournalInfoDAO;

/**
 * The Class JournalInfoDAOImpl.
 *
 * @author virtusa version 1.0
 */
public class SaveJournalInfoDAOImpl implements SaveJournalInfoDAO {

    /**
     * This field holds the value of LOGGER
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(SaveJournalInfoDAOImpl.class);

    /**
     * Gets the journal id.
     *
     * @param dhId
     *            the dh id
     * @return the journal id
     */
    @Override
    public final Integer getJournalId(final String dhId) {
        Session session = null;
        Integer journalId = null;
        try {
            session = getSessionFactory().openSession();
            final String hql = "select jc.dhId from JournalConfiguration jc where jc.dhId= :dhId";
            journalId = (Integer) session.createQuery(hql)
                    .setInteger("dhId", Integer.parseInt(dhId)).uniqueResult();
        } finally {
            if (!StringUtils.isEmpty(session)) {
                session.flush();
                session.close();
            }
        }
        return journalId;
    }

    /**
     * Save journal info.
     *
     * @param journalConfiguration
     *            the journal configuration
     * @return true, if successful
     */
    @Override
    public final boolean saveJournalInfo(
            final JournalConfiguration journalConfiguration) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(journalConfiguration);
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
