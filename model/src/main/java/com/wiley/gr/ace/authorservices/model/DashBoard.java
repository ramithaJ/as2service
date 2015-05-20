package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author Virtusa
 */
@JsonInclude(Include.NON_NULL)
public class DashBoard {
    
    /** The security Details . */
    private SecurityDetails securityDetails;
    
    /** The user funders . */
    private UserFunder userFunders;
    
    /** The userMgmt . */
    private User user;
    
    /** The society Details . */
    private Society society;
    
    /** The Affiliations . */
    private Affiliation affiliation;
    
    /** The interests . */
    private Interests interests;
    
    /**
     * Gets the Security Details.
     *
     * @return the Security Details
     */
    public SecurityDetails getSecurityDetails() {
        return securityDetails;
    }
    
    /**
     * Sets the Security Details.
     *
     * @param the
     *            Security Details
     */
    public void setSecurityDetails(SecurityDetails securityDetails) {
        this.securityDetails = securityDetails;
    }
    
    /**
     * Gets the Funders Details.
     *
     * @return the Funders Details
     */
    public UserFunder getUserFunders() {
        return userFunders;
    }
    
    /**
     * sets the Funders Details.
     *
     * @param the
     *            Funders
     */
    public void setUserFunders(UserFunder userFunders) {
        this.userFunders = userFunders;
    }
    
    /**
     * Gets the UserMgmt.
     *
     * @return the UserMgmt
     */
    public User getUser() {
        return user;
    }
    
    /**
     * Sets the UserMgmt.
     *
     * @param the
     *            UserMgmt
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    /**
     * Gets the Society.
     *
     * @return the Society
     */
    public Society getSociety() {
        return society;
    }
    
    /**
     * Sets the Society.
     *
     * @param the
     *            Society
     */
    public void setSociety(Society society) {
        this.society = society;
    }
    
    /**
     * Gets the affiliation.
     *
     * @return the affiliation
     */
    public Affiliation getAffiliation() {
        return affiliation;
    }
    
    /**
     * Sets the affiliation.
     *
     * @param the
     *            affiliation
     */
    public void setAffiliation(Affiliation affiliation) {
        this.affiliation = affiliation;
    }
    
    /**
     * Gets the Interests.
     *
     * @return the Interests
     */
    public Interests getInterests() {
        return interests;
    }
    
    /**
     * Sets the Interests.
     *
     * @param the
     *            Interests
     */
    public void setInterests(Interests interests) {
        this.interests = interests;
    }
    
}
