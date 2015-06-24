package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.Institution;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.QuoteDetails;
import com.wiley.gr.ace.authorservices.model.ResearchFunder;
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
    List<OrderDetails> getAllOrders(Integer userId, String type);

    /**
	 * @param userId
	 * @param onlineOpenOrder
	 * @throws Exception 
	 */
	OrderResponse submitOnlineOpenOrder(String userId, String orderId, String orderTypeFlag) throws Exception;

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
    void saveLaterOrder(OnlineOpenOrder order, String userId);

    /**
     * @param userId
     * @return
     */
    List<WOAAccounts> getWOAAccounts();

    /**
     * @param userId
     */
    void getGrantRecipients();

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
    List<ResearchFunder> getFundersList();

}
