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

import org.hibernate.Query;
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
        List<Object[]> list = new ArrayList<Object[]>();
        List<RolePermissions> daoPermissionsList = new ArrayList<RolePermissions>();
        
        try {
            session = con.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            
            if(roles.getRoleId() != null && roles.getRoleId() != 0) {
	            Roles daoRoles = (Roles) session.get(Roles.class, roles.getRoleId());
	            
	            daoRoles.setDescription(roles.getDescription());
	            
	            session.saveOrUpdate(daoRoles);
            } else {
            	session.saveOrUpdate(roles);
            }
            
            Query query = session.createSQLQuery("select * from role_permissions where role_id = :roleId").setParameter("roleId", roles.getRoleId().toString());
            list = query.list();
            
//            String hql = "from RolePermissions where id.roleId = :roleId";
//            List<RolePermissions> daoPermissionsList = session.createQuery(hql)
//                    .setInteger("roleId", roles.getRoleId()).list();
            
            for (Object[] object : list) {
                
                RolePermissions rolePermissions = new RolePermissions();
                RolePermissionsId rolePermissionsId = new RolePermissionsId();
                rolePermissionsId.setRoleId(Integer.valueOf(object[0].toString()));
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
                rolePermissionsId.setPermissionCd(permissions.getPermissionCd());
                
                rolePermissions.setId(rolePermissionsId);
                
                session.saveOrUpdate(rolePermissions);
                
            }
            
            for (Map.Entry<String, RolePermissions> entry : daoPermissionsMap
                    .entrySet()) {
                Query deleteQuery = session.createSQLQuery("delete from role_permissions where permission_cd = :permissionCd").setParameter("permissionCd", entry.getValue().getId().getPermissionCd());
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
    
}
