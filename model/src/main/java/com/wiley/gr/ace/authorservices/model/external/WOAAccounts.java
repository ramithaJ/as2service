package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author virtusa version1.0
 *
 */
public class WOAAccounts {

    /**
     * This field holds the value of woaAccount
     */
    @JsonProperty("WOAAccount")
    private List<WOAAccount> woaAccount = new ArrayList<WOAAccount>();

    /**
     * 
     * @return The WOAAccount
     */
    public List<WOAAccount> getWOAAccount() {
        return woaAccount;
    }

    /**
     * 
     * @param WOAAccount
     *            The WOAAccount
     */
    public void setWOAAccount(final List<WOAAccount> woaAccount) {
        this.woaAccount = woaAccount;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "WOAAccounts [woaAccount=" + woaAccount + "]";
    }

}