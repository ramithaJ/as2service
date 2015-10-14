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

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.wiley.gr.ace.authorservices.model.Society;
import com.wiley.gr.ace.authorservices.persistence.entity.Societies;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSocietyDetails;
import com.wiley.gr.ace.authorservices.persistence.services.SocietyDao;

/**
 * The Class SocietyDaoImpl.
 * 
 * @author virtusa version 1.0
 */
public class SocietyDaoImpl implements SocietyDao {

    /**
     * This method is calling Db to get society details.
     *
     * @return the society
     */
    @SuppressWarnings("unchecked")
    @Override
    public final List<Societies> getSociety() {
        Session session = null;
        ArrayList<Societies> societyList = null;

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

    @Override
    public boolean updateSociety(final String userId, final Society society) {

        Session session = null;
        try {
            session = getSessionFactory().openSession();
            UserSocietyDetails userSocietyDetails = (UserSocietyDetails) session
                    .get(UserSocietyDetails.class, society.getId());
            userSocietyDetails.setParticipantId(userId.getBytes());

            Societies societies = new Societies();
            societies.setSocietyCd(society.getSocietyId());
            userSocietyDetails.setSocieties(societies);

            userSocietyDetails.setSocietyName(society.getSocietyName());
            userSocietyDetails.setMembershipNo(society.getMembershipNumber());
            userSocietyDetails.setPromoCode(society.getPromoCode());
            userSocietyDetails.setStartDt(null); // need to convert string to
                                                 // date type
            userSocietyDetails.setEndDt(null); // need to convert string to date
                                               // type
            userSocietyDetails.setUpdatedDate(null); // need to update date
            userSocietyDetails.setUpdatedBy(null); // need to update type

            session.update(userSocietyDetails);

        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
        return true;
    }

    @Override
    public List<UserSocietyDetails> getSocietyDetails(final String participantId) {

        Session session = null;

        try {
            session = getSessionFactory().openSession();
            Criteria criteria = session
                    .createCriteria(UserSocietyDetails.class);
            criteria.add(Restrictions.eq("participantId",
                    participantId.getBytes()));
            return criteria.list();

        } finally {
            if (null != session) {
                session.flush();
                session.close();
            }
        }
    }
}
