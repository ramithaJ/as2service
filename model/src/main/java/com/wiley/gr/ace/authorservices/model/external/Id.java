package com.wiley.gr.ace.authorservices.model.external;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(Include.NON_NULL)
public class Id {

    @JsonProperty("type")
    private String type;

    @JsonProperty("_content_")
    private String content;

    /**
     * 
     * @return The type
     */
    public String getType() {
        return type;
    }

    /**
     * 
     * @param type
     *            The type
     */
    public void setType(final String type) {
        this.type = type;
    }

    /**
     * @return the content
     */
    public final String getContent() {
        return content;
    }

    /**
     * @param content
     *            the content to set
     */
    public final void setContent(final String content) {
        this.content = content;
    }

}