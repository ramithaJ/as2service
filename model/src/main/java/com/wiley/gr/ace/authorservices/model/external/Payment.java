/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author virtusa version 1.0
 * 
 */
public class Payment {

    /** The credit card. */
    private CreditCard creditCard;

    /** The payment method. */
    private String paymentMethod;

    /**
     * @return the creditCard
     */
    public CreditCard getCreditCard() {
        return creditCard;
    }

    /**
     * @param creditCard
     *            the creditCard to set
     */
    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    /**
     * @return the paymentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod
     *            the paymentMethod to set
     */
    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "ClassPojo [creditCard = " + creditCard + ", paymentMethod = "
                + paymentMethod + "]";
    }
}
