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
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.AddressDetails;
import com.wiley.gr.ace.authorservices.model.Amount;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.Discounts;
import com.wiley.gr.ace.authorservices.model.FunderDetails;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.Prices;
import com.wiley.gr.ace.authorservices.model.QuoteDetail;
import com.wiley.gr.ace.authorservices.model.QuoteDetails;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.WOAAccounts;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.DiscountedSociety;
import com.wiley.gr.ace.authorservices.model.external.DiscountedSocietyResponse;
import com.wiley.gr.ace.authorservices.model.external.InstitutionDiscounts;
import com.wiley.gr.ace.authorservices.model.external.OrderData;
import com.wiley.gr.ace.authorservices.model.external.OrderDataList;
import com.wiley.gr.ace.authorservices.model.external.OrderRequest;
import com.wiley.gr.ace.authorservices.model.external.OrderResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.ResearchFunderElement;
import com.wiley.gr.ace.authorservices.model.external.Societies;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.model.external.WOAAccount;
import com.wiley.gr.ace.authorservices.model.external.WOAFunder;
import com.wiley.gr.ace.authorservices.model.external.WileyOpenAccessFunders;
import com.wiley.gr.ace.authorservices.persistence.entity.Articles;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
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

    /** The user profiles. */
    @Autowired
    private UserProfiles userProfiles;

    /**
     * This method will take userId and orderId as input and calls external
     * service to get details of Online order details
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
        onlineOpenOrder.setTaxDetails(taxDetails);
        Amount amount = new Amount();
        amount.setAmount(orderData.getPricing().getAmountToBePaid().toString());
        amount.setCurrency(orderData.getPricing().getCurrency());
        onlineOpenOrder.setAmountPayable(amount);
        onlineOpenOrder.setPaymentMethod(orderData.getPayment()
                .getPaymentMethod());
        Address address = new Address();
        address.setFirstName(orderData.getContactAddress().getName());
        address.setLastName(orderData.getContactAddress().getName());
        address.setDepartment(orderData.getContactAddress().getDepartment());
        address.setAddressLine1(orderData.getContactAddress()
                .getAdditionalStreet());
        address.setAddressLine2(orderData.getContactAddress()
                .getAdditionalStreet());
        address.setCity(orderData.getContactAddress().getCity());
        address.setState(orderData.getContactAddress().getState());
        Country country = new Country();
        country.setCountryName(orderData.getContactAddress().getCountry());
        address.setCountry(country);
        address.setPostCode(orderData.getContactAddress().getZip());
        address.setPhoneNumber(orderData.getContactAddress().getPhoneNumber());
        AddressDetails addressDetails = new AddressDetails();
        addressDetails.setBillingAddress(address);
        addressDetails.setShippingAddress(address);
        List<AddressDetails> addressDetailsList = new ArrayList<AddressDetails>();
        addressDetailsList.add(addressDetails);
        onlineOpenOrder.setAddressDetails(addressDetailsList);

        return onlineOpenOrder;
    }

    /**
     * Method to get quote.
     */
    @Override
    public QuoteDetails getQuote(final String userId, final String articleId,
            final String pdmSalesFlag) {

        // Article details having userId and articleId
        // Articles articles = orderOnlineDAO.getArticleDetails(articleId);
        Articles articles = null;
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
            ProductPersonRelations productPersonRelations = orderOnlineDAO
                    .getAritcleAssignmentDetails(userId, articleId);
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
                Orders orders = orderOnlineDAO.getOrder(productPersonRelations
                        .getProdRelationId());
                if (orders != null) {
                    throw new ASException("804",
                            "Order already submitted for this Article");
                }
                /*
                 * calling external service for article and journal titles.
                 * Quote quote = orderservice.getQuote(articleId);
                 */

                quoteDetails = new QuoteDetails();
                // Article details (ArticleId and ArticleTitle)
                PdhArticleResponse pdhArticleResponse = orderservice
                        .pdhLookUpArticle(articles.getDhId());
                ArticleDetails articleDetails = new ArticleDetails();
                articleDetails.setArticleAID(articleId);
                articleDetails.setArticleTitle(pdhArticleResponse.getTitle());
                quoteDetails.setArticleDetails(articleDetails);
                // Author Name
                quoteDetails.setAuthorName("shiva");
                // Journal details (JornalId and jornalTitle)
                JournalDetails journalDetails = new JournalDetails();
                journalDetails.setJournalId(String.valueOf(articles
                        .getJournalId()));
                journalDetails.setJournalTitle(pdhLookup.getTitle());
                quoteDetails.setJournalDetails(journalDetails);

                // prices in 3 type of currencies
                QuoteDetail quoteDetail = new QuoteDetail();
                quoteDetail.setPrices(pdhArticleResponse.getPrices());

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
                addressDetails.setShippingAddress(userProfileResponse
                        .getCustomerProfile().getAddressDetails().get(2)
                        .getShippingAddress());
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
     * 
     */
    @Override
    public OrderResponse submitOnlineOpenOrder(final String userId,
            final OnlineOpenOrder onlineOpenOrder, final String orderTypeFlag) {

        OrderResponse orderResponse = null;

        if (userId != null && onlineOpenOrder != null) {
            OrderRequest orderRequest = new OrderRequest();
            // TODO All the below hardcoded values need to changed once proper
            // data
            // is provided.
            orderRequest.setApplicationKey("Key134");
            orderRequest.setCorrelationID("1234");
            OrderData orderData = getOrderDataForOnlineOpenOrder(onlineOpenOrder);
            orderRequest.setOrderData(orderData);
            orderRequest.setUserID("user001");

            orderResponse = orderservice.submitOnlineOpenOrder(orderData);

            /*
             * OrderResponse orderResponse = (OrderResponse) StubInvokerUtil
             * .invokeJsonStub("http://jsonstub.com/createOrder",
             * HttpMethod.POST, OrderResponse.class);
             */

            Orders orders = new Orders();
            // ProductPersonRelations articleAuthorAssignment = new
            // ProductPersonRelations();
            // TODO: Set proper ArticleAuthId
            // articleAuthorAssignment.set(8);
            // orders.setArticleAuthorAssignment(articleAuthorAssignment);
            orders.setOrderType("");
            orders.setOoOaFlg(orderTypeFlag);
            orders.setOrderStatus(AuthorServicesConstants.ORDER_STATUS_SUBMIT);
            if ("OO".equalsIgnoreCase(orderTypeFlag)) {
                orders.setDownstreamappOrderId(Integer.parseInt(orderResponse
                        .getOoUniqueId()));
            }
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
     */
    private OrderData getOrderDataForOnlineOpenOrder(
            final OnlineOpenOrder onlineOpenOrder) {
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

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService
     * #saveLaterOrder(com.wiley.gr.ace.authorservices.model.OnlineOpenOrder)
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
                .getWOAFunders().getWOAFunder().get(0).getWOAAccounts()
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
     */
    @Override
    public void getGrantRecipients() {
        // TODO Auto-generated method stub

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
    public InstitutionDiscounts getInstitutionDiscounts() {

        return orderservice.getInstitutionDiscounts();
    }

    /**
     * Method to get Funders list.
     * 
     * @return
     */
    @Override
    public List<ResearchFunder> getFundersList() {

        WileyOpenAccessFunders wileyOpenAccessFunders = orderservice
                .getWoaAcounts();
        List<WOAAccount> woaAccountList = wileyOpenAccessFunders
                .getWOAFunders().getWOAFunder().get(0).getWOAAccounts()
                .getWOAAccount();
        List<ResearchFunder> researchFunderList = new ArrayList<ResearchFunder>();
        ResearchFunder researchFunder = null;
        for (WOAAccount woaAccount : woaAccountList) {

            List<ResearchFunderElement> researchFunderElementList = woaAccount
                    .getResearchFunders().getResearchfunder();
            for (ResearchFunderElement researchFunderElement : researchFunderElementList) {
                researchFunder = new ResearchFunder();
                researchFunder.setResearchFunderId(Integer
                        .parseInt(researchFunderElement.getFunderrefid()));
                researchFunder.setResearchFunderName(researchFunderElement
                        .getFundername());
                researchFunderList.add(researchFunder);
            }
        }
        return researchFunderList;
    }

}
