package com.wiley.gr.ace.authorservices.model.external;

public class ProductPersonRelationObject {

    private String userId;
    private String emailId;
    private String dhId;
    private String productRoleCd;

    public final String getUserId() {
        return userId;
    }

    public final void setUserId(final String userId) {
        this.userId = userId;
    }

    public final String getEmailId() {
        return emailId;
    }

    public final void setEmailId(final String emailId) {
        this.emailId = emailId;
    }

    public final String getDhId() {
        return dhId;
    }

    public final void setDhId(final String dhId) {
        this.dhId = dhId;
    }

    public final String getProductRoleCd() {
        return productRoleCd;
    }

    public final void setProductRoleCd(final String productRoleCd) {
        this.productRoleCd = productRoleCd;
    }
}
