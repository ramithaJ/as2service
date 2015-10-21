package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class ResearchFunderElement.
 *
 * @author virtusa
 * @version 1.0
 */
public class ResearchFunderElement {

    /** The name. */
    private String name;

    /** The doi. */
    private String doi;

    /**
     * @return the name
     */
    public final String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public final void setName(final String name) {
        this.name = name;
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
     * to String method
     */
    @Override
    public String toString() {
        return "ResearchFunderElement [name=" + name + ", doi=" + doi + "]";
    }

}
