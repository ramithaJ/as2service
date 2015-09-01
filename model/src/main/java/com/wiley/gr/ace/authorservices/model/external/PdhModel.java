package com.wiley.gr.ace.authorservices.model.external;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class PdhModel.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Lookup-Response")
public class PdhModel {

    /** The product entities. */
    @XmlElement(name = "Product-Entities")
    private ProductEntities productEntities;

    /**
     * Gets the product entities.
     *
     * @return the product entities
     */
    public ProductEntities getProductEntities() {
        return productEntities;
    }

    /**
     * Sets the product entities.
     *
     * @param productEntities
     *            the new product entities
     */
    public void setProductEntities(final ProductEntities productEntities) {
        this.productEntities = productEntities;
    }
}
