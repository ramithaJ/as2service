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

import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO;

/**
 * @author virtusa version1.0
 *
 */
public class OrderOnlineDAOImpl implements OrderOnlineDAO {

    /**
     * Method to get ArticleAssigmentDetails table object.
     */
    @Override
    public final ProductPersonRelations getAritcleAssignmentDetails(
            final String userId, final String articleId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(
                    ProductPersonRelations.class, "productPersonRelations");
            criteria.createAlias("productPersonRelations.products", "products");
            criteria.createAlias("productPersonRelations.userProfile",
                    "userProfile");
            criteria.add(Restrictions.eq("products.dhId",
                    Integer.parseInt(articleId)));
            criteria.add(Restrictions.eq("userProfile.userId",
                    Integer.parseInt(userId)));
            ProductPersonRelations productPersonRelations = (ProductPersonRelations) criteria
                    .uniqueResult();
            System.err.println(productPersonRelations.getProductRoles()
                    .getProductRoleCd());
            return null;
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
    public List<ProductPersonRelations> getArticleAuthId(final Integer userId,
            final String type) {

        Session session = null;
        List<ProductPersonRelations> listArticleAuthorAssignments = null;
        System.err.println(type);
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(
                    ProductPersonRelations.class, "articleAuthorAssignment");
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
            listArticleAuthorAssignments = criteria.list();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return listArticleAuthorAssignments;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO#
     * saveLaterOrder(java.lang.String)
     */
    @Override
    public void saveLaterOrder(final SavedOrders savedOrders) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(savedOrders);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

    }

    @Override
    public void saveOrUpdateOrder(final Orders orders) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.getTransaction().begin();
            session.saveOrUpdate(orders);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

    }

    /**
     * This method returns the SavedOrder details for the corresponding orderId.
     * 
     * @param orderId
     * @param userId
     * @return SavedOrders
     * 
     */
    @Override
    public SavedOrders getSavedOrdersForTheOrderId(final String orderId,
            final String userId) {
        Session session = null;
        SavedOrders savedOrder = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(SavedOrders.class,
                    "savedOrders");
            criteria.createAlias("savedOrders.userProfile", "userProfile");
            criteria.add(Restrictions.eq("savedOrders.orderId",
                    Integer.parseInt(orderId)));
            criteria.add(Restrictions.eq("userProfile.userId",
                    Integer.parseInt(userId)));

            savedOrder = (SavedOrders) criteria.uniqueResult();

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return savedOrder;

    }

    @Override
    public List<ProductPersonRelations> getGrantRecipients(
            final String articleId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(
                    ProductPersonRelations.class, "productPersonRelations");
            criteria.createAlias("productPersonRelations.products", "products");
            criteria.createAlias("productPersonRelations.productRoles",
                    "productRoles");
            criteria.add(Restrictions.eq("products.dhId",
                    Integer.parseInt(articleId)));
            criteria.add(Restrictions.eq("productRoles.productRoleCd", "0002"));
            criteria.setFetchMode("userProfile", FetchMode.JOIN);
            criteria.setFetchMode("userProfile.usersByUserId", FetchMode.JOIN);
            return criteria.list();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

}
