/**
 * 
 */
package com.wiley.gr.ace.authorservices.model;

import java.io.Serializable;

/**
 * SubFunder.
 *
 * @author virtusa
 * @version 1.0
 */
public class SubFunder implements Serializable {

    private static final long serialVersionUID = 1L;

    /** The id **/
    private String id;

    /** The doi **/
    private String doi;

    /** The name **/
    private String name;

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
     * @return the doi
     */
    public String getDoi() {
        return doi;
    }

    /**
     * @param doi
     *            the doi to set
     */
    public void setDoi(String doi) {
        this.doi = doi;
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

}
