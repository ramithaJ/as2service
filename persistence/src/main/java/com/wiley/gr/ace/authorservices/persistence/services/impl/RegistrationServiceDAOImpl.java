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
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;

public class RegistrationServiceDAOImpl implements RegistrationServiceDAO {

	@Autowired(required = true)
	HibernateConnection con;

	@Override
	public List<AuthorProfile> getUserFromFirstNameLastName(String firstName,
			String lastName) {
		Session session = con.getSessionFactory().openSession();
		String hql = "from AuthorProfile uf where uf.firstName = :firstName AND uf.lastName = :lastName";
		List<AuthorProfile> userProfileList = session.createQuery(hql)
				.setString("firstName", firstName)
				.setString("lastName", lastName).list();

		return userProfileList;
	}

	@Override
	public boolean searchUserByOrcidId(String orcidId) throws Exception {

		boolean isUserFound = false;
		Session session = con.getSessionFactory().openSession();
		String searchOrcidHql = "from AuthorProfile af where af.orcidId=:orcidId";
		List<AuthorProfile> authorProfilesList = session
				.createQuery(searchOrcidHql).setString("orcidId", "orcidId")
				.list();
		if (!StringUtils.isEmpty(authorProfilesList)) {
			isUserFound = true;
		}

		return isUserFound;
	}

	@Override
	public InviteResetpwdLog getInvitationRecords(String guid) {
		InviteResetpwdLog inviteRecord = new InviteResetpwdLog();
		Session session = con.getSessionFactory().openSession();
		String searchInviteHql = "from InviteResetpwdLog ir where ir.guid=:guid";
		List<InviteResetpwdLog> inviteRecordList = session
				.createQuery(searchInviteHql).setString("guid", guid).list();
		if (!StringUtils.isEmpty(inviteRecordList)) {
			inviteRecord = inviteRecordList.get(0);
		} else {
			inviteRecord = null;
		}

		return inviteRecord;
	}

}
