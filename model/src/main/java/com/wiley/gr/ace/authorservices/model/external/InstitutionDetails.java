/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class InstitutionDetails.
 *
 * @author virtusa version 1.0
 */
public class InstitutionDetails {
	
	/**
     * This field holds the value of institute
     */
	@JsonProperty("institutions")
    private List<Institute> instituteList;

    /**
     * @return the instituteList
     */
    public final List<Institute> getInstituteList() {
        return instituteList;
    }

    /**
     * @param instituteList
     *            the instituteList to set
     */
    public final void setInstituteList(final List<Institute> instituteList) {
        this.instituteList = instituteList;
    }

}
