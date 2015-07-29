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

    /** The no of permissions. */
    @NotNull
    @NotBlank
    /** The no of permissions. */
    private String noOfPermissions;
    
    /** The no of users. */
    private String noOfUsers;

    /**
     * Gets the role id.
     *
     * @return the roleId
     */
    public final String getRoleId() {
        return roleId;
    }

    /**
     * Sets the role id.
     *
     * @param roleId
     *            the roleId to set
     */
    public final void setRoleId(final String roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the role name.
     *
     * @return the roleName
     */
    public final String getRoleName() {
        return roleName;
    }

    /**
     * Sets the role name.
     *
     * @param roleName
     *            the roleName to set
     */
    public final void setRoleName(final String roleName) {
        this.roleName = roleName;
    }

    /**
     * Gets the role description.
     *
     * @return the roleDescription
     */
    public final String getRoleDescription() {
        return roleDescription;
    }

    /**
     * Sets the role description.
     *
     * @param roleDescription
     *            the roleDescription to set
     */
    public final void setRoleDescription(final String roleDescription) {
        this.roleDescription = roleDescription;
    }

    /**
     * Checks if is admin role.
     *
     * @return the isAdminRole
     */
    public final boolean isAdminRole() {
        return isAdminRole;
    }

    /**
     * Sets the admin role.
     *
     * @param isAdminRole
     *            the isAdminRole to set
     */
    public final void setAdminRole(final boolean isAdminRole) {
        this.isAdminRole = isAdminRole;
    }

    /**
     * Gets the no of permissions.
     *
     * @return the noOfPermissions
     */
    public final String getNoOfPermissions() {
        return noOfPermissions;
    }

    /**
     * Sets the no of permissions.
     *
     * @param noOfPermissions
     *            the noOfPermissions to set
     */
    public final void setNoOfPermissions(final String noOfPermissions) {
        this.noOfPermissions = noOfPermissions;
    }

    /**
     * Gets the no of users.
     *
     * @return the no of users
     */
    public String getNoOfUsers() {
        return noOfUsers;
    }

    /**
     * Sets the no of users.
     *
     * @param noOfUsers the new no of users
     */
    public void setNoOfUsers(final String noOfUsers) {
        this.noOfUsers = noOfUsers;
    }

}
