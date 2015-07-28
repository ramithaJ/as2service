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

import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.RolesService;
import com.wiley.gr.ace.authorservices.model.Role;
import com.wiley.gr.ace.authorservices.model.external.RolesData;

/**
 * The Class RolesServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class RolesServiceImpl implements RolesService {
    
    @Value("${roles.url}")
    private String rolesUrl;

	/* (non-Javadoc)
	 * @see com.wiley.gr.ace.authorservices.externalservices.service.RolesService#getRoles()
	 */
	@Override
	public List<RolesData> getRoles() {
		
	    List<RolesData> rolesList = (List<RolesData>)RestServiceInvokerUtil.getServiceData(rolesUrl, List.class);
	    
	    System.out.println("Size of rolesList:::"+rolesList.size());
		
		return null;
	}

    /* (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.externalservices.service.RolesService#getAdminRoles()
     */
    @Override
    public List<Role> getAdminRoles() {
        
        List<RolesData> rolesList = (List<RolesData>)RestServiceInvokerUtil.getServiceData(rolesUrl, List.class);
        List<Role> adminRoles = new ArrayList<Role>();
        
        for (RolesData roleData : rolesList) {
            
            if(roleData.getRoleType().equalsIgnoreCase(AuthorServicesConstants.ROLE_TYPE_INTERNAL)) {
                
                Role adminRole = new Role();
                adminRole.setRoleId(roleData.getRoleId());
                adminRole.setRoleName(roleData.getRoleName());
                adminRoles.add(adminRole);
            }
            
        }
        
        return adminRoles;
    }
    
    

}
