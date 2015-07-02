package com.wiley.gr.ace.authorservices.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.ASExceptionController;
import com.wiley.gr.ace.authorservices.model.AddressDetails;
import com.wiley.gr.ace.authorservices.model.FunderDetails;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.PaymentDetails;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
import com.wiley.gr.ace.authorservices.model.external.WOAFunder;
import com.wiley.gr.ace.authorservices.services.service.OnlineOpenAuthorValidatorService;
import com.wiley.gr.ace.authorservices.services.service.OpenAccessService;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;

/**
 * @author virtusa version1.0
 *
 */
@RestController
@RequestMapping("/onlineopen")
public class OrderOnlineOpenController extends ASExceptionController {

    /**
     * This field holds the value of orderOnlineOpenService
     */
    @Autowired(required = true)
    private OrderOnlineOpenService orderOnlineOpenService;

    /**
     * This field holds the value of OpenAccessService
     */
    @Autowired(required = true)
    private OpenAccessService openAccessService;

    /**
     * This field holds the value of nlineOpenAuthorValidatorService
     */
    @Autowired(required = true)
    private OnlineOpenAuthorValidatorService onlineOpenAuthorValidatorService;

    /**
     * This field holds the value of invalidContactAddressCode
     */
    @Value("${contactAddress.code}")
    private String invalidContactAddressCode;

    /**
     * This field holds the value of invalidContactAddressMessage
     */
    @Value("${contactAddress.message}")
    private String invalidContactAddressMessage;

    /**
     * This field holds the value of invalidBillingAddressCode
     */
    @Value("${billingAddress.code}")
    private String invalidBillingAddressCode;

    /**
     * This field holds the value of invalidBillingAddressMessage
     */
    @Value("${billingAddress.message}")
    private String invalidBillingAddressMessage;

    /**
     * This field holds the value of onlineOpen
     */
    @Value("${OnlineOpen}")
    private String onlineOpen;

    /**
     * @param userId
     * @param articleId
     * @return service
     */
    @RequestMapping(value = "/quote/{userId}/{articleId}", method = RequestMethod.GET)
    public final Service getQuote(@PathVariable("userId") final String userId,
            @PathVariable("articleId") final String articleId) {
        Service service = new Service();
        service.setPayload(orderOnlineOpenService.initiateOnline(userId,
                articleId, onlineOpen));
        return service;
    }

    /**
     * @param userId
     * @param onlineOpenOrder
     * @return service
     */
    @RequestMapping(value = "/saveLater/{userId}/", method = RequestMethod.POST)
    public final Service saveOnlineOpenOrder(
            @PathVariable("userId") final String userId,
            @RequestBody final OnlineOpenOrder onlineOpenOrder) {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService.saveLaterOrder(
                onlineOpenOrder, userId));
        return service;
    }

    /**
     * @param userId
     * @param orderId
     * @return service
     * 
     */
    @RequestMapping(value = "/submit/{userId}/{orderId}/", method = RequestMethod.POST)
    public final Service submitOnlineOpenOrder(
            @PathVariable("userId") final String userId,
            @PathVariable("orderId") final String orderId) {

        Service service = new Service();

        try {
            orderOnlineOpenService.submitOnlineOpenOrder(userId, orderId, "OO");
        } catch (Exception e) {
            throw new ASException("704", e.getMessage());
        }

        return service;
    }

    /**
     * @param userId
     * @param orderId
     * @return service
     */
    @RequestMapping(value = "/view/{userId}/{orderId}/", method = RequestMethod.GET)
    public final Service getOnlineOpenOrderDetails(
            @PathVariable("userId") final String userId,
            @PathVariable("orderId") final String orderId) {
        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getOnlineOpenOrderDetails(
                userId, orderId));
        return service;
    }

    /**
     * @param userId
     * @param orderId
     * @return service
     */
    @RequestMapping(value = "/cancel/", method = RequestMethod.POST)
    public final Service cancelOnlineOpenOrder(
            @PathVariable("userId") final String userId,
            @PathVariable("orderId") final String orderId) {

        return new Service();
    }

    /**
     * @return service
     */
    @RequestMapping(value = "/fundersList/", method = RequestMethod.GET)
    public final Service getFundersList() {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getFundersList());
        return service;
    }

    /**
     * @param funderId
     * @return service
     */
    @RequestMapping(value = "/subFundersList/{funderId}/", method = RequestMethod.GET)
    public final Service getSubFundersList(
            @PathVariable("funderId") final String funderId) {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getSubFundersList(funderId));
        return service;
    }

    /**
     * @return service
     */
    @RequestMapping(value = "/woaFunders/", method = RequestMethod.GET)
    public final Service getWOAFunders() {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getWOAFunders());
        return service;
    }

    /**
     * @param articleId
     * @return service
     */
    @RequestMapping(value = "/grantRecipients/{articleId}", method = RequestMethod.GET)
    public final Service getGrantRecipients(
            @PathVariable("articleId") final String articleId) {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getGrantRecipients(articleId));
        return service;
    }

    /**
     * @return service
     */
    @RequestMapping(value = "/discountedSocieties/", method = RequestMethod.GET)
    public final Service getDiscountedSocieties() {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getDiscountedSocieties());
        return service;
    }

    /**
     * @param orderId
     * @param type
     * @param sdate
     * @param edate
     * @return service
     */
    @RequestMapping(value = "/allOrders/{orderId}/", method = RequestMethod.GET)
    public final Service getAllOrders(
            @PathVariable("orderId") final String orderId,
            @RequestParam(value = "type", required = false) final String type,
            @RequestParam(value = "sdate", required = false) final String sdate,
            @RequestParam(value = "edate", required = false) final String edate) {
        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getAllOrders(orderId));
        return service;
    }

    /**
     * Gets the institution discounts.
     *
     * @return service
     */
    @RequestMapping(value = "/institutionDiscounts/", method = RequestMethod.GET)
    public final Service getInstitutionDiscounts() {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getInstitutionDiscounts());
        return service;
    }

    /**
     * @param taxDetails
     * @return service
     */
    @RequestMapping(value = "/validate/taxDetails/{userId}/", method = RequestMethod.POST)
    public final Service validateTaxDetails(
            @RequestBody final TaxDetails taxDetails) {

        onlineOpenAuthorValidatorService.validateTaxDetails(taxDetails);

        return new Service();
    }

    /**
     * @param funderDetailsList
     * @return service
     */
    @RequestMapping(value = "/validate/funderDetails/", method = RequestMethod.POST)
    public final Service validateFunderDetails(
            @RequestBody final List<FunderDetails> funderDetailsList) {

        onlineOpenAuthorValidatorService
                .validateFunderDetails(funderDetailsList);

        return new Service();
    }

    /**
     * @param userId
     * @param addressDetails
     * @return service
     */
    @RequestMapping(value = "/validate/address/{userId}/", method = RequestMethod.POST)
    public final Service validateAddressDetails(
            @PathVariable("userId") final String userId,
            @RequestBody final AddressDetails addressDetails) {

        if (addressDetails.getContactAddress() != null) {
            try {
                openAccessService.validateAddress(addressDetails
                        .getContactAddress());
            } catch (Exception e) {
                throw new ASException(invalidContactAddressCode,
                        invalidContactAddressMessage);
            }
        }

        if (addressDetails.getBillingAddress() != null) {
            try {
                openAccessService.validateAddress(addressDetails
                        .getBillingAddress());
            } catch (Exception e) {
                throw new ASException(invalidBillingAddressCode,
                        invalidBillingAddressMessage);
            }
        }

        return new Service();
    }

    /**
     * @param id
     * @return service
     */
    @RequestMapping(value = "/woaFunder/{id}", method = RequestMethod.GET)
    public final Service processAllRestrictedFunderWOAAccounts(
            @PathVariable("id") final String id) {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService
                .processAllRestrictedFunderWOAAccounts(id));

        return service;
    }

    /**
     * @param woaFunder
     * @return service
     */
    @RequestMapping(value = "/woaFunder/", method = RequestMethod.POST)
    public final Service validateAndProcessWOAAccount(
            @RequestBody final WOAFunder woaFunder) {

        orderOnlineOpenService.processWOAAccount(woaFunder);

        return new Service();
    }

    /**
     * @param userId
     * @param onlineOpenOrder
     * @return Service
     */
    @RequestMapping(value = "/next/preview/{userId}", method = RequestMethod.POST)
    public final Service processAndValidateNext(
            @PathVariable("userId") final String userId,
            @RequestBody final OnlineOpenOrder onlineOpenOrder) {

        Service service = new Service();
        service.setPayload(onlineOpenAuthorValidatorService
                .processAndValidateNext(onlineOpenOrder, userId));

        return service;
    }

    /**
     * @param paymentDetails
     * @return service
     */
    @RequestMapping(value = "/paymentDetails", method = RequestMethod.POST)
    public final Service updatePaymentDetails(
            @RequestBody final PaymentDetails paymentDetails) {
        Service service = new Service();
        service.setPayload(orderOnlineOpenService
                .updatePaymentDetails(paymentDetails));
        return service;

    }

    /**
     * @return service
     */
    @RequestMapping(value = "/wpg/config", method = RequestMethod.GET)
    public final Service getWPGConfiguration() {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getWPGConfiguration());
        return service;
    }

}
