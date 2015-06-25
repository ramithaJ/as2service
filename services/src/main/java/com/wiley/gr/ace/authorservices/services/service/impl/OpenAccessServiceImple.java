package com.wiley.gr.ace.authorservices.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.AddressDetails;
import com.wiley.gr.ace.authorservices.model.Amount;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.OpenAccessPaymentData;
import com.wiley.gr.ace.authorservices.model.QuoteData;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.external.Article;
import com.wiley.gr.ace.authorservices.model.external.PdhArticleResponse;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.QuoteRequest;
import com.wiley.gr.ace.authorservices.services.service.OpenAccessService;

public class OpenAccessServiceImple implements OpenAccessService {

	@Autowired(required = true)
	OrderService orderService;

	@Override
	public OpenAccessPaymentData getOpenAccessDetails(final String articleId,
			final String journalId) throws Exception {

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
		Quote quote = orderService.getQuote(quoteRequest);
		QuoteData quoteData = new QuoteData();
		quoteData.setArticlePubCharge(quote.getArticlePubCharge());
		quoteData.setCurrency(quote.getCurrency());
		quoteData.setPaymentStatus(quote.getPaymentStatus());
		quoteData.setQuoteStatus(quote.getQuoteStatus());

		Amount taxAmount = new Amount();
		// Still need to do tax calculation from service
		String finalAmount = Integer.toString(Integer.parseInt(quote
				.getArticlePubCharge())
				- Integer.parseInt(quote.getDiscount().getDiscountAmount())
				+ Integer.parseInt(taxAmount.getAmount()));

		Amount amountPayable = new Amount();

		amountPayable.setAmount(finalAmount);

		Address billingAddress = new Address();
		billingAddress.setAddressLine1(quote.getAddressOnFile()
				.getBillingStreetLine1());
		billingAddress.setAddressLine2(quote.getAddressOnFile()
				.getBillingStreetLine2());
		billingAddress.setAddressType("BILLING");
		billingAddress.setCity(quote.getAddressOnFile().getBillingCity());
		Country billingCountry = new Country();
		billingCountry.setCountryCode(quote.getAddressOnFile()
				.getBillingCountry());
		billingAddress.setCountry(billingCountry);
		billingAddress.setDepartment(quote.getAddressOnFile()
				.getBillingDepartment());
		billingAddress.setEmailId(quote.getAddressOnFile().getBillingEmail());
		billingAddress.setInstitution(quote.getAddressOnFile()
				.getBillingInstitution());
		billingAddress.setPhoneNumber(quote.getAddressOnFile()
				.getBillingPhoneNumber());
		billingAddress.setState(quote.getAddressOnFile().getBillingStateProv());
		billingAddress.setPostCode(quote.getAddressOnFile()
				.getBillingZipPostalCode());

		Address contactAddress = new Address();
		contactAddress.setAddressLine1(quote.getAddressOnFile()
				.getContactStreetLine1());
		contactAddress.setAddressLine2(quote.getAddressOnFile()
				.getContactStreetLine2());
		contactAddress.setAddressType("CONTACT");
		contactAddress.setCity(quote.getAddressOnFile().getContactCity());
		Country contactCountry = new Country();
		contactCountry.setCountryCode(quote.getAddressOnFile()
				.getContactCountry());
		contactAddress.setCountry(contactCountry);
		contactAddress.setDepartment(quote.getAddressOnFile()
				.getContactDepartment());
		contactAddress.setEmailId(quote.getAddressOnFile().getContactEmail());
		contactAddress.setInstitution(quote.getAddressOnFile()
				.getContactInstitution());
		contactAddress.setPhoneNumber(quote.getAddressOnFile()
				.getContactPhoneNumber());
		contactAddress.setState(quote.getAddressOnFile().getContactStateProv());
		contactAddress.setPostCode(quote.getAddressOnFile()
				.getContactZipPostalCode());

		AddressDetails addressDetails = new AddressDetails();
		addressDetails.setBillingAddress(billingAddress);
		addressDetails.setContactAddress(contactAddress);

		TaxDetails taxDetails = new TaxDetails();
		taxDetails.setTaxCodeExpiryDate(quote.getAddressOnFile()
				.getTaxExemptionExpiryDate());
		taxDetails.setTaxExemptionNumber(quote.getAddressOnFile()
				.getTaxExemption());
		taxDetails.setVatExemptionNumber(quote.getAddressOnFile()
				.getVatExemptionNumber());
		taxDetails.setVatIdNumber(quote.getAddressOnFile().getVatId());
		taxDetails.setCountryCode(quote.getAddressOnFile().getBillingCountry());

		OpenAccessPaymentData openAccessPaymentData = new OpenAccessPaymentData();
		openAccessPaymentData.setAuthorName("Dishari");
		openAccessPaymentData.setAmountPayable(amountPayable);
		openAccessPaymentData.setArticleDetails(articleDetails);
		openAccessPaymentData.setJournalDetails(journalDetails);
		openAccessPaymentData.setQuoteData(quoteData);
		openAccessPaymentData.setAddressOnFile(addressDetails);
		openAccessPaymentData.setTaxDetails(taxDetails);
		openAccessPaymentData.setTaxAmount(taxAmount);
		return openAccessPaymentData;
	}

}
