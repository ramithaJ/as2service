/**
 * 
 */
package com.wiley.gr.ace.authorservices.web.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.ASExceptionController;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;

/**
 * @author kalyancj
 *
 */
@RestController
@RequestMapping("/payment")
public class PaymentServiceController extends ASExceptionController {

	/**
	 * This field holds the value of orderOnlineOpenService.
	 */
	@Autowired(required = true)
	private OrderOnlineOpenService orderOnlineOpenService;
	
	@Value("${wpgOnlineOpenRedirection.url}")
	private String wpgOnlineOpenRedirectionurl;
	
	@Value("${wpgOpenAccessRedirection.url}")
	private String wpgOpenAccessRedirectionurl;

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
	 * 
	 * @param form
	 * @param response
	 */
	@RequestMapping(value = "/wpg/details/", method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public final void redirectWpgResponse(
			@RequestBody final MultiValueMap<String, String> form,
			HttpServletResponse response) {
		
		String url = null;
		 
		 orderOnlineOpenService.savePaymentDetails(form);
		 String orderType = orderOnlineOpenService.getOrderType(Integer.parseInt(form.toSingleValueMap().get("transID")));
		 
		 if (AuthorServicesConstants.ONLINE_OPEN.equals(orderType)){
			 url = wpgOnlineOpenRedirectionurl;
		 } else if (AuthorServicesConstants.OPEN_ACCESS.equals(orderType)){
			 url = wpgOpenAccessRedirectionurl;
		 }

		try {
			response.setStatus(HttpStatus.SC_MOVED_PERMANENTLY);
			response.sendRedirect(url);
		} catch (IOException e) {
			throw new ASException("704", e.getMessage());
		}

	}

}
