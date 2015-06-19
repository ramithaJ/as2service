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
package com.wiley.gr.ace.authorservices.model;

import java.util.List;

public class QuoteDetail {

    private List<Prices> prices;

    /**
     * @return the prices
     */
    public final List<Prices> getPrices() {
        return prices;
    }

    /**
     * @param prices the prices to set
     */
    public final void setPrices(List<Prices> prices) {
        this.prices = prices;
    }

    
}
