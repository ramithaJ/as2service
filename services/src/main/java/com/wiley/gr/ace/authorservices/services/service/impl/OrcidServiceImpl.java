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
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.util.StringUtils;

import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.exception.ASException;
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

    /** The Constant ORCID_IDENTIFIER. */
    public static final String ORCID_IDENTIFIER = "orcid-identifier";

    /** The Constant AFFILIATION. */
    public static final String AFFILIATION = "affiliation";

    /** The Constant ORCID_ACTIVITIES. */
    public static final String ORCID_ACTIVITIES = "orcid-activities";

    /** The Constant TYPE. */
    public static final String TYPE = "type";

    /** The Constant AFFILIATIONS. */
    public static final String AFFILIATIONS = "affiliations";

    /** The Constant ORCID_WORK. */
    public static final String ORCID_WORK = "orcid-work";

    /** The Constant NAME. */
    public static final String NAME = "name";

    /** The Constant VISIBILITY. */
    public static final String VISIBILITY = "-visibility";

    /** The Constant CITY. */
    public static final String CITY = "city";

    /** The Constant ORCID_PROFILE. */
    public static final String ORCID_PROFILE = "orcid-profile";

    /** The Constant ORCID_BIO. */
    public static final String ORCID_BIO = "orcid-bio";

    /** The Constant PATH. */
    public static final String PATH = "path";

    /** The Constant VALUE. */
    public static final String VALUE = "value";

    /** The Constant PERSONAL_DETAILS. */
    public static final String PERSONAL_DETAILS = "personal-details";

    /** The Constant CONTACT_DETAILS. */
    public static final String CONTACT_DETAILS = "contact-details";

    /** The Constant EMAIL. */
    public static final String EMAIL = "email";

    /** The Constant PRIMARY. */
    public static final String PRIMARY = "primary";

    /** The Constant GIVEN_NAMES. */
    public static final String GIVEN_NAMES = "given-names";

    /** The Constant FAMILY_NAME. */
    public static final String FAMILY_NAME = "family-name";

    /** The Constant COUNTRY. */
    public static final String COUNTRY = "country";

    /** The Constant ADDRESS. */
    public static final String ADDRESS = "address";

    /** The Constant DEPARTMENT_NAME. */
    public static final String DEPARTMENT_NAME = "department-name";

    /** The Constant ROLE_TITLE. */
    public static final String ROLE_TITLE = "role-title";

    /** The Constant START_DATE. */
    public static final String START_DATE = "start-date";

    /** The Constant ORGANIZATION. */
    public static final String ORGANIZATION = "organization";

    /** The Constant REGION. */
    public static final String REGION = "region";

    /** The Constant DISAMBIGUATED_ORGANIZATION. */
    public static final String DISAMBIGUATED_ORGANIZATION = "disambiguated-organization";

    /** The Constant DISAMBIGUATED_ORGANIZATION_IDENTIFIER. */
    public static final String DISAMBIGUATED_ORGANIZATION_IDENTIFIER = "disambiguated-organization-identifier";

    /** The Constant DISAMBIGUATION_SOURCE. */
    public static final String DISAMBIGUATION_SOURCE = "disambiguation-source";

    /**
     * This method will take authorizationCode and call external service
     * oricdInterfaceService to authorize.
     *
     * @param authorizationCode
     *            the authorization code
     * @return the access token
     */

    @Override
    public final OrcidAccessToken getAccessToken(final String authorizationCode) {
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
     * @throws ASException
     *             the as exception
     */
    @Override
    public final User getWork(final OrcidAccessToken token, final User user)
            throws ASException {
        try {
            String orcidMessageJSON = oricdInterfaceService.getWork(token);
            if (null != orcidMessageJSON && !orcidMessageJSON.isEmpty()) {
                /**
                 * Code to map the orcid JSON to user model object
                 */
                parseOrcidJSONForWork(orcidMessageJSON, user);
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }
        return user;
    }

    /**
     * Gets the bio.
     *
     * @param token
     *            the access token
     * @return the bio
     * @throws ASException
     *             the as exception
     */
    @Override
    public final User getBio(final OrcidAccessToken token) throws ASException {

        User user = new User();
        try {
            String orcidMessageJSON = oricdInterfaceService.getBio(token);
            if (null != orcidMessageJSON && !orcidMessageJSON.isEmpty()) {
                /**
                 * Code to map the orcid JSON to user model object
                 */
                parseOrcidJSON(orcidMessageJSON, user);
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
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
     * @throws ASException
     *             the as exception
     */
    private void parseOrcidJSON(final String orcidMessageJSON, final User user)
            throws ASException {
        try {
            JSONObject orcidProfileJSON = (JSONObject) new JSONParser()
                    .parse(orcidMessageJSON);
            JSONObject orcidProfile = (JSONObject) orcidProfileJSON
                    .get(ORCID_PROFILE);
            LOGGER.info("orcidProfile ##### ", orcidProfile);
            if (null != orcidProfile) {
                LOGGER.error("Orcid Message found");
                parseOrcidIdentifier(orcidProfile, user);
                JSONObject orcidBioJSON = (JSONObject) new JSONParser()
                        .parse(orcidProfile.toJSONString());
                JSONObject orcidBio = (JSONObject) orcidBioJSON.get(ORCID_BIO);
                LOGGER.info("orcidBio ##### ", orcidBio);
                if (null != orcidBio) {
                    JSONObject personalDetailsJSON = (JSONObject) new JSONParser()
                            .parse(orcidBio.toJSONString());
                    parsePersonalDetails(personalDetailsJSON, user);
                    parseContactDetails(personalDetailsJSON, user);
                }
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }

    }

    /**
     * Parses the orcid identifier.
     *
     * @param orcidProfile
     *            the orcid profile
     * @param user
     *            the user
     * @throws ASException
     *             the as exception
     */
    private void parseOrcidIdentifier(final JSONObject orcidProfile,
            final User user) throws ASException {
        try {
            JSONObject orcidIdentifierJSON = (JSONObject) new JSONParser()
                    .parse(orcidProfile.toJSONString());
            JSONObject orcidIdentifier = (JSONObject) orcidIdentifierJSON
                    .get(ORCID_IDENTIFIER);
            LOGGER.info("orcidIdentifier ##### ", orcidIdentifier);
            if (!StringUtils.isEmpty(orcidIdentifier)) {
                LOGGER.info("orcidId Found ##### ", orcidIdentifier);
                JSONObject orcidIdentifierValueJSON = (JSONObject) new JSONParser()
                        .parse(orcidIdentifier.toJSONString());
                user.setOrcidId((String) orcidIdentifierValueJSON.get(PATH));
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }
    }

    /**
     * Parses the personal details.
     *
     * @param personalDetailsJSON
     *            the personal details json
     * @param user
     *            the user
     * @throws ASException
     *             the as exception
     */
    private void parsePersonalDetails(final JSONObject personalDetailsJSON,
            final User user) throws ASException {
        try {
            JSONObject personalDetails = (JSONObject) personalDetailsJSON
                    .get(PERSONAL_DETAILS);
            if (null != personalDetails) {
                /**
                 * Code to fetch FN and LN.
                 */
                LOGGER.error("Person Details Found");
                JSONObject givenNamesJSON = (JSONObject) new JSONParser()
                        .parse(personalDetails.toJSONString());
                JSONObject givenNames = (JSONObject) givenNamesJSON
                        .get(GIVEN_NAMES);
                LOGGER.info("givenNames ##### ", givenNames);
                if (null != givenNames) {
                    JSONObject givenNamesValueJSON = (JSONObject) new JSONParser()
                            .parse(givenNames.toJSONString());
                    user.setFirstName((String) givenNamesValueJSON.get(VALUE));
                }
                JSONObject familyNamesJSON = (JSONObject) new JSONParser()
                        .parse(personalDetails.toJSONString());
                JSONObject familyNames = (JSONObject) familyNamesJSON
                        .get(FAMILY_NAME);
                LOGGER.info("familyNames ##### ", familyNames);
                if (null != familyNames) {
                    JSONObject familyNamesValueJSON = (JSONObject) new JSONParser()
                            .parse(familyNames.toJSONString());
                    user.setLastName((String) familyNamesValueJSON.get(VALUE));
                }
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }

    }

    /**
     * Parses the contact details.
     *
     * @param personalDetailsJSON
     *            the personal details json
     * @param user
     *            the user
     * @throws ASException
     *             the as exception
     */
    private void parseContactDetails(final JSONObject personalDetailsJSON,
            final User user) throws ASException {
        try {
            JSONObject contactDetails = (JSONObject) personalDetailsJSON
                    .get(CONTACT_DETAILS);
            if (null != contactDetails) {
                LOGGER.error("Contact Details Found");
                JSONObject emailArrayJSON = (JSONObject) new JSONParser()
                        .parse(contactDetails.toJSONString());
                JSONArray emailArray = (JSONArray) emailArrayJSON.get(EMAIL);
                LOGGER.info("emailArray ##### ", emailArray);
                if (null != emailArray) {
                    Iterator<JSONObject> emailItr = emailArray.iterator();
                    Boolean isPrimary;
                    while (emailItr.hasNext()) {
                        JSONObject emailJSON = (JSONObject) new JSONParser()
                                .parse(emailItr.next().toJSONString());
                        isPrimary = (Boolean) emailJSON.get(PRIMARY);

                        LOGGER.info("isPrimary ---->" + isPrimary);
                        if (isPrimary) {
                            user.setPrimaryEmailAddr((String) emailJSON
                                    .get(VALUE));
                        }
                    }
                }
                Addresses addresses = parseAddressesDetails(contactDetails);
                user.setAddresses(addresses);
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }

    }

    /**
     * Parses the addresses details.
     *
     * @param contactDetails
     *            the contact details
     * @return the addresses
     * @throws ASException
     *             the as exception
     */
    private Addresses parseAddressesDetails(final JSONObject contactDetails)
            throws ASException {
        Addresses addresses = null;
        try {
            JSONObject addressJSON = (JSONObject) new JSONParser()
                    .parse(contactDetails.toJSONString());
            JSONObject addressDetails = (JSONObject) addressJSON.get(ADDRESS);
            LOGGER.info("addressDetails ##### ", addressDetails);
            if (null != addressDetails) {
                LOGGER.error("Address Details found");
                JSONObject countryJSON = (JSONObject) new JSONParser()
                        .parse(addressDetails.toJSONString());
                JSONObject countryDetails = (JSONObject) countryJSON
                        .get(COUNTRY);
                addresses = new Addresses();
                Address address = new Address();
                Country countryObj = parseCountryDetails(countryDetails);
                address.setCountry(countryObj);
                addresses.setCorrespondenceAddress(address);
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }
        return addresses;
    }

    /**
     * Parses the country details.
     *
     * @param countryDetails
     *            the country details
     * @return the country
     * @throws ASException
     *             the as exception
     */
    private Country parseCountryDetails(final JSONObject countryDetails)
            throws ASException {
        Country country = null;
        country = new Country();
        country.setCountryCode((String) countryDetails.get(VALUE));
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
     * @throws ASException
     *             the as exception
     */
    private void parseOrcidJSONForWork(final String orcidMessageJSON,
            final User user) throws ASException {
        try {
            JSONObject orcidProfileJSON = (JSONObject) new JSONParser()
                    .parse(orcidMessageJSON);
            JSONObject orcidProfile = (JSONObject) orcidProfileJSON
                    .get(ORCID_PROFILE);
            LOGGER.info("orcidProfile ##### ", orcidProfile);
            if (null != orcidProfile) {
                LOGGER.error("OrcId Profile not null");
                JSONObject orcidActivitiesJSON = (JSONObject) new JSONParser()
                        .parse(orcidProfile.toJSONString());
                JSONObject orcidActivities = (JSONObject) orcidActivitiesJSON
                        .get(ORCID_ACTIVITIES);
                LOGGER.info("orcidActivities ##### ", orcidActivities);
                if (null != orcidActivities) {
                    JSONObject orcidWorkJSON = (JSONObject) new JSONParser()
                            .parse(orcidActivities.toJSONString());
                    JSONObject orcidWork = (JSONObject) orcidWorkJSON
                            .get(ORCID_WORK);
                    LOGGER.info("orcidWork ##### ", orcidWork);
                    JSONObject affiliations = (JSONObject) orcidActivities
                            .get(AFFILIATIONS);
                    LOGGER.info("affiliations ##### ", affiliations);
                    if (null != affiliations) {
                        parseAffiliations(affiliations, user);
                    }
                }
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }
    }

    /**
     * Parses the affiliations.
     *
     * @param affiliations
     *            the affiliations
     * @param user
     *            the user
     * @throws ASException
     *             the as exception
     */
    private void parseAffiliations(final JSONObject affiliations,
            final User user) throws ASException {
        try {
            JSONObject affiliationArrayJSON = (JSONObject) new JSONParser()
                    .parse(affiliations.toJSONString());
            JSONArray affiliationArray = (JSONArray) affiliationArrayJSON
                    .get(AFFILIATION);
            LOGGER.info("affiliationArray ##### ", affiliationArray);
            if (null != affiliationArray) {
                LOGGER.error("Affiliation Array not null");
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
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }
    }

    /**
     * Parses the affiliation json.
     *
     * @param affiliationJSON
     *            the affiliation json
     * @return the affiliation
     * @throws ASException
     *             the as exception
     */
    private Affiliation parseAffiliationJSON(final JSONObject affiliationJSON)
            throws ASException {
        Affiliation affiliation = null;
        Organization organization = null;
        DisambiguatedOrganization disambiguatedOrganization = null;
        try {
            affiliation = new Affiliation();
            affiliation.setVisibility((String) affiliationJSON.get(VISIBILITY));
            affiliation.setType((String) affiliationJSON.get(TYPE));
            affiliation.setDepartmentName((String) affiliationJSON
                    .get(DEPARTMENT_NAME));
            affiliation.setRoleTitle((String) affiliationJSON.get(ROLE_TITLE));
            affiliation
                    .setStartDate(affiliationJSON.get(START_DATE).toString());
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
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }
        return affiliation;
    }

    /**
     * Parses the organization.
     *
     * @param affiliationJSON
     *            the affiliation json
     * @return the organization
     * @throws ASException
     *             the as exception
     */
    private Organization parseOrganization(final JSONObject affiliationJSON)
            throws ASException {
        Organization organization = null;
        try {
            JSONObject organizationJSON = (JSONObject) new JSONParser()
                    .parse(affiliationJSON.toJSONString());
            JSONObject organizationDetails = (JSONObject) organizationJSON
                    .get(ORGANIZATION);
            if (null != organizationDetails) {
                organization = new Organization();
                organization.setName((String) organizationDetails.get(NAME));
                Address address = parseAddress(organizationDetails);
                if (null != address) {
                    organization.setAddress(address);
                }
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }
        return organization;
    }

    /**
     * Parses the address.
     *
     * @param organizationDetails
     *            the organization details
     * @return the address
     * @throws ASException
     *             the asexception
     */
    private Address parseAddress(final JSONObject organizationDetails)
            throws ASException {
        Address address = null;
        try {
            JSONObject addressJSON = (JSONObject) new JSONParser()
                    .parse(organizationDetails.toJSONString());
            JSONObject addressDetails = (JSONObject) addressJSON.get(ADDRESS);
            if (null != addressDetails) {
                address = new Address();
                address.setCity((String) addressDetails.get(CITY));
                address.setRegion((String) addressDetails.get(REGION));
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }
        return address;
    }

    /**
     * Parses the disambiguated organization.
     *
     * @param affiliationJSON
     *            the affiliation json
     * @return the disambiguated organization
     * @throws ASException
     *             the as exception
     */
    private DisambiguatedOrganization parseDisambiguatedOrganization(
            final JSONObject affiliationJSON) throws ASException {
        DisambiguatedOrganization disambiguatedOrganization = null;
        try {
            JSONObject disambiguatedOrganizationJSON = (JSONObject) new JSONParser()
                    .parse(affiliationJSON.toJSONString());
            JSONObject disambiguatedOrganizationDetails = (JSONObject) disambiguatedOrganizationJSON
                    .get(DISAMBIGUATED_ORGANIZATION);
            if (null != disambiguatedOrganizationDetails) {
                disambiguatedOrganization = new DisambiguatedOrganization();
                disambiguatedOrganization
                        .setDisambiguatedOrganizationIdentifier((String) disambiguatedOrganizationDetails
                                .get(DISAMBIGUATED_ORGANIZATION_IDENTIFIER));
                disambiguatedOrganization
                        .setDisambiguationSource((String) disambiguatedOrganizationDetails
                                .get(DISAMBIGUATION_SOURCE));
            }
        } catch (Exception e) {
            LOGGER.error(AuthorServicesConstants.PRINTSTACKTRACE, e);
            throw new ASException();
        }
        return disambiguatedOrganization;
    }

    /**
     * Gets the orcid id.
     *
     * @param participantId
     *            the participant id
     * @return the orcid id
     */
    @Override
    public String getOrcidId(final String participantId) {
        String orcidId = null;
        Participant participant = participantsInterfaceService
                .searchParticipantByParticipantId(participantId);
        if (!StringUtils.isEmpty(participant)) {
            orcidId = participant.getOrcidId();
        }
        return orcidId;
    }

    @Override
    @CachePut(value = "user", key = "#authorizationCode")
    public User putOrcidData(final User user, final String authorizationCode) {
        return user;
    }

    @Override
    @Cacheable(value = "user", key = "#authorizationCode")
    public User getCachedOrcidData(final User user,
            final String authorizationCode) {
        return user;
    }
}
