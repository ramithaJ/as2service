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
import org.springframework.beans.factory.annotation.Autowired;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.DashBoard;
import com.wiley.gr.ace.authorservices.persistence.entity.ResearchFunders;
import com.wiley.gr.ace.authorservices.persistence.entity.SocietyDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.DashBoardDAO;


/**
 * @author yugandhark
 *
 */
public class DashBoardDAOImpl implements DashBoardDAO {

	// @Override
	// public List<Article> getAllAuthorArticles() {
	// // TODO Auto-generated method stub
	// List<Article> list=new LinkedList<Article>();
	// Article article=new Article();
	// /*
	// Here to implement DB Code
	// */
	// article.setArticleId(1234);
	// article.setArticleName("Australion Journal");
	// article.setSubmittedBy("John");
	// article.setSubmittedDate("10-JAN-2015");
	// article.setArticleStatus(false);
	// article.setStatusUpdatedDate("20-FEB-2015");
	// article.setShowLicenceAgreementToSign(false);
	//
	// Article article1=new Article();
	// /*
	// Here to implement DB Code
	// */
	// article1.setArticleId(1234);
	// article1.setArticleName("UK Journal");
	// article1.setSubmittedBy("Smith");
	// article1.setSubmittedDate("25-JAN-2015");
	// article1.setArticleStatus(true);
	// article1.setStatusUpdatedDate("26-FEB-2015");
	// article1.setShowLicenceAgreementToSign(true);
	// list.add(article);
	// list.add(article1);
	// return list;
	// }

	@Autowired(required = true)
	HibernateConnection con;
//	Session session = con.getSessionFactory().openSession();
     DashBoard dashBoard=new DashBoard();
     
	public DashBoard getProfileMeter(int userId) {
		
		Session session = HibernateConnection.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		String secureDetailsHql = "from UserSecurityDetails where authorProfile.userId=:userId";
		List<UserSecurityDetails> secureResultList = session.createQuery(secureDetailsHql).setInteger("userId", userId).list();
		dashBoard.setUserSecurityDetails(secureResultList);
		
//		String profileHql = " select apf.secondaryEmailAddr,apf.orcidId,apf.isAccountVerified from AuthorProfile apf where apf.userId=:userId";
//		List<AuthorProfile> userProfileList= session
//				.createQuery(profileHql).setInteger("userId", userId)
//				.list();
		
		List<AuthorProfile> authorProfileList=new LinkedList<AuthorProfile>();
		authorProfileList.add(null);
		authorProfileList.add(null);
		authorProfileList.add(null);
		dashBoard.setAuthorProfileList(authorProfileList);
		
		List<LinkedList> affiliationsList=new LinkedList<LinkedList>();
		affiliationsList.add(null);
		dashBoard.setAffiliation(affiliationsList);
		List<LinkedList> areaOfExpertiseList=new LinkedList<LinkedList>();
		areaOfExpertiseList.add(null);
		dashBoard.setAreaOfExpertise(areaOfExpertiseList);
		
		List<SocietyDetails> societyDetailsList=new LinkedList<SocietyDetails>();
		societyDetailsList.add(null);
		dashBoard.setSocietyDetails(societyDetailsList);
		
		List<ResearchFunders> researchFundersList=new LinkedList<ResearchFunders>();
		researchFundersList.add(null);
		dashBoard.setResearchFunder(researchFundersList);
		
//		String SocietyDetailsHql = "select sd.societyId,ap.userId from SocietyDetails sd ,AuthorProfile ap where ap.userId=:userId";
//		List<SocietyDetails> societyDetailsList = session.createQuery(SocietyDetailsHql)
//				.setInteger("userId", userId).list();
//        dashBoard.setSociety(societyDetailsList);
        
//		String affiliationHql = " from Affiliations where userId=:userId";
//List<Affiliation> affiliationList = session.createQuery(affiliationHql)
//	.setInteger("userId", userId).list();
        
//		String areasOfExpertiseHql = " from AreasOfExpertise where userId=:userId";
//List<Affiliation> affiliationList = session.createQuery(areasOfExpertiseHql)
//	.setInteger("userId", userId).list();
        
//		String researchFundersHql = "select ap.userId,rf.rfunderId from ResearchFunders rf,AuthorProfile ap where ap.userId=:userId";
//		List<ResearchFunders> researchFundersList = session.createQuery(researchFundersHql)
//				.setInteger("userId", userId).list();
//		dashBoard.setResearchFunder(researchFundersList);
        
		session.flush();
 		session.close();
 		tx.commit();
		return dashBoard;
	}
}
