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

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.LookupValues;
import com.wiley.gr.ace.authorservices.persistence.entity.Roles;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;

/**
 * @author kpshiva
 *
 */
public class ASDataDAOImpl implements ASDataDAO {

	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");

	@Override
	public List<String> getSecurityDetails() {
		Session session = null;
		Transaction transaction = null;
		List<String> list = new ArrayList();
		try {
			session = con.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(LookupValues.class);
			criteria.add(Restrictions.eq("lookupKey", "SEQ"));
			List<LookupValues> lookupList = criteria.list();
			for (int i = 0; i < lookupList.size(); i++) {

				list.add(lookupList.get(i).getLookupName());
				list.add(lookupList.get(i).getLookupValue());
			}
			System.out.println("shiva" + list.size());
			transaction.commit();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}

		return list;
	}

	@Override
	public List<Roles> getAdminRoles() {
		
		Session session = null;
		List<Roles> list = new ArrayList();
		String roleType = "Internal";
		
		try {
			
			session = con.getSessionFactory().openSession();
			
			String hql = "from Roles where roleType = :roleType";
			
			list = session.createQuery(hql)
					.setString("roleType", roleType).list();
			
			
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
		
		return list;
	}
}
