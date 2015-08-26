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

public class ASDateFormatUtil {
    
    public static String convertDate(long longDate)
    {
       Date date=new Date(longDate);
       System.err.println("date in dat6e formatter" +date);
        SimpleDateFormat dateFormatter = new SimpleDateFormat( "yyyy-MM-dd'T'HH:mm:ssXXX");
        String stringDate = dateFormatter.format(date);
        System.err.println("before returning from date formatter"+stringDate);
        return stringDate;
    }

}
