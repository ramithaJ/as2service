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

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
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
import com.wiley.gr.ace.authorservices.model.Prices;
import com.wiley.gr.ace.authorservices.model.QuoteDetail;
import com.wiley.gr.ace.authorservices.model.QuoteDetails;
import com.wiley.gr.ace.authorservices.model.Recipients;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.WOAAccounts;
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
import com.wiley.gr.ace.authorservices.model.external.TaxData;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.model.external.WOAAccount;
import com.wiley.gr.ace.authorservices.model.external.WOAFunder;
import com.wiley.gr.ace.authorservices.model.external.WileyOpenAccessFunders;
import com.wiley.gr.ace.authorservices.model.external.WoaAccountHolder;
import com.wiley.gr.ace.authorservices.persistence.entity.OrderTypes;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductRelations;
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
        taxDetails.setCountryCode(orderData.getTaxDetails().getCountryCode());
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
        return onlineOpenOrder;
    }

    /**
     * Method to get quote.
     */
    @Override
    public QuoteDetails getQuote(final String userId, final String articleId,
            final String pdmSalesFlag) {

        ProductRelations productRelations = orderOnlineDAO
                .getProductRelations(articleId);
        if (null == productRelations) {
            throw new ASException("", "");
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
                throw new ASException("802", "Article is not yet Accepted");
            }
            // check user is corresponding author or not.
            if (productPersonRelations.getProductRoles() != null
                    && productPersonRelations.getProductRoles()
                            .getProductRoleCd().equalsIgnoreCase("0001")) {

                // check is there any saved orders for this article.
                SavedOrders savedOrders = orderOnlineDAO.getSavedOrders(
                        articleId, userId);
                if (null != savedOrders) {
                    throw new ASException("803",
                            "Order already exists for this Article");
                }
                // check is there any placed orders for this article.
                Orders orders = orderOnlineDAO.getOrder(articleId, userId);
                if (orders != null) {
                    throw new ASException("804",
                            "Order already submitted for this Article");
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
                throw new ASException("805",
                        "You don't have permissions to make article as online open");
            }
        } else {
            throw new ASException("806",
                    "It's not an Online open journal article");
        }
        return quoteDetails;
    }

    /**
     * Method to get All Orders.
     */
    @Override
    public List<OrderDetails> getAllOrders(final Integer userId,
            final String type) {
        List<ProductPersonRelations> articleAuthorAssignmentList = orderOnlineDAO
                .getArticleAuthId(userId, type);
        OrderDetails orderDetails = null;
        List<OrderDetails> lisofOrderDetails = new ArrayList<OrderDetails>();

        for (ProductPersonRelations articleAuthorAssignment : articleAuthorAssignmentList) {
            orderDetails = new OrderDetails();
            orderDetails.setArticleId(articleAuthorAssignment
                    .getProdRelationId().toString());
            orderDetails.setPrice("0.0");
            PdhJournalResponse pdhLookup = orderservice
                    .pdhLookUpJournal(articleAuthorAssignment.getProducts()
                            .getDhId());
            orderDetails.setArticleTitle(pdhLookup.getTitle());
            /*
             * for (Orders orders : articleAuthorAssignment.getOrderses()) {
             * orderDetails.setOrderDate(orders.getUpdatedDate().toString());
             * orderDetails.setStatus(orders.getOrderStatus()); }
             */
            lisofOrderDetails.add(orderDetails);
        }

        return lisofOrderDetails;

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
            final String orderId, final String orderTypeFlag) throws Exception {

        OrderResponse orderResponse = null;

        if (userId != null && orderId != null) {
            OrderRequest orderRequest = new OrderRequest();
            // TODO All the below hardcoded values need to changed once proper
            // data
            // is provided.
            orderRequest.setApplicationKey("Key134");
            orderRequest.setCorrelationID("1234");
            OrderData orderData = null;
            try {
                orderData = getOrderDataForOnlineOpenOrder(orderId, userId);
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
            // need to be changed
            // OrderData orderData = new OrderData();
            orderRequest.setOrderData(orderData);
            orderRequest.setUserID("user001");

            // orderResponse = orderservice.submitOnlineOpenOrder(orderData);

            orderResponse = (OrderResponse) StubInvokerUtil.invokeJsonStub(
                    "http://jsonstub.com/createOrder", HttpMethod.POST,
                    OrderResponse.class);

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
        }
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
            final String userId) throws Exception {
        OrderData orderData = null;
        SavedOrders savedOrder = null;
        String orderDataObject = null;
        OnlineOpenOrder onlineOpenOrder = null;

        if (orderId != null) {
            savedOrder = orderOnlineDAO.getSavedOrdersForTheOrderId(orderId,
                    userId);
            orderDataObject = savedOrder.getOrderObject();
            JSONObject object = (JSONObject) new JSONParser()
            .parse(orderDataObject);
            onlineOpenOrder = new ObjectMapper().readValue(
                    object.toJSONString(), OnlineOpenOrder.class);

            orderData = new OrderData();
            // TODO: Need to check Article data
            orderData.setArticle(new ArticleData());
            AddressDetails address = onlineOpenOrder.getAddressDetails();

            // TODO: Need to Check the types
            if ("illingAddress".equals(address.getBillingAddress()
                    .getAddressType())) {
                ContactAddress billingAddress = new ContactAddress();
                // TODO: Need to set remaining objects
                billingAddress.setName(address.getBillingAddress()
                        .getFirstName()
                        + address.getBillingAddress().getLastName());
                billingAddress.setOrg(address.getBillingAddress()
                        .getInstitution());

                orderData.setBillingAddress(billingAddress);
            } else if ("contactAddress".equals(address.getBillingAddress()
                    .getAddressType())) {
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
                    .getCountryCode());
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

            // TODO: Need to check WOAAccountHolder
            orderData.setWoaAccountHolder(new WoaAccountHolder());

            orderData.setSpecialNotes("");
            orderData.setCustomer(new Customer());
            orderData.setEnteredBy("");
            orderData.setOoUniqueId("");
            orderData.setOrderDate("");
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
    public List<WOAFunder> retrieveDiscountedWOAFunderList(final String userId,
            final String DHID) {

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
     * @param journalId
     * @return List<DiscountedSociety>
     * 
     */
    @Override
    public List<DiscountedSociety> retrieveSocietyDiscountListForJournal(
            final String userId, final String journalId) {
        // TODO: Request object needs to be developed once provided with
        // structure.

        List<DiscountedSociety> discountedSocietyListForJournal = null;

        if (userId != null && journalId != null) {
            DiscountedSocietyResponse discountedSocietiesResponse = orderservice
                    .getDiscountedSocietiesForJournal(journalId);

            // TODO: Need to be removed
            discountedSocietiesResponse = (DiscountedSocietyResponse) StubInvokerUtil
                    .invokeJsonStub("http://jsonstub.com/discountedSocieties",
                            HttpMethod.GET, DiscountedSocietyResponse.class);

            if (discountedSocietiesResponse != null) {
                discountedSocietyListForJournal = discountedSocietiesResponse
                        .getSocieties();
            }
        }

        return discountedSocietyListForJournal;
    }

    /**
     * Method to save orders.
     */
    @Override
    public void saveLaterOrder(final OnlineOpenOrder order, final String userId) {

        ObjectMapper mapper = new ObjectMapper();
        SavedOrders savedOrders = new SavedOrders();
        try {
            savedOrders.setOrderObject(mapper.writeValueAsString(order));
        } catch (Exception e) {
            e.printStackTrace();
        }
        /*
         * Articles articles = new Articles();
         * articles.setArticleId(Integer.parseInt(order.getArticleId()));
         * savedOrders.setArticles(articles); UserProfile userProfile = new
         * UserProfile(); userProfile.setUserId(Integer.parseInt(userId));
         * savedOrders.setUserProfile(userProfile);
         */
        Users users = new Users();
        users.setUserId(Integer.parseInt(userId));
        savedOrders.setUsersByCreatedBy(users);
        savedOrders.setCreatedDate(new Date());
        orderOnlineDAO.saveLaterOrder(savedOrders);
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
    public boolean isAdditionDiscountAvailableForJournal(final String userId,
            final String journalId) {
        boolean isAdditionDiscountAvailable = false;
        // Need confirmation on DHID or journal id.

        // TODO: Need to create a request object when provided.

        if (userId != null && journalId != null) {
            // TODO: Need to check if journalId or DHId should be passed
            PdhJournalResponse pdhLookupJournal = orderservice
                    .pdhLookUpJournal(Integer.parseInt(journalId));
            isAdditionDiscountAvailable = Boolean.getBoolean(pdhLookupJournal
                    .getAdditionalDiscountAllowed());
        }

        return isAdditionDiscountAvailable;
    }

    /**
     * Method to get WOA accounts.
     * 
     * @return
     */
    @Override
    public List<WOAAccounts> getWOAAccounts() {

        WileyOpenAccessFunders wileyOpenAccessFunders = orderservice
                .getWoaAcounts();
        List<WOAAccount> woaAccountList = wileyOpenAccessFunders
                .getWoaFunders().getWOAFunder().get(0).getWOAAccounts()
                .getWOAAccount();
        List<WOAAccounts> woaAccountsList = new ArrayList<WOAAccounts>();
        WOAAccounts woaAccounts = null;
        for (WOAAccount woaAccount : woaAccountList) {
            woaAccounts = new WOAAccounts();
            woaAccounts.setCode(woaAccount.getId());
            woaAccounts.setName(woaAccount.getName());
            woaAccountsList.add(woaAccounts);
        }
        return woaAccountsList;
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
            grantRecipients.setCode(users.getUserId() + "");
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

        List<Societies> societiesList = orderservice.getSocietyMemberDiscount()
                .getSocieties();
        List<Society> societyList = new ArrayList<Society>();
        Society society = null;
        for (Societies societies : societiesList) {
            society = new Society();
            society.setSocietyId(societies.getSocietyId());
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

}
