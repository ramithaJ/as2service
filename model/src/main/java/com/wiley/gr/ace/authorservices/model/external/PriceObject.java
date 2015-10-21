package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author virtusa version1.0
 *
 */
public class PriceObject {

    /** The price. */
    private String price;

    /** The currency. */
    private String currency;

    /**
     * @return the price
     */
    public String getPrice() {
        return price;
    }

    /**
     * @param price
     *            the price to set
     */
    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency
     *            the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

}
