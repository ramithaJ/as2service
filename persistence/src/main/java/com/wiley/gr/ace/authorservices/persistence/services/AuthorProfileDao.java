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
 * The Interface AuthorProfileDao.
 * 
 * @author virtusa version 1.0
 */
public interface AuthorProfileDao {

    /**
     * Save profile picture.
     *
     * @param image
     *            the image
     * @param userId
     *            the user id
     */
    void saveProfilePicture(byte[] image, String userId);

//    /**
//     * @param userId
//     * @return
//     */
//    UserProfile getProfilePicture(String userId);

}
