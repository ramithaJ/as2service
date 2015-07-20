package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

// TODO: Auto-generated Javadoc
/**
 * The Class OpenAccessPaymentData.
 */
@JsonInclude(Include.NON_NULL)
public class OpenAccessPaymentData {

	/** The article details. */
	private ArticleDetails articleDetails;;

	/** The journal details. */
	private JournalDetails journalDetails;

	/** The address on file. */
	private AddressDetails addressOnFile;

	/** The quote data. */
	private QuoteData quoteData;

	/** The amount payable. */
	private Amount amountPayable;

	/** The author name. */
	private String authorName;

	/** The discount detail. */
	private DiscountDetail discountDetail;

	/** The tax amount. */
	private String taxAmount;

	/** The tax details. */
	private TaxDetails taxDetails;

	/**
	 * Gets the address on file.
	 *
	 * @return the address on file
	 */
	public final AddressDetails getAddressOnFile() {
		return addressOnFile;
	}

	/**
	 * Sets the address on file.
	 *
	 * @param addressOnFile
	 *            the new address on file
	 */
	public final void setAddressOnFile(AddressDetails addressOnFile) {
		this.addressOnFile = addressOnFile;
	}

	/**
	 * Gets the quote data.
	 *
	 * @return the quote data
	 */
	public final QuoteData getQuoteData() {
		return quoteData;
	}

	/**
	 * Sets the quote data.
	 *
	 * @param quoteData
	 *            the new quote data
	 */
	public final void setQuoteData(QuoteData quoteData) {
		this.quoteData = quoteData;
	}

	/**
	 * Gets the author name.
	 *
	 * @return the author name
	 */
	public final String getAuthorName() {
		return authorName;
	}

	/**
	 * Sets the author name.
	 *
	 * @param authorName
	 *            the new author name
	 */
	public final void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * Gets the article details.
	 *
	 * @return the article details
	 */
	public final ArticleDetails getArticleDetails() {
		return articleDetails;
	}

	/**
	 * Sets the article details.
	 *
	 * @param articleDetails
	 *            the new article details
	 */
	public final void setArticleDetails(ArticleDetails articleDetails) {
		this.articleDetails = articleDetails;
	}

	/**
	 * Gets the journal details.
	 *
	 * @return the journal details
	 */
	public final JournalDetails getJournalDetails() {
		return journalDetails;
	}

	/**
	 * Sets the journal details.
	 *
	 * @param journalDetails
	 *            the new journal details
	 */
	public final void setJournalDetails(JournalDetails journalDetails) {
		this.journalDetails = journalDetails;
	}

	/**
	 * Gets the amount payable.
	 *
	 * @return the amount payable
	 */
	public final Amount getAmountPayable() {
		return amountPayable;
	}

	/**
	 * Sets the amount payable.
	 *
	 * @param amountPayable
	 *            the new amount payable
	 */
	public final void setAmountPayable(final Amount amountPayable) {
		this.amountPayable = amountPayable;
	}

	/**
	 * Gets the discount detail.
	 *
	 * @return the discount detail
	 */
	public final DiscountDetail getDiscountDetail() {
		return discountDetail;
	}

	/**
	 * Sets the discount detail.
	 *
	 * @param discountDetail
	 *            the new discount detail
	 */
	public final void setDiscountDetail(DiscountDetail discountDetail) {
		this.discountDetail = discountDetail;
	}

	/**
	 * Gets the tax amount.
	 *
	 * @return the tax amount
	 */
	public final String getTaxAmount() {
		return taxAmount;
	}

	/**
	 * Sets the tax amount.
	 *
	 * @param taxAmount the new tax amount
	 */
	public final void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	/**
	 * Gets the tax details.
	 *
	 * @return the tax details
	 */
	public final TaxDetails getTaxDetails() {
		return taxDetails;
	}

	/**
	 * Sets the tax details.
	 *
	 * @param taxDetails the new tax details
	 */
	public final void setTaxDetails(TaxDetails taxDetails) {
		this.taxDetails = taxDetails;
	}

}
