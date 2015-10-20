/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

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
    private List<ArticleData> articleData;

    /**
     * @return the articleData
     */
    public final List<ArticleData> getArticleData() {
        return articleData;
    }

    /**
     * @param articleData
     *            the articleData to set
     */
    public final void setArticleData(final List<ArticleData> articleData) {
        this.articleData = articleData;
    }

}
