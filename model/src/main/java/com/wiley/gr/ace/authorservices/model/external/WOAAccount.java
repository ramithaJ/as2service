package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author virtusa version1.0
 *
 */
public class WOAAccount {

    /**
     * This field holds the value of id
     */
    private String id;
    /**
     * This field holds the value of code
     */
    private String code;
    /**
     * This field holds the value of name
     */
    private String name;
    /**
     * This field holds the value of dealType
     */
    private String dealType;
    /**
     * This field holds the value of currency
     */
    private String currency;
    /**
     * This field holds the value of researchFunders
     */
    @JsonProperty("ResearchFunders")
    private ResearchFunders researchFunders;

    /**
     * 
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *            The id
     */
    public void setId(final String id) {
        this.id = id;
    }

    /**
     * 
     * @return The code
     */
    public String getCode() {
        return code;
    }

    /**
     * 
     * @param code
     *            The code
     */
    public void setCode(final String code) {
        this.code = code;
    }

    /**
     * 
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *            The name
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * 
     * @return The dealType
     */
    public String getDealType() {
        return dealType;
    }

    /**
     * 
     * @param dealType
     *            The dealType
     */
    public void setDealType(final String dealType) {
        this.dealType = dealType;
    }

    /**
     * 
     * @return The currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *            The currency
     */
    public void setCurrency(final String currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return The ResearchFunders
     */
    public ResearchFunders getResearchFunders() {
        return researchFunders;
    }

    /**
     * 
     * @param researchFunders
     *            The ResearchFunders
     */
    public void setResearchFunders(final ResearchFunders researchFunders) {
        this.researchFunders = researchFunders;
    }

}