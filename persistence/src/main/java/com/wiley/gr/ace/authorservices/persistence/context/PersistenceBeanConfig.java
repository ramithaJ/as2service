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
package com.wiley.gr.ace.authorservices.persistence.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;
import com.wiley.gr.ace.authorservices.persistence.services.DashBoardDAO;
import com.wiley.gr.ace.authorservices.persistence.services.LookUpValuesDAO;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserRolesDAO;
import com.wiley.gr.ace.authorservices.persistence.services.impl.ASDataDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.DashBoardDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.LookupValuesDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.RegistrationServiceDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UpdateUserDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserAccountDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserLoginDaoImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserLoginServiceDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserRolesDAOImpl;

@Configuration
public class PersistenceBeanConfig {
    
    @Bean(name = "HibernateConnection")
    public HibernateConnection hibernateConnection() {
        return new HibernateConnection();
    }
    
    @Bean(name = "AdminLoginDao")
    public UserLoginDao userlogindao() {
        return new UserLoginDaoImpl();
    }
    
    @Bean(name = "RegistrationServiceDAO")
    public RegistrationServiceDAO registrationServiceDAO() {
        return new RegistrationServiceDAOImpl();
    }
    
    @Bean(name = "UserLoginServiceDAO")
    public UserLoginServiceDAO userLoginServiceDAO() {
        return new UserLoginServiceDAOImpl();
    }
    
    @Bean(name = "DashBoardDAO")
    public DashBoardDAO dashBoardDAO() {
        return new DashBoardDAOImpl();
    }
    
    @Bean(name = "UpdateUserDAO")
    public UpdateUserDAO updateUserDAO() {
        return new UpdateUserDAOImpl();
    }
    
    @Bean(name = "UserAccountDAO")
    public UserAccountDAO userAccountDAO() {
        return new UserAccountDAOImpl();
    }
    
    @Bean(name = "ASDataDAO")
    public ASDataDAO aSDataDAO() {
        return new ASDataDAOImpl();
    }
    
    @Bean(name = "LookUpValuesDAO")
    public LookUpValuesDAO lookupValuesDAO() {
        return new LookupValuesDAOImpl();
    }
    
    @Bean(name = "UserRolesDAO")
    public UserRolesDAO userRolesDAO() {
        return new UserRolesDAOImpl();
        
    }
}