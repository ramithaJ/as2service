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

package com.wiley.gr.ace.authorservices.external.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;

/**
 * @author virtusa version 1.0
 *
 */
public class ASDateFormatUtil {

    /**
     * @param longDate
     * @return
     */
    public static String convertDate(long longDate) {
        Date date = new Date(longDate);
        SimpleDateFormat dateFormatter = new SimpleDateFormat(
                AuthorServicesConstants.DATE_FORMAT);
        String stringDate = dateFormatter.format(date);
        return stringDate;
    }

}
