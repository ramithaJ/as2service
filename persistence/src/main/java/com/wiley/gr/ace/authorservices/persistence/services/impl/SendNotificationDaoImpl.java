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

import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.SendNotificationDao;

/**
 * The Class SendNotificationDaoImpl.
 */
public class SendNotificationDaoImpl implements SendNotificationDao {

    /**
     * this method will take
     * 
     * @param userId
     * @return users
     * */
    @Override
    public Users getUserProfile(Integer userId) {
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

    /**
     * this method will take
     * 
     * @param userId
     * @return users
     * */
    @Override
    public Users getUserProfileByEmail(String emailId) {
        Session session = null;
        Users users = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Users.class);
            criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
            users = (Users) criteria.uniqueResult();
        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }

        }

        return users;
    }

    /**
     * The main method.
     *
     * @param args
     *            the arguments
     */
    public static void main(String[] args) {
        SendNotificationDaoImpl sendNotificationDaoImpl = new SendNotificationDaoImpl();
        sendNotificationDaoImpl.getUserProfileByEmail("alley9020@temp.com");
    }
}
