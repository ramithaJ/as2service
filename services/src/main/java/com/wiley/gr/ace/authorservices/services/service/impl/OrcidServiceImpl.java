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
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.wiley.gr.ace.authorservices.externalservices.service.OrcidInterfaceService;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.Addresses;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.DisambiguatedOrganization;
import com.wiley.gr.ace.authorservices.model.Organization;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.orcid.OrcidAccessToken;
import com.wiley.gr.ace.authorservices.services.service.ASDataService;
import com.wiley.gr.ace.authorservices.services.service.OrcidService;

/**
 * @author vkumark
 */
public class OrcidServiceImpl implements OrcidService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(OrcidServiceImpl.class);
    @Autowired(required = true)
    OrcidInterfaceService oricdInterfaceService;
    @Autowired(required = true)
    ASDataService asDataService;

    /*
     * (non-Javadoc)
     * 
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
    public User getWork(OrcidAccessToken token, User user) throws Exception {
        String orcidMessageJSON = oricdInterfaceService.getWork(token);
        if (null != orcidMessageJSON && !orcidMessageJSON.isEmpty()) {
            /**
             * Code to map the orcid JSON to user model object
             */
            parseOrcidJSONForWork(orcidMessageJSON, user);
        }
        return user;
    }

    @Override
    public User getBio(OrcidAccessToken token) throws Exception {

        User user = new User();
        String orcidMessageJSON = oricdInterfaceService.getBio(token);
        if (null != orcidMessageJSON && !orcidMessageJSON.isEmpty()) {
            /**
             * Code to map the orcid JSON to user model object
             */
            parseOrcidJSON(orcidMessageJSON, user);
        }
        return user;
    }

    private void parseOrcidJSON(String orcidMessageJSON, User user) {
        try {
            JSONObject orcidProfileJSON = (JSONObject) new JSONParser()
                    .parse(orcidMessageJSON);
            JSONObject orcidProfile = (JSONObject) orcidProfileJSON
                    .get("orcid-profile");
            LOGGER.info("orcidProfile ##### ", orcidProfile);
            if (null != orcidProfile) {
                JSONObject orcidBioJSON = (JSONObject) new JSONParser()
                        .parse(orcidProfile.toJSONString());
                JSONObject orcidBio = (JSONObject) orcidBioJSON
                        .get("orcid-bio");
                LOGGER.info("orcidBio ##### ", orcidBio);
                if (null != orcidBio) {
                    JSONObject personalDetailsJSON = (JSONObject) new JSONParser()
                            .parse(orcidBio.toJSONString());
                    parsePersonalDetails(personalDetailsJSON, user);
                    parseContactDetails(personalDetailsJSON, user);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Initial SessionFactory creation failed.", e);
        }
    }

    private void parsePersonalDetails(JSONObject personalDetailsJSON, User user) {
        try {
            JSONObject personalDetails = (JSONObject) personalDetailsJSON
                    .get("personal-details");
            if (null != personalDetails) {
                /**
                 * Code to fetch FN and LN.
                 */
                JSONObject givenNamesJSON = (JSONObject) new JSONParser()
                        .parse(personalDetails.toJSONString());
                JSONObject givenNames = (JSONObject) givenNamesJSON
                        .get("given-names");
                LOGGER.info("givenNames ##### ", givenNames);
                if (null != givenNames) {
                    JSONObject givenNamesValueJSON = (JSONObject) new JSONParser()
                            .parse(givenNames.toJSONString());
                    user.setFirstName((String) givenNamesValueJSON.get("value"));
                }
                JSONObject familyNamesJSON = (JSONObject) new JSONParser()
                        .parse(personalDetails.toJSONString());
                JSONObject familyNames = (JSONObject) familyNamesJSON
                        .get("family-name");
                LOGGER.info("familyNames ##### ", familyNames);
                if (null != familyNames) {
                    JSONObject familyNamesValueJSON = (JSONObject) new JSONParser()
                            .parse(familyNames.toJSONString());
                    user.setLastName((String) familyNamesValueJSON.get("value"));
                }
            }
        } catch (Exception e) {
            LOGGER.error("Initial SessionFactory creation failed.", e);
        }
    }

    private void parseContactDetails(JSONObject personalDetailsJSON, User user) {
        try {
            JSONObject contactDetails = (JSONObject) personalDetailsJSON
                    .get("contact-details");
            if (null != contactDetails) {
                JSONObject emailArrayJSON = (JSONObject) new JSONParser()
                        .parse(contactDetails.toJSONString());
                JSONArray emailArray = (JSONArray) emailArrayJSON.get("email");
                LOGGER.info("emailArray ##### ", emailArray);
                if (null != emailArray) {
                    Iterator<JSONObject> emailItr = emailArray.iterator();
                    Boolean isPrimary;
                    while (emailItr.hasNext()) {
                        JSONObject emailJSON = (JSONObject) new JSONParser()
                                .parse(emailItr.next().toJSONString());
                        isPrimary = (Boolean) emailJSON.get("primary");

                        LOGGER.info("isPrimary ---->" + isPrimary);
                        if (isPrimary) {
                            user.setPrimaryEmailAddr((String) emailJSON
                                    .get("value"));
                            user.setOrcidID((String) emailJSON.get("source"));
                        }
                    }
                }
                Addresses addresses = parseAddressesDetails(contactDetails);
                user.setAddresses(addresses);
            }
        } catch (Exception e) {
            LOGGER.error("Initial SessionFactory creation failed.", e);
        }
    }

    private Addresses parseAddressesDetails(JSONObject contactDetails) {
        Addresses addresses = null;
        try {
            JSONObject addressJSON = (JSONObject) new JSONParser()
                    .parse(contactDetails.toJSONString());
            JSONObject addressDetails = (JSONObject) addressJSON.get("address");
            LOGGER.info("addressDetails ##### ", addressDetails);
            if (null != addressDetails) {
                JSONObject countryJSON = (JSONObject) new JSONParser()
                        .parse(addressDetails.toJSONString());
                JSONObject countryDetails = (JSONObject) countryJSON
                        .get("country");
                addresses = new Addresses();
                Address address = new Address();
                Country country = parseCountryDetails(countryDetails);
                address.setCountry(country);
                addresses.setCorrespondenceAddress(address);
            }
        } catch (Exception e) {
            LOGGER.error("Initial SessionFactory creation failed.", e);
        }
        return addresses;
    }

    private Country parseCountryDetails(JSONObject countryDetails) {
        Country country = null;
        try {
            country = new Country();
            country.setCountryCode((String) countryDetails.get("value"));
            List<Country> countryList = asDataService.getCountries(10);
            for (Country countryEntity : countryList) {
                if (countryEntity.getCountryCode().startsWith(
                        country.getCountryCode())) {
                    country.setCountryName(countryEntity.getCountryName());
                    break;
                }
            }
        } catch (Exception e) {
            LOGGER.error("Initial SessionFactory creation failed.", e);
        }
        return country;
    }

    private void parseOrcidJSONForWork(String orcidMessageJSON, User user) {
        try {
            JSONObject orcidProfileJSON = (JSONObject) new JSONParser()
                    .parse(orcidMessageJSON);
            JSONObject orcidProfile = (JSONObject) orcidProfileJSON
                    .get("orcid-profile");
            LOGGER.info("orcidProfile ##### ", orcidProfile);
            if (null != orcidProfile) {
                JSONObject orcidActivitiesJSON = (JSONObject) new JSONParser()
                        .parse(orcidProfile.toJSONString());
                JSONObject orcidActivities = (JSONObject) orcidActivitiesJSON
                        .get("orcid-activities");
                LOGGER.info("orcidActivities ##### ", orcidActivities);
                if (null != orcidActivities) {
                    JSONObject orcidWorkJSON = (JSONObject) new JSONParser()
                            .parse(orcidActivities.toJSONString());
                    JSONObject orcidWork = (JSONObject) orcidWorkJSON
                            .get("orcid-work");
                    LOGGER.info("orcidWork ##### ", orcidWork);
                    JSONObject affiliations = (JSONObject) orcidActivities
                            .get("affiliations");
                    LOGGER.info("affiliations ##### ", affiliations);
                    if (null != affiliations) {
                        parseAffiliations(affiliations, user);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("Initial SessionFactory creation failed.", e);
        }
    }

    private void parseAffiliations(JSONObject affiliations, User user) {
        try {
            JSONObject affiliationArrayJSON = (JSONObject) new JSONParser()
                    .parse(affiliations.toJSONString());
            JSONArray affiliationArray = (JSONArray) affiliationArrayJSON
                    .get("affiliation");
            LOGGER.info("affiliationArray ##### ", affiliationArray);
            if (null != affiliationArray) {
                Iterator<JSONObject> affiliationItr = affiliationArray
                        .iterator();
                Affiliation affiliation = null;
                while (affiliationItr.hasNext()) {
                    JSONObject affiliationJSON = (JSONObject) new JSONParser()
                            .parse(affiliationItr.next().toJSONString());
                    affiliation = parseAffiliationJSON(affiliationJSON);
                    if (null != affiliation) {
                        user.setAffiliation(affiliation);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error("Initial SessionFactory creation failed.", e);
        }
    }

    private Affiliation parseAffiliationJSON(JSONObject affiliationJSON) {
        Affiliation affiliation = null;
        Organization organization = null;
        DisambiguatedOrganization disambiguatedOrganization = null;
        try {
            affiliation = new Affiliation();
            affiliation.setVisibility((String) affiliationJSON
                    .get("-visibility"));
            affiliation.setType((String) affiliationJSON.get("type"));
            affiliation.setDepartmentName((String) affiliationJSON
                    .get("department-name"));
            affiliation
                    .setRoleTitle((String) affiliationJSON.get("role-title"));
            affiliation.setStartDate((java.util.Date) affiliationJSON
                    .get("start-date"));
            organization = parseOrganization(affiliationJSON);
            if (null != organization) {
                affiliation.setOrganization(organization);
            }
            disambiguatedOrganization = parseDisambiguatedOrganization(affiliationJSON);
            if (null != disambiguatedOrganization) {
                affiliation
                        .setDisambiguatedOrganization(disambiguatedOrganization);
            }
        } catch (Exception e) {
            LOGGER.error("Initial SessionFactory creation failed.", e);
        }
        return affiliation;
    }

    private Organization parseOrganization(JSONObject affiliationJSON) {
        Organization organization = null;
        try {
            JSONObject organizationJSON = (JSONObject) new JSONParser()
                    .parse(affiliationJSON.toJSONString());
            JSONObject organizationDetails = (JSONObject) organizationJSON
                    .get("organization");
            if (null != organizationDetails) {
                organization = new Organization();
                organization.setName((String) organizationDetails.get("name"));
                Address address = parseAddress(organizationDetails);
                if (null != address) {
                    organization.setAddress(address);
                }
            }
        } catch (Exception e) {
            LOGGER.error("Initial SessionFactory creation failed.", e);
        }
        return organization;
    }

    private Address parseAddress(JSONObject organizationDetails) {
        Address address = null;
        try {
            JSONObject addressJSON = (JSONObject) new JSONParser()
                    .parse(organizationDetails.toJSONString());
            JSONObject addressDetails = (JSONObject) addressJSON.get("address");
            if (null != addressDetails) {
                address = new Address();
                address.setCity((String) addressDetails.get("city"));
                address.setRegion((String) addressDetails.get("region"));
            }
        } catch (Exception e) {
            LOGGER.error("Initial SessionFactory creation failed.", e);
        }
        return address;
    }

    private DisambiguatedOrganization parseDisambiguatedOrganization(
            JSONObject affiliationJSON) {
        DisambiguatedOrganization disambiguatedOrganization = null;
        try {
            JSONObject disambiguatedOrganizationJSON = (JSONObject) new JSONParser()
                    .parse(affiliationJSON.toJSONString());
            JSONObject disambiguatedOrganizationDetails = (JSONObject) disambiguatedOrganizationJSON
                    .get("disambiguated-organization");
            if (null != disambiguatedOrganizationDetails) {
                disambiguatedOrganization = new DisambiguatedOrganization();
                disambiguatedOrganization
                        .setDisambiguatedOrganizationIdentifier((String) disambiguatedOrganizationDetails
                                .get("disambiguated-organization-identifier"));
                disambiguatedOrganization
                        .setDisambiguationSource((String) disambiguatedOrganizationDetails
                                .get("disambiguation-source"));
            }
        } catch (Exception e) {
            LOGGER.error("Initial SessionFactory creation failed.", e);
        }
        return disambiguatedOrganization;
    }
}
