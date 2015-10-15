package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

public class AlertRequest {
    private String preferredEmailId;
    private List<PreferenceAlert> alertList;
    public String getPreferredEmailId() {
        return preferredEmailId;
    }
    public void setPreferredEmailId(String preferredEmailId) {
        this.preferredEmailId = preferredEmailId;
    }
    public List<PreferenceAlert> getAlertList() {
        return alertList;
    }
    public void setAlertList(List<PreferenceAlert> list) {
        this.alertList = list;
    }
}
