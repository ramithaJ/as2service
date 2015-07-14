/**
 * 
 */
package com.wiley.gr.ace.authorservices.web.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;

/**
 * @author kalyancj
 *
 */
@RestController
@RequestMapping("/payment")
public class PaymentServiceController {
	
    /**
     * This field holds the value of orderOnlineOpenService.
     */
    @Autowired(required = true)
    private OrderOnlineOpenService orderOnlineOpenService;
    
    
    
    /**
     * @param orderId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/wpg/config/{orderId}/", method = RequestMethod.GET)
    public final Service getWPGConfiguration(
            @PathVariable("orderId") final String orderId) {

        Service service = new Service();
        service.setPayload(orderOnlineOpenService.getWPGConfiguration(orderId));
        return service;
    }
    
    
    /**
     * @param orderId
     *            - the request value
     * @return service
     */
    @RequestMapping(value = "/wpg/details/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public final HttpServletResponse redirectWpgResponse(
    		@RequestBody final UrlEncodedFormEntity form, HttpServletResponse response) {

    	String url = "http://authorservicesdev.wiley.com/landing.html#onlineopen/confirmation";
    	try {
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	response.setStatus(HttpStatus.SC_MOVED_PERMANENTLY);
    	return response;
    	
       /* Service service = new Service();
        service.setPayload(orderOnlineOpenService.getWPGConfiguration(orderId));
        return service;*/
    }

}
