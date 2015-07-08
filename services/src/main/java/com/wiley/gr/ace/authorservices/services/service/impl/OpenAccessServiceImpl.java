package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

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
import com.wiley.gr.ace.authorservices.model.external.AddressValidationMultiReq;
import com.wiley.gr.ace.authorservices.model.external.AddressValidationRequest;
import com.wiley.gr.ace.authorservices.model.external.Article;
import com.wiley.gr.ace.authorservices.model.external.Item;
import com.wiley.gr.ace.authorservices.model.external.PdhArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.QuoteRequest;
import com.wiley.gr.ace.authorservices.model.external.TaxRequest;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO;
import com.wiley.gr.ace.authorservices.services.service.OpenAccessService;

// TODO: Auto-generated Javadoc
/**
 * The Class OpenAccessServiceImpl.
 */
public class OpenAccessServiceImpl implements OpenAccessService {

	/** The order service. */
	@Autowired(required = true)
	OrderService orderService;

	@Autowired(required = true)
	private ValidationService validationService;

	@Autowired(required = true)
	private OrderOnlineDAO orderOnlineDAO;

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
	 * This field holds the value of correspondingAuthorId
	 */
	@Value("${CorrespondingAuthorId}")
	private String correspondingAuthorId;

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
		OpenAccessPaymentData openAccessPaymentData = null;
		PdhArticleResponse pdhArticleResponse = orderService
				.pdhLookUpArticle(Integer.parseInt(articleId));

		ProductPersonRelations articleAssignmentData = orderOnlineDAO
				.getProductPersonRelations(userId, articleId);
		if (articleAssignmentData == null) {
			throw new ASException(articleAcceptanceCode,
					articleAcceptanceMessage);
		}
		if (articleAssignmentData.getProductRoles() != null
				&& articleAssignmentData.getProductRoles().getProductRoleCd()
						.equalsIgnoreCase(correspondingAuthorId)) {

			SavedOrders savedOrders = orderOnlineDAO.getSavedOrders(articleId,
					userId);
			if (null != savedOrders) {
				throw new ASException(savedOrderCode, savedOrderMessage);
			}
			Orders existingOrders = orderOnlineDAO.getOrder(articleId, userId);
			if (existingOrders != null) {
				throw new ASException(orderExistenceCode, orderExistenceMessage);
			}

			articleDetails.setArticleAID(pdhArticleResponse.getArticleId());

			PdhJournalResponse pdhJournalResponse = orderService
					.pdhLookUpJournal(Integer.parseInt(journalId));
			journalDetails.setJournalId(pdhJournalResponse.getJournalId());
			journalDetails.setJournalTitle(pdhJournalResponse
					.getJournalPrintISSN());
			Article article = new Article();
			article.setArticleID(pdhArticleResponse.getArticleId());
			article.setJournalElectronicISSN(pdhJournalResponse
					.getJournalElectronicISSN());
			article.setJournalPrintISSN(pdhJournalResponse
					.getJournalPrintISSN());
			QuoteRequest quoteRequest = new QuoteRequest();
			quoteRequest.setArticle(article);
			Quote quoteResponse = orderService.getQuote(quoteRequest);
			QuoteData quoteData = new QuoteData();
			quoteData.setArticlePubCharge(quoteResponse.getArticlePubCharge());
			quoteData.setCurrency(quoteResponse.getCurrency());

			DiscountDetail discountDetail = new DiscountDetail();
			discountDetail.setDiscountType(quoteResponse.getDiscount()
					.getDiscountType());
			discountDetail.setDiscountAmount(quoteResponse.getDiscount()
					.getDiscountAmount());
			discountDetail.setDiscountPercent(quoteResponse.getDiscount()
					.getDiscountPercent());

			TaxDetails taxDetails = new TaxDetails();
			taxDetails.setTaxCodeExpiryDate(quoteResponse.getAddressOnFile()
					.getTaxExemptionExpiryDate());
			taxDetails.setTaxExemptionNumber(quoteResponse.getAddressOnFile()
					.getTaxExemption());
			taxDetails.setVatExemptionNumber(quoteResponse.getAddressOnFile()
					.getVatExemptionNumber());
			taxDetails.setVatIdNumber(quoteResponse.getAddressOnFile()
					.getVatId());

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

			String taxAmount = orderService.getTaxAmount(taxRequest);

			String finalAmount = Integer.toString(Integer
					.parseInt(pdhArticleResponse.getPrices().get(0).getPrice())
					- Integer.parseInt(discountDetail.getDiscountAmount())
					+ Integer.parseInt(taxAmount));

			Amount amountPayable = new Amount();

			amountPayable.setAmount(finalAmount);

			AddressDetails addressDetails = new AddressDetails();

			Address contactAddressOnFile = new Address();
			contactAddressOnFile.setAddressLine1(quoteResponse
					.getAddressOnFile().getContactStreetLine1());
			contactAddressOnFile.setAddressLine2(quoteResponse
					.getAddressOnFile().getContactStreetLine2());
			contactAddressOnFile.setAddressType("CONTACT");
			contactAddressOnFile.setCity(quoteResponse.getAddressOnFile()
					.getContactCity());
			Country contactCountry = new Country();
			contactCountry.setCountryCode(quoteResponse.getAddressOnFile()
					.getContactCountry());
			contactAddressOnFile.setCountry(contactCountry);
			contactAddressOnFile.setDepartment(quoteResponse.getAddressOnFile()
					.getContactDepartment());
			contactAddressOnFile.setEmailId(quoteResponse.getAddressOnFile()
					.getContactEmail());
			contactAddressOnFile.setFirstName(quoteResponse.getAddressOnFile()
					.getContactName());
			contactAddressOnFile.setInstitution(quoteResponse
					.getAddressOnFile().getContactInstitution());
			contactAddressOnFile.setPhoneNumber(quoteResponse
					.getAddressOnFile().getContactPhoneNumber());
			contactAddressOnFile.setPostCode(quoteResponse.getAddressOnFile()
					.getContactZipPostalCode());
			contactAddressOnFile.setState(quoteResponse.getAddressOnFile()
					.getContactStateProv());

			Address billingAddressOnFile = new Address();
			billingAddressOnFile.setAddressLine1(quoteResponse
					.getAddressOnFile().getBillingStreetLine1());
			billingAddressOnFile.setAddressLine2(quoteResponse
					.getAddressOnFile().getBillingStreetLine2());
			billingAddressOnFile.setAddressType("CONTACT");
			billingAddressOnFile.setCity(quoteResponse.getAddressOnFile()
					.getBillingCity());
			Country billingCountry = new Country();
			billingCountry.setCountryCode(quoteResponse.getAddressOnFile()
					.getBillingCountry());
			billingAddressOnFile.setCountry(billingCountry);
			billingAddressOnFile.setDepartment(quoteResponse.getAddressOnFile()
					.getBillingDepartment());
			billingAddressOnFile.setEmailId(quoteResponse.getAddressOnFile()
					.getBillingEmail());
			billingAddressOnFile.setFirstName(quoteResponse.getAddressOnFile()
					.getBillingCustomerName());
			billingAddressOnFile.setInstitution(quoteResponse
					.getAddressOnFile().getBillingInstitution());
			billingAddressOnFile.setPhoneNumber(quoteResponse
					.getAddressOnFile().getBillingPhoneNumber());
			billingAddressOnFile.setPostCode(quoteResponse.getAddressOnFile()
					.getBillingZipPostalCode());
			billingAddressOnFile.setState(quoteResponse.getAddressOnFile()
					.getBillingStateProv());

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

	@Override
	public boolean validateAddress(Address address) throws Exception {
		AddressValidationRequest addressValidationRequest = new AddressValidationRequest();
		AddressValidationMultiReq addressValidationMultiReq = new AddressValidationMultiReq();
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

	@Override
	public boolean validateVatTaxDetails(String countryCode, String vatTaxRegNum)
			throws Exception {
		
		return validationService.vatValidation(countryCode, vatTaxRegNum);
	}

}
