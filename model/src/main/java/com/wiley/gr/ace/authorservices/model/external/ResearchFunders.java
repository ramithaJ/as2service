/* Generated by JavaFromJSON */
/*http://javafromjson.dashingrocket.com*/

package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The Class ResearchFunders.
 */
public class ResearchFunders {

    /** The research funder. */
    @JsonProperty("ResearchFunder")
    private List<ResearchFunderElement> researchfunder;

    /**
     * @return the research funder
     */
    public final List<ResearchFunderElement> getResearchfunder() {
        return researchfunder;
    }

    /**
     * @param researchfunder
     *            the research funder to set
     */
    public final void setResearchfunder(
            final List<ResearchFunderElement> researchfunder) {
        this.researchfunder = researchfunder;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ResearchFunders [researchfunder=" + researchfunder + "]";
    }

}
