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

package com.wiley.gr.ace.authorservices.services.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.external.AreaOfInterests;
import com.wiley.gr.ace.authorservices.model.external.Industry;
import com.wiley.gr.ace.authorservices.model.external.JobCategory;
import com.wiley.gr.ace.authorservices.services.service.AuthorProfileExternalService;

/**
 * @author kpshiva
 *
 */
public class AuthorProfileExternalServiceImpl implements AuthorProfileExternalService {
 
	
	@Autowired
	CDMInterfaceService cdmservice;
	@Override
	public Object[] getAreaOfInterest() {
	AreaOfInterests areaOfInterests=  cdmservice.getAreaOfInterests();
		return areaOfInterests.getResponse().getDocs();
	}
	
    @Override
    public Object[] getJobCategories() {
        
        JobCategory jobCategory = cdmservice.getJobCategories();
        return jobCategory.getResponse().getDocs();
    }

    @Override
    public Object[] getIndustries() {

        Industry industry = cdmservice.getIndustries();
        return industry.getResponse().getDocs();
    }

	
	
}
