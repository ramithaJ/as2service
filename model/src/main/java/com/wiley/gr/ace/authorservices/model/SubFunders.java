/**
 * 
 */
package com.wiley.gr.ace.authorservices.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * SubFunders.
 *
 * @author virtusa
 * @version 1.0
 */
public class SubFunders implements Serializable {

    /** Serial Version Id. */
    private static final long serialVersionUID = 1L;

    /** the id. */
    private String id;

    /** the name. */
    private String name;

    /** the sub funder list. */
    private List<SubFunder> subFunderList = new ArrayList<SubFunder>();

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

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
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the subFunderList
     */
    public List<SubFunder> getSubFunderList() {
        return subFunderList;
    }

    /**
     * @param subFunderList
     *            the subFunderList to set
     */
    public void setSubFunderList(List<SubFunder> subFunderList) {
        this.subFunderList = subFunderList;
    }

}
