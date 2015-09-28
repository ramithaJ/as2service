package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class ProductEntities.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Product-Entities")
public class ProductEntities {
	
    
    /** The identifier. */
    @XmlElement(name = "IDENTIFIER")
    private List<Identifier> identifier;
    
    /**
     * Gets the identifier.
     *
     * @return the identifier
     */
    public final List<Identifier> getIdentifier() {
        return identifier;
    }

    /**
     * Sets the identifier.
     *
     * @param identifier
     *            the new identifier
     */
    public final void setIdentifier(final List<Identifier> identifier) {
        this.identifier = identifier;
    }
    
	/** The title. */
	@XmlElement(name = "TITLE")
	private Title title;

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public Title getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(Title title) {
		this.title = title;
	}
}
