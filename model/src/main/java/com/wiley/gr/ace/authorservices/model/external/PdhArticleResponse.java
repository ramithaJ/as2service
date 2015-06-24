package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.wiley.gr.ace.authorservices.model.Prices;

/**
 * @author virtusa version1.0
 *
 */
public class PdhArticleResponse {

    /**
     * This field holds the value of title
     */
    private String title;

    /**
     * This field holds the value of WOAFunders
     */
    private WOAFunders WOAFunders;

    /**
     * This field holds the value of prices
     */
    private List<Prices> prices;

    /**
     * This field holds the value of articleId
     */
    private String articleId;

    /**
     * @return the title
     */
    public final String getTitle() {
        return title;
    }

    /**
     * @param title
     *            the title to set
     */
    public final void setTitle(final String title) {
        this.title = title;
    }

    /**
     * @return the wOAFunders
     */
    public final WOAFunders getWOAFunders() {
        return WOAFunders;
    }

    /**
     * @param wOAFunders
     *            the wOAFunders to set
     */
    public final void setWOAFunders(final WOAFunders wOAFunders) {
        WOAFunders = wOAFunders;
    }

    /**
     * @return the prices
     */
    public final List<Prices> getPrices() {
        return prices;
    }

    /**
     * @param prices
     *            the prices to set
     */
    public final void setPrices(final List<Prices> prices) {
        this.prices = prices;
    }

    /**
     * @return the articleId
     */
    public final String getArticleId() {
        return articleId;
    }

    /**
     * @param articleId
     *            the articleId to set
     */
    public final void setArticleId(final String articleId) {
        this.articleId = articleId;
    }

}
