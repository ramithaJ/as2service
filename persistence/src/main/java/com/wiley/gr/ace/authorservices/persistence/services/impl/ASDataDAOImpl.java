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
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.wiley.gr.ace.authorservices.persistence.entity.LookupValues;
import com.wiley.gr.ace.authorservices.persistence.entity.Permissions;
import com.wiley.gr.ace.authorservices.persistence.entity.RolePermissions;
import com.wiley.gr.ace.authorservices.persistence.entity.RolePermissionsId;
import com.wiley.gr.ace.authorservices.persistence.entity.Roles;
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
     * This method gets the List of Roles of User from AS 2.0 DB.
     * 
     * @param roleId
     *            to Retrieve.
     * @return the List of Roles.
     */
    @Override
    public final List<Roles> getUserRoles(final String roleId) {

        Session session = null;
        List<Roles> list = new ArrayList<Roles>();
        String hql = null;

        try {

            session = getSessionFactory().openSession();

            if (roleId == null) {

                hql = "from Roles";
                list = session.createQuery(hql).list();

            } else {
                hql = "from Roles where roleId = :roleId";
                list = session.createQuery(hql).setString("roleId", roleId)
                        .list();
            }

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return list;
    }

    /**
     * This method gets the List of Roles of Admin from AS 2.0 DB.
     * 
     * @param roleType
     *            to Retrieve.
     * @return the List of Roles.
     */
    @Override
    public final List<Roles> getAdminRoles(final String roleType) {

        Session session = null;
        List<Roles> list = new ArrayList<Roles>();
        String hql = null;
        try {

            session = getSessionFactory().openSession();

            if (roleType == null) {

                hql = "from Roles";
                list = session.createQuery(hql).list();

            } else {
                hql = "from Roles where roleType = :roleType";
                list = session.createQuery(hql).setString("roleType", roleType)
                        .list();
            }

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return list;
    }

    /**
     * This method gets all the permissions from AS 2.0 DB.
     * 
     * @return the List of Permissions.
     */
    public final List<Permissions> getPermissions() {

        Session session = null;
        List<Permissions> list = new ArrayList();

        try {

            session = getSessionFactory().openSession();

            String hql = "from Permissions";

            list = session.createQuery(hql).list();

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return list;
    }

    /**
     * This method gets the Role Permissions Mappings for all roles from AS 2.0
     * DB.
     * 
     * @param roleId
     *            to Retrieve.
     * @return the List of Role Permissions.
     */
    @Override
    public final List<RolePermissions> getRolePermissionMappings(
            final String roleId) {

        Session session = null;
        List<Object[]> list = new ArrayList<Object[]>();
        List<RolePermissions> returnList = new ArrayList<RolePermissions>();

        try {

            session = getSessionFactory().openSession();

            if (roleId == null) {

                Query query = session
                        .createSQLQuery("select * from role_permissions");
                list = query.list();

            } else {

                Query query = session
                        .createSQLQuery(
                                "select * from role_permissions where role_id = :roleId")
                        .setParameter("roleId", roleId);
                list = query.list();
            }

            for (Object[] object : list) {

                RolePermissions rolePermissions = new RolePermissions();
                RolePermissionsId rolePermissionsId = new RolePermissionsId();
                rolePermissionsId.setRoleId(Integer.valueOf(object[0]
                        .toString()));
                rolePermissionsId.setPermissionCd(object[1].toString());
                rolePermissions.setId(rolePermissionsId);
                returnList.add(rolePermissions);
            }

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return returnList;
    }

    /**
     * This method gets the count of Roles.
     * 
     * @param roleId
     *            to Retrieve.
     * @return the count
     */
    @Override
    public final int getCount(final int roleId) {
        Session session = null;
        List list = new ArrayList();
        int count = 0;
        session = getSessionFactory().openSession();
        Query query = session.createSQLQuery(
                "select * from ROLE_PERMISSIONS  where ROLE_ID = :roleId")
                .setParameter("roleId", roleId);
        list = query.list();
        count = list.size();
        return count;
    }

}
