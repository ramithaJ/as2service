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
 * @author kpshiva
 */
public class ASDataDAOImpl implements ASDataDAO {
  
    
    @Override
    public List<LookupValues> getDropDown(String keyName) {
        
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
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO#getAdminRoles
     * ()
     */
    @Override
    public List<Roles> getUserRoles(String roleId) {
        
        Session session = null;
        List<Roles> list = new ArrayList();
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
    
    @Override
    public List<Roles> getAdminRoles(String roleType) {
        
        Session session = null;
        List<Roles> list = new ArrayList();
        String hql = null;
        
        try {
            
            session =getSessionFactory().openSession();
            
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
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO#getPermissions
     * ()
     */
    public List<Permissions> getPermissions() {
        
        Session session = null;
        List<Permissions> list = new ArrayList();
        
        try {
            
            session =getSessionFactory().openSession();
            
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
    
    /*
     * (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO#
     * getRolePermissionMappings()
     */
    @Override
    public List<RolePermissions> getRolePermissionMappings(String roleId) {
        
        Session session = null;
        List<Object[]> list = new ArrayList<Object[]>();
        List<RolePermissions> returnList = new ArrayList<RolePermissions>();
        
        try {
            
            session = getSessionFactory().openSession();
            
            if (roleId == null) {
                
                Query query = session.createSQLQuery("select * from role_permissions");
                list = query.list();
                
            } else {
                
                Query query = session.createSQLQuery("select * from role_permissions where role_id = :roleId").setParameter("roleId", roleId);
                list = query.list();
            }
            
            for (Object[] object : list) {
                
                RolePermissions rolePermissions = new RolePermissions();
                RolePermissionsId rolePermissionsId = new RolePermissionsId();
                rolePermissionsId.setRoleId(Integer.valueOf(object[0].toString()));
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
    
}
