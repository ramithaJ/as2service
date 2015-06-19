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

package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.model.Amount;
import com.wiley.gr.ace.authorservices.model.Discounts;
import com.wiley.gr.ace.authorservices.model.FunderDetails;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.external.OrderData;
import com.wiley.gr.ace.authorservices.model.external.PdhLookup;
import com.wiley.gr.ace.authorservices.persistence.entity.ArticleAuthorAssignment;
import com.wiley.gr.ace.authorservices.persistence.entity.Articles;
import com.wiley.gr.ace.authorservices.persistence.entity.Orders;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedOrders;
import com.wiley.gr.ace.authorservices.persistence.services.OrderOnlineDAO;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;

/**
 * @author virtusa version 1.0
 *
 */
public class OrderOnlineOpenServiceImpl implements OrderOnlineOpenService {

	/** Getting Bean Of Order Service */
	@Autowired(required = true)
	private OrderService orderservice;

	/** Getting Bean Of OrderOnlineDAO Service */
	@Autowired(required = true)
	private OrderOnlineDAO orderOnlineDAO;

	/**
	 * This method will take userId and orderId as input and calls external
	 * service to get details of Online order details
	 */
	@Override
	public OnlineOpenOrder getOnlineOpenOrderDetails(final String userId,
			final String orderId) {
		OnlineOpenOrder onlineOpenOrder = new OnlineOpenOrder();
		OrderData orderData = orderservice.getOrderDetails(userId, orderId);
		onlineOpenOrder.setArticleId(orderData.getArticle().getDHID());
		// Should check the below one
		// onlineOpenOrder.setJournalId(orderData.getArticle().getJournal().get);
		onlineOpenOrder.setPaymentMethod(orderData.getPayment()
				.getPaymentMethod());
		// need to calculate this
		// onlineOpenOrder.setTaxPercentage(orderData.);
		Discounts discounts = new Discounts();
		discounts.setInstitutionId(orderData.getPricing().getDiscounts()
				.getDiscount().getAffiliationData().getName());
		// Need to check this
		// discounts.setOtherDiscounts(orderData.getDiscountData().getOtherDiscounts());
		discounts.setPromoCode(orderData.getPricing().getDiscounts()
				.getDiscount().getPromoCode());
		discounts.setSocietyId(orderData.getPricing().getDiscounts()
				.getDiscount().getSocietyData().getName());
		onlineOpenOrder.setDiscounts(discounts);
		Amount amount = new Amount();
		amount.setAmount(orderData.getPricing().getAmountToBePaid().toString());
		amount.setAmount(orderData.getPricing().getCurrency());
		onlineOpenOrder.setAmountPayable(amount);
		FunderDetails funderDetails = new FunderDetails();
		List<FunderDetails> listoffunderdetails = new ArrayList<FunderDetails>();
		// Currently not getting this data from stub
		// funderDetails.setFunderId(orderData.getFundingDetails().getFunderId());
		// funderDetails.setResearchFunderId(orderData.getFundingDetails()
		// .getResearchFunderId());
		funderDetails
				.setWoaAccountId(orderData.getWoaAccountHolder().getName());
		listoffunderdetails.add(funderDetails);
		onlineOpenOrder.setFunderDetails(listoffunderdetails);
		TaxDetails taxDetails = new TaxDetails();
		taxDetails.setCountryCode(orderData.getTaxDetails().getCountryCode());
		taxDetails.setTaxCodeExpiryDate(orderData.getTaxDetails()
				.getTaxExpiration());
		taxDetails.setTaxExemptionNumber(orderData.getTaxDetails()
				.getTaxNumber());
		taxDetails.setVatExemptionNumber(orderData.getTaxDetails()
				.getVatExemptionNumber());
		taxDetails.setVatIdNumber(orderData.getTaxDetails().getVatIdNumber());
		onlineOpenOrder.setTaxDetails(taxDetails);
		// TODO: Update Address details
		// Address address = new Address();
		// address.setAddressLine1(orderData.getAddresses().get(0)
		// .getAddressLine1());
		// AddressDetails addressDetails = new AddressDetails();
		// addressDetails.setAddress(null);

		return onlineOpenOrder;
	}

	/**
	 * Method to get quote.
	 */
	@Override
	public boolean getQuote(String userId, String articleId) {

		// Article details having userId and articleId
		Articles articles = orderOnlineDAO.getArticleDetails(articleId);
		if (null == articles) {
			throw new ASException("801", "");
		}

		PdhLookup pdhLookup = orderservice.pdhLookUp(articles.getJournals()
				.getDhId());
		// check article is onlineOpen article or not.
		if (pdhLookup.getPdmSalesModel().equalsIgnoreCase("OO")) {

			// Article Author Assignment table details having userId and
			// articleId.
			ArticleAuthorAssignment articleAuthorAssignment = orderOnlineDAO
					.getAritcleAssignmentDetails(userId, articleId);
			if (articleAuthorAssignment == null) {
				throw new ASException("802", "Article is not yet Accepted");
			}
			// check user is corresponding author or not.
			if (articleAuthorAssignment.getArticleRoles().getArticleRoleCd()
					.equalsIgnoreCase("0001")) {

				// check is there any saved orders for this article.
				SavedOrders savedOrders = orderOnlineDAO.getSavedOrders(
						articleId, userId);
				if (null != savedOrders) {
					throw new ASException("803",
							"Order already exists for this Article");
				}
				// check is there any placed orders for this article.
				Orders orders = orderOnlineDAO.getOrder(articleAuthorAssignment
						.getArticleAuthId());
				if (orders != null) {
					throw new ASException("804",
							"Order already submitted for this Article");
				}
				// calling external service for article and journal titles.
				orderservice.pdhLookUpArticle(articles.getDhId());
				orderservice.pdhLookUp(articles.getJournals().getDhId());
			}
		}

		return false;
	}

}
