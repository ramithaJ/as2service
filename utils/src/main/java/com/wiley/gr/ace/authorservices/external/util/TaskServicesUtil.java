package com.wiley.gr.ace.authorservices.external.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.bpm.authentication.WileyBPMAuthenticationUtils;
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;

/**
 * The Class TaskServicesUtil.
 *
 * @author virtusa version 1.0
 */
public class TaskServicesUtil {

	@Value("${bpmservice.url}")
	private static String bpmserviceurl;

	@Value("${bpmservice.key}")
	private static String key;

	@Value("${bpmservice.action}")
	private static String action;

	@Value("${bpmservice.bpdId}")
	private static String bpId;

	@Value("${bpmservice.processAppId}")
	private static String processAppId;

	@Value("${bpmservice.parts}")
	private static String parts;

	@Value("${bpmservice.httpHeaderAcceptValue}")
	private static String httpHeaderAcceptValue;

	@Value("${bpmservice.httpHeaderContentTypeValue}")
	private static String httpHeaderContentTypeValue;

	@Value("${bpmservice.sourceAppValue}")
	private static String sourceAppValue;

	/**
	 * Method invokes BPM service returns the status
	 * 
	 * @param paramString
	 * @param userId
	 * @return status
	 * 
	 */
	public static String invokeTaskService(String paramString, String userId) {

		String saltString = null;
		String encodedParamString = null;
		Date currentDate = null;
		Long date = null;
		String generatedSignature = null;
		Integer statusCode = null;
		String status = null;
		String payLoadString = null;

		HttpClient client = null;
		HttpUriRequest request = null;
		HttpResponse response = null;

		try {
			encodedParamString = URLEncoder.encode(paramString, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			throw new ASException("3000", e.getMessage());
		}

		StringBuilder decodedParamString = new StringBuilder();

		decodedParamString.append("action=").append(action).append("&")
				.append("bpdId=").append(bpId).append("&")
				.append("processAppId=").append(processAppId).append("&")
				.append("params=").append(encodedParamString).append("&")
				.append("parts=").append(parts);

		payLoadString = decodedParamString.toString();

		String url = bpmserviceurl + "?" + payLoadString;

		try {
			saltString = WileyBPMAuthenticationUtils.getSalt();
		} catch (RuntimeException e) {
			throw new ASException();
		}

		currentDate = new Date();
		date = currentDate.getTime();
		generatedSignature = WileyBPMAuthenticationUtils.generateSignature(key,
				saltString, "POST", payLoadString, userId, date);

		List<Header> headers = new ArrayList<Header>();
		headers.add(new BasicHeader(HttpHeaders.ACCEPT, httpHeaderAcceptValue));
		headers.add(new BasicHeader(HttpHeaders.CONTENT_TYPE,
				httpHeaderContentTypeValue));
		headers.add(new BasicHeader(AuthorServicesConstants.BPM_SOURCE_APP,
				sourceAppValue));
		headers.add(new BasicHeader(AuthorServicesConstants.BPM_LONG_DATE, date
				.toString()));
		headers.add(new BasicHeader(AuthorServicesConstants.BPM_USERID, userId));
		headers.add(new BasicHeader(AuthorServicesConstants.BPM_SIGNATURE,
				generatedSignature));
		headers.add(new BasicHeader(AuthorServicesConstants.BPM_SALT,
				saltString));

		client = HttpClients.custom().setDefaultHeaders(headers).build();
		request = RequestBuilder.post(url).build();

		try {
			response = client.execute(request);
		} catch (ClientProtocolException e) {
			throw new ASException("2000", e.getMessage());
		} catch (IOException e) {
			throw new ASException("2001", e.getMessage());
		}
		statusCode = response.getStatusLine().getStatusCode();

		if (statusCode == 200) {
			status = AuthorServicesConstants.BPM_CALL_SUCCESS_STATUS;
		} else {
			throw new ASException(statusCode.toString(), response
					.getStatusLine().getReasonPhrase());
		}

		return status;
	}

}
