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

	/* (non-Javadoc)
	 * @see com.wiley.gr.ace.authorservices.persistence.services.SocietyDetailsDao#getSocietiesForUser(java.lang.String)
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
			if (userSocietyDetails.size()==0) {
				
				throw new ASException( "1914" ,"Requested User id Doesn't exist please contact Support team");
			}

		} finally {
			if (null != session)
				session.getTransaction().commit();
			session.flush();
			session.close();

		}

		return userSocietyDetails;
	}

}
