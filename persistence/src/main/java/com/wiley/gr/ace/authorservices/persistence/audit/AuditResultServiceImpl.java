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

public class AuditResultServiceImpl implements AuditResultService {
    
    @Override
    public boolean userAudit(List<HashMap<String, String>> auditMap,
            HashMap<String, String> actionMap, Users user) {
        
        Session session = null;
        Transaction transaction = null;
        
        Set<AuditDetails> auditDetailsSet = new HashSet<AuditDetails>();
        try {
            session = HibernateConnection.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            Actions actions = new Actions();
            AuditDetails auditDetails = new AuditDetails();
            int auditSize = auditMap.size();
            for (int j = 0; j <= auditSize; j++) {
                HashMap<String, String> auditDetailsMap = auditMap.get(j);
                if (null != auditDetailsMap && auditDetailsMap.size() > 0) {
                    if (!StringUtils.isEmpty(auditDetailsMap.get(AuthorServicesConstants.AUDIT_OBJ_NAME))) {
                        auditDetails
                                .setObjName(auditDetailsMap.get(AuthorServicesConstants.AUDIT_OBJ_NAME));
                    }
                    if (!StringUtils.isEmpty(auditDetailsMap.get(AuthorServicesConstants.AUDIT_OBJ_ATTR))) {
                        auditDetails.setObjAttribute(auditDetailsMap
                                .get(AuthorServicesConstants.AUDIT_OBJ_ATTR));
                    }
                    if (!StringUtils.isEmpty(auditDetailsMap.get(AuthorServicesConstants.AUDIT_OLD_VAL))) {
                        auditDetails.setOldVal(auditDetailsMap.get(AuthorServicesConstants.AUDIT_OLD_VAL));
                    }
                    if (!StringUtils.isEmpty(auditDetailsMap.get(AuthorServicesConstants.AUDIT_NEW_VAL))) {
                        auditDetails.setNewVal(auditDetailsMap.get(AuthorServicesConstants.AUDIT_NEW_VAL));
                    }
                    auditDetails.setCreatedDate(new Date());
                    if (null != user) {
                        auditDetails.setUsersByCreatedBy(user);
                        auditDetails.setUsersByUserId(user);
                    }
                    session.save(auditDetails);
                    auditDetailsSet.add(auditDetails);
                }
            }
            if (!StringUtils.isEmpty(actionMap.get(AuthorServicesConstants.AUDIT_ACTION_CD))) {
                actions.setActionCd(actionMap.get(AuthorServicesConstants.AUDIT_ACTION_CD));
            }
            if (!StringUtils.isEmpty(actionMap.get(AuthorServicesConstants.AUDIT_ACTION_NAME))) {
                actions.setActionName(actionMap.get(AuthorServicesConstants.AUDIT_ACTION_NAME));
            }
            if (!StringUtils.isEmpty(actionMap.get(AuthorServicesConstants.AUDIT_DESCRIPTION))) {
                actions.setDescription(actionMap.get(AuthorServicesConstants.AUDIT_DESCRIPTION));
            }
            actions.setCreatedDate(new Date());
            actions.setUpdatedDate(new Date());
            actions.setAuditDetailses(auditDetailsSet);
            session.save(actions);
            session.flush();
            session.clear();
            
            transaction.commit();
        } catch (Exception e) {
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
    
    public static void main(String[] args) {
        
        AuditResultServiceImpl auditResultServiceImpl = new AuditResultServiceImpl();
        HashMap<String, String> auditMap = new HashMap<String, String>();
        auditMap.put("OBJ_NAME", "objet1");
        auditMap.put("OBJ_ATTR", "objAttr");
        auditMap.put("OLD_VAL", "oldvlaue");
        auditMap.put("NEW_VAL", "newvalue");
        
        List<HashMap<String, String>> auditDetailsMap = new ArrayList<HashMap<String,String>>();
        auditDetailsMap.add(auditMap);
        
        HashMap<String, String> actionMap = new HashMap<String, String>();
        actionMap.put("ACTION_CD", "actionId");
        actionMap.put("ACTION_NAME", "actionName");
        actionMap.put("DESCRIPTION", "discription");
        auditResultServiceImpl.userAudit(auditDetailsMap, actionMap, new Users());
    }
}
