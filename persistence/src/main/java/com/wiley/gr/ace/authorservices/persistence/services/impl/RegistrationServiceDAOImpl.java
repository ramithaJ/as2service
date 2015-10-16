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

import org.hibernate.Session;

import com.wiley.gr.ace.authorservices.persistence.entity.RegistrationDetails;
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
        // Session session = getSessionFactory().openSession();
        // String searchOrcidHql =
        // "from AuthorProfile af where af.orcidId=:orcidId";
        // List<UserProfile> authorProfilesList = session
        // .createQuery(searchOrcidHql).setString("orcidId", "orcidId")
        // .list();
        // if (!StringUtils.isEmpty(authorProfilesList)) {
        // isUserFound = true;
        // }

        return isUserFound;
    }

    /**
     * This method gets the Invitation Records.
     * 
     * @param guid
     *            to Retrieve.
     * @return the InviteResetpwdLog.
     */
    /*
     * @Override public final InviteResetpwdLog getInvitationRecords(final
     * String guid) { InviteResetpwdLog inviteRecord = new InviteResetpwdLog();
     * Session session = getSessionFactory().openSession(); String
     * searchInviteHql = "from InviteResetpwdLog ir where ir.guid=:guid";
     * List<InviteResetpwdLog> inviteRecordList = session
     * .createQuery(searchInviteHql).setString("guid", guid).list(); if
     * (!StringUtils.isEmpty(inviteRecordList)) { inviteRecord =
     * inviteRecordList.get(0); } else { inviteRecord = null; }
     * 
     * return inviteRecord; }
     */

    @Override
    public void createRegistrationRecord(
            final RegistrationDetails registrationDetails) {
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(registrationDetails);
            session.getTransaction().commit();
        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
    }

    @Override
    public RegistrationDetails getRegistrationRecord(final String almUserId) {
        return null;
        /*
         * Session session = null; RegistrationDetails registrationDetails =
         * null; try { session = getSessionFactory().openSession();
         * 
         * Criteria criteria = session.createCriteria(InviteResetpwdLog.class);
         * criteria.add(Restrictions.eq("almUserId", almUserId));
         * registrationDetails = (RegistrationDetails) criteria.uniqueResult();
         * } finally { if (null != session) { session.flush(); session.close();
         * } } return registrationDetails;
         */
    }

    @Override
    public void deleteRegistrationDetails(final String almUserId) {

        Session session = null;
        try {
            RegistrationDetails registrationDetails = new RegistrationDetails();
            session = getSessionFactory().openSession();
            session.beginTransaction();
            registrationDetails.setAlmUserId(almUserId);
            session.delete(registrationDetails);
            session.getTransaction().commit();

        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }

    }
}
