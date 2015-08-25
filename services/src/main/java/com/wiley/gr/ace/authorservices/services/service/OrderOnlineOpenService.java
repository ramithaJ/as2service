package com.wiley.gr.ace.authorservices.services.service;

import java.io.FileNotFoundException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import com.wiley.gr.ace.authorservices.model.FundingOrganizations;
import com.wiley.gr.ace.authorservices.model.GrantRecipients;
import com.wiley.gr.ace.authorservices.model.InstitutionalDiscounts;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OrderDetails;
import com.wiley.gr.ace.authorservices.model.QuoteDetails;
import com.wiley.gr.ace.authorservices.model.SocietyDiscounts;
import com.wiley.gr.ace.authorservices.model.WOAAccountHolders;
import com.wiley.gr.ace.authorservices.model.external.DiscountedSociety;
import com.wiley.gr.ace.authorservices.model.external.OrderResponse;
import com.wiley.gr.ace.authorservices.model.external.WOAFunder;
import com.wiley.gr.ace.authorservices.model.external.WPGConfiguration;

/**
 * The Interface OrderOnlineOpenService.
 *
 * @author virtusa version 1.0
 */
public interface OrderOnlineOpenService {

    /**
     * Gets the online open order details.
     *
     * @param userId
     *            the user id
     * @param orderId
     *            the order id
     * @return the online open order details
     */
    OnlineOpenOrder getOnlineOpenOrderDetails(String userId, String orderId);

    /**
     * Initiate online.
     *
     * @param userId
     *            the user id
     * @param articleId
     *            the article id
     * @param pdmSalesFlag
     *            the pdm sales flag
     * @return the quote details
     */
    QuoteDetails initiateOnline(String userId, String articleId,
            String pdmSalesFlag);

    /**
     * Gets the all orders.
     *
     * @param orderId
     *            the order id
     * @return the all orders
     */
    List<OrderDetails> getAllOrders(String orderId);

    /**
     * Submit online open order.
     *
     * @param userId
     *            the user id
     * @param orderId
     *            the order id
     * @param orderTypeFlag
     *            the order type flag
     * @return the order response
     * @throws Exception
     *             the exception
     */
    OrderResponse submitOnlineOpenOrder(String userId, String orderId,
            String orderTypeFlag) throws Exception;

    /**
     * Retrieve discounted woa funder list.
     *
     * @param DHID
     *            the dhid
     * @return the list
     */
    List<WOAFunder> retrieveDiscountedWOAFunderList(String DHID);

    /**
     * Retrieve society discount list for journal.
     *
     * @param DHID
     *            the dhid
     * @return the list
     */
    List<DiscountedSociety> retrieveSocietyDiscountListForJournal(String DHID);

    /**
     * Checks if is addition discount available for journal.
     *
     * @param DHID
     *            the dhid
     * @return true, if is addition discount available for journal
     */
    boolean isAdditionDiscountAvailableForJournal(String DHID);

    /**
     * Save later order.
     *
     * @param order
     *            the order
     * @param userId
     *            the user id
     * @return the integer
     */
    Integer saveLaterOrder(OnlineOpenOrder order, String userId);

    /**
     * Gets the WOA funders.
     *
     * @return the WOA funders
     */
    WOAAccountHolders getWOAFunders();

    /**
     * Gets the grant recipients.
     *
     * @param articleId
     *            the article id
     * @return the grant recipients
     */
    List<GrantRecipients> getGrantRecipients(String articleId);

    /**
     * Gets the discounted societies.
     *
     * @param DHID
     *            the dhid
     * @return the discounted societies
     */
    SocietyDiscounts getDiscountedSocieties(String DHID);

    /**
     * Gets the institution discounts.
     *
     * @return the institution discounts
     */
    InstitutionalDiscounts getInstitutionDiscounts();

    /**
     * Gets the funders list.
     *
     * @return the funders list
     */
    List<FundingOrganizations> getFundersList();

    /**
     * Process all restricted funder woa accounts.
     *
     * @param id
     *            the id
     * @return the list
     */
    List<String> processAllRestrictedFunderWOAAccounts(String id);

    /**
     * Save payment details.
     *
     * @param form
     *            the form
     */
    void savePaymentDetails(final MultiValueMap<String, String> form);

    /**
     * Gets the WPG configuration.
     *
     * @param orderId
     *            the order id
     * @return the WPG configuration
     */
    WPGConfiguration getWPGConfiguration(String orderId);

    /**
     * Cancel online open order.
     *
     * @param userId
     *            the user id
     * @param orderId
     *            the order id
     * @return the order response
     */
    OrderResponse cancelOnlineOpenOrder(String userId, String orderId);

    /**
     * Gets the order type.
     *
     * @param orderId
     *            the order id
     * @return the order type
     */
    String getOrderType(final Integer orderId);

    /**
     * Pdf.
     *
     * @param ooUniqueId
     *            the oo unique id
     * @param articleID
     *            the article id
     * @return the file
     * @throws Exception
     * @throws FileNotFoundException
     */
    ResponseEntity<byte[]> getInvoice(String ooUniqueId, String articleID);
}
