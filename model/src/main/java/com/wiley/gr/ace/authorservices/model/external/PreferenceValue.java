package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PreferenceValue.
 */
public class PreferenceValue {
    
    /** The preffered email id. */
    String prefferedEmailId;
    
    /** The alert. */
    List<PreferenceAlert> alert;
    
    /**
     * Gets the preffered email id.
     *
     * @return the preffered email id
     */
    public String getPrefferedEmailId() {
        return prefferedEmailId;
    }
    
    /**
     * Sets the preffered email id.
     *
     * @param prefferedEmailId the new preffered email id
     */
    public void setPrefferedEmailId(String prefferedEmailId) {
        this.prefferedEmailId = prefferedEmailId;
    }

    /**
     * Gets the alert.
     *
     * @return the alert
     */
    public List<PreferenceAlert> getAlert() {
        return alert;
    }

    /**
     * Sets the alert.
     *
     * @param alert the new alert
     */
    public void setAlert(List<PreferenceAlert> alert) {
        this.alert = alert;
    }
    
 
}
