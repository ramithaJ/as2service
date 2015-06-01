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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.AdminDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserRoles;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;

/**
 * @author RAVISINHA
 */
public class UserLoginDaoImpl implements UserLoginDao {
    
    @Autowired(required = true)
    HibernateConnection con;
    
    @Override
    public boolean validateEmail(String emailId) {
        boolean status = false;
        int userId = getUserId(emailId);
        
        Session session = con.getSessionFactory().openSession();
        Transaction txn = session.getTransaction();
        txn.begin();
        
        AdminDetails adminDetails = (AdminDetails) session.load(
                AdminDetails.class, userId);
        
        if (null != adminDetails) {
            
            status = true;
        }
        txn.commit();
        session.flush();
        
        session.close();
        return status;
    }
    
    @Override
    public boolean doLogin(String emailId) {
        Session session = con.getSessionFactory().openSession();
        
        AuthorProfile authorProfile = null;
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        
        String utildate = dateFormat.format(date);
        
        java.sql.Date.valueOf(utildate);
        int userId = getUserId(emailId);
        
        String hql = "from AuthorProfile where userId = :userId";
        List<AuthorProfile> result = session.createQuery(hql)
                .setInteger("userId", userId).list();
        
        if (null != result && result.isEmpty()) {
            authorProfile = result.get(0);
        }
        
        if (authorProfile != null) {
            Users users = new Users();
            users.setUserId(userId);
            authorProfile.setUsersByUpdatedBy(users);
            authorProfile.setUpdatedDate(date);
        }
        
        session.saveOrUpdate(authorProfile);
        session.flush();
        
        session.close();
        
        return true;
    }
    
    /**
     * Method to get UserId using emailId
     * 
     * @param emailId
     * @return
     */
    private int getUserId(String emailId) {
        
        Session session = con.getSessionFactory().openSession();
        Users user = null;
        int userId = 0;
        
        String hql = "from Users where primaryEmailAddr = :emailId";
        List<Users> result = session.createQuery(hql)
                .setString("emailId", emailId).list();
        
        if (result != null && result.isEmpty()) {
            
            user = result.get(0);
            userId = user.getUserId();
        }
        
        session.flush();
        session.close();
        
        return userId;
        
    }
    
    @Override
    public void createAdminUser(Users users, List<UserRoles> userRolesList) {
        
        Session session = null;
        
        try {
            session = con.getSessionFactory().openSession();
            session.saveOrUpdate(users);
            AdminDetails adminDetails = new AdminDetails();
            adminDetails.setAdminUserId(users.getUserId());
            
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
    
}
