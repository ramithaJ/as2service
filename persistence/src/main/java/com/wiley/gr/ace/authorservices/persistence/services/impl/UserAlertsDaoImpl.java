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
import com.wiley.gr.ace.authorservices.persistence.entity.UserAlerts;
import com.wiley.gr.ace.authorservices.persistence.services.UserAlertsDao;

public class UserAlertsDaoImpl implements UserAlertsDao {
	@Autowired(required = true)
	HibernateConnection con;

	@Override
	public List<UserAlerts> getListOfAlerts(String userId) {
		Session session = con.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "from UserAlerts where id.userId = :userId";
		List<UserAlerts> result = session.createQuery(hql)
				.setString("userId", userId).list();
		session.getTransaction().commit();
		session.flush();
		session.close();

		return result;
	}

	@Override
	public boolean updateAlerts(List<UserAlerts> serviceUserAlertsList) {

		Session session = con.getSessionFactory().openSession();
		session.beginTransaction();

		for (UserAlerts userAlerts : serviceUserAlertsList) {

			UserAlerts daoUseralerts = (UserAlerts) session.load(
					UserAlerts.class, userAlerts.getId());

			daoUseralerts.setEmailFlg(userAlerts.getEmailFlg());
			daoUseralerts.setOnScreenFlg(userAlerts.getOnScreenFlg());
			session.save(daoUseralerts);

		}
		session.getTransaction().commit();
		session.flush();
		session.close();

		return true;
	}
}
