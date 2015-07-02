package com.wiley.gr.ace.authorservices.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.wiley.gr.ace.authorservices.security.service.TokenAuthenticationService;

/**
 * TokenAuthenticationProvider authenticates and verifies.
 */
@Component("tokenAuthenticationProvider")
public class TokenAuthenticationProvider implements AuthenticationProvider {

    /** The token authentication service. */
    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.authentication.AuthenticationProvider#
     * authenticate(org.springframework.security.core.Authentication)
     */
    @Override
    public Authentication authenticate(final Authentication authentication)
            throws AuthenticationException {
        if (null == authentication) {
            return null;
        }
        final String principal = authentication.getPrincipal().toString();
        final String credentials = authentication.getCredentials().toString();
        return tokenAuthenticationService.authenticate(principal, credentials);
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.authentication.AuthenticationProvider#supports
     * (java.lang.Class)
     */
    @Override
    public boolean supports(final Class<?> authentication) {
        return null != authentication
                && authentication
                .equals(UsernamePasswordAuthenticationToken.class);
    }

}
