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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.service.InvoiceService;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.AddressDetails;
import com.wiley.gr.ace.authorservices.model.Amount;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.Discounts;
import com.wiley.gr.ace.authorservices.model.FunderDetails;
import com.wiley.gr.ace.authorservices.model.FundingOrganizations;
import com.wiley.gr.ace.authorservices.model.GrantRecipients;
import com.wiley.gr.ace.authorservices.model.Grants;
import com.wiley.gr.ace.authorservices.model.Institution;
import com.wiley.gr.ace.authorservices.model.InstitutionalDiscounts;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.PaymentDetails;
import com.wiley.gr.ace.authorservices.model.Prices;
import com.wiley.gr.ace.authorservices.model.QuoteDetail;
import com.wiley.gr.ace.authorservices.model.QuoteDetails;
import com.wiley.gr.ace.authorservices.model.Recipients;
import com.wiley.gr.ace.authorservices.model.RequestOnlineOpen;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.SocietyDiscounts;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.WOAAccountFunders;
import com.wiley.gr.ace.authorservices.model.WOAAccountHolders;
import com.wiley.gr.ace.authorservices.model.external.Article;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.CancelOrderRequest;
import com.wiley.gr.ace.authorservices.model.external.ContactAddress;
import com.wiley.gr.ace.authorservices.model.external.Customer;
import com.wiley.gr.ace.authorservices.model.external.DiscountedSociety;
import com.wiley.gr.ace.authorservices.model.external.DiscountedSocietyResponse;
import com.wiley.gr.ace.authorservices.model.external.Institute;
import com.wiley.gr.ace.authorservices.model.external.InstitutionDiscountsResponse;
import com.wiley.gr.ace.authorservices.model.external.Invoice;
import com.wiley.gr.ace.authorservices.model.external.OrderData;
import com.wiley.gr.ace.authorservices.model.external.OrderDataList;
import com.wiley.gr.ace.authorservices.model.external.OrderRequest;
import com.wiley.gr.ace.authorservices.model.external.OrderResponse;
import com.wiley.gr.ace.authorservices.model.external.Payment;
import com.wiley.gr.ace.authorservices.model.external.PdhArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.PricingData;
import com.wiley.gr.ace.authorservices.model.external.ResearchFunderElement;
import com.wiley.gr.ace.authorservices.model.external.Societies;
import com.wiley.gr.ace.authorservices.model.external.SocietyMemberDiscount;
import com.wiley.gr.ace.authorservices.model.external.TaskServiceRequest;
import com.wiley.gr.ace.authorservices.model.external.TaxData;
import com.wiley.gr.ace.authorservices.model.external.WOAAccount;
import com.wiley.gr.ace.authorservices.model.external.WOAFunder;
import com.wiley.gr.ace.authorservices.model.external.WPGConfiguration;
import com.wiley.gr.ace.authorservices.model.external.WileyOpenAccessFunders;
import com.wiley.gr.ace.authorservices.model.external.WoaAccountHolder;
import com.wiley.gr.ace.authorservices.persistence.entity.CoauthorRequestsOoorders;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;

/**
 * The Class OrderOnlineOpenServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class OrderOnlineOpenServiceImpl implements OrderOnlineOpenService {

    /** Getting Bean Of Order Service. */
    @Autowired(required = true)
    private OrderService orderservice;

    /** Getting Bean Of OrderOnlineDAO Service. */
    @Autowired(required = true)
    private OrderOnlineDAO orderOnlineDAO;

    // /** The user profiles. */
    // @Autowired
    // private UserProfiles userProfiles;

    /** The invoiceservice. */
    @Autowired(required = true)
    private InvoiceService invoiceservice;

    // @Autowired(required=true)
    // private TaskService taskService;
    // /**
    // * This field holds the value of correspondingAuthorId.
    // */
    // @Value("${CorrespondingAuthorId}")
    // private String correspondingAuthorId;
    //
//    /**
//     * This field holds the value of articleDetailsCode.
//     */
//    @Value("${articleDetails.code}")
//    private String articleDetailsCode;
//
//    /**
//     * This field holds the value of articleDetailsMessage.
//     */
//    @Value("${articleDetails.message}")
//    private String articleDetailsMessage;
    //
    // /**
    // * This field holds the value of articleAcceptanceCode.
    // */
    // @Value("${articleAcceptance.code}")
    // private String articleAcceptanceCode;
    //
    // /**
    // * This field holds the value of articleAcceptanceMessage.
    // */
    // @Value("${articleAcceptance.message}")
    // private String articleAcceptanceMessage;
    //
    // /**
    // * This field holds the value of savedOrderCode.
    // */
    // @Value("${savedOrder.code}")
    // private String savedOrderCode;
    //
    // /**
    // * This field holds the value of savedOrderMessage.
    // */
    // @Value("${savedOrder.message}")
    // private String savedOrderMessage;
    //
    // /**
    // * This field holds the value of orderExistenceCode.
    // */
    // @Value("${orderExistence.code}")
    // private String orderExistenceCode;
    //
    // /**
    // * This field holds the value of orderExistenceMessage.
    // */
    // @Value("${orderExistence.message}")
    // private String orderExistenceMessage;
    //
    // /**
    // * This field holds the value of onlineOpenCode.
    // */
    // @Value("${OnlineOpen.code}")
    // private String onlineOpenCode;
    //
    // /**
    // * This field holds the value of onlineOpenMessage.
    // */
    // @Value("${OnlineOpen.message}")
    // private String onlineOpenMessage;
    //
    // /**
    // * This field holds the value of onlineOpenJournalCode.
    // */
    // @Value("${OnlineOpenJournal.code}")
    // private String onlineOpenJournalCode;
    //
    // /**
    // * This field holds the value of OnlineOpenJournalMessage.
    // */
    // @Value("${OnlineOpenJournal.message}")
    // private String OnlineOpenJournalMessage;

    /**
     * This field holds the value of jsonProcessingExceptionCode.
     */
    /*
     * @Value("${JsonProcessingException}") private String
     * jsonProcessingExceptionCode;
     */

    /**
     * This field holds the value of applicationKey.
     */
    @Value("${OnlineOpenProperties.applicationKey}")
    private String applicationKey;

    /**
     * This field holds the value of correlationId.
     */
    @Value("${OnlineOpenProperties.correlationId}")
    private String correlationId;

    /*
     * WPG Configuration property values
     */

    /** The acquirer id. */
    @Value("${wpgAcquirerId}")
    private String acquirerId;

    /** The wpg vendor id. */
    @Value("${wpgVendorId}")
    private String wpgVendorId;

    /** The wpg vendor password. */
    @Value("${wpgVendorPassword}")
    private String wpgVendorPassword;

    /** The wpg method. */
    @Value("${wpgMethod}")
    private String wpgMethod;

    /** The wpg description. */
    @Value("${wpgDescription}")
    private String wpgDescription;

    /** The wpg country code. */
    @Value("${wpgCountryCode}")
    private String wpgCountryCode;

    /** The wpg allow avs fail. */
    @Value("${wpgAllowAVSFail}")
    private String wpgAllowAVSFail;

    /** The wpg region. */
    @Value("${wpgRegion}")
    private String wpgRegion;

    // Cancel order request values from property file
    /**
     * This field holds the value of cancelOrderCorrelationID.
     */
    @Value("${cancelOrder.CorrelationID}")
    private String cancelOrderCorrelationID;

    /**
     * This field holds the value of cancelOrderApplicationKey.
     */
    @Value("${cancelOrder.ApplicationKey}")
    private String cancelOrderApplicationKey;

    /**
     * This field holds the value of cancelOrderUserID.
     */
    @Value("${cancelOrder.UserID}")
    private String cancelOrderUserID;

    /**
     * This field holds the value of cancelOrderCancelReasonCode.
     */
    @Value("${cancelOrder.cancelReasonCode}")
    private String cancelOrderCancelReasonCode;

    /**
     * Min value for Transaction id.
     *
     * @param userId
     *            the user id
     * @param orderId
     *            the order id
     * @return the online open order details
     */
    // private static final int MIN_VALUE = 1;

    /**
     * This method will take userId and orderId as input and calls external
     * service to get details of Online order details
     * 
     * @param userId
     *            - the request value
     * @param orderId
     *            - the request value
     * @return OnlineOpenOrder
     */
    @Override
    public final OnlineOpenOrder getOnlineOpenOrderDetails(final String userId,
            final String orderId) {
        OnlineOpenOrder onlineOpenOrder = new OnlineOpenOrder();
        OrderData orderData = new OrderData();
        OrderDataList orderDataList = orderservice.getOrderDetails(userId,
                orderId);
        orderData = orderDataList.getOrderDatas().get(0);
        ArticleDetails articleDetails = new ArticleDetails();
        articleDetails.setArticleId(orderData.getArticle().getAidECORE());
        articleDetails
                .setArticleTitle(orderData.getArticle().getArticleTitle());
        onlineOpenOrder.setArticleDetails(articleDetails);
        JournalDetails journalDetails = new JournalDetails();
        journalDetails.setJournalId(orderData.getArticle().getJournal()
                .getJournalID());
        journalDetails.setJournalTitle(orderData.getArticle().getJournal()
                .getJournalTitle());
        onlineOpenOrder.setJournalDetails(journalDetails);
        onlineOpenOrder
                .setAuthorName(orderData.getWoaAccountHolder().getName());
        QuoteDetail quoteDetail = new QuoteDetail();
        Prices prices = new Prices();
        List<Prices> pricesList = new ArrayList<Prices>();
        prices.setCurrency(orderData.getPricing().getCurrency());
        prices.setPrice(orderData.getPricing().getProductBasePrice().toString());
        pricesList.add(prices);
        quoteDetail.setPrices(pricesList);
        onlineOpenOrder.setQuoteDetail(quoteDetail);
        FunderDetails funderDetails = new FunderDetails();
        /*
         * funderDetails.setResearchFunderId(orderData.getWoaAccountHolder()
         * .getName());
         */
        funderDetails
                .setWoaAccountId(orderData.getWoaAccountHolder().getCode());
        List<Grants> grantsList = new ArrayList<Grants>();
        Grants grants = new Grants();
        Recipients recipients = new Recipients();
        List<Recipients> recipentsList = new ArrayList<Recipients>();
        recipentsList.add(recipients);
        grants.setRecipientsList(recipentsList);
        grantsList.add(grants);
        funderDetails.setGrants(grantsList);
        List<FunderDetails> funderDetailsList = new ArrayList<FunderDetails>();
        funderDetailsList.add(funderDetails);
        onlineOpenOrder.setFunderDetails(funderDetailsList);
        Discounts discounts = new Discounts();
        List<Discounts> discountsList = new ArrayList<Discounts>();
        discounts.setSocietyId(orderData.getPricing().getDiscounts()
                .getDiscount().getSocietyData().getPromoCode());
        discounts.setPromoCode(orderData.getPricing().getDiscounts()
                .getDiscount().getPromoCode());
        discountsList.add(discounts);
        onlineOpenOrder.setDiscountDetails(discountsList);
        onlineOpenOrder.setPaymentMethod(orderData.getPayment()
                .getPaymentMethod());
        TaxDetails taxDetails = new TaxDetails();
        taxDetails
                .setTaxCountryCode(orderData.getTaxDetails().getCountryCode());
        taxDetails.setTaxExemptionNumber(orderData.getTaxDetails()
                .getVatExemptionNumber());
        taxDetails.setTaxCodeExpiryDate(orderData.getTaxDetails()
                .getTaxExpiration());
        taxDetails.setVatExemptionNumber(orderData.getTaxDetails()
                .getVatExemptionNumber());
        taxDetails.setVatIdNumber(orderData.getTaxDetails().getVatIdNumber());
        onlineOpenOrder.setTaxDetails(taxDetails);
        Amount amount = new Amount();
        amount.setAmount(orderData.getPricing().getAmountToBePaid().toString());
        amount.setCurrency(orderData.getPricing().getCurrency());
        onlineOpenOrder.setAmountPayable(amount);
        Amount finalAmount = new Amount();
        onlineOpenOrder.setFinalAmount(finalAmount);
        onlineOpenOrder.setPaymentMethod(orderData.getPayment()
                .getPaymentMethod());
        Address contactAddress = new Address();
        contactAddress.setFirstName(orderData.getContactAddress().getName());
        contactAddress.setLastName(orderData.getContactAddress().getName());
        contactAddress.setDepartmentName(orderData.getContactAddress()
                .getDepartment());
        contactAddress.setAddressLine1(orderData.getContactAddress()
                .getAdditionalStreet());
        contactAddress.setAddressLine2(orderData.getContactAddress()
                .getAdditionalStreet());
        contactAddress.setCity(orderData.getContactAddress().getCity());
        contactAddress.setState(orderData.getContactAddress().getState());
        Country country = new Country();
        country.setCountryName(orderData.getContactAddress().getCountry());
        contactAddress.setCountry(country);
        contactAddress.setPostCode(orderData.getContactAddress().getZip());
        contactAddress.setPhoneNumber(orderData.getContactAddress()
                .getPhoneNumber());
        contactAddress.setEmailId(orderData.getContactAddress().getEmail());
        AddressDetails addressDetails = new AddressDetails();
        addressDetails.setBillingAddress(contactAddress);

        Address billingAddress = new Address();
        billingAddress.setFirstName(orderData.getBillingAddress().getName());
        billingAddress.setLastName(orderData.getBillingAddress().getName());
        billingAddress.setDepartmentName(orderData.getBillingAddress()
                .getDepartment());
        billingAddress.setAddressLine1(orderData.getBillingAddress()
                .getAdditionalStreet());
        billingAddress.setAddressLine2(orderData.getBillingAddress()
                .getAdditionalStreet());
        billingAddress.setCity(orderData.getBillingAddress().getCity());
        billingAddress.setState(orderData.getBillingAddress().getState());
        Country countryBilling = new Country();
        countryBilling.setCountryName(orderData.getBillingAddress()
                .getCountry());
        billingAddress.setCountry(countryBilling);
        billingAddress.setPostCode(orderData.getBillingAddress().getZip());
        billingAddress.setPhoneNumber(orderData.getBillingAddress()
                .getPhoneNumber());
        billingAddress.setEmailId(orderData.getBillingAddress().getEmail());
        addressDetails.setContactAddress(contactAddress);
        addressDetails.setBillingAddress(billingAddress);
        onlineOpenOrder.setAddressDetails(addressDetails);
        Amount taxAmount = new Amount();
        onlineOpenOrder.setTaxAmount(taxAmount);
        return onlineOpenOrder;
    }

    /**
     * Method to get quote.
     * 
     * @param userId
     *            - the request value
     * @param articleId
     *            - the request value
     * @param pdmSalesFlag
     *            - the request value
     * @return QuoteDetails
     */
    @Override
    public final QuoteDetails initiateOnline(final String userId,
            final String articleId, final String pdmSalesFlag) {
        /*
         * QuoteDetails quoteDetails = null; ProductRelations productRelations =
         * orderOnlineDAO .getProductRelations(articleId); if (null ==
         * productRelations) { throw new ASException(articleDetailsCode,
         * articleDetailsMessage); }
         */
        // // Calling PdhLookUpJornal service with jornalDhId
        // PdhJournalResponse pdhLookup = orderservice
        // .pdhLookUpJournal(Integer.parseInt(String.valueOf(productRelations.getProductsByParentDhId()
        // .getDhId())));
        // // UI OnLoad object for OrderOnlineOpen order.
        // //QuoteDetails quoteDetails = null;
        // // check article is onlineOpen article or not.
        // if (pdmSalesFlag.equalsIgnoreCase(pdhLookup.getPdmSalesModel())) {
        //
        // // DB call to get ProductPersonRelations object.
        // ProductPersonRelations productPersonRelations = orderOnlineDAO
        // .getProductPersonRelations(userId, articleId);
        // if (productPersonRelations == null) {
        // throw new ASException(articleAcceptanceCode,
        // articleAcceptanceMessage);
        // }
        // // check user is corresponding author or not.
        // if (productPersonRelations.getProductRoles() != null
        // && productPersonRelations.getProductRoles()
        // .getProductRoleCd()
        // .equalsIgnoreCase(correspondingAuthorId)) {
        //
        // // check is there any saved orders for this article.
        // SavedOrders savedOrders = orderOnlineDAO.getSavedOrders(
        // articleId, userId);
        // if (null != savedOrders) {
        // throw new ASException(savedOrderCode, savedOrderMessage);
        // }
        // // check is there any placed orders for this article.
        // Orders orders = orderOnlineDAO.getOrder(articleId, userId);
        // if (orders != null) {
        // throw new ASException(orderExistenceCode,
        // orderExistenceMessage);
        // }
        // quoteDetails = new QuoteDetails();
        // // calling PdhLookupArticle service with article DhId for
        // // article title.
        // PdhArticleResponse pdhArticleResponse = orderservice
        // .pdhLookUpArticle(Integer.parseInt(String.valueOf(productPersonRelations.getProducts()
        // .getDhId())));
        // // Article details (ArticleId and Article title)
        // ArticleDetails articleDetails = new ArticleDetails();
        // articleDetails.setArticleId(articleId);
        // articleDetails.setArticleTitle(pdhArticleResponse.getTitle());
        // quoteDetails.setArticleDetails(articleDetails);
        // // Journal details (JornalId and jornalTitle)
        // JournalDetails journalDetails = new JournalDetails();
        // journalDetails.setJournalId(productRelations
        // .getProductsByParentDhId().getDhId() + "");
        // journalDetails.setJournalTitle(pdhLookup.getTitle());
        // quoteDetails.setJournalDetails(journalDetails);
        //
        // // prices in 3 type of currencies
        // QuoteDetail quoteDetail = new QuoteDetail();
        // quoteDetail.setPrices(pdhArticleResponse.getPrices());
        // quoteDetails.setQuoteDetail(quoteDetail);
        //
        // // values of DiscountsAllowed and AdditionalDiscountAllowed
        // quoteDetails.setDiscountsAllowed(pdhLookup
        // .getDiscountsAllowed());
        // quoteDetails.setAdditionalDiscountAllowed(pdhLookup
        // .getAdditionalDiscountAllowed());
        // // userProfile object form userProfile service for society
        // // details and addressDetails
        // LookupCustomerProfileResponse userProfileResponse = userProfiles
        // .getLookupCustomerProfile(userId).getLookupCustomerProfileResponse();
        // // First and LastName of author
        // quoteDetails.setAuthorName(userProfileResponse
        // .getCustomerProfile().getCustomerDetails()
        // .getfName()
        // + " "
        // + userProfileResponse.getCustomerProfile()
        // .getCustomerDetails().getlName());
        // // GrantRecipients(coAuthors)
        // userProfileResponse.getCustomerProfile().getCoAuthors();
        // // Societies
        // userProfileResponse.getCustomerProfile().getSocietyList();
        // // billing and contact addresses
        // AddressDetails addressDetails = new AddressDetails();
        // // addressDetails.setBillingAddress(userProfileResponse
        // // .getCustomerProfile().getAddressDetails().get(1)
        // // .getBillingAddress());
        // // addressDetails.setContactAddress(userProfileResponse
        // // .getCustomerProfile().getAddressDetails().getAddress().get(0));
        // quoteDetails.setAddressDetails(addressDetails);
        //
        // } else {
        // throw new ASException(onlineOpenCode, onlineOpenMessage);
        // }
        // } else {
        // throw new ASException(onlineOpenJournalCode,
        // OnlineOpenJournalMessage);
        // }
        return null;
    }

    /**
     * Method to get All Orders.
     *
     * @param orderId
     *            the order id
     * @return list
     */
    @Override
    public final List<OrderDetails> getAllOrders(final String orderId) {
        OrderDetails orderDetails = new OrderDetails();
        List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
        OrderDataList orderDataList = orderservice.getAllOrders(orderId);
        for (OrderData orderData : orderDataList.getOrderDatas()) {
            orderDetails.setArticleId(orderData.getArticle().getDhId());
            orderDetails.setArticleTitle(orderData.getArticle()
                    .getArticleTitle());
            orderDetails.setOrderDate(orderData.getOrderDate());
            orderDetails.setPrice(orderData.getPricing().getAmountToBePaid()
                    .toString());
            orderDetails.setStatus(orderData.getOrderStatusCode());
            orderDetails.setOrderId(orderData.getOoUniqueId());
            String type = orderData.getOrderType();
            if ("AUTHOR_PAID".equalsIgnoreCase(type)) {
                orderDetails.setOrderType("onlineopen");
            } else {
                orderDetails.setOrderType("openaccess");
            }
        }

        orderDetailsList.add(orderDetails);
        return orderDetailsList;

    }

    /**
     * This method submits the online open order and returns the order response.
     *
     * @param userId
     *            - the request value
     * @param orderId
     *            - the request value
     * @param orderTypeFlag
     *            - the request value
     * @return OrderResponse
     */
    @Override
    public final OrderResponse submitOnlineOpenOrder(final String userId,
            final String orderId, final String orderTypeFlag) {

        OrderResponse orderResponse = null;

        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setApplicationKey(applicationKey);
        orderRequest.setCorrelationID(correlationId);
        OrderData orderData = null;
        orderData = getOrderDataForOnlineOpenOrder(orderId);
        orderRequest.setOrderData(orderData);
        orderRequest.setUserID(userId);

        orderResponse = orderservice.submitOnlineOpenOrder(orderRequest);

        Orders orders = new Orders();
        // orders.setOrderTypes(new OrderTypes());
        // orders.setOoOaFlg(orderTypeFlag);
        orders.setOrderId(Integer.parseInt(orderId));
        // orders.setOrderStatus(AuthorServicesConstants.ORDER_STATUS_SUBMIT);
        // Products products = new Products(Integer.parseInt(orderData
        // .getArticle().getDhId()));
        // orders.setProducts(products);
        // //
        // orders.setDownstreamappOrderId(Integer.parseInt(orderResponse.getOoUniqueId()));
        // Users users = new Users();
        // users.setUserId(Long.valueOf(userId));
        // orders.setUsersByCreatedBy(users);
        // orders.setUsersByUserId(users);
        orders.setCreatedDate(new Date());
        orderOnlineDAO.saveOrder(orders);
        Long longOrderId = orders.getOrderId();
        orderOnlineDAO.deleteSavedOrderPostOrderSubmission(longOrderId
                .intValue());

        return orderResponse;
    }

    /**
     * This method returns the data of the requested Order.
     * 
     * @param orderId
     *            - the request value
     * @return orderData
     */
    private final OrderData getOrderDataForOnlineOpenOrder(final String orderId) {
        OrderData orderData = null;
        SavedOrders savedOrder = null;
        OnlineOpenOrder onlineOpenOrder = null;

        savedOrder = orderOnlineDAO.getSavedOrdersForTheOrderId(orderId);

        onlineOpenOrder = getOrderDetails(null, savedOrder);
        orderData = new OrderData();

        if (onlineOpenOrder != null) {
            ArticleData articleData = new ArticleData();
            // articleData.setDhId(String.valueOf(savedOrder.getProducts().getDhId()));
            orderData.setArticle(articleData);
            AddressDetails address = onlineOpenOrder.getAddressDetails();

            ContactAddress billingAddress = new ContactAddress();
            // TODO: Need to set remaining objects
            billingAddress.setName(address.getBillingAddress().getFirstName()
                    + address.getBillingAddress().getLastName());
            // billingAddress.setOrg(address.getBillingAddress().getInstitution());

            orderData.setBillingAddress(billingAddress);

            ContactAddress contactAddress = new ContactAddress();
            // TODO: Need to set remaining objects
            contactAddress.setName(address.getContactAddress().getFirstName()
                    + address.getBillingAddress().getLastName());
            // contactAddress.setOrg(address.getContactAddress().getInstitution());
            orderData.setContactAddress(contactAddress);

            TaxData taxData = new TaxData();
            taxData.setCountryCode(onlineOpenOrder.getTaxDetails()
                    .getTaxCountryCode());
            taxData.setTaxExpiration(onlineOpenOrder.getTaxDetails()
                    .getTaxCodeExpiryDate());
            taxData.setTaxNumber(onlineOpenOrder.getTaxDetails()
                    .getTaxExemptionNumber());
            taxData.setVatExemptionNumber(onlineOpenOrder.getTaxDetails()
                    .getVatExemptionNumber());
            taxData.setVatIdNumber(onlineOpenOrder.getTaxDetails()
                    .getVatIdNumber());
            orderData.setTaxDetails(taxData);

            PricingData pricingData = new PricingData();
            String amountToBePaidValue = onlineOpenOrder.getFinalAmount()
                    .getAmount();
            if (amountToBePaidValue != null
                    && !"".equals(amountToBePaidValue.trim())) {
                Double.parseDouble(amountToBePaidValue);
            }
            pricingData.setCurrency(onlineOpenOrder.getFinalAmount()
                    .getCurrency());
            orderData.setPricing(pricingData);

            Payment payment = new Payment();
            payment.setPaymentMethod(onlineOpenOrder.getPaymentMethod());
            orderData.setPayment(payment);

            WoaAccountHolder woaAccountHolder = processWOAAccount(onlineOpenOrder);

            /*
             * woaAccountHolder.setCode(onlineOpenOrder.getFunderDetails().get(0)
             * .getWoaAccountId());
             */

            orderData.setWoaAccountHolder(woaAccountHolder);

            orderData.setSpecialNotes("");
            orderData.setCustomer(new Customer());
            orderData.setEnteredBy("");
            orderData.setOoUniqueId("");
            orderData.setOrderDate(new Date().toString());
            orderData.setOrderSource("");
            orderData.setOrderStatusCode("");
            orderData.setOrderSubType("");
            orderData.setOrderType("");
            orderData.setPoNumber("");
            orderData.setReferenceOoUniqueId("");

        }

        return orderData;

    }

    /**
     * This method send the WOAFunder with the correct WOA Account to the OO
     * app.
     * 
     * @param onlineOpenOrder
     * @return onlineOpenOrder
     */
    private WoaAccountHolder processWOAAccount(
            final OnlineOpenOrder onlineOpenOrder) {

        WoaAccountHolder woaAccountHolder = null;
        WOAAccount selectedWOAAccount = null;
        List<WOAAccount> woaAccountList = onlineOpenOrder.getWoaFunder()
                .getWOAAccounts().getWOAAccount();
        List<WOAAccount> nonRestrictedWOAAccountList = null;
        List<WOAAccount> restrictedWOAAccountList = null;
        Integer countOfRA = 0;
        Integer countOfNRA = 0;

        List<FunderDetails> funderDetailsList = onlineOpenOrder
                .getFunderDetails();

        if (woaAccountList != null) {
            woaAccountHolder = new WoaAccountHolder();

            if (woaAccountList.size() == 1) {
                woaAccountHolder.setCode(funderDetailsList.get(0)
                        .getWoaAccountId());

            } else if (woaAccountList.size() > 1) {

                nonRestrictedWOAAccountList = retrieveNonRestrictedWOAAccountList(
                        nonRestrictedWOAAccountList, woaAccountList);

                restrictedWOAAccountList = retrieveRestrictedWOAAccountList(
                        restrictedWOAAccountList, woaAccountList);

                countOfRA = restrictedWOAAccountList.size();
                countOfNRA = nonRestrictedWOAAccountList.size();

                if (countOfNRA == 1 && countOfRA > 0) {

                    selectedWOAAccount = getSelectedWOAAccount(
                            funderDetailsList, restrictedWOAAccountList,
                            selectedWOAAccount);

                } else if (countOfNRA == 0 && countOfRA > 0) {

                    selectedWOAAccount = getSelectedWOAAccount(
                            funderDetailsList, restrictedWOAAccountList,
                            selectedWOAAccount);
                }

                if (selectedWOAAccount != null) {
                    woaAccountHolder.setCode(selectedWOAAccount.getCode());
                    woaAccountHolder.setName(selectedWOAAccount.getName());
                } else {

                    woaAccountHolder.setCode(nonRestrictedWOAAccountList.get(0)
                            .getCode());
                    woaAccountHolder.setName(nonRestrictedWOAAccountList.get(0)
                            .getName());
                }

            }

        }
        return woaAccountHolder;

    }

    /**
     * This method retrieves the selected WOAAccount
     * 
     * @param funderDetailsList
     * @param restrictedWOAAccountList
     * @param selectedWOAAccount
     * @return selectedWOAAccount
     */
    private WOAAccount getSelectedWOAAccount(
            final List<FunderDetails> funderDetailsList,
            final List<WOAAccount> restrictedWOAAccountList,
            WOAAccount selectedWOAAccount) {
        if (!funderDetailsList.isEmpty() && funderDetailsList.size() == 1) {

            String doi = orderservice.getResearchFunderDOI(funderDetailsList
                    .get(0).getFunderId());

            for (WOAAccount woaAccount : restrictedWOAAccountList) {
                if (doi.equals(woaAccount.getResearchFunders()
                        .getResearchfunder().get(0).getDoi())) {
                    selectedWOAAccount = woaAccount;
                    break;
                }
            }

        }
        return selectedWOAAccount;
    }

    /**
     * This method returns the non restricted WOA Acounts.
     *
     * @param nonRestrictedWOAAccountList
     *            - the request value
     * @param woaAccountList
     *            - the request value
     * @return list
     */
    private final List<WOAAccount> retrieveNonRestrictedWOAAccountList(
            List<WOAAccount> nonRestrictedWOAAccountList,
            final List<WOAAccount> woaAccountList) {

        if (woaAccountList != null) {
            nonRestrictedWOAAccountList = new ArrayList<WOAAccount>();

            for (Iterator<WOAAccount> iterator = woaAccountList.iterator(); iterator
                    .hasNext();) {
                WOAAccount woaAccount = iterator.next();

                if (woaAccount.getResearchFunders().getResearchfunder()
                        .isEmpty()) {
                    nonRestrictedWOAAccountList.add(woaAccount);
                }

            }

        }

        return nonRestrictedWOAAccountList;
    }

    /**
     * This method returns the restricted WOA Acounts
     * 
     * @param nonRestrictedWOAAccountList
     *            - the request value
     * @param woaAccountList
     *            - the request value
     * @return list
     */
    private final List<WOAAccount> retrieveRestrictedWOAAccountList(
            List<WOAAccount> restrictedWOAAccountList,
            final List<WOAAccount> woaAccountList) {

        if (woaAccountList != null) {
            restrictedWOAAccountList = new ArrayList<WOAAccount>();

            for (Iterator<WOAAccount> iterator = woaAccountList.iterator(); iterator
                    .hasNext();) {
                WOAAccount woaAccount = iterator.next();

                if (!(woaAccount.getResearchFunders().getResearchfunder()
                        .isEmpty())) {
                    restrictedWOAAccountList.add(woaAccount);
                }

            }

        }

        return restrictedWOAAccountList;
    }

    /**
     * This method returns the Discounted WOA Funder List.
     *
     * @param DHID
     *            - the request value
     * @return List
     */
    @Override
    public final List<WOAFunder> retrieveDiscountedWOAFunderList(
            final String DHID) {

        List<WOAFunder> woaFunderList = null;

        PdhArticleResponse pdhArticleResponse = orderservice
                .pdhLookUpArticle(Integer.parseInt(DHID));

        woaFunderList = pdhArticleResponse.getWOAFunders().getWOAFunder();

        return woaFunderList;
    }

    /**
     * This method returns the List of Societies which provide Society discounts
     * for the journal.
     *
     * @param DHID
     *            the dhid
     * @return List
     */
    @Override
    public final List<DiscountedSociety> retrieveSocietyDiscountListForJournal(
            final String DHID) {
        List<DiscountedSociety> discountedSocietyListForJournal = null;
        String journalAcronym = null;

        // TODO: Need to implement the retrival of jrnl acronym
        DiscountedSocietyResponse discountedSocietiesResponse = orderservice
                .getDiscountedSocietiesForJournal(journalAcronym);

        if (discountedSocietiesResponse != null) {
            discountedSocietyListForJournal = discountedSocietiesResponse
                    .getSocieties();
        }
        return discountedSocietyListForJournal;
    }

    /**
     * Method to save orders.
     * 
     * @param order
     *            - the request value
     * @param userId
     *            - the request value
     * @return integer
     */
    @Override
    public final Integer saveLaterOrder(final OnlineOpenOrder order,
            final String userId) {

        // final ObjectMapper mapper = new ObjectMapper();
        final SavedOrders savedOrders = new SavedOrders();
        // Checking is there any existing saved orders in saved orders table
        SavedOrders orders = orderOnlineDAO.verifySavedOrders(order
                .getArticleDetails().getArticleId(), userId);
        if (null != orders) {
            savedOrders.setOrderId(orders.getOrderId());
        }
        // final Products products = new Products();
        // products.setDhId(Integer.parseInt(order.getArticleDetails()
        // .getArticleId()));
        // savedOrders.setProducts(products);
        //
        // final Users users = new Users();
        // users.setUserId(Long.valueOf(userId));
        // savedOrders.setUsersByUserId(users);
        // savedOrders.setUsersByCreatedBy(users);
        savedOrders.setCreatedDate(new Date());
        return orderOnlineDAO.saveLaterOrder(savedOrders);
    }

    /**
     * This method checks if additional discount is available for the journal.
     *
     * @param DHID
     *            the dhid
     * @return boolean
     */
    @Override
    public final boolean isAdditionDiscountAvailableForJournal(final String DHID) {
        boolean isAdditionDiscountAvailable = false;
        // Need confirmation on DHID or journal id.

        // TODO: Need to create a request object when provided.

        // TODO: Need to check if journalId or DHId should be passed
        PdhJournalResponse pdhLookupJournal = orderservice
                .pdhLookUpJournal(Integer.parseInt(DHID));
        isAdditionDiscountAvailable = Boolean.getBoolean(pdhLookupJournal
                .getAdditionalDiscountAllowed());

        return isAdditionDiscountAvailable;
    }

    /**
     * Method to get WOA accounts.
     * 
     * @return woaAccountHolders
     */
    @Override
    public final WOAAccountHolders getWOAFunders() {

        WileyOpenAccessFunders wileyOpenAccessFunders = orderservice
                .getWoaAcounts();
        List<WOAFunder> woaFundersList = wileyOpenAccessFunders.getWoaFunders()
                .getWOAFunder();
        List<WOAAccountFunders> woaAccountFundersList = new ArrayList<WOAAccountFunders>();
        WOAAccountFunders woaAccountFunders = null;
        WOAAccountHolders woaAccountHolders = new WOAAccountHolders();
        for (WOAFunder woaFunder : woaFundersList) {
            woaAccountFunders = new WOAAccountFunders();
            woaAccountFunders.setWoaFunderId(woaFunder.getId());
            woaAccountFunders.setWoaFunderName(woaFunder.getName());
            List<WOAAccount> woaAccountList = woaFunder.getWOAAccounts()
                    .getWOAAccount();
            for (WOAAccount woaAccount : woaAccountList) {
                if (null == woaAccount.getResearchFunders()) {
                    woaAccountFunders.setAllRestricted(false);
                } else {
                    woaAccountFunders.setAllRestricted(true);
                }
                woaAccountFundersList.add(woaAccountFunders);
            }
        }
        woaAccountHolders.setWoaFunders(woaAccountFundersList);
        return woaAccountHolders;
    }

    /**
     * Method to get Grant Recipients.
     * 
     * @param articleId
     *            - the request value
     * @return list
     */
    @Override
    public final List<GrantRecipients> getGrantRecipients(final String articleId) {

        // List<ProductPersonRelations> productPersonRelationsList =
        // orderOnlineDAO
        // .getGrantRecipients(articleId);
        List<GrantRecipients> grantRecipientsList = new ArrayList<GrantRecipients>();
        // GrantRecipients grantRecipients = null;
        // for (ProductPersonRelations productPersonRelations :
        // productPersonRelationsList) {
        // Users users = productPersonRelations.getUserProfile()
        // .getUsersByUserId();
        // grantRecipients = new GrantRecipients();
        // grantRecipients.setCode(String.valueOf(users.getUserId()));
        // grantRecipients.setName(users.getFirstName() + " "
        // + users.getLastName());
        // grantRecipientsList.add(grantRecipients);
        // }
        return grantRecipientsList;
    }

    /**
     * Method to get Discounted Societies.
     *
     * @param DHID
     *            the dhid
     * @return SocietyDiscounts
     */
    @Override
    public final SocietyDiscounts getDiscountedSocieties(final String DHID) {

        SocietyMemberDiscount societyMemberDiscount = orderservice
                .getSocietyMemberDiscount(DHID);
        List<Societies> societiesList = societyMemberDiscount.getPayload()
                .getSocieties();
        SocietyDiscounts societyDiscounts = new SocietyDiscounts();
        List<Society> societyList = new ArrayList<Society>();
        Society society = null;
        for (Societies societies : societiesList) {
            society = new Society();
            society.setSocietyName(societies.getSocietyName());
            societyList.add(society);
        }
        societyDiscounts.setSocieties(societyList);
        return societyDiscounts;
    }

    /**
     * Method to get Institutional discounts.
     *
     * @param DHID
     *            the dhid
     * @return InstitutionalDiscounts
     */
    @Override
    public final InstitutionalDiscounts getInstitutionDiscounts() {

        InstitutionDiscountsResponse institutionDiscounts = orderservice
                .getInstitutionDiscounts();
        List<Institute> istituteList = institutionDiscounts
                .getInstitutionDetails().getInstituteList();
        InstitutionalDiscounts institutionalDiscounts = new InstitutionalDiscounts();
        List<Institution> institutionList = new ArrayList<Institution>();
        Institution institution = null;
        for (Institute institute : istituteList) {
            institution = new Institution();
            institution.setInstitutionId(institute.getInstituteCode());
            institution.setInstitutionName(institute.getInstituteName());
            institutionList.add(institution);
        }
        institutionalDiscounts.setInstituteList(institutionList);
        return institutionalDiscounts;
    }

    /**
     * Method to get Funders list.
     * 
     * @return list
     */
    @Override
    public final List<FundingOrganizations> getFundersList() {

        WileyOpenAccessFunders wileyOpenAccessFunders = orderservice
                .getWoaAcounts();
        List<WOAAccount> woaAccountList = wileyOpenAccessFunders
                .getWoaFunders().getWOAFunder().get(0).getWOAAccounts()
                .getWOAAccount();
        List<FundingOrganizations> fundingOrganizationsList = new ArrayList<FundingOrganizations>();
        FundingOrganizations fundingOrganizations = null;
        for (WOAAccount woaAccount : woaAccountList) {
            List<ResearchFunderElement> researchFunderElementList = woaAccount
                    .getResearchFunders().getResearchfunder();
            if (null == researchFunderElementList) {
                return fundingOrganizationsList;
            }
            for (ResearchFunderElement researchFunderElement : researchFunderElementList) {
                fundingOrganizations = new FundingOrganizations();
//                fundingOrganizations.setFunderRefId(researchFunderElement
//                        .getFunderRefId());
                fundingOrganizations.setFunderName(researchFunderElement
                        .getName());
                fundingOrganizationsList.add(fundingOrganizations);
            }
        }
        return fundingOrganizationsList;
    }

    /**
     * Method to retrieve all the corresponding Accounts of the account Holder.
     *
     * @param id
     *            - the request value
     * @return list
     */
    @Override
    public final List<String> processAllRestrictedFunderWOAAccounts(
            final String id) {
        WOAFunder currentWoaFunder = null;
        List<WOAAccount> woaAccountList = null;
        List<String> woaAccountNameList = null;
        WileyOpenAccessFunders wileyOpenAccessFunders = orderservice
                .getWoaAcounts();

        List<WOAFunder> funder = wileyOpenAccessFunders.getWoaFunders()
                .getWOAFunder();

        for (Iterator<WOAFunder> iterator = funder.iterator(); iterator
                .hasNext();) {
            WOAFunder woaFunder = iterator.next();

            if (id.equals(woaFunder.getId())) {
                currentWoaFunder = woaFunder;
                break;
            }
        }

        woaAccountList = currentWoaFunder.getWOAAccounts().getWOAAccount();
        woaAccountNameList = new ArrayList<String>();

        for (Iterator<WOAAccount> iterator = woaAccountList.iterator(); iterator
                .hasNext();) {
            WOAAccount woaAccount = iterator.next();

            List<ResearchFunderElement> researchfunderList = woaAccount
                    .getResearchFunders().getResearchfunder();

            for (Iterator<ResearchFunderElement> iterator2 = researchfunderList
                    .iterator(); iterator2.hasNext();) {
                ResearchFunderElement researchFunderElement = iterator2.next();

                woaAccountNameList.add(researchFunderElement.getDoi());
            }

        }

        return woaAccountNameList;
    }

    /**
     * Method to update Payment Details.
     *
     * @param form
     *            the form
     */
    @Override
    public final void savePaymentDetails(
            final MultiValueMap<String, String> form) {

        PaymentDetails paymentDetails = new PaymentDetails();

        Map<String, String> map = form.toSingleValueMap();

        paymentDetails.setOperation(map.get("operation"));
        paymentDetails.setVendorId(Integer.parseInt(map.get("vendorID")));
        paymentDetails.setTransId(Integer.parseInt(map.get("transID")));
        Long longDate = Long.parseLong(map.get("timestamp"));
        Date date = new Date(longDate);
        paymentDetails.setTransTimeStamp(date);
        paymentDetails.setReturnCode(Integer.parseInt(map.get("returnCode")));
        paymentDetails.setReturnMessage(map.get("returnMessage"));
        paymentDetails.setMerchantResponse(map.get("merchantResponse"));
        paymentDetails.setMerchantId(Integer.parseInt(map.get("merchantID")));
        paymentDetails.setToken(map.get("token"));
        paymentDetails.setAcquirerId(map.get("acquirerID").toCharArray()[0]);
        paymentDetails.setAcquirerBank(map.get("acquirerName"));
        paymentDetails.setBankId(map.get("bankID").toCharArray()[0]);
        paymentDetails.setBankName(map.get("bankName"));
        paymentDetails.setMaskedCardNumber(map.get("maskedCardNumber"));
        paymentDetails.setCardExpiry(Integer.parseInt(map.get("cardExpiry")));
        paymentDetails.setCscResult(map.get("CSCResult").toCharArray()[0]);
        paymentDetails.setAvsAddressResult(map.get("AVSAddrResult")
                .toCharArray()[0]);
        paymentDetails
                .setAvsPostResult(map.get("AVSPostResult").toCharArray()[0]);
        paymentDetails.setSecurity(map.get("security"));

        // orderOnlineDAO.savePaymentDetails(paymentDetails);
    }

    /**
     * Method to retrieve Wiley Payment Gateway configuration details.
     * 
     * @param orderId
     *            - the request value
     * @return wpgConfiguration
     */
    @Override
    public final WPGConfiguration getWPGConfiguration(final String orderId) {

        WPGConfiguration wpgConfiguration = new WPGConfiguration();

        wpgConfiguration.setAcquirerId(acquirerId);
        wpgConfiguration = getAddressAndCurrencyDetailsForOrderId(orderId,
                wpgConfiguration);
        wpgConfiguration.setWpgAllowAVSFail(wpgAllowAVSFail);
        wpgConfiguration.setWpgRegion(wpgRegion);
        wpgConfiguration.setWpgCountryCode(wpgCountryCode);
        wpgConfiguration.setWpgDescription(wpgDescription);
        wpgConfiguration.setWpgMethod(wpgMethod);
        Long wpgTimeStmp = new Date().getTime();
        wpgConfiguration.setWpgTimeStmap(wpgTimeStmp.toString());

        // Commented the below code - to fix on Monday 7/13

        // Integer intWpgTransId = generateRandomTransactionId(MIN_VALUE,
        // Integer.MAX_VALUE);
        // String wpgTransId = intWpgTransId.toString();

        wpgConfiguration.setWpgTransId(orderId);
        // wpgValue is not required for WPG_VALIDATE
        // wpgConfiguration.setWpgValue(wpgValue);
        wpgConfiguration.setWpgVendorId(wpgVendorId);

        StringBuilder securityStringBuilder = new StringBuilder();
        securityStringBuilder.append(wpgTimeStmp.toString())
                .append(wpgVendorId).append(orderId).append(wpgMethod)
                .append(wpgDescription).append(wpgRegion)
                .append(wpgConfiguration.getWpgAddress())
                .append(wpgConfiguration.getWpgPostCode())
                .append(wpgCountryCode).append(wpgAllowAVSFail)
                .append(wpgVendorPassword);

        wpgConfiguration.setWpgSecurity(DigestUtils
                .md5Hex(securityStringBuilder.toString()));

        return wpgConfiguration;
    }

    /**
     * This method returns the Address, Currency Details, Article and Journal
     * details of the requested Order.
     * 
     * @param orderId
     *            - the request value
     * @param wpgConfiguration
     *            - the request value
     * @return WpgConfiguration
     * 
     */
    private final WPGConfiguration getAddressAndCurrencyDetailsForOrderId(
            final String orderId, final WPGConfiguration wpgConfiguration) {
        OnlineOpenOrder onlineOpenOrder = null;
        String addressLine1 = null;
        String addressPostCode = null;
        String totalAmount = null;
        String wpgCurrency = null;
        String price = null;
        String articleName = null;
        String journalName = null;
        String taxAmount = null;

        /*
         * Need to remove all the null checks which are not required.
         */

        onlineOpenOrder = getOrderDetails(orderId, null);

        if (onlineOpenOrder != null) {

            if (onlineOpenOrder.getAddressDetails().getBillingAddress() != null) {

                addressLine1 = onlineOpenOrder.getAddressDetails()
                        .getBillingAddress().getAddressLine1() != null ? onlineOpenOrder
                        .getAddressDetails().getBillingAddress()
                        .getAddressLine1()
                        : "";

                addressPostCode = onlineOpenOrder.getAddressDetails()
                        .getBillingAddress().getPostCode() != null ? onlineOpenOrder
                        .getAddressDetails().getBillingAddress().getPostCode()
                        : "";
            }

            if (onlineOpenOrder.getFinalAmount() != null) {
                totalAmount = onlineOpenOrder.getFinalAmount().getAmount() != null ? onlineOpenOrder
                        .getFinalAmount().getAmount() : "";

                wpgCurrency = onlineOpenOrder.getFinalAmount().getCurrency() != null ? onlineOpenOrder
                        .getFinalAmount().getCurrency() : "";
            }

            if (onlineOpenOrder.getAmountPayable() != null) {
                price = onlineOpenOrder.getAmountPayable().getAmount() != null ? onlineOpenOrder
                        .getAmountPayable().getAmount() : "";
            }

            if (onlineOpenOrder.getArticleDetails() != null) {
                articleName = onlineOpenOrder.getArticleDetails()
                        .getArticleTitle() != null ? onlineOpenOrder
                        .getArticleDetails().getArticleTitle() : "";
            }

            if (onlineOpenOrder.getJournalDetails() != null) {
                journalName = onlineOpenOrder.getJournalDetails()
                        .getJournalTitle() != null ? onlineOpenOrder
                        .getJournalDetails().getJournalTitle() : "";
            }

            if (onlineOpenOrder.getTaxAmount() != null) {
                taxAmount = onlineOpenOrder.getTaxAmount().getAmount() != null ? onlineOpenOrder
                        .getTaxAmount().getAmount() : "";
            }

            wpgConfiguration.setWpgAddress(addressLine1 != null ? addressLine1
                    : "");
            wpgConfiguration
                    .setWpgPostCode(addressPostCode != null ? addressPostCode
                            : "");
            wpgConfiguration.setTotalAmount(totalAmount != null ? totalAmount
                    : "");
            wpgConfiguration.setWpgCurrency(wpgCurrency != null ? wpgCurrency
                    : "");
            wpgConfiguration.setPrice(price != null ? price : "");
            wpgConfiguration.setArticleName(articleName != null ? articleName
                    : "");
            wpgConfiguration.setJournalName(journalName != null ? journalName
                    : "");
            wpgConfiguration.setTax(taxAmount != null ? taxAmount : "");

        }

        return wpgConfiguration;

    }

    /**
     * This method returns the Online Open Order details.
     *
     * @param orderId
     *            - the request value
     * @param savedOrder
     *            - the request value
     * @return onlineOpenOrder
     */
    private final OnlineOpenOrder getOrderDetails(final String orderId,
            SavedOrders savedOrder) {
        String orderDataObject = null;
        OnlineOpenOrder onlineOpenOrder = null;
        boolean flag = false;

        if (orderId != null && savedOrder == null) {
            savedOrder = orderOnlineDAO.getSavedOrdersForTheOrderId(orderId);
            flag = true;
        } else if (orderId == null && savedOrder != null) {
            flag = true;
        }

        if (flag && savedOrder != null) {
            // orderDataObject = savedOrder.getOrderObject();
            try {
                JSONObject object = (JSONObject) new JSONParser()
                        .parse(orderDataObject);
                onlineOpenOrder = new ObjectMapper().readValue(
                        object.toJSONString(), OnlineOpenOrder.class);
            } catch (JsonParseException e) {
                throw new ASException(
                        AuthorServicesConstants.INTERNAL_SERVER_ERROR,
                        e.getMessage());
            } catch (JsonMappingException e) {
                throw new ASException(
                        AuthorServicesConstants.INTERNAL_SERVER_ERROR,
                        e.getMessage());
            } catch (ParseException e) {
                throw new ASException(
                        AuthorServicesConstants.INTERNAL_SERVER_ERROR,
                        e.getMessage());
            } catch (IOException e) {
                throw new ASException(
                        AuthorServicesConstants.INTERNAL_SERVER_ERROR,
                        e.getMessage());
            }
        }

        return onlineOpenOrder;

    }

    /**
     * This method generates a random transaction id.
     *
     * @param userId
     *            the user id
     * @param orderId
     *            the order id
     * @return transactionId
     */

    /**
     * @param userId
     *            - the request value
     * @param orderId
     *            - the request value
     * @return OrderResponse
     */
    @Override
    public OrderResponse cancelOnlineOpenOrder(final String userId,
            final String orderId) {
        CancelOrderRequest cancelOrderRequest = new CancelOrderRequest();
        cancelOrderRequest.setApplicationKey(cancelOrderApplicationKey);
        cancelOrderRequest.setAsID(Integer.parseInt(userId));
        cancelOrderRequest.setCancelReasonCode(cancelOrderCancelReasonCode);
        cancelOrderRequest.setCorrelationID(Integer
                .parseInt(cancelOrderCorrelationID));
        cancelOrderRequest.setOoUniqueId(Integer.parseInt(orderId));
        cancelOrderRequest.setUserId(Integer.parseInt(cancelOrderUserID));

        return orderservice.cancelOnlineOpenOrder(cancelOrderRequest);
    }

    /**
     * Method returns the order type.
     *
     * @param orderId
     *            the order id
     * @return orderType
     */
    @Override
    public String getOrderType(final Integer orderId) {
        // return orderOnlineDAO.retrieveOrderType(orderId);
        return null;

    }

    /**
     * This will call Invoce service to get invoice
     * 
     * @param ooUniqueId
     * @param articleID
     * @throws Exception
     * @throws FileNotFoundException
     * */
    @Override
    public ResponseEntity<byte[]> getInvoice(final String ooUniqueId,
            final String articleID) {

        HttpHeaders headers = new HttpHeaders();
        byte[] contents = null;
        ResponseEntity<byte[]> response = null;

        Invoice invoice = new Invoice();
        invoice.setRequestType("GET_INVOCIE");
        invoice.setRequestCreatedTimestamp("2014-12-12 10:12:12");
        Article article = new Article();
        article.setArticleID(articleID);
        article.setJournalPrintISSN("0008543X");
        invoice.setArticle(article);
        headers.setContentType(MediaType.parseMediaType("application/pdf"));
        // headers.setContentDispositionFormData(AuthorServicesConstants.PDF_NAME,
        // AuthorServicesConstants.PDF_NAME);
        headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        contents = invoiceservice.getInvoice(invoice);
        response = new ResponseEntity<byte[]>(contents, headers, HttpStatus.OK);

        return response;
    }

    /**
     * This will call dao to get online open request data
     * 
     * @param userId
     * @param articleId
     * */
    @Override
    public RequestOnlineOpen viewOnlineOpenRequest(final String userId,
            final String articleId) {
        RequestOnlineOpen requestOnlineOpen = new RequestOnlineOpen();
        CoauthorRequestsOoorders coauthorRequestsOoorders = orderOnlineDAO
                .viewOnlineOpenRequest(userId, articleId);
        // requestOnlineOpen.setArticleId(String.valueOf(coauthorRequestsOoorders.getProducts()
        // .getDhId()));
        requestOnlineOpen.setMessage(coauthorRequestsOoorders
                .getMessageFromCoauth());
        PdhArticleResponse pdhArticleResponse = orderservice
                .pdhLookUpArticle(Integer.parseInt(articleId));
        requestOnlineOpen.setArticleTitle(pdhArticleResponse.getTitle());
        // TODO getting article title.......
        return requestOnlineOpen;
    }

    /**
     * Call pdh ,then dao to insert and then bpm to create task
     * 
     * @param requestOnlineOpen
     * */
    @Override
    public void requestOnlineOpen(final RequestOnlineOpen requestOnlineOpen) {

        boolean journalAllows = true;
        // TODO call Pdh To get Status
        if (journalAllows) {
            CoauthorRequestsOoorders coauthorRequestsOoorders = new CoauthorRequestsOoorders();
            // Users users = new Users();
            // users.setUserId(Long.valueOf(requestOnlineOpen.getUserId()));
            // Products products = new Products();
            // products.setDhId(Integer.parseInt(requestOnlineOpen.getArticleId()));
            // coauthorRequestsOoorders.setUsersByCoauthUserId(users);
            // coauthorRequestsOoorders.setProducts(products);
            coauthorRequestsOoorders.setMessageFromCoauth(requestOnlineOpen
                    .getMessage());
            try {
                orderOnlineDAO.requestOnlineOpen(coauthorRequestsOoorders);
            } catch (Exception exception) {
                throw new ASException("2434",
                        " Already Requested by some one For Online Open");
            }
            TaskServiceRequest taskServiceRequest = new TaskServiceRequest();

            List<String> articleId = new ArrayList<String>();
            articleId.add(requestOnlineOpen.getMessage());
            taskServiceRequest.setJustifications(articleId);
            // Users
            // userDao=orderOnlineDAO.getUserDetails(requestOnlineOpen.getUserId());
            // String emailId=userDao.getPrimaryEmailAddr();
            // String[] emailSplit =emailId.split("@");
            // taskServiceRequest.setRequestorEmail(emailId);
            taskServiceRequest.setRequestorId(requestOnlineOpen.getUserId());
            // TODO call bpm for creating task requestType
            // taskService.invokeTaskService(taskServiceRequest, emailSplit[0]);

        } else if (journalAllows == false) {
            throw new ASException("1234", "journal Doesnot allows to OO");
        }

    }
}
