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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.wiley.gr.ace.authorservices.persistence.entity.UserSecondaryEmailAddr;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.SendNotificationDao;

/**
 * The Class SendNotificationDaoImpl.
 */
public class SendNotificationDaoImpl implements SendNotificationDao {

    /**
     * this method will take.
     *
     * @param userId
     *            the user id
     * @return users
     */
    @Override
    public final Users getUserProfile(final Integer userId) {
        Session session = null;
        Users users = null;
        try {
            session = getSessionFactory().openSession();
            users = (Users) session.get(Users.class, userId);
        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }

        }

        return users;
    }

    @Override
    public UserSecondaryEmailAddr getUserSecEmailAddr(final int userId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(
                    UserSecondaryEmailAddr.class, "userSecondaryEmailAddr");
            criteria.createAlias("userSecondaryEmailAddr.usersByUserId",
                    "usersByUserId");
            criteria.add(Restrictions.eq("usersByUserId.userId", userId));
            return (UserSecondaryEmailAddr) criteria.uniqueResult();
        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }

        }
    }

}
