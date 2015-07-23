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
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;

/**
 * The Class UserLoginServiceDAOImpl.
 *
 * @author virtusa version 1.0
 */
public class UserLoginServiceDAOImpl implements UserLoginServiceDAO {

    /**
     * The invalidEmail code.
     */
    @Value("${invalidEmail.code}")
    private String invalidEmail;

    /**
     * The invalidEmail message.
     */
    @Value("${invalidEmail.message}")
    private String invalidEmailMsg;

    /**
     * This method validates the the email Address .
     *
     * @param emailId
     *            to validate the emailId.
     * @return true, if successful.
     */
    @Override
    public final boolean validateEmailAddress(final String emailId) {

        Session session = null;
        try {

            Users user = getUserId(emailId);
            session = getSessionFactory().openSession();
            Users users = (Users) session.load(Users.class, user.getUserId());
            if (null == users) {
                return false;
            }
            return true;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * This method gets the userId.
     * 
     * @param emailId
     *            to get the userId.
     * @return the userId.
     */
    @Override
    public final Users getUserId(final String emailId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Users.class);
            criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
            Users user = (Users) criteria.uniqueResult();
            if (null == user) {
                throw new UserException(invalidEmail, invalidEmailMsg);
            }
            return user;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * This method gets the reset password log.
     * 
     * @param guid
     *            to get InviteResetpwdLog.
     * @return the InviteResetpwdLog.
     */
    @Override
    public final InviteResetpwdLog getinviteResetpwdLog(final String guid) {
        Session session = null;
        InviteResetpwdLog inviteResetpwdLog = null;
        try {

            session = getSessionFactory().openSession();
            inviteResetpwdLog = (InviteResetpwdLog) session.get(
                    InviteResetpwdLog.class, guid);

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return inviteResetpwdLog;
    }

    /**
     * This method verifying the updated emailId.
     * 
     * @param emailId
     *            to verify the updated emailId.
     * 
     */
    @Override
    public final void verifyEmailUpdate(final String emailId) {
        Session session = null;
        Users user = getUserId(emailId);
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            UserProfile authorProfile = new UserProfile();
            authorProfile = (UserProfile) session.get(UserProfile.class,
                    user.getUserId());
            authorProfile.setIsAccountVerified('Y');
            session.update(authorProfile);
            session.getTransaction().commit();
        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
    }

    /** This method will inserts a record in db */
    @Override
    public void insertGuid(InviteResetpwdLog inviteResetpwdLog) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();

            session.save(inviteResetpwdLog);
            session.getTransaction().commit();
        } finally {
            if (null != session) {
                session.flush();
                session.close();

            }

        }
    }

}
