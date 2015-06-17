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
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the access_token
     */
    public final String getAccess_token() {
        return access_token;
    }

    /**
     * @param access_token
     *            the access_token to set
     */
    public final void setAccess_token(final String access_token) {
        this.access_token = access_token;
    }

    /**
     * @return the token_type
     */
    public final String getToken_type() {
        return token_type;
    }

    /**
     * @param token_type
     *            the token_type to set
     */
    public final void setToken_type(final String token_type) {
        this.token_type = token_type;
    }

    /**
     * @return the refresh_token
     */
    public final String getRefresh_token() {
        return refresh_token;
    }

    /**
     * @param refresh_token
     *            the refresh_token to set
     */
    public final void setRefresh_token(final String refresh_token) {
        this.refresh_token = refresh_token;
    }

    /**
     * @return the expires_in
     */
    public final int getExpires_in() {
        return expires_in;
    }

    /**
     * @param expires_in
     *            the expires_in to set
     */
    public final void setExpires_in(final int expires_in) {
        this.expires_in = expires_in;
    }

    /**
     * @return the scope
     */
    public final String getScope() {
        return scope;
    }

    /**
     * @param scope
     *            the scope to set
     */
    public final void setScope(final String scope) {
        this.scope = scope;
    }

    /**
     * @return the orcid
     */
    public final String getOrcid() {
        return orcid;
    }

    /**
     * @param orcid
     *            the orcid to set
     */
    public final void setOrcid(final String orcid) {
        this.orcid = orcid;
    }

    /**
     * @return the state
     */
    public final String getState() {
        return state;
    }

    /**
     * @param state
     *            the state to set
     */
    public final void setState(final String state) {
        this.state = state;
    }

}
