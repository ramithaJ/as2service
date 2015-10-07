package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.OpenAccessPaymentData;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.OpenAccessService;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;

/**
 * The Class OpenAccessController.
 */
@RestController
@RequestMapping("/openaccess")
public class OpenAccessController {

    /** The order online open service. */
    @Autowired(required = true)
    OrderOnlineOpenService orderOnlineOpenService;

    /** The open access service. */
    @Autowired(required = true)
    OpenAccessService openAccessService;

    /**
     * Gets the open access quote.
     *
     * @param userId
     *            the user id
     * @param articleId
     *            the article id
     * @param journalId
     *            the journal id
     * @return the open access quote
     */
    @RequestMapping(value = "/getQuote", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service getOpenAccessQuote(
            @RequestParam("userId") final String userId,
            @RequestParam("articleId") final String articleId,
            @RequestParam("journalId") final String journalId) {
        Service service = new Service();
        OpenAccessPaymentData openAccessPaymentData = new OpenAccessPaymentData();

        try {
            openAccessPaymentData = openAccessService.getOpenAccessDetails(
                    userId, articleId, journalId);
            if (!StringUtils.isEmpty(openAccessPaymentData)) {
                service.setStatus("SUCCESS");
                service.setPayload(openAccessPaymentData);
            }
        } catch (Exception e) {
            service.setStatus("ERROR");
        }

        return service;
    }

    /**
     * Pay open access.
     *
     * @param userId
     *            the user id
     * @param orderId
     *            the order id
     * @return the service
     */
    @RequestMapping(value = "/pay", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service payOpenAccess(
            @RequestParam("userId") final String userId,
            @RequestParam("orderId") final String orderId) {
        Service service = new Service();

        try {
            orderOnlineOpenService.submitOnlineOpenOrder(userId, orderId, "OA");
            service.setStatus("SUCCESS");
        } catch (Exception e) {
            service.setStatus("ERROR");
            ErrorPOJO err = new ErrorPOJO();
            err.setCode("609");
            err.setMessage("Submit payment unsuccessful");
            service.setError(err);
        }

        return service;
    }

    /**
     * Save for later.
     *
     * @param userId
     *            the user id
     * @param onlineOpenOrder
     *            the online open order
     * @return the service
     */
    @RequestMapping(value = "/saveforlater", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service saveForLater(
            @RequestParam("userId") final String userId,
            @RequestBody final OnlineOpenOrder onlineOpenOrder) {
        Service service = new Service();

        orderOnlineOpenService.saveLaterOrder(onlineOpenOrder, userId);

        return service;
    }

    /**
     * View open access.
     *
     * @param userId
     *            the user id
     * @param orderId
     *            the order id
     * @return the service
     */
    @RequestMapping(value = "/view/{userId}/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service viewOpenAccess(
            @PathVariable("userId") final String userId,
            @PathVariable("orderId") final String orderId) {
        Service service = new Service();
        service.setPayload(openAccessService.viewOpenAccess(userId, orderId));
        return service;
    }

    /**
     * Validate address.
     *
     * @param address
     *            the address
     * @return the service
     */
    @RequestMapping(value = "/validate/address", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service validateAddress(@RequestBody final Address address) {
        Service service = new Service();
        try {
            if (StringUtils.isEmpty(openAccessService.validateAddress(address))) {
                service.setStatus("SUCCESS");
            } else {
                service.setStatus("FAILURE");
                ErrorPOJO err = new ErrorPOJO();
                service.setPayload(openAccessService.validateAddress(address));
                err.setCode("199");
                err.setMessage("Address is not valid");
                service.setError(err);
            }
        } catch (Exception e) {
            service.setStatus("ERROR");
            ErrorPOJO err = new ErrorPOJO();
            err.setCode("198");
            err.setMessage("Address doctor service encountered exception");
            service.setError(err);
        }
        return null;
    }

    /**
     * Validate vat tax details.
     *
     * @param countryCode
     *            the country code
     * @param vatTaxRegNum
     *            the vat tax reg num
     * @return the service
     */
    @RequestMapping(value = "/validate/vat", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service validateVatTaxDetails(
            @RequestParam("countryCD") final String countryCode,
            @RequestParam("vat") final String vatTaxRegNum) {
        Service service = new Service();
        try {
            if (openAccessService.validateVatTaxDetails(countryCode,
                    vatTaxRegNum)) {
                service.setStatus("SUCCESS");
            } else {
                service.setStatus("FAILURE");
                ErrorPOJO err = new ErrorPOJO();
                err.setCode("199");
                err.setMessage("Vat/Tax details is not valid");
                service.setError(err);
            }
        } catch (Exception e) {
            service.setStatus("ERROR");
            ErrorPOJO err = new ErrorPOJO();
            err.setCode("198");
            err.setMessage("Vat/Tax details validation service encountered exception");
            service.setError(err);
        }
        return null;
    }

}
