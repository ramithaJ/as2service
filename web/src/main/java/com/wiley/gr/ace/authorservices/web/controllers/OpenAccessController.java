package com.wiley.gr.ace.authorservices.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
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

    /**
     * Logger Configured.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(OpenAccessController.class);

    /** The order online open service. */
    @Autowired(required = true)
    OrderOnlineOpenService orderOnlineOpenService;

    /** The open access service. */
    @Autowired(required = true)
    OpenAccessService openAccessService;

    /** The open access quote error code. */
    @Value("${OpenAccessController.openAccessQuote.code}")
    private String openAccessQuoteErrorCode;

    /** The open access quote error mesage. */
    @Value("${OpenAccessController.openAccessQuote.message}")
    private String openAccessQuoteErrorMesage;

    /** The pay open access error code. */
    @Value("${OpenAccessController.payOpenAccess.code}")
    private String payOpenAccessErrorCode;

    /** The pay open access error message. */
    @Value("${OpenAccessController.payOpenAccess.message}")
    private String payOpenAccessErrorMessage;

    /** The validate address error code. */
    @Value("${OpenAccessController.validateAddress.code}")
    private String validateAddressErrorCode;

    /** The validate address error message. */
    @Value("${OpenAccessController.validateAddress.message}")
    private String validateAddressErrorMessage;

    /** The validate address failed error code. */
    @Value("${OpenAccessController.validateAddressFailed.code}")
    private String validateAddressFailedErrorCode;

    /** The validate address failed error message. */
    @Value("${OpenAccessController.validateAddressFailed.message}")
    private String validateAddressFailedErrorMessage;

    /** The validate vat tax details error code. */
    @Value("${OpenAccessController.validateVatTaxDetails.code}")
    private String validateVatTaxDetailsErrorCode;

    /** The validate vat tax details error message. */
    @Value("${OpenAccessController.validateVatTaxDetails.message}")
    private String validateVatTaxDetailsErrorMessage;

    /** The vat tax details failed error code. */
    @Value("${OpenAccessController.vatTaxDetailsFailed.code}")
    private String vatTaxDetailsFailedErrorCode;

    /** The vat tax details failed error message. */
    @Value("${OpenAccessController.vatTaxDetailsFailed.message}")
    private String vatTaxDetailsFailedErrorMessage;

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
    @RequestMapping(value = "/getQuote", method = RequestMethod.GET)
    public Service getOpenAccessQuote(
            @RequestParam("userId") final String userId,
            @RequestParam("articleId") final String articleId,
            @RequestParam("journalId") final String journalId) {
        Service service = new Service();
        OpenAccessPaymentData openAccessPaymentData = new OpenAccessPaymentData();

        try {
            openAccessPaymentData = openAccessService.getOpenAccessDetails(
                    userId, articleId, journalId);
            if (!StringUtils.isEmpty(openAccessPaymentData)) {
                service.setStatus(AuthorServicesConstants.SUCCESS);
                service.setPayload(openAccessPaymentData);
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException(openAccessQuoteErrorCode,
                    openAccessQuoteErrorMesage);

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
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public Service payOpenAccess(@RequestParam("userId") final String userId,
            @RequestParam("orderId") final String orderId) {
        Service service = new Service();

        try {
            orderOnlineOpenService.submitOnlineOpenOrder(userId, orderId, "OA");
            service.setStatus("SUCCESS");
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException(payOpenAccessErrorCode,
                    payOpenAccessErrorMessage);
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
    @RequestMapping(value = "/saveforlater", method = RequestMethod.PUT)
    public Service saveForLater(@RequestParam("userId") final String userId,
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
    @RequestMapping(value = "/view/{userId}/{orderId}", method = RequestMethod.GET)
    public Service viewOpenAccess(@PathVariable("userId") final String userId,
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
    @RequestMapping(value = "/validate/address", method = RequestMethod.POST)
    public Service validateAddress(@RequestBody final Address address) {
        Service service = new Service();
        try {
            if (StringUtils.isEmpty(openAccessService.validateAddress(address))) {
                service.setStatus(AuthorServicesConstants.SUCCESS);
            } else {
                service.setStatus(AuthorServicesConstants.FAILURE);
                ErrorPOJO err = new ErrorPOJO();
                service.setPayload(openAccessService.validateAddress(address));
                err.setCode(validateAddressErrorCode);
                err.setMessage(validateAddressErrorMessage);
                service.setError(err);
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException(validateAddressFailedErrorCode,
                    validateAddressFailedErrorMessage);
        }
        return service;
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
    @RequestMapping(value = "/validate/vat", method = RequestMethod.GET)
    public Service validateVatTaxDetails(
            @RequestParam("countryCD") final String countryCode,
            @RequestParam("vat") final String vatTaxRegNum) {
        Service service = new Service();
        try {
            if (openAccessService.validateVatTaxDetails(countryCode,
                    vatTaxRegNum)) {
                service.setStatus(AuthorServicesConstants.SUCCESS);
            } else {
                service.setStatus(AuthorServicesConstants.FAILURE);
                ErrorPOJO err = new ErrorPOJO();
                err.setCode(validateVatTaxDetailsErrorCode);
                err.setMessage(validateVatTaxDetailsErrorMessage);
                service.setError(err);
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException(vatTaxDetailsFailedErrorCode,
                    vatTaxDetailsFailedErrorMessage);
        }
        return service;
    }

}
