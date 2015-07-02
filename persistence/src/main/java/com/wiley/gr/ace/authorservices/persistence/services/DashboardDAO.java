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
package com.wiley.gr.ace.authorservices.persistence.services;

import java.util.List;

import com.wiley.gr.ace.authorservices.persistence.entity.InvitationLog;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPersonRelations;
import com.wiley.gr.ace.authorservices.persistence.entity.ProductPublicationStatuses;

/**
 * The Interface DashboardDAO.
 *
 * @author virtusa version 1.0
 */
public interface DashboardDAO {

    /**
     * Gets the product person relations.
     *
     * @param userId
     *            the user id
     * @return the product person relations
     */
    List<ProductPersonRelations> getProductPersonRelations(Integer userId);

    /**
     * Gets the invitation log list.
     *
     * @param userId
     *            the user id
     * @return the invitation log list
     * @throws Exception
     *             the exception
     */
    List<InvitationLog> getInvitationLogList(Integer userId) throws Exception;

    /**
     * Gets the published article details.
     *
     * @param dhId
     *            the dh id
     * @return the published article details
     * @throws Exception
     *             the exception
     */
    ProductPublicationStatuses getPublishedArticleDetails(Integer dhId)
            throws Exception;
}
