package com.wiley.gr.ace.authorservices.model.external;

public class PreferenceValue {
    String prefferedEmailId;
    PreferenceAlert alert;
    public String getPrefferedEmailId() {
        return prefferedEmailId;
    }
    public void setPrefferedEmailId(String prefferedEmailId) {
        this.prefferedEmailId = prefferedEmailId;
    }
    public PreferenceAlert getAlert() {
        return alert;
    }
    public void setAlert(PreferenceAlert alert) {
        this.alert = alert;
    }
}
