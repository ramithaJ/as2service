package com.wiley.gr.ace.authorservices.persistence.services;

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
		List<UserProfile> upList = session.createCriteria(UserProfile.class)
				.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		session.close();
		return upList;
	}

	@Override
	public boolean validateEmailAddress(String emailId) {
		// TODO Auto-generated method stub
		boolean status = false;
		Session session = con.getSessionFactory().openSession();
		String hql = "from UserProfile where primaryEmailAddr = :emailId";
		List<UserProfile> result = session.createQuery(hql)
				.setString("emailId", emailId).list();

		if (result != null && result.size() > 0) {

			status = true;
		}
		return status;
	}

	@Override
	public boolean checkSecuritySetup(String emailId) {
		boolean isSecure = false;
		Session session = con.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria(UserProfile.class);
		criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
		UserProfile userProfile = (UserProfile) criteria.uniqueResult();

		if (null == userProfile)
			return false;
		if (userProfile.getSecurityQuestFlg().equals(YES))
			isSecure = true;
		session.flush();
		session.close();
		tx.commit();
		return isSecure;
	}

	@Override
	public List<Object[]> getSecurityQuestions(String userId) {
		// TODO Auto-generated method stub
		Session session = con.getSessionFactory().openSession();

		/*
		 * use this scenario when hql required
		 * 
		 * String hql = "from USER_SECURITY_DETAILS where USER_ID= :userId";
		 * List<UserSecurityDetails> userSecirityDetails = session
		 * .createQuery(hql).setString("userId", userId).list();
		 * System.out.println("list values" + userSecirityDetails.toString());
		 * return userSecirityDetails;
		 */

		List<Object[]> rows = session.createSQLQuery(
				"SELECT * FROM USER_SECURITY_DETAILS where USER_ID=1234")
				.list();
		System.out.println("--------------" + rows.size());
		return rows;

		/*
		 * use this when criteria required
		 * 
		 * Transaction tx = session.beginTransaction(); Criteria criteria
		 * =session.createCriteria(UserSecurityDetails.class);
		 * criteria.add(Restrictions.eq("userId", Integer.parseInt(userId)));
		 * List<UserSecurityDetails> userSecurityDetails
		 * =(List<UserSecurityDetails>) criteria.list(); session.flush();
		 * session.close(); tx.commit(); return userSecurityDetails;
		 */

	}

	@Override
	public boolean validateSecurityQuestions(String emailId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doLogin(String emailId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isUserLocked(String emailId) {
		// TODO Auto-generated method stub
		boolean isLocked = false;
		Session session = con.getSessionFactory().openSession();
		Criteria criteria = session.createCriteria(UserProfile.class);
		criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
		UserProfile userProfile = (UserProfile) criteria.uniqueResult();
		if (null == userProfile)
			return false;
		if (userProfile.getSecurityQuestFlg().equals(YES))
			isLocked = true;
		return isLocked;
	}

	@Override
	public int lockUser(String emailId) {
		// TODO Auto-generated method stub
		Session session = con.getSessionFactory().openSession();
		String hql = "UPDATE UserProfile set isAccountActive = :isAccountActive "
				+ "WHERE primaryEmailAddr = :emailId";
		Query query = session.createQuery(hql);
		query.setParameter("isAccountActive", "n");
		query.setParameter("emailId", emailId);
		return query.executeUpdate();
	}

}
