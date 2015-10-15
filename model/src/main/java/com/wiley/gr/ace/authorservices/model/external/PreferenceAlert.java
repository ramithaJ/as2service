package com.wiley.gr.ace.authorservices.model.external;

public class PreferenceAlert {
    private String preferenceKey;
    AlertType alertType;

    public String getPreferenceKey() {
        return preferenceKey;
    }

    public void setPreferenceKey(String preferenceKey) {
        this.preferenceKey = preferenceKey;
    }

    public AlertType getAlertType() {
        return alertType;
    }

    public void setAlertType(AlertType alertType) {
        this.alertType = alertType;
    }

 
}
