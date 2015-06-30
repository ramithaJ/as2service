package com.wiley.gr.ace.authorservices.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.externalservices.service.ValidationService;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.AddressDetails;
import com.wiley.gr.ace.authorservices.model.Amount;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.DiscountDetail;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.OpenAccessPaymentData;
import com.wiley.gr.ace.authorservices.model.QuoteData;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationMultiReq;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationRequest;
import com.wiley.gr.ace.authorservices.model.external.Article;
import com.wiley.gr.ace.authorservices.model.external.PdhArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.QuoteRequest;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;
import com.wiley.gr.ace.authorservices.services.service.OpenAccessService;

// TODO: Auto-generated Javadoc
/**
 * The Class OpenAccessServiceImpl.
 */
public class OpenAccessServiceImpl implements OpenAccessService {

    /** The order service. */
    @Autowired(required = true)
    OrderService orderService;

	@Autowired
	private UserProfiles userProfiles;
	
	@Autowired(required=true)
	private ValidationService validationService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wiley.gr.ace.authorservices.services.service.OpenAccessService#
	 * getOpenAccessDetails(java.lang.String, java.lang.String)
	 */
	@Override
	public OpenAccessPaymentData getOpenAccessDetails(String userId,
			final String articleId, final String journalId) throws Exception {

        ArticleDetails articleDetails = new ArticleDetails();
        JournalDetails journalDetails = new JournalDetails();
        PdhArticleResponse pdhArticleResponse = orderService
                .pdhLookUpArticle(Integer.parseInt(articleId));
        articleDetails.setArticleAID(pdhArticleResponse.getArticleId());

		PdhJournalResponse pdhJournalResponse = orderService
				.pdhLookUpJournal(Integer.parseInt(journalId));
		journalDetails.setJournalId(pdhJournalResponse.getJournalId());
		journalDetails
				.setJournalTitle(pdhJournalResponse.getJournalPrintISSN());
		Article article = new Article();
		article.setArticleID(pdhArticleResponse.getArticleId());
		article.setJournalElectronicISSN(pdhJournalResponse
				.getJournalElectronicISSN());
		article.setJournalPrintISSN(pdhJournalResponse.getJournalPrintISSN());
		QuoteRequest quoteRequest = new QuoteRequest();
		quoteRequest.setArticle(article);
		QuoteData quoteData = new QuoteData();
		quoteData.setArticlePubCharge(pdhArticleResponse.getPrices().get(0)
				.getPrice());
		quoteData.setCurrency(pdhArticleResponse.getPrices().get(0)
				.getCurrency());

		DiscountDetail discountDetail = new DiscountDetail();
		discountDetail.setDiscountType("Society");
		discountDetail.setDiscountAmount("10");
		discountDetail.setDiscountPercent("1.5");
		String finalAmount = Integer.toString(Integer
				.parseInt(pdhArticleResponse.getPrices().get(0).getPrice())
				- Integer.parseInt("10"));

        Amount amountPayable = new Amount();

        amountPayable.setAmount(finalAmount);

		UserProfileResponse userProfileResponse = userProfiles
				.getUserProfileResponse(userId);

		AddressDetails addressDetails = new AddressDetails();
		addressDetails.setBillingAddress(userProfileResponse
				.getCustomerProfile().getAddressDetails().get(1)
				.getBillingAddress());
		addressDetails.setContactAddress(userProfileResponse
				.getCustomerProfile().getAddressDetails().get(0)
				.getCorrespondenceAddress());

		OpenAccessPaymentData openAccessPaymentData = new OpenAccessPaymentData();
		openAccessPaymentData.setAuthorName("Dishari");
		openAccessPaymentData.setAmountPayable(amountPayable);
		openAccessPaymentData.setArticleDetails(articleDetails);
		openAccessPaymentData.setJournalDetails(journalDetails);
		openAccessPaymentData.setQuoteData(quoteData);
		openAccessPaymentData.setAddressOnFile(addressDetails);
		openAccessPaymentData.setDiscountDetail(discountDetail);
		return openAccessPaymentData;
	}

	@Override
	public boolean validateAddress(Address address) throws Exception {
		AddressValidationRequest addressValidationRequest = new AddressValidationRequest();
		AddressValidationMultiReq addressValidationMultiReq = new AddressValidationMultiReq();
		addressValidationMultiReq.setStreet1(address.getAddressLine1());
		addressValidationMultiReq.setStreet2(address.getAddressLine2());
		addressValidationMultiReq.setLocality1(address.getCity());
		addressValidationMultiReq.setPostCode(address.getPostCode());
		addressValidationMultiReq.setProvince1(address.getState());
		addressValidationMultiReq.setCountryName(address.getCountry().getCountryName());
		addressValidationMultiReq.setOrganization1(address.getInstitution());
		addressValidationMultiReq.setOrganizationDepartment1(address.getDepartment());
		
		addressValidationRequest.setAddressValidationMultiReq(addressValidationMultiReq);
		
		return validationService.validateAddress(addressValidationRequest);
	}

}
