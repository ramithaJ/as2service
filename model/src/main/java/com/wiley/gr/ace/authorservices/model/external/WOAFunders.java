package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author virtusa version1.0
 *
 */
public class WOAFunders {

    /**
     * This field holds the value of woaFunder
     */
    @JsonProperty("WOAFunder")
    private List<WOAFunder> woaFunder = new ArrayList<WOAFunder>();

    /**
     * 
     * @return The WOAFunder
     */
    public List<WOAFunder> getWOAFunder() {
        return woaFunder;
    }

    /**
     * 
     * @param WOAFunder
     *            The WOAFunder
     */
    public void setWOAFunder(final List<WOAFunder> woaFunder) {
        this.woaFunder = woaFunder;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "WOAFunders [woaFunder=" + woaFunder + "]";
    }
}