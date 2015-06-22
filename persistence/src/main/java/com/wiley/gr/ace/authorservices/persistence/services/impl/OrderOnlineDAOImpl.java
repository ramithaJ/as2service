/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import static com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection.getSessionFactory;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.wiley.gr.ace.authorservices.persistence.entity.ArticleAuthorAssignment;
import com.wiley.gr.ace.authorservices.persistence.entity.Articles;
import com.wiley.gr.ace.authorservices.persistence.entity.Journals;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO;

/**
 * @author virtusa version1.0
 *
 */
public class OrderOnlineDAOImpl implements OrderOnlineDAO {

    /**
     * Method to get ArticleAssigmentDetails tabel object.
     */
    @Override
    public final ArticleAuthorAssignment getAritcleAssignmentDetails(
            final String userId, final String articleId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(
                    ArticleAuthorAssignment.class, "articleAuthorAssignment");
            criteria.createAlias("articleAuthorAssignment.articles", "articles");
            criteria.createAlias("articleAuthorAssignment.userProfile",
                    "userProfile");
            criteria.add(Restrictions.eq("articles.articleId",
                    Integer.parseInt(articleId)));
            criteria.add(Restrictions.eq("userProfile.userId",
                    Integer.parseInt(userId)));
            return (ArticleAuthorAssignment) criteria.uniqueResult();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * Method to get ArticleDetails table object.
     */
    @Override
    public final Articles getArticleDetails(final String articleId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            return (Articles) session.get(Articles.class,
                    Integer.parseInt(articleId));
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * Method to get Journal Details table object.
     */
    @Override
    public final Journals getJournalDetails(final String journalId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            return (Journals) session.get(Journals.class,
                    Integer.parseInt(journalId));
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * Method to get savedOrders.
     */
    @Override
    public final SavedOrders getSavedOrders(final String articleId,
            final String userId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(SavedOrders.class,
                    "savedOrders");
            criteria.createAlias("savedOrders.articles", "articles");
            criteria.createAlias("savedOrders.userProfile", "userProfile");
            criteria.add(Restrictions.eq("articles.articleId",
                    Integer.parseInt(articleId)));
            criteria.add(Restrictions.eq("userProfile.userId",
                    Integer.parseInt(userId)));
            return (SavedOrders) criteria.uniqueResult();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * Method to get orders.
     */
    @Override
    public final Orders getOrder(final Integer aritcleAuthId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Orders.class, "orders");
            criteria.createAlias("orders.articleAuthorAssignment",
                    "articleAuthorAssignment");
            criteria.add(Restrictions.eq(
                    "articleAuthorAssignment.articleAuthId", aritcleAuthId));
            return (Orders) criteria.uniqueResult();

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /** For Getting List Of ArticleAuthId */
    @Override
    public List<ArticleAuthorAssignment> getArticleAuthId(Integer userId,
            String type) {

        Session session = null;
        List<ArticleAuthorAssignment> listArticleAuthorAssignments = null;
        System.err.println(type);
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(
                    ArticleAuthorAssignment.class, "articleAuthorAssignment");
            criteria.createAlias("articleAuthorAssignment.userProfile",
                    "userProfile");
            criteria.add(Restrictions.eq("userProfile.userId", userId));
            if (type == null) {
                criteria.setFetchMode("orderses", FetchMode.JOIN);
                criteria.setFetchMode("articles", FetchMode.JOIN);
            } else {
                criteria.createAlias("articleAuthorAssignment.orderses",
                        "orderses");
                criteria.add(Restrictions.eq("orderses.ooOaFlg", type));
            }
            listArticleAuthorAssignments = (List<ArticleAuthorAssignment>) criteria
                    .list();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return listArticleAuthorAssignments;
    }

	/* (non-Javadoc)
	 * @see com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO#saveLaterOrder(java.lang.String)
	 */
	@Override
	public String saveLaterOrder(String order) {
		
		
		return null;
	}
}
