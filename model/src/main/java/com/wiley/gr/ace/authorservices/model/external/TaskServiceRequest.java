package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class TaskServiceRequest.
 *
 * @author virtusa version 1.0
 */
public class TaskServiceRequest {

    /** The requestor email. */
    @JsonProperty("requestorEmail")
    private String requestorEmail;

    /** The justifications. */
    @JsonProperty("justifications")
    private List<String> justifications = new ArrayList<String>();

    /** The requestor id. */
    @JsonProperty("requestorId")
    private String requestorId;

    /**
     * 
     * @return The requestorEmail
     */
    @JsonProperty("requestorEmail")
    public String getRequestorEmail() {
        return requestorEmail;
    }

    /**
     * 
     * @param requestorEmail
     *            The requestorEmail
     */
    @JsonProperty("requestorEmail")
    public void setRequestorEmail(String requestorEmail) {
        this.requestorEmail = requestorEmail;
    }

    /**
     * 
     * @return The justifications
     */
    @JsonProperty("justifications")
    public List<String> getJustifications() {
        return justifications;
    }

    /**
     * 
     * @param justifications
     *            The justifications
     */
    @JsonProperty("justifications")
    public void setJustifications(List<String> justifications) {
        this.justifications = justifications;
    }

    /**
     * 
     * @return The requestorId
     */
    @JsonProperty("requestorId")
    public String getRequestorId() {
        return requestorId;
    }

    /**
     * 
     * @param requestorId
     *            The requestorId
     */
    @JsonProperty("requestorId")
    public void setRequestorId(String requestorId) {
        this.requestorId = requestorId;
    }

    @SuppressWarnings("unchecked")
    public String getJsonString(TaskServiceRequest taskServiceRequest) {

        JSONObject object = new JSONObject();

        object.put("requestorEmail", taskServiceRequest.getRequestorEmail());
        object.put("justifications", taskServiceRequest.getJustifications());
        object.put("requestorId", taskServiceRequest.getRequestorId());

        return object.toJSONString().toString();

    }

    @Override
    public String toString() {
        return "{\"requestorEmail\":\"" + requestorEmail
                + "\", \"justifications\":\"" + justifications
                + "\", \"requestorId\":\"" + requestorId + "\"}";
    }
}