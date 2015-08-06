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
 ******************************************************************************/
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import static com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection.getSessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.persistence.entity.OwnershipTypes;
import com.wiley.gr.ace.authorservices.persistence.services.CollectArticleDAO;

public class CollectArticleDAOImpl implements CollectArticleDAO {

	@Override
	public final List<OwnershipTypes> getCollectArticle() throws Exception {
		List<OwnershipTypes> ownershipTypesList = null;
		Session session = null;
		try {

			session = getSessionFactory().openSession();
			String hql = "from OwnershipTypes";
			ownershipTypesList = session.createQuery(hql).list();
			System.err.println("ownershipTypesList"+ownershipTypesList);
		} finally {
			if (!StringUtils.isEmpty(session)) {
				session.flush();
				session.close();
			}
		}
		return ownershipTypesList;
	}

}
