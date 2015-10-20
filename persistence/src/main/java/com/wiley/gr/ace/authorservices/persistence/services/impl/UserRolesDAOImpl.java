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

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.persistence.services.UserRolesDAO;

/**
 * The Class UserRolesDAOImpl.
 *
 * @author virtusa version 1.0
 */
public class UserRolesDAOImpl implements UserRolesDAO {

    /**
     * The error code for checkRoleName.
     */
    @Value("${UserRolesDAOImpl.checkRoleName.errorcode}")
    private String errorcode;
    /**
     * The error message for checkRoleName.
     */
    @Value("${UserRolesDAOImpl.checkRoleName.errormessage}")
    private String errormessage;

    /**
     * This checks the role name.
     * 
     * @param roleName
     *            to check.
     */
    @Override
    public final void checkRoleName(final String roleName) {
        Session session = getSessionFactory().openSession();
        try {
            Query query = session.createSQLQuery(
                    "select * from roles where role_name = :rolename")
                    .setParameter("rolename", roleName);

            List list = query.list();

            if (!(list.isEmpty())) {
                throw new ASException(errorcode, errormessage);
            }
        } finally {

            if (session != null) {
                session.flush();
                session.close();

            }
        }

    }
}
