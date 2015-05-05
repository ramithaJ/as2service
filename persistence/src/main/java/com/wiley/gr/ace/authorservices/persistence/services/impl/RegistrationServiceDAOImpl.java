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
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;

public class RegistrationServiceDAOImpl implements RegistrationServiceDAO {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");

	@Override
	public void createUser(AuthorProfile userProfile) {

		Session session = con.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(userProfile);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<AuthorProfile> getUserFromFirstNameLastName(String firstName,
			String lastName) {
		Session session = con.getSessionFactory().openSession();
		String hql = "from AuthorProfile uf where uf.firstName = :firstName AND uf.lastName = :lastName";
		List<AuthorProfile> userProfileList = session.createQuery(hql)
				.setString("firstName", firstName)
				.setString("lastName", lastName).list();

		return userProfileList;
	}

	@Override
	public List<AuthorProfile> getFromPrimaryEmailAddres(String emailId) {
		Session session = con.getSessionFactory().openSession();
		String hql = "from AuthorProfile uf where uf.primaryEmailAddr = :primaryEmailAddr";
		List<AuthorProfile> userProfileList = session.createQuery(hql)
				.setString("primaryEmailAddr", emailId).list();
		return userProfileList;
	}

	@Override
	public List<AuthorProfile> getFromSecondaryEmailAddress(String emailId) {
		Session session = con.getSessionFactory().openSession();
		String hql = "from AuthorProfile uf where uf.secondaryEmailAddr = :secondaryEmailAddr";
		List<AuthorProfile> userProfileList = session.createQuery(hql)
				.setString("secondaryEmailAddr", emailId).list();
		return userProfileList;
	}

}
