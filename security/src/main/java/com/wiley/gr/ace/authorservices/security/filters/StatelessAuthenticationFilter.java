package com.wiley.gr.ace.authorservices.security.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.GenericFilterBean;

import com.wiley.gr.ace.authorservices.security.service.TokenAuthenticationService;

/**
 * StatelessAuthenticationFilter authenticates using token authentication
 * service.
 */
public class StatelessAuthenticationFilter extends GenericFilterBean {

    /** The token authentication service. */
    private final TokenAuthenticationService tokenAuthenticationService;

    /**
     * Instantiates a new stateless authentication filter.
     *
     * @param authenticationService
     *            the authentication service
     */
    public StatelessAuthenticationFilter(
            final TokenAuthenticationService authenticationService) {
        tokenAuthenticationService = authenticationService;
    }

    /*
     * (non-Javadoc)
     * 
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
     * javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    @Override
    public void doFilter(final ServletRequest request,
            final ServletResponse response, final FilterChain filterChain)
                    throws IOException, ServletException {
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        final HttpServletResponse httpResponse = (HttpServletResponse) response;

        // Verify the authentication and Add new refreshed Token to Cookie
        final Authentication authentication = tokenAuthenticationService
                .verifyAuthentication(httpRequest, httpResponse);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        filterChain.doFilter(request, response);
        SecurityContextHolder.getContext().setAuthentication(null);
    }
}