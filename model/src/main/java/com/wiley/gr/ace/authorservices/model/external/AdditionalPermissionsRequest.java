package com.wiley.gr.ace.authorservices.model.external;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author virtusa version1.0
 *
 */
public class AdditionalPermissionsRequest {

    /**
     * This field holds the value of permissionCd
     */
    @NotNull
    @NotBlank
    private String permissionCd;

    /**
     * This field holds the value of permissionName
     */
    private String permissionName;

    /**
     * @return the permissionCd
     */
    public String getPermissionCd() {
        return permissionCd;
    }

    /**
     * @param permissionCd
     *            the permissionCd to set
     */
    public void setPermissionCd(final String permissionCd) {
        this.permissionCd = permissionCd;
    }

    /**
     * @return the permissionName
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * @param permissionName
     *            the permissionName to set
     */
    public void setPermissionName(final String permissionName) {
        this.permissionName = permissionName;
    }

}
