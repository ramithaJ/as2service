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
package com.wiley.gr.ace.authorservices.persistence.audit;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.model.AuditInformation;
import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.Actions;
import com.wiley.gr.ace.authorservices.persistence.entity.AuditDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;

/**
 * The Class AuditResultServiceImpl.
 * 
 * @author virtusa version 1.0
 */
public class AuditResultServiceImpl implements AuditResultService {

    /**
     * Method to Audit user Operations.
     *
     * @param auditMap
     *            the audit map
     * @param user
     *            the user
     * @return true, if successful
     */
    @Override
    public final boolean userAudit(
            final List<HashMap<String, String>> auditMap, final Users user) {

        Session session = null;
        Transaction transaction = null;
        try {
            // Hibernate Connection
            session = HibernateConnection.getSessionFactory().openSession();
            // begin Transaction
            transaction = session.beginTransaction();
            new Actions();
            // creating AuditDetails object
            AuditDetails auditDetails = null;
            int auditSize = auditMap.size();
            for (int j = 0; j < auditSize; j++) {
                HashMap<String, String> auditDetailsMap = auditMap.get(j);
                auditDetails = new AuditDetails();
                // auditDetailsMap null check
                if (null != auditDetailsMap && auditDetailsMap.size() > 0) {
                    if (!StringUtils.isEmpty(auditDetailsMap
                            .get(AuthorServicesConstants.AUDIT_OBJ_NAME))) {
                        auditDetails.setObjName(auditDetailsMap
                                .get(AuthorServicesConstants.AUDIT_OBJ_NAME));
                    }
                    if (!StringUtils.isEmpty(auditDetailsMap
                            .get(AuthorServicesConstants.AUDIT_OBJ_ATTR))) {
                        auditDetails.setObjAttribute(auditDetailsMap
                                .get(AuthorServicesConstants.AUDIT_OBJ_ATTR));
                    }
                    if (!StringUtils.isEmpty(auditDetailsMap
                            .get(AuthorServicesConstants.AUDIT_OLD_VAL))) {
                        auditDetails.setOldVal(auditDetailsMap
                                .get(AuthorServicesConstants.AUDIT_OLD_VAL));
                    }
                    if (!StringUtils.isEmpty(auditDetailsMap
                            .get(AuthorServicesConstants.AUDIT_NEW_VAL))) {
                        auditDetails.setNewVal(auditDetailsMap
                                .get(AuthorServicesConstants.AUDIT_NEW_VAL));
                    }
                    if (!StringUtils.isEmpty(auditDetailsMap
                            .get(AuthorServicesConstants.AUDIT_ACTION_CD))) {
                        auditDetails.setActions(new Actions(auditDetailsMap
                                .get(AuthorServicesConstants.AUDIT_ACTION_CD)));
                    }
                    auditDetails.setCreatedDate(new Date());

                    if (null != user) {
                        auditDetails.setUsers(user);

                    }
                    // saving the auditDetails object.
                    session.save(auditDetails);
                }
            }
            transaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
            if (StringUtils.isEmpty(session)) {
                // rollback the trasaction
                transaction.rollback();
            }
        } finally {
            if (StringUtils.isEmpty(session)) {
                session.flush();
                session.close();
            }
        }
        return true;
    }

    /**
     * Audit user actions.
     *
     * @param auditInformation
     *            the audit information
     */
    public static final void auditUserActions(
            final AuditInformation auditInformation) {

        List<HashMap<String, String>> auditMap = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("OBJ_NAME", auditInformation.getTableName()); // Table Name
        hashMap.put("OBJ_ATTR", auditInformation.getColumnName()); // Column
                                                                   // Name
        hashMap.put("OLD_VAL", auditInformation.getOldValue());
        hashMap.put("NEW_VAL", auditInformation.getNewValue());
        hashMap.put("ACTION_CD", auditInformation.getActionID());
        auditMap.add(hashMap);

        Users users = new Users();
        users.setUserId(new Long(auditInformation.getUserId()));

        AuditResultServiceImpl auditResultServiceImpl = new AuditResultServiceImpl();
        auditResultServiceImpl.userAudit(auditMap, users);
    }

}
