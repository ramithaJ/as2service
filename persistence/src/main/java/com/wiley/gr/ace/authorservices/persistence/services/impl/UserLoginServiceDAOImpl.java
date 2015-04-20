package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;

/**
 * @author kpshiva
 */
public class UserLoginServiceDAOImpl implements UserLoginServiceDAO {

	private static final String YES = "Y";

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");

	@Override
	public List<UserProfile> getUsersList() {

		Session session = null;
	    Transaction transaction = null;
		try{
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			List<UserProfile> upList = session.createCriteria(UserProfile.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			session.flush();
			transaction.commit();
			return upList;
		}
		finally{
			if(session==null)
				session.close();
		}		
	}
	
	@Override
	public boolean validateEmailAddress(String emailId) {

		Session session = null;
	    Transaction transaction = null;
		try{
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			boolean status = false;
			String hql = "from UserProfile where primaryEmailAddr = :emailId";
			List<UserProfile> result = session.createQuery(hql)
				.setString("emailId", emailId).list();
			if (result != null && result.size() > 0)
			status = true;
			session.flush();
			transaction.commit();
			return status;		
		}finally{
			if(session==null)				
				session.close();		
		}
	}

	@Override
	public boolean checkSecuritySetup(String emailId) {
		
		Session session = null;
	    Transaction transaction = null;
	    try{
	    	session = con.getSessionFactory().openSession();
	    	transaction = session.beginTransaction();
	    	boolean isSecure = false;
	    	Criteria criteria = session.createCriteria(UserProfile.class);
	    	criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
	    	UserProfile userProfile = (UserProfile) criteria.uniqueResult();
	    	if (null == userProfile)
	    		return isSecure;
	    	if (userProfile.getSecurityQuestFlg().equals(YES))
	    		isSecure = true;
	    	session.flush();
	    	transaction.commit();
	    	return isSecure;
	    }finally{
	    	if(session==null)
	    		session.close();
	    }
	}

	@Override
	public List<UserSecurityDetails> getSecurityQuestions(Integer userId) {

		Session session = null;
	    Transaction transaction = null;
	    try{
	    	session = con.getSessionFactory().openSession();
	    	transaction = session.beginTransaction();
	    	Criteria criteria = session.createCriteria(UserSecurityDetails.class);
	    	criteria.add(Restrictions.eq("userId", userId));
	    	List<UserSecurityDetails> userSecurityDetails = criteria.list();
	    	session.flush();
	    	transaction.commit();
	    	return userSecurityDetails;
	    }finally{
	    	if(session==null)
	    		session.close();
	    }

	}

	@Override
	public boolean validateSecurityQuestions(String emailId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean doLogin(String emailId, String password) {

		// here we should call the external AML service to authenticate the user
		return true;
	}

	@Override
	public boolean isUserLocked(String emailId) {

		Session session = null;
	    Transaction transaction = null;
	    try{
	    	session = con.getSessionFactory().openSession();
	    	transaction = session.beginTransaction();
	    	boolean isLocked = false;
	    	Criteria criteria = session.createCriteria(UserProfile.class);
	    	criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
	    	UserProfile userProfile = (UserProfile) criteria.uniqueResult();
	    	if (null == userProfile)
	    		return isLocked;
	    	if (!userProfile.getIsAccountActive().equals(YES))
	    		isLocked = true;
	    	session.flush();
	    	transaction.commit();
	    	return isLocked;
	    }finally{
	    	if(session==null)
	    		session.close();
	    }
	}

	@Override
	public int lockUser(String emailId) {

		Session session = null;
	    Transaction transaction = null;
	    try{
	    	session = con.getSessionFactory().openSession();
	    	transaction = session.beginTransaction();
	    	String hql = "UPDATE UserProfile set isAccountActive = :isAccountActive "
				+ "WHERE primaryEmailAddr = :emailId";
	    	Query query = session.createQuery(hql);
	    	query.setParameter("isAccountActive", "N");
	    	query.setParameter("emailId", emailId);
	    	int result = query.executeUpdate();
	    	session.flush();
	    	transaction.commit();
	    	return result;
	    }finally{
	    	if(session==null)
	    		session.close();
	    }
	}

	@Override
	public boolean resetPassword(String emailId, String password) {

		// we should call the external AML service to update the password

		return false;
	}

	@Override
	public Integer getUserId(String emailId) {

		Session session = null;
	    Transaction transaction = null;
	    try{
	    	session = con.getSessionFactory().openSession();
	    	transaction = session.beginTransaction();
	    	Criteria criteria = session.createCriteria(UserProfile.class);
	    	criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
	    	UserProfile userProfile = (UserProfile) criteria.uniqueResult();
			int usreId = userProfile.getUserId();
			session.flush();
			transaction.commit();
			return usreId;
	    }finally{
	    	if(session==null)
	    		session.close();
	    }
	}

}
