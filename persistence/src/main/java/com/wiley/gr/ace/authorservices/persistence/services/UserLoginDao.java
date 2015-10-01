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


/**
 * The Interface UserLoginDao.
 *
 * @author virtusa version 1.0
 */
public interface UserLoginDao {

    /**
     * Checks if emailId exists in USER_PROFILE in AS2.0 database.
     * 
     * @param emailId
     *            to validate.
     * @return the boolean value.
     */

    boolean validateEmail(String emailId);

//    /**
//     * This method creates admin user in database.
//     * 
//     * @param users
//     *            to create Admin User.
//     * @param userRolesList
//     *            to create Admin User.
//     */
//
//    void createAdminUser(Users users, List<UserRoles> userRolesList);
//
//    /**
//     * @param emailId
//     *            the request value.
//     * @return users
//     */
//    Users verifyUser(String emailId);

}
