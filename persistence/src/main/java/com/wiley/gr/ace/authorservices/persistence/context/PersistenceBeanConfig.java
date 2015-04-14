package com.wiley.gr.ace.authorservices.persistence.context;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.services.UserServiceDAO;
import com.wiley.gr.ace.authorservices.persistence.services.UserServiceDAOImpl;
import com.wiley.gr.ace.authorservices.persistence.services.usermanagement.impl.UserLoginDaoImpl;
import com.wiley.gr.ace.authorservices.persistence.services.usermanagement.UserLoginDao;

@Configuration
public class PersistenceBeanConfig {

	@Bean(name = "HibernateConnection")
	public HibernateConnection hibernateConnection() {
		return new HibernateConnection();
	}

	@Bean(name = "UserServiceDAO")
	public UserServiceDAO userServiceDAO() {
		return new UserServiceDAOImpl();
	}
	
	
	@Bean(name = "AdminLoginDao")
	public UserLoginDao userlogindao() {
		return new UserLoginDaoImpl();
	}
	
}
