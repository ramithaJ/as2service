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
     * @return the emailId
     */
    public final String getEmailId() {
        return emailId;
    }

    /**
     * @param emailId
     *            the emailId to set
     */
    public final void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    /**
     * @return the rolesList
     */
    public final List<String> getRolesList() {
        return rolesList;
    }

    /**
     * @param rolesList
     *            the rolesList to set
     */
    public final void setRolesList(final List<String> rolesList) {
        this.rolesList = rolesList;
    }

    /**
     * @return the firstName
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            the firstName to set
     */
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            the lastName to set
     */
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

}
