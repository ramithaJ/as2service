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

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.wiley.gr.ace.authorservices.persistence.entity.Societies;
import com.wiley.gr.ace.authorservices.persistence.services.SocietyDao;

/**
 * The Class SocietyDaoImpl.
 * 
 * @author virtusa version 1.0
 */
public class SocietyDaoImpl implements SocietyDao {

    /** This method is calling Db to get society details */
    @SuppressWarnings("unchecked")
    @Override
    public final List<Societies> getSociety() {
        Session session = null;
        ArrayList<Societies> societyList = new ArrayList<Societies>();

        try {
            session = getSessionFactory().openSession();

            societyList = (ArrayList<Societies>) session.createCriteria(
                    Societies.class).list();

        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
        return societyList;

    }
}
