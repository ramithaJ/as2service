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

package com.wiley.gr.ace.authorservices.model;

import java.io.File;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class ProfilePicture {
    
    @NotBlank
    @NotNull
    private String userId;
    @NotNull
    private File image;

    /**
     * @return the userId
     */
    public final String getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public final void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the image
     */
    public final File getImage() {
        return image;
    }

    /**
     * @param image the image to set
     */
    public final void setImage(File image) {
        this.image = image;
    }

}
