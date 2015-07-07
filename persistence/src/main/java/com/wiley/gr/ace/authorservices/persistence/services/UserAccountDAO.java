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
package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.SecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;

/**
 * @author virtusa version 1.0
 */
public interface UserAccountDAO {

    /**
     * This method gets the email Details from AS 2.0 DB.
     * 
     * @param userId
     *            to Retrieve.
     * @return the AuthorProfile.
     */
    UserProfile getEmailDetails(String userId);

    /**
     * This method update the Email Details to AS 2.0 DB.
     * 
     * @param userId
     *            to update.
     * @param primaryEmail
     *            to be update.
     * @param secondaryEmail
     *            to be update.
     * @return the boolean value.
     */
    boolean updateEmailDetails(String userId, String primaryEmail,
            String secondaryEmail);

    /**
     * This method update the SecurityDetails to AS 2.0 DB.
     * 
     * @param userId
     *            to update.
     * @param securityDetails
     *            to be update.
     * @return the boolean value.
     */
    boolean updateSecurityDetails(Integer userId,
            List<SecurityDetails> securityDetails);

}
