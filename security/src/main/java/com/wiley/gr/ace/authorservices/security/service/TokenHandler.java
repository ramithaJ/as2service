package com.wiley.gr.ace.authorservices.security.service;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.jose4j.jws.JsonWebSignature;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.gr.ace.authorservices.security.TokenAuthentication;

/**
 * TokenHandler handles external calls to retrieve/refresh/parse token.
 */
@Component("tokenHandler")
public class TokenHandler {

    /** The logger. */
    private static Logger LOGGER = LoggerFactory.getLogger(TokenHandler.class);

    /** The authentication token header name. */
    @Value("${authentication.service.token.header.name}")
    private String authenticationTokenHeaderName;

    /** The authentication url. */
    @Value("${authentication.service.auth.url.authenticate}")
    private String authenticationUrl;

    /** The authentication token refresh url. */
    @Value("${authentication.service.auth.url.refresh}")
    private String authenticationTokenRefreshUrl;

    /** The authentication token validation url. */
    @Value("${authentication.service.auth.url.validate}")
    private String authenticationTokenValidationUrl;

    /** The token app key. */
    @Value("${authentication.service.token.app.key}")
    private String tokenAppKey;

    /** The token auth type. */
    @Value("${authentication.service.token.auth.type}")
    private String tokenAuthType;

    /** The user id. */
    @Value("${authentication.service.token.user.key}")
    private String tokenUserId;

    /** User locked message. */
    @Value("${authentication.service.user.locked.message}")
    private final String userLockedMessage = "423 Locked";

    /** The rest template. */
    @Autowired
    private RestTemplate restTemplate;

    /**
     * Gets the cookie.
     *
     * @param request
     *            the request
     * @param name
     *            the name
     * @return the cookie
     */
    public Cookie getCookie(final HttpServletRequest request, final String name) {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        final Cookie[] cookies = request.getCookies();
        if (null != cookies && cookies.length > 0) {
            for (final Cookie cookie : cookies) {
                if (StringUtils.equalsIgnoreCase(cookie.getName(), name)) {
                    return cookie;
                }
            }
        }
        return null;
    }

    /**
     * Invoke token authorization.
     *
     * @param username
     *            the username
     * @param password
     *            the password
     * @return the string
     */
    public String invokeTokenAuthorization(final String username,
            final String password) {
        final JSONObject entity = new JSONObject();
        entity.put("userId", username);
        entity.put("password", password);
        entity.put("authenticationType", tokenAuthType);
        entity.put("appKey", tokenAppKey);

        ResponseEntity<String> response = null;
        try {
            response = restTemplate.postForEntity(new URI(authenticationUrl),
                    entity, String.class);
        } catch (final Exception e) {
            TokenHandler.LOGGER.error(
                    "Error on authenticating with Username={}; Password={}",
                    username, password, e);
            if (userLockedMessage.equalsIgnoreCase(e.getMessage())) {
                throw new AuthenticationServiceException(e.getMessage(), e);
            }
        }

        if (null == response || HttpStatus.OK != response.getStatusCode()) {
            return null;
        }

        return response.getHeaders().getFirst(authenticationTokenHeaderName);
    }

    /**
     * Validate and refresh.
     *
     * @param token
     *            the token
     * @return the token authentication
     */
    public TokenAuthentication validateAndRefresh(String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }

        // Validate provided Token
        final HttpHeaders headers = new HttpHeaders();
        headers.add(authenticationTokenHeaderName, token);

        // Send request to Auth Server for new refreshed token
        final ResponseEntity<String> responseEntity = restTemplate.exchange(
                authenticationTokenRefreshUrl, HttpMethod.GET,
                new HttpEntity<>(headers), String.class);

        if (null == responseEntity
                || responseEntity.getStatusCode() != HttpStatus.CREATED) {
            return null;
        }

        token = responseEntity.getHeaders().getFirst(
                authenticationTokenHeaderName);

        final User user = parseUser(token);
        if (user == null) {
            return null;
        }
        return new TokenAuthentication(token, user);
    }

    /**
     * Parses the user.
     *
     * @param token
     *            the token
     * @return the user
     */
    private User parseUser(final String token) {
        if (StringUtils.isBlank(token)) {
            return null;
        }
        final String username = getUsername(token);
        if (StringUtils.isBlank(username)) {
            return null;
        }
        return new User(username, StringUtils.EMPTY,
                new ArrayList<GrantedAuthority>());
    }

    /**
     * Gets the username.
     *
     * @param token
     *            the token
     * @return the username
     */
    private String getUsername(final String token) {
        String username = null;
        try {
            final JsonWebSignature jws = new JsonWebSignature();
            jws.setCompactSerialization(token);
            username = getTokenNodeValue(tokenUserId, jws);
        } catch (final Exception e) {
            TokenHandler.LOGGER.error("Error parsing token : ", e);
        }
        return username;
    }

    /**
     * Gets the token node value.
     *
     * @param key
     *            the key
     * @param jws
     *            the jws
     * @return the token node value
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private String getTokenNodeValue(final String key,
            final JsonWebSignature jws) throws IOException {
        final ObjectMapper mapper = new ObjectMapper();
        final JsonNode actualObj = mapper.readTree(jws.getUnverifiedPayload());
        final JsonNode jsonNode = actualObj.get(key);
        return jsonNode.textValue();
    }

}
