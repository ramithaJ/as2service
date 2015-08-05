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
package com.wiley.gr.ace.authorservices.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
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
import com.wiley.gr.ace.authorservices.model.RequestOnlineOpen;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.TaxDetails;
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
     * This field holds the value of orderOnlineOpenService.
     */
    @Autowired(required = true)
    private OrderOnlineOpenService orderOnlineOpenService;

    /**
     * This field holds the value of OpenAccessService.
     */
    @Autowired(required = true)
    private OpenAccessService openAccessService;

    /**
     * This field holds the value of nlineOpenAuthorValidatorService.
     */
    @Autowired(required = true)
    private OnlineOpenAuthorValidatorService onlineOpenAuthorValidatorService;

    /**
     * This field holds the value of invalidContactAddressCode.
     */
    @Value("${contactAddress.code}")
    private String invalidContactAddressCode;

    /**
     * This field holds the value of invalidContactAddressMessage.
     */
    @Value("${contactAddress.message}")
    private String invalidContactAddressMessage;

    /**
     * This field holds the value of invalidBillingAddressCode.
     */
    @Value("${billingAddress.code}")
    private String invalidBillingAddressCode;

    /**
     * This field holds the value of invalidBillingAddressMessage.
     */
    @Value("${billingAddress.message}")
    private String invalidBillingAddressMessage;

    /**
     * This field holds the value of onlineOpen.
     */
    @Value("${OnlineOpen}")
    private String onlineOpen;

    /**
     * @param userId
     *            - the request value
     * @param articleId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/initiateOnline/{userId}/{articleId}/", method = RequestMethod.GET)
    public final Service initiateOnline(
            @PathVariable("userId") final String userId,
            @PathVariable("articleId") final String articleId) {
        final Service service = new Service();
        service.setPayload(orderOnlineOpenService.initiateOnline(userId,
                articleId, onlineOpen));
        return service;
    }

    /**
     * @param userId
     *            - the request value
     * @param onlineOpenOrder
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/saveLater/{userId}/", method = RequestMethod.POST)
    public final Service saveOnlineOpenOrder(
            @PathVariable("userId") final String userId,
            @RequestBody final OnlineOpenOrder onlineOpenOrder) {

        final Service service = new Service();
        service.setPayload(orderOnlineOpenService.saveLaterOrder(
                onlineOpenOrder, userId));
        return service;
    }

    /**
     * @param userId
     *            - the request value
     * @param orderId
     *            - the request value
     * @return service
     * 
     */
    @RequestMapping(value = "/submit/{userId}/{orderId}/", method = RequestMethod.POST)
    public final Service submitOnlineOpenOrder(
            @PathVariable("userId") final String userId,
            @PathVariable("orderId") final String orderId) {

        final Service service = new Service();

        try {
            orderOnlineOpenService.submitOnlineOpenOrder(userId, orderId,
                    onlineOpen);
        } catch (final Exception e) {
            throw new ASException("704", e.getMessage());
        }

        return service;
    }

    /**
     * @param userId
     *            - the request value
     * @param orderId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/view/{userId}/{orderId}/", method = RequestMethod.GET)
    public final Service getOnlineOpenOrderDetails(
            @PathVariable("userId") final String userId,
            @PathVariable("orderId") final String orderId) {
        final Service service = new Service();
        service.setPayload(orderOnlineOpenService.getOnlineOpenOrderDetails(
                userId, orderId));
        return service;
    }

    /**
     * @param userId
     *            - the request value
     * @param orderId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/cancel/{userId}/{orderId}/", method = RequestMethod.POST)
    public final Service cancelOnlineOpenOrder(
            @PathVariable("userId") final String userId,
            @PathVariable("orderId") final String orderId) {

        orderOnlineOpenService.cancelOnlineOpenOrder(userId, orderId);
        return new Service();
    }

    /**
     * @return service
     */
    @RequestMapping(value = "/fundersList/", method = RequestMethod.GET)
    public final Service getFundersList() {

        final Service service = new Service();
        service.setPayload(orderOnlineOpenService.getFundersList());
        return service;
    }

    /**
     * @param funderId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/subFundersList/{funderId}/", method = RequestMethod.GET)
    public final Service getSubFundersList(
            @PathVariable("funderId") final String funderId) {

        final Service service = new Service();
        service.setPayload(orderOnlineOpenService.getFundersList());
        return service;
    }

    /**
     * @return service
     */
    @RequestMapping(value = "/woaFunders/", method = RequestMethod.GET)
    public final Service getWOAFunders() {

        final Service service = new Service();
        service.setPayload(orderOnlineOpenService.getWOAFunders());
        return service;
    }

    /**
     * @param articleId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/grantRecipients/{articleId}/", method = RequestMethod.GET)
    public final Service getGrantRecipients(
            @PathVariable("articleId") final String articleId) {

        final Service service = new Service();
        service.setPayload(orderOnlineOpenService.getGrantRecipients(articleId));
        return service;
    }

    /**
     * @return service
     */
    @RequestMapping(value = "/discountedSocieties/{dhId}/", method = RequestMethod.GET)
    public final Service getDiscountedSocieties(
            @PathVariable("dhId") final String dhId) {

        final Service service = new Service();
        service.setPayload(orderOnlineOpenService.getDiscountedSocieties(dhId));
        return service;
    }

    /**
     * @param orderId
     *            - the request value
     * @param type
     *            - the request value
     * @param sdate
     *            - the request value
     * @param edate
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/allOrders/{orderId}/", method = RequestMethod.GET)
    public final Service getAllOrders(
            @PathVariable("orderId") final String orderId,
            @RequestParam(value = "type", required = false) final String type,
            @RequestParam(value = "sdate", required = false) final String sdate,
            @RequestParam(value = "edate", required = false) final String edate) {
        final Service service = new Service();
        service.setPayload(orderOnlineOpenService.getAllOrders(orderId));
        return service;
    }

    /**
     * Gets the institution discounts.
     *
     * @return service
     */
    @RequestMapping(value = "/institutionDiscounts/{dhId}/", method = RequestMethod.GET)
    public final Service getInstitutionDiscounts(
            @PathVariable("dhId") final String dhId) {

        final Service service = new Service();
        service.setPayload(orderOnlineOpenService.getInstitutionDiscounts(dhId));
        return service;
    }

    /**
     * @param taxDetails
     *            - the request value
     * @return Service
     */
    @RequestMapping(value = "/validate/taxDetails/{userId}/", method = RequestMethod.POST)
    public final Service validateTaxDetails(
            @RequestBody final TaxDetails taxDetails) {

        onlineOpenAuthorValidatorService.validateTaxDetails(taxDetails);

        return new Service();
    }

    /**
     * @param funderDetailsList
     *            - the request value
     * @return Service
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
     *            - the request value
     * @param addressDetails
     *            - the request value
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
            } catch (final Exception e) {
                throw new ASException(invalidContactAddressCode,
                        invalidContactAddressMessage);
            }
        }

        if (addressDetails.getBillingAddress() != null) {
            try {
                openAccessService.validateAddress(addressDetails
                        .getBillingAddress());
            } catch (final Exception e) {
                throw new ASException(invalidBillingAddressCode,
                        invalidBillingAddressMessage);
            }
        }

        return new Service();
    }

    /**
     * @param id
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/woaFunder/{id}/", method = RequestMethod.GET)
    public final Service processAllRestrictedFunderWOAAccounts(
            @PathVariable("id") final String id) {

        final Service service = new Service();
        service.setPayload(orderOnlineOpenService
                .processAllRestrictedFunderWOAAccounts(id));

        return service;
    }

    /**
     * @param userId
     *            - the request value
     * @param onlineOpenOrder
     *            - the request value
     * @return Service
     */
    @RequestMapping(value = "/preview/{userId}/", method = RequestMethod.POST)
    public final Service processAndValidateNext(
            @PathVariable("userId") final String userId,
            @RequestBody final OnlineOpenOrder onlineOpenOrder) {

        final Service service = new Service();
        service.setPayload(onlineOpenAuthorValidatorService
                .processAndValidateNext(onlineOpenOrder, userId));

        return service;
    }

    /**
     * This method will generate PDF.
     * 
     * @param ooUniqueId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/invoice/{ooUniqueId}/{articleID}/", method = RequestMethod.GET)
    public final ResponseEntity<byte[]> getPDF(
            @PathVariable("ooUniqueId") final String ooUniqueId,
            @PathVariable("articleID") final String articleID) {

        return orderOnlineOpenService.getInvoice(ooUniqueId, articleID);

    }

    /**
     * @param userId
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/permissions/{userId}/{articleId}/", method = RequestMethod.GET)
    public final Service viewOnlineOpenRequest(
            @PathVariable("userId") final String userId,
            @PathVariable("articleId") final String articleId) {
        Service service = new Service();
        service.setPayload(orderOnlineOpenService.viewOnlineOpenRequest(userId,
                articleId));
        return service;

    }

    /**
     * @param requestOnlineOpen
     * @return
     */
    @RequestMapping(value = "/permissions/", method = RequestMethod.POST)
    public final Service requestOnlineOpen(
            @RequestBody final RequestOnlineOpen requestOnlineOpen) {
        orderOnlineOpenService.requestOnlineOpen(requestOnlineOpen);
        return new Service();

    }
}
