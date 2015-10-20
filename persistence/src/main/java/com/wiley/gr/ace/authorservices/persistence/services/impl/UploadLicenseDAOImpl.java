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

import java.util.Date;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wiley.gr.ace.authorservices.persistence.entity.LicenseUploadDetails;
import com.wiley.gr.ace.authorservices.persistence.entity.SavedLicenses;
import com.wiley.gr.ace.authorservices.persistence.services.UploadLicenseDAO;

/**
 * The Class UploadLicenseDAOImpl.
 */
public class UploadLicenseDAOImpl implements UploadLicenseDAO {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UploadLicenseDAOImpl.class);

    /**
     * View license.
     *
     * @param dhId
     *            the dh id
     * @param userId
     *            the user id
     * @return the string
     * @throws Exception
     *             the exception
     */
    @Override
    public final String viewLicense(final String dhId, final String userId)
            throws Exception {
        LOGGER.info("Inside viewLicense method of UploadLicenseDAOImpl");
        String license = null;
        Session session = null;
        if (!StringUtils.isEmpty(dhId) && !StringUtils.isEmpty(userId)) {
            try {
                session = getSessionFactory().openSession();
            } finally {
                if (session != null) {
                    session.flush();
                    session.close();
                }
            }
        }
        return license;
    }

    /**
     * Upload license.
     *
     * @param dhId
     *            the dh id
     * @param userId
     *            the user id
     * @param file
     *            the file
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean uploadLicense(final String dhId, final String userId,
            final MultipartFile file) throws Exception {
        LOGGER.info("Inside uploadLicense method of UploadLicenseDAOImpl");
        boolean isUpdated = false;
        Session session = null;
        if (!StringUtils.isEmpty(dhId) && !StringUtils.isEmpty(userId)
                && !StringUtils.isEmpty(file)) {
            try {
                session = getSessionFactory().openSession();
                String hql = "from SavedLicenses sl where sl.products.dhId = :dhId"
                        + " and sl.usersByUserId.userId = :userId";
                SavedLicenses savedLicense = (SavedLicenses) session
                        .createQuery(hql).setString("dhId", dhId)
                        .setString("userId", userId).uniqueResult();
                if (!StringUtils.isEmpty(savedLicense)) {
                    LicenseUploadDetails licenseUploadDetails = new LicenseUploadDetails();
                    licenseUploadDetails.setLicenseFile(file.getBytes());
                    Date date = new Date();
                    licenseUploadDetails.setCreatedDate(date);
                    session.beginTransaction();
                    session.save(licenseUploadDetails);
                    session.getTransaction().commit();
                    isUpdated = true;
                }
            } catch (Exception e) {
                session.getTransaction().rollback();
                isUpdated = false;
                throw e;
            } finally {
                if (session != null) {
                    session.flush();
                    session.close();
                }
            }
        }

        return isUpdated;
    }

}
