/**
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO;

/**
 * @author vkumark
 *
 */
public class UpdateUserDAOImpl implements UpdateUserDAO {
	
	private static ApplicationContext context = new AnnotationConfigApplicationContext(PersistenceBeanConfig.class);
	private static HibernateConnection con = (HibernateConnection) context.getBean("HibernateConnection");
	
	/* (non-Javadoc)
	 * @see com.wiley.gr.ace.authorservices.persistence.services.UpdateUserDAO#updateUserWithOrcid(com.wiley.gr.ace.authorservices.model.User)
	 */
	@Override
	public User updateUserWithOrcid(User user) throws Exception{
		/**
		 * Create hibernate session 
		 */
		Session session = con.getSessionFactory().openSession();
		try {
			
			if(user!=null){
				/*up.setPrimaryEmailAddr(user.getPrimaryEmailAddr());
				up.setFirstName(user.getFirstName());
				up.setLastName(user.getLastName());*/
				/**
				 * Fetch user profile with user Id
				 */
				Transaction getTxn = session.beginTransaction();
				UserProfile up = (UserProfile)session.load(UserProfile.class, user.getUserId());
				/*System.out.println("Before Update ::: "+up.getUserId());
				System.out.println("Before Update ::: "+up.getPrimaryEmailAddr());
				System.out.println("Before Update ::: "+up.getFirstName());
				System.out.println("Before Update ::: "+up.getLastName());*/
				getTxn.commit();
				
				/**
				 * Update profile with ORCID details
				 */
				up.setPrimaryEmailAddr(user.getPrimaryEmailAddr());
				up.setFirstName(user.getFirstName());
				up.setLastName(user.getLastName());
				Transaction updateTxn = session.beginTransaction();
				session.update(up);
				updateTxn.commit();
				/*System.out.println("After Update ::: "+up.getUserId());
				System.out.println("After Update ::: "+up.getPrimaryEmailAddr());
				System.out.println("After Update ::: "+up.getFirstName());
				System.out.println("After Update ::: "+up.getLastName());*/
				user.setPrimaryEmailAddr(up.getPrimaryEmailAddr());
				user.setFirstName(up.getFirstName());
				user.setLastName(up.getLastName());
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception();
		}
		finally{
			session.close();
		}
		return user;
	}

}
