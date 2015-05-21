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
 ******************************************************************************/
/**
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO;

/**
 * @author vkumark
 */
public class UpdateUserDAOImpl implements UpdateUserDAO {
    
    /*
     * @Autowired(required = true) HibernateConnection con;
     */
    
    /*
     * (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO#
     * updateUserWithOrcid(com.wiley.gr.ace.authorservices.model.User)
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UpdateUserDAOImpl.class);
    
    @Override
    public User updateUserWithOrcid(User user) throws Exception {
        /**
         * Create hibernate session
         */
        Session session = HibernateConnection.getSessionFactory().openSession();
        Transaction getTxn = null;
        Transaction updateTxn = null;
        try {
            
            if (user != null) {
                /**
                 * Fetch user profile with user Id
                 */
                getTxn = session.beginTransaction();
                Users userEntity = (Users) session.load(Users.class,
                        user.getUserId());
                getTxn.commit();
                
                /**
                 * Update profile with ORCID details
                 */
                // userEntity.setEmailAddr(user.getPrimaryEmailAddr());
                updateTxn = session.beginTransaction();
                session.update(userEntity);
                updateTxn.commit();
                
                // user.setPrimaryEmailAddr(userEntity.getEmailAddr());
            } else {
                user = null;
            }
        } catch (Exception e) {
            if (updateTxn != null)
                updateTxn.rollback();
            user = null;
            LOGGER.error("Stack Trace- .", e);
            throw new Exception();
        } finally {
            session.close();
        }
        return user;
    }
    
    @Override
    public String updateUserOrcidId(String orcidId, String userId)
            throws Exception {
        
        String status = "";
        /**
         * Create hibernate session
         */
        Session session = HibernateConnection.getSessionFactory().openSession();
        Transaction txn = session.beginTransaction();
        try {
            /**
             * This block of code will be work now as Author_profile does not
             * have Orcid ID. But will be added as per new design.
             */
            String hql = "UPDATE AuthorProfile set orcid = :orcidId "
                    + "WHERE userId = :userId";
            Query query = session.createQuery(hql);
            query.setParameter("orcidId", orcidId);
            query.setParameter("userId", userId);
            
            int result = query.executeUpdate();
            LOGGER.info("Rows affected: ", result);
            if (result == 1) {
                status = "success";
                txn.commit();
            } else {
                status = "failure";
                txn.rollback();
            }
        } catch (Exception e) {
            txn.rollback();
            status = "";
            LOGGER.error("Print Stack Trace- ", e);
            throw new Exception();
        } finally {
            session.close();
        }
        return status;
    }
    
}
