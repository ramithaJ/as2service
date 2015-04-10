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

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void shutDownSessionFactory() {
		sessionFactory.close();
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
