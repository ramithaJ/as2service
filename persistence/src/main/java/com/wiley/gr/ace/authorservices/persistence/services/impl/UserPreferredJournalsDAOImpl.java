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

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.UserPreferredJournals;
import com.wiley.gr.ace.authorservices.persistence.services.UserPreferredJournalsDAO;

public class UserPreferredJournalsDAOImpl implements UserPreferredJournalsDAO {

	@Autowired(required = true)
	HibernateConnection con;

	@Override
	public List<UserPreferredJournals> getPreferredJournals(String userId) {

		Session session = con.getSessionFactory().openSession();

		List<UserPreferredJournals> userPreferredJournals = null;
		try {
			String hql = "from UserPreferredJournals where id.userId = :userId";

			userPreferredJournals = session.createQuery(hql)
					.setString("userId", userId).list();

		} finally {
			if (null != session)

				session.flush();
			session.close();

		}

		return userPreferredJournals;

	}

}
