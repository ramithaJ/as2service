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
/**
 * 
 */
package com.wiley.gr.ace.authorservices.persistence.services.impl;

import com.wiley.gr.ace.authorservices.persistence.services.ArticleAssignmentDAO;

/**
 * The class ArticleAssignmentDAO.
 *
 * @author virtusa version 1.0
 */
public class ArticleAssignmentDAOImpl implements ArticleAssignmentDAO {

//    /** The Constant LOGGER. */
//    private static final Logger LOGGER = LoggerFactory
//            .getLogger(ArticleAssignmentDAOImpl.class);
//
//    /**
//     * Gets the product person relations.
//     *
//     * @param emailId
//     *            the email id
//     * @return the product person relations
//     */
//    @Override
//    public final List<ProductPersonRelations> getProductPersonRelations(
//            final String emailAddr) {
//        LOGGER.info("inside getProductPersonRelations Method of DashboardDAOImpl");
//        Session session = null;
//        String productPersonRelationsHql = null;
//        try {
//            session = getSessionFactory().openSession();
//            productPersonRelationsHql = "from ProductPersonRelations ppr where ppr.emailAddr=:emailAddr";
//            final List<ProductPersonRelations> productPersonRelationsList = session
//                    .createQuery(productPersonRelationsHql)
//                    .setString("emailAddr", emailAddr).list();
//            return productPersonRelationsList;
//        } finally {
//            if (session != null) {
//                session.flush();
//                session.close();
//            }
//        }
//    }
}
