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

import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
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
     * User audit.
     *
     * @param auditMap
     *            the audit map
     * @param actionMap
     *            the action map
     * @param user
     *            the user
     * @return true, if successful
     */
    @Override
    public final boolean userAudit(
            final List<HashMap<String, String>> auditMap,
            final HashMap<String, String> actionMap, final Users user) {

        Session session = null;
        Transaction transaction = null;

        Set<AuditDetails> auditDetailsSet = new HashSet<AuditDetails>();
        try {
            session = HibernateConnection.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            Actions actions = new Actions();
            AuditDetails auditDetails = null;
            int auditSize = auditMap.size();
            for (int j = 0; j < auditSize; j++) {
                HashMap<String, String> auditDetailsMap = auditMap.get(j);
                auditDetails = new AuditDetails();
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
                    auditDetails.setCreatedDate(new Date());
                    if (null != user) {
                        auditDetails.setUsersByCreatedBy(user);
                        auditDetails.setUsersByUserId(user);
                    }
                    session.save(auditDetails);
                    session.flush();
                    auditDetailsSet.add(auditDetails);
                }
            }
            if (!StringUtils.isEmpty(actionMap
                    .get(AuthorServicesConstants.AUDIT_ACTION_CD))) {
                actions.setActionCd(actionMap
                        .get(AuthorServicesConstants.AUDIT_ACTION_CD));
            }
            if (!StringUtils.isEmpty(actionMap
                    .get(AuthorServicesConstants.AUDIT_ACTION_NAME))) {
                actions.setActionName(actionMap
                        .get(AuthorServicesConstants.AUDIT_ACTION_NAME));
            }
            if (!StringUtils.isEmpty(actionMap
                    .get(AuthorServicesConstants.AUDIT_DESCRIPTION))) {
                actions.setDescription(actionMap
                        .get(AuthorServicesConstants.AUDIT_DESCRIPTION));
            }
            actions.setCreatedDate(new Date());
            actions.setUpdatedDate(new Date());
            actions.setAuditDetailses(auditDetailsSet);
            session.save(actions);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (null != session) {
                transaction.rollback();
            }
        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
        return true;
    }

    /*
     * public static void main(String[] args) {
     * 
     * AuditResultServiceImpl auditResultServiceImpl = new
     * AuditResultServiceImpl(); HashMap<String, String> auditMap = new
     * HashMap<String, String>();
     * auditMap.put(AuthorServicesConstants.AUDIT_OBJ_NAME, "shiva1");
     * auditMap.put(AuthorServicesConstants.AUDIT_OBJ_ATTR, "shiva1");
     * auditMap.put(AuthorServicesConstants.AUDIT_OLD_VAL, "shiva1");
     * auditMap.put(AuthorServicesConstants.AUDIT_NEW_VAL, "shiva1");
     * 
     * HashMap<String, String> auditMap2 = new HashMap<String, String>();
     * auditMap2.put(AuthorServicesConstants.AUDIT_OBJ_NAME, "Kumar1");
     * auditMap2.put(AuthorServicesConstants.AUDIT_OBJ_ATTR, "Kuma1r");
     * auditMap2.put(AuthorServicesConstants.AUDIT_OLD_VAL, "Kumar1");
     * auditMap2.put(AuthorServicesConstants.AUDIT_NEW_VAL, "Kumar1");
     * 
     * List<HashMap<String, String>> auditDetailsMap = new
     * ArrayList<HashMap<String,String>>(); auditDetailsMap.add(auditMap);
     * auditDetailsMap.add(auditMap2);
     * 
     * HashMap<String, String> actionMap = new HashMap<String, String>();
     * actionMap.put(AuthorServicesConstants.AUDIT_ACTION_CD, "punna1");
     * actionMap.put(AuthorServicesConstants.AUDIT_ACTION_NAME, "punna1");
     * actionMap.put(AuthorServicesConstants.AUDIT_DESCRIPTION, "punna1"); Users
     * users = new Users(1001,"as2.app@dummy.com");
     * 
     * auditResultServiceImpl.userAudit(auditDetailsMap, actionMap, users); }
     */
}
