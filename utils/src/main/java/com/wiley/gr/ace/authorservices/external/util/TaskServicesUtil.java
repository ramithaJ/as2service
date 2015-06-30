package com.wiley.gr.ace.authorservices.external.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;

//import com.wiley.bpm.authentication.WileyBPMAuthenticationUtils;


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

	@Value("${bpmservice.userId}")
	private static String userId;

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
	 * @return status
	 * 
	 */
	public static String invokeTaskService(String paramString) {

		String saltString = null;
		String encodedParamString = null;
		// Date currentDate = null;
		// Long date = null;
		String generatedSignature = null;
		
		try {
			encodedParamString = URLEncoder.encode(paramString, "UTF-8");

		} catch (UnsupportedEncodingException e) {
			throw new ASException();
		}

		StringBuilder decodedParamString = new StringBuilder();

		decodedParamString.append("action=").append(action).append("&")
				.append("bpdId=").append(bpId).append("&")
				.append("processAppId=").append(processAppId).append("&")
				.append("params=").append(encodedParamString).append("&")
				.append("parts=").append(parts);

		String url = bpmserviceurl + "?" + decodedParamString.toString();

		HttpPost post = new HttpPost(url);
		
		
		//TODO: Needs to be uncommented once jar is added to nexus
		/*try {
			saltString = WileyBPMAuthenticationUtils.getSalt();
		} catch (RuntimeException e) {
			throw new ASException();
		}

		Date currentDate = new Date();
		Long date = currentDate.getTime();
		String generatedSignature = WileyBPMAuthenticationUtils
				.generateSignature(key, saltString, "POST", payLoadString,
						userId, date);*/

		List<Header> headers = new ArrayList<Header>();
		headers.add(new BasicHeader(HttpHeaders.ACCEPT, httpHeaderAcceptValue));
		headers.add(new BasicHeader(HttpHeaders.CONTENT_TYPE,
				httpHeaderContentTypeValue));
		headers.add(new BasicHeader(AuthorServicesConstants.BPM_SOURCE_APP,
				sourceAppValue));
		//TODO: Needs to be uncommented once jar is added to nexus
		//headers.add(new BasicHeader(AuthorServicesConstants.BPM_LONG_DATE, date.toString()));
		headers.add(new BasicHeader(AuthorServicesConstants.BPM_USERID, userId));
		headers.add(new BasicHeader(AuthorServicesConstants.BPM_SIGNATURE,
				generatedSignature));
		headers.add(new BasicHeader(AuthorServicesConstants.BPM_SALT,
				saltString));

		HttpClient client = HttpClients.custom().setDefaultHeaders(headers)
				.build();
		HttpUriRequest request = RequestBuilder.post(url).build();

		StringBuffer result;
		try {
			HttpResponse response = client.execute(request);
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + post.getEntity());
			System.out.println("Response Code : "
					+ response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(response
					.getEntity().getContent()));

			result = new StringBuffer();
			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (ClientProtocolException e) {
			throw new ASException();
		} catch (UnsupportedOperationException e) {
			throw new ASException();
		} catch (IOException e) {
			throw new ASException();
		}

		System.out.println(result.toString());
		return result.toString();
	}

}
