package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserAlerts;
import com.wiley.gr.ace.authorservices.persistence.services.UserAlertsDao;

public class UserAlertsDaoImpl implements UserAlertsDao {
	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");

	@Override
	public List<UserAlerts> getListOfAlerts(String userId) {
		Session session = con.getSessionFactory().openSession();
		session.beginTransaction();
		UserAlerts userAlerts = null;

		String hql = "from UserAlerts where id.userId = :userId";
		List<UserAlerts> result = session.createQuery(hql)
				.setString("userId", userId).list();

		// session.saveOrUpdate(userAlerts);

		session.getTransaction().commit();
		session.flush();
		session.close();

		return result;
	}
}
