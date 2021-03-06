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

import com.wiley.gr.ace.authorservices.persistence.entity.Alerts;
import com.wiley.gr.ace.authorservices.persistence.services.AlertsDao;

/**
 * The Class AlertsDaoImpl.
 */
public class AlertsDaoImpl implements AlertsDao {

    /**
     * calling dao to get details from alerts table.
     * 
     * @return list of alerts.
     * 
     * */
    @SuppressWarnings("unchecked")
    @Override
    public final List<Alerts> getAlerts() {
        Session session = null;
        Criteria criteria = null;
        List<Alerts> alertsList = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            criteria = session.createCriteria(Alerts.class);
            alertsList = criteria.list();
        } finally {
            if (null != session) {
                session.flush();
                session.getTransaction().commit();
                session.close();
            }
        }

        return alertsList;
    }

}
