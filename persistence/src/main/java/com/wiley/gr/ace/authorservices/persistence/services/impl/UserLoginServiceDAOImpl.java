/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;

/**
 * @author kpshiva
 */
public class UserLoginServiceDAOImpl implements UserLoginServiceDAO {

	@Autowired(required = true)
	HibernateConnection con;

	@Override
	public List<AuthorProfile> getUsersList() {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			List<AuthorProfile> upList = session
					.createCriteria(AuthorProfile.class)
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
			String hql = "from Users where emailAddr = :emailId";
			List<Users> result = session.createQuery(hql)
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
			Criteria criteria = session.createCriteria(AuthorProfile.class);
			criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
			AuthorProfile userProfile = (AuthorProfile) criteria.uniqueResult();
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
			criteria.createAlias("userSecurityDetails.authorProfile",
					"authorProfile");
			criteria.add(Restrictions.eq("authorProfile.userId", userId));
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
	public boolean doLogin(int userId, String password) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Date date = new Date();

			String hql = "UPDATE AuthorProfile set lastLoginDate = :lastLoginDate, updatedBy = :updatedBy, updatedDate = :updatedDate "
					+ "WHERE userId = :userId";
			Query query = session.createQuery(hql);
			query.setParameter("lastLoginDate", date);
			query.setParameter("updatedBy", "system");
			query.setParameter("updatedDate", date);
			query.setParameter("userId", userId);
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
	public boolean isUserLocked(int userId) {

		Session session = null;
		Transaction transaction = null;
		boolean isLocked = false;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(AuthorProfile.class);
			criteria.add(Restrictions.eq("userId", userId));
			AuthorProfile authorProfile = (AuthorProfile) criteria
					.uniqueResult();
			if (null == authorProfile)
				return isLocked;
			if (authorProfile.getIsAccountLocked() == 'Y') {
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
	public boolean lockUser(int userId) {

		Session session = null;
		Transaction transaction = null;
		Date accountLockedTime = new Date();
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String hql = "UPDATE AuthorProfile set isAccountLocked = :isAccountLocked, accountLockedTime = :accountLockedTime "
					+ "WHERE userId = :userId";
			Query query = session.createQuery(hql);
			query.setParameter("isAccountLocked", 'Y');
			query.setParameter("accountLockedTime", accountLockedTime);
			query.setParameter("userId", userId);
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
	public Integer getUserId(String emailId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("emailAddr", emailId));
			Users user = (Users) criteria.uniqueResult();
			int usreId = user.getUserId();
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
	public int getCount(int userId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(AuthorProfile.class);
			criteria.add(Restrictions.eq("userId", userId));
			AuthorProfile userProfile = (AuthorProfile) criteria.uniqueResult();
			int count = userProfile.getInvalidLoginCnt();
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
	public boolean updateCount(int count, int userId) {

		Session session = null;
		Transaction transaction = null;
		boolean status = false;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String hql = "UPDATE AuthorProfile set invalidLoginCnt = :invalidLoginCnt "
					+ "WHERE userId = :userId";
			Query query = session.createQuery(hql);
			query.setParameter("invalidLoginCnt", count);
			query.setParameter("userId", userId);
			int result = query.executeUpdate();
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
	public Date getLockedTime(int userId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(AuthorProfile.class);
			criteria.add(Restrictions.eq("userId", userId));
			AuthorProfile userProfile = (AuthorProfile) criteria.uniqueResult();
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
	public boolean unLockUser(int userId) {

		Session session = null;
		Transaction transaction = null;
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			String hql = "UPDATE AuthorProfile set isAccountLocked = :isAccountLocked "
					+ "WHERE userId = :userId";
			Query query = session.createQuery(hql);
			query.setParameter("isAccountLocked", 'N');
			query.setParameter("userId", userId);
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
