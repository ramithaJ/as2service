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

import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.persistence.entity.Societies;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSocietyDetails;

/**
 * The Interface SocietyDao.
 * 
 * @author virtusa version 1.0
 */
public interface SocietyDao {

    /**
     * Gets the society.
     *
     * @return the society
     */
    List<Societies> getSociety();

    List<UserSocietyDetails> getSocietyDetails(String participantId);

    boolean updateSociety(String userId, Society society);

}
