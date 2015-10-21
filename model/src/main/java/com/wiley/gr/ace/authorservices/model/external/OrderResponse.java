package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author virtusa version1.0
 *
 */
public class OrderResponse {

    /** The response code. */
    private String responseCode;

    /** The response description. */
    private String responseDescription;

    /** The oo unique id. */
    private String ooUniqueId;

    /**
     * 
     * @return The responseCode
     */
    public String getResponseCode() {
        return responseCode;
    }

    /**
     * 
     * @param responseCode
     *            The responseCode
     */
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    /**
     * 
     * @return The responseDescription
     */
    public String getResponseDescription() {
        return responseDescription;
    }

    /**
     * 
     * @param responseDescription
     *            The responseDescription
     */
    public void setResponseDescription(String responseDescription) {
        this.responseDescription = responseDescription;
    }

    /**
     * 
     * @return The ooUniqueId
     */
    public String getOoUniqueId() {
        return ooUniqueId;
    }

    /**
     * 
     * @param ooUniqueId
     *            The ooUniqueId
     */
    public void setOoUniqueId(String ooUniqueId) {
        this.ooUniqueId = ooUniqueId;
    }
}