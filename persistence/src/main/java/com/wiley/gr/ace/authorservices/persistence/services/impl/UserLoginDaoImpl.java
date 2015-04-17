package com.wiley.gr.ace.authorservices.persistence.services.usermanagement.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		session.beginTransaction();
		
		UserProfile userProfile = null;
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		
		String hql = "from UserProfile where primaryEmailAddr = :emailId";
		List<UserProfile> result = session.createQuery(hql).setString("emailId", emailId).list();
		
		if(result!=null && result.size() > 0){
			userProfile = result.get(0);
		}
		
		if(userProfile != null) {
			userProfile.setUpdatedBy("system");
			userProfile.setUpdatedDate(date);
			userProfile.setLastLoginDate(date);
		}
		
		session.saveOrUpdate(userProfile);
		
		session.getTransaction().commit();
		
		session.close();
		
		
		return true;
	}

}
