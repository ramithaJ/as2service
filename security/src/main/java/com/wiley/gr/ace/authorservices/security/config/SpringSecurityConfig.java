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
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;

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

    /**
     * Injecting UserLoginServiceDAO bean.
     */
    @Autowired(required = true)
    private AdminLoginService adminLoginService;

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

                .antMatchers("/user/userSecurityQuestions/*")
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
                                authenticationManager(), adminLoginService),
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