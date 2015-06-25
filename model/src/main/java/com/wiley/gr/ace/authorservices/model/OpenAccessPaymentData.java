package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class OpenAccessPaymentData {

	private ArticleDetails articleDetails;;
	private JournalDetails journalDetails;
	private AddressDetails addressOnFile;
	private TaxDetails taxDetails;
	private QuoteData quoteData;
	private Amount taxAmount;
	private Amount amountPayable;
	private String authorName;

	public final AddressDetails getAddressOnFile() {
		return addressOnFile;
	}

	public final void setAddressOnFile(AddressDetails addressOnFile) {
		this.addressOnFile = addressOnFile;
	}

	public final TaxDetails getTaxDetails() {
		return taxDetails;
	}

	public final void setTaxDetails(TaxDetails taxDetails) {
		this.taxDetails = taxDetails;
	}

	public final QuoteData getQuoteData() {
		return quoteData;
	}

	public final void setQuoteData(QuoteData quoteData) {
		this.quoteData = quoteData;
	}

	public final String getAuthorName() {
		return authorName;
	}

	public final void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public final ArticleDetails getArticleDetails() {
		return articleDetails;
	}

	public final void setArticleDetails(ArticleDetails articleDetails) {
		this.articleDetails = articleDetails;
	}

	public final JournalDetails getJournalDetails() {
		return journalDetails;
	}

	public final void setJournalDetails(JournalDetails journalDetails) {
		this.journalDetails = journalDetails;
	}

	public final Amount getAmountPayable() {
		return amountPayable;
	}

	public final void setAmountPayable(final Amount amountPayable) {
		this.amountPayable = amountPayable;
	}

	public final Amount getTaxAmount() {
		return taxAmount;
	}

	public final void setTaxAmount(Amount taxAmount) {
		this.taxAmount = taxAmount;
	}

}
