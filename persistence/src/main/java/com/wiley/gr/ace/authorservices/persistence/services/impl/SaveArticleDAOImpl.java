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

import static com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection.getSessionFactory;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.services.SaveArticleDAO;

// TODO: Auto-generated Javadoc
/**
 * The Class SaveArticleDAOImpl.
 */
public class SaveArticleDAOImpl implements SaveArticleDAO {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SaveArticleDAOImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.persistence.services.SaveArticleDAO#
	 * saveArticleInvitation(java.lang.String, java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public boolean saveArticleInvitation(InviteResetpwdLog invite)
			throws Exception {
		Session session = null;
		try {
			session = getSessionFactory().openSession();
			session.getTransaction().begin();
			session.save(invite);
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null) {
				session.getTransaction().rollback();
			}
			LOGGER.error("Exception while inserting record ..."
					+ e.getMessage());
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
		return false;
	}

}
