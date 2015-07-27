package com.wiley.gr.ace.authorservices.security.service;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import com.wiley.gr.ace.authorservices.security.TokenAuthentication;

/**
 * TokenAuthenticationService contacts external auth server to
 * retrieve/refresh/validate token.
 */
@Component("tokenAuthenticationService")
public class TokenAuthenticationService {

    /** The authentication cookie name. */
    @Value("${authentication.service.token.cookie.name}")
    private String authenticationCookieName;

    /** The authentication cookie max age. */
    @Value("${authentication.service.token.cookie.maxage}")
    private int authenticationCookieMaxAge;

    /** The token handler. */
    @Autowired
    private TokenHandler tokenHandler;

    /**
     * Authenticate.
     *
     * @param username
     *            the username
     * @param password
     *            the password
     * @return the authentication
     */
    public Authentication authenticate(final String username,
            final String password) {
        final String authenticationToken = tokenHandler
                .invokeTokenAuthorization(username, password);
        if (StringUtils.isBlank(authenticationToken)) {
            return null;
        }
        final User user = new User(username, StringUtils.EMPTY,
                new ArrayList<GrantedAuthority>());
        return new TokenAuthentication(authenticationToken, user);
    }

    /**
     * Verify authentication.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @return the authentication
     */
    public Authentication verifyAuthentication(
            final HttpServletRequest request, final HttpServletResponse response) {
        String token = null;
        final Cookie cookie = tokenHandler.getCookie(request,
                authenticationCookieName);
        if (null != cookie) {
            token = cookie.getValue();
        }
        if (StringUtils.isBlank(token)) {
            return null;
        }

        // Fetch new token if valid token in request
        final TokenAuthentication tokenAuthentication = tokenHandler
                .validateAndRefresh(token);

        if (null != tokenAuthentication) {
            addAuthentication(request, response, tokenAuthentication);
        }
        return tokenAuthentication;
    }

    /**
     * Adds the authentication.
     *
     * @param request
     *            the request
     * @param response
     *            the response
     * @param tokenAuthentication
     *            the token authentication
     */
    public void addAuthentication(final HttpServletRequest request,
            final HttpServletResponse response,
            final TokenAuthentication tokenAuthentication) {
        if (null == tokenAuthentication) {
            return;
        }
        if (StringUtils.isBlank(tokenAuthentication.getToken())) {
            return;
        }

        Cookie cookie = tokenHandler.getCookie(request,
                authenticationCookieName);
        if (null == cookie) {
            cookie = new Cookie(authenticationCookieName,
                    tokenAuthentication.getToken());
            cookie.setPath(request.getContextPath());
            cookie.setHttpOnly(false);
        } else {
            cookie.setValue(tokenAuthentication.getToken());
        }

        cookie.setMaxAge(authenticationCookieMaxAge);
        response.addCookie(cookie);
    }

}
