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

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSocietyDetails;
import com.wiley.gr.ace.authorservices.persistence.services.SocietyDetailsDao;

/**
 * @author RAVISINHA
 *
 */
public class SocietyDetailsDaoImpl implements SocietyDetailsDao {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wiley.gr.ace.authorservices.persistence.services.SocietyDetailsDao
	 * #getSocietiesForUser()
	 */

	@Autowired(required = true)
	HibernateConnection con;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wiley.gr.ace.authorservices.persistence.services.SocietyDetailsDao
	 * #getSocietiesForUser(java.lang.String)
	 */
	@Override
	public List<UserSocietyDetails> getSocietiesForUser(String userId) {
		Session session = con.getSessionFactory().openSession();

		session.beginTransaction();
		List<UserSocietyDetails> userSocietyDetails = null;
		try {
			String hql = "from UserSocietyDetails usd where usd.authorProfile.userId = :userId";

			userSocietyDetails = session.createQuery(hql)
					.setString("userId", userId).list();
			if (userSocietyDetails.size() == 0) {

				throw new ASException("1914",
						"Requested User id Doesn't exist please contact Support team");
			}

		} finally {
			if (null != session)
				session.getTransaction().commit();
			session.flush();
			session.close();

		}

		return userSocietyDetails;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wiley.gr.ace.authorservices.persistence.services.SocietyDetailsDao
	 * #deleteSociety(java.lang.String, java.lang.String)
	 */
	@Override
	public boolean deleteSociety(String userId, String societyId) {

		Session session = con.getSessionFactory().openSession();

		session.beginTransaction();
		try {
			String hql = "delete from UserSocietyDetails where authorProfile.userId=:userId and societyId = :societyId";
			Query query = session.createQuery(hql);
			query.setString("userId", userId);
			query.setString("societyId", societyId);
			int count = query.executeUpdate();

			if (count == 0) {

				throw new ASException("45345",
						"Delete Record Failed please Check With Support Team");
			}
		}

		finally {
			if (null != session)

				session.flush();
			session.getTransaction().commit();
			session.close();

		}

		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wiley.gr.ace.authorservices.persistence.services.SocietyDetailsDao
	 * #updateSociety(java.lang.String,
	 * com.wiley.gr.ace.authorservices.model.Society)
	 */
	@Override
	public void updateSociety(UserSocietyDetails userSocietyDetails) {
		Session session = con.getSessionFactory().openSession();
		session.beginTransaction();
		try {

			session.saveOrUpdate(userSocietyDetails);

		} finally {
			if (null != session)
				session.flush();
			session.getTransaction().commit();
			session.close();

		}

	}
}
