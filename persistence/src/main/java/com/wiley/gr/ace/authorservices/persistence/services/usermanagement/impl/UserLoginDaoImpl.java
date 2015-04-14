package com.wiley.gr.ace.authorservices.persistence.services.usermanagement.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.services.usermanagement.UserLoginDao;

public class UserLoginDaoImpl implements UserLoginDao {
	
	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");

	@Override
	public boolean validateEmail(String emailId) {
		boolean status=false;
		Session session = con.getSessionFactory().openSession();
		
//		List<UserProfile> upList = session.createCriteria(UserProfile.class)
//				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
//		
		String hql = "from UserProfile where primaryEmailAddr = :emailId";
		List<UserProfile> result = session.createQuery(hql).setString("emailId", emailId).list();
	
		if(result!=null && result.size() > 0){  
		   
			status = true;  
		} 
		return status;
	}

	@Override
	public boolean doLogin(String emailId) {
		boolean status=false;
		Session session = con.getSessionFactory().openSession();
		return status;
	}

}
