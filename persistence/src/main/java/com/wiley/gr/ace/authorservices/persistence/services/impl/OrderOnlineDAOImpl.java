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

import java.util.Collections;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.persistence.entity.CoauthorRequestsOoorders;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO;

/**
 * @author virtusa version1.0
 *
 */
public class OrderOnlineDAOImpl implements OrderOnlineDAO {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(OrderOnlineDAOImpl.class);

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
            criteria.createAlias("savedOrders.products", "products");
            criteria.createAlias("savedOrders.usersByUserId", "usersByUserId");
            criteria.add(Restrictions.eq("products.dhId",
                    Integer.parseInt(articleId)));
            criteria.add(Restrictions.eq("usersByUserId.userId",
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
    public final Orders getOrder(final String articleId, final String userId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(Orders.class, "orders");
            criteria.createAlias("orders.usersByUserId", "usersByUserId");
            criteria.createAlias("orders.products", "products");
            criteria.add(Restrictions.eq("usersByUserId.userId",
                    Integer.parseInt(userId)));
            criteria.add(Restrictions.eq("products.dhId",
                    Integer.parseInt(articleId)));
            return (Orders) criteria.uniqueResult();

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * This method save the order
     * 
     * @param savedOrders
     * @return orderId
     *
     */
    @Override
    public Integer saveLaterOrder(final SavedOrders savedOrders) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(savedOrders);
            session.getTransaction().commit();
            return savedOrders.getOrderId().intValue();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

    }

    @Override
    public void saveOrder(final Orders orders) {

        Session session = null;

        try {
            session = getSessionFactory().openSession();
            session.getTransaction().begin();
            session.save(orders);
            session.getTransaction().commit();
        } catch (HibernateException e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            session.getTransaction().rollback();
            throw new ASException("704", e.getMessage());
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
    public SavedOrders getSavedOrdersForTheOrderId(final String orderId) {
        Session session = null;
        SavedOrders savedOrder = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(SavedOrders.class,
                    "savedOrders");
            criteria.add(Restrictions.eq("savedOrders.orderId",
                    Integer.parseInt(orderId)));

            savedOrder = (SavedOrders) criteria.uniqueResult();

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return savedOrder;

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
    public void deleteSavedOrderPostOrderSubmission(final Integer orderId) {
        Session session = null;
        SavedOrders savedOrder = null;

        try {
            session = getSessionFactory().openSession();
            session.getTransaction().begin();
            savedOrder = (SavedOrders) session.load(SavedOrders.class, orderId);
            session.delete(savedOrder);
            session.getTransaction().commit();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

    }

    @Override
    public SavedOrders verifySavedOrders(final String articleId,
            final String userId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(SavedOrders.class,
                    "savedOrders");
            criteria.createAlias("savedOrders.usersByUserId", "usersByUserId");
            criteria.createAlias("savedOrders.products", "products");
            criteria.add(Restrictions.eq("usersByUserId.userId",
                    Integer.parseInt(userId)));
            criteria.add(Restrictions.eq("products.dhId",
                    Integer.parseInt(articleId)));
            return (SavedOrders) criteria.uniqueResult();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

    }

    /**
     * call db to insert coauthor details
     * 
     * @param coauthorRequestsOoorders
     * */
    @Override
    public void requestOnlineOpen(
            final CoauthorRequestsOoorders coauthorRequestsOoorders) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(coauthorRequestsOoorders);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }

        }

    }

    /**
     * call db to get coauthor details
     * 
     * @param userId
     * @param articleId
     * */
    @Override
    public CoauthorRequestsOoorders viewOnlineOpenRequest(final String userId,
            final String articleId) {
        CoauthorRequestsOoorders coauthorRequestsOoorders = new CoauthorRequestsOoorders();
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(
                    CoauthorRequestsOoorders.class, "coAuthors");
            criteria.createAlias("coAuthors.usersByCoauthUserId",
                    "usersByUserId");
            criteria.createAlias("coAuthors.products", "Products");
            criteria.add(Restrictions.eq("usersByUserId.userId",
                    Integer.parseInt(userId)));
            criteria.add(Restrictions.eq("Products.dhId",
                    Integer.parseInt(articleId)));
            coauthorRequestsOoorders = (CoauthorRequestsOoorders) criteria
                    .uniqueResult();

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }

        }
        return coauthorRequestsOoorders;
    }

    @Override
    public List<CoauthorRequestsOoorders> getcoAuthorReqOO(final String userId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(
                    CoauthorRequestsOoorders.class, "coauthorRequestsOoorders");
            criteria.createAlias(
                    "coauthorRequestsOoorders.usersByCoauthUserId",
                    "usersByCoauthUserId");
            criteria.add(Restrictions.eq("usersByCoauthUserId.userId",
                    Integer.parseInt(userId)));
            List<CoauthorRequestsOoorders> coauthorRequestsOoorders = criteria
                    .list();
            if (coauthorRequestsOoorders.isEmpty()) {
                return Collections.emptyList();
            }
            return coauthorRequestsOoorders;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    @Override
    public List<SavedOrders> getUserSavedOrders(final String userId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(SavedOrders.class,
                    "savedOrders");
            criteria.createAlias("savedOrders.usersByUserId", "usersByUserId");
            criteria.add(Restrictions.eq("usersByUserId.userId",
                    Integer.parseInt(userId)));
            List<SavedOrders> list = criteria.list();
            if (list.isEmpty()) {
                return Collections.emptyList();
            }
            return list;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

}
