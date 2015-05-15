package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrantsId;
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
		try {

			UserFunderGrants userFunderGrants = new UserFunderGrants();
			userFunderGrants.setId(new UserFunderGrantsId(Integer
					.parseInt(userId), researchFunder.getResearchFunderId(),
					researchFunder.getResearchFunderName()));
			userFunderGrants = (UserFunderGrants) session.get(
					UserFunderGrants.class, userFunderGrants.getId());
//			if (null != userFunderGrants) {
//
//				// userFunderGrants.s
//
//			}
			return true;
		} finally {

			if (null != session) {
				session.flush();
				session.close();
			}
		}
	}

}
