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
import com.wiley.gr.ace.authorservices.persistence.entity.LookupValuesId;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;

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
			//transaction = session.beginTransaction();
			//Criteria criteria = session.createCriteria(LookupValues.class);
			//   .add(Restrictions.eq("lookupKey", "SEQ"));
			//String hql = "from LookupValuesId where lookupKey = :lookupKey";
			//List<LookupValuesId> lookupList = session.createQuery(hql)
			//		.setString("lookupKey", "SEQ").list();
			//List<String> lookupList = criteria.list();
			//System.out.println("shiva"+lookupList.get(0)+"  "+lookupList.size());
			/*for (LookupValuesId lookupValuesId : lookupList) {
				list.add(lookupValuesId.getLookupValue());
			}
*/
			
			
			transaction.commit();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}

		return list;
	}
}
