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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.persistence.entity.InvitationLog;
import com.wiley.gr.ace.authorservices.persistence.entity.InviteResetpwdLog;
import com.wiley.gr.ace.authorservices.persistence.services.InvitationStartDAO;

/**
 * The Class InvitationStartDAOImpl.
 * 
 * @author virtusa version 1.0
 */
public class InvitationStartDAOImpl implements InvitationStartDAO {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(InvitationStartDAOImpl.class);

    /**
     * Update invite reset pwd log.
     *
     * @param guId
     *            the gu id
     * @param email
     *            the email
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean updateInviteResetPWDLog(final String guId,
            final String email) throws Exception {
        LOGGER.info("inside updateInviteResetPWDLog of InvitationStartDAOImpl");
        boolean isUpdated = false;
        Session session = null;
        if (!StringUtils.isEmpty(guId) && !StringUtils.isEmpty(email)) {
            try {
                session = getSessionFactory().openSession();
                String hql = "from InviteResetpwdLog rp whwere rp.emailAddress = :email";
                InviteResetpwdLog inviteResetpwdLog = (InviteResetpwdLog) session
                        .createQuery(hql).setString("email", email)
                        .uniqueResult();
                session.beginTransaction();
                inviteResetpwdLog.setGuid(guId);
                session.getTransaction().commit();
                isUpdated = true;
            } catch (Exception e) {
                if (!StringUtils.isEmpty(session)) {
                    session.getTransaction().rollback();
                }
            } finally {
                if (!StringUtils.isEmpty(session)) {
                    session.flush();
                    session.close();
                }
            }
        }
        return isUpdated;
    }

    /**
     * Creates the invitation log.
     *
     * @param invitationLog
     *            the invitation log
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean createInvitationLog(final InvitationLog invitationLog)
            throws Exception {
        LOGGER.info("inside createInvitationLog of InvitationStartDAOImpl");
        boolean isUpdated = false;
        Session session = null;
        if (!StringUtils.isEmpty(invitationLog)) {
            try {
                session = getSessionFactory().openSession();
                session.beginTransaction();
                session.saveOrUpdate(invitationLog);
                session.getTransaction().commit();
                isUpdated = true;
            } catch (Exception e) {
                if (!StringUtils.isEmpty(session)) {
                    session.getTransaction().rollback();
                }
            } finally {
                if (!StringUtils.isEmpty(session)) {
                    session.flush();
                    session.close();
                }
            }
        }
        return isUpdated;
    }
}
