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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.externalservices.service.ValidationService;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.AddressDetails;
import com.wiley.gr.ace.authorservices.model.Amount;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.DiscountDetail;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OpenAccessPaymentData;
import com.wiley.gr.ace.authorservices.model.QuoteData;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.external.AddressOnFile;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationMultiReq;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationMultiRes;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationRequest;
import com.wiley.gr.ace.authorservices.model.external.Article;
import com.wiley.gr.ace.authorservices.model.external.Discount;
import com.wiley.gr.ace.authorservices.model.external.Identifier;
import com.wiley.gr.ace.authorservices.model.external.Item;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupArticle;
import com.wiley.gr.ace.authorservices.model.external.PdhLookupJournal;
import com.wiley.gr.ace.authorservices.model.external.ProductContributor;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.QuoteRequest;
import com.wiley.gr.ace.authorservices.model.external.TaxRequest;
import com.wiley.gr.ace.authorservices.model.external.Title;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO;
import com.wiley.gr.ace.authorservices.services.service.OpenAccessService;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;

/**
 * The Class OpenAccessServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class OpenAccessServiceImpl implements OpenAccessService {

    /** The order service. */
    @Autowired(required = true)
    private OrderService orderService;

    /** The validation service. */
    @Autowired(required = true)
    private ValidationService validationService;

    /** The order online dao. */
    @Autowired(required = true)
    private OrderOnlineDAO orderOnlineDAO;

    @Autowired(required = true)
    private ESBInterfaceService esbInterfaceService;
    /**
     * This is for getting of online open service because same ui for onlineopen
     * and open access
     */
    @Autowired(required = true)
    OrderOnlineOpenService orderOnlineOpenService;

    /** This field holds the value of savedOrderCode. */
    @Value("${savedOrder.code}")
    private String savedOrderCode;

    /** This field holds the value of savedOrderMessage. */
    @Value("${savedOrder.message}")
    private String savedOrderMessage;

    /** This field holds the value of orderExistenceCode. */
    @Value("${orderExistence.code}")
    private String orderExistenceCode;

    /** This field holds the value of orderExistenceMessage. */
    @Value("${orderExistence.message}")
    private String orderExistenceMessage;

    /**
     * Gets the open access details.
     *
     * @param userId
     *            the user id
     * @param articleId
     *            the article id
     * @param journalId
     *            the journal id
     * @return the open access details
     * @throws Exception
     *             the exception
     */
    @Override
    public final OpenAccessPaymentData getOpenAccessDetails(
            final String userId, final String articleId, final String journalId) {

        OpenAccessPaymentData openAccessPaymentData = null;

        SavedOrders savedOrders = orderOnlineDAO.getSavedOrders(articleId,
                userId);
        if (null != savedOrders) {
            throw new ASException(savedOrderCode, savedOrderMessage);
        }
        Orders existingOrders = orderOnlineDAO.getOrder(articleId, userId);
        if (existingOrders != null) {
            throw new ASException(orderExistenceCode, orderExistenceMessage);
        }

        PdhLookupArticle pdhLookupArticle = (PdhLookupArticle) esbInterfaceService
                .getPdhLookupResponse(articleId);

        ArticleDetails articleDetails = new ArticleDetails();

        articleDetails.setArticleId(articleId);

        articleDetails.setArticleTitle(pdhLookupArticle
                .getArticleProductEntities().getTitle().getTitleText());

        for (ProductContributor pc : pdhLookupArticle
                .getArticleProductEntities().getProductContributor()) {
            if ("Corresponding Author".equalsIgnoreCase(pc.getDhRoleTypeCd())) {
                articleDetails.setArticleAuthorName(pc.getFirstName() + " "
                        + pc.getLastName());
            }
        }

        PdhLookupJournal pdhLookupJournal = (PdhLookupJournal) esbInterfaceService
                .getPdhLookupResponse(journalId);

        JournalDetails journalDetails = new JournalDetails();

        journalDetails.setJournalId(journalId);

        for (Title t : pdhLookupJournal.getJournalProductEntities().getTitle()) {
            if ("FULL_TITLE".equalsIgnoreCase(t.getDhTitleTypeCd())) {
                journalDetails.setJournalTitle(t.getTitleText());
            }
        }

        for (Identifier i : pdhLookupJournal.getJournalProductEntities()
                .getIdentifier()) {
            if ("ISSN".equalsIgnoreCase(i.getDhTypeCd())) {
                journalDetails.setJournalPrintIssn(i.getIdentCd());
            }

            if ("E-ISSN".equalsIgnoreCase(i.getDhTypeCd())) {
                journalDetails.setJournalElectronicIssn(i.getIdentCd());
            }
        }

        Article article = new Article();
        article.setArticleID(articleDetails.getArticleId());
        article.setJournalElectronicISSN(journalDetails
                .getJournalElectronicIssn());
        article.setJournalPrintISSN(journalDetails.getJournalPrintIssn());
        QuoteRequest quoteRequest = new QuoteRequest();
        quoteRequest.setArticle(article);

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String requestCreatedTimestamp = df.format(new Date());

        quoteRequest.setRequestCreatedTimestamp(requestCreatedTimestamp);
        quoteRequest.setRequestType("GET_QUOTE");

        Quote quoteResponse = orderService.getQuote(quoteRequest);
        QuoteData quoteData = new QuoteData();
        quoteData.setArticlePubCharge(quoteResponse.getArticlePubCharge());
        quoteData.setCurrency(quoteResponse.getCurrency());

        DiscountDetail discountDetail = new DiscountDetail();
        Discount discount = quoteResponse.getDiscount();
        discountDetail.setDiscountType(discount.getDiscountType());
        discountDetail.setDiscountAmount(discount.getDiscountAmount());
        discountDetail.setDiscountPercent(discount.getDiscountPercent());

        TaxDetails taxDetails = new TaxDetails();
        taxDetails.setTaxCodeExpiryDate(quoteResponse.getAddressOnFile()
                .getTaxExemptionExpiryDate());
        taxDetails.setTaxExemptionNumber(quoteResponse.getAddressOnFile()
                .getTaxExemption());
        taxDetails.setVatExemptionNumber(quoteResponse.getAddressOnFile()
                .getVatExemptionNumber());
        taxDetails.setVatIdNumber(quoteResponse.getAddressOnFile().getVatId());

        TaxRequest taxRequest = new TaxRequest();
        Item taxRequestItem = new Item();
        List<Item> taxRequestItemList = new ArrayList<Item>();
        taxRequest.setCityName(quoteResponse.getAddressOnFile()
                .getBillingCity());
        taxRequest.setCountry(quoteResponse.getAddressOnFile()
                .getBillingCountry());
        taxRequest.setStateProv(quoteResponse.getAddressOnFile()
                .getBillingStateProv());
        taxRequest.setTaxExemption(taxDetails.getTaxExemptionNumber());
        taxRequest.setTaxExemptionExpiryDate(taxDetails.getTaxCodeExpiryDate());
        taxRequest.setVatId(taxDetails.getVatIdNumber());
        taxRequestItem.setJournalElectronicISSN(journalDetails
                .getJournalElectronicIssn());
        taxRequestItem
                .setJournalPrintISSN(journalDetails.getJournalPrintIssn());
        taxRequestItem.setProductCode(articleId);
        taxRequestItemList.add(taxRequestItem);
        taxRequest.setItem(taxRequestItemList);

        String taxAmount = orderService.getTaxAmount(taxRequest);

        String finalAmount = Integer.toString(Integer.parseInt(quoteResponse
                .getArticlePubCharge())
                - Integer.parseInt(discountDetail.getDiscountAmount())
                + Integer.parseInt(taxAmount));

        Amount amountPayable = new Amount();

        amountPayable.setAmount(finalAmount);

        AddressDetails addressDetails = new AddressDetails();

        Address contactAddressOnFile = getContactAddressFromQuoteResponse(quoteResponse
                .getAddressOnFile());

        Address billingAddressOnFile = getBillingAddressFromQuoteResponse(quoteResponse
                .getAddressOnFile());

        addressDetails.setBillingAddress(billingAddressOnFile);
        addressDetails.setContactAddress(contactAddressOnFile);

        openAccessPaymentData = new OpenAccessPaymentData();
        openAccessPaymentData.setAuthorName(quoteResponse.getAddressOnFile()
                .getContactName());
        openAccessPaymentData.setAmountPayable(amountPayable);
        openAccessPaymentData.setArticleDetails(articleDetails);
        openAccessPaymentData.setJournalDetails(journalDetails);
        openAccessPaymentData.setQuoteData(quoteData);
        openAccessPaymentData.setAddressOnFile(addressDetails);
        openAccessPaymentData.setDiscountDetail(discountDetail);
        openAccessPaymentData.setTaxAmount(taxAmount);
        openAccessPaymentData.setTaxDetails(taxDetails);

        return openAccessPaymentData;
    }

    /**
     * Gets the billing address from quote response.
     *
     * @param addressOnFile
     *            the address on file
     * @return the billing address from quote response
     */
    private Address getBillingAddressFromQuoteResponse(
            final AddressOnFile addressOnFile) {
        final Address address = new Address();
        address.setAddressLine1(addressOnFile.getBillingStreetLine1());
        address.setAddressLine2(addressOnFile.getBillingStreetLine2());
        address.setAddressType("BILLING");
        address.setCity(addressOnFile.getBillingCity());
        final Country billingCountry = new Country();
        billingCountry.setCountryCode(addressOnFile.getBillingCountry());
        address.setCountry(billingCountry);

        address.setEmailId(addressOnFile.getBillingEmail());
        address.setFirstName(addressOnFile.getBillingCustomerName());

        address.setPhoneNumber(addressOnFile.getBillingPhoneNumber());
        address.setPostCode(addressOnFile.getBillingZipPostalCode());
        address.setState(addressOnFile.getBillingStateProv());
        return address;

    }

    /**
     * Gets the contact address from quote response.
     *
     * @param addressOnFile
     *            the address on file
     * @return the contact address from quote response
     */
    private Address getContactAddressFromQuoteResponse(
            final AddressOnFile addressOnFile) {
        final Address address = new Address();
        address.setAddressLine1(addressOnFile.getContactStreetLine1());
        address.setAddressLine2(addressOnFile.getContactStreetLine2());
        address.setAddressType("CONTACT");
        address.setCity(addressOnFile.getContactCity());
        final Country billingCountry = new Country();
        billingCountry.setCountryCode(addressOnFile.getContactCountry());
        address.setCountry(billingCountry);

        address.setEmailId(addressOnFile.getContactEmail());
        address.setFirstName(addressOnFile.getContactName());

        address.setPhoneNumber(addressOnFile.getContactPhoneNumber());
        address.setPostCode(addressOnFile.getContactZipPostalCode());
        address.setStateCode(addressOnFile.getContactStateProv());
        return address;

    }

    /**
     * Validate address.
     *
     * @param address
     *            the address
     * @return true, if successful
     * @throws UserException
     *             the user exception
     */
    @Override
    public final List<Address> validateAddress(final Address address)
            throws UserException {
        List<Address> validAddressList = new ArrayList<>();
        AddressValidationRequest addressValidationRequest = new AddressValidationRequest();
        AddressValidationMultiReq addressValidationMultiReq = new AddressValidationMultiReq();
        addressValidationMultiReq.setStreet1(address.getAddressLine1());
        addressValidationMultiReq.setStreet2(address.getAddressLine2());
        addressValidationMultiReq.setLocality1(address.getCity());
        addressValidationMultiReq.setPostCode(address.getPostCode());
        addressValidationMultiReq.setProvince1(address.getState());
        addressValidationMultiReq.setCountryName(address.getCountry()
                .getCountryName());

        addressValidationRequest
                .setAddressValidationMultiReq(addressValidationMultiReq);

        List<AddressValidationMultiRes> validAddressListFromAddressDoctor = validationService
                .validateAddress(addressValidationRequest);

        if (!StringUtils.isEmpty(validAddressListFromAddressDoctor)) {
            for (AddressValidationMultiRes addressValidationMultiRes : validAddressListFromAddressDoctor) {
                Address tempAddr = new Address();
                tempAddr.setAddressLine1(addressValidationMultiRes
                        .getDeliveryAddress1());
                tempAddr.setAddressLine2(addressValidationMultiRes
                        .getDeliveryAddress2());
                tempAddr.setCity(addressValidationMultiRes.getLocality1());
                tempAddr.setState(addressValidationMultiRes
                        .getProvinceExtended1());
                tempAddr.setPostCode(addressValidationMultiRes.getPostCode());
                Country tempCountry = new Country();
                tempCountry.setCountryName(addressValidationMultiRes
                        .getCountryName1());
                tempCountry.setCountryCode(addressValidationMultiRes
                        .getCountryISO2Char());
                tempAddr.setCountry(tempCountry);
                validAddressList.add(tempAddr);
            }
        } else {
            validAddressList = null;
        }

        return validAddressList;
    }

    /**
     * Validate vat tax details.
     *
     * @param countryCode
     *            the country code
     * @param vatTaxRegNum
     *            the vat tax reg num
     * @return true, if successful
     */
    @Override
    public final boolean validateVatTaxDetails(final String countryCode,
            final String vatTaxRegNum) {

        return validationService.vatValidation(countryCode, vatTaxRegNum);
    }

    /**
     * This method is for view open access as oa and oo are almost same so we
     * are using same method of oo but with few changes
     * 
     * @param userId
     * @param orderId
     * */
    @Override
    public OnlineOpenOrder viewOpenAccess(final String userId,
            final String orderId) {
        OnlineOpenOrder onlineOpenOrder = orderOnlineOpenService
                .getOnlineOpenOrderDetails(userId, orderId);
        onlineOpenOrder.setFunderDetails(null);
        DiscountDetail discountDetail = new DiscountDetail();

        discountDetail.setDiscountAmount(new String());
        discountDetail.setDiscountPercent(new String());
        discountDetail.setDiscountType(new String());
        onlineOpenOrder.setDiscountDetail(discountDetail);
        return onlineOpenOrder;
    }

}
