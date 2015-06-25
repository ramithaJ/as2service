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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Value;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.persistence.entity.Permissions;
import com.wiley.gr.ace.authorservices.persistence.entity.RolePermissions;
import com.wiley.gr.ace.authorservices.persistence.entity.RolePermissionsId;
import com.wiley.gr.ace.authorservices.persistence.entity.Roles;
import com.wiley.gr.ace.authorservices.persistence.services.UserRolesDAO;

/**
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
     * This method is used to add or update user roles and permissions.
     * 
     * @param roles
     *            to add or update roles.
     * @param permissionsList
     *            to add or update permissions.
     */
    @Override
    public final void addOrUpdateUserRoles(final Roles roles,
            final List<Permissions> permissionsList) {

        Session session = null;
        Transaction transaction = null;
        List<Object[]> list = new ArrayList<Object[]>();
        List<RolePermissions> daoPermissionsList = new ArrayList<RolePermissions>();

        try {
            session = getSessionFactory().openSession();
            transaction = session.beginTransaction();

            if (roles.getRoleId() != null && roles.getRoleId() != 0) {
                Roles daoRoles = (Roles) session.get(Roles.class,
                        roles.getRoleId());

                daoRoles.setDescription(roles.getDescription());

                session.saveOrUpdate(daoRoles);
            } else {
                session.saveOrUpdate(roles);
            }

            Query query = session.createSQLQuery(
                    "select * from role_permissions where role_id = :roleId")
                    .setParameter("roleId", roles.getRoleId().toString());
            list = query.list();

            // String hql = "from RolePermissions where id.roleId = :roleId";
            // List<RolePermissions> daoPermissionsList =
            // session.createQuery(hql)
            // .setInteger("roleId", roles.getRoleId()).list();

            for (Object[] object : list) {

                RolePermissions rolePermissions = new RolePermissions();
                RolePermissionsId rolePermissionsId = new RolePermissionsId();
                rolePermissionsId.setRoleId(Integer.valueOf(object[0]
                        .toString()));
                rolePermissionsId.setPermissionCd(object[1].toString());
                rolePermissions.setId(rolePermissionsId);
                daoPermissionsList.add(rolePermissions);
            }

            List<Permissions> addList = new ArrayList<Permissions>();

            Map<String, RolePermissions> daoPermissionsMap = new HashMap<String, RolePermissions>();

            for (RolePermissions rolePermissions : daoPermissionsList) {

                daoPermissionsMap.put(
                        rolePermissions.getId().getPermissionCd(),
                        rolePermissions);

            }

            for (Permissions permissions : permissionsList) {

                if (daoPermissionsMap
                        .containsKey(permissions.getPermissionCd())) {
                    daoPermissionsMap.remove(permissions.getPermissionCd());
                } else {
                    addList.add(permissions);
                }
            }

            for (Permissions permissions : addList) {

                RolePermissions rolePermissions = new RolePermissions();
                RolePermissionsId rolePermissionsId = new RolePermissionsId();
                rolePermissionsId.setRoleId(roles.getRoleId());
                rolePermissionsId
                        .setPermissionCd(permissions.getPermissionCd());

                rolePermissions.setId(rolePermissionsId);

                session.saveOrUpdate(rolePermissions);

            }

            for (Map.Entry<String, RolePermissions> entry : daoPermissionsMap
                    .entrySet()) {
                Query deleteQuery = session
                        .createSQLQuery(
                                "delete from role_permissions where permission_cd = :permissionCd")
                        .setParameter("permissionCd",
                                entry.getValue().getId().getPermissionCd());
                deleteQuery.executeUpdate();
            }

            transaction.commit();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

    }

    /**
     * This checks the role name.
     * 
     * @param roleName
     *            to check.
     */
    public final void checkRoleName(final String roleName) {
        List list = new ArrayList();
        Session session = getSessionFactory().openSession();
        try {
            Query query = session.createSQLQuery(
                    "select * from roles where role_name = :rolename")
                    .setParameter("rolename", roleName);

            list = query.list();

            if (!(list.isEmpty()) || list == null) {
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
