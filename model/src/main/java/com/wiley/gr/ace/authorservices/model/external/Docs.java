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
 * The Class Docs.
 * 
 * @author virtusa version 1.0
 */
public class Docs {

    /** The id. */
    private String id;

    /** The version. */
    @JsonProperty("_version_")
    private String version;

    /** The docType. */
    @JsonProperty("doc_type")
    private String docType;

    /** The subject code. */
    @JsonProperty("SUBJECT_CODE")
    private String subjectCode;

    /** The subject short name. */
    @JsonProperty("SUBJECT_SHORT_NAME")
    private String subjectShortName;

    /** The subject name. */
    @JsonProperty("SUBJECT_NAME")
    private String subjectName;

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
     * Gets the subject code.
     *
     * @return the subject code
     */
    public final String getSubjectCode() {
        return subjectCode;
    }

    /**
     * Sets the subject code.
     *
     * @param subjectCode
     *            the new subject code
     */
    public final void setSubjectCode(final String subjectCode) {
        this.subjectCode = subjectCode;
    }

    /**
     * Gets the subject short name.
     *
     * @return the subject short name
     */
    public final String getSubjectShortName() {
        return subjectShortName;
    }

    /**
     * Sets the subject short name.
     *
     * @param subjectShortName
     *            the new subject short name
     */
    public final void setSubjectShortName(final String subjectShortName) {
        this.subjectShortName = subjectShortName;
    }

    /**
     * Gets the subject name.
     *
     * @return the subject name
     */
    public final String getSubjectName() {
        return subjectName;
    }

    /**
     * Sets the subject name.
     *
     * @param subjectName
     *            the new subject name
     */
    public final void setSubjectName(final String subjectName) {
        this.subjectName = subjectName;
    }

}
