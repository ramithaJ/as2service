/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

/**
 * @author yugandhark
 *
 */
public class CommunicationHistory {
	
	private List<CommunicationDetails> communicationDetails;

	public List<CommunicationDetails> getCommunicationDetails() {
		return communicationDetails;
	}

	public void setCommunicationDetails(
			List<CommunicationDetails> communicationDetails) {
		this.communicationDetails = communicationDetails;
	}

}
