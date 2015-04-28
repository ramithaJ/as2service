package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
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
		// UserAlerts userAlerts = null;

		String hql = "from UserAlerts where id.userId = :userId";
		List<UserAlerts> result = session.createQuery(hql)
				.setString("userId", userId).list();
		session.getTransaction().commit();
		session.flush();
		session.close();

		return result;
	}

	@Override
	public boolean updateAlerts(List<UserAlerts> userAlertsList) {

		Session session = con.getSessionFactory().openSession();
		Transaction Txn = session.beginTransaction();
		
		
		for (UserAlerts userAlerts1 : userAlertsList) {
			
	
		  for (int i = 0; i < userAlertsList.size(); i++) {
			
			{
				UserAlerts userAlerts = (UserAlerts) session.load(UserAlerts.class,userAlertsList.get(i).getId());
				
				if (userAlerts.getId().getAlertId()==userAlerts1.getAlerts().getAlertId())
				{
				userAlerts.setOnScreenFlg(userAlertsList.get(i).getOnScreenFlg());
				userAlerts.setEmailFlg(userAlertsList.get(i).getEmailFlg());
				session.save(userAlerts);
				 if ( i % 20 == 0 ) { 
				       
				        session.flush();
				        session.clear();
				
				
			}
		}

	}
		 
}
		 Txn.commit();
			session.close();

	}
		return false;
}
}
