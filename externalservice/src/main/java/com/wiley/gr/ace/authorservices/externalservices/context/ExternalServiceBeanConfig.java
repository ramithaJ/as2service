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
package com.wiley.gr.ace.authorservices.externalservices.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.externalservices.service.ALMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.CDMInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.ESBInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.InvoiceService;
import com.wiley.gr.ace.authorservices.externalservices.service.LicenseInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.NotificationService;
import com.wiley.gr.ace.authorservices.externalservices.service.OrcidInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.OrderService;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.PermissionService;
import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.externalservices.service.TaskService;
import com.wiley.gr.ace.authorservices.externalservices.service.UserManagement;
import com.wiley.gr.ace.authorservices.externalservices.service.UserProfiles;
import com.wiley.gr.ace.authorservices.externalservices.service.ValidationService;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ALMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.CDMInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ESBInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.InvoiceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.LicenseInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.NotificationServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.OrcidInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.OrderServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ParticipantsInterfaceServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.PermissionServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.SharedServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.TaskServiceImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.UserManagementImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.UserProfilesImpl;
import com.wiley.gr.ace.authorservices.externalservices.service.impl.ValidationServiceImpl;

/**
 * The Class ExternalServiceBeanConfig.
 * 
 * @author virtusa version 1.0
 */
@Configuration
public class ExternalServiceBeanConfig {

    /**
     * A lm external service.
     *
     * @return the user management
     */
    @Bean(name = "UserManagement")
    public UserManagement aLMExternalService() {
        return new UserManagementImpl();
    }

    /**
     * Bpm external service.
     *
     * @return the BPM interface service
     */
    @Bean(name = "TaskService")
    public TaskService bpmExternalService() {
        return new TaskServiceImpl();
    }

    /**
     * E sb interface service.
     *
     * @return the ESB interface service
     */
    @Bean(name = "ESBInterfaceService")
    public ESBInterfaceService eSBInterfaceService() {
        return new ESBInterfaceServiceImpl();
    }

    /**
     * Orcid interface service.
     *
     * @return the orcid interface service
     */
    @Bean(name = "OricdInterfaceService")
    public OrcidInterfaceService orcidInterfaceService() {
        return new OrcidInterfaceServiceImpl();
    }

    /**
     * Cdm interface service.
     *
     * @return the user profiles
     */
    @Bean(name = "UserProfiles")
    public UserProfiles userProfiles() {

        return new UserProfilesImpl();
    }

    /**
     * Shared service.
     *
     * @return the shared service
     */
    @Bean(name = "SharedService")
    public SharedService sharedService() {
        return new SharedServiceImpl();
    }

    /**
     * Order service.
     *
     * @return the Order service
     */
    @Bean(name = "OrderService")
    public OrderService orderService() {
        return new OrderServiceImpl();
    }

    /**
     * NotificationService.
     *
     * @return the Notification service
     */
    @Bean(name = "NotificationService")
    public NotificationService notificationService() {
        return new NotificationServiceImpl();
    }

    /**
     * Validation service.
     *
     * @return the validation service
     */
    @Bean(name = "ValidationService")
    public ValidationService validationService() {
        return new ValidationServiceImpl();
    }

    /**
     * Permission service.
     *
     * @return the permission service
     */
    @Bean(name = "PermissionService")
    public PermissionService permissionService() {
        return new PermissionServiceImpl();
    }

    /**
     * Invoice service.
     *
     * @return the invoice service
     */
    @Bean(name = "InvoiceService")
    public InvoiceService invoiceService() {

        return new InvoiceServiceImpl();
    }

    /**
     * License interface service.
     *
     * @return the license interface service
     */
    @Bean(name = "LicenseInterfaceService")
    public LicenseInterfaceService licenseInterfaceService() {
        return new LicenseInterfaceServiceImpl();
    }

    /**
     * Alm interface service.
     *
     * @return the ALM interface service
     */
    @Bean(name = "ALMInterfaceService")
    public ALMInterfaceService almInterfaceService() {
        return new ALMInterfaceServiceImpl();
    }

    /**
     * Cdm interface service.
     *
     * @return the CDM interface service
     */
    @Bean(name = "CDMInterfaceService")
    public CDMInterfaceService cdmInterfaceService() {
        return new CDMInterfaceServiceImpl();
    }

    /**
     * Participants interface service.
     *
     * @return the participants interface service
     */
    @Bean(name = "ParticipantsInterfaceService")
    public ParticipantsInterfaceService participantsInterfaceService() {
        return new ParticipantsInterfaceServiceImpl();
    }

}
