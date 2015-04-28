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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;

/**
 * @author kpshiva
 *
 */
public class UserAccountDAOImpl implements UserAccountDAO {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");

	@Override
	public UserProfile getEmailDetails(String userId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(UserProfile.class);
			criteria.add(Restrictions.eq("userId", Integer.parseInt(userId)));
			UserProfile userProfile = (UserProfile) criteria.uniqueResult();
			System.out.println("shiva" + userProfile.getSecondaryEmailAddr());
			if (null == userProfile)
				return null;
			transaction.commit();
			return userProfile;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public boolean updateEmailDetails() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateSecurityDetails() {
		// TODO Auto-generated method stub
		return false;
	}

}
