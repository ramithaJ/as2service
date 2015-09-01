/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/

package com.wiley.gr.ace.authorservices.web.context;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jta.JtaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * The Class Application.
 * 
 * @author virtusa version 1.0
 */
@SpringBootApplication(exclude = { JacksonAutoConfiguration.class,
		JtaAutoConfiguration.class })
public class Application {

	/** The max file size. */
	@Value("${MAX_FILE_SIZE}")
	private Integer maxFileSize;

	/**
	 * Multipart config element.
	 *
	 * @return the multipart config element
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement() {
		return new MultipartConfigElement("");
	}

	/**
	 * Multipart resolver.
	 *
	 * @return the multipart resolver
	 */
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
		multipartResolver.setMaxInMemorySize(maxFileSize);
		multipartResolver.setMaxUploadSize(maxFileSize);
		return multipartResolver;
	}
}
