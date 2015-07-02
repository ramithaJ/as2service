package com.wiley.gr.ace.authorservices.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.wiley.gr.ace.authorservices.security.TokenAuthentication;
import com.wiley.gr.ace.authorservices.security.service.TokenAuthenticationService;

/**
 * StatelessLoginFilter authenticates using username and password with external
 * auth server.
 */
public class StatelessLoginFilter extends
        AbstractAuthenticationProcessingFilter {

    /** The Constant USERNAME. */
    private static final String USERNAME = "username";

    /** The Constant PASSWORD. */
    private static final String PASSWORD = "password";

    /** The token authentication service. */
    private final TokenAuthenticationService tokenAuthenticationService;

    /**
     * Instantiates a new stateless login filter.
     *
     * @param urlMapping
     *            the url mapping
     * @param tokenAuthenticationService
     *            the token authentication service
     * @param authenticationManager
     *            the authentication manager
     */
    public StatelessLoginFilter(final String urlMapping,
            final TokenAuthenticationService tokenAuthenticationService,
            final AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher(urlMapping));
        this.tokenAuthenticationService = tokenAuthenticationService;
        setAuthenticationManager(authenticationManager);
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

        final String username = request
                .getParameter(StatelessLoginFilter.USERNAME);
        final String password = request
                .getParameter(StatelessLoginFilter.PASSWORD);

        final UsernamePasswordAuthenticationToken loginToken = new UsernamePasswordAuthenticationToken(
                username, password);
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

        // Add the authentication to the Security context
        SecurityContextHolder.getContext().setAuthentication(
                tokenAuthentication);
    }
}
