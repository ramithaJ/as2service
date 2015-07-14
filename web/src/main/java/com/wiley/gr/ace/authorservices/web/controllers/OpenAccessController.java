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

@RestController
@RequestMapping("/openaccess")
public class OpenAccessController {

    @Autowired(required = true)
    OrderOnlineOpenService orderOnlineOpenService;

    @Autowired(required = true)
    OpenAccessService openAccessService;

    @RequestMapping(value = "/getQuote", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service getOpenAccessQuote(
            @RequestParam("userId") String userId,
            @RequestParam("articleId") String articleId,
            @RequestParam("journalId") String journalId) {
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

    @RequestMapping(value = "/pay", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service payOpenAccess(
            @RequestParam("userId") String userId,
            @RequestParam("orderId") String orderId) {
        Service service = new Service();

        try {
            orderOnlineOpenService.submitOnlineOpenOrder(userId, orderId, "OA");
            service.setStatus("SUCCESS");
        } catch (Exception e) {
            service.setStatus("ERROR");
            ErrorPOJO err = new ErrorPOJO();
            err.setCode(609);
            err.setMessage("Submit payment unsuccessful");
            service.setError(err);
        }

        return service;
    }

    @RequestMapping(value = "/saveforlater", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service saveForLater(
            @RequestParam("userId") String userId,
            @RequestBody OnlineOpenOrder onlineOpenOrder) {
        Service service = new Service();

        orderOnlineOpenService.saveLaterOrder(onlineOpenOrder, userId);

        return service;
    }

    @RequestMapping(value = "/view/{userId}/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service viewOpenAccess(
            @PathVariable("userId") String userId,
            @PathVariable("orderId") String orderId) {
        Service service = new Service();
        OnlineOpenOrder onlineOpenOrder = openAccessService.viewOpenAccess(
                userId, orderId);
        service.setPayload(onlineOpenOrder);
        return service;
    }

    @RequestMapping(value = "/validate/address", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service validateAddress(@RequestBody Address address) {
        Service service = new Service();
        try {
            if (openAccessService.validateAddress(address)) {
                service.setStatus("SUCCESS");
            } else {
                service.setStatus("FAILURE");
                ErrorPOJO err = new ErrorPOJO();
                err.setCode(199);
                err.setMessage("Address is not valid");
                service.setError(err);
            }
        } catch (Exception e) {
            service.setStatus("ERROR");
            ErrorPOJO err = new ErrorPOJO();
            err.setCode(198);
            err.setMessage("Address doctor service encountered exception");
            service.setError(err);
        }
        return null;
    }

    @RequestMapping(value = "/validate/vat", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody Service validateVatTaxDetails(
            @RequestParam("countryCD") String countryCode,
            @RequestParam("vat") String vatTaxRegNum) {
        Service service = new Service();
        try {
            if (openAccessService.validateVatTaxDetails(countryCode,
                    vatTaxRegNum)) {
                service.setStatus("SUCCESS");
            } else {
                service.setStatus("FAILURE");
                ErrorPOJO err = new ErrorPOJO();
                err.setCode(199);
                err.setMessage("Vat/Tax details is not valid");
                service.setError(err);
            }
        } catch (Exception e) {
            service.setStatus("ERROR");
            ErrorPOJO err = new ErrorPOJO();
            err.setCode(198);
            err.setMessage("Vat/Tax details validation service encountered exception");
            service.setError(err);
        }
        return null;
    }

}
