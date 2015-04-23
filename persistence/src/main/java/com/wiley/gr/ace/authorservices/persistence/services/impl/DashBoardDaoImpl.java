/**
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.Article;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.DashBoardDao;

/**
 * @author yugandhark
 *
 */
public class DashBoardDaoImpl implements DashBoardDao{
	
	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");
	
	
	
	@Override
	public List<Article> getAllAuthorArticles() {
		// TODO Auto-generated method stub
		
		List<Article> list=new LinkedList<Article>();
		Article article=new Article();
		/*
		 Here to implement DB Code
		*/
		article.setArticleId(1234);
		article.setArticleName("Australion Journal");
		article.setSubmittedBy("John");
		article.setSubmittedDate("10-JAN-2015");
		article.setArticleStatus(false);
		article.setStatusUpdatedDate("20-FEB-2015");
		article.setShowLicenceAgreementToSign(false);
		
		Article article1=new Article();
		/*
		 Here to implement DB Code
		*/
		article1.setArticleId(1234);
		article1.setArticleName("UK Journal");
		article1.setSubmittedBy("Smith");
		article1.setSubmittedDate("25-JAN-2015");
		article1.setArticleStatus(true);
		article1.setStatusUpdatedDate("26-FEB-2015");
		article1.setShowLicenceAgreementToSign(true);
		list.add(article);
		list.add(article1);
				
		return list;
	}

	@Override
	public List<UserSecurityDetails> getProfileMeter(int userId) {
		// TODO Auto-generated method stub
		Session session = con.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from UserSecurityDetails where userProfile.userId=:userId";
		List<UserSecurityDetails> secureResultList = session.createQuery(hql)
				.setInteger("userId", userId).list();
		
		session.flush();
		session.close();
		tx.commit();
		return secureResultList;
		
	}

}
	