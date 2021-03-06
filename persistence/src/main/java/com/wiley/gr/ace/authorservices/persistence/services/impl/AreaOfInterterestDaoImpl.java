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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wiley.gr.ace.authorservices.persistence.entity.AreaOfInterest;
import com.wiley.gr.ace.authorservices.persistence.services.AreaOfInterterestDao;

/**
 * The Class AreaOfInterterestDaoImpl.
 */
public class AreaOfInterterestDaoImpl implements AreaOfInterterestDao {
    
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AreaOfInterterestDaoImpl.class);

    /**
     * this method calls db to get interest details.
     *
     * @return the area of interest
     */
    @SuppressWarnings("unchecked")
    @Override
    public final List<AreaOfInterest> getAreaOfInterest() {

        LOGGER.info("Inside getAreaOfInterest() ");
        Session session = null;
        List<AreaOfInterest> interestList = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(AreaOfInterest.class);
            interestList = criteria.list();

        } finally {
            if (null != session) {
                session.flush();
                session.clear();
                session.close();

            }

        }
        return interestList;
    }

}
