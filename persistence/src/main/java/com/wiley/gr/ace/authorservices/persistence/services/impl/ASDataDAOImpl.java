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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.wiley.gr.ace.authorservices.persistence.entity.LookupValues;
import com.wiley.gr.ace.authorservices.persistence.entity.Societies;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;

/**
 * The Class ASDataDAOImpl.
 *
 * @author virtusa version 1.0
 */
public class ASDataDAOImpl implements ASDataDAO {
    /**
     * This method gets the List of LookupValues from AS 2.0 DB.
     * 
     * @param keyName
     *            to Retrieve.
     * @return the List of Lookup Values.
     */
    @SuppressWarnings("unchecked")
    @Override
    public final List<LookupValues> getDropDown(final String keyName) {

        Session session = null;
        List<LookupValues> lookupList = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(LookupValues.class);
            criteria.add(Restrictions.eq("lookupKey", keyName));
            lookupList = criteria.list();
            return lookupList;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * This method gets the count of Roles.
     * 
     * @param roleId
     *            to Retrieve.
     * @return the count
     */
    @SuppressWarnings("rawtypes")
    @Override
    public final int getCount(final int roleId) {
        Session session = null;
        List list = null;
        int count = 0;
        session = getSessionFactory().openSession();
        Query query = session.createSQLQuery(
                "select * from ROLE_PERMISSIONS  where ROLE_ID = :roleId")
                .setParameter("roleId", roleId);
        list = query.list();
        count = list.size();
        return count;
    }

    /**
     * Gets the data.
     *
     * @param id
     *            request value
     * @return String response value
     */
    @Override
    public final String getData(final String id) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(LookupValues.class);
            criteria.add(Restrictions.eq("lookupName", id));
            LookupValues lookupValues = (LookupValues) criteria.uniqueResult();
            if (null == lookupValues) {
                return null;
            }
            return lookupValues.getLookupValue();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * This method is calling Db to get society details.
     *
     * @return the society
     */
    @SuppressWarnings("unchecked")
    @Override
    public final List<Societies> getSociety() {
        Session session = null;
        List<Societies> societyList = null;

        try {
            session = getSessionFactory().openSession();

            societyList = session.createCriteria(Societies.class).list();

        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
        return societyList;

    }

}
