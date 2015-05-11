package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthCoauthDetails;
import com.wiley.gr.ace.authorservices.persistence.services.AuthorCoAuthorDAO;

public class AuthorCoAuthorDAOImpl implements AuthorCoAuthorDAO {

	@Autowired(required = true)
	HibernateConnection con;

	@Override
	public List<AuthCoauthDetails> getCoAuthorsList(String userId) {

		Session session = null;
		try {
			session = con.getSessionFactory().openSession();
			Criteria criteria = session.createCriteria(AuthCoauthDetails.class,
					"authCoauthDetails");
			criteria.createAlias("authCoauthDetails.authorProfileByAuthorId",
					"authorProfile");
			criteria.add(Restrictions.eq("authorProfile.userId",
					Integer.parseInt(userId)));
			List<AuthCoauthDetails> authCoauthDetails = criteria.list();

			return authCoauthDetails;
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

}
