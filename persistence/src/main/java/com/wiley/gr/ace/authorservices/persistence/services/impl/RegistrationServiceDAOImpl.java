package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;

public class RegistrationServiceDAOImpl implements RegistrationServiceDAO {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");

	@Override
	public void createUser(UserProfile userProfile) {

		Session session = con.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(userProfile);
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public List<UserProfile> getUserFromFirstNameLastName(String firstName,
			String lastName) {
		Session session = con.getSessionFactory().openSession();
		String hql = "from UserProfile uf where uf.firstName = :firstName AND uf.lastName = :lastName";
		List<UserProfile> userProfileList = session.createQuery(hql)
				.setString("firstName", firstName)
				.setString("lastName", lastName).list();

		return userProfileList;
	}

	@Override
	public List<UserProfile> getFromPrimaryEmailAddres(String emailId) {
		Session session = con.getSessionFactory().openSession();
		String hql = "from UserProfile uf where uf.primaryEmailAddr = :primaryEmailAddr";
		List<UserProfile> userProfileList = session.createQuery(hql)
				.setString("primaryEmailAddr", emailId).list();
		return userProfileList;
	}

	@Override
	public List<UserProfile> getFromSecondaryEmailAddress(String emailId) {
		Session session = con.getSessionFactory().openSession();
		String hql = "from UserProfile uf where uf.secondaryEmailAddr = :secondaryEmailAddr";
		List<UserProfile> userProfileList = session.createQuery(hql)
				.setString("secondaryEmailAddr", emailId).list();
		return userProfileList;
	}

}
