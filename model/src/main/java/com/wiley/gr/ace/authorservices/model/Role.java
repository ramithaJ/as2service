package com.wiley.gr.ace.authorservices.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

/**
 * @author virtusa
 *	version 1.0
 */
public class Role {
    
    private String roleId;
    
    @NotNull
    @NotBlank
    private String roleName;
    
    @NotNull
    @NotBlank
    private String roleDescription;
    
    private boolean isAdminRole = false;
    private int noOfPermissions;
    
    public int getNoOfPermissions() {
        return noOfPermissions;
    }

    public void setNoOfPermissions(int noOfPermissions) {
        this.noOfPermissions = noOfPermissions;
    }

    /**
     * @return
     */
    public String getRoleId() {
        return roleId;
    }
    
    /**
     * @param roleId
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    
    /**
     * @return
     */
    public String getRoleName() {
        return roleName;
    }
    
    /**
     * @param roleName
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    /**
     * @return
     */
    public boolean isAdminRole() {
        return isAdminRole;
    }
    
    /**
     * @param isAdminRole
     */
    public void setAdminRole(boolean isAdminRole) {
        this.isAdminRole = isAdminRole;
    }
    
    /**
     * @return
     */
    public String getRoleDescription() {
        return roleDescription;
    }
    
    /**
     * @param roleDescription
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }
    
}
