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

import java.nio.charset.StandardCharsets;
import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.UserProfile;
import com.wiley.gr.ace.authorservices.persistence.entity.UserAffiliations;
import com.wiley.gr.ace.authorservices.persistence.services.AuthorProfileDao;

/**
 * The Class AuthorProfileDaoImpl.
 * 
 * @author virtusa version 1.0
 */
public class AuthorProfileDaoImpl implements AuthorProfileDao {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(AuthorProfileDaoImpl.class);

    /**
     * This method will call db and update image in db.
     *
     * @param image
     *            the image
     * @param userId
     *            the user id
     */
    @Override
    public final void saveProfilePicture(final byte[] image, final String userId) {

        Session session = null;
        try {

            session = getSessionFactory().openSession();
            session.beginTransaction();
            UserProfile userProfile = (UserProfile) session.get(
                    UserProfile.class, Integer.valueOf(userId));
            session.save(userProfile);
            session.getTransaction().commit();

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
    }

    /**
     * Gets the affiliation list.
     *
     * @param userId
     *            the user id
     * @return the affiliation list
     * @throws Exception
     *             the exception
     */
    @Override
    public final List<UserAffiliations> getAffiliationList(final String userId)
            throws Exception {
        AuthorProfileDaoImpl.LOGGER.info("inside getAffiliationsList method ");

        Session session = null;
        List<UserAffiliations> affiliationList = null;
        try {

            session = getSessionFactory().openSession();
            session.beginTransaction();
            String hql = "from UserAffiliations a where a.participnatId = :userId";
            affiliationList = session
                    .createQuery(hql)
                    .setBinary("participantId",
                            userId.getBytes(StandardCharsets.UTF_8)).list();

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return affiliationList;

    }

    /**
     * Delete affiliations.
     *
     * @param userId
     *            the user id
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean deleteAffiliations(final String userId)
            throws Exception {
        AuthorProfileDaoImpl.LOGGER.info("inside deleteAffiliations method ");

        Session session = null;
        boolean isDeleted = false;
        try {

            session = getSessionFactory().openSession();
            List<UserAffiliations> affiliationList = getAffiliationList(userId);
            session.beginTransaction();
            for (UserAffiliations af : affiliationList) {
                session.delete(af);
            }
            session.getTransaction().commit();
            isDeleted = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return isDeleted;
    }

    /**
     * Update affiliation.
     *
     * @param userId
     *            the user id
     * @param affiliation
     *            the affiliation
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean updateAffiliation(final String userId,
            final Affiliation affiliation) throws Exception {
        AuthorProfileDaoImpl.LOGGER.info("inside updateAffiliation method ");
        Session session = null;
        boolean isUpdated = false;
        UserAffiliations userAffiliation = new UserAffiliations();
        String affliationId = affiliation.getAffiliationId();
        if (!"0".equals(affliationId)) {
            userAffiliation.setAffiliationId(Long.valueOf(affliationId));
        }
        userAffiliation.setStartDt(new Date(Long.parseLong(affiliation
                .getStartDate())));
        userAffiliation.setEndDt(new Date(Long.parseLong(affiliation
                .getEndDate())));
        userAffiliation.setTownOrCityName(affiliation.getCity());
        userAffiliation.setStateOrProvinceName(affiliation.getStateCode());
        userAffiliation.setCountryCd(affiliation.getCountryCode());
        userAffiliation.setInstitutionCd(affiliation.getInstitutionId());
        userAffiliation.setInstitutionName(affiliation.getInstitutionName());
        userAffiliation.setDepartmentCd(affiliation.getDepartmentId());
        userAffiliation.setDepartmentName(affiliation.getDepartmentName());
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.saveOrUpdate(userAffiliation);
            session.getTransaction().commit();
            isUpdated = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw e;
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return isUpdated;

    }

}
