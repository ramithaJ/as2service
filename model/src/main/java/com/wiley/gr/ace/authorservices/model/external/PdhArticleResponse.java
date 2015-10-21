package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.wiley.gr.ace.authorservices.model.Prices;

/**
 * The Class PdhArticleResponse.
 *
 * @author virtusa version1.0
 */
public class PdhArticleResponse {

    /** This field holds the value of title. */
    private String title;

    /** This field holds the value of WOAFunders. */
    @JsonProperty("WOAFunders")
    private WOAFunders woaFunders;

    /** This field holds the value of prices. */
    private List<Prices> prices;

    /** This field holds the value of articleId. */
    private String articleId;

    /** The is article invited. */
    private String isArticleInvited;

    /**
     * Gets the title.
     *
     * @return the title
     */
    public final String getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title
     *            the title to set
     */
    public final void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return the woaFunders
     */
    public WOAFunders getWoaFunders() {
        return woaFunders;
    }

    /**
     * @param woaFunders
     *            the woaFunders to set
     */
    public void setWoaFunders(WOAFunders woaFunders) {
        this.woaFunders = woaFunders;
    }

    /**
     * Gets the prices.
     *
     * @return the prices
     */
    public final List<Prices> getPrices() {
        return prices;
    }

    /**
     * Sets the prices.
     *
     * @param prices
     *            the prices to set
     */
    public final void setPrices(final List<Prices> prices) {
        this.prices = prices;
    }

    /**
     * Gets the article id.
     *
     * @return the articleId
     */
    public final String getArticleId() {
        return articleId;
    }

    /**
     * Sets the article id.
     *
     * @param articleId
     *            the articleId to set
     */
    public final void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

    /**
     * Gets the checks if is article invited.
     *
     * @return the checks if is article invited
     */
    public final String getIsArticleInvited() {
        return isArticleInvited;
    }

    /**
     * Sets the checks if is article invited.
     *
     * @param isArticleInvited
     *            the new checks if is article invited
     */
    public final void setIsArticleInvited(String isArticleInvited) {
        this.isArticleInvited = isArticleInvited;
    }

}
