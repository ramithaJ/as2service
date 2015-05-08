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

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;

/**
 * @author kpshiva
 *
 */
public class UserAccountDAOImpl implements UserAccountDAO {

	@Autowired(required = true)
	HibernateConnection con;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO#
	 * getEmailDetails(java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO#
	 * updateSecurityDetails(java.lang.Integer,
	 * com.wiley.gr.ace.authorservices.model.Security)
	 */
	@Override
	public boolean updateSecurityDetails(Integer userId,
			Security securityDetails) {

		Session session = null;
		Transaction transaction = null;
		try {

			Security security = getSecurityIDs(userId);
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();

			String hql = "UPDATE UserSecurityDetails set securityQuestion = :securityQuestion, securityAnswer = :securityAnswer "
					+ "WHERE authorProfile.userId = :userId and userSecurityId = :userSecurityId";
			Query query = session.createQuery(hql);
			query.setParameter("securityQuestion",
					securityDetails.getSecurityQuestion1());
			query.setParameter("securityAnswer",
					securityDetails.getSecurityAnswer1());
			query.setParameter("userId", userId);
			query.setParameter("userSecurityId", security.getId1());
			int result = query.executeUpdate();

			String hql2 = "UPDATE UserSecurityDetails set securityQuestion = :securityQuestion, securityAnswer = :securityAnswer "
					+ "WHERE authorProfile.userId = :userId and userSecurityId = :userSecurityId";
			Query query2 = session.createQuery(hql2);
			query2.setParameter("securityQuestion",
					securityDetails.getSecurityQuestion2());
			query2.setParameter("securityAnswer",
					securityDetails.getSecurityAnswer2());
			query2.setParameter("userId", userId);
			query2.setParameter("userSecurityId", security.getId2());
			int results = query2.executeUpdate();
			transaction.commit();

			if (result == 1 && results == 1) {
				return true;
			} else {
				throw new ASException("1018",
						"update unsuccessful please try again");
			}

		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO#
	 * updateEmailDetails(java.lang.String, java.lang.String, java.lang.String)
	 */
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO#
	 * getSecurityIDs(int)
	 */
	@Override
	public Security getSecurityIDs(int userId) {

		Session session = null;
		Transaction transaction = null;
		Security security = new Security();
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(
					UserSecurityDetails.class, "userSecurityDetails");
			criteria.createAlias("userSecurityDetails.authorProfile",
					"authorProfile");
			criteria.add(Restrictions.eq("authorProfile.userId", userId));
			List<UserSecurityDetails> userSecurityDetails = criteria.list();
			security.setId1(userSecurityDetails.get(0).getUserSecurityId());
			security.setId2(userSecurityDetails.get(1).getUserSecurityId());
			transaction.commit();
			return security;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}

	}
}
