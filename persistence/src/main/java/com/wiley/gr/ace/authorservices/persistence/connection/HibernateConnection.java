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
package com.wiley.gr.ace.authorservices.persistence.connection;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateConnection {

	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			Configuration configuration = new Configuration().configure();
			StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
					.applySettings(configuration.getProperties());
			System.out.println("Hibernate Configuration loaded");

			return configuration.buildSessionFactory(builder.build());
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void shutDownSessionFactory() {
		getSessionFactory().close();
	}

	/*
	 * public static void main(String args[]) { Session session =
	 * sessionFactory.openSession(); List<UserProfile> up =
	 * session.createCriteria
	 * (UserProfile.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY
	 * ).list(); System.out.println("&&&&&&&&&& "+up.get(0).getFirstName());
	 * System.out.println("&&&&&&&&&& "+up.get(0).getLastName());
	 * session.close();
	 * 
	 * }
	 */

}
