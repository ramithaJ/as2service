/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class ArticleDataDetails.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class ArticleDataDetails {

    /** The article data. */
    private ArrayList<ArticleData> articleData;

    /**
     * Gets the article data.
     *
     * @return the article data
     */
    public final ArrayList<ArticleData> getArticleData() {
        return articleData;
    }

    /**
     * Sets the article data.
     *
     * @param articleData
     *            the new article data
     */
    public final void setArticleData(final ArrayList<ArticleData> articleData) {
        this.articleData = articleData;
    }

}
