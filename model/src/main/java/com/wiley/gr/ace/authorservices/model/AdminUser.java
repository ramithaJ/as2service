package com.wiley.gr.ace.authorservices.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * The Class AdminUser.
 *
 * @author virtusa version 1.0
 */
@JsonInclude(Include.NON_NULL)
public class AdminUser {

    /** The email id. */
    private String emailId;

    /** The roles list. */
    private List<String> rolesList;

    /** The first name. */
    private String firstName;

    /** The last name. */
    private String lastName;

    /**
     * Gets the email id.
     *
     * @return the email id
     */
    public String getEmailId() {
        return emailId;
    }

    /**
     * Sets the email id.
     *
     * @param emailId
     *            the new email id
     */
    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    /**
     * Gets the first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     *
     * @param firstName
     *            the new first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     *
     * @param lastName
     *            the new last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the roles list.
     *
     * @return the roles list
     */
    public List<String> getRolesList() {
        return rolesList;
    }

    /**
     * Sets the roles list.
     *
     * @param rolesList
     *            the new roles list
     */
    public void setRolesList(List<String> rolesList) {
        this.rolesList = rolesList;
    }

}
