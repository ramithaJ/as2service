package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

/**
 * The Class PermissionData.
 *
 * @author SarmaKumarap
 */
public class PermissionData {

    /** The links. */
    private List<LinkData> links;

    /** The permission cd. */
    private String permissionCd;

    /** The permission name. */
    private String permissionName;

    /** The groups. */
    private List<String> groups;

    /**
     * Gets the links.
     *
     * @return the links
     */
    public List<LinkData> getLinks() {
        return links;
    }

    /**
     * Sets the links.
     *
     * @param links
     *            the new links
     */
    public void setLinks(final List<LinkData> links) {
        this.links = links;
    }

    /**
     * Gets the permission cd.
     *
     * @return the permission cd
     */
    public String getPermissionCd() {
        return permissionCd;
    }

    /**
     * Sets the permission cd.
     *
     * @param permissionCd
     *            the new permission cd
     */
    public void setPermissionCd(final String permissionCd) {
        this.permissionCd = permissionCd;
    }

    /**
     * Gets the permission name.
     *
     * @return the permission name
     */
    public String getPermissionName() {
        return permissionName;
    }

    /**
     * Sets the permission name.
     *
     * @param permissionName
     *            the new permission name
     */
    public void setPermissionName(final String permissionName) {
        this.permissionName = permissionName;
    }

    /**
     * Gets the groups.
     *
     * @return the groups
     */
    public List<String> getGroups() {
        return groups;
    }

    /**
     * Sets the groups.
     *
     * @param groups
     *            the new groups
     */
    public void setGroups(final List<String> groups) {
        this.groups = groups;
    }

}
