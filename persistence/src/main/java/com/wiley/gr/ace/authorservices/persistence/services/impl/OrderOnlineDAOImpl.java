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

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.PaymentDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.CoauthorRequestsOoorders;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.entity.WpgResponseDetails;
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

    @Value("${CorrespondingAuthorId}")
    private String CorrespondingAuthorId;

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
    public List<ProductPersonRelations> getGrantRecipients(
            final String articleId) {

        Session session = null;
        List list = new ArrayList();
        list.add(coAuthorId);
        list.add(CorrespondingAuthorId);
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(
                    ProductPersonRelations.class, "productPersonRelations");
            criteria.createAlias("productPersonRelations.products", "products");
            criteria.createAlias("productPersonRelations.productRoles",
                    "productRoles");
            criteria.add(Restrictions.eq("products.dhId",
                    Integer.parseInt(articleId)));
            criteria.add(Restrictions.in("productRoles.productRoleCd", list));
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

    /**
     * Method to updated payment details
     * 
     * @param paymentDetails
     * @return boolean
     * 
     */
    @Override
    public void savePaymentDetails(final PaymentDetails paymentDetails) {

        Session session = null;

        try {
            session = getSessionFactory().openSession();
            session.getTransaction().begin();
            WpgResponseDetails wpgResponseDetails = new WpgResponseDetails();

            wpgResponseDetails
                    .setAcquirerBank(paymentDetails.getAcquirerBank());
            wpgResponseDetails.setAcquirerId(paymentDetails.getAcquirerId());
            wpgResponseDetails.setAvsAddressResult(paymentDetails
                    .getAvsAddressResult());
            wpgResponseDetails.setAvsPostResult(paymentDetails
                    .getAvsPostResult());
            wpgResponseDetails.setBankId(paymentDetails.getBankId());
            wpgResponseDetails.setBankName(paymentDetails.getBankName());
            wpgResponseDetails.setCardExpiry(paymentDetails.getCardExpiry());
            wpgResponseDetails.setCscResult(paymentDetails.getCscResult());
            wpgResponseDetails.setMaskedCardNumber(paymentDetails
                    .getMaskedCardNumber());
            wpgResponseDetails.setMerchantId(paymentDetails.getMerchantId());
            wpgResponseDetails.setMerchantResponse(paymentDetails
                    .getMerchantResponse());
            wpgResponseDetails.setOperation(paymentDetails.getOperation());
            wpgResponseDetails.setReturnCode(paymentDetails.getReturnCode());
            wpgResponseDetails.setReturnMessage(paymentDetails
                    .getReturnMessage());
            wpgResponseDetails.setSecurity(paymentDetails.getSecurity());
            wpgResponseDetails.setToken(paymentDetails.getToken());
            wpgResponseDetails.setTransId(paymentDetails.getTransId());
            wpgResponseDetails.setTransTimestamp(paymentDetails
                    .getTransTimeStamp());
            wpgResponseDetails.setVendorId(paymentDetails.getVendorId());
            session.save(wpgResponseDetails);
            session.getTransaction().commit();

        } catch (HibernateException e) {
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
     * Method returns the order type for the corresponding order id
     * 
     * @param orderId
     * @return orderType
     * 
     */
    @Override
    public String retrieveOrderType(final Integer orderId) {
        Session session = null;
        Orders order = null;
        String orderType = null;

        try {
            session = getSessionFactory().openSession();
            order = (Orders) session.load(Orders.class, orderId);
            orderType = order.getOrderTypes().getOrderTypeName();

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }

        }

        return orderType;
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

        }

        finally {
            if (session != null) {
                session.flush();
                session.close();
            }

        }
        return coauthorRequestsOoorders;
    }

    /**
     * For getting user details by taking userId
     * 
     * @param userId
     * */
    @Override
    public Users getUserDetails(final String userId) {

        Session session = null;
        Users users = null;

        try {
            session = getSessionFactory().openSession();
            users = (Users) session.get(Users.class, Integer.parseInt(userId));

        }

        finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return users;

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
            System.err.println(coauthorRequestsOoorders);
            if (coauthorRequestsOoorders.isEmpty()) {
                return null;
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
            System.err.println(list.size());
            if (list.isEmpty()) {
                return null;
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
