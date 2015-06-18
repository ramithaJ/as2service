/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ArticleRecord.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ArticleRecord {

    /** The article citation record. */
    private List<ArticleCitationRecord> articleCitationRecord;

    /** The article read record. */
    private List<ArticleReadRecord> articleReadRecord;

    /**
     * Gets the article citation record.
     *
     * @return the article citation record
     */
    public final List<ArticleCitationRecord> getArticleCitationRecord() {
        return articleCitationRecord;
    }

    /**
     * Sets the article citation record.
     *
     * @param articleCitationRecord
     *            the new article citation record
     */
    public final void setArticleCitationRecord(
            final List<ArticleCitationRecord> articleCitationRecord) {
        this.articleCitationRecord = articleCitationRecord;
    }

    /**
     * Gets the article read record.
     *
     * @return the article read record
     */
    public final List<ArticleReadRecord> getArticleReadRecord() {
        return articleReadRecord;
    }

    /**
     * Sets the article read record.
     *
     * @param articleReadRecord
     *            the new article read record
     */
    public final void setArticleReadRecord(
            final List<ArticleReadRecord> articleReadRecord) {
        this.articleReadRecord = articleReadRecord;
    }

}
