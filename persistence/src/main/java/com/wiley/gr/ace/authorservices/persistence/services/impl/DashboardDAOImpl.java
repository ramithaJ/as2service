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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wiley.gr.ace.authorservices.persistence.entity.InvitationLog;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.services.DashboardDAO;

/**
 * The Class DashboardDAOImpl.
 * 
 * @author virtusa version 1.0
 */
public class DashboardDAOImpl implements DashboardDAO {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(DashboardDAOImpl.class);

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
    public final List<InvitationLog> getInvitationLogList(final String userId)
            throws Exception {
        LOGGER.info("inside getInvitationLogList Method of DashboardDAOImpl");
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            final String invitationLogHql = "from InvitationLog il where il.userProfile.userId=:userId";
            final List<InvitationLog> invitationLogList = session
                    .createQuery(invitationLogHql)
                    .setInteger("userId", Integer.parseInt(userId)).list();
            return invitationLogList;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * Gets the product person relations.
     *
     * @param userId
     *            the user id
     * @return the product person relations
     */
    @Override
    public final List<ProductPersonRelations> getProductPersonRelations(
            final String userId) {
        LOGGER.info("inside getProductPersonRelations Method of DashboardDAOImpl");
        Session session = null;
        String productPersonRelationsHql = null;
        try {
            session = getSessionFactory().openSession();
            productPersonRelationsHql = "from ProductPersonRelations ppr where ppr.userProfile.userId=:userId";
            final List<ProductPersonRelations> productPersonRelationsList = session
                    .createQuery(productPersonRelationsHql)
                    .setInteger("userId", Integer.parseInt(userId)).list();
            return productPersonRelationsList;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

}
