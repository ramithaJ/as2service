package com.wiley.gr.ace.authorservices.persistence.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.services.DashBoardDao;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserAlertsDao;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.impl.DashBoardDaoImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.RegistrationServiceDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UpdateUserDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserAlertsDaoImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserLoginDaoImpl;
import com.wiley.gr.ace.authorservices.persistence.services.impl.UserLoginServiceDAOImpl;

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

	@Bean(name = "DashBoardDao")
	public DashBoardDao dashBoardDao() {
		return new DashBoardDaoImpl();
	}

	@Bean(name = "UserAlertsDao")
	public UserAlertsDao userAlertsdao() {
		return new UserAlertsDaoImpl();
	}
    @Bean(name="UpdateUserDAO")
    public UpdateUserDAO updateUserDAO() {
    	return new UpdateUserDAOImpl();
    }
}
