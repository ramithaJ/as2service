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
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class CommunicationDetails.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class CommunicationDetails {

    private Integer userId;
    private Integer inviationId;
    private String emailId;
    private Integer articleId;
    private String sentDate;
    private Integer sentBy;
    public final Integer getUserId() {
        return userId;
    }
    public final void setUserId(Integer userId) {
        this.userId = userId;
    }
    public final Integer getInviationId() {
        return inviationId;
    }
    public final void setInviationId(Integer inviationId) {
        this.inviationId = inviationId;
    }
    public final String getEmailId() {
        return emailId;
    }
    public final void setEmailId(String emailId) {
        this.emailId = emailId;
    }
    public final Integer getArticleId() {
        return articleId;
    }
    public final void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
    public final String getSentDate() {
        return sentDate;
    }
    public final void setSentDate(String sentDate) {
        this.sentDate = sentDate;
    }
    public final Integer getSentBy() {
        return sentBy;
    }
    public final void setSentBy(Integer sentBy) {
        this.sentBy = sentBy;
    }
    

}
