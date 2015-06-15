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

import java.util.List;

import org.hibernate.Session;

import com.wiley.gr.ace.authorservices.persistence.entity.LookupValues;
import com.wiley.gr.ace.authorservices.persistence.services.LookUpValuesDAO;

/**
 * @author virtusa version 1.0
 */
public class LookupValuesDAOImpl implements LookUpValuesDAO {

    /**
     * This method gets data from LOOKUP_VALUES table with a key.
     * 
     * @param lookupKey
     *            to Retrieve.
     * @return the List of LookupValues.
     */
    @Override
    public final List<LookupValues> getLookUpData(final String lookupKey) {

        List<LookupValues> lookupList = null;
        Session session = null;
        try {
            session = getSessionFactory().openSession();

            String hql = "from LookupValues where lookupKey = :lookupKey";
            lookupList = session.createQuery(hql)
                    .setString("lookupKey", lookupKey).list();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return lookupList;
    }

}
