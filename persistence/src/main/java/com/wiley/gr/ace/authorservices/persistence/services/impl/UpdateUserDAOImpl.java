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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO;

/**
 * @author vkumark
 *
 */
public class UpdateUserDAOImpl implements UpdateUserDAO {
	
	private static ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceBeanConfig.class);
	private static HibernateConnection con = (HibernateConnection) context.getBean("HibernateConnection");
	
	/* (non-Javadoc)
	 * @see com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO#updateUserWithOrcid(com.wiley.gr.ace.authorservices.model.User)
	 */
	@Override
	public User updateUserWithOrcid(User user) throws Exception{
		/**
		 * Create hibernate session 
		 */
		Session session = con.getSessionFactory().openSession();
		try {
			
			if(user!=null){
				/**
				 * Fetch user profile with user Id
				 */
				Transaction getTxn = session.beginTransaction();
				Users userEntity = (Users)session.load(Users.class, user.getUserId());
				getTxn.commit();
				
				/**
				 * Update profile with ORCID details
				 */
				userEntity.setEmailAddr(user.getPrimaryEmailAddr());
				Transaction updateTxn = session.beginTransaction();
				session.update(userEntity);
				updateTxn.commit();
				
				user.setPrimaryEmailAddr(userEntity.getEmailAddr());
			}else {
				user = null;
			}
		} catch (Exception e) {
			user = null;
			e.printStackTrace();
			throw new Exception();
		}
		finally{
			session.close();
		}
		return user;
	}

}
