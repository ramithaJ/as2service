package com.wiley.gr.ace.authorservices.model;

import java.util.List;

/**
 * The Class AlertsResponse.
 */
public class AlertsResponse {
    
    /** The emails list. */
    private List<String> emailsList;
    
    /** The alerts list. */
    private List<Alert> alertsList;
    
    /**
     * Gets the emails list.
     *
     * @return the emails list
     */
    public List<String> getEmailsList() {
        return emailsList;
    }
    
    /**
     * Sets the emails list.
     *
     * @param emailsList the new emails list
     */
    public void setEmailsList(List<String> emailsList) {
        this.emailsList = emailsList;
    }
    
    /**
     * Gets the alerts list.
     *
     * @return the alerts list
     */
    public List<Alert> getAlertsList() {
        return alertsList;
    }
    
    /**
     * Sets the alerts list.
     *
     * @param alertsList the new alerts list
     */
    public void setAlertsList(List<Alert> alertsList) {
        this.alertsList = alertsList;
    }
    
}
