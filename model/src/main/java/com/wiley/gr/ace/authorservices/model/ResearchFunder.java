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
package com.wiley.gr.ace.authorservices.model;

import java.util.Set;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author SarmaKumarap
 */
@JsonInclude(Include.NON_NULL)
public class ResearchFunder {
    
    @NotNull
    @NotBlank
    private Integer researchFunderId;
    
    @NotNull
    @NotBlank
    private String researchFunderName;
    
    private String articleAID;
    
    private String articleName;
    
    private Set<String> grantNumber;
    
    public Integer getResearchFunderId() {
        return researchFunderId;
    }
    
    public void setResearchFunderId(Integer researchFunderId) {
        this.researchFunderId = researchFunderId;
    }
    
    public String getResearchFunderName() {
        return researchFunderName;
    }
    
    public void setResearchFunderName(String researchFunderName) {
        this.researchFunderName = researchFunderName;
    }
    
    public String getArticleAID() {
        return articleAID;
    }
    
    public void setArticleAID(String articleAID) {
        this.articleAID = articleAID;
    }
    
    public String getArticleName() {
        return articleName;
    }
    
    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }
    
    public Set<String> getGrantNumber() {
        return grantNumber;
    }
    
    public void setGrantNumber(Set<String> grantNumber) {
        this.grantNumber = grantNumber;
    }
    
}
