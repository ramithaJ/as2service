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

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wiley.gr.ace.authorservices.persistence.entity.InvitationLog;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.services.DashboardDAO;

/**
 * The Class DashboardDAOImpl.
 * 
 * @author virtusa version 1.0
 */
public class DashboardDAOImpl implements DashboardDAO {

    /**
     * Gets the invitation log list.
     *
     * @param userId
     *            the user id
     * @return the invitation log list
     * @throws Exception
     *             the exception
     */
    @Override
    public final List<InvitationLog> getInvitationLogList(final Integer userId)
            throws Exception {
        Session session = null;
        Transaction txn = null;
        try {
            session = getSessionFactory().openSession();
            txn = session.beginTransaction();
            final String invitationLogHql = "from InvitationLog il where il.userProfile.userId=:userId";
            final List<InvitationLog> invitationLogList = session
                    .createQuery(invitationLogHql).setInteger("userId", userId)
                    .list();
            txn.commit();
            return invitationLogList;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * Gets the article author roles.
     *
     * @param userId
     *            the user id
     * @return the article author roles
     */
    @Override
    public final ProductPersonRelations getArticleAuthorRoles(
            final Integer userId) {
        Session session = null;
        Transaction txn = null;
        try {
            session = getSessionFactory().openSession();
            txn = session.beginTransaction();
            final String articleAuthorAssignmentHql = "from ProductPersonRelations ppr where ppr.userProfile.userId=:userId";
            final ProductPersonRelations productPersonRelations = (ProductPersonRelations) session
                    .createQuery(articleAuthorAssignmentHql)
                    .setInteger("userId", userId).uniqueResult();
            txn.commit();
            return productPersonRelations;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

}
