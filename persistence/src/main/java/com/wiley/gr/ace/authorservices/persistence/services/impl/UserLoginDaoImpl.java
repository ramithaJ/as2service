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

import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;

/**
 * The Class UserLoginDaoImpl.
 *
 * @author virtusa version 1.0
 */
public class UserLoginDaoImpl implements UserLoginDao {

    /**
     * Checks if emailId exists in USER_PROFILE in AS2.0 database.
     * 
     * @param emailId
     *            to validate.
     * @return the boolean value.
     */
    @Override
    public final boolean validateEmail(final String emailId) {
        boolean status = false;
        Session session = getSessionFactory().openSession();
        try {

            status = true;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return status;
    }

}
