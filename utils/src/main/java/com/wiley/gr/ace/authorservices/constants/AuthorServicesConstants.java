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

package com.wiley.gr.ace.authorservices.constants;

/**
 * The Class AuthorServicesConstants.
 *
 * @author virtusa version 1.0
 */
public class AuthorServicesConstants {

	/** The Constant AUTHOR_ROLE_CD. */
	public static final String AUTHOR_ROLE_CD = "101";

	/** The Constant COAUTHOR_ROLE_CD. */
	public static final String COAUTHOR_ROLE_CD = "102";

	/** The Constant for OrderStatus. */
	public static final String ORDER_STATUS_SUBMIT = "Submitted";

	/** The Constant PDF_NAME. */
	public static final String PDF_NAME = "Invoice.pdf";

	/** The Constant ADM_ACC_LOOKUP_KEY. */
	public static final String ADM_ACC_LOOKUP_KEY = "ADMACC";

	/** The Constant PERMISSION_LEVEL_SYSTEM. */
	public static final String PERMISSION_LEVEL_SYSTEM = "System";

	/** The Constant PERMISSION_LEVEL_ARTICLE. */
	public static final String PERMISSION_LEVEL_ARTICLE = "Article";

	/** The Constant PERMISSION_LEVEL_ADMIN. */
	public static final String PERMISSION_LEVEL_ADMIN = "Admin";

	/** The Constant PERMISSION_TYPE_INTERNAL. */
	public static final String PERMISSION_TYPE_INTERNAL = "internalusers";

	/** The Constant PERMISSION_TYPE_EXTERNAL. */
	public static final String PERMISSION_TYPE_EXTERNAL = "externalusers";

	/** The Constant ROLE_TYPE_EXTERNAL. */
	public static final String ROLE_TYPE_EXTERNAL = "EXTERNAL";

	/** The Constant ROLE_TYPE_INTERNAL. */
	public static final String ROLE_TYPE_INTERNAL = "INTERNAL";

	/** The Constant INVITE_RESET_PASSWORD_STATUS. */
	public static final String INVITE_RESET_PASSWORD_STATUS = "PENDING";

	/** The Constant INVITE_RESET_PASSWORD_STATUS_ClOSED. */
	public static final String INVITE_RESET_PASSWORD_STATUS_CLOSED = "CLOSED";

	/** The Constant AUDIT_OBJ_NAME. */
	public static final String AUDIT_OBJ_NAME = "OBJ_NAME";

	/** The Constant AUDIT_OBJ_ATTR. */
	public static final String AUDIT_OBJ_ATTR = "OBJ_ATTR";

	/** The Constant AUDIT_OLD_VAL. */
	public static final String AUDIT_OLD_VAL = "OLD_VAL";

	/** The Constant AUDIT_NEW_VAL. */
	public static final String AUDIT_NEW_VAL = "NEW_VAL";

	/** The Constant AUDIT_ACTION_CD. */
	public static final String AUDIT_ACTION_CD = "ACTION_CD";

	/** The Constant AUDIT_ACTION_NAME. */
	public static final String AUDIT_ACTION_NAME = "ACTION_NAME";

	/** The Constant AUDIT_DESCRIPTION. */
	public static final String AUDIT_DESCRIPTION = "DESCRIPTION";

	/** The Constant INVALIDEMAILCODE. */
	public static final String INVALIDEMAILCODE = "222";

	/** The Constant INVALIDEMAILMSG. */
	public static final String INVALIDEMAILMSG = "Invalid email address. Please Re-Enter";

	/** The Constant SERVERERRORCODE. */
	public static final String SERVERERRORCODE = "2013";

	/** The Constant SERVERERRORMESSAGE. */
	public static final String SERVERERRORMESSAGE = "Unable to process your request. Please try after some time..";

	/** The Constant SERVERERRORCODE. */
	public static final String NODATAFOUNDCODE = "2013";

	/** The Constant SERVERERRORMESSAGE. */
	public static final String NODATAFOUNDMSG = "No Data Found";

	/** FOR ROLES. */
	public static final int ROLEID = 10;

	/** UNAUTHORIZEDCODE. */
	public static final String UNAUTHORIZEDCODE = "2015";

	/** UNAUTHORIZEDMSG. */
	public static final String UNAUTHORIZEDMSG = "401 Unauthorized";

	/** LOCKEDCODE. */
	public static final String LOCKEDCODE = "2016";

	/** LOCKEDMSG. */
	public static final String LOCKEDMSG = "423 Locked";

	/** The Constant INVITE_RESET_PASSWORD_STATUS_TYPE. */
	public static final String INVITE_RESET_PASSWORD_STATUS_TYPE = "verifyAccount";

	/** This field holds the value of AUTHUSERNAME. */
	public static final String AUTHUSERNAME = "as2admin";

	/** This field holds the value of AUTHPASSWORD. */
	public static final String AUTHPASSWORD = "hgdJbhjrnfY9KFs3KPpddQ==";

	/** This field holds the value of SOURCESYSTEM. */
	public static final String SOURCESYSTEM = "AS";
    /** The Constant PDF_NAME. */
    public static final String INVOICE_PDF_NAME = "Invoice.pdf";

	/** This field holds the value of GUID. */
	public static final String GUID = "guid";

	/** The Constant for BPM_SOURCE_APP. */
	public static final String BPM_SOURCE_APP = "sourceApp";

	/** The Constant for BPM_LONG_DATE. */
	public static final String BPM_LONG_DATE = "longDate";

	/** The Constant for BPM_USERID. */
	public static final String BPM_USERID = "userId";

	/** The Constant for BPM_SIGNATURE. */
	public static final String BPM_SIGNATURE = "signature";

	/** The Constant for BPM_SALT. */
	public static final String BPM_SALT = "salt";

	/** The Constant for BPM_CALL_SUCCESS_STATUS. */
	public static final String BPM_CALL_SUCCESS_STATUS = "SUCCESS";

	/** The Constant for BPM_CALL_SUCCESS_STATUS. */
	public static final String STATUS_CODE_OK = "200";

	/** The Constant INTERNAL_SERVER_ERROR. */
	public static final String INTERNAL_SERVER_ERROR = "500";

	/** The Constant DATE_FORMAT. */
	public static final String DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ssXXX";

	/**
	 * This field holds the value of STATUS_ADD.
	 */
	public static final String STATUS_ADD = "add";

	/**
	 * This field holds the value of STATUS_EDIT.
	 */
	public static final String STATUS_EDIT = "edit";
	
	//need to look at
	
	public static final String COUNTRY_USA = "USA";
	
	public static final String COUNTRY_CANADA = "CANADA";

    /** The Constant LICENSE_PDF_NAME. */
    public static final String LICENSE_PDF_NAME = "License.pdf";

    public static final String INVITE_RESET_PASSWORD_STATUS_TYPE_VERIFIED = "VERIFIED";

    public static enum OO_ORDER_STATUS {
        SUBMIT_ORDER, ONLINE_OPEN_REQ_RCVD, NEW_ORDER_CREATED, ORDER_UPDATED, ORDER_FUNDING_APPROVED, ORDER_FUNDING_DENIED, CUSTOMER_ACCOUNT_ON_HOLD, NEW_INVOICE_GENERATED, PAYMENT_CONFIRMED, CONTENT_NOT_RECEIVED, RETRY_IDENTIFIER_UPDATED, RETRY_DSS_UNAVAILABLE, RETRY_DSS_NOT_FOUND, REQUEST_TO_WCR_DSS_FAILED, ARTICLE_ONLINE_OPEN, OPEN_ARTICLE_REQUEST_SEND, CREDIT_CARD_DECLINED, ORDER_CANCELLED, ORDER_CANCELLATION_FAILED, CANCELLATION_RECEIVED_NO_MATCHING_ORDER_FOUND, CUSTOMER_STEP_COMPLETE, CUSTOMER_STEP_FAILED, ORDER_AMOUNT_CALCULATED, AMOUNT_CALCULATION_FAILED, PENDING_FOR_FUNDER_APPROVAL, MULTIPLE_ARTICLES_FOUND, ARTICLE_NOT_FOUND, CANNOT_IDENTIFY_JOURNAL, DUPLICATE_ORDER_FOUND, ISSN_UPDATED, ARTICLE_STEP_COMPLETE, REQUEST_TO_CREATE_PROFORMA_INVOICE, ORDER_FOR_PAYMENT_ENTERED, ORDER_CREATION_FAILED, ON_HOLD, AUTOMATED_PROCESSING_DISABLED, AUTOMATION_CURRENTLY_ENABLED
    };

}
