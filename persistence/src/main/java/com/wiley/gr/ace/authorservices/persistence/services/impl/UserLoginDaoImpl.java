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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.persistence.entity.AdminProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserRoles;
import com.wiley.gr.ace.authorservices.persistence.entity.UserRolesId;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
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
        int userId = getUserId(emailId);
        System.err.println(userId);
        if (userId == 0) {
            return status;
        }
        Session session = getSessionFactory().openSession();
        try {
            AdminProfile adminDetails = (AdminProfile) session.get(
                    AdminProfile.class, userId);
            if (null != adminDetails) {

                status = true;
            }
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return status;
    }

    /**
     * Updates the LAST_LOGIN_TIME, UPDATED_BY, UPDATED_DATE columns of
     * USER_PROFILE table.
     * 
     * @param emailId
     *            to Login.
     * @return the boolean value.
     */
    @Override
    public final boolean doLogin(final String emailId) {
        Session session = getSessionFactory().openSession();

        UserProfile authorProfile = null;

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        String utildate = dateFormat.format(date);

        java.sql.Date.valueOf(utildate);
        int userId = getUserId(emailId);
        try {
            String hql = "from AuthorProfile where userId = :userId";
            List<UserProfile> result = session.createQuery(hql)
                    .setInteger("userId", userId).list();

            if (null != result && !result.isEmpty()) {
                authorProfile = result.get(0);
            }
            if (authorProfile != null) {
                Users users = new Users();
                users.setUserId(userId);
                authorProfile.setUsersByUpdatedBy(users);
                authorProfile.setUpdatedDate(date);
            }
            session.saveOrUpdate(authorProfile);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return true;
    }

    /**
     * Method to get UserId using emailId.
     * 
     * @param emailId
     *            to get userId.
     * @return the Integer value.
     */
    private final int getUserId(final String emailId) {

        Session session = getSessionFactory().openSession();
        Users user = null;
        int userId = 0;
        try {
            String hql = "from Users where primaryEmailAddr = :emailId";
            List<Users> result = session.createQuery(hql)
                    .setString("emailId", emailId).list();

            if (result != null && !result.isEmpty()) {

                user = result.get(0);
                userId = user.getUserId();
            }

        } finally {

            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return userId;

    }

    /**
     * This method creates admin user in database.
     * 
     * @param users
     *            to create Admin User.
     * @param userRolesList
     *            to create Admin User.
     */
    @Override
    public final void createAdminUser(final Users users,
            final List<UserRoles> userRolesList) {

        Session session = null;

        Date date = new Date();

        try {

            if (getUserId(users.getPrimaryEmailAddr()) != 0) {
                throw new ASException("1020", "User already exists.");
            } else {

                session = getSessionFactory().openSession();
                Transaction txn = session.getTransaction();
                txn.begin();
                session.save(users);

                txn.commit();
                txn = session.getTransaction();
                txn.begin();

                AdminProfile adminDetails = new AdminProfile();
                adminDetails.setAdminUserId(users.getUserId());
                adminDetails.setCreatedDate(date);
                adminDetails.setUsersByCreatedBy(users);
                adminDetails.setUsersByUserId(users);

                session.save(adminDetails);

                txn.commit();
                txn = session.getTransaction();
                txn.begin();

                // int adminRoleId = getAdminRoleId();
                UserRoles userRoles = new UserRoles();
                UserRolesId userRolesId = new UserRolesId();
                userRolesId.setRoleId(AuthorServicesConstants.ROLEID);
                userRolesId.setUserId(users.getUserId());
                userRoles.setId(userRolesId);
                userRoles.setCreatedDate(date);

                session.save(userRoles);

                txn.commit();
            }

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * This method gets the User Details.
     * 
     * @param emailId
     *            to get the User Details.
     * @return the Users.
     */
    @Override
    public final Users getUserDetails(final String emailId) {

        Session session = getSessionFactory().openSession();
        Users user = null;
        try {
            String hql = "from Users where primaryEmailAddr = :emailId";
            List<Users> result = session.createQuery(hql)
                    .setString("emailId", emailId).list();
            if (result != null && !result.isEmpty()) {
                user = result.get(0);
            }

        } finally {

            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return user;
    }

    /**
     * @return
     */
    /*
     * private int getAdminRoleId() {
     * 
     * Session session = con.getSessionFactory().openSession(); int roleId = 0;
     * Roles daoRoles = null;
     * 
     * session = con.getSessionFactory().openSession();
     * 
     * String hql = "from Roles where role_name = :roleName"; List<Roles> result
     * = session.createQuery(hql) .setString("roleName", "AOS Admin").list();
     * 
     * if (result != null && result.isEmpty()) {
     * 
     * daoRoles = result.get(0); roleId = daoRoles.getRoleId(); }
     * 
     * session.flush(); session.close();
     * 
     * return roleId; }
     */

}
