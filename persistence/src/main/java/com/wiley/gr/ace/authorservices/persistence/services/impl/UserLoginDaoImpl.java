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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;

/**
 * @author RAVISINHA
 *
 */
public class UserLoginDaoImpl implements UserLoginDao {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");

	@Override
	public boolean validateEmail(String emailId) {
		boolean status = false;
		Session session = con.getSessionFactory().openSession();

		String hql = "from Users where emailAddr = :emailId";
		List<Users> result = session.createQuery(hql)
				.setString("emailId", emailId).list();

		if (result != null && result.size() > 0) {

			status = true;
		}
		return status;
	}

	@Override
	public boolean doLogin(String emailId) {
//		boolean status = false;
		Session session = con.getSessionFactory().openSession();
		session.beginTransaction();

		AuthorProfile authorProfile = null;

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		int userId = getUserId(emailId);
		
		String hql = "from AuthorProfile where userId = :userId";
		List<AuthorProfile> result = session.createQuery(hql)
				.setString("emailId", emailId).list();

		if (result != null && result.size() > 0) {
			authorProfile = result.get(0);
		}

		if (authorProfile != null) {
			authorProfile.setUpdatedBy("system");
			authorProfile.setUpdatedDate(date);
			authorProfile.setLastLoginDate(date);
		}

		session.saveOrUpdate(authorProfile);

		session.getTransaction().commit();

		session.close();

		return true;
	}
	
	/**
	 * Method to get UserId using emailId
	 * @param emailId
	 * @return
	 */
	private int getUserId(String emailId) {
		
		Session session = con.getSessionFactory().openSession();
		Users user = null;
		int userId = 0;

		String hql = "from Users where emailAddr = :emailId";
		List<Users> result = session.createQuery(hql)
				.setString("emailId", emailId).list();

		if (result != null && result.size() > 0) {
			
			user = result.get(0);
			userId = user.getUserId();
		}
		
		return userId;
		
	}

}
