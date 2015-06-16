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
package com.wiley.gr.ace.authorservices.model.orcid;

/**
 * The Class OrcidAccessToken.
 *
 * @author virtusa version 1.0
 */
public class OrcidAccessToken {

    /** The name. */
    private String name;

    /** The access_token. */
    private String access_token;

    /** The token_type. */
    private String token_type;

    /** The refresh_token. */
    private String refresh_token;

    /** The expires_in. */
    private int expires_in;

    /** The scope. */
    private String scope;

    /** The orcid. */
    private String orcid;

    /** The state. */
    private String state;

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the access_token.
     *
     * @return the access_token
     */
    public String getAccess_token() {
        return access_token;
    }

    /**
     * Sets the access_token.
     *
     * @param access_token
     *            the access_token to set
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    /**
     * Gets the token_type.
     *
     * @return the token_type
     */
    public String getToken_type() {
        return token_type;
    }

    /**
     * Sets the token_type.
     *
     * @param token_type
     *            the token_type to set
     */
    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    /**
     * Gets the refresh_token.
     *
     * @return the refresh_token
     */
    public String getRefresh_token() {
        return refresh_token;
    }

    /**
     * Sets the refresh_token.
     *
     * @param refresh_token
     *            the refresh_token to set
     */
    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    /**
     * Gets the expires_in.
     *
     * @return the expires_in
     */
    public int getExpires_in() {
        return expires_in;
    }

    /**
     * Sets the expires_in.
     *
     * @param expires_in
     *            the expires_in to set
     */
    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    /**
     * Gets the scope.
     *
     * @return the scope
     */
    public String getScope() {
        return scope;
    }

    /**
     * Sets the scope.
     *
     * @param scope
     *            the scope to set
     */
    public void setScope(String scope) {
        this.scope = scope;
    }

    /**
     * Gets the orcid.
     *
     * @return the orcid
     */
    public String getOrcid() {
        return orcid;
    }

    /**
     * Sets the orcid.
     *
     * @param orcid
     *            the orcid to set
     */
    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state
     *            the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

}
