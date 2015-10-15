package com.wiley.gr.ace.authorservices.model;

import java.io.Serializable;

/**
 * 
 * @author virtusa
 * @version 1.0
 */
public class CacheData implements Serializable {

    private static final long serialVersionUID = 1L;

    /** The name */
    private String name;

    /** The code */
    private String code;

    /** The display name */
    private String displayName;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(final String code) {
        this.code = code;
    }

    /**
     * @return the displayName
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @param displayName
     *            the displayName to set
     */
    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return "{\"name\":\"" + name + "\",\"code\":\"" + code
                + "\",\"displayName\":\"" + displayName + "\"}";
    }

}
