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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import static com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection.getSessionFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wiley.gr.ace.authorservices.exception.LicenseException;
import com.wiley.gr.ace.authorservices.persistence.entity.LicenseUploadDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedLicenses;
import com.wiley.gr.ace.authorservices.persistence.services.LicenseDAO;

/**
 * The Class LicenseDAOImpl.
 * 
 * @author virtusa version 1.0
 */
public class LicenseDAOImpl implements LicenseDAO {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(LicenseDAOImpl.class);

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.LicenseDAO#saveLicense
     * (com.wiley.gr.ace.authorservices.persistence.entity.SavedLicenses)
     */
    @Override
    public Integer saveLicense(SavedLicenses savedLicenses) {
        Session session = null;
        Integer licenseId = null;
        try {
            session = getSessionFactory().getCurrentSession();
            session.beginTransaction();
            session.save(savedLicenses);
            session.getTransaction().commit();
            licenseId = savedLicenses.getLicenseId();
        } catch (final Exception e) {
            LOGGER.error("Print Stack Trace- ", e);
            if (null != session) {
                session.getTransaction().rollback();
            }
            throw new LicenseException("ERROR_SAVING_LICENSE",
                    "error saving the license");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return licenseId;
    }

    /**
     * Gets the l license upload details.
     *
     * @param dhId
     *            the dh id
     * @return the l license upload details
     */
    @Override
    public LicenseUploadDetails getlLicenseUploadDetails(final String dhId) {
        LOGGER.info("inside getlLicenseUploadDetails Method of LicenseDAOImpl");
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(
                    LicenseUploadDetails.class, "licenseUploadDetails");
            criteria.createAlias("licenseUploadDetails.savedLicenses",
                    "savedLicenses");
            criteria.createAlias("savedLicenses.products", "products");
            criteria.add(Restrictions.eq("products.dhId",
                    Integer.parseInt(dhId)));
            return (LicenseUploadDetails) criteria.uniqueResult();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }
}
