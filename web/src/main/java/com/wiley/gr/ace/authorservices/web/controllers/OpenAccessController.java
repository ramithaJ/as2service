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
			@RequestParam("articleId") String articleId,
			@RequestParam("journalId") String journalId) {
		Service service = new Service();
		OpenAccessPaymentData openAccessPaymentData = new OpenAccessPaymentData();

		try {
			openAccessPaymentData = openAccessService.getOpenAccessDetails(articleId, journalId);
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

}
