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

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class OrcidAccessToken.
 *
 * @author virtusa version 1.0
 */
public class OrcidAccessToken {

    /** The name. */
    private String name;

    /** The access token. */
    @JsonProperty("access_token")
    private String accessToken;

    /** The token type. */
    @JsonProperty("token_type")
    private String tokenType;

    /** The refresh token. */
    @JsonProperty("refresh_token")
    private String refreshToken;

    /** The expires in. */
    @JsonProperty("expires_in")
    private Integer expiresIn;

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
    public final String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     *            the name to set
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the access token.
     *
     * @return the accessToken
     */
    public final String getAccessToken() {
        return accessToken;
    }

    /**
     * Sets the access token.
     *
     * @param accessToken
     *            the new access token
     */
    public final void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * Gets the token type.
     *
     * @return the token type
     */
    public final String getTokenType() {
        return tokenType;
    }

    /**
     * Sets the token type.
     *
     * @param tokenType
     *            the new token type
     */
    public final void setTokenType(final String tokenType) {
        this.tokenType = tokenType;
    }

    /**
     * Gets the refresh token.
     *
     * @return the refresh token
     */
    public final String getRefreshToken() {
        return refreshToken;
    }

    /**
     * Sets the refresh token.
     *
     * @param refreshToken
     *            the new refresh token
     */
    public final void setRefreshToken(final String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * Gets the expires in.
     *
     * @return the expires in
     */
    public final Integer getExpiresIn() {
        return expiresIn;
    }

    /**
     * Sets the expires in.
     *
     * @param expiresIn
     *            the new expires in
     */
    public final void setExpiresIn(final Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    /**
     * Gets the scope.
     *
     * @return the scope
     */
    public final String getScope() {
        return scope;
    }

    /**
     * Sets the scope.
     *
     * @param scope
     *            the scope to set
     */
    public final void setScope(final String scope) {
        this.scope = scope;
    }

    /**
     * Gets the orcid.
     *
     * @return the orcid
     */
    public final String getOrcid() {
        return orcid;
    }

    /**
     * Sets the orcid.
     *
     * @param orcid
     *            the orcid to set
     */
    public final void setOrcid(final String orcid) {
        this.orcid = orcid;
    }

    /**
     * Gets the state.
     *
     * @return the state
     */
    public final String getState() {
        return state;
    }

    /**
     * Sets the state.
     *
     * @param state
     *            the state to set
     */
    public final void setState(final String state) {
        this.state = state;
    }

}
