/**
 * 
 */
package com.wiley.gr.ace.authorservices.model.external;

/**
 * @author kalyancj
 *
 */
public class Payment {
	private CreditCard creditCard;

	private String paymentMethod;

	public CreditCard getCreditCard() {
		return creditCard;
	}

	public void setCreditCard(CreditCard creditCard) {
		this.creditCard = creditCard;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "ClassPojo [creditCard = " + creditCard + ", paymentMethod = "
				+ paymentMethod + "]";
	}
}
