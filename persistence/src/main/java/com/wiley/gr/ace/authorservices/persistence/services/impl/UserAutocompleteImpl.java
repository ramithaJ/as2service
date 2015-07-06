package com.wiley.gr.ace.authorservices.persistence.services.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Projections;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.Societies;
import com.wiley.gr.ace.authorservices.persistence.services.UserAutocomplete;

public class UserAutocompleteImpl implements UserAutocomplete {

    /**
     * This method gets data from LOOKUP_VALUES table with a key.
     *
     * @param lookupKey
     *            to Retrieve.
     * @return the List of LookupValues.
     */
    @SuppressWarnings("unchecked")
    @Override
    public final List<String> getSocietyDetails() {
        List<String> societyList = null;
        Session session = null;
        try {
            session = HibernateConnection.getSessionFactory().openSession();

            societyList = session.createCriteria(Societies.class)
                    .setProjection(Projections.property("societyName")).list();

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return societyList;
    }
}
