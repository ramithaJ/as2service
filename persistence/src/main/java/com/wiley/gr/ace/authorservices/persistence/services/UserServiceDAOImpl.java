package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;

public class UserServiceDAOImpl implements UserServiceDAO {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");

	@Override
	public List<UserProfile> getUsersList() {

		Session session = con.getSessionFactory().openSession();
		List<UserProfile> upList = session.createCriteria(UserProfile.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.close();
		return upList;
	}

}
