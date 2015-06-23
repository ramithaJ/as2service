package com.wiley.gr.ace.authorservices.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.model.Amount;
import com.wiley.gr.ace.authorservices.model.OpenAccessPaymentData;
import com.wiley.gr.ace.authorservices.model.external.Article;
import com.wiley.gr.ace.authorservices.model.external.ArticleData;
import com.wiley.gr.ace.authorservices.model.external.PdhJournalResponse;
import com.wiley.gr.ace.authorservices.model.external.Quote;
import com.wiley.gr.ace.authorservices.model.external.QuoteRequest;
import com.wiley.gr.ace.authorservices.services.service.OpenAccessService;

public class OpenAccessServiceImple implements OpenAccessService {

	@Autowired(required = true)
	ESBInterfaceService esbInterfaceService;

	@Override
	public OpenAccessPaymentData getOpenAccessDetails(final String articleId,
			final String journalId) throws Exception {

		ArticleData articleData = esbInterfaceService.pdhGetArticle(articleId);
		PdhJournalResponse pdhJournalResponse = esbInterfaceService
				.pdhJournalLookUp(journalId);
		Article article = new Article();
		article.setArticleID(articleData.getAidECORE());
		article.setJournalElectronicISSN(pdhJournalResponse
				.getJournalElectronicISSN());
		article.setJournalPrintISSN(pdhJournalResponse.getJournalPrintISSN());
		QuoteRequest quoteRequest = new QuoteRequest();
		quoteRequest.setArticle(article);
		Quote quote = esbInterfaceService.getQuote(quoteRequest);

		String finalAmount = Integer.toString(Integer.parseInt(quote
				.getArticlePubCharge())
				- Integer.parseInt(quote.getDiscount().getDiscountAmount()));

		Amount amountPayable = new Amount();

		amountPayable.setAmount(finalAmount);

		OpenAccessPaymentData openAccessPaymentData = new OpenAccessPaymentData();
		openAccessPaymentData.setAmountPayable(amountPayable);
		openAccessPaymentData.setArticleData(articleData);
		openAccessPaymentData.setQuote(quote);
		return openAccessPaymentData;
	}
}
