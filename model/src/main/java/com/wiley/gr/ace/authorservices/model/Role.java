package com.wiley.gr.ace.authorservices.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * The Class Role.
 *
 * @author virtusa version 1.0
 */
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
    private int noOfPermissions;

    /**
     * Gets the no of permissions.
     *
     * @return the no of permissions
     */
    public int getNoOfPermissions() {
        return noOfPermissions;
    }

    /**
     * Sets the no of permissions.
     *
     * @param noOfPermissions
     *            the new no of permissions
     */
    public void setNoOfPermissions(int noOfPermissions) {
        this.noOfPermissions = noOfPermissions;
    }

    /**
     * Gets the role id.
     *
     * @return the role id
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * Sets the role id.
     *
     * @param roleId
     *            the new role id
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * Gets the role name.
     *
     * @return the role name
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * Sets the role name.
     *
     * @param roleName
     *            the new role name
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * Checks if is admin role.
     *
     * @return true, if is admin role
     */
    public boolean isAdminRole() {
        return isAdminRole;
    }

    /**
     * Sets the admin role.
     *
     * @param isAdminRole
     *            the new admin role
     */
    public void setAdminRole(boolean isAdminRole) {
        this.isAdminRole = isAdminRole;
    }

    /**
     * Gets the role description.
     *
     * @return the role description
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     * Sets the role description.
     *
     * @param roleDescription
     *            the new role description
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

}
