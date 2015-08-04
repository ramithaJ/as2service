package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Doc {

	@JsonProperty("CG_CUST_GRP_NAME")
	private String CGCUSTGRPNAME;

	@JsonProperty("CG_CUST_GRP_ID")
	private String CGCUSTGRPID;

	@JsonProperty("CG_LEVEL_0_NM")
	private String CGLEVEL0NM;

	@JsonProperty("doc_type")
	private String docType;

	@JsonProperty("CG_LEVEL_NUM")
	private String CGLEVELNUM;

	@JsonProperty("CG_LEVEL_1_NM")
	private String CGLEVEL1NM;

	@JsonProperty("CG_LEVEL_0_ID")
	private String CGLEVEL0ID;

	@JsonProperty("id")
	private String id;

	@JsonProperty("CG_LEVEL_1_ID")
	private String CGLEVEL1ID;

	@JsonProperty("_version_")
	private Integer Version;

	/**
	 * 
	 * @return The CGCUSTGRPNAME
	 */
	public String getCGCUSTGRPNAME() {
		return CGCUSTGRPNAME;
	}

	/**
	 * 
	 * @param CGCUSTGRPNAME
	 *            The CG_CUST_GRP_NAME
	 */
	public void setCGCUSTGRPNAME(String CGCUSTGRPNAME) {
		this.CGCUSTGRPNAME = CGCUSTGRPNAME;
	}

	/**
	 * 
	 * @return The CGCUSTGRPID
	 */
	public String getCGCUSTGRPID() {
		return CGCUSTGRPID;
	}

	/**
	 * 
	 * @param CGCUSTGRPID
	 *            The CG_CUST_GRP_ID
	 */
	public void setCGCUSTGRPID(String CGCUSTGRPID) {
		this.CGCUSTGRPID = CGCUSTGRPID;
	}

	/**
	 * 
	 * @return The CGLEVEL0NM
	 */
	public String getCGLEVEL0NM() {
		return CGLEVEL0NM;
	}

	/**
	 * 
	 * @param CGLEVEL0NM
	 *            The CG_LEVEL_0_NM
	 */
	public void setCGLEVEL0NM(String CGLEVEL0NM) {
		this.CGLEVEL0NM = CGLEVEL0NM;
	}

	/**
	 * 
	 * @return The docType
	 */
	public String getDocType() {
		return docType;
	}

	/**
	 * 
	 * @param docType
	 *            The doc_type
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}

	/**
	 * 
	 * @return The CGLEVELNUM
	 */
	public String getCGLEVELNUM() {
		return CGLEVELNUM;
	}

	/**
	 * 
	 * @param CGLEVELNUM
	 *            The CG_LEVEL_NUM
	 */
	public void setCGLEVELNUM(String CGLEVELNUM) {
		this.CGLEVELNUM = CGLEVELNUM;
	}

	/**
	 * 
	 * @return The CGLEVEL1NM
	 */
	public String getCGLEVEL1NM() {
		return CGLEVEL1NM;
	}

	/**
	 * 
	 * @param CGLEVEL1NM
	 *            The CG_LEVEL_1_NM
	 */
	public void setCGLEVEL1NM(String CGLEVEL1NM) {
		this.CGLEVEL1NM = CGLEVEL1NM;
	}

	/**
	 * 
	 * @return The CGLEVEL0ID
	 */
	public String getCGLEVEL0ID() {
		return CGLEVEL0ID;
	}

	/**
	 * 
	 * @param CGLEVEL0ID
	 *            The CG_LEVEL_0_ID
	 */
	public void setCGLEVEL0ID(String CGLEVEL0ID) {
		this.CGLEVEL0ID = CGLEVEL0ID;
	}

	/**
	 * 
	 * @return The id
	 */
	public String getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 *            The id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 
	 * @return The CGLEVEL1ID
	 */
	public String getCGLEVEL1ID() {
		return CGLEVEL1ID;
	}

	/**
	 * 
	 * @param CGLEVEL1ID
	 *            The CG_LEVEL_1_ID
	 */
	public void setCGLEVEL1ID(String CGLEVEL1ID) {
		this.CGLEVEL1ID = CGLEVEL1ID;
	}

	/**
	 * 
	 * @return The Version
	 */
	public Integer getVersion() {
		return Version;
	}

}