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
import com.wiley.gr.ace.authorservices.persistence.entity.UserAffiliations;
import com.wiley.gr.ace.authorservices.persistence.entity.UserAreaOfInterest;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSocietyDetails;
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
	 * @return userFunderGrants
	 */
	public List<UserFunderGrants> getFundersDetailsList(int userId) throws Exception {
		try {
			session = con.getSessionFactory().openSession();
			txn = session.beginTransaction();
			String userFunderGrantsHql = "from UserFunderGrants where id.userId=:userId";
			List<UserFunderGrants> userFunderGrantsList = session
					.createQuery(userFunderGrantsHql)
					.setInteger("userId", userId).list();
			txn.commit();
			return userFunderGrantsList;
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
	public List<AuthorProfile> getMissedUserProfileList(int userId) throws Exception {
		try {
			session = con.getSessionFactory().openSession();
			txn = session.beginTransaction();
			String profileHql = "from AuthorProfile ap where ap.userId=:userId";
			List<AuthorProfile> authorProfileList=session
					.createQuery(profileHql).setInteger("userId", userId)
					.list();
			System.err.println("=============="+authorProfileList.get(0).getOrcidId());
			txn.commit();
			return authorProfileList;
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
	 * @return secureResultList
	 */
	public List<UserSocietyDetails> getSocietyDetailsList(int userId) throws Exception{
		try {
			session = con.getSessionFactory().openSession();
			txn = session.beginTransaction();
			String societyDetailsHql = "from UserSocietyDetails usd where usd.authorProfile.userId = :userId";
			List<UserSocietyDetails> societyResultList = session
					.createQuery(societyDetailsHql).setInteger("userId", userId)
					.list();
			txn.commit();
			return societyResultList;
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
	 * @return userAffiliationsList
	 */
	public List<UserAffiliations> getUserAffiliationsList(int userId) throws Exception{
		try{
		session = con.getSessionFactory().openSession();
		txn = session.beginTransaction();
		String userAffiliationsHql = "from UserAffiliations ua where ua.authorProfile.userId = :userId";
		List<UserAffiliations> userAffiliationsList = session
				.createQuery(userAffiliationsHql).setInteger("userId", userId)
				.list();
		System.err.println("================"+userAffiliationsList.size());
		txn.commit();
		return userAffiliationsList;
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
	 * @return userAreaOfInterestList
	 */
	public List<UserAreaOfInterest> getUserAreaOfInterestsList(int userId) throws Exception {
		try {
			session = con.getSessionFactory().openSession();
			txn = session.beginTransaction();
			String userAreaOfInterestHql = "from UserAreaOfInterest where id.userId=:userId";
			List<UserAreaOfInterest> userAreaOfInterestList = session
					.createQuery(userAreaOfInterestHql)
					.setInteger("userId", userId).list();
			txn.commit();
			return userAreaOfInterestList;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}
}
