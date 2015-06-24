package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASExceptionController;
import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;

/**
 * @author virtusa version1.0
 *
 */
@RestController
@RequestMapping("/onlineopen")
public class OrderOnlineOpenController extends ASExceptionController {

    @Autowired(required = true)
    private OrderOnlineOpenService orderOnlineOpenService;

    /**
     * @param userId
     * @param articleId
     * @return
     */
    @RequestMapping(value = "/quote/{userId}/{articleId}", method = RequestMethod.GET)
    public final Service getQuote(@PathVariable("userId") final String userId,
            @PathVariable("articleId") final String articleId) {
        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getQuote(userId, articleId,
                "OO"));
        return service;
    }

    /**
     * @param userId
     * @param onlineOpenOrder
     * @return
     */
    @RequestMapping(value = "/saveLater/{userId}/", method = RequestMethod.POST)
    public final Service saveOnlineOpenOrder(
            @PathVariable("userId") final String userId,
            @RequestBody final OnlineOpenOrder onlineOpenOrder) {

        Service service = new Service();

        // TODO: Get orderId from below method and return in payload
        orderOnlineOpenService.saveLaterOrder(onlineOpenOrder, userId);

        return service;
    }

    /**
     * @param userId
     * @param onlineOpenOrder
     * @return
     */
    @RequestMapping(value = "/submit/{userId}/", method = RequestMethod.POST)
    public final Service submitOnlineOpenOrder(
            @PathVariable("userId") final String userId,
            @RequestBody final OnlineOpenOrder onlineOpenOrder) {

        Service service = new Service();
        // TODO Need to create Internal Model and set it to the payload
        service.setPayload(orderOnlineOpenService.submitOnlineOpenOrder(userId,
                onlineOpenOrder, "OO"));

        return service;
    }

    /**
     * @param userId
     * @param orderId
     * @return
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
     * @return
     */
    @RequestMapping(value = "/cancel/", method = RequestMethod.POST)
    public final Service cancelOnlineOpenOrder(
            @PathVariable("userId") final String userId,
            @PathVariable("orderId") final String orderId) {

        return new Service();
    }

    /**
     * @param userId
     * @return
     */
    @RequestMapping(value = "/fundersList/", method = RequestMethod.GET)
    public final Service getFundersList(
            @PathVariable("userId") final String userId) {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getFundersList(userId));
        return service;
    }

    /**
     * @param userId
     * @return
     */
    @RequestMapping(value = "/woaAccounts/", method = RequestMethod.GET)
    public final Service getWOAAccounts(
            @PathVariable("userId") final String userId) {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getWOAAccounts(userId));
        return service;
    }

    /**
     * @param userId
     * @return
     */
    @RequestMapping(value = "/grantRecipients/", method = RequestMethod.GET)
    public final Service getGrantRecipients(
            @PathVariable("userId") final String userId) {

        Service service = new Service();
        // service.setPayload(orderOnlineOpenService.getGrantRecipients(userId));
        return service;
    }

    /**
     * @param userId
     * @return
     */
    @RequestMapping(value = "/discountedSocieties/", method = RequestMethod.GET)
    public final Service getDiscountedSocieties(
            @PathVariable("userId") final String userId) {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService
                .getDiscountedSocieties(userId));
        return service;
    }

    /**
     * @param userId
     * @return
     */
    @RequestMapping(value = "/allOrders/{userId}/", method = RequestMethod.GET)
    public final Service getAllOrders(
            @PathVariable("userId") final String userId,
            @RequestParam(value = "type", required = false) final String type,
            @RequestParam(value = "sdate", required = false) final String sdate,
            @RequestParam(value = "edate", required = false) final String edate) {
        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getAllOrders(
                Integer.parseInt(userId), type));
        return service;
    }

    /**
     * Gets the institution discounts.
     *
     * @param userId
     *            the user id
     * @return the institution discounts
     */
    @RequestMapping(value = "/institutionDiscounts/", method = RequestMethod.GET)
    public final Service getInstitutionDiscounts(
            @PathVariable("userId") final String userId) {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService
                .getInstitutionDiscounts(userId));
        return service;
    }

}
