package com.wiley.gr.ace.authorservices.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import com.wiley.gr.ace.authorservices.security.TokenAuthenticationProvider;
import com.wiley.gr.ace.authorservices.security.filters.StatelessAuthenticationFilter;
import com.wiley.gr.ace.authorservices.security.filters.StatelessLoginFilter;
import com.wiley.gr.ace.authorservices.security.service.TokenAuthenticationService;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

/**
 * SpringSecurityConfig holds configurations for access restrictions and auth
 * flow.
 */
@Configuration
@EnableWebSecurity
@Order(2)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /** The Constant AUTHENTICATE. */
    public static final String AUTHENTICATE = "/authenticate";

    /** The token authentication provider. */
    @Autowired
    private TokenAuthenticationProvider tokenAuthenticationProvider;

    /** The token authentication service. */
    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired(required = true)
    private UserLoginService userLoginService;

    /**
     * Instantiates a new spring security config.
     */
    public SpringSecurityConfig() {
        super(true);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.config.annotation.web.configuration.
     * WebSecurityConfigurerAdapter
     * #configure(org.springframework.security.config
     * .annotation.web.builders.HttpSecurity)
     */
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .and()
                .anonymous()
                .and()
                .servletApi()
                .and()
                .authorizeRequests()

                // Allow anonymous resource requests
                .antMatchers("/")
                .permitAll()

                .antMatchers("/favicon.ico")
                .permitAll()

                .antMatchers("**/*.html")
                .permitAll()

                .antMatchers("**/*.css")
                .permitAll()

                .antMatchers("**/*.js")
                .permitAll()

                .antMatchers("/autocomplete/dropdown/*")
                .permitAll()

                .antMatchers("/user/resetPassword/*")
                .permitAll()

                .antMatchers("/user/verifyAccount/*")
                .permitAll()

                .antMatchers("/user/userSecurityQuestions/*/")
                .permitAll()

                .antMatchers("/user/password/reset")
                .permitAll()

                .antMatchers("/user/securityQuestions/validate")
                .permitAll()

                .antMatchers("/asdata/securityQuestions/")
                .permitAll()

                .antMatchers("/user/resetByEmail/*/")
                .permitAll()

                .antMatchers("/user/orcid/profile/*/*")
                .permitAll()
                .antMatchers("/user/orcid/*")
                .permitAll()
                .antMatchers("/registration/verify/email")
                .permitAll()
                .antMatchers("/registration/search/orcid/*")
                .permitAll()
                .antMatchers("/user/orcid/authorization/*")
                .permitAll()
                .antMatchers(
                        "http://authorservicesdev.wiley.com/landing.html#register/*")
                .permitAll()
                .antMatchers(
                        "http://authorservicesdev.wiley.com/landing.html#profile/*")
                .permitAll()
                .antMatchers("/registration/register")
                .permitAll()

                .antMatchers("/registration/verifyAccount/*")
                .permitAll()

                .antMatchers("/admin/permissions/*")
                .permitAll()

                .antMatchers("/registration/invitation/*")
                .permitAll()

                .antMatchers("/userAccount/userAddresses/*")
                .permitAll()

                .antMatchers("/userprofile/alerts/*")
                .permitAll()

                .antMatchers("/userprofile/getImage/*")
                .permitAll()

                .antMatchers("/userprofile/uploadImage/*/")
                .permitAll()

                .antMatchers("/userprofile/affiliations/*/*/")
                .permitAll()

                .antMatchers("/userprofile/affiliations/*/")
                .permitAll()

                .antMatchers("/search/api")
                .permitAll()

                .antMatchers("/search/autocomplete")
                .permitAll()

                .antMatchers(HttpMethod.POST, SpringSecurityConfig.AUTHENTICATE)
                .permitAll()

                .anyRequest()
                .authenticated()

                .and()
                .addFilterBefore(
                        new StatelessLoginFilter(
                                SpringSecurityConfig.AUTHENTICATE,
                                tokenAuthenticationService,
                                authenticationManager(), userLoginService),
                        UsernamePasswordAuthenticationFilter.class)

                // Custom Token based authentication based on the
                // header previously given to the client
                .addFilterBefore(
                        new StatelessAuthenticationFilter(
                                tokenAuthenticationService),
                        UsernamePasswordAuthenticationFilter.class);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.config.annotation.web.configuration.
     * WebSecurityConfigurerAdapter
     * #configure(org.springframework.security.config
     * .annotation.authentication.builders.AuthenticationManagerBuilder)
     */
    @Override
    protected void configure(
            final AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {
        authenticationManagerBuilder
                .authenticationProvider(tokenAuthenticationProvider);
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.security.config.annotation.web.configuration.
     * WebSecurityConfigurerAdapter#authenticationManagerBean()
     */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * Rest template bean.
     *
     * @return the rest template
     */
    @Bean
    public RestTemplate restTemplateBean() {
        return new RestTemplate();
    }
}