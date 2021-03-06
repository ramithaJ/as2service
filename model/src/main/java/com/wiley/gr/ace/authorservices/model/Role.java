package com.wiley.gr.ace.authorservices.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class Role.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class Role {

    /** The role id. */
    private String roleId;

    /** The role name. */
    @NotNull
    @NotBlank
    private String roleName;

    /** The role description. */
    @NotNull
    @NotBlank
    private String roleDescription;

    /** The is admin role. */
    private boolean isAdminRole = false;
   
    @NotNull
    @NotBlank
    /** The no of permissions. */
    private String noOfPermissions;

    /**
     * @return the roleId
     */
    public final String getRoleId() {
        return roleId;
    }

    /**
     * @param roleId
     *            the roleId to set
     */
    public final void setRoleId(final String roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the roleName
     */
    public final String getRoleName() {
        return roleName;
    }

    /**
     * @param roleName
     *            the roleName to set
     */
    public final void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    /**
     * @return the roleDescription
     */
    public final String getRoleDescription() {
        return roleDescription;
    }

    /**
     * @param roleDescription
     *            the roleDescription to set
     */
    public final void setRoleDescription(final String roleDescription) {
        this.roleDescription = roleDescription;
    }

    /**
     * @return the isAdminRole
     */
    public final boolean isAdminRole() {
        return isAdminRole;
    }

    /**
     * @param isAdminRole
     *            the isAdminRole to set
     */
    public final void setAdminRole(final boolean isAdminRole) {
        this.isAdminRole = isAdminRole;
    }

    /**
     * @return the noOfPermissions
     */
    public final String getNoOfPermissions() {
        return noOfPermissions;
    }

    /**
     * @param noOfPermissions
     *            the noOfPermissions to set
     */
    public final void setNoOfPermissions(final String noOfPermissions) {
        this.noOfPermissions = noOfPermissions;
    }

}
