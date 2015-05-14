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

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.DashBoardDAO;

/**
 * @author Virtusa
 *
 */
public class DashBoardDAOImpl implements DashBoardDAO {
	
	/** HibernateConnection . */
	@Autowired(required = true)
	private HibernateConnection con;
	
	/** The Session . */
	private Session session = null;
	
	/** The Transaction . */
	private Transaction txn = null;

	/**
	 * @param userId
	 *            to extract the data from Database
	 * @return secureResultList
	 */
	public final List<UserSecurityDetails> getSecurityDetailsList(
			final int userId) {
		try {
			session = con.getSessionFactory().openSession();
			txn = session.beginTransaction();
			String secureDetailsHql = "from UserSecurityDetails where authorProfile.userId=:userId";
			List<UserSecurityDetails> secureResultList = session
					.createQuery(secureDetailsHql).setInteger("userId", userId)
					.list();
			txn.commit();
			return secureResultList;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}
	/**
	 * @param userId
	 *            to extract the data from Database
	 * @return userFunderGrants
	 */
	public final UserFunderGrants getFundersDetails(final int userId) {
		try {
			session = HibernateConnection.getSessionFactory().openSession();
			txn = session.beginTransaction();
			String userFunderGrantsHql = "from UserFunderGrants where id.userId=:userId";
			UserFunderGrants userFunderGrants = (UserFunderGrants) session
					.createQuery(userFunderGrantsHql)
					.setInteger("userId", userId).uniqueResult();
			txn.commit();
			return userFunderGrants;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	/**
	 * @param userId
	 *            to extract the data from Database
	 * @return AuthorProfile
	 */
	public final AuthorProfile getMissedUserProfile(final int userId) {
		try {
			session = HibernateConnection.getSessionFactory().openSession();
			txn = session.beginTransaction();
			String profileHql = "select isAccountVerified from AuthorProfile where userId=:userId";
			Character isAccountVerified = (Character) session
					.createQuery(profileHql).setInteger("userId", userId)
					.uniqueResult();
			AuthorProfile authorProfile = new AuthorProfile();
			authorProfile.setIsAccountVerified(isAccountVerified);
			txn.commit();
			return authorProfile;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}
}
