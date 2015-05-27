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

package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;
import com.wiley.gr.ace.authorservices.model.external.LookUpProfile;

/**
 * @author RAVISINHA
 */
public class CDMInterfaceServiceImpl implements CDMInterfaceService {

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService
     * #lookUpProfile(java.lang.String)
     */
    @Override
    public LookUpProfile lookUpProfile(String userId) {
        final String url = "http://demo6374909.mockable.io/user/lookUpProfile";
        LookUpProfile lookupProfile = (LookUpProfile) StubInvokerUtil
                .invokeStub(url, HttpMethod.GET, "LookUpProfile");
        return lookupProfile;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService
     * #
     * updateProfile(com.wiley.gr.ace.authorservices.model.external.LookUpProfile
     * )
     */
    @Override
    public boolean updateProfile(LookUpProfile lookUpProfile) {
        final String url = "http://demo6374909.mockable.io/user/updateProfile";
        Service service = (Service) StubInvokerUtil.invokeStub(url,
                HttpMethod.POST, "Service");
        String status = service.getStatus();

        if (status != null && status.equalsIgnoreCase("success")) {

            return true;
        }
        return false;
    }

	@Override
	public List<ESBResponse> getAreaOfInterests() {
		 final String url = "http://vmesbdev.wiley.com:15200/PickList?q=*&fq=doc_type:SUBJECTCD&wt=json&rows1000000";
		 ESBResponse areaOfInterests = (ESBResponse) StubInvokerUtil
	                .invokeStub(url, HttpMethod.GET, "AreaOfInterests");
		        List<ESBResponse> areaOfInterestslist=new ArrayList<ESBResponse>();
		          areaOfInterestslist.add(areaOfInterests);
		 
	        return areaOfInterestslist ;
	}

    @Override
    public JobCategories getJobCategories() {
        
        final String url = "http://vmesbdev.wiley.com:15200/PickList?q=*&fq=doc_type:JOBCD&wt=json&rows=1000000";
        JobCategories jobCategory = (JobCategories) StubInvokerUtil
                   .invokeStub(url, HttpMethod.GET, "JobCategory");
           return jobCategory ;
    }

    @Override
    public Industries getIndustries() {

        final String url = "http://vmesbdev.wiley.com:15200/PickList?q=*&fq=doc_type:NAICSCD&wt=json&rows=1000000";
        Industries industry = (Industries) StubInvokerUtil
                   .invokeStub(url, HttpMethod.GET, "Industry");
           return industry ;
    }
}
