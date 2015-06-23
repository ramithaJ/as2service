package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.model.OpenAccessPaymentData;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.OpenAccessService;

@RestController
@RequestMapping("/openaccess")
public class OpenAccessController {

	@Autowired(required = true)
	OpenAccessService openAccessService;

	@RequestMapping(value = "/getQuote", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Service getOpenAccessQuote(
			@RequestParam("journalId") String journalId,
			@RequestParam("articleId") String articleId) {
		OpenAccessPaymentData openAccessPaymentData = null;
		Service service = new Service();
		try {
			openAccessPaymentData = openAccessService.getOpenAccessDetails(
					articleId, journalId);
			if (!StringUtils.isEmpty(openAccessPaymentData)) {
				service.setStatus("SUCCESS");
				service.setPayload(openAccessPaymentData);
			} else {
				service.setStatus("FAILURE");
			}
		} catch (Exception e) {
			service.setStatus("ERROR");
		}

		return service;
	}
}
