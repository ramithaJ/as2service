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

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.persistence.connection.HibernateConnection;
import com.wiley.gr.ace.authorservices.persistence.entity.UserAlerts;
import com.wiley.gr.ace.authorservices.persistence.services.UserAlertsDao;

/**
 * @author RAVISINHA
 */
public class UserAlertsDaoImpl implements UserAlertsDao {
    @Autowired(required = true)
    HibernateConnection con;
    
    /*
     * (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.persistence.services.UserAlertsDao#
     * getListOfAlerts(java.lang.String)
     */
    @Override
    public List<UserAlerts> getListOfAlerts(String userId) {
        Session session = con.getSessionFactory().openSession();
        session.beginTransaction();
        List<UserAlerts> result = null;
        try {
            
            String hql = "from UserAlerts where id.userId = :userId";
            result = session.createQuery(hql).setString("userId", userId)
                    .list();
        }
        
        finally {
            if (null != session) {
                session.flush();
                session.getTransaction().commit();
                session.close();
            }
        }
        return result;
    }
    
    /*
     * (non-Javadoc)
     * @see com.wiley.gr.ace.authorservices.persistence.services.UserAlertsDao#
     * updateAlerts(java.util.List)
     */
    @Override
    public boolean updateAlerts(List<UserAlerts> serviceUserAlertsList) {
        
        Session session = con.getSessionFactory().openSession();
        session.beginTransaction();
        try {
            
            for (UserAlerts userAlerts : serviceUserAlertsList) {
                
                UserAlerts daoUseralerts = (UserAlerts) session.load(
                        UserAlerts.class, userAlerts.getId());
                
                daoUseralerts.setEmailFlg(userAlerts.getEmailFlg());
                daoUseralerts.setOnScreenFlg(userAlerts.getOnScreenFlg());
                session.save(daoUseralerts);
            }
        } finally {
            if (null != session)
                session.flush();
            session.getTransaction().commit();
            session.close();
            
        }
        
        return true;
    }
}
