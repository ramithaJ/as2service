package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

// TODO: Auto-generated Javadoc
/**
 * The Class PreferenceValue.
 */
public class PreferenceValue {
    
    /** The preffered email id. */
    String preferredEmailId;
    
    /** The alert. */
    List<PreferenceAlert> alert;
    
    /**
     * Gets the preffered email id.
     *
     * @return the preffered email id
     */
    public String getPreferredEmailId() {
        return preferredEmailId;
    }
    
    /**
     * Sets the preffered email id.
     *
     * @param prefferedEmailId the new preffered email id
     */
    public void setPreferredEmailId(String preferredEmailId) {
        this.preferredEmailId = preferredEmailId;
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
