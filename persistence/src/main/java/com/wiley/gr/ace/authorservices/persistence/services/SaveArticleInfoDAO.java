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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.services;

import com.wiley.gr.ace.authorservices.persistence.entity.ArticleConfiguration;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.Products;

/**
 * The Interface SaveArticleInfoDAO.
 *
 * @author virtusa version 1.0
 */
public interface SaveArticleInfoDAO {

    /**
     * Gets the article id.
     *
     * @param dhId
     *            the dh id
     * @return the article id
     */
    Integer getArticleId(String dhId);

    /**
     * Save article info.
     *
     * @param articleConfiguration
     *            the article configuration
     * @return true, if successful
     */
    boolean saveArticleInfo(ArticleConfiguration articleConfiguration);
    
    /**
     * Save product details.
     *
     * @param products the products
     * @return true, if successful
     */
    boolean saveProductDetails(Products products);
    
    void saveProductRelation(ProductRelations productRelations);
}
