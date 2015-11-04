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

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import javax.sql.rowset.serial.SerialException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.UserException;
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
    public final List<UserAffiliations> getAffiliationList(final String userId) {
        AuthorProfileDaoImpl.LOGGER.info("inside getAffiliationsList method ");

        Session session = null;
        List<UserAffiliations> affiliationList = null;
        try {

            session = getSessionFactory().openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(UserAffiliations.class);
            criteria.add(Restrictions.eq("participantId",
                    UUID.fromString(userId)));
            affiliationList = criteria.list();
            System.err.println(affiliationList);
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
    public final boolean deleteAffiliations(final String userId,
            final String affiliationId) {
        AuthorProfileDaoImpl.LOGGER.info("inside deleteAffiliations method ");

        Session session = null;
        boolean isDeleted = false;
        try {

            session = getSessionFactory().openSession();
            session.beginTransaction();
            Criteria criteria = session.createCriteria(UserAffiliations.class);
            criteria.add(Restrictions.eq("participantId",
                    UUID.fromString(userId)));
            criteria.add(Restrictions.eq("affiliationId",
                    Long.parseLong(affiliationId)));
            UserAffiliations userAffiliations = (UserAffiliations) criteria
                    .uniqueResult();
            if (!StringUtils.isEmpty(userAffiliations)) {
                session.delete(userAffiliations);
            }
            session.getTransaction().commit();
            isDeleted = true;
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            session.getTransaction().rollback();
            throw new UserException();
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
     * @throws SQLException
     * @throws SerialException
     * @throws Exception
     *             the exception
     */
    @Override
    public final boolean updateAffiliation(final String userId,
            final Affiliation affiliation,final String affiliationId) throws Exception {
        AuthorProfileDaoImpl.LOGGER.info("inside updateAffiliation method ");
        Session session = null;
        boolean isUpdated = false;
        UserAffiliations userAffiliation = new UserAffiliations();
        if (!"0".equals(affiliationId)) {
            userAffiliation.setAffiliationId(Long.valueOf(affiliationId));
        }
        String startDate = affiliation.getStartDate();
        if (!StringUtils.isEmpty(startDate)) {
            userAffiliation.setStartDt(new Date(Long.parseLong(startDate)));
        }
        String endDate = affiliation.getEndDate();
        if (!StringUtils.isEmpty(endDate)) {
            userAffiliation.setEndDt(new Date(Long.parseLong(endDate)));
        }
        userAffiliation.setParticipantId(UUID.fromString(userId));
        userAffiliation.setTownOrCityName(affiliation.getCity());
        userAffiliation.setStateOrProvinceName(affiliation.getState());
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
