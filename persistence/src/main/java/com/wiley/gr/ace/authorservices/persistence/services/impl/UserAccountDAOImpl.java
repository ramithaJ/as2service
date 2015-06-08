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

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;

/**
 * @author virtusa
 *	version 1.0
 */
public class UserAccountDAOImpl implements UserAccountDAO {
    
    @Autowired(required = true)
    UserLoginServiceDAO userLoginServiceDAO;
    
    @Override
    public AuthorProfile getEmailDetails(String userId) {
        
        Session session = null;
        try {
            session =getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(AuthorProfile.class);
            criteria.add(Restrictions.eq("userId", Integer.parseInt(userId)));
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
    
    /**
     * this method is used for updating the security details in DB by using
     * userId and security Question unique id.
     */
    @Override
    public boolean updateSecurityDetails(Integer userId,
            List<SecurityDetails> securityDetails) {
        
        // TODO: This is not required now, security details are maintained by ALM
        return true;
    }
    
    @Override
    public boolean updateEmailDetails(String userId, String primaryEmail,
            String secondaryEmail) {
        
        Session session = null;
        Transaction transaction = null;
        try {
            session = getSessionFactory().openSession();
            transaction = session.beginTransaction();
            String hql = "UPDATE AuthorProfile set primaryEmailAddr = :primaryEmailAddr, secondaryEmailAddr = :secondaryEmailAddr "
                    + "WHERE userId = :userId";
            Query query = session.createQuery(hql);
            query.setParameter("primaryEmailAddr", primaryEmail);
            query.setParameter("secondaryEmailAddr", secondaryEmail);
            query.setParameter("userId", Integer.parseInt(userId));
            transaction.commit();
            return true;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
}
