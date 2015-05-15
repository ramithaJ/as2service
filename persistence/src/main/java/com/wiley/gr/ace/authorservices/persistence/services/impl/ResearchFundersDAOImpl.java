package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.ResearchFunders;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;
import com.wiley.gr.ace.authorservices.persistence.services.ResearchFundersDAO;

public class ResearchFundersDAOImpl implements ResearchFundersDAO {

	@Autowired(required = true)
	HibernateConnection con;

	@Override
	public List<UserFunderGrants> getResearchFunders(String userId) {

		Session session = con.getSessionFactory().openSession();
		session.beginTransaction();
		List<UserFunderGrants> userFunderGrants = null;
		try {

			String hql = "from UserFunderGrants where id.userId = :userId";
			userFunderGrants = session.createQuery(hql)
					.setString("userId", userId).list();
			session.getTransaction().commit();
			return userFunderGrants;
		} finally {

			if (null != session) {
				session.flush();
				session.close();
			}
		}
	}

	@Override
	public boolean updateResearchFunder(String userId,
			ResearchFunder researchFunder) {

		Session session = con.getSessionFactory().openSession();
		session.beginTransaction();
		UserFunderGrants userFunderGrants = null;
		ResearchFunders researchFunders = new ResearchFunders();
		try {

			Criteria criteria = session.createCriteria(UserFunderGrants.class);
			criteria.add(Restrictions.eq("id.userId", Integer.parseInt(userId)));
			criteria.add(Restrictions.eq("researchFunders.rfunderId",
					researchFunder.getResearchFunderId()));
			userFunderGrants = (UserFunderGrants) criteria.uniqueResult();
			if (null != userFunderGrants) {
				
				researchFunders.setFunderName(researchFunder
						.getResearchFunderName());
				userFunderGrants.setResearchFunders(researchFunders);
				session.saveOrUpdate(userFunderGrants);
				session.getTransaction().commit();
			}
			return true;
		} finally {

			if (null != session) {
				session.flush();
				session.close();
			}
		}
	}

}
