package com.wiley.gr.ace.authorservices.persistence.services.impl;

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

import com.wiley.gr.ace.authorservices.persistence.services.InvitationCeaseDAO;

/**
 * The Class InviataionCesaseDAOImpl.
 * 
 * @author virtusa version 1.0
 */
public class InviataionCeaseDAOImpl implements InvitationCeaseDAO {

//    /** The Constant LOGGER. */
//    private static final Logger LOGGER = LoggerFactory
//            .getLogger(InviataionCeaseDAOImpl.class);

    /**
     * Update invite reset pwd log.
     *
     * @param email
     *            the email
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean updateInviteResetPWDLog(final String email)
            throws Exception {
        return false;
        /*
         * LOGGER.info("inside updateInviteResetPWDLog of InviataionCesaseDAOImpl"
         * ); boolean isUpdated = false; Session session = null; if
         * (!StringUtils.isEmpty(email)) { try { session =
         * getSessionFactory().openSession(); String hql =
         * "from InviteResetpwdLog ip where ip.emailAddress = :email";
         * InviteResetpwdLog inviteResetpwdLog = (InviteResetpwdLog) session
         * .createQuery(hql).setString("email", email) .uniqueResult();
         * session.beginTransaction(); inviteResetpwdLog.setStatus("Closed");
         * session.getTransaction().commit(); isUpdated = true; } catch
         * (Exception e) { if (!StringUtils.isEmpty(session)) {
         * session.getTransaction().rollback(); } } finally { if
         * (!StringUtils.isEmpty(session)) { session.flush(); session.close(); }
         * } } return isUpdated;
         */
    }

}
