package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class PreferenceMapper.
 */
public class PreferenceMapper {
    
    /** The preference key. */
    private String preferenceKey;
    
    /** The preference value. */
    private PreferenceValue preferenceValue;

  

    /**
     * Gets the preference key.
     *
     * @return the preference key
     */
    public String getPreferenceKey() {
        return preferenceKey;
    }

    /**
     * Sets the preference key.
     *
     * @param preferenceKey the new preference key
     */
    public void setPreferenceKey(String preferenceKey) {
        this.preferenceKey = preferenceKey;
    }

    /**
     * Gets the preference value.
     *
     * @return the preference value
     */
    public PreferenceValue getPreferenceValue() {
        return preferenceValue;
    }

    /**
     * Sets the preference value.
     *
     * @param preferenceValue the new preference value
     */
    public void setPreferenceValue(PreferenceValue preferenceValue) {
        this.preferenceValue = preferenceValue;
    }
}
