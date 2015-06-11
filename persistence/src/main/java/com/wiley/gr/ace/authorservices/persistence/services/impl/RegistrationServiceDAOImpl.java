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

import static com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection.getSessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.persistence.entity.AuthorProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.entity.UserRoles;
import com.wiley.gr.ace.authorservices.persistence.entity.UserRolesId;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;

/**
 * @author virtusa version 1.0
 */
public class RegistrationServiceDAOImpl implements RegistrationServiceDAO {

	@Override
	public boolean searchUserByOrcidId(String orcidId) throws Exception {

		boolean isUserFound = false;
		Session session = getSessionFactory().openSession();
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
		Session session = getSessionFactory().openSession();
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

	@Override
	public void assignRoleToNewRegistration(String emaildId) {

		Session session = null;
		try {
			session = getSessionFactory().openSession();
			Users userEntity = (Users) session.createCriteria(Users.class)
					.add(Restrictions.eq("primaryEmailAddr", emaildId))
					.uniqueResult();

			UserRoles userRolesEntity = new UserRoles();
			UserRolesId userRolesId = new UserRolesId();
			userRolesId.setRoleId(1);
			userRolesId.setUserId(userEntity.getUserId());
			userRolesEntity.setId(userRolesId);

			Transaction txn = session.beginTransaction();
			session.save(userRolesEntity);
			txn.commit();
		} finally {
			if (session != null) {
				session.flush();
				session.close();
			}
		}

	}
}
