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
 ******************************************************************************/
package com.wiley.gr.ace.authorservices.services.service;

import com.wiley.gr.ace.authorservices.model.CollectArticle;

/**
 * The Interface CollectArticleService.
 */
public interface CollectArticleService {

    /**
     * Gets the collect article obj.
     *
     * @return the collect article obj
     * @throws Exception
     *             the exception
     */
    CollectArticle getCollectArticleObj() throws Exception;

}
