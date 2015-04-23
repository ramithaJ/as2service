package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.Date;
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

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");

	@Override
	public List<UserProfile> getUsersList() {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			List<UserProfile> upList = session
					.createCriteria(UserProfile.class)
					.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			transaction.commit();
			return upList;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public boolean validateEmailAddress(String emailId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			boolean status = false;
			String hql = "from UserProfile where primaryEmailAddr = :emailId";
			List<UserProfile> result = session.createQuery(hql)
					.setString("emailId", emailId).list();
			if (result != null && result.size() > 0)
				status = true;
			transaction.commit();
			return status;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public boolean checkSecuritySetup(String emailId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			boolean isSecure = false;
			Criteria criteria = session.createCriteria(UserProfile.class);
			criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
			UserProfile userProfile = (UserProfile) criteria.uniqueResult();
			if (null == userProfile)
				return isSecure;
			if (userProfile.getSecurityQuestFlg() == 'Y') {
				isSecure = true;
				return isSecure;
			}
			transaction.commit();
			return isSecure;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public List<UserSecurityDetails> getSecurityQuestions(Integer userId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(
					UserSecurityDetails.class, "userSecurityDetails");
			criteria.createAlias("userSecurityDetails.userProfile",
					"userProfile");
			criteria.add(Restrictions.eq("userProfile.userId", userId));
			List<UserSecurityDetails> userSecurityDetails = criteria.list();
			transaction.commit();
			return userSecurityDetails;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public boolean validateSecurityQuestions(String emailId) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean doLogin(String emailId, String password) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Date date = new Date();

			String hql = "UPDATE UserProfile set lastLoginDate = :lastLoginDate, updatedBy = :updatedBy, updatedDate = :updatedDate "
					+ "WHERE primaryEmailAddr = :emailId";
			Query query = session.createQuery(hql);
			query.setParameter("lastLoginDate", date);
			query.setParameter("updatedBy", "System");
			query.setParameter("updatedDate", date);
			query.setParameter("emailId", emailId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public boolean isUserLocked(String emailId) {

		Session session = null;
		Transaction transaction = null;
		boolean isLocked = false;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(UserProfile.class);
			criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
			UserProfile userProfile = (UserProfile) criteria.uniqueResult();
			System.out.println("shiva======================="
					+ userProfile.getIsAccountLocked());
			if (null == userProfile)
				return isLocked;
			if (userProfile.getIsAccountLocked() == 'Y') {
				isLocked = true;
			} else {
				isLocked = false;
			}
			transaction.commit();
			return isLocked;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public boolean lockUser(String emailId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String hql = "UPDATE UserProfile set isAccountLocked = :isAccountLocked "
					+ "WHERE primaryEmailAddr = :emailId";
			Query query = session.createQuery(hql);
			query.setParameter("isAccountLocked", "Y");
			query.setParameter("emailId", emailId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
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
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(UserProfile.class);
			criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
			UserProfile userProfile = (UserProfile) criteria.uniqueResult();
			int usreId = userProfile.getUserId();
			transaction.commit();
			return usreId;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public int getCount(String emailId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(UserProfile.class);
			criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
			UserProfile userProfile = (UserProfile) criteria.uniqueResult();
			int count =userProfile.getInvalidLoginCnt();
			transaction.commit();
			return count;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public boolean updateCount(int count, String emailId) {

		System.out.println("enteringcount");
		Session session = null;
		Transaction transaction = null;
		boolean status = false;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String hql = "UPDATE UserProfile set invalidLoginCnt = :invalidLoginCnt "
					+ "WHERE primaryEmailAddr = :emailId";
			Query query = session.createQuery(hql);
			query.setParameter("invalidLoginCnt"
					+ "", count);
			query.setParameter("emailId", emailId);
			int result = query.executeUpdate();
			System.out.println("enteringconut1"+result);
			if (result == 1)
				return status;
			transaction.commit();
			return status;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public Date getLockedTime(String emailId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(UserProfile.class);
			criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
			UserProfile userProfile = (UserProfile) criteria.uniqueResult();
			Date lockedTime = userProfile.getAccountLockedTime();
			transaction.commit();
			return lockedTime;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public boolean unLockUser(String emailId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String hql = "UPDATE UserProfile set isAccountLocked = :isAccountLocked "
					+ "WHERE primaryEmailAddr = :emailId";
			Query query = session.createQuery(hql);
			query.setParameter("isAccountLocked", 'N');
			query.setParameter("emailId", emailId);
			int result = query.executeUpdate();
			transaction.commit();
			if (result == 1) {
				return true;
			} else {
				return false;
			}
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

}
