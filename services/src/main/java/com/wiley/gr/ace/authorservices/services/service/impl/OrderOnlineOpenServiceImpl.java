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

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
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
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.PaymentDetails;
import com.wiley.gr.ace.authorservices.model.Prices;
import com.wiley.gr.ace.authorservices.model.QuoteDetail;
import com.wiley.gr.ace.authorservices.model.QuoteDetails;
import com.wiley.gr.ace.authorservices.model.Recipients;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.WOAAccountFunders;
import com.wiley.gr.ace.authorservices.model.WOAAccountHolders;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.ContactAddress;
import com.wiley.gr.ace.authorservices.model.external.Customer;
import com.wiley.gr.ace.authorservices.model.external.DiscountedSociety;
import com.wiley.gr.ace.authorservices.model.external.DiscountedSocietyResponse;
import com.wiley.gr.ace.authorservices.model.external.Institute;
import com.wiley.gr.ace.authorservices.model.external.InstitutionDiscounts;
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
import com.wiley.gr.ace.authorservices.model.external.TaxData;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.model.external.WOAAccount;
import com.wiley.gr.ace.authorservices.model.external.WOAFunder;
import com.wiley.gr.ace.authorservices.model.external.WPGConfiguration;
import com.wiley.gr.ace.authorservices.model.external.WileyOpenAccessFunders;
import com.wiley.gr.ace.authorservices.model.external.WoaAccountHolder;
import com.wiley.gr.ace.authorservices.persistence.entity.OrderTypes;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.Products;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
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

    /** The user profiles. */
    @Autowired
    private UserProfiles userProfiles;

    /**
     * This field holds the value of correspondingAuthorId
     */
    @Value("${CorrespondingAuthorId}")
    private String correspondingAuthorId;

    /**
     * This field holds the value of articleDetailsCode
     */
    @Value("${articleDetails.code}")
    private String articleDetailsCode;

    /**
     * This field holds the value of articleDetailsMessage
     */
    @Value("${articleDetails.message}")
    private String articleDetailsMessage;

    /**
     * This field holds the value of articleAcceptanceCode
     */
    @Value("${articleAcceptance.code}")
    private String articleAcceptanceCode;

    /**
     * This field holds the value of articleAcceptanceMessage
     */
    @Value("${articleAcceptance.message}")
    private String articleAcceptanceMessage;

    /**
     * This field holds the value of savedOrderCode
     */
    @Value("${savedOrder.code}")
    private String savedOrderCode;

    /**
     * This field holds the value of savedOrderMessage
     */
    @Value("${savedOrder.message}")
    private String savedOrderMessage;

    /**
     * This field holds the value of orderExistenceCode
     */
    @Value("${orderExistence.code}")
    private String orderExistenceCode;

    /**
     * This field holds the value of orderExistenceMessage
     */
    @Value("${orderExistence.message}")
    private String orderExistenceMessage;

    /**
     * This field holds the value of onlineOpenCode
     */
    @Value("${OnlineOpen.code}")
    private String onlineOpenCode;

    /**
     * This field holds the value of onlineOpenMessage
     */
    @Value("${OnlineOpen.message}")
    private String onlineOpenMessage;

    /**
     * This field holds the value of onlineOpenJournalCode
     */
    @Value("${OnlineOpenJournal.code}")
    private String onlineOpenJournalCode;

    /**
     * This field holds the value of OnlineOpenJournalMessage
     */
    @Value("${OnlineOpenJournal.message}")
    private String OnlineOpenJournalMessage;

    /**
     * This field holds the value of jsonProcessingExceptionCode
     */
    /*
     * @Value("${JsonProcessingException}") private String
     * jsonProcessingExceptionCode;
     */

    /**
     * This field holds the value of applicationKey
     */
    @Value("${OnlineOpenProperties.applicationKey}")
    private String applicationKey;

    /**
     * This field holds the value of correlationId
     */
    @Value("${OnlineOpenProperties.correlationId}")
    private String correlationId;

    /**
     * This field holds the value of userId
     */
    /*
     * @Value("${OnlineOpenProperties.userId}") private String userId;
     */
    // WPG Configuration property values

    @Value("$acquirerId}")
    private String acquirerId;

    @Value("$wpgTimeStmap}")
    private String wpgTimeStmap;

    @Value("$wpgVendorId}")
    private String wpgVendorId;

    @Value("$wpgTransId}")
    private String wpgTransId;

    @Value("$wpgMethod}")
    private String wpgMethod;

    @Value("$wpgDescription}")
    private String wpgDescription;

    @Value("$wpgValue}")
    private String wpgValue;

    @Value("$wpgCurrency}")
    private String wpgCurrency;

    @Value("$wpgRegion}")
    private String wpgRegion;

    @Value("$wpgAddress}")
    private String wpgAddress;

    @Value("$wpgPostCode}")
    private String wpgPostCode;

    @Value("$wpgCountryCode}")
    private String wpgCountryCode;

    @Value("$wpgAllowAVSFail}")
    private String wpgAllowAVSFail;

    @Value("$wpgSecurity}")
    private String wpgSecurity;

    /**
     * This method will take userId and orderId as input and calls external
     * service to get details of Online order details
     * 
     * @param userId
     * @param orderId
     */
    @Override
    public OnlineOpenOrder getOnlineOpenOrderDetails(final String userId,
            final String orderId) {
        OnlineOpenOrder onlineOpenOrder = new OnlineOpenOrder();
        OrderData orderData = new OrderData();
        OrderDataList orderDataList = orderservice.getOrderDetails(userId,
                orderId);
        orderData = orderDataList.getOrderDatas().get(0);
        ArticleDetails articleDetails = new ArticleDetails();
        List<ArticleDetails> articleDetailsList = new ArrayList<ArticleDetails>();
        articleDetails.setArticleAID(orderData.getArticle().getAidECORE());
        articleDetails
                .setArticleTitle(orderData.getArticle().getArticleTitle());
        articleDetailsList.add(articleDetails);
        onlineOpenOrder.setArticleDetails(articleDetailsList);
        JournalDetails journalDetails = new JournalDetails();
        List<JournalDetails> journalDetailsList = new ArrayList<JournalDetails>();
        journalDetails.setJournalId(orderData.getArticle().getJournal()
                .getDhId());
        journalDetails.setJournalTitle(orderData.getArticle().getJournal()
                .getJournalTitle());
        journalDetailsList.add(journalDetails);
        onlineOpenOrder.setJournalDetails(journalDetailsList);
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
                .getDiscount().getSocietyData().getCode());
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
        contactAddress.setDepartment(orderData.getContactAddress()
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
        billingAddress.setDepartment(orderData.getBillingAddress()
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
     */
    @Override
    public QuoteDetails initiateOnline(final String userId,
            final String articleId, final String pdmSalesFlag) {

        ProductRelations productRelations = orderOnlineDAO
                .getProductRelations(articleId);
        if (null == productRelations) {
            throw new ASException(articleDetailsCode, articleDetailsMessage);
        }
        // Calling PdhLookUpJornal service with jornalDhId
        PdhJournalResponse pdhLookup = orderservice
                .pdhLookUpJournal(productRelations.getProductsByParentDhId()
                        .getDhId());
        // UI OnLoad object for OrderOnlineOpen order.
        QuoteDetails quoteDetails = null;
        // check article is onlineOpen article or not.
        if (pdmSalesFlag.equalsIgnoreCase(pdhLookup.getPdmSalesModel())) {

            // DB call to get ProductPersonRelations object.
            ProductPersonRelations productPersonRelations = orderOnlineDAO
                    .getProductPersonRelations(userId, articleId);
            if (productPersonRelations == null) {
                throw new ASException(articleAcceptanceCode,
                        articleAcceptanceMessage);
            }
            // check user is corresponding author or not.
            if (productPersonRelations.getProductRoles() != null
                    && productPersonRelations.getProductRoles()
                            .getProductRoleCd()
                            .equalsIgnoreCase(correspondingAuthorId)) {

                // check is there any saved orders for this article.
                SavedOrders savedOrders = orderOnlineDAO.getSavedOrders(
                        articleId, userId);
                if (null != savedOrders) {
                    throw new ASException(savedOrderCode, savedOrderMessage);
                }
                // check is there any placed orders for this article.
                Orders orders = orderOnlineDAO.getOrder(articleId, userId);
                if (orders != null) {
                    throw new ASException(orderExistenceCode,
                            orderExistenceMessage);
                }
                quoteDetails = new QuoteDetails();
                // calling PdhLookupArticle service with article DhId for
                // article title.
                PdhArticleResponse pdhArticleResponse = orderservice
                        .pdhLookUpArticle(productPersonRelations.getProducts()
                                .getDhId());
                // Article details (ArticleId and Article title)
                ArticleDetails articleDetails = new ArticleDetails();
                articleDetails.setArticleAID(articleId);
                articleDetails.setArticleTitle(pdhArticleResponse.getTitle());
                quoteDetails.setArticleDetails(articleDetails);
                // Journal details (JornalId and jornalTitle)
                JournalDetails journalDetails = new JournalDetails();
                journalDetails.setJournalId(productRelations
                        .getProductsByParentDhId().getDhId() + "");
                journalDetails.setJournalTitle(pdhLookup.getTitle());
                quoteDetails.setJournalDetails(journalDetails);

                // prices in 3 type of currencies
                QuoteDetail quoteDetail = new QuoteDetail();
                quoteDetail.setPrices(pdhArticleResponse.getPrices());
                quoteDetails.setQuoteDetail(quoteDetail);

                // values of DiscountsAllowed and AdditionalDiscountAllowed
                quoteDetails.setDiscountsAllowed(pdhLookup
                        .getDiscountsAllowed());
                quoteDetails.setAdditionalDiscountAllowed(pdhLookup
                        .getAdditionalDiscountAllowed());
                // userProfile object form userProfile service for society
                // details and addressDetails
                UserProfileResponse userProfileResponse = userProfiles
                        .getUserProfileResponse(userId);
                // First and LastName of author
                quoteDetails.setAuthorName(userProfileResponse
                        .getCustomerProfile().getCustomerDetails()
                        .getFirstName()
                        + " "
                        + userProfileResponse.getCustomerProfile()
                                .getCustomerDetails().getLastName());
                // GrantRecipients(coAuthors)
                userProfileResponse.getCustomerProfile().getCoAuthors();
                // Societies
                userProfileResponse.getCustomerProfile().getSocieties();
                // billing and contact addresses
                AddressDetails addressDetails = new AddressDetails();
                addressDetails.setBillingAddress(userProfileResponse
                        .getCustomerProfile().getAddressDetails().get(1)
                        .getBillingAddress());
                addressDetails.setContactAddress(userProfileResponse
                        .getCustomerProfile().getAddressDetails().get(0)
                        .getCorrespondenceAddress());
                quoteDetails.setAddressDetails(addressDetails);

            } else {
                throw new ASException(onlineOpenCode, onlineOpenMessage);
            }
        } else {
            throw new ASException(onlineOpenJournalCode,
                    OnlineOpenJournalMessage);
        }
        return quoteDetails;
    }

    /**
     * Method to get All Orders.
     */
    @Override
    public List<OrderDetails> getAllOrders(final String orderId) {
        OrderDetails orderDetails = new OrderDetails();
        List<OrderDetails> orderDetailsList = new ArrayList<OrderDetails>();
        // OrderData orderData = new OrderData();
        OrderDataList orderDataList = orderservice.getAllOrders(orderId);
        // orderData = orderDataList.getOrderDatas().get(0);
        for (OrderData orderData : orderDataList.getOrderDatas()) {
            orderDetails.setArticleId(orderData.getArticle().getDHID());
            orderDetails.setArticleTitle(orderData.getArticle()
                    .getArticleTitle());
            orderDetails.setOrderDate(orderData.getOrderDate());
            orderDetails.setPrice(orderData.getPricing().getAmountToBePaid()
                    .toString());
            orderDetails.setStatus(orderData.getOrderStatusCode());
        }

        orderDetailsList.add(orderDetails);
        return orderDetailsList;

    }

    /**
     * This method submits the online open order and returns the order response
     * 
     * @param userId
     * @param onlineOpenOrder
     * @return OrderResponse
     * @throws Exception
     * 
     */
    @Override
    public OrderResponse submitOnlineOpenOrder(final String userId,
            final String orderId, final String orderTypeFlag) {

        OrderResponse orderResponse = null;

        OrderRequest orderRequest = new OrderRequest();
        // TODO All the below hardcoded values need to changed once proper
        // data
        // is provided.
        orderRequest.setApplicationKey(applicationKey);
        orderRequest.setCorrelationID(correlationId);
        OrderData orderData = null;
        orderData = getOrderDataForOnlineOpenOrder(orderId, userId);
        orderRequest.setOrderData(orderData);
        orderRequest.setUserID(userId);

        orderResponse = orderservice.submitOnlineOpenOrder(orderData);

        Orders orders = new Orders();
        orders.setOrderTypes(new OrderTypes());
        // orders.setOoOaFlg(orderTypeFlag);
        orders.setOrderStatus(AuthorServicesConstants.ORDER_STATUS_SUBMIT);
        // orders.setDownstreamappOrderId(Integer.parseInt(orderResponse.getOoUniqueId()));
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
     * @throws Exception
     */
    private OrderData getOrderDataForOnlineOpenOrder(final String orderId,
            final String userId) {
        OrderData orderData = null;
        SavedOrders savedOrder = null;
        String orderDataObject = null;
        OnlineOpenOrder onlineOpenOrder = null;

        if (orderId != null) {
            savedOrder = orderOnlineDAO.getSavedOrdersForTheOrderId(orderId,
                    userId);
            orderDataObject = savedOrder.getOrderObject();
            try {
                JSONObject object = (JSONObject) new JSONParser()
                        .parse(orderDataObject);
                onlineOpenOrder = new ObjectMapper().readValue(
                        object.toJSONString(), OnlineOpenOrder.class);
            } catch (JsonParseException e) {
                throw new ASException("700", e.getMessage());
            } catch (JsonMappingException e) {
                throw new ASException("701", e.getMessage());
            } catch (ParseException e) {
                throw new ASException("702", e.getMessage());
            } catch (IOException e) {
                throw new ASException("703", e.getMessage());
            }

            orderData = new OrderData();
            // TODO: Need to check Article data
            orderData.setArticle(new ArticleData());
            AddressDetails address = onlineOpenOrder.getAddressDetails();

            // TODO: Need to Check the types
            if (AuthorServicesConstants.BILLING_ADDRESS_TYPE.equals(address
                    .getBillingAddress().getAddressType())) {
                ContactAddress billingAddress = new ContactAddress();
                // TODO: Need to set remaining objects
                billingAddress.setName(address.getBillingAddress()
                        .getFirstName()
                        + address.getBillingAddress().getLastName());
                billingAddress.setOrg(address.getBillingAddress()
                        .getInstitution());

                orderData.setBillingAddress(billingAddress);
            } else if (AuthorServicesConstants.CONTACT_ADDRESS_TYPE
                    .equals(address.getBillingAddress().getAddressType())) {
                ContactAddress contactAddress = new ContactAddress();
                // TODO: Need to set remaining objects
                contactAddress.setName(address.getContactAddress()
                        .getFirstName()
                        + address.getBillingAddress().getLastName());
                contactAddress.setOrg(address.getContactAddress()
                        .getInstitution());
                orderData.setContactAddress(contactAddress);
            }

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

            WoaAccountHolder woaAccountHolder = new WoaAccountHolder();

            woaAccountHolder.setCode(onlineOpenOrder.getFunderDetails().get(0)
                    .getWoaAccountId());

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
     * This method returns the Discounted WOA Funder List
     * 
     * @param userId
     * @param DHID
     * @return List<String>
     * 
     */
    @Override
    public List<WOAFunder> retrieveDiscountedWOAFunderList(final String DHID) {

        List<WOAFunder> woaFunderList = null;

        PdhArticleResponse pdhArticleResponse = orderservice
                .pdhLookUpArticle(Integer.parseInt(DHID));

        woaFunderList = pdhArticleResponse.getWOAFunders().getWOAFunder();

        return woaFunderList;
    }

    /**
     * This method returns the List of Societies which provide Society discounts
     * for the journal
     * 
     * @param userId
     * @param journalId
     * @return List<DiscountedSociety>
     * 
     */
    @Override
    public List<DiscountedSociety> retrieveSocietyDiscountListForJournal(
            final String DHID) {
        List<DiscountedSociety> discountedSocietyListForJournal = null;

        DiscountedSocietyResponse discountedSocietiesResponse = orderservice
                .getDiscountedSocietiesForJournal(DHID);

        if (discountedSocietiesResponse != null) {
            discountedSocietyListForJournal = discountedSocietiesResponse
                    .getSocieties();
        }
        return discountedSocietyListForJournal;
    }

    /**
     * Method to save orders.
     * 
     * @return
     */
    @Override
    public Integer saveLaterOrder(final OnlineOpenOrder order,
            final String userId) {

        ObjectMapper mapper = new ObjectMapper();
        SavedOrders savedOrders = new SavedOrders();
        try {
            savedOrders.setOrderObject(mapper.writeValueAsString(order));
        } catch (JsonProcessingException e) {
            throw new ASException("jsonProcessingExceptionCode", e.getMessage());
        }
        Products products = new Products();
        products.setDhId(Integer.parseInt(order.getArticleDetails().get(0)
                .getArticleAID()));
        savedOrders.setProducts(products);

        Users users = new Users();
        users.setUserId(Integer.parseInt(userId));
        savedOrders.setUsersByUserId(users);
        savedOrders.setUsersByCreatedBy(users);
        savedOrders.setCreatedDate(new Date());
        return orderOnlineDAO.saveLaterOrder(savedOrders);
    }

    /**
     * This method checks if additional discount is available for the journal.
     * 
     * @param userId
     * @param journalId
     * @return boolean
     * 
     */
    @Override
    public boolean isAdditionDiscountAvailableForJournal(final String DHID) {
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
     * @return
     */
    @Override
    public WOAAccountHolders getWOAFunders() {

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
     * @return
     */
    @Override
    public List<GrantRecipients> getGrantRecipients(final String articleId) {

        List<ProductPersonRelations> productPersonRelationsList = orderOnlineDAO
                .getGrantRecipients(articleId);
        List<GrantRecipients> grantRecipientsList = new ArrayList<GrantRecipients>();
        GrantRecipients grantRecipients = null;
        for (ProductPersonRelations productPersonRelations : productPersonRelationsList) {
            Users users = productPersonRelations.getUserProfile()
                    .getUsersByUserId();
            grantRecipients = new GrantRecipients();
            grantRecipients.setCode(users.getUserId());
            grantRecipients.setName(users.getFirstName() + " "
                    + users.getLastName());
            grantRecipientsList.add(grantRecipients);
        }
        return grantRecipientsList;
    }

    /**
     * Method to get Discounted Societies.
     * 
     * @return
     */
    @Override
    public List<Society> getDiscountedSocieties() {

        SocietyMemberDiscount societyMemberDiscount = orderservice
                .getSocietyMemberDiscount();
        List<Societies> societiesList = societyMemberDiscount.getPayload()
                .getSocieties();
        List<Society> societyList = new ArrayList<Society>();
        Society society = null;
        for (Societies societies : societiesList) {
            society = new Society();
            society.setSocietyName(societies.getSocietyName());
            societyList.add(society);
        }
        return societyList;
    }

    /**
     * Method to get Institutional discounts.
     * 
     * @return
     */
    @Override
    public List<Institution> getInstitutionDiscounts() {

        InstitutionDiscounts institutionDiscounts = orderservice
                .getInstitutionDiscounts();
        List<Institute> istituteList = institutionDiscounts.getInstitute();
        List<Institution> institutionList = new ArrayList<Institution>();
        Institution institution = null;
        for (Institute institute : istituteList) {
            institution = new Institution();
            institution.setInstitutionId(institute.getInstituteCode());
            institution.setInstitutionName(institute.getInstituteName());
            institutionList.add(institution);
        }
        return institutionList;
    }

    /**
     * Method to get Funders list.
     * 
     * @return
     */
    @Override
    public List<FundingOrganizations> getFundersList() {

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
                fundingOrganizations.setFunderRefId(researchFunderElement
                        .getFunderRefId());
                fundingOrganizations.setFunderName(researchFunderElement
                        .getFunderName());
                fundingOrganizationsList.add(fundingOrganizations);
            }
        }
        return fundingOrganizationsList;
    }

    /**
     * This method send the WOAFunder with the correct WOA Account to the OO
     * app.
     * 
     * @param woaFunder
     */
    @Override
    public void processWOAAccount(final WOAFunder woaFunder) {
        List<WOAAccount> woaAccountList = null;

        woaAccountList = woaFunder.getWOAAccounts().getWOAAccount();

        if (woaAccountList != null) {

            /*
             * If Selected WOA Institution has multiple WOA Accounts, send the
             * Non Restricted WOA Accounts list to the admin to select the
             * correct WOA Account.
             */
            List<WOAAccount> nonRestrictedWOAAccountList = null;
            nonRestrictedWOAAccountList = retrieveNonRestrictedWOAAccountList(
                    nonRestrictedWOAAccountList, woaAccountList);

            if (nonRestrictedWOAAccountList != null
                    && nonRestrictedWOAAccountList.size() > 0) {
                orderservice
                        .sendNonRestrictedWOAAccountListToAdmin(nonRestrictedWOAAccountList);
            } /*
               * else {
               * 
               * // TODO: Need to consume BPM service }
               */
        }

    }

    /**
     * This method returns the non restricted WOA Acounts
     * 
     * @param woaAccountList
     * @param woaAccountList2
     * @return
     */
    private List<WOAAccount> retrieveNonRestrictedWOAAccountList(
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
     * Method to retrieve all the corresponding Accounts of the account Holder
     * 
     * @param name
     * @return woaAccountNameList
     * 
     */
    @Override
    public List<String> processAllRestrictedFunderWOAAccounts(final String id) {
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
     */
    @Override
    public boolean updatePaymentDetails(final PaymentDetails paymentDetails) {

        return orderOnlineDAO.updatePaymentDetails(paymentDetails);
    }

    @Override
    public WPGConfiguration getWPGConfiguration() {

        WPGConfiguration wpgConfiguration = new WPGConfiguration();
        wpgConfiguration.setAcquirerId(acquirerId);
        wpgConfiguration.setWpgAddress(wpgAddress);
        wpgConfiguration.setWpgAllowAVSFail(wpgAllowAVSFail);
        wpgConfiguration.setWpgCountryCode(wpgCountryCode);
        wpgConfiguration.setWpgCurrency(wpgCurrency);
        wpgConfiguration.setWpgDescription(wpgDescription);
        wpgConfiguration.setWpgMethod(wpgMethod);
        wpgConfiguration.setWpgPostCode(wpgPostCode);
        wpgConfiguration.setWpgRegion(wpgRegion);
        wpgConfiguration.setWpgSecurity(wpgSecurity);
        wpgConfiguration.setWpgTimeStmap(wpgTimeStmap);
        wpgConfiguration.setWpgTransId(wpgTransId);
        wpgConfiguration.setWpgValue(wpgValue);
        wpgConfiguration.setWpgVendorId(wpgVendorId);

        return wpgConfiguration;
    }

}
