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

import com.wiley.gr.ace.authorservices.persistence.entity.LookupValues;

/**
 * The Interface LookUpValuesDAO.
 *
 * @author virtusa version 1.0
 */
public interface LookUpValuesDAO {

    /**
     * This method gets data from LOOKUP_VALUES table with a key.
     * 
     * @param lookupKey
     *            to Retrieve.
     * @return the List of LookupValues.
     */
    List<LookupValues> getLookUpData(String lookupKey);

}
