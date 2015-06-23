/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/

package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.model.Amount;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.Discounts;
import com.wiley.gr.ace.authorservices.model.FunderDetails;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.Prices;
import com.wiley.gr.ace.authorservices.model.QuoteDetail;
import com.wiley.gr.ace.authorservices.model.QuoteDetails;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.OrderData;
import com.wiley.gr.ace.authorservices.model.external.OrderRequest;
import com.wiley.gr.ace.authorservices.model.external.OrderResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.WOAFunder;
import com.wiley.gr.ace.authorservices.persistence.entity.ArticleAuthorAssignment;
import com.wiley.gr.ace.authorservices.persistence.entity.Articles;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;

/**
 * @author virtusa version 1.0
 *
 */
public class OrderOnlineOpenServiceImpl implements OrderOnlineOpenService {

    /** Getting Bean Of Order Service */
    @Autowired(required = true)
    private OrderService orderservice;

    /** Getting Bean Of OrderOnlineDAO Service */
    @Autowired(required = true)
    private OrderOnlineDAO orderOnlineDAO;

    /**
     * This method will take userId and orderId as input and calls external
     * service to get details of Online order details
     */
    @Override
    public OnlineOpenOrder getOnlineOpenOrderDetails(final String userId,
            final String orderId) {
        OnlineOpenOrder onlineOpenOrder = new OnlineOpenOrder();
        OrderData orderData = orderservice.getOrderDetails(userId, orderId);
        onlineOpenOrder.setArticleId(orderData.getArticle().getDHID());
        // Should check the below one
        // onlineOpenOrder.setJournalId(orderData.getArticle().getJournal().get);
        onlineOpenOrder.setPaymentMethod(orderData.getPayment()
                .getPaymentMethod());
        // need to calculate this
        // onlineOpenOrder.setTaxPercentage(orderData.);
        Discounts discounts = new Discounts();
        discounts.setInstitutionId(orderData.getPricing().getDiscounts()
                .getDiscount().getAffiliationData().getName());
        // Need to check this
        // discounts.setOtherDiscounts(orderData.getDiscountData().getOtherDiscounts());
        discounts.setPromoCode(orderData.getPricing().getDiscounts()
                .getDiscount().getPromoCode());
        discounts.setSocietyId(orderData.getPricing().getDiscounts()
                .getDiscount().getSocietyData().getName());
        onlineOpenOrder.setDiscounts(discounts);
        Amount amount = new Amount();
        amount.setAmount(orderData.getPricing().getAmountToBePaid().toString());
        amount.setAmount(orderData.getPricing().getCurrency());
        onlineOpenOrder.setAmountPayable(amount);
        FunderDetails funderDetails = new FunderDetails();
        List<FunderDetails> listoffunderdetails = new ArrayList<FunderDetails>();
        // Currently not getting this data from stub
        // funderDetails.setFunderId(orderData.getFundingDetails().getFunderId());
        // funderDetails.setResearchFunderId(orderData.getFundingDetails()
        // .getResearchFunderId());
        funderDetails
                .setWoaAccountId(orderData.getWoaAccountHolder().getName());
        listoffunderdetails.add(funderDetails);
        onlineOpenOrder.setFunderDetails(listoffunderdetails);
        TaxDetails taxDetails = new TaxDetails();
        taxDetails.setCountryCode(orderData.getTaxDetails().getCountryCode());
        taxDetails.setTaxCodeExpiryDate(orderData.getTaxDetails()
                .getTaxExpiration());
        taxDetails.setTaxExemptionNumber(orderData.getTaxDetails()
                .getTaxNumber());
        taxDetails.setVatExemptionNumber(orderData.getTaxDetails()
                .getVatExemptionNumber());
        taxDetails.setVatIdNumber(orderData.getTaxDetails().getVatIdNumber());
        onlineOpenOrder.setTaxDetails(taxDetails);
        // TODO: Update Address details
        // Address address = new Address();
        // address.setAddressLine1(orderData.getAddresses().get(0)
        // .getAddressLine1());
        // AddressDetails addressDetails = new AddressDetails();
        // addressDetails.setAddress(null);

        return onlineOpenOrder;
    }

    /**
     * Method to get quote.
     */
    @Override
    public QuoteDetails getQuote(String userId, String articleId,
            String pdmSalesFlag) {

        // Article details having userId and articleId
        Articles articles = orderOnlineDAO.getArticleDetails(articleId);
        if (null == articles) {
            throw new ASException("801",
                    "Article Not found in system. Please try after sometime..");
        }

        PdhJournalResponse pdhLookup = orderservice.pdhLookUpJournal(articles
                .getJournalId());
        QuoteDetails quoteDetails = null;
        // check article is onlineOpen article or not.
        if (pdmSalesFlag.equalsIgnoreCase(pdhLookup.getPdmSalesModel())) {

            // Article Author Assignment table details having userId and
            // articleId.
            ArticleAuthorAssignment articleAuthorAssignment = orderOnlineDAO
                    .getAritcleAssignmentDetails(userId, articleId);
            if (articleAuthorAssignment == null) {
                throw new ASException("802", "Article is not yet Accepted");
            }
            // check user is corresponding author or not.
            if (articleAuthorAssignment.getArticleRoles() != null
                    && articleAuthorAssignment.getArticleRoles()
                            .getArticleRoleCd().equalsIgnoreCase("0001")) {

                // check is there any saved orders for this article.
                SavedOrders savedOrders = orderOnlineDAO.getSavedOrders(
                        articleId, userId);
                if (null != savedOrders) {
                    throw new ASException("803",
                            "Order already exists for this Article");
                }
                // check is there any placed orders for this article.
                Orders orders = orderOnlineDAO.getOrder(articleAuthorAssignment
                        .getArticleAuthId());
                if (orders != null) {
                    throw new ASException("804",
                            "Order already submitted for this Article");
                }
                // calling external service for article and journal titles.
                Quote quote = orderservice.getQuote(articleId);

                quoteDetails = new QuoteDetails();
                ArticleDetails articleDetails = new ArticleDetails();
                articleDetails.setArticleAID(articleId);
                articleDetails.setArticleTitle(orderservice.pdhLookUpArticle(
                        articles.getDhId()).getTitle());
                quoteDetails.setArticleDetails(articleDetails);
                quoteDetails.setAuthorName("shiva");
                JournalDetails journalDetails = new JournalDetails();
                journalDetails.setJournalId(String.valueOf(articles
                        .getJournalId()));
                journalDetails.setJournalTitle(orderservice.pdhLookUpJournal(
                        articles.getJournalId()).getTitle());
                quoteDetails.setJournalDetails(journalDetails);
                QuoteDetail quoteDetail = new QuoteDetail();
                List<Prices> prices = new ArrayList<Prices>();
                Prices price = new Prices();
                price.setCurrency(quote.getCurrency());
                price.setPrice(quote.getArticlePubCharge());
                prices.add(price);
                quoteDetail.setPrices(prices);
                quoteDetails.setQuoteDetail(quoteDetail);

                // TODO: Get affiliated funder details from article pdh lookup
                // TODO: Get society details from profile
                // TODO: Get address details from profile
            }
        }
        return quoteDetails;
    }

    @Override
    public List<OrderDetails> getAllOrders(Integer userId, String type) {
        List<ArticleAuthorAssignment> articleAuthorAssignmentList = orderOnlineDAO
                .getArticleAuthId(userId, type);
        OrderDetails orderDetails = null;
        List<OrderDetails> lisofOrderDetails = new ArrayList<OrderDetails>();

        for (ArticleAuthorAssignment articleAuthorAssignment : articleAuthorAssignmentList) {
            orderDetails = new OrderDetails();
            orderDetails.setArticleId(articleAuthorAssignment.getArticles()
                    .getArticleId().toString());
            orderDetails.setPrice("0.0");
            PdhJournalResponse pdhLookup = orderservice
                    .pdhLookUpJournal(articleAuthorAssignment.getArticles()
                            .getDhId());
            orderDetails.setArticleTitle(pdhLookup.getTitle());
            for (Orders orders : articleAuthorAssignment.getOrderses()) {
                orderDetails.setOrderDate(orders.getUpdatedDate().toString());
                orderDetails.setStatus(orders.getOrderStatus());
            }
            lisofOrderDetails.add(orderDetails);
        }

        return lisofOrderDetails;

    }

    @Override
    public OrderResponse submitOnlineOpenOrder(String userId,
            OnlineOpenOrder onlineOpenOrder) {

        OrderRequest orderRequest = new OrderRequest();
        // TODO All the below hardcoded values need to changed once proper data
        // is provided.
        orderRequest.setApplicationKey("Key134");
        orderRequest.setCorrelationID("1234");
        OrderData orderData = getOrderDataForOnlineOpenOrder(onlineOpenOrder);
        orderRequest.setOrderData(orderData);
        orderRequest.setUserID("user001");

        OrderResponse orderResponse = (OrderResponse) StubInvokerUtil
                .invokeJsonStub("http://jsonstub.com/createOrder",
                        HttpMethod.POST, OrderResponse.class);

        Orders orders = new Orders();
        ArticleAuthorAssignment articleAuthorAssignment = new ArticleAuthorAssignment();
        // TODO: Set proper ArticleAuthId
        articleAuthorAssignment.setArticleAuthId(8);
        // orders.setArticleAuthorAssignment(articleAuthorAssignment);
        orders.setOrderType("");
        orders.setOoOaFlg(AuthorServicesConstants.OO_OA_FLAG_OO);
        orders.setOrderStatus(AuthorServicesConstants.ORDER_STATUS_SUBMIT);
        orders.setDownstreamappOrderId(Integer.parseInt(orderResponse
                .getOoUniqueId()));
        Users users = new Users();
        users.setUserId(Integer.parseInt(userId));
        orders.setUsersByCreatedBy(users);
        orders.setCreatedDate(new Date());
        orderOnlineDAO.saveOrUpdateOrder(orders);
        return orderResponse;
    }

    /**
     * This method returns the data of the requested Order.
     * 
     * @param onlineOpenOrder
     * @return OrderData
     */
    private OrderData getOrderDataForOnlineOpenOrder(
            OnlineOpenOrder onlineOpenOrder) {
        OrderData orderData = null;

        // TODO need to populate from OnlineOpenOrder object
        if (onlineOpenOrder != null) {
            orderData = new OrderData();
            orderData.setArticle(new ArticleData());
        }

        return orderData;

    }

    /**
     * This method returns the Discounted WOA Funder List
     * 
     * @param userId
     * @param DHID
     * @return List<String>
     * 
     */
    @Override
    public List<WOAFunder> retrieveDiscountedWOAFunderList(String userId,
            String DHID) {

        List<WOAFunder> woaFunderList = null;

        if (userId != null && DHID != null) {
            PdhArticleResponse pdhArticleResponse = orderservice
                    .pdhLookUpArticle(Integer.parseInt(DHID));

            woaFunderList = pdhArticleResponse.getWOAFunders().getWOAFunder();

        }

        return woaFunderList;
    }

    /**
     * This method returns the List of Societies which provide Society discounts
     * for the journal
     * 
     * @param userId
     * @param DHID
     * @return List<String>
     * 
     */
    @Override
    public List<String> retrieveSocietyDiscountListForJournal(String userId,
            String DHID) {
        // TODO Auto-generated method stub
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService
     * #saveLaterOrder(com.wiley.gr.ace.authorservices.model.OnlineOpenOrder)
     */
    @Override
    public void saveLaterOrder(OnlineOpenOrder order, String userId) {

        ObjectMapper mapper = new ObjectMapper();
        SavedOrders savedOrders = new SavedOrders();
        try {
            savedOrders.setOrderObject(mapper.writeValueAsString(order));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Articles articles = new Articles();
        articles.setArticleId(Integer.parseInt(order.getArticleId()));
        savedOrders.setArticles(articles);
        UserProfile userProfile = new UserProfile();
        userProfile.setUserId(Integer.parseInt(userId));
        savedOrders.setUserProfile(userProfile);
        Users users = new Users();
        users.setUserId(Integer.parseInt(userId));
        savedOrders.setUsersByCreatedBy(users);
        savedOrders.setCreatedDate(new Date());
        orderOnlineDAO.saveLaterOrder(savedOrders);
    }

}
