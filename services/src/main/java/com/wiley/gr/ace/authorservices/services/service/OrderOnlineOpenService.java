package com.wiley.gr.ace.authorservices.services.service;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.FundingOrganizations;
import com.wiley.gr.ace.authorservices.model.GrantRecipients;
import com.wiley.gr.ace.authorservices.model.InstitutionalDiscounts;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.PaymentDetails;
import com.wiley.gr.ace.authorservices.model.QuoteDetails;
import com.wiley.gr.ace.authorservices.model.SocietyDiscounts;
import com.wiley.gr.ace.authorservices.model.WOAAccountHolders;
import com.wiley.gr.ace.authorservices.model.external.DiscountedSociety;
import com.wiley.gr.ace.authorservices.model.external.OrderResponse;
import com.wiley.gr.ace.authorservices.model.external.WOAFunder;
import com.wiley.gr.ace.authorservices.model.external.WPGConfiguration;

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
    QuoteDetails initiateOnline(String userId, String articleId,
            String pdmSalesFlag);

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
    List<WOAFunder> retrieveDiscountedWOAFunderList(String DHID);

    /**
     * @param userId
     * @param onlineOpenOrder
     */
    List<DiscountedSociety> retrieveSocietyDiscountListForJournal(String DHID);

    /**
     * @param userId
     * @param journalId
     */
    boolean isAdditionDiscountAvailableForJournal(String DHID);

    /**
     * @param order
     * @return
     */
    Integer saveLaterOrder(OnlineOpenOrder order, String userId);

    /**
     * @param userId
     * @return
     */
    WOAAccountHolders getWOAFunders();

    /**
     * @param userId
     * @return
     */
    List<GrantRecipients> getGrantRecipients(String articleId);

    /**
     * @param userId
     * @return
     */
    SocietyDiscounts getDiscountedSocieties();

    /**
     * @param userId
     * @return
     */
    InstitutionalDiscounts getInstitutionDiscounts();

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
    List<String> processAllRestrictedFunderWOAAccounts(String id);

    /**
     * @param paymentDetails
     * @return
     */
    boolean updatePaymentDetails(PaymentDetails paymentDetails);

    /**
     * @return
     */
    WPGConfiguration getWPGConfiguration();
}
