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
 * @author virtusa
 * version 1.0
 */
public class FundingDetails {
 
    private String woaAccountHolder;
    
    private String researchFunder;
    
    private String grantNumber;
    
    private String grantRecipient;

    public String getWoaAccountHolder() {
        return woaAccountHolder;
    }

    public void setWoaAccountHolder(String woaAccountHolder) {
        this.woaAccountHolder = woaAccountHolder;
    }

    public String getResearchFunder() {
        return researchFunder;
    }

    public void setResearchFunder(String researchFunder) {
        this.researchFunder = researchFunder;
    }

    public String getGrantNumber() {
        return grantNumber;
    }

    public void setGrantNumber(String grantNumber) {
        this.grantNumber = grantNumber;
    }

    public String getGrantRecipient() {
        return grantRecipient;
    }

    public void setGrantRecipient(String grantRecipient) {
        this.grantRecipient = grantRecipient;
    }
    
    
}
