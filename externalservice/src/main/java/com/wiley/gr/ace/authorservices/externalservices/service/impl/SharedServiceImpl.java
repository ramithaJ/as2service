/**
 *
 */
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.NotificationHistory;
import com.wiley.gr.ace.authorservices.model.Notifications;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ProductPersonRelationObject;

/**
 * The Class SharedServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class SharedServiceImpl implements SharedService {

    @Value("${authorLookup.url}")
    private String authorLookupUrl;

    @Value("${notificationHistory.url}")
    private String notificationHistroyUrl;

    @Value("${productPersonRelation.url}")
    private String productPersonRelationUrl;

    private static String APPID = "24";

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.SharedService
     * #authorLookup(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public final Service authorLookup(final String firstName,
            final String lastName, final String email) {
        return (Service) RestServiceInvokerUtil.getServiceData(authorLookupUrl,
                Service.class);

    }

    @Override
    public Service saveProductPersonRelation(
            final ProductPersonRelationObject productPersonRelationObject) {

        return (Service) RestServiceInvokerUtil.restServiceInvoker(
                productPersonRelationUrl, productPersonRelationObject,
                Service.class);
    }

    @Override
    public Notifications searchInvitationRecord(final String emailId) {

        Notifications notifications = null;
        NotificationHistory notificationHistory = (NotificationHistory) RestServiceInvokerUtil
                .getServiceData(
                        notificationHistroyUrl.concat(APPID).concat("?to=")
                                .concat(emailId), NotificationHistory.class);
        if (!StringUtils.isEmpty(notificationHistory)) {
            notifications = notificationHistory.getNotifications().get(0);
        }
        return notifications;
    }
}
