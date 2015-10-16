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

import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;

/**
 * The Class UserLoginServiceDAOImpl.
 *
 * @author virtusa version 1.0
 */
public class UserLoginServiceDAOImpl implements UserLoginServiceDAO {

    // /**
    // * The invalidEmail code.
    // */
    // @Value("${invalidEmail.code}")
    // private String invalidEmail;

    // /**
    // * The invalidEmail message.
    // */
    // @Value("${invalidEmail.message}")
    // private String invalidEmailMsg;

    // /**
    // * This method gets the userId.
    // *
    // * @param emailId
    // * to get the userId.
    // * @return the userId.
    // */
    // @Override
    // public final Users getUserId(final String emailId) {
    //
    // Session session = null;
    // try {
    // session = getSessionFactory().openSession();
    // Criteria criteria = session.createCriteria(Users.class);
    // criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
    // Users user = (Users) criteria.uniqueResult();
    // if (null == user) {
    // throw new UserException(invalidEmail, invalidEmailMsg);
    // }
    // return user;
    // } finally {
    // if (session != null) {
    // session.flush();
    // session.close();
    // }
    // }
    // }

    /**
     * This method gets the reset password log.
     * 
     * @param guid
     *            to get InviteResetpwdLog.
     * @return the InviteResetpwdLog.
     */
    /*
     * @Override public final InviteResetpwdLog getinviteResetpwdLog(final
     * String guid) { Session session = null; InviteResetpwdLog
     * inviteResetpwdLog = null; try {
     * 
     * 
     * session = getSessionFactory().openSession(); Criteria criteria =
     * session.createCriteria(InviteResetpwdLog.class);
     * criteria.add(Restrictions.eq("guid", guid)); inviteResetpwdLog =
     * (InviteResetpwdLog) criteria.uniqueResult();
     * 
     * } finally { if (session != null) { session.flush(); session.close(); } }
     */

    /*
     * return inviteResetpwdLog; }
     */
    /**
     * This method will inserts a record in db.
     *
     * @param inviteResetpwdLog
     *            the invite resetpwd log
     * @return the string
     */
    /*
     * @SuppressWarnings("unchecked")
     * 
     * @Override public final String insertGuid(final InviteResetpwdLog
     * inviteResetpwdLog) {
     * 
     * Session session = null; Integer maxValue = null; try { session =
     * getSessionFactory().openSession(); session.beginTransaction();
     * 
     * Criteria criteria = session.createCriteria(InviteResetpwdLog.class);
     * criteria.setProjection(Projections .max(AuthorServicesConstants.GUID));
     * String maxGuid = (String) criteria.uniqueResult(); maxValue =
     * (Integer.parseInt(maxGuid) + 1);
     * inviteResetpwdLog.setGuid(String.valueOf(maxValue));
     * session.save(inviteResetpwdLog); session.getTransaction().commit(); }
     * finally { if (null != session) { session.flush(); session.close(); } }
     * return maxValue.toString();
     * 
     * }
     */
    // @Override
    // public List<UserRoles> getSuperAdmins(final int roleId) {
    //
    // Session session = null;
    // try {
    // session = getSessionFactory().openSession();
    // Criteria criteria = session.createCriteria(UserRoles.class,
    // "userRoles");
    // criteria.createAlias("userRoles.roles", "roles");
    // criteria.add(Restrictions.eq("roles.roleId", roleId));
    // criteria.setFetchMode("usersByUserId", FetchMode.JOIN);
    // return criteria.list();
    // } finally {
    // if (session != null) {
    // session.flush();
    // session.close();
    // }
    // }
    /*
     * // }
     * 
     * @Override public void verifyAccountStatusUpdate(final Integer logId) {
     * Session session = null; InviteResetpwdLog inviteResetpwdLog = null; try {
     * session = getSessionFactory().openSession(); session.beginTransaction();
     * inviteResetpwdLog = (InviteResetpwdLog) session.get(
     * InviteResetpwdLog.class, logId);
     * inviteResetpwdLog.setLogId(Long.valueOf(logId)); inviteResetpwdLog
     * .setStatus(AuthorServicesConstants.INVITE_RESET_PASSWORD_STATUS_CLOSED);
     * inviteResetpwdLog
     * .setType(AuthorServicesConstants.INVITE_RESET_PASSWORD_STATUS_TYPE_VERIFIED
     * ); session.update(inviteResetpwdLog); session.getTransaction().commit();
     * 
     * } finally { if (null != session) { session.flush(); session.close(); } }
     * 
     * }
     */
    @Override
    public void updateIsAccountActive(final Integer userId) {
        Session session = null;
        // UserProfile userProfile = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            // userProfile = (UserProfile) session.get(UserProfile.class,
            // userId);
            // userProfile.setIsAccountActive('1');
            session.getTransaction().commit();

        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }

    }

}
