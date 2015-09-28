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
package com.wiley.gr.ace.authorservices.autocomplete.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteCachingService;
import com.wiley.gr.ace.authorservices.autocomplete.service.AutocompleteService;
import com.wiley.gr.ace.authorservices.autocomplete.service.impl.AutocompleteCachingServiceImpl;
import com.wiley.gr.ace.authorservices.autocomplete.service.impl.AutocompleteServiceImpl;

/**
 * The Class ServiceBeanConfig.
 * 
 * @author Virtusa version1.0
 *
 */
@Configuration
public class AutocompleteServiceBeanConfig {

    /**
     * Autocomplete Service.
     * 
     * @return autocompleteServiceImpl.
     */
    @Bean(name = "AutocompleteService")
    public AutocompleteService autocompleteService() {
        return new AutocompleteServiceImpl();
    }

    /**
     * AutocompleteCachingService.
     * 
     * @return autocompleteCachingServiceImpl.
     */
    @Bean(name = "AutocompleteCachingService")
    public AutocompleteCachingService autocompleteCachingService() {
        return new AutocompleteCachingServiceImpl();
    }
}
