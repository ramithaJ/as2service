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

import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserRoles;
import com.wiley.gr.ace.authorservices.persistence.entity.UserRolesId;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.persistence.services.RegistrationServiceDAO;

/**
 * The Class RegistrationServiceDAOImpl.
 *
 * @author virtusa version 1.0
 */
public class RegistrationServiceDAOImpl implements RegistrationServiceDAO {

    /**
     * This method search the User by using orcidId.
     * 
     * @param orcidId
     *            to Retrieve.
     * @return the boolean value.
     * @throws Exception
     *             if unable to search.
     */
    @Override
    public final boolean searchUserByOrcidId(final String orcidId)
            throws Exception {

        boolean isUserFound = false;
        Session session = getSessionFactory().openSession();
        String searchOrcidHql = "from AuthorProfile af where af.orcidId=:orcidId";
        List<UserProfile> authorProfilesList = session
                .createQuery(searchOrcidHql).setString("orcidId", "orcidId")
                .list();
        if (!StringUtils.isEmpty(authorProfilesList)) {
            isUserFound = true;
        }

        return isUserFound;
    }

    /**
     * This method gets the Invitation Records.
     * 
     * @param guid
     *            to Retrieve.
     * @return the InviteResetpwdLog.
     */
    @Override
    public final InviteResetpwdLog getInvitationRecords(final String guid) {
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

    /**
     * This method Assigns the Role to New Registration.
     * 
     * @param emaildId
     *            to assign.
     */
    @Override
    public final void assignRoleToNewRegistration(final String emaildId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Transaction txn = session.beginTransaction();
            Users userEntity = (Users) session.createCriteria(Users.class)
                    .add(Restrictions.eq("primaryEmailAddr", emaildId))
                    .uniqueResult();
            UserRoles userRolesEntity = new UserRoles();
            UserRolesId userRolesId = new UserRolesId();
            userRolesId.setRoleId(1);
            userRolesId.setUserId(userEntity.getUserId());
            userRolesEntity.setId(userRolesId);

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
