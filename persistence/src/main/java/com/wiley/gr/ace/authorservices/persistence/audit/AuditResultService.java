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

import java.util.HashMap;
import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.Users;

/**
 * The Interface AuditResultService.
 */
public interface AuditResultService {

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
    boolean userAudit(List<HashMap<String, String>> auditMap,
            HashMap<String, String> actionMap, Users user);
}
