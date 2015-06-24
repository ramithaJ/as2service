package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.OnlineOpenOrder;
import com.wiley.gr.ace.authorservices.model.QuoteDetails;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.OrderOnlineOpenService;

@RestController
@RequestMapping("/openaccess")
public class OpenAccessController {

	@Autowired(required=true)
	OrderOnlineOpenService orderOnlineOpenService;

	@RequestMapping(value = "/getQuote", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Service getOpenAccessQuote(
			@RequestParam("userId") String userId,
			@RequestParam("articleId") String articleId) {
		Service service = new Service();
		QuoteDetails quoteDetails = new QuoteDetails();
		
		try{
			quoteDetails = orderOnlineOpenService.getQuote(userId, articleId, "OA");
			if(!StringUtils.isEmpty(quoteDetails)){
				service.setStatus("SUCCESS");
				service.setPayload(quoteDetails);
			}
		} catch(Exception e){
			service.setStatus("ERROR");
		}

		return service;
	}
	
	@RequestMapping(value = "/pay", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Service payOpenAccess(
			@RequestParam("userId") String userId,
			@RequestBody OnlineOpenOrder onlineOpenOrder) {
		Service service = new Service();
		
		orderOnlineOpenService.submitOnlineOpenOrder(userId, onlineOpenOrder, "OA");

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
	
	
}
