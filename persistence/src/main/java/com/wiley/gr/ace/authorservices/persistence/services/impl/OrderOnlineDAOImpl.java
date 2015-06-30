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
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.model.PaymentDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.entity.WpgResponseDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.WpgResponseDetailsId;
import com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO;

/**
 * @author virtusa version1.0
 *
 */
public class OrderOnlineDAOImpl implements OrderOnlineDAO {

    /**
     * This field holds the value of coAuthorId
     */
    @Value("${coAuthorId}")
    private String coAuthorId;

    /**
     * Method to get ArticleAssigmentDetails table object.
     */
    @Override
    public final ProductPersonRelations getProductPersonRelations(
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
            return (ProductPersonRelations) criteria.uniqueResult();
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
                    Integer.parseInt(articleId)));
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
    public Integer saveLaterOrder(final SavedOrders savedOrders) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(savedOrders);
            session.getTransaction().commit();
            return savedOrders.getOrderId();
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
            criteria.add(Restrictions.eq("productRoles.productRoleCd",
                    coAuthorId));
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

    @Override
    public ProductRelations getProductRelations(final String articleDhId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(ProductRelations.class,
                    "productRelations");
            criteria.createAlias("productRelations.productsByChildDhId",
                    "productsByChildDhId");
            criteria.add(Restrictions.eq("productsByChildDhId.dhId",
                    Integer.parseInt(articleDhId)));
            return (ProductRelations) criteria.uniqueResult();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

    }

    @Override
    public boolean updatePaymentDetails(final PaymentDetails paymentDetails) {

        Session session = null;
        Transaction transaction = null;
        try {
            session = getSessionFactory().openSession();
            transaction = session.getTransaction();
            transaction.begin();
            WpgResponseDetailsId wpgResponseDetailsId = new WpgResponseDetailsId();
            WpgResponseDetails WpgResponseDetails = new WpgResponseDetails();

            wpgResponseDetailsId.setAcquirerBank(paymentDetails
                    .getAcquirerBank());
            wpgResponseDetailsId.setAcquirerId(paymentDetails.getAcquirerId());
            wpgResponseDetailsId.setAvsAddressResult(paymentDetails
                    .getAvsAddressResult());
            wpgResponseDetailsId.setAvsPostResult(paymentDetails
                    .getAvsPostResult());
            wpgResponseDetailsId.setBankId(paymentDetails.getBankId());
            wpgResponseDetailsId.setBankName(paymentDetails.getBankName());
            wpgResponseDetailsId.setCardExpiry(paymentDetails.getCardExpiry());
            wpgResponseDetailsId.setCscResult(paymentDetails.getCscResult());
            wpgResponseDetailsId.setMaskedCardNumber(paymentDetails
                    .getMaskedCardNumber());
            wpgResponseDetailsId.setMerchantId(paymentDetails.getMerchantId());
            wpgResponseDetailsId.setMerchantResponse(paymentDetails
                    .getMerchantResponse());
            wpgResponseDetailsId.setOperation(paymentDetails.getOperation());
            wpgResponseDetailsId.setReturnCode(paymentDetails.getReturnCode());
            wpgResponseDetailsId.setReturnMessage(paymentDetails
                    .getReturnMessage());
            wpgResponseDetailsId.setSecurity(paymentDetails.getSecurity());
            wpgResponseDetailsId.setToken(paymentDetails.getToken());
            wpgResponseDetailsId.setTransId(paymentDetails.getTransId());
            wpgResponseDetailsId.setTransTimestamp(paymentDetails
                    .getTransTimeStamp());
            wpgResponseDetailsId.setVendorId(paymentDetails.getVendorId());
            WpgResponseDetails.setId(wpgResponseDetailsId);
            session.saveOrUpdate(WpgResponseDetails);
            transaction.commit();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return true;
    }
}
