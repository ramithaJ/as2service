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
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;

public class RegistrationServiceDAOImpl implements RegistrationServiceDAO {

	@Autowired(required = true)
	HibernateConnection con;

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

}
