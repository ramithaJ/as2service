package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author virtusa version1.0
 *
 */
public class WOAFunder {

    /**
     * This field holds the value of id
     */
    private String id;
    /**
     * This field holds the value of name
     */
    private String name;
    /**
     * This field holds the value of woaAccounts
     */
    @JsonProperty("WOAAccounts")
    private WOAAccounts woaAccounts;

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
     * @return The WOAAccounts
     */
    public WOAAccounts getWOAAccounts() {
        return woaAccounts;
    }

    /**
     * 
     * @param WOAAccounts
     *            The WOAAccounts
     */
    public void setWOAAccounts(final WOAAccounts woaAccounts) {
        this.woaAccounts = woaAccounts;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "WOAFunder [id=" + id + ", name=" + name + ", woaAccounts="
                + woaAccounts + "]";
    }

}