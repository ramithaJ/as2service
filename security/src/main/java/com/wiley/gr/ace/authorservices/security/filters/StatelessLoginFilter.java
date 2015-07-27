package com.wiley.gr.ace.authorservices.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.google.gson.Gson;
import com.wiley.gr.ace.authorservices.exception.UserException;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.UserLogin;
import com.wiley.gr.ace.authorservices.persistence.entity.Users;
import com.wiley.gr.ace.authorservices.security.TokenAuthentication;
import com.wiley.gr.ace.authorservices.security.service.TokenAuthenticationService;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;

/**
 * StatelessLoginFilter authenticates using username and password with external
 * auth server.
 */
public class StatelessLoginFilter extends
        AbstractAuthenticationProcessingFilter {

    /** The Constant APPLICATION_JSON_CHARSET_UTF_8. */
    public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json;charset=UTF-8";

    /** The Constant CACHE_CONTROL. */
    public static final String CACHE_CONTROL = "Cache-Control";

    /** The Constant NO_CACHE. */
    public static final String NO_CACHE = "no-cache";

    /** The Constant FAILURE. */
    public static final String FAILURE = "FAILURE";

    /** The Constant SUCCESS. */
    public static final String SUCCESS = "SUCCESS";

    /** The Constant ADMIN. */
    public static final String ADMIN = "ADMIN";
    /**
     * The token authentication service.
     */
    private final TokenAuthenticationService tokenAuthenticationService;

    /** The admin login service. */
    private final AdminLoginService adminLoginService;

    /** The unp. */
    private UsernameAndPassword unp = null;

    /**
     * Externalize constants (adminnotexist.code) to properties file.
     */
    public static final String notAdminCode = "AE_1010";

    /**
     * Externalize constants (adminnotexist.message) to properties file.
     */
    public static final String notAdminMessage = "You don't have access to Wiley Admin";

    /**
     * Externalize constants (invalidLogin.code) to properties file.
     */
    public static final String invalidLoginCode = "AE_1000";

    /**
     * Externalize constants (invalidLogin.message) to properties file.
     */
    public static final String invalidLoginMessage = "Please enter valid EmailId and Password";

    /**
     * Instantiates a new stateless login filter.
     *
     * @param urlMapping
     *            the url mapping
     * @param tokenAuthenticationService
     *            the token authentication service
     * @param authenticationManager
     *            the authentication manager
     * @param adminLoginService
     *            the admin login service
     */
    public StatelessLoginFilter(final String urlMapping,
            final TokenAuthenticationService tokenAuthenticationService,
            final AuthenticationManager authenticationManager,
            final AdminLoginService adminLoginService) {
        super(new AntPathRequestMatcher(urlMapping));
        this.tokenAuthenticationService = tokenAuthenticationService;
        setAuthenticationManager(authenticationManager);
        this.adminLoginService = adminLoginService;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.
     * AbstractAuthenticationProcessingFilter
     * #attemptAuthentication(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse)
     */
    @Override
    public Authentication attemptAuthentication(
            final HttpServletRequest request, final HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        unp = new Gson().fromJson(request.getReader(),
                UsernameAndPassword.class);
        final UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(
                unp.getUsername(), unp.getPassword());
        return getAuthenticationManager().authenticate(loginToken);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.
     * AbstractAuthenticationProcessingFilter
     * #successfulAuthentication(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain,
     * org.springframework.security.core.Authentication)
     */
    @Override
    protected void successfulAuthentication(final HttpServletRequest request,
            final HttpServletResponse response, final FilterChain chain,
            final Authentication authentication) throws IOException,
            ServletException {

        final TokenAuthentication tokenAuthentication = (TokenAuthentication) authentication;

        // Add the custom token as HTTP header to the response
        tokenAuthenticationService.addAuthentication(request, response,
                tokenAuthentication);

        Users users = null;

        try {
            users = adminLoginService.getASUser(unp.getUsername());
        } catch (final UserException e) {
            unsuccessfulAuthentication(request, response,
                    new AuthenticationServiceException(
                            StatelessLoginFilter.invalidLoginMessage));
        }

        if (StringUtils.equalsIgnoreCase(StatelessLoginFilter.ADMIN,
                unp.getType())
                && !adminLoginService.validateEmail(unp.getUsername())) {
            unsuccessfulAuthentication(request, response,
                    new AuthenticationServiceException(
                            StatelessLoginFilter.notAdminMessage));
            return;
        }

        final UserLogin user = new UserLogin();
        user.setUserId(users.getUserId());
        user.setFirstName(users.getFirstName());
        user.setLastName(users.getLastName());

        response.setContentType(StatelessLoginFilter.APPLICATION_JSON_CHARSET_UTF_8);
        response.setHeader(StatelessLoginFilter.CACHE_CONTROL,
                StatelessLoginFilter.NO_CACHE);
        response.getWriter().write(
                new Gson().toJson(new Service(StatelessLoginFilter.SUCCESS,
                        user, null)));

        // Add the authentication to the Security context
        SecurityContextHolder.getContext().setAuthentication(
                tokenAuthentication);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.web.authentication.
     * AbstractAuthenticationProcessingFilter
     * #unsuccessfulAuthentication(javax.servlet.http.HttpServletRequest,
     * javax.servlet.http.HttpServletResponse,
     * org.springframework.security.core.AuthenticationException)
     */
    @Override
    protected void unsuccessfulAuthentication(final HttpServletRequest request,
            final HttpServletResponse response,
            final AuthenticationException failed) throws IOException,
            ServletException {
        SecurityContextHolder.clearContext();

        ErrorPOJO error;
        if (StringUtils.equalsIgnoreCase(StatelessLoginFilter.notAdminMessage,
                failed.getMessage())) {
            error = new ErrorPOJO(StatelessLoginFilter.notAdminCode,
                    StatelessLoginFilter.notAdminMessage);
        } else {
            error = new ErrorPOJO(StatelessLoginFilter.invalidLoginCode,
                    StatelessLoginFilter.invalidLoginMessage);
        }

        response.setContentType(StatelessLoginFilter.APPLICATION_JSON_CHARSET_UTF_8);
        response.setHeader(StatelessLoginFilter.CACHE_CONTROL,
                StatelessLoginFilter.NO_CACHE);
        response.getWriter().write(
                new Gson().toJson(new Service(StatelessLoginFilter.FAILURE,
                        null, error)));
    }

    /**
     * The Class UsernameAndPassword.
     */
    public class UsernameAndPassword {

        /** The username. */
        private String username;

        /** The password. */
        private String password;

        /** The type. */
        private String type;

        /**
         * Instantiates a new username and password.
         */
        public UsernameAndPassword() {
        }

        /**
         * Instantiates a new username and password.
         *
         * @param username
         *            the username
         * @param password
         *            the password
         * @param type
         *            the type
         */
        public UsernameAndPassword(final String username,
                final String password, final String type) {
            this.username = username;
            this.password = password;
            this.type = type;
        }

        /**
         * Gets the username.
         *
         * @return the username
         */
        public final String getUsername() {
            return username;
        }

        /**
         * Sets the username.
         *
         * @param username
         *            the username to set
         */
        public final void setUsername(final String username) {
            this.username = username;
        }

        /**
         * Gets the password.
         *
         * @return the password
         */
        public final String getPassword() {
            return password;
        }

        /**
         * Sets the password.
         *
         * @param password
         *            the password to set
         */
        public final void setPassword(final String password) {
            this.password = password;
        }

        /**
         * Gets the type.
         *
         * @return the type
         */
        public String getType() {
            return type;
        }

        /**
         * Sets the type.
         *
         * @param type
         *            the new type
         */
        public void setType(final String type) {
            this.type = type;
        }
    }
}
