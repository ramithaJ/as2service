package com.wiley.gr.ace.authorservices.exception.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.ASExceptionController;

/**
 * @author SarmaKumarap
 *
 */
@Configuration
public class ExceptionBeanConfig {
	
	@Bean(name = "asException")
	public ASException getASException() {
		return new ASException();
	}
	
	@Bean(name = "asExceptionController")
	public ASExceptionController getASExceptionController() {
		return new ASExceptionController();
	}
	
}
