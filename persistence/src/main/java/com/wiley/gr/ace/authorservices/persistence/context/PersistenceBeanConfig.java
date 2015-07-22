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
import com.wiley.gr.ace.authorservices.persistence.services.AuthorProfileDao;
import com.wiley.gr.ace.authorservices.persistence.services.DashboardDAO;
import com.wiley.gr.ace.authorservices.persistence.services.LookUpValuesDAO;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.SocietyDao;
import com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserAccountDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserAutocomplete;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserRolesDAO;
import com.wiley.gr.ace.authorservices.persistence.services.impl.ASDataDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.AuthorProfileDaoImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.DashboardDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.LookupValuesDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.RegistrationServiceDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.SocietyDaoImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UpdateUserDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserAccountDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserAutocompleteImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserLoginDaoImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserLoginServiceDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserRolesDAOImpl;

/**
 * The Class PersistenceBeanConfig.
 *
 * @author virtusa version 1.0
 */
@Configuration
public class PersistenceBeanConfig {

    /**
     * This method Creates the HibernateConnection.
     *
     * @return the HibernateConnection
     */
    @Bean(name = "HibernateConnection")
    public HibernateConnection hibernateConnection() {
        return new HibernateConnection();
    }

    /**
     * This method Creates userLoginDao.
     *
     * @return the UserLoginDaoImpl.
     */
    @Bean(name = "AdminLoginDao")
    public UserLoginDao userlogindao() {
        return new UserLoginDaoImpl();
    }

    /**
     * This method Creates registrationServiceDAO.
     *
     * @return the RegistrationServiceDAOImpl.
     */
    @Bean(name = "RegistrationServiceDAO")
    public RegistrationServiceDAO registrationServiceDAO() {
        return new RegistrationServiceDAOImpl();
    }

    /**
     * This method Creates userLoginServiceDAO.
     *
     * @return the UserLoginServiceDAOImpl.
     */
    @Bean(name = "UserLoginServiceDAO")
    public UserLoginServiceDAO userLoginServiceDAO() {
        return new UserLoginServiceDAOImpl();
    }

    /**
     * This method Creates the DashboardDAO.
     *
     * @return the DashboardDAOImpl.
     */
    @Bean(name = "DashboardDAO")
    public DashboardDAO dashboardDAO() {
        return new DashboardDAOImpl();
    }

    /**
     * This method Creates the UpdateUserDAO.
     *
     * @return the UpdateUserDAOImpl.
     */
    @Bean(name = "UpdateUserDAO")
    public UpdateUserDAO updateUserDAO() {
        return new UpdateUserDAOImpl();
    }

    /**
     * This method Creates UserAccountDAO.
     *
     * @return the UserAccountDAOImpl.
     */
    @Bean(name = "UserAccountDAO")
    public UserAccountDAO userAccountDAO() {
        return new UserAccountDAOImpl();
    }

    /**
     * This method Creates ASDataDAO.
     *
     * @return the ASDataDAOImpl
     */
    @Bean(name = "ASDataDAO")
    public ASDataDAO aSDataDAO() {
        return new ASDataDAOImpl();
    }

    /**
     * This method Creates LookUpValuesDAO.
     *
     * @return the LookUpValuesDAOImpl.
     */
    @Bean(name = "LookUpValuesDAO")
    public LookUpValuesDAO lookupValuesDAO() {
        return new LookupValuesDAOImpl();
    }

    /**
     * This method Creates UserRolesDAO.
     *
     * @return the UserRolesDAOImpl.
     */
    @Bean(name = "UserRolesDAO")
    public UserRolesDAO userRolesDAO() {
        return new UserRolesDAOImpl();
    }

    /**
     * This method Creates UserAutocomplete.
     *
     * @return the UserAutocompleteImpl.
     */
    @Bean(name = "UserAutocomplete")
    public UserAutocomplete userAutocomplete() {
        return new UserAutocompleteImpl();
    }

    /**
     * Society dao.
     *
     * @return the society dao
     */
    @Bean(name = "SocietyDao")
    public SocietyDao societyDao() {
        return new SocietyDaoImpl();
    }
    /**
     * AuthorProfile dao.
     *
     * @return the Author profile dao
     */
    @Bean(name = "AuthorProfileDao")
    public AuthorProfileDao authorProfileDao()
    {
        return new AuthorProfileDaoImpl();
    }
   
}
