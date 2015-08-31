package com.wiley.gr.ace.authorservices.model.external;

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
