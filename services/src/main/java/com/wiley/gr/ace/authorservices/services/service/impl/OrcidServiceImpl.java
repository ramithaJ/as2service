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
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.externalservices.service.OrcidInterfaceService;
import com.wiley.gr.ace.authorservices.externalservices.service.ParticipantsInterfaceService;
import com.wiley.gr.ace.authorservices.model.Address;
import com.wiley.gr.ace.authorservices.model.Addresses;
import com.wiley.gr.ace.authorservices.model.Affiliation;
import com.wiley.gr.ace.authorservices.model.Country;
import com.wiley.gr.ace.authorservices.model.DisambiguatedOrganization;
import com.wiley.gr.ace.authorservices.model.Organization;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.external.Participant;
import com.wiley.gr.ace.authorservices.model.orcid.OrcidAccessToken;
import com.wiley.gr.ace.authorservices.services.service.ASDataService;
import com.wiley.gr.ace.authorservices.services.service.OrcidService;

/**
 * The Class OrcidServiceImpl.
 *
 * @author virtusa version 1.0
 */
public class OrcidServiceImpl implements OrcidService {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(OrcidServiceImpl.class);

    /** getting bean of oricdInterfaceService. */
    @Autowired(required = true)
    private OrcidInterfaceService oricdInterfaceService;

    /** getting bean of asDataService. */
    @Autowired(required = true)
    private ASDataService asDataService;

    @Autowired(required = true)
    private ParticipantsInterfaceService participantsInterfaceService;
    /** The Constant COUNT. */
    private static final int COUNT = 10;

    /**
     * This method will take authorizationCode and call external service
     * oricdInterfaceService to authorize.
     *
     * @param authorizationCode
     *            the authorization code
     * @return the access token
     * @throws Exception
     *             the exception
     */

    @Override
    public final OrcidAccessToken getAccessToken(final String authorizationCode)
            throws Exception {
        return oricdInterfaceService.getAccessToken(authorizationCode);
    }

    /**
     * Gets the work.
     *
     * @param token
     *            the token
     * @param user
     *            the user
     * @return the work
     * @throws Exception
     *             the exception
     */
    @Override
    public final User getWork(final OrcidAccessToken token, final User user)
            throws Exception {
        String orcidMessageJSON = oricdInterfaceService.getWork(token);
        if (null != orcidMessageJSON && !orcidMessageJSON.isEmpty()) {
            /**
             * Code to map the orcid JSON to user model object
             */
            parseOrcidJSONForWork(orcidMessageJSON, user);
        }
        return user;
    }

    /**
     * Gets the bio.
     *
     * @param token
     *            the access token
     * @return the bio
     * @throws Exception
     *             the exception
     */
    @Override
    public final User getBio(final OrcidAccessToken token) throws Exception {

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

    /**
     * Parses the orcid json.
     *
     * @param orcidMessageJSON
     *            the orcid message json
     * @param user
     *            the user
     * @throws Exception
     *             the exception
     */
    private void parseOrcidJSON(final String orcidMessageJSON, final User user)
            throws Exception {

        JSONObject orcidProfileJSON = (JSONObject) new JSONParser()
                .parse(orcidMessageJSON);
        JSONObject orcidProfile = (JSONObject) orcidProfileJSON
                .get("orcid-profile");
        LOGGER.info("orcidProfile ##### ", orcidProfile);
        if (null != orcidProfile) {
            LOGGER.error("Orcid Message found");
            parseOrcidIdentifier(orcidProfile, user);
            JSONObject orcidBioJSON = (JSONObject) new JSONParser()
                    .parse(orcidProfile.toJSONString());
            JSONObject orcidBio = (JSONObject) orcidBioJSON.get("orcid-bio");
            LOGGER.info("orcidBio ##### ", orcidBio);
            if (null != orcidBio) {
                JSONObject personalDetailsJSON = (JSONObject) new JSONParser()
                        .parse(orcidBio.toJSONString());
                parsePersonalDetails(personalDetailsJSON, user);
                parseContactDetails(personalDetailsJSON, user);
            }
        }

    }

    /**
     * Parses the orcid identifier.
     *
     * @param orcidProfile
     *            the orcid profile
     * @param user
     *            the user
     * @throws Exception
     *             the exception
     */
    private void parseOrcidIdentifier(final JSONObject orcidProfile,
            final User user) throws Exception {
        JSONObject orcidIdentifierJSON = (JSONObject) new JSONParser()
                .parse(orcidProfile.toJSONString());
        JSONObject orcidIdentifier = (JSONObject) orcidIdentifierJSON
                .get("orcid-identifier");
        LOGGER.info("orcidIdentifier ##### ", orcidIdentifier);
        if (!StringUtils.isEmpty(orcidIdentifier)) {
            LOGGER.info("orcidId Found ##### ", orcidIdentifier);
            JSONObject orcidIdentifierValueJSON = (JSONObject) new JSONParser()
                    .parse(orcidIdentifier.toJSONString());
            user.setOrcidId((String) orcidIdentifierValueJSON.get("path"));
        }
    }

    /**
     * Parses the personal details.
     *
     * @param personalDetailsJSON
     *            the personal details json
     * @param user
     *            the user
     * @throws Exception
     *             the exception
     */
    private void parsePersonalDetails(final JSONObject personalDetailsJSON,
            final User user) throws Exception {

        JSONObject personalDetails = (JSONObject) personalDetailsJSON
                .get("personal-details");
        if (null != personalDetails) {
            /**
             * Code to fetch FN and LN.
             */
            LOGGER.error("Person Details Found");
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

    }

    /**
     * Parses the contact details.
     *
     * @param personalDetailsJSON
     *            the personal details json
     * @param user
     *            the user
     * @throws Exception
     *             the exception
     */
    private void parseContactDetails(final JSONObject personalDetailsJSON,
            final User user) throws Exception {

        JSONObject contactDetails = (JSONObject) personalDetailsJSON
                .get("contact-details");
        if (null != contactDetails) {
            LOGGER.error("Contact Details Found");
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
                    }
                }
            }
            Addresses addresses = parseAddressesDetails(contactDetails);
            user.setAddresses(addresses);
        }

    }

    /**
     * Parses the addresses details.
     *
     * @param contactDetails
     *            the contact details
     * @return the addresses
     * @throws Exception
     *             the exception
     */
    private Addresses parseAddressesDetails(final JSONObject contactDetails)
            throws Exception {
        Addresses addresses = null;

        JSONObject addressJSON = (JSONObject) new JSONParser()
                .parse(contactDetails.toJSONString());
        JSONObject addressDetails = (JSONObject) addressJSON.get("address");
        LOGGER.info("addressDetails ##### ", addressDetails);
        if (null != addressDetails) {
            LOGGER.error("Address Details found");
            JSONObject countryJSON = (JSONObject) new JSONParser()
                    .parse(addressDetails.toJSONString());
            JSONObject countryDetails = (JSONObject) countryJSON.get("country");
            addresses = new Addresses();
            Address address = new Address();
            Country country = parseCountryDetails(countryDetails);
            address.setCountry(country);
            addresses.setCorrespondenceAddress(address);
        }

        return addresses;
    }

    /**
     * Parses the country details.
     *
     * @param countryDetails
     *            the country details
     * @return the country
     * @throws Exception
     *             the exception
     */
    private Country parseCountryDetails(final JSONObject countryDetails)
            throws Exception {
        Country country = null;
        country = new Country();
        country.setCountryCode((String) countryDetails.get("value"));
        List<Country> countryList = asDataService.getCountries(COUNT);
        for (Country countryEntity : countryList) {
            if (countryEntity.getCountryCode().startsWith(
                    country.getCountryCode())) {
                country.setCountryName(countryEntity.getCountryName());
                break;
            }
        }

        return country;
    }

    /**
     * Parses the orcid json for work.
     *
     * @param orcidMessageJSON
     *            the orcid message json
     * @param user
     *            the user
     * @throws Exception
     *             the exception
     */
    private void parseOrcidJSONForWork(final String orcidMessageJSON,
            final User user) throws Exception {
        JSONObject orcidProfileJSON = (JSONObject) new JSONParser()
                .parse(orcidMessageJSON);
        JSONObject orcidProfile = (JSONObject) orcidProfileJSON
                .get("orcid-profile");
        LOGGER.info("orcidProfile ##### ", orcidProfile);
        if (null != orcidProfile) {
            LOGGER.error("OrcId Profile not null");
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
    }

    /**
     * Parses the affiliations.
     *
     * @param affiliations
     *            the affiliations
     * @param user
     *            the user
     * @throws Exception
     *             the exception
     */
    private void parseAffiliations(final JSONObject affiliations,
            final User user) throws Exception {
        JSONObject affiliationArrayJSON = (JSONObject) new JSONParser()
                .parse(affiliations.toJSONString());
        JSONArray affiliationArray = (JSONArray) affiliationArrayJSON
                .get("affiliation");
        LOGGER.info("affiliationArray ##### ", affiliationArray);
        if (null != affiliationArray) {
            LOGGER.error("Affiliation Array not null");
            Iterator<JSONObject> affiliationItr = affiliationArray.iterator();
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
    }

    /**
     * Parses the affiliation json.
     *
     * @param affiliationJSON
     *            the affiliation json
     * @return the affiliation
     * @throws Exception
     *             the exception
     */
    private Affiliation parseAffiliationJSON(final JSONObject affiliationJSON)
            throws Exception {
        Affiliation affiliation = null;
        Organization organization = null;
        DisambiguatedOrganization disambiguatedOrganization = null;

        affiliation = new Affiliation();
        affiliation.setVisibility((String) affiliationJSON.get("-visibility"));
        affiliation.setType((String) affiliationJSON.get("type"));
        affiliation.setDepartmentName((String) affiliationJSON
                .get("department-name"));
        affiliation.setRoleTitle((String) affiliationJSON.get("role-title"));
        affiliation.setStartDate(affiliationJSON.get("start-date").toString());
        organization = parseOrganization(affiliationJSON);
        if (null != organization) {
            affiliation.setOrganization(organization);
        }
        disambiguatedOrganization = parseDisambiguatedOrganization(affiliationJSON);
        if (null != disambiguatedOrganization) {
            affiliation.setDisambiguatedOrganization(disambiguatedOrganization);
        }

        return affiliation;
    }

    /**
     * Parses the organization.
     *
     * @param affiliationJSON
     *            the affiliation json
     * @return the organization
     * @throws Exception
     *             the exception
     */
    private Organization parseOrganization(final JSONObject affiliationJSON)
            throws Exception {
        Organization organization = null;
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

        return organization;
    }

    /**
     * Parses the address.
     *
     * @param organizationDetails
     *            the organization details
     * @return the address
     * @throws Exception
     *             the exception
     */
    private Address parseAddress(final JSONObject organizationDetails)
            throws Exception {
        Address address = null;
        JSONObject addressJSON = (JSONObject) new JSONParser()
                .parse(organizationDetails.toJSONString());
        JSONObject addressDetails = (JSONObject) addressJSON.get("address");
        if (null != addressDetails) {
            address = new Address();
            address.setCity((String) addressDetails.get("city"));
            address.setRegion((String) addressDetails.get("region"));
        }
        return address;
    }

    /**
     * Parses the disambiguated organization.
     *
     * @param affiliationJSON
     *            the affiliation json
     * @return the disambiguated organization
     * @throws Exception
     *             the exception
     */
    private DisambiguatedOrganization parseDisambiguatedOrganization(
            final JSONObject affiliationJSON) throws Exception {
        DisambiguatedOrganization disambiguatedOrganization = null;
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
        return disambiguatedOrganization;
    }

    /**
     * Gets the orcid id.
     *
     * @param participantId
     *            the participant id
     * @return the orcid id
     * @throws Exception
     *             the exception
     */
    @Override
    public String getOrcidId(final String participantId) throws Exception {
        String orcidId = null;
        Participant participant = participantsInterfaceService
                .searchParticipantByParticipantId(participantId);
        if (!StringUtils.isEmpty(participant)) {
            orcidId = participant.getOrcidId();
        }
        return orcidId;
    }
}
