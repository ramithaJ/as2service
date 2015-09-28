/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p/>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.model.external;

/**
 * The Class Customer.
 *
 * @author virtusa version 1.0
 */
public class Customer {

    /** The e core customer account id part1. */
    private String eCoreCustomerAccountIdPart1;
    
    /** The e core customer account id part2. */
    private String eCoreCustomerAccountIdPart2;
    
    /** The author id. */
    private String authorId;

    /**
     * Gets the e core customer account id part1.
     *
     * @return the e core customer account id part1
     */
    public final String geteCoreCustomerAccountIdPart1() {
        return eCoreCustomerAccountIdPart1;
    }

    /**
     * Gets the e core customer account id part2.
     *
     * @return the e core customer account id part2
     */
    public final String geteCoreCustomerAccountIdPart2() {
        return eCoreCustomerAccountIdPart2;
    }

    /**
     * Gets the author id.
     *
     * @return the author id
     */
    public final String getAuthorId() {
        return authorId;
    }

    /**
     * Sets the e core customer account id part1.
     *
     * @param eCoreCustomerAccountIdPart1 the new e core customer account id part1
     */
    public final void seteCoreCustomerAccountIdPart1(
            final String eCoreCustomerAccountIdPart1) {
        this.eCoreCustomerAccountIdPart1 = eCoreCustomerAccountIdPart1;
    }

    /**
     * Sets the e core customer account id part2.
     *
     * @param eCoreCustomerAccountIdPart2 the new e core customer account id part2
     */
    public final void seteCoreCustomerAccountIdPart2(
            final String eCoreCustomerAccountIdPart2) {
        this.eCoreCustomerAccountIdPart2 = eCoreCustomerAccountIdPart2;
    }

    /**
     * Sets the author id.
     *
     * @param authorId the new author id
     */
    public final void setAuthorId(final String authorId) {
        this.authorId = authorId;
    }

}
