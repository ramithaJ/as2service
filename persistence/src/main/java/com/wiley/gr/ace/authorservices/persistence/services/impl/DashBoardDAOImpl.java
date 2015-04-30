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

import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserReferenceData;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.DashBoardDAO;

/**
 * @author yugandhark
 *
 */
public class DashBoardDAOImpl implements DashBoardDAO{
	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);

	private static HibernateConnection con = (HibernateConnection) context
			.getBean("HibernateConnection");
	Session session = con.getSessionFactory().openSession();
	
	
//	@Override
//	public List<Article> getAllAuthorArticles() {
//		// TODO Auto-generated method stub
//		List<Article> list=new LinkedList<Article>();
//		Article article=new Article();
//		/*
//		 Here to implement DB Code
//		*/
//		article.setArticleId(1234);
//		article.setArticleName("Australion Journal");
//		article.setSubmittedBy("John");
//		article.setSubmittedDate("10-JAN-2015");
//		article.setArticleStatus(false);
//		article.setStatusUpdatedDate("20-FEB-2015");
//		article.setShowLicenceAgreementToSign(false);
//		
//		Article article1=new Article();
//		/*
//		 Here to implement DB Code
//		*/
//		article1.setArticleId(1234);
//		article1.setArticleName("UK Journal");
//		article1.setSubmittedBy("Smith");
//		article1.setSubmittedDate("25-JAN-2015");
//		article1.setArticleStatus(true);
//		article1.setStatusUpdatedDate("26-FEB-2015");
//		article1.setShowLicenceAgreementToSign(true);
//		list.add(article);
//		list.add(article1);
//		return list;
//	}

	@Override
	public List<LinkedList> getProfileMeter(int userId) {
		// TODO Auto-generated method stub
		Session session = con.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		List profileMeterList=new LinkedList();
		String secureDetailsHql = "from UserSecurityDetails where userProfile.userId=:userId";
		List<UserSecurityDetails> secureResultList = session.createQuery(secureDetailsHql)
				.setInteger("userId", userId).list();
		
		String secondaryEmailHql=" select upf.secondaryEmailAddr from UserProfile upf where upf.userId=:userId";
		List<UserProfile> userProfileList = session.createQuery(secondaryEmailHql)
				.setInteger("userId", userId).list();
	
		String orcidIdHql="select orcid from UserReferenceData where userProfile.userId=:userId";
		List<UserReferenceData> userOrcIdList = session.createQuery(orcidIdHql)
				.setInteger("userId", userId).list();
		profileMeterList.add(secureResultList);
		profileMeterList.add(userProfileList);
		profileMeterList.add(userOrcIdList);
		session.flush();
		session.close();
		tx.commit();
		return profileMeterList;
		
	}

}
	