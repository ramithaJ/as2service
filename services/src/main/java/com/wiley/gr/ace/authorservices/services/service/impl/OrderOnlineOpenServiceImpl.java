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
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.AddressDetails;
import com.wiley.gr.ace.authorservices.model.Amount;
import com.wiley.gr.ace.authorservices.model.Discounts;
import com.wiley.gr.ace.authorservices.model.FunderDetails;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.external.OrderData;
import com.wiley.gr.ace.authorservices.model.external.PdhLookup;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.persistence.entity.ArticleAuthorAssignment;
import com.wiley.gr.ace.authorservices.persistence.entity.Articles;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
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
        onlineOpenOrder.setArticleId(orderData.getArticleId());
        onlineOpenOrder.setArticleId(orderData.getArticleId());
        onlineOpenOrder.setJournalId(orderData.getJournalId());
        onlineOpenOrder.setPaymentMethod(orderData.getPaymentMethod());
        onlineOpenOrder.setTaxPercentage(orderData.getTaxPercentage());
        Discounts discounts = new Discounts();
        discounts.setInstitutionId(orderData.getDiscountData()
                .getInstitutionId());
        discounts.setOtherDiscounts(orderData.getDiscountData()
                .getOtherDiscounts());
        discounts.setPromoCode(orderData.getDiscountData().getPromoCode());
        discounts.setSocietyId(orderData.getDiscountData().getSocietyId());
        onlineOpenOrder.setDiscounts(discounts);
        Amount amount = new Amount();
        amount.setAmount(orderData.getAmountPayable().getAmount());
        amount.setAmount(orderData.getAmountPayable().getCurrency());
        onlineOpenOrder.setAmountPayable(amount);
        FunderDetails funderDetails = new FunderDetails();
        List<FunderDetails> listoffunderdetails = new ArrayList<FunderDetails>();
        funderDetails.setFunderId(orderData.getFundingDetails().getFunderId());
        funderDetails.setResearchFunderId(orderData.getFundingDetails()
                .getResearchFunderId());
        funderDetails.setWoaAccountId(orderData.getFundingDetails()
                .getWoaAccountId());
        listoffunderdetails.add(funderDetails);
        onlineOpenOrder.setFunderDetails(listoffunderdetails);
        TaxDetails taxDetails = new TaxDetails();
        taxDetails.setCountryCode(orderData.getTaxDetails().getCountryCode());
        taxDetails.setTaxCodeExpiryDate(orderData.getTaxDetails()
                .getTaxCodeExpiryDate());
        taxDetails.setTaxExemptionNumber(orderData.getTaxDetails()
                .getTaxExemptionNumber());
        taxDetails.setVatExemptionNumber(orderData.getTaxDetails()
                .getVatExemptionNumber());
        taxDetails.setVatIdNumber(orderData.getTaxDetails().getVatIdNumber());
        onlineOpenOrder.setTaxDetails(taxDetails);
        Address address = new Address();
        address.setAddressLine1(orderData.getAddresses().get(0)
                .getAddressLine1());
        AddressDetails addressDetails = new AddressDetails();
        addressDetails.setAddress(null);

        return onlineOpenOrder;
    }

    /**
     * Method to get quote.
     */
    @Override
    public boolean getQuote(String userId, String articleId) {

        // Article details having userId and articleId
        Articles articles = orderOnlineDAO.getArticleDetails(articleId);
        if(null == articles){
            throw new ASException("801", "");
        }
        
        PdhLookup pdhLookup = orderservice.pdhLookUp(articles.getJournals().getDhId());
        // check article is onlineOpen article or not.
        if(pdhLookup.getPdmSalesModel().equalsIgnoreCase("OO")){
            
            // Article Author Assignment table details having userId and articleId.
            ArticleAuthorAssignment articleAuthorAssignment = orderOnlineDAO.getAritcleAssignmentDetails(userId, articleId);
            if(articleAuthorAssignment == null) {
                throw new ASException("802", "Article is not yet Accepted");
            }
            // check user is corresponding author or not.
            if(articleAuthorAssignment.getArticleRoles().getArticleRoleCd().equalsIgnoreCase("0001")) {
                
                // check is there any saved orders for this article.
                SavedOrders savedOrders = orderOnlineDAO.getSavedOrders(articleId, userId);
                if(null != savedOrders) {
                    throw new ASException("803", "Order already exists for this Article");
                }
                //check is there any placed orders for this article.
                Orders orders = orderOnlineDAO.getOrder(articleAuthorAssignment.getArticleAuthId());
                if(orders != null) {
                    throw new ASException("804", "Order already submitted for this Article");
                }
                // calling external service for article and journal titles.
                orderservice.pdhLookUpArticle(articles.getDhId());
                orderservice.pdhLookUp(articles.getJournals().getDhId()); 
                Quote quote = orderservice.getQuote(articleId);
                
            }
        }
        
        return false;
    }
    
}
