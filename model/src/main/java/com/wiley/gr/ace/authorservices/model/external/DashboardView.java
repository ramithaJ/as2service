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

import java.util.List;

/**
 * @author yugandhark
 *
 */
public class DashboardView {

    private List<ArticleData> articleData;

    private List<ArticleReadRecord> articleReadRecord;

    private List<CommunicationDetails> communicationDetails;

    private List<ArticleCitationRecord> articleCitationRecord;

    public List<ArticleReadRecord> getArticleReadRecord() {
        return articleReadRecord;
    }

    public void setArticleReadRecord(List<ArticleReadRecord> articleReadRecord) {
        this.articleReadRecord = articleReadRecord;
    }

    public List<CommunicationDetails> getCommunicationDetails() {
        return communicationDetails;
    }

    public void setCommunicationDetails(
            List<CommunicationDetails> communicationDetails) {
        this.communicationDetails = communicationDetails;
    }

    public List<ArticleCitationRecord> getArticleCitationRecord() {
        return articleCitationRecord;
    }

    public void setArticleCitationRecord(
            List<ArticleCitationRecord> articleCitationRecord) {
        this.articleCitationRecord = articleCitationRecord;
    }

    public List<ArticleData> getArticleData() {
        return articleData;
    }

    public void setArticleData(List<ArticleData> articleData) {
        this.articleData = articleData;
    }
}
