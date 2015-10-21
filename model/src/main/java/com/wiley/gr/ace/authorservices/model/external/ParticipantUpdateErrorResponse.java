package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author virtusa version 1.0
 *
 */
public class ParticipantUpdateErrorResponse {

    /**
     * This field holds the value of error
     */
    private ErrorPayLoad error;

    /**
     * @return the error
     */
    public final ErrorPayLoad getError() {
        return error;
    }

    /**
     * @param error
     *            the error to set
     */
    public final void setError(final ErrorPayLoad error) {
        this.error = error;
    }

}
