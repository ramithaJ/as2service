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
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.model.DropDown;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ESBResponse;
import com.wiley.gr.ace.authorservices.model.external.Industries;
import com.wiley.gr.ace.authorservices.model.external.JobCategories;
import com.wiley.gr.ace.authorservices.model.external.UserProfileResponse;

/**
 * @author Virtusa
 */
public class UserProfilesImpl implements UserProfiles {
    
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
    public UserProfileResponse userProfileResponse(String userId) {
        
        return (UserProfileResponse) StubInvokerUtil
                .invokeStub(userProfile, HttpMethod.GET, UserProfileResponse.class);
    }
    
    @Override
    public boolean updateProfile(UserProfileResponse userProfileResponse) {
        
        Service service = (Service) StubInvokerUtil.invokeStub(updateProfile,
                HttpMethod.POST, Service.class);
        String status = service.getStatus();
        if (status != null && status.equalsIgnoreCase(STATUSS)) {
            return true;
        }
        return false;
    }
    
    @Override
    public UserProfileResponse userProfileResponseDashboard(String userId) {
        
        return (UserProfileResponse) StubInvokerUtil
                .invokeStub(lookupProfileDashboard, HttpMethod.GET,
                        UserProfileResponse.class);
    }
    
    @Override
    public ESBResponse getAreaOfInterests() {
        
        return (ESBResponse) StubInvokerUtil.invokeStub(
                areaofInterests, HttpMethod.GET, ESBResponse.class);
    }
    
    @Override
    public JobCategories getJobCategories() {
        
        return (JobCategories) StubInvokerUtil.invokeStub(
                jobCategories, HttpMethod.GET, JobCategories.class);
    }
    
    @Override
    public Industries getIndustries() {
        
        return (Industries) StubInvokerUtil.invokeStub(
                industries, HttpMethod.GET, Industries.class);
    }
    
    @Override
    public ESBResponse getCountries() {
        
        return (ESBResponse) StubInvokerUtil.invokeStub(
                countries, HttpMethod.GET, ESBResponse.class);
    }
    
    @Override
    public ESBResponse getStates() {
        
        return (ESBResponse) StubInvokerUtil.invokeStub(states,
                HttpMethod.GET, ESBResponse.class);
    }
    
    @Override
    public DropDown getInstitutionsList() {
        
        return (DropDown) StubInvokerUtil.invokeStub(institutions,
                HttpMethod.GET, DropDown.class);
    }
    
    @Override
    public DropDown getDepartmentsList() {
        
        return (DropDown) StubInvokerUtil.invokeStub(departments,
                HttpMethod.GET, DropDown.class);
    }
    
    @Override
    public DropDown getReasearchFunder() {
        
        return (DropDown) StubInvokerUtil.invokeStub(
                researchFunders, HttpMethod.GET, DropDown.class);
    }
    
    @Override
    public DropDown getSocietyList() {
        
        return (DropDown) StubInvokerUtil.invokeStub(societies,
                HttpMethod.GET, DropDown.class);
    }
}
