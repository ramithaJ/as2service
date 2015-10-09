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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class Participant.
 */
/**
 * @author rajatg
 *
 */
public class Participant {

	/** The participant id. */
	private String participantId;
	
	/** The email. */
	private String email;
	
	/** The recovery email. */
	private String recoveryEmail;
	
	/** The alternate emails. */
	private List<String> alternateEmails;
	
	/** The honorific prefix. */
	private String honorificPrefix;
	
	/** The job title. */
	private String jobTitle;
	
	/** The additional name. */
	private String additionalName;
	
	/** The honorific suffix. */
	private String honorificSuffix;
	
	/** The alternate names. */
	private List<Name> alternateNames;
	
    /** The user id. */
    private String userId;
    
    /** The open access accounts. */
    private List<String> openAccessAccounts;
    
    /** The industry id. */
    private String industryId;
    
    /** The job category id. */
    private String jobCategoryId;

    /** The personid. */
    private String personId;
    
    /** The orcid id. */
    private String orcidId;
    
    /** The areas of interest. */
    private List<String> areasOfInterest;

    /** The user name. */
    private String userName;

    /** The name. */
    private String name;

    /** The given name. */
    private String givenName;

    /** The family name. */
    private String familyName;

    /** The participant country. */
    private String participantCountry;

    /** The state. */
    private String state;

    /** The created date. */
    @JsonProperty("created")
    private String createdDate;

    /** The modified date. */
    @JsonProperty("modified")
    private String modifiedDate;

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId
     *            the new user id
     */
    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    /**
     * Gets the personid.
     *
     * @return the personid
     */
    public final String getPersonid() {
        return personId;
    }

    /**
     * Sets the personid.
     *
     * @param personid
     *            the new personid
     */
    public final void setPersonid(final String personid) {
        this.personId = personid;
    }

    /**
     * Gets the user name.
     *
     * @return the user name
     */
    public final String getUserName() {
        return userName;
    }

    /**
     * Sets the user name.
     *
     * @param userName
     *            the new user name
     */
    public final void setUserName(final String userName) {
        this.userName = userName;
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
     * Gets the given name.
     *
     * @return the given name
     */
    public final String getGivenName() {
        return givenName;
    }

    /**
     * Sets the given name.
     *
     * @param givenName
     *            the new given name
     */
    public final void setGivenName(final String givenName) {
        this.givenName = givenName;
    }

    /**
     * Gets the family name.
     *
     * @return the family name
     */
    public final String getFamilyName() {
        return familyName;
    }

    /**
     * Sets the family name.
     *
     * @param familyName
     *            the new family name
     */
    public final void setFamilyName(final String familyName) {
        this.familyName = familyName;
    }

    /**
     * Gets the participant country.
     *
     * @return the participant country
     */
    public final String getParticipantCountry() {
        return participantCountry;
    }

    /**
     * Sets the participant country.
     *
     * @param participantCountry
     *            the new participant country
     */
    public final void setParticipantCountry(final String participantCountry) {
        this.participantCountry = participantCountry;
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
     *            the new state
     */
    public final void setState(final String state) {
        this.state = state;
    }

    /**
     * Gets the created date.
     *
     * @return the created date
     */
    public final String getCreatedDate() {
        return createdDate;
    }

    /**
     * Sets the created date.
     *
     * @param createdDate
     *            the new created date
     */
    public final void setCreatedDate(final String createdDate) {
        this.createdDate = createdDate;
    }

    /**
     * Gets the modified date.
     *
     * @return the modified date
     */
    public final String getModifiedDate() {
        return modifiedDate;
    }

    /**
     * Sets the modified date.
     *
     * @param modifiedDate
     *            the new modified date
     */
    public final void setModifiedDate(final String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

	/**
	 * Gets the participant id.
	 *
	 * @return the participant id
	 */
	public String getParticipantId() {
		return participantId;
	}

	/**
	 * Sets the participant id.
	 *
	 * @param participantId the new participant id
	 */
	public void setParticipantId(String participantId) {
		this.participantId = participantId;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Gets the recovery email.
	 *
	 * @return the recovery email
	 */
	public String getRecoveryEmail() {
		return recoveryEmail;
	}

	/**
	 * Sets the recovery email.
	 *
	 * @param recoveryEmail the new recovery email
	 */
	public void setRecoveryEmail(String recoveryEmail) {
		this.recoveryEmail = recoveryEmail;
	}

	/**
	 * Gets the alternate emails.
	 *
	 * @return the alternate emails
	 */
	public List<String> getAlternateEmails() {
		return alternateEmails;
	}

	/**
	 * Sets the alternate emails.
	 *
	 * @param alternateEmails the new alternate emails
	 */
	public void setAlternateEmails(List<String> alternateEmails) {
		this.alternateEmails = alternateEmails;
	}

	/**
	 * Gets the honorific prefix.
	 *
	 * @return the honorific prefix
	 */
	public String getHonorificPrefix() {
		return honorificPrefix;
	}

	/**
	 * Sets the honorific prefix.
	 *
	 * @param honorificPrefix the new honorific prefix
	 */
	public void setHonorificPrefix(String honorificPrefix) {
		this.honorificPrefix = honorificPrefix;
	}

	/**
	 * Gets the job title.
	 *
	 * @return the job title
	 */
	public String getJobTitle() {
		return jobTitle;
	}

	/**
	 * Sets the job title.
	 *
	 * @param jobTitle the new job title
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	/**
	 * Gets the additional name.
	 *
	 * @return the additional name
	 */
	public String getAdditionalName() {
		return additionalName;
	}

	/**
	 * Sets the additional name.
	 *
	 * @param additionalName the new additional name
	 */
	public void setAdditionalName(String additionalName) {
		this.additionalName = additionalName;
	}

	/**
	 * Gets the honorific suffix.
	 *
	 * @return the honorific suffix
	 */
	public String getHonorificSuffix() {
		return honorificSuffix;
	}

	/**
	 * Sets the honorific suffix.
	 *
	 * @param honorificSuffix the new honorific suffix
	 */
	public void setHonorificSuffix(String honorificSuffix) {
		this.honorificSuffix = honorificSuffix;
	}

	/**
	 * Gets the alternate names.
	 *
	 * @return the alternate names
	 */
	public List<Name> getAlternateNames() {
		return alternateNames;
	}

	/**
	 * Sets the alternate names.
	 *
	 * @param alternateNames the new alternate names
	 */
	public void setAlternateNames(List<Name> alternateNames) {
		this.alternateNames = alternateNames;
	}

	/**
	 * Gets the open access accounts.
	 *
	 * @return the open access accounts
	 */
	public List<String> getOpenAccessAccounts() {
		return openAccessAccounts;
	}

	/**
	 * Sets the open access accounts.
	 *
	 * @param openAccessAccounts the new open access accounts
	 */
	public void setOpenAccessAccounts(List<String> openAccessAccounts) {
		this.openAccessAccounts = openAccessAccounts;
	}

	/**
	 * Gets the industry id.
	 *
	 * @return the industry id
	 */
	public String getIndustryId() {
		return industryId;
	}

	/**
	 * Sets the industry id.
	 *
	 * @param industryId the new industry id
	 */
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	/**
	 * Gets the job category id.
	 *
	 * @return the job category id
	 */
	public String getJobCategoryId() {
		return jobCategoryId;
	}

	/**
	 * Sets the job category id.
	 *
	 * @param jobCategoryId the new job category id
	 */
	public void setJobCategoryId(String jobCategoryId) {
		this.jobCategoryId = jobCategoryId;
	}

	/**
	 * Gets the person id.
	 *
	 * @return the person id
	 */
	public String getPersonId() {
		return personId;
	}

	/**
	 * Sets the person id.
	 *
	 * @param personId the new person id
	 */
	public void setPersonId(String personId) {
		this.personId = personId;
	}

	/**
	 * Gets the orcid id.
	 *
	 * @return the orcid id
	 */
	public String getOrcidId() {
		return orcidId;
	}

	/**
	 * Sets the orcid id.
	 *
	 * @param orcidId the new orcid id
	 */
	public void setOrcidId(String orcidId) {
		this.orcidId = orcidId;
	}

	/**
	 * Gets the areas of interest.
	 *
	 * @return the areas of interest
	 */
	public List<String> getAreasOfInterest() {
		return areasOfInterest;
	}

	/**
	 * Sets the areas of interest.
	 *
	 * @param areasOfInterest the new areas of interest
	 */
	public void setAreasOfInterest(List<String> areasOfInterest) {
		this.areasOfInterest = areasOfInterest;
	}
    
    
}
