package com.wiley.gr.ace.authorservices.services.service;

import com.wiley.gr.ace.authorservices.model.OpenAccessPaymentData;

public interface OpenAccessService {

	OpenAccessPaymentData getOpenAccessDetails(String articleId, String journalId) throws Exception;
}
