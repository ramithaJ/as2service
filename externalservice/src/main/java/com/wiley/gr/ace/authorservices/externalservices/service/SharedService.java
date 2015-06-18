/**
 * 
 */
package com.wiley.gr.ace.authorservices.externalservices.service;

import com.wiley.gr.ace.authorservices.model.external.AssociationConfirmation;

/**
 * The Interface SharedService.
 *
 * @author virtusa version 1.0
 */
public interface SharedService {

    /**
     * Association confirmation.
     *
     * @param associationConfirmation
     *            the association confirmation
     * @return true, if successful
     * @throws Exception
     *             the exception
     */
    boolean associationConfirmation(
            AssociationConfirmation associationConfirmation) throws Exception;
}
