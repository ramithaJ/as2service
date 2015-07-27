package com.wiley.gr.ace.authorservices.security;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

/**
 * TokenAuthentication holds token and user objects.
 */
public class TokenAuthentication implements Authentication {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 5658151770977098941L;

    /** The user. */
    private final User user;

    /** The token. */
    private final String token;

    /** The authenticated. */
    private boolean authenticated = true;

    /**
     * Instantiates a new token authentication.
     *
     * @param authenticationToken
     *            the authentication token
     * @param user
     *            the user
     */
    public TokenAuthentication(final String authenticationToken, final User user) {
        token = authenticationToken;
        this.user = user;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.security.Principal#getName()
     */
    @Override
    public String getName() {
        return user.getUsername();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.Authentication#getAuthorities()
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return user.getAuthorities();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.Authentication#getCredentials()
     */
    @Override
    public Object getCredentials() {
        return user.getPassword();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.Authentication#getDetails()
     */
    @Override
    public User getDetails() {
        return user;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.Authentication#getPrincipal()
     */
    @Override
    public Object getPrincipal() {
        return user.getUsername();
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.core.Authentication#isAuthenticated()
     */
    @Override
    public boolean isAuthenticated() {
        return authenticated;
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * org.springframework.security.core.Authentication#setAuthenticated(boolean
     * )
     */
    @Override
    public void setAuthenticated(final boolean authenticated) {
        this.authenticated = authenticated;
    }

    /**
     * Gets the token.
     *
     * @return the token
     */
    public String getToken() {
        return token;
    }
}
