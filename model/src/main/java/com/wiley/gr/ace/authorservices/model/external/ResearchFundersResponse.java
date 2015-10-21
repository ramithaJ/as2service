package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * @author virtusa version1.0
 *
 */
@JsonInclude(Include.NON_NULL)
public class ResearchFundersResponse {

    /** The funders. */
    private FunderData funders;

    /**
     * @return the funders
     */
    public FunderData getFunders() {
        return funders;
    }

    /**
     * @param funders
     *            the funders to set
     */
    public void setFunders(FunderData funders) {
        this.funders = funders;
    }

}