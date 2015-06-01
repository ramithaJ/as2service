/*
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 */
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;

/**
 * @author kpshiva
 */
public class UserLoginServiceDAOImpl implements UserLoginServiceDAO {
    
    @Autowired(required = true)
    HibernateConnection con;
    
    @Value("${invalidEmail.code}")
    private String invalidEmail;
    
    @Value("${invalidEmail.message}")
    private String invalidEmailMsg;
    
    private static final String USERID = "userId";
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO
     * #getUsersList()
     */
    @Override
    public List<AuthorProfile> getUsersList() {
        
        Session session = null;
        Transaction transaction = null;
        try {
            session = con.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            List<AuthorProfile> upList = session
                    .createCriteria(AuthorProfile.class)
                    .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
            transaction.commit();
            return upList;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO
     * #validateEmailAddress(java.lang.String)
     */
    @Override
    public boolean validateEmailAddress(String emailId) {
        
        Session session = null;
        try {
            session = con.getSessionFactory().openSession();
            boolean status = false;
            int userId = getUserId(emailId);
            if (userId == 0) {
                throw new ASException(invalidEmail, invalidEmailMsg);
            }
            Users users = (Users) session.load(Users.class, userId);
            if (users != null) {
                status = true;
            }
            return status;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO
     * #checkSecuritySetup(int)
     */
    @Override
    public boolean checkSecuritySetup(int userId) {
        
        Session session = null;
        try {
            session = con.getSessionFactory().openSession();
            boolean isSecure = false;
            Criteria criteria = session.createCriteria(AuthorProfile.class);
            criteria.add(Restrictions.eq(USERID, userId));
            AuthorProfile userProfile = (AuthorProfile) criteria.uniqueResult();
            if (null == userProfile) {
                return isSecure;
            }
            // TODO: This method is not required now.
            /*if (userProfile.getSecurityQuestFlg() == 'Y') {
                isSecure = true;
                return isSecure;
            } */
            return isSecure;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO
     * #doLogin(int, java.lang.String)
     */
    @Override
    public void doLogin(int userId) {
        
        Session session = null;
        Transaction transaction = null;
        try {
            session = con.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Date date = new Date();
            
            Users users = (Users) session.load(Users.class, userId);
            
            users.setLastLoginDate(date);
            users.setUsersByUpdatedBy(users);
            users.setUpdatedDate(date);
            Users updateByUser = new Users();
            updateByUser.setUserId(userId);
            users.setUsersByUpdatedBy(updateByUser);
            
            session.update(users);
            transaction.commit();
            
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO
     * #isUserLocked(int)
     */
    @Override
    public boolean isUserLocked(int userId) {
        
        Session session = null;
        boolean isLocked = false;
        try {
            session = con.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Users.class);
            criteria.add(Restrictions.eq(USERID, userId));
            Users users = (Users) criteria.uniqueResult();
            if(users != null && users.getAccountLockedTime() != null) {
                isLocked = true;
            }
            
            return isLocked;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO
     * #getUserId(java.lang.String)
     */
    @Override
    public Integer getUserId(String emailId) {
        
        Session session = null;
        int userId = 0;
        try {
            session = con.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Users.class);
            criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
            Users user = (Users) criteria.uniqueResult();
            if (user != null) {
                userId = user.getUserId();
            }
            return userId;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO
     * #getCount(int)
     */
    @Override
    public int getCount(int userId) {
        
        Session session = null;
        try {
            session = con.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Users.class);
            criteria.add(Restrictions.eq(USERID, userId));
            Users user = (Users) criteria.uniqueResult();
            return user.getInvalidLoginCnt();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO
     * #updateCount(int, int)
     */
    @Override
    public boolean updateCount(int count, int userId) {
        
        Session session = null;
        Transaction transaction = null;
        try {
            session = con.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Users users = (Users) session.load(Users.class, userId);
            users.setInvalidLoginCnt(count);
            Users updateByUser = new Users();
            updateByUser.setUserId(userId);
            users.setUsersByUpdatedBy(updateByUser);
            session.saveOrUpdate(users);
            transaction.commit();
            return true;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO
     * #getLockedTime(int)
     */
    @Override
    public Date getLockedTime(int userId) {
        
        Session session = null;
        try {
            session = con.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Users.class);
            criteria.add(Restrictions.eq(USERID, userId));
            Users user = (Users) criteria.uniqueResult();
            return user.getAccountLockedTime();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO
     * #unLockUser(int)
     */
    @Override
    public void unLockUser(int userId) {
        
        Session session = null;
        Transaction transaction = null;
        try {
            session = con.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Users users = (Users) session.load(Users.class, userId);
            users.setAccountLockedTime(null);
            users.setInvalidLoginCnt(0);
            Users updateByUser = new Users();
            updateByUser.setUserId(userId);
            users.setUsersByUpdatedBy(updateByUser);
            session.saveOrUpdate(users);
            transaction.commit();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
    
    @Override
    public AuthorProfile authorProfile(int userId) {
        
        Session session = null;
        try {
            session = con.getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(AuthorProfile.class);
            criteria.add(Restrictions.eq(USERID, userId));
            AuthorProfile userProfile = (AuthorProfile) criteria.uniqueResult();
            if (null == userProfile) {
                return null;
            }
            return userProfile;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
    
}
