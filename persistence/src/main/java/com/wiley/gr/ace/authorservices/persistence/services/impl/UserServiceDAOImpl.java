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
import com.wiley.gr.ace.authorservices.persistence.services.UserServiceDAO;

/**
 * @author kpshiva
 */
public class UserServiceDAOImpl implements UserServiceDAO {

	private static final String YES = "y";

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");
	

	@Override
	public List<UserProfile> getUsersList() {

		Session session = con.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List<UserProfile> upList = session.createCriteria(UserProfile.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.close();
		return upList;
	}

	@Override
	public boolean validateEmailAddress(String emailId) {

		Session session = con.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		boolean status = false;
		String hql = "from UserProfile where primaryEmailAddr = :emailId";
		List<UserProfile> result = session.createQuery(hql)
				.setString("emailId", emailId).list();
		if (result != null && result.size() > 0)
			status = true;
		session.flush();
		session.close();
		tx.commit();
		return status;
	}

	@Override
	public boolean checkSecuritySetup(String emailId) {

		Session session = con.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		boolean isSecure = false;
		Criteria criteria = session.createCriteria(UserProfile.class);
		criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
		UserProfile userProfile = (UserProfile) criteria.uniqueResult();
		if (null == userProfile)
			return isSecure;
		if (userProfile.getSecurityQuestFlg().equals(YES))
			isSecure = true;
		session.flush();
		session.close();
		tx.commit();
		return isSecure;
	}

	@Override
	public List<UserSecurityDetails> getSecurityQuestions(Integer userId) {

		Session session = con.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UserSecurityDetails.class);
		criteria.add(Restrictions.eq("userId", userId));
		List<UserSecurityDetails> userSecurityDetails = criteria.list();
		session.flush();
		session.close();
		tx.commit();
		return userSecurityDetails;

	}

	@Override
	public boolean validateSecurityQuestions(String emailId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doLogin(String emailId, String password) {

		// here we should call the external AML service to authenticate the user
		return true;
	}

	@Override
	public boolean isUserLocked(String emailId) {

		Session session = con.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		boolean isLocked = false;
		Criteria criteria = session.createCriteria(UserProfile.class);
		criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
		UserProfile userProfile = (UserProfile) criteria.uniqueResult();
		if (null == userProfile)
			return isLocked;
		if (!userProfile.getIsAccountActive().equals(YES))
			isLocked = true;
		session.flush();
		session.close();
		tx.commit();
		return isLocked;
	}

	@Override
	public int lockUser(String emailId) {

		Session session = con.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String hql = "UPDATE UserProfile set isAccountActive = :isAccountActive "
				+ "WHERE primaryEmailAddr = :emailId";
		Query query = session.createQuery(hql);
		query.setParameter("isAccountActive", "n");
		query.setParameter("emailId", emailId);
		int result=query.executeUpdate();
		session.flush();
		session.close();
		tx.commit();
		return result;
	}

	@Override
	public boolean resetPassword(String emailId, String password) {

		// we should call the external AML service to update the password

		return false;
	}

	@Override
	public Integer getUserId(String emailId) {

		Session session = con.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		Criteria criteria = session.createCriteria(UserProfile.class);
		criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
		UserProfile userProfile = (UserProfile) criteria.uniqueResult();
		int usreId= userProfile.getUserId();
		session.flush();
		session.close();
		tx.commit();
		return usreId;
	}

}
