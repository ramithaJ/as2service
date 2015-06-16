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
package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class JobCategoryDocs.
 *
 * @author virtusa version 1.0
 */
public class JobCategoryDocs {

    /** The id. */
    private String id;

    /** The version. */
    @JsonProperty("_version_")
    private String version;

    /** The subJobTitle. */
    @JsonProperty("SUBJOBTITLE")
    private String subJobTitle;

    /** The jobTitle. */
    @JsonProperty("JOBTITLE")
    private String jobTitle;

    /** The docType. */
    @JsonProperty("doc_type")
    private String docType;

    /** The jobCode. */
    @JsonProperty("JOBCODE")
    private String jobCode;

    /** The job definition. */
    @JsonProperty("JOB_DEFINITION")
    private String jobDefinition;

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
     *            the id to set
     */
    public final void setId(final String id) {
        this.id = id;
    }

    /**
     * Gets the version.
     *
     * @return the version
     */
    public final String getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the new version
     */
    public final void setVersion(final String version) {
        this.version = version;
    }

    /**
     * Gets the sub job title.
     *
     * @return the sub job title
     */
    public final String getSubJobTitle() {
        return subJobTitle;
    }

    /**
     * Sets the sub job title.
     *
     * @param subJobTitle
     *            the new sub job title
     */
    public final void setSubJobTitle(final String subJobTitle) {
        this.subJobTitle = subJobTitle;
    }

    /**
     * Gets the job title.
     *
     * @return the job title
     */
    public final String getJobTitle() {
        return jobTitle;
    }

    /**
     * Sets the job title.
     *
     * @param jobTitle
     *            the new job title
     */
    public final void setJobTitle(final String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * Gets the doc type.
     *
     * @return the doc type
     */
    public final String getDocType() {
        return docType;
    }

    /**
     * Sets the doc type.
     *
     * @param docType
     *            the new doc type
     */
    public final void setDocType(final String docType) {
        this.docType = docType;
    }

    /**
     * Gets the job code.
     *
     * @return the job code
     */
    public final String getJobCode() {
        return jobCode;
    }

    /**
     * Sets the job code.
     *
     * @param jobCode
     *            the new job code
     */
    public final void setJobCode(final String jobCode) {
        this.jobCode = jobCode;
    }

    /**
     * Gets the job definition.
     *
     * @return the job definition
     */
    public final String getJobDefinition() {
        return jobDefinition;
    }

    /**
     * Sets the job definition.
     *
     * @param jobDefinition
     *            the new job definition
     */
    public final void setJobDefinition(final String jobDefinition) {
        this.jobDefinition = jobDefinition;
    }

}
