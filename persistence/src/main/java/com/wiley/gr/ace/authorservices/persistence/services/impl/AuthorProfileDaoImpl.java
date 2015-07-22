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

package com.wiley.gr.ace.authorservices.persistence.services.impl;

import static com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection.getSessionFactory;

import java.sql.Blob;

import org.hibernate.Session;

import com.wiley.gr.ace.authorservices.persistence.entity.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.services.AuthorProfileDao;

/**
 * The Class AuthorProfileDaoImpl.
 * @author virtusa version 1.0
 */
public class AuthorProfileDaoImpl  implements AuthorProfileDao{

   /** This method will call db and update image in db
    * 
    * @param image
    * */
    @Override
    public void saveProfilePicture(byte[] image ,String userId) {
        
        Session session = null;
        try {

            session = getSessionFactory().openSession();
            session.beginTransaction();
            UserProfile userProfile=(UserProfile) session.get(UserProfile.class, Integer.parseInt(userId));
            System.err.println(userProfile.getMiddleName());
            Blob blob = new javax.sql.rowset.serial.SerialBlob(image);
            userProfile.setProfilePic(blob);
            session.save(userProfile);
            session.getTransaction().commit();
            

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
        
    }

