package com.wiley.gr.ace.authorservices.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author SarmaKumarap
 */
@JsonInclude(Include.NON_NULL)
public class AdminUser {
    
    private String emailId;
    
    private String roleId;
    
    private String firstName;
    
    private String lastName;
    
    /**
     * @return
     */
    public String getEmailId() {
        return emailId;
    }
    
    /**
     * @param emailId
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
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
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
}
