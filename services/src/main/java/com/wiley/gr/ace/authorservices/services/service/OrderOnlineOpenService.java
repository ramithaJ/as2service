package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.FundingOrganizations;
import com.wiley.gr.ace.authorservices.model.GrantRecipients;
import com.wiley.gr.ace.authorservices.model.Institution;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.QuoteDetails;
import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.model.WOAAccounts;
import com.wiley.gr.ace.authorservices.model.external.DiscountedSociety;
import com.wiley.gr.ace.authorservices.model.external.OrderResponse;
import com.wiley.gr.ace.authorservices.model.external.WOAFunder;

/**
 * @author virtusa version 1.0
 *
 */
public interface OrderOnlineOpenService {

    /**
     * @param userId
     * @param orderId
     * @return
     */
    OnlineOpenOrder getOnlineOpenOrderDetails(String userId, String orderId);

    /**
     * @param userId
     * @param articleId
     * @return
     */
    QuoteDetails getQuote(String userId, String articleId, String pdmSalesFlag);

    /**
     * @param userId
     * @return
     */
    List<OrderDetails> getAllOrders(String orderId);

    /**
     * @param userId
     * @param onlineOpenOrder
     * @throws Exception
     */
    OrderResponse submitOnlineOpenOrder(String userId, String orderId,
            String orderTypeFlag) throws Exception;

    /**
     * @param userId
     * @param onlineOpenOrder
     */
    List<WOAFunder> retrieveDiscountedWOAFunderList(String userId, String DHID);

    /**
     * @param userId
     * @param onlineOpenOrder
     */
    List<DiscountedSociety> retrieveSocietyDiscountListForJournal(
            String userId, String journalId);

    /**
     * @param userId
     * @param journalId
     */
    boolean isAdditionDiscountAvailableForJournal(String userId,
            String journalId);

    /**
     * @param order
     * @return
     */
    Integer saveLaterOrder(OnlineOpenOrder order, String userId);

    /**
     * @param userId
     * @return
     */
    List<WOAAccounts> getWOAAccounts();

    /**
     * @param userId
     * @return
     */
    List<GrantRecipients> getGrantRecipients(String articleId);

    /**
     * @param userId
     * @return
     */
    List<Society> getDiscountedSocieties();

    /**
     * @param userId
     * @return
     */
    List<Institution> getInstitutionDiscounts();

    /**
     * @param userId
     * @return
     */
    List<FundingOrganizations> getFundersList();
    
	/**
	 * @param userId
	 * @param woaFunder
	 */
	void processWOAAccount(WOAFunder woaFunder);

	/**
	 * @param name
	 */
	List<String> processAllRestrictedFunderWOAAccounts(String name);

}
