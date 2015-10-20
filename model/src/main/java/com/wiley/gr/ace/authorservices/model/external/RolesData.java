package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

/**
 * The Class RolesData.
 *
 * @author virtusa version 1.0
 */
public class RolesData {

    /** The role id. */
    private String roleId;

    /** The role name. */
    private String roleName;

    /** The role description. */
    private String roleDescription;

    /** The role type. */
    private String roleType;

    /** The permissions. */
    private List<PermissionData> permissions;

    /** The users. */
    private List<UserData> users;

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
    public void setRoleId(final String roleId) {
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
    public void setRoleName(final String roleName) {
        this.roleName = roleName;
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
    public void setRoleDescription(final String roleDescription) {
        this.roleDescription = roleDescription;
    }

    /**
     * Gets the role type.
     *
     * @return the role type
     */
    public String getRoleType() {
        return roleType;
    }

    /**
     * Sets the role type.
     *
     * @param roleType
     *            the new role type
     */
    public void setRoleType(final String roleType) {
        this.roleType = roleType;
    }

    /**
     * Gets the permissions.
     *
     * @return the permissions
     */
    public List<PermissionData> getPermissions() {
        return permissions;
    }

    /**
     * Sets the permissions.
     *
     * @param permissions
     *            the new permissions
     */
    public void setPermissions(final List<PermissionData> permissions) {
        this.permissions = permissions;
    }

    /**
     * Gets the users.
     *
     * @return the users
     */
    public List<UserData> getUsers() {
        return users;
    }

    /**
     * Sets the users.
     *
     * @param users
     *            the new users
     */
    public void setUsers(final List<UserData> users) {
        this.users = users;
    }

}
