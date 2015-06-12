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
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

/**
 * @author virtusa
 * version 1.0
 */
public class Order {
    
    
    private String articleId;
    
    private String journalId;
    
    private String orderType;
    
    private Pricing pricing;
    
    private Discount discount;
    
    private Affiliation affiliation;
    
    private String paymentMethod;
    
    private CreditCard creditCard;
    
    private TaxDetails taxDetails;
    
    private List<AddressInformation> addresses;
    
    private Customer customer;
    
    private FundingDetails fundingDetails;

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Pricing getPricing() {
        return pricing;
    }

    public void setPricing(Pricing pricing) {
        this.pricing = pricing;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public Affiliation getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public TaxDetails getTaxDetails() {
        return taxDetails;
    }

    public void setTaxDetails(TaxDetails taxDetails) {
        this.taxDetails = taxDetails;
    }

    public List<AddressInformation> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<AddressInformation> addresses) {
        this.addresses = addresses;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public FundingDetails getFundingDetails() {
        return fundingDetails;
    }

    public void setFundingDetails(FundingDetails fundingDetails) {
        this.fundingDetails = fundingDetails;
    }
    
    
}
