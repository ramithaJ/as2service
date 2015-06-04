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
 * @author virtusa
 *  version 1.0
 *
 */
public class OrcidAccessToken {
    
    private String name;
    private String access_token;
    private String token_type;
    private String refresh_token;
    private int expires_in;
    private String scope;
    private String orcid;
    private String state;
    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }
    
    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * @return the access_token
     */
    public String getAccess_token() {
        return access_token;
    }
    
    /**
     * @param access_token
     *            the access_token to set
     */
    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
    
    /**
     * @return the token_type
     */
    public String getToken_type() {
        return token_type;
    }
    
    /**
     * @param token_type
     *            the token_type to set
     */
    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }
    
    /**
     * @return the refresh_token
     */
    public String getRefresh_token() {
        return refresh_token;
    }
    
    /**
     * @param refresh_token
     *            the refresh_token to set
     */
    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }
    
    /**
     * @return the expires_in
     */
    public int getExpires_in() {
        return expires_in;
    }
    
    /**
     * @param expires_in
     *            the expires_in to set
     */
    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }
    
    /**
     * @return the scope
     */
    public String getScope() {
        return scope;
    }
    
    /**
     * @param scope
     *            the scope to set
     */
    public void setScope(String scope) {
        this.scope = scope;
    }
    
    /**
     * @return the orcid
     */
    public String getOrcid() {
        return orcid;
    }
    
    /**
     * @param orcid
     *            the orcid to set
     */
    public void setOrcid(String orcid) {
        this.orcid = orcid;
    }
    
    /**
     * @return the state
     */
    public String getState() {
        return state;
    }
    
    /**
     * @param state
     *            the state to set
     */
    public void setState(String state) {
        this.state = state;
    }
    
}
