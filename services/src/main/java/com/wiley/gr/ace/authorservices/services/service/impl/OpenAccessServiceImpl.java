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

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.externalservices.service.ValidationService;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.AddressDetails;
import com.wiley.gr.ace.authorservices.model.Amount;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.DiscountDetail;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.OpenAccessPaymentData;
import com.wiley.gr.ace.authorservices.model.QuoteData;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.external.AddressOnFile;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationMultiReq;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationRequest;
import com.wiley.gr.ace.authorservices.model.external.Article;
import com.wiley.gr.ace.authorservices.model.external.Discount;
import com.wiley.gr.ace.authorservices.model.external.Item;
import com.wiley.gr.ace.authorservices.model.external.PdhArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.QuoteRequest;
import com.wiley.gr.ace.authorservices.model.external.TaxRequest;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductRoles;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO;
import com.wiley.gr.ace.authorservices.services.service.OpenAccessService;

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

    /** This field holds the value of articleAcceptanceCode. */
    @Value("${articleAcceptance.code}")
    private String articleAcceptanceCode;

    /** This field holds the value of articleAcceptanceMessage. */
    @Value("${articleAcceptance.message}")
    private String articleAcceptanceMessage;

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

    /** This field holds the value of correspondingAuthorId. */
    @Value("${CorrespondingAuthorId}")
    private String correspondingAuthorId;

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
            final String userId, final String articleId, final String journalId)
                    throws Exception {

        OpenAccessPaymentData openAccessPaymentData = null;

        final ProductPersonRelations articleAssignmentData = orderOnlineDAO
                .getProductPersonRelations(userId, articleId);
        if (articleAssignmentData == null) {
            throw new ASException(articleAcceptanceCode,
                    articleAcceptanceMessage);
        }

        final ProductRoles productRoles = articleAssignmentData
                .getProductRoles();

        if (!StringUtils.isEmpty(productRoles)
                && productRoles.getProductRoleCd().equalsIgnoreCase(
                        correspondingAuthorId)) {

            final SavedOrders savedOrders = orderOnlineDAO.getSavedOrders(
                    articleId, userId);
            if (null != savedOrders) {
                throw new ASException(savedOrderCode, savedOrderMessage);
            }
            final Orders existingOrders = orderOnlineDAO.getOrder(articleId,
                    userId);
            if (existingOrders != null) {
                throw new ASException(orderExistenceCode, orderExistenceMessage);
            }

            final PdhArticleResponse pdhArticleResponse = orderService
                    .pdhLookUpArticle(Integer.valueOf(articleId));

            final ArticleDetails articleDetails = new ArticleDetails();
            articleDetails.setArticleAID(pdhArticleResponse.getArticleId());

            final PdhJournalResponse pdhJournalResponse = orderService
                    .pdhLookUpJournal(Integer.valueOf(journalId));
            final JournalDetails journalDetails = new JournalDetails();
            journalDetails.setJournalId(pdhJournalResponse.getJournalId());
            journalDetails.setJournalTitle(pdhJournalResponse
                    .getJournalPrintISSN());
            final Article article = new Article();
            article.setArticleID(articleDetails.getArticleAID());
            article.setJournalElectronicISSN(pdhJournalResponse
                    .getJournalElectronicISSN());
            article.setJournalPrintISSN(pdhJournalResponse
                    .getJournalPrintISSN());
            final QuoteRequest quoteRequest = new QuoteRequest();
            quoteRequest.setArticle(article);
            final Quote quoteResponse = orderService.getQuote(quoteRequest);
            final QuoteData quoteData = new QuoteData();
            quoteData.setArticlePubCharge(quoteResponse.getArticlePubCharge());
            quoteData.setCurrency(quoteResponse.getCurrency());

            final DiscountDetail discountDetail = new DiscountDetail();
            final Discount discount = quoteResponse.getDiscount();
            discountDetail.setDiscountType(discount.getDiscountType());
            discountDetail.setDiscountAmount(discount.getDiscountAmount());
            discountDetail.setDiscountPercent(discount.getDiscountPercent());

            final TaxDetails taxDetails = new TaxDetails();
            taxDetails.setTaxCodeExpiryDate(quoteResponse.getAddressOnFile()
                    .getTaxExemptionExpiryDate());
            taxDetails.setTaxExemptionNumber(quoteResponse.getAddressOnFile()
                    .getTaxExemption());
            taxDetails.setVatExemptionNumber(quoteResponse.getAddressOnFile()
                    .getVatExemptionNumber());
            taxDetails.setVatIdNumber(quoteResponse.getAddressOnFile()
                    .getVatId());

            final TaxRequest taxRequest = new TaxRequest();
            final Item taxRequestItem = new Item();
            final List<Item> taxRequestItemList = new ArrayList<Item>();
            taxRequest.setCityName(quoteResponse.getAddressOnFile()
                    .getBillingCity());
            taxRequest.setCountry(quoteResponse.getAddressOnFile()
                    .getBillingCountry());
            taxRequest.setStateProv(quoteResponse.getAddressOnFile()
                    .getBillingStateProv());
            taxRequest.setTaxExemption(taxDetails.getTaxExemptionNumber());
            taxRequest.setTaxExemptionExpiryDate(taxDetails
                    .getTaxCodeExpiryDate());
            taxRequest.setVatId(taxDetails.getVatIdNumber());
            taxRequestItem.setJournalElectronicISSN(pdhJournalResponse
                    .getJournalElectronicISSN());
            taxRequestItem.setJournalPrintISSN(pdhJournalResponse
                    .getJournalPrintISSN());
            taxRequestItem.setProductCode(articleId);
            taxRequestItemList.add(taxRequestItem);
            taxRequest.setItem(taxRequestItemList);

            final String taxAmount = orderService.getTaxAmount(taxRequest);

            final String finalAmount = Integer.toString(Integer
                    .parseInt(pdhArticleResponse.getPrices().get(0).getPrice())
                    - Integer.parseInt(discountDetail.getDiscountAmount())
                    + Integer.parseInt(taxAmount));

            final Amount amountPayable = new Amount();

            amountPayable.setAmount(finalAmount);

            final AddressDetails addressDetails = new AddressDetails();

            final Address contactAddressOnFile = getContactAddressFromQuoteResponse(quoteResponse
                    .getAddressOnFile());

            final Address billingAddressOnFile = getBillingAddressFromQuoteResponse(quoteResponse
                    .getAddressOnFile());

            addressDetails.setBillingAddress(billingAddressOnFile);
            addressDetails.setContactAddress(contactAddressOnFile);

            openAccessPaymentData = new OpenAccessPaymentData();
            openAccessPaymentData.setAuthorName("Dishari");
            openAccessPaymentData.setAmountPayable(amountPayable);
            openAccessPaymentData.setArticleDetails(articleDetails);
            openAccessPaymentData.setJournalDetails(journalDetails);
            openAccessPaymentData.setQuoteData(quoteData);
            openAccessPaymentData.setAddressOnFile(addressDetails);
            openAccessPaymentData.setDiscountDetail(discountDetail);
            openAccessPaymentData.setTaxAmount(taxAmount);
            openAccessPaymentData.setTaxDetails(taxDetails);
        }
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
        address.setDepartment(addressOnFile.getBillingDepartment());
        address.setEmailId(addressOnFile.getBillingEmail());
        address.setFirstName(addressOnFile.getBillingCustomerName());
        address.setInstitution(addressOnFile.getBillingInstitution());
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
        address.setDepartment(addressOnFile.getContactDepartment());
        address.setEmailId(addressOnFile.getContactEmail());
        address.setFirstName(addressOnFile.getContactName());
        address.setInstitution(addressOnFile.getContactInstitution());
        address.setPhoneNumber(addressOnFile.getContactPhoneNumber());
        address.setPostCode(addressOnFile.getContactZipPostalCode());
        address.setState(addressOnFile.getContactStateProv());
        return address;

    }

    /**
     * Validate address.
     *
     * @param address
     *            the address
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean validateAddress(final Address address)
            throws Exception {
        final AddressValidationRequest addressValidationRequest = new AddressValidationRequest();
        final AddressValidationMultiReq addressValidationMultiReq = new AddressValidationMultiReq();
        addressValidationMultiReq.setStreet1(address.getAddressLine1());
        addressValidationMultiReq.setStreet2(address.getAddressLine2());
        addressValidationMultiReq.setLocality1(address.getCity());
        addressValidationMultiReq.setPostCode(address.getPostCode());
        addressValidationMultiReq.setProvince1(address.getState());
        addressValidationMultiReq.setCountryName(address.getCountry()
                .getCountryName());
        addressValidationMultiReq.setOrganization1(address.getInstitution());
        addressValidationMultiReq.setOrganizationDepartment1(address
                .getDepartment());

        addressValidationRequest
        .setAddressValidationMultiReq(addressValidationMultiReq);

        return validationService.validateAddress(addressValidationRequest);
    }

    /**
     * Validate vat tax details.
     *
     * @param countryCode
     *            the country code
     * @param vatTaxRegNum
     *            the vat tax reg num
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean validateVatTaxDetails(final String countryCode,
            final String vatTaxRegNum) throws Exception {

        return validationService.vatValidation(countryCode, vatTaxRegNum);
    }

}
