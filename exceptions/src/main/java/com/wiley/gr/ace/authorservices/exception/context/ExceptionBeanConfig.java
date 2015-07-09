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
package com.wiley.gr.ace.authorservices.exception.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.exception.ASExceptionController;

/**
 * The Class ExceptionBeanConfig.
 *
 * @author virtusa version 1.0
 */
@Configuration
public class ExceptionBeanConfig {

     /** Gets the AS exception.
     *
     * @return the AS exception
     */
    @Bean(name = "asException")
    public final ASException getASException() {
        return new ASException();
    }

     /** Gets the AS exception controller.
     *
     * @return the AS exception controller
     */
    @Bean(name = "asExceptionController")
    public final ASExceptionController getASExceptionController() {
        return new ASExceptionController();
    }

}
