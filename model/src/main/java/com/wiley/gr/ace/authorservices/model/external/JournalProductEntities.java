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
public class JournalProductEntities {

    /** The product contributor. */
    @XmlElement(name = "PRODUCT_CONTRIBUTOR")
    private List<ProductContributor> productContributor;

    /** The price. */
    @XmlElement(name = "PRICE")
    private List<Price> price;

    /** The identifier. */
    @XmlElement(name = "IDENTIFIER")
    private List<Identifier> identifier;

    /** The product codes. */
    @XmlElement(name = "PRODUCT_CODES")
    private List<ProductCodes> productCodes;

    /** The product. */
    @XmlElement(name = "PRODUCT")
    private Product product;

    /** The product extension. */
    @XmlElement(name = "PRODUCT_EXTENSION")
    private List<ProductExtension> productExtension;

    /** The product relation parent. */
    @XmlElement(name = "PRODUCT_RELATION_PARENT")
    private List<ProductRelationParent> productRelationParent;

    /** The product images. */
    @XmlElement(name = "PRODUCT_IMAGES")
    private List<ProductImages> productImages;

    /** The product region. */
    @XmlElement(name = "PRODUCT_REGION")
    private ProductRegion productRegion;

    /** The product status. */
    @XmlElement(name = "PRODUCT_STATUS")
    private ProductStatus productStatus;

    /** The product url. */
    @XmlElement(name = "PRODUCT_URL")
    private List<ProductUrl> productUrl;

    /** The title. */
    @XmlElement(name = "TITLE")
    private List<Title> title;

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
     * Gets the price.
     *
     * @return the price
     */
    public final List<Price> getPrice() {
        return price;
    }

    /**
     * Sets the price.
     *
     * @param price
     *            the new price
     */
    public final void setPrice(final List<Price> price) {
        this.price = price;
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
     * Gets the product codes.
     *
     * @return the product codes
     */
    public final List<ProductCodes> getProductCodes() {
        return productCodes;
    }

    /**
     * Sets the product codes.
     *
     * @param productCodes
     *            the new product codes
     */
    public final void setProductCodes(final List<ProductCodes> productCodes) {
        this.productCodes = productCodes;
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
     * Gets the product relation parent.
     *
     * @return the product relation parent
     */
    public final List<ProductRelationParent> getProductRelationParent() {
        return productRelationParent;
    }

    /**
     * Sets the product relation parent.
     *
     * @param productRelationParent
     *            the new product relation parent
     */
    public final void setProductRelationParent(
            final List<ProductRelationParent> productRelationParent) {
        this.productRelationParent = productRelationParent;
    }

    /**
     * Gets the product images.
     *
     * @return the product images
     */
    public final List<ProductImages> getProductImages() {
        return productImages;
    }

    /**
     * Sets the product images.
     *
     * @param productImages
     *            the new product images
     */
    public final void setProductImages(final List<ProductImages> productImages) {
        this.productImages = productImages;
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
     * Gets the product status.
     *
     * @return the product status
     */
    public final ProductStatus getProductStatus() {
        return productStatus;
    }

    /**
     * Sets the product status.
     *
     * @param productStatus
     *            the new product status
     */
    public final void setProductStatus(final ProductStatus productStatus) {
        this.productStatus = productStatus;
    }

    /**
     * Gets the product url.
     *
     * @return the product url
     */
    public final List<ProductUrl> getProductUrl() {
        return productUrl;
    }

    /**
     * Sets the product url.
     *
     * @param productUrl
     *            the new product url
     */
    public final void setProductUrl(final List<ProductUrl> productUrl) {
        this.productUrl = productUrl;
    }

    /**
     * Gets the title.
     *
     * @return the title
     */
    public final List<Title> getTitle() {
        return title;
    }

    /**
     * Sets the title.
     *
     * @param title
     *            the new title
     */
    public final void setTitle(final List<Title> title) {
        this.title = title;
    }

}
