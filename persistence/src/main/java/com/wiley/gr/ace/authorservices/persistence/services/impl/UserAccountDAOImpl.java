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
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import static com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection.getSessionFactory;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;

/**
 * @author virtusa version 1.0
 */
public class UserAccountDAOImpl implements UserAccountDAO {

    /**
     * This method gets the email Details from AS 2.0 DB.
     * 
     * @param userId
     *            to Retrieve.
     * @return the AuthorProfile.
     */
    @Override
    public final UserProfile getEmailDetails(final String userId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(UserProfile.class);
            criteria.add(Restrictions.eq("userId", Integer.parseInt(userId)));
            UserProfile userProfile = (UserProfile) criteria.uniqueResult();
            if (null == userProfile) {
                return null;
            }
            return userProfile;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * This method update the SecurityDetails to AS 2.0 DB.
     * 
     * @param userId
     *            to update.
     * @param securityDetails
     *            to be update.
     * @return the boolean value.
     */
    @Override
    public final boolean updateSecurityDetails(final Integer userId,
            final List<SecurityDetails> securityDetails) {

        // TODO: This is not required now, security details are maintained by
        // ALM
        return true;
    }

    /**
     * This method update the Email Details to AS 2.0 DB.
     * 
     * @param userId
     *            to update.
     * @param primaryEmail
     *            to be update.
     * @param secondaryEmail
     *            to be update.
     * @return the boolean value.
     */
    @Override
    public final boolean updateEmailDetails(final String userId,
            final String primaryEmail, final String secondaryEmail) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "UPDATE AuthorProfile set primaryEmailAddr = :primaryEmailAddr, secondaryEmailAddr = :secondaryEmailAddr "
                    + "WHERE userId = :userId";
            Query query = session.createQuery(hql);
            query.setParameter("primaryEmailAddr", primaryEmail);
            query.setParameter("secondaryEmailAddr", secondaryEmail);
            query.setParameter("userId", Integer.parseInt(userId));
            transaction.commit();
            return true;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
}
