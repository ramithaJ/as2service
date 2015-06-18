/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class AssociationConfirmation.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class AssociationConfirmation {

    /** The article auth id. */
    private Integer articleAuthId;

    /** The user id. */
    private Integer userId;

    /**
     * Gets the article auth id.
     *
     * @return the article auth id
     */
    public final Integer getArticleAuthId() {
        return articleAuthId;
    }

    /**
     * Sets the article auth id.
     *
     * @param articleAuthId
     *            the new article auth id
     */
    public final void setArticleAuthId(final Integer articleAuthId) {
        this.articleAuthId = articleAuthId;
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public final Integer getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId
     *            the new user id
     */
    public final void setUserId(final Integer userId) {
        this.userId = userId;
    }

}
