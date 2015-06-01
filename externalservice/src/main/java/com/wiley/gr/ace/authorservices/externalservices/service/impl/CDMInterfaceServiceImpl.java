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

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import com.wiley.gr.ace.authorservices.external.util.StubInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.model.DropDown;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;
import com.wiley.gr.ace.authorservices.model.external.LookUpProfile;

/**
 * @author RAVISINHA
 */
public class CDMInterfaceServiceImpl implements CDMInterfaceService {
    
    @Value("${lookupProfile.url}")
    private String userProfile;
    
    @Value("${updateProfile.url}")
    private String updateProfile;
    
    @Value("${lookUpProfileDashboard.url}")
    private String lookupProfileDashboard;
    
    @Value("${institutions.url}")
    private String institutions;
    
    @Value("${departments.url}")
    private String departments;
    
    @Value("${reasearchFunders.url}")
    private String researchFunders;
    
    @Value("${societies.url}")
    private String societies;
    
    @Value("${areaofInterests.url}")
    private String areaofInterests;
    
    @Value("${jobCategories.url}")
    private String jobCategories;
    
    @Value("${industries.url}")
    private String industries;
    
    @Value("${countries.url}")
    private String countries;
    
    @Value("${states.url}")
    private String states;
    
    private static final String STATUSS = "success";
    
    @Override
    public LookUpProfile lookUpProfile(String userId) {
        
        LookUpProfile lookupProfile = (LookUpProfile) StubInvokerUtil
                .invokeStub(userProfile, HttpMethod.GET, LookUpProfile.class);
        return lookupProfile;
    }
    
    @Override
    public boolean updateProfile(LookUpProfile lookUpProfile) {
        
        Service service = (Service) StubInvokerUtil.invokeStub(updateProfile,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUSS)) {
            return true;
        }
        return false;
    }
    
    @Override
    public LookUpProfile lookUpProfileDashboard(String userId) {
        
        LookUpProfile lookupProfile = (LookUpProfile) StubInvokerUtil
                .invokeStub(lookupProfileDashboard, HttpMethod.GET,
                        LookUpProfile.class);
        return lookupProfile;
    }
    
    @Override
    public ESBResponse getAreaOfInterests() {
        
        ESBResponse areaOfInterests = (ESBResponse) StubInvokerUtil.invokeStub(
                areaofInterests, HttpMethod.GET, ESBResponse.class);
        return areaOfInterests;
    }
    
    @Override
    public JobCategories getJobCategories() {
        
        JobCategories jobCategory = (JobCategories) StubInvokerUtil.invokeStub(
                jobCategories, HttpMethod.GET, JobCategories.class);
        return jobCategory;
    }
    
    @Override
    public Industries getIndustries() {
        
        Industries industry = (Industries) StubInvokerUtil.invokeStub(
                industries, HttpMethod.GET, Industries.class);
        return industry;
    }
    
    @Override
    public ESBResponse getCountries() {
        
        ESBResponse countrycode = (ESBResponse) StubInvokerUtil.invokeStub(
                countries, HttpMethod.GET, ESBResponse.class);
        return countrycode;
    }
    
    @Override
    public ESBResponse getStates() {
        
        ESBResponse state = (ESBResponse) StubInvokerUtil.invokeStub(states,
                HttpMethod.GET, ESBResponse.class);
        return state;
    }
    
    @Override
    public DropDown getInstitutionsList() {
        
        DropDown dropDown = (DropDown) StubInvokerUtil.invokeStub(institutions,
                HttpMethod.GET, DropDown.class);
        return dropDown;
    }
    
    @Override
    public DropDown getDepartmentsList() {
        
        DropDown dropDown = (DropDown) StubInvokerUtil.invokeStub(departments,
                HttpMethod.GET, DropDown.class);
        return dropDown;
    }
    
    @Override
    public DropDown getReasearchFunder() {
        
        DropDown dropDown = (DropDown) StubInvokerUtil.invokeStub(
                researchFunders, HttpMethod.GET, DropDown.class);
        return dropDown;
    }
    
    @Override
    public DropDown getSocietyList() {
        
        DropDown dropDown = (DropDown) StubInvokerUtil.invokeStub(societies,
                HttpMethod.GET, DropDown.class);
        return dropDown;
    }
}
