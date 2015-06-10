/*
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 */
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import static com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection.getSessionFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;

/**
 * @author virtusa version 1.0
 */
public class UserLoginServiceDAOImpl implements UserLoginServiceDAO {

	@Value("${invalidEmail.code}")
	private String invalidEmail;

	@Value("${invalidEmail.message}")
	private String invalidEmailMsg;
	

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO
	 * #validateEmailAddress(java.lang.String)
	 */
	@Override
	public boolean validateEmailAddress(String emailId) {

		Session session = null;
		try {

			int userId = getUserId(emailId);
			session = getSessionFactory().openSession();
			Users users = (Users) session.load(Users.class, userId);
			if (null == users) {
				return false;
			}
			return true;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO
	 * #getUserId(java.lang.String)
	 */
	@Override
	public Integer getUserId(String emailId) {

		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("primaryEmailAddr", emailId));
			Users user = (Users) criteria.uniqueResult();
			if (null == user) {
				throw new ASException(invalidEmail, invalidEmailMsg);
			}
			return user.getUserId();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public InviteResetpwdLog getinviteResetpwdLog(String guid) {
		Session session = null;
		InviteResetpwdLog inviteResetpwdLog =null;
		try {

			session = getSessionFactory().openSession();
			inviteResetpwdLog = (InviteResetpwdLog) session
					.get(InviteResetpwdLog.class, guid);

			

		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}

		return inviteResetpwdLog;
	}
}
