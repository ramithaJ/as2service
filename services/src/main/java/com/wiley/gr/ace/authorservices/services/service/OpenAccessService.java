package com.wiley.gr.ace.authorservices.services.service;

import com.wiley.gr.ace.authorservices.model.OpenAccessPaymentData;

// TODO: Auto-generated Javadoc
/**
 * The Interface OpenAccessService.
 */
public interface OpenAccessService {

	/**
	 * Gets the open access details.
	 *
	 * @param articleId the article id
	 * @param journalId the journal id
	 * @return the open access details
	 * @throws Exception the exception
	 */
	OpenAccessPaymentData getOpenAccessDetails(String userId, String articleId, String journalId) throws Exception;
}
