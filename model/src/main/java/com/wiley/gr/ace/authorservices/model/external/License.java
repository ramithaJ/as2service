/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class License.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class License {

    /** The license status. */
    private String licenseStatus;
    
    private List<ProgramData> program;

   

    /**
     * Gets the license status.
     *
     * @return the license status
     */
    public final String getLicenseStatus() {
        return licenseStatus;
    }

    /**
     * Sets the license status.
     *
     * @param licenseStatus
     *            the new license status
     */
    public final void setLicenseStatus(final String licenseStatus) {
        this.licenseStatus = licenseStatus;
    }

    public final List<ProgramData> getProgram() {
        return program;
    }

    public final void setProgram(final List<ProgramData> program) {
        this.program = program;
    }

}
