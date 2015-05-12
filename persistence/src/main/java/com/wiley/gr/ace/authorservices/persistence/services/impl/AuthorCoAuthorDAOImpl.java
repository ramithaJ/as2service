package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.model.CoAuthor;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthCoauthDetails;
import com.wiley.gr.ace.authorservices.persistence.services.AuthorCoAuthorDAO;

/**
 * @author kpshiva
 *
 */
public class AuthorCoAuthorDAOImpl implements AuthorCoAuthorDAO {

	@Autowired(required = true)
	HibernateConnection con;

	/**
	 * This method will give the list of co-authors which are tagged to
	 * author-id.
	 */
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

	/**
	 * This method will update the co-author details which are tagged to the
	 * author based on Author-id and co-Author_id.
	 */
	@Override
	public boolean editCoAuthor(String userId, CoAuthor coAuthorJson) {

		Session session = null;
		try {
			session = con.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(AuthCoauthDetails.class,
					"authCoauthDetails");
			criteria.createAlias("authCoauthDetails.authorProfileByAuthorId",
					"authorProfile");
			criteria.add(Restrictions.eq("authorProfile.userId",
					Integer.parseInt(userId)));
			criteria.add(Restrictions.eq(
					"authCoauthDetails.authorProfileByCoauthUserId.userId",
					coAuthorJson.getUserId()));
			AuthCoauthDetails authCoauthDetails = (AuthCoauthDetails) criteria
					.uniqueResult();

			if (null != authCoauthDetails) {

				authCoauthDetails.setCoauthTitle(coAuthorJson.getTitle());
				authCoauthDetails.setCoauthFirstName(coAuthorJson
						.getFirstName());
				authCoauthDetails.setCoauthLastName(coAuthorJson.getLastName());
				authCoauthDetails.setCoauthEmailAddr(coAuthorJson.getEmailId());
				authCoauthDetails.setCoauthPhone(coAuthorJson.getPhone());
				authCoauthDetails.setCoauthInstitution(coAuthorJson
						.getInstitutionName());
				authCoauthDetails.setCoauthDept(coAuthorJson
						.getDepartmentName());
				session.saveOrUpdate(authCoauthDetails);
				session.getTransaction().commit();
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

	/**
	 * This method will delete the co-author which are tagged to the author
	 * based on author-id and coAuthor-id.
	 */
	@Override
	public boolean deleteCoAuthor(String userId, String coAuthorId) {

		System.out.println("koti" + userId + "  " + coAuthorId);
		Session session = null;
		try {

			session = con.getSessionFactory().openSession();
			session.beginTransaction();
			Criteria criteria = session.createCriteria(AuthCoauthDetails.class,
					"authCoauthDetails");
			criteria.add(Restrictions.eq(
					"authCoauthDetails.authorProfileByAuthorId.userId",
					Integer.parseInt(userId)));
			criteria.add(Restrictions.eq(
					"authCoauthDetails.authorProfileByCoauthUserId.userId",
					Integer.parseInt(coAuthorId)));
			AuthCoauthDetails authCoauthDetails = (AuthCoauthDetails) criteria
					.uniqueResult();

			if (null != authCoauthDetails) {
				session.delete(authCoauthDetails);
				session.getTransaction().commit();
			}
			return true;

		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}
	}

}
