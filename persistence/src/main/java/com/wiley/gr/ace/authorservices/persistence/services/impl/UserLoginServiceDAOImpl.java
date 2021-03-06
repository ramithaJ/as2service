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

import org.hibernate.Session;

import com.wiley.gr.ace.authorservices.persistence.entity.ResetPasswd;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;

/**
 * The Class UserLoginServiceDAOImpl.
 *
 * @author virtusa version 1.0
 */
public class UserLoginServiceDAOImpl implements UserLoginServiceDAO {

    /**
     * Update is account active.
     *
     * @param userId
     *            the user id
     */
    @Override
    public void updateIsAccountActive(final Integer userId) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.getTransaction().commit();

        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * Insert guid.
     *
     * @param resetPasswd
     *            the reset passwd
     * @return the string
     */
    @Override
    public String insertGuid(final ResetPasswd resetPasswd) {
        Session session = null;
        Long id = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            id = (Long) session.save(resetPasswd);
            session.getTransaction().commit();

        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
        return id.toString();
    }

}
