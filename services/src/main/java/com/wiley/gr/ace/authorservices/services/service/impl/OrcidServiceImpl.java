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
package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.OrcidInterfaceService;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.Addresses;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.orcid.OrcidAccessToken;
import com.wiley.gr.ace.authorservices.services.service.OrcidService;

/**
 * @author vkumark
 */
public class OrcidServiceImpl implements OrcidService {
    
    @Autowired(required = true)
    OrcidInterfaceService oricdInterfaceService;
    
    /*
     * (non-Javadoc)
     * @see
     * com.wiley.gr.ace.authorservices.services.service.OrcidService#getAccessToken
     * (java.lang.String)
     */
    @Override
    public OrcidAccessToken getAccessToken(String authorizationCode)
            throws Exception {
        return oricdInterfaceService.getAccessToken(authorizationCode);
    }
    
    @Override
    public void getWork(User user) throws Exception {
    }
    
    @Override
    public User getBio(OrcidAccessToken token) throws Exception {
        
        User user = null;
        String orcidMessageJSON = oricdInterfaceService.getBio(token);
        if (null != orcidMessageJSON && !orcidMessageJSON.isEmpty()) {
            /**
             * Code to map the orcid JSON to user model object
             */
            user = parseOrcidJSON(orcidMessageJSON);
        }
        return user;
    }
    
    private User parseOrcidJSON(String orcidMessageJSON) {
        User user = null;
        try {
            JSONObject orcidProfileJSON = (JSONObject) new JSONParser()
                    .parse(orcidMessageJSON);
            JSONObject orcidProfile = (JSONObject) orcidProfileJSON
                    .get("orcid-profile");
            System.out.println("orcidProfile ##### " + orcidProfile);
            if (null != orcidProfile) {
                JSONObject orcidBioJSON = (JSONObject) new JSONParser()
                        .parse(orcidProfile.toJSONString());
                JSONObject orcidBio = (JSONObject) orcidBioJSON
                        .get("orcid-bio");
                System.out.println("orcidBio ##### " + orcidBio);
                if (null != orcidBio) {
                    user = new User();
                    JSONObject personalDetailsJSON = (JSONObject) new JSONParser()
                            .parse(orcidBio.toJSONString());
                    JSONObject personalDetails = (JSONObject) personalDetailsJSON
                            .get("personal-details");
                    System.out.println("personalDetails ##### "
                            + personalDetails);
                    if (null != personalDetails) {
                        /**
                         * Code to fetch FN and LN.
                         */
                        JSONObject givenNamesJSON = (JSONObject) new JSONParser()
                                .parse(personalDetails.toJSONString());
                        JSONObject givenNames = (JSONObject) givenNamesJSON
                                .get("given-names");
                        System.out.println("givenNames ##### " + givenNames);
                        
                        JSONObject familyNamesJSON = (JSONObject) new JSONParser()
                                .parse(personalDetails.toJSONString());
                        JSONObject familyNames = (JSONObject) familyNamesJSON
                                .get("family-name");
                        System.out.println("familyNames ##### " + familyNames);
                        
                        if (null != givenNames) {
                            JSONObject givenNamesValueJSON = (JSONObject) new JSONParser()
                                    .parse(givenNames.toJSONString());
                            user.setFirstName((String) givenNamesValueJSON
                                    .get("value"));
                        }
                        if (null != familyNames) {
                            JSONObject familyNamesValueJSON = (JSONObject) new JSONParser()
                                    .parse(familyNames.toJSONString());
                            user.setLastName((String) familyNamesValueJSON
                                    .get("value"));
                        }
                    }
                    /**
                     * Code to fetch Email and ORCID ID
                     */
                    JSONObject contactDetails = (JSONObject) personalDetailsJSON
                            .get("contact-details");
                    if (null != contactDetails) {
                        JSONObject emailArrayJSON = (JSONObject) new JSONParser()
                                .parse(contactDetails.toJSONString());
                        JSONArray emailArray = (JSONArray) emailArrayJSON
                                .get("email");
                        System.out.println("emailArray ##### " + emailArray);
                        /**
                         * Email JSON is an array so iterating through it to
                         * find primary email
                         */
                        if (null != emailArray) {
                            Iterator<JSONObject> emailItr = emailArray
                                    .iterator();
                            Boolean isPrimary;
                            while (emailItr.hasNext()) {
                                JSONObject emailJSON = (JSONObject) new JSONParser()
                                        .parse(emailItr.next().toJSONString());
                                isPrimary = (Boolean) emailJSON.get("primary");
                                
                                System.out.println("isPrimary ---->"
                                        + isPrimary);
                                if (isPrimary) {
                                    user.setPrimaryEmailAddr((String) emailJSON
                                            .get("value"));
                                    user.setOrcidID((String) emailJSON
                                            .get("source"));
                                }
                            }
                        }
                        /**
                         * Fetching country code from address field
                         */
                        JSONObject addressJSON = (JSONObject) new JSONParser()
                                .parse(contactDetails.toJSONString());
                        JSONObject addressDetails = (JSONObject) addressJSON
                                .get("address");
                        System.out.println("addressDetails ##### "
                                + addressDetails);
                        if (null != addressDetails) {
                            JSONObject countryJSON = (JSONObject) new JSONParser()
                                    .parse(addressDetails.toJSONString());
                            JSONObject countryDetails = (JSONObject) countryJSON
                                    .get("country");
                            Addresses addresses = new Addresses();
                            Address address = new Address();
                            Country country = new Country();
                            country.setCountryCode((String) countryDetails
                                    .get("value"));
                            country.setCountryName("INDIA"); // Need to replace
                                                             // with actual
                                                             // name once we
                                                             // have the
                                                             // service for
                                                             // country
                            address.setCountry(country);
                            addresses.setCorrespondenceAddress(address);
                            user.setAddresses(addresses);
                        }
                    }
                }
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
