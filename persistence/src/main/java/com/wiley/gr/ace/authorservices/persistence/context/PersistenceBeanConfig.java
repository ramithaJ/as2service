package com.wiley.gr.ace.authorservices.persistence.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginDao;
import com.wiley.gr.ace.authorservices.persistence.services.UserLoginServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.impl.RegistrationServiceDAOImpl;
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

	@Bean(name = "UserLoginServiceDAO")
	public UserLoginServiceDAO userLoginServiceDAO() {
		return new UserLoginServiceDAOImpl();
	}

	@Bean(name = "RegistrationServiceDAO")
	public RegistrationServiceDAO registrationServiceDAO() {
		return new RegistrationServiceDAOImpl();
	}

}
