package com.wiley.gr.ace.authorservices.model.external;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author virtusa
 * @version 1.0
 */
public class FunderData {

    /** The funder */
    private List<Funder> funder = new ArrayList<Funder>();

    /**
     * @return the funder
     */
    public List<Funder> getFunder() {
        return funder;
    }

    /**
     * @param funder
     *            the funder to set
     */
    public void setFunder(List<Funder> funder) {
        this.funder = funder;
    }

}
