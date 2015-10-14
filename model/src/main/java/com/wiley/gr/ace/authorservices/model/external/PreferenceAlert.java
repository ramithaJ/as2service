package com.wiley.gr.ace.authorservices.model.external;

public class PreferenceAlert {
    private String preferenceKey;
    private PreferenceValue preferenceValue;

    public String getPreferenceKey() {
        return preferenceKey;
    }

    public void setPreferenceKey(String preferenceKey) {
        this.preferenceKey = preferenceKey;
    }

    public PreferenceValue getPreferenceVAlue() {
        return preferenceValue;
    }

    public void setPreferenceValue(PreferenceValue preferenceValue) {
        this.preferenceValue = preferenceValue;
    }
}
