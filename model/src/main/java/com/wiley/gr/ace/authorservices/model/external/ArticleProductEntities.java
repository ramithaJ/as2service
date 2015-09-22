/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class ProductEntities.
 *
 * @author virtusa version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Product-Entities")
public class ArticleProductEntities {

    /** The product contributor. */
    @XmlElement(name = "PRODUCT_CONTRIBUTOR")
    private List<ProductContributor> productContributor;

    /** The product dates. */
    @XmlElement(name = "PRODUCT_DATES")
    private List<ProductDates> productDates;

    /** The identifier. */
    @XmlElement(name = "IDENTIFIER")
    private List<Identifier> identifier;

    /** The product. */
    @XmlElement(name = "PRODUCT")
    private Product product;

    /** The product extension. */
    @XmlElement(name = "PRODUCT_EXTENSION")
    private List<ProductExtension> productExtension;

    /** The product relation child. */
    @XmlElement(name = "PRODUCT_RELATION_CHILD")
    private List<ProductRelationChild> productRelationChild;

    /** The product region. */
    @XmlElement(name = "PRODUCT_REGION")
    private ProductRegion productRegion;

    /** The title. */
    @XmlElement(name = "TITLE")
    private Title title;

    /**
     * Gets the product contributor.
     *
     * @return the product contributor
     */
    public final List<ProductContributor> getProductContributor() {
        return productContributor;
    }

    /**
     * Sets the product contributor.
     *
     * @param productContributor
     *            the new product contributor
     */
    public final void setProductContributor(
            final List<ProductContributor> productContributor) {
        this.productContributor = productContributor;
    }

    /**
     * Gets the product dates.
     *
     * @return the product dates
     */
    public final List<ProductDates> getProductDates() {
        return productDates;
    }

    /**
     * Sets the product dates.
     *
     * @param productDates
     *            the new product dates
     */
    public final void setProductDates(final List<ProductDates> productDates) {
        this.productDates = productDates;
    }

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

    /**
     * Gets the product.
     *
     * @return the product
     */
    public final Product getProduct() {
        return product;
    }

    /**
     * Sets the product.
     *
     * @param product
     *            the new product
     */
    public final void setProduct(final Product product) {
        this.product = product;
    }

    /**
     * Gets the product extension.
     *
     * @return the product extension
     */
    public final List<ProductExtension> getProductExtension() {
        return productExtension;
    }

    /**
     * Sets the product extension.
     *
     * @param productExtension
     *            the new product extension
     */
    public final void setProductExtension(
            final List<ProductExtension> productExtension) {
        this.productExtension = productExtension;
    }

    /**
     * Gets the product relation child.
     *
     * @return the product relation child
     */
    public final List<ProductRelationChild> getProductRelationChild() {
        return productRelationChild;
    }

    /**
     * Sets the product relation child.
     *
     * @param productRelationChild
     *            the new product relation child
     */
    public final void setProductRelationChild(
            final List<ProductRelationChild> productRelationChild) {
        this.productRelationChild = productRelationChild;
    }

    /**
     * Gets the product region.
     *
     * @return the product region
     */
    public final ProductRegion getProductRegion() {
        return productRegion;
    }

    /**
     * Sets the product region.
     *
     * @param productRegion
     *            the new product region
     */
    public final void setProductRegion(final ProductRegion productRegion) {
        this.productRegion = productRegion;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public final Title getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title
     *            the new title
     */
    public final void setTitle(final Title title) {
        this.title = title;
    }

}
