package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wiley.gr.ace.authorservices.model.external.TaxResponse;

@JsonInclude(Include.NON_NULL)
public class OpenAccessPaymentData {

	private ArticleDetails articleDetails;;
	private JournalDetails journalDetails;
	private Address addressOnFile;
	private TaxDetails taxDetails;
	private QuoteData quoteData;
	private TaxResponse taxResponse;
	private Amount amountPayable;

	public final Address getAddressOnFile() {
		return addressOnFile;
	}

	public final void setAddressOnFile(Address addressOnFile) {
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

	private String authorName;

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


	public final TaxResponse getTaxResponse() {
		return taxResponse;
	}

	public final void setTaxResponse(final TaxResponse taxResponse) {
		this.taxResponse = taxResponse;
	}

	public final Amount getAmountPayable() {
		return amountPayable;
	}

	public final void setAmountPayable(final Amount amountPayable) {
		this.amountPayable = amountPayable;
	}

}
