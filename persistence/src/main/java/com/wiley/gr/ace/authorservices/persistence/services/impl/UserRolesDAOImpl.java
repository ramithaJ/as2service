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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.Permissions;
import com.wiley.gr.ace.authorservices.persistence.entity.RolePermissions;
import com.wiley.gr.ace.authorservices.persistence.entity.RolePermissionsId;
import com.wiley.gr.ace.authorservices.persistence.entity.Roles;
import com.wiley.gr.ace.authorservices.persistence.services.UserRolesDAO;

/**
 * @author sarmakumarap
 */
public class UserRolesDAOImpl implements UserRolesDAO {
    
    @Autowired(required = true)
    HibernateConnection con;
    
    /*
     * (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.persistence.services.UserRolesDAO#
     * addOrUpdateUserRoles
     * (com.wiley.gr.ace.authorservices.persistence.entity.UserRoles,
     * java.util.List)
     */
    @Override
    public void addOrUpdateUserRoles(Roles roles,
            List<Permissions> permissionsList) {
        
        Session session = null;
        Transaction transaction = null;
        try {
            session = con.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            session.saveOrUpdate(roles);
            
            String hql = "from RolePermissions where id.roleId = :roleId";
            List<RolePermissions> daoPermissionsList = session.createQuery(hql)
                    .setInteger("roleId", roles.getRoleId()).list();
            
            List<Permissions> addList = new ArrayList<Permissions>();
            
            Map<Integer, RolePermissions> daoPermissionsMap = new HashMap<Integer, RolePermissions>();
            
            for (RolePermissions rolePermissions : daoPermissionsList) {
                
                daoPermissionsMap.put(
                        rolePermissions.getId().getPermissionId(),
                        rolePermissions);
                
            }
            
            for (Permissions permissions : permissionsList) {
                
                if (daoPermissionsMap
                        .containsKey(permissions.getPermissionId())) {
                    daoPermissionsMap.remove(permissions.getPermissionId());
                } else {
                    addList.add(permissions);
                }
            }
            
            for (Permissions permissions : addList) {
                
                RolePermissions rolePermissions = new RolePermissions();
                
                rolePermissions.setId(new RolePermissionsId(roles.getRoleId(),
                        permissions.getPermissionId()));
                
                session.saveOrUpdate(rolePermissions);
                
            }
            
            for (Map.Entry<Integer, RolePermissions> entry : daoPermissionsMap
                    .entrySet()) {
                session.delete(entry.getValue());
            }
            
            transaction.commit();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        
    }
    
}
