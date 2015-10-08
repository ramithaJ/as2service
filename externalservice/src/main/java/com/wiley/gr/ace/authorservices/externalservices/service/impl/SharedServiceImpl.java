/**
 * 
 */
package com.wiley.gr.ace.authorservices.externalservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.externalservices.service.SharedService;
import com.wiley.gr.ace.authorservices.model.NotificationHistory;
import com.wiley.gr.ace.authorservices.model.Notifications;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.external.ProductPersonRelationObject;

// TODO: Auto-generated Javadoc
/**
 * The Class SharedServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class SharedServiceImpl implements SharedService {

    @Value("${authorLookup.url}")
    private String authorLookupUrl;

    @Value("${notification.url}")
    private String notificationHistroyUrl;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.wiley.gr.ace.authorservices.externalservices.service.SharedService
     * #authorLookup(java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public final Service authorLookup(final String firstName,
            final String lastName, final String email) throws Exception {
        return (Service) RestServiceInvokerUtil.getServiceData(authorLookupUrl,
                Service.class);

    }

    @Override
    public Service saveProductPersonRelation(
            final ProductPersonRelationObject productPersonRelationObject) {

        return (Service) RestServiceInvokerUtil
                .restServiceInvoker(
                        "http://10.201.64.81:8090/as2crossrefservices/v1/article/assign",
                        productPersonRelationObject, Service.class);
    }

    @Override
    public boolean searchInvitationRecord(final String emailId) {
        boolean searchInvitation = false;
        NotificationHistory notificationHistory = (NotificationHistory) RestServiceInvokerUtil
                .getServiceData(
                        notificationHistroyUrl.concat("appId").concat("?from=")
                                .concat(emailId), NotificationHistory.class);
        if (!StringUtils.isEmpty(notificationHistory)) {
            List<Notifications> notificationsList = notificationHistory
                    .getNotifications();
            if (!StringUtils.isEmpty(notificationsList)) {
                for (Notifications notification : notificationsList) {
                    if ("Invitation".equalsIgnoreCase(notification.getTemplate().getTagl1())) {
                        searchInvitation = true;
                    }
                }
            }
        }
        return searchInvitation;
    }
}
