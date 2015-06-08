package com.wiley.gr.ace.authorservices.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author virtusa
 *	version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class AdminUser {
    
    private String emailId;
    
    private List<String> rolesList;
    
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

    /**
     * @return
     */
    public List<String> getRolesList() {
        return rolesList;
    }

    /**
     * @param rolesList
     */
    public void setRolesList(List<String> rolesList) {
        this.rolesList = rolesList;
    }
    
}
