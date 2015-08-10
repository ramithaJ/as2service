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
package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class Funder.
 * 
 * @author virtusa version 1.0
 */
public class Funder {

    /** The uri. */
    private String uri;

    /** The id. */
    private String id;
    
    /** The secondary ids. */
    private SecondaryIds secondaryIds;

    /** The fund ref id. */
    private String fundRefId;

    /** The name. */
    private String name;
    
    /** The alt name. */
    private String altName;
    
    /** The parent. */
    private ParentData parent;
    
    /** The ultimate parent. */
    private UltimateParentData ultimateParent;
    
    /** The mandates. */
    private Mandates mandates;

    /**
     * Gets the id.
     *
     * @return the id
     */
    public final String getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     *            the new id
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the fund ref id.
     *
     * @return the fund ref id
     */
    public final String getFundRefId() {
        return fundRefId;
    }

    /**
     * Sets the fund ref id.
     *
     * @param fundRefId
     *            the new fund ref id
     */
    public final void setFundRefId(final String fundRefId) {
        this.fundRefId = fundRefId;
    }

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
     *            the new name
     */
    public final void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the alt name.
     *
     * @return the alt name
     */
    public final String getAltName() {
        return altName;
    }

    /**
     * Gets the ultimate parent.
     *
     * @return the ultimate parent
     */
    public final UltimateParentData getUltimateParent() {
        return ultimateParent;
    }

    /**
     * Gets the parent.
     *
     * @return the parent
     */
    public final ParentData getParent() {
        return parent;
    }

    /**
     * Gets the secondary ids.
     *
     * @return the secondary ids
     */
    public final SecondaryIds getSecondaryIds() {
        return secondaryIds;
    }

    /**
     * Gets the mandates.
     *
     * @return the mandates
     */
    public final Mandates getMandates() {
        return mandates;
    }

    /**
     * Gets the uri.
     *
     * @return the uri
     */
    public final String getUri() {
        return uri;
    }

    /**
     * Sets the alt name.
     *
     * @param altName the new alt name
     */
    public final void setAltName(final String altName) {
        this.altName = altName;
    }

    /**
     * Sets the ultimate parent.
     *
     * @param ultimateParent the new ultimate parent
     */
    public final void setUltimateParent(final UltimateParentData ultimateParent) {
        this.ultimateParent = ultimateParent;
    }

    /**
     * Sets the parent.
     *
     * @param parent the new parent
     */
    public final void setParent(final ParentData parent) {
        this.parent = parent;
    }

    /**
     * Sets the secondary ids.
     *
     * @param secondaryIds the new secondary ids
     */
    public final void setSecondaryIds(final SecondaryIds secondaryIds) {
        this.secondaryIds = secondaryIds;
    }

    /**
     * Sets the mandates.
     *
     * @param mandates the new mandates
     */
    public final void setMandates(final Mandates mandates) {
        this.mandates = mandates;
    }

    /**
     * Sets the uri.
     *
     * @param uri the new uri
     */
    public final void setUri(final String uri) {
        this.uri = uri;
    }
}
