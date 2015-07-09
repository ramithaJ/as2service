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
 ******************************************************************************/
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.Societies;
import com.wiley.gr.ace.authorservices.persistence.services.UserAutocomplete;

/**
 * The Class UserAutocompleteImpl.
 * 
 * @author virtusa version 1.0
 */
public class UserAutocompleteImpl implements UserAutocomplete {

    /**
     * This method gets data from LOOKUP_VALUES table with a key.
     *
     * @return the List of LookupValues.
     */
    @SuppressWarnings("unchecked")
    @Override
    public final List<String> getSocietyDetails() {
        List<String> societyList = null;
        Session session = null;
        try {
            session = HibernateConnection.getSessionFactory().openSession();

            societyList = session.createCriteria(Societies.class)
                    .setProjection(Projections.property("societyName")).list();

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return societyList;
    }
}
