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

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;

/**
 * @author kpshiva
 *
 */
public class UserAccountDAOImpl implements UserAccountDAO {

	@Autowired(required = true)
	HibernateConnection con;
	@Autowired(required = true)
	UserLoginServiceDAO userLoginServiceDAO;

	@Override
	public AuthorProfile getEmailDetails(String userId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(AuthorProfile.class);
			criteria.add(Restrictions.eq("userId", Integer.parseInt(userId)));
			AuthorProfile userProfile = (AuthorProfile) criteria.uniqueResult();
			// System.out.println("shiva" +
			// userProfile.getSecondaryEmailAddr());
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

	/**
	 * this method is used for updating the security details in DB by using
	 * userId and security Question unique id.
	 */
	@Override
	public boolean updateSecurityDetails(Integer userId,
			ArrayList<SecurityDetails> securityDetails) {

		Session session = null;
		try {

			// it will give the unique id's of security quesitons based on
			// userId.
			List<UserSecurityDetails> security = userLoginServiceDAO
					.getSecurityQuestions(userId);
			session = con.getSessionFactory().openSession();
			for (int i = 0; i < securityDetails.size(); i++) {

				session.beginTransaction();
				Criteria criteria = session
						.createCriteria(UserSecurityDetails.class);
				criteria.add(Restrictions.eq("authorProfile.userId", userId));
				criteria.add(Restrictions.eq("userSecurityId", security.get(i)
						.getUserSecurityId()));
				UserSecurityDetails userSecurityDetails = (UserSecurityDetails) criteria
						.uniqueResult();
				if (null != userSecurityDetails) {

					userSecurityDetails.setSecurityQuestion(securityDetails
							.get(i).getSecurityQuestion());
					userSecurityDetails.setSecurityAnswer(securityDetails
							.get(i).getSecurityAnswer());
					session.saveOrUpdate(userSecurityDetails);
					session.getTransaction().commit();
				}

			}
			return true;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public boolean updateEmailDetails(String userId, String primaryEmail,
			String secondaryEmail) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String hql = "UPDATE AuthorProfile set primaryEmailAddr = :primaryEmailAddr, secondaryEmailAddr = :secondaryEmailAddr "
					+ "WHERE userId = :userId";
			Query query = session.createQuery(hql);
			query.setParameter("primaryEmailAddr", primaryEmail);
			query.setParameter("secondaryEmailAddr", secondaryEmail);
			query.setParameter("userId", Integer.parseInt(userId));
			int result = query.executeUpdate();
			transaction.commit();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}
}
