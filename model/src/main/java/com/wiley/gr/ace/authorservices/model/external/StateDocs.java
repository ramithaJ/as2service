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

public class StateDocs {

	private String id;

	private String _version_;

	private String ISO_ALPHA_3;

	private String ISO_ALPHA_2;

	private String doc_type;

	private String SUBDIVISION_CD;

	private String SUBDIVISION_NAME;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String get_version_() {
		return _version_;
	}

	public void set_version_(String _version_) {
		this._version_ = _version_;
	}

	public String getISO_ALPHA_3() {
		return ISO_ALPHA_3;
	}

	public void setISO_ALPHA_3(String ISO_ALPHA_3) {
		this.ISO_ALPHA_3 = ISO_ALPHA_3;
	}

	public String getISO_ALPHA_2() {
		return ISO_ALPHA_2;
	}

	public void setISO_ALPHA_2(String ISO_ALPHA_2) {
		this.ISO_ALPHA_2 = ISO_ALPHA_2;
	}

	public String getDoc_type() {
		return doc_type;
	}

	public void setDoc_type(String doc_type) {
		this.doc_type = doc_type;
	}

	public String getSUBDIVISION_CD() {
		return SUBDIVISION_CD;
	}

	public void setSUBDIVISION_CD(String SUBDIVISION_CD) {
		this.SUBDIVISION_CD = SUBDIVISION_CD;
	}

	public String getSUBDIVISION_NAME() {
		return SUBDIVISION_NAME;
	}

	public void setSUBDIVISION_NAME(String SUBDIVISION_NAME) {
		this.SUBDIVISION_NAME = SUBDIVISION_NAME;
	}

	@Override
	public String toString() {
		return "ClassPojo [id = " + id + ", _version_ = " + _version_
				+ ", ISO_ALPHA_3 = " + ISO_ALPHA_3 + ", ISO_ALPHA_2 = "
				+ ISO_ALPHA_2 + ", doc_type = " + doc_type
				+ ", SUBDIVISION_CD = " + SUBDIVISION_CD
				+ ", SUBDIVISION_NAME = " + SUBDIVISION_NAME + "]";
	}
}
