package com.wiley.gr.ace.authorservices.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.model.Amount;
import com.wiley.gr.ace.authorservices.model.ArticleDetails;
import com.wiley.gr.ace.authorservices.model.JournalDetails;
import com.wiley.gr.ace.authorservices.model.OpenAccessPaymentData;
import com.wiley.gr.ace.authorservices.model.QuoteData;
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
		journalDetails.setJournalTitle(pdhJournalResponse.getJournalPrintISSN());
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

		String finalAmount = Integer.toString(Integer.parseInt(quote
				.getArticlePubCharge())
				- Integer.parseInt(quote.getDiscount().getDiscountAmount()));

		Amount amountPayable = new Amount();

		amountPayable.setAmount(finalAmount);

		OpenAccessPaymentData openAccessPaymentData = new OpenAccessPaymentData();
		openAccessPaymentData.setAuthorName("Dishari");
		openAccessPaymentData.setAmountPayable(amountPayable);
		openAccessPaymentData.setArticleDetails(articleDetails);
		openAccessPaymentData.setJournalDetails(journalDetails);
		openAccessPaymentData.setQuoteData(quoteData);
		return openAccessPaymentData;
	}

}
