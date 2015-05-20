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
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.LookupValues;
import com.wiley.gr.ace.authorservices.persistence.entity.Permissions;
import com.wiley.gr.ace.authorservices.persistence.entity.RolePermissions;
import com.wiley.gr.ace.authorservices.persistence.entity.Roles;
import com.wiley.gr.ace.authorservices.persistence.services.ASDataDAO;

/**
 * @author kpshiva
 */
public class ASDataDAOImpl implements ASDataDAO {
    
    @Autowired(required = true)
    HibernateConnection con;
    
    @Override
    public List<LookupValues> getDropDown(String keyName) {
        
        Session session = null;
        Transaction transaction = null;
        List<LookupValues> lookupList = null;
        try {
            session = con.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            Criteria criteria = session.createCriteria(LookupValues.class);
            criteria.add(Restrictions.eq("lookupKey", keyName));
            lookupList = criteria.list();
            transaction.commit();
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
            
            session = con.getSessionFactory().openSession();
            
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
            
            session = con.getSessionFactory().openSession();
            
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
            
            session = con.getSessionFactory().openSession();
            
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
        List<RolePermissions> list = new ArrayList();
        String hql = "";
        
        try {
            
            session = con.getSessionFactory().openSession();
            
            if (roleId == null) {
                
                hql = "from RolePermissions";
                list = session.createQuery(hql).list();
                
            } else {
                hql = "from RolePermissions where id.roleId = :roleId";
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
    
}
