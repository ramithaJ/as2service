/**
 * ****************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 * <p>
 * All material contained herein is proprietary to John Wiley & Sons
 * and its third party suppliers, if any. The methods, techniques and
 * technical concepts contained herein are considered trade secrets
 * and confidential and may be protected by intellectual property laws.
 * Reproduction or distribution of this material, in whole or in part,
 * is strictly forbidden except by express prior written permission
 * of John Wiley & Sons.
 * *****************************************************************************
 */
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import static com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection.getSessionFactory;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.wiley.gr.ace.authorservices.model.ResearchFunder;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunderGrants;
import com.wiley.gr.ace.authorservices.persistence.entity.UserFunders;
import com.wiley.gr.ace.authorservices.persistence.services.ResearchFunderDAO;

/**
 * @author virtusa version 1.0
 *
 */
public class ResearchFunderDAOImpl implements ResearchFunderDAO {

    @Override
    public List<UserFunders> getResearchFunders(final UUID participantId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session.createCriteria(UserFunders.class);
            criteria.add(Restrictions.eq("participantId", participantId));
            return criteria.list();
        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
    }

    @Override
    public boolean updateResearchFunder(final String participantId,
            final ResearchFunder researchFunder) {

        deleteGrants(researchFunder.getSeqId());

        UUID participantUUID = UUID.fromString(participantId);
        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            UserFunders userFunders = (UserFunders) session.get(
                    UserFunders.class, researchFunder.getSeqId());
            userFunders.setParticipantId(participantUUID);
            userFunders.setFunderDoi(researchFunder.getResearchFunderId());
            userFunders.setFunderName(researchFunder.getResearchFunderName());

            Set<UserFunderGrants> userFunderGrantsSet = new HashSet<UserFunderGrants>();
            UserFunderGrants userFunderGrants = null;
            Set<String> grantsList = researchFunder.getGrantNumber();
            for (String grant : grantsList) {
                userFunderGrants = new UserFunderGrants();
                userFunderGrants.setGrantNum(grant);
                userFunderGrants.setUserFunders(userFunders);
                userFunderGrantsSet.add(userFunderGrants);
            }

            userFunders.setUserFunderGrantses(userFunderGrantsSet);
            userFunders.setUpdatedBy(participantUUID);
            userFunders.setUpdatedDate(new Date());

            session.update(userFunders);
            session.getTransaction().commit();

        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean deleteResearchFunder(final Long researchFunderSeqId) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            UserFunders userFunders = new UserFunders();
            userFunders.setUserFunderId(researchFunderSeqId);
            session.delete(userFunders);
            session.getTransaction().commit();
        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean addResearchFunder(final UserFunders userFunders) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.save(userFunders);
            session.getTransaction().commit();

        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
        return true;
    }

    @Override
    public boolean deleteGrants(final Long userFunderId) {

        Session session = null;

        String hql = "delete from UserFunderGrants where userFunders.userFunderId = :userFunderId";

        try {
            session = getSessionFactory().openSession();
            session.beginTransaction();
            session.createQuery(hql)
                    .setString("userFunderId", userFunderId.toString())
                    .executeUpdate();
            session.getTransaction().commit();
        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
        return true;
    }

}
