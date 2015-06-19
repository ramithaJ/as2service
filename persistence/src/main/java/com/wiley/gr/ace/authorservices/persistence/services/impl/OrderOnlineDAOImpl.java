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

import org.hibernate.Criteria;
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
    public ArticleAuthorAssignment getAritcleAssignmentDetails(String userId,
            String articleId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(
                    ArticleAuthorAssignment.class, "articleAuthorAssignment");
            criteria.createAlias("articleAuthorAssignment.articles", "articles");
            criteria.add(Restrictions.eq("articles.articleId",
                    Integer.parseInt(articleId)));
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
    public Articles getArticleDetails(String articleId) {

        Session session = null;
        try {

            session = getSessionFactory().openSession();
            return (Articles) session.get(Articles.class, articleId);

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
    public Journals getJournalDetails(String journalId) {

        Session session = null;
        try {

            session = getSessionFactory().openSession();
            Journals articles = (Journals) session.get(Journals.class,
                    journalId);
            return articles;

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    @Override
    public SavedOrders getSavedOrders(String articleId, String userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Orders getOrder(String aritcleAuthId) {
        // TODO Auto-generated method stub
        return null;
    }

    public static void main(String[] args) {

        OrderOnlineDAOImpl orderOnlineDAOImpl = new OrderOnlineDAOImpl();
        orderOnlineDAOImpl.getAritcleAssignmentDetails("8011047", "1111");
    }
}
