/*
 * 
 */
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
import com.wiley.gr.ace.authorservices.constants.AuthorServicesConstants;
import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.model.User;
import com.wiley.gr.ace.authorservices.model.UserLogin;
import com.wiley.gr.ace.authorservices.security.TokenAuthentication;
import com.wiley.gr.ace.authorservices.security.service.TokenAuthenticationService;
import com.wiley.gr.ace.authorservices.services.service.UserLoginService;

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

	/** The Constant LOCKED. */
	public static final String LOCKED = "423 Locked";

	/**
	 * The token authentication service.
	 */
	private final TokenAuthenticationService tokenAuthenticationService;

	private final UserLoginService userLoginService;

	/** The unp. */
	private UsernameAndPassword unp = null;

	/**
	 * Externalize constants (adminnotexist.code) to properties file.
	 */
	public static final String NOT_ADMIN_CODE = "HOME_PAGE_MARKETING_USER_NOT_EXISTS_ERR_TEXT";

	/**
	 * Externalize constants (adminnotexist.message) to properties file.
	 */
	public static final String NOT_ADMIN_MESSAGE = "You don't have access to Wiley Admin";

	/**
	 * Externalize constants (invalidLogin.code) to properties file.
	 */
	public static final String INVALID_LOGIN_CODE = "HOME_PAGE_MARKETING_INCRCT_PASSWORD_ERR_TEXT";

	/**
	 * Externalize constants (invalidLogin.message) to properties file.
	 */
	public static final String INVALID_LOGIN_MESSAGE = "Please enter valid EmailId and Password";

	/**
	 * Externalize constants (userLocked.code) to properties file.
	 */
	public static final String USER_LOCKED_CODE = "HOME_PAGE_MARKETING_LOCKED_USER_ERR_TEXT";

	/**
	 * Externalize constants (userLocked.message) to properties file.
	 */
	public static final String USER_LOCKED_MESSAGE = "Please retry after few minutes";

	/**
	 * This field holds the value of ACCOUNT_INACTIVE_CODE.
	 */
	public static final String ACCOUNT_INACTIVE_CODE = "1234";

	/**
	 * This field holds the value of ACCOUNT_INACTIVE_MSG.
	 */
	public static final String ACCOUNT_INACTIVE_MSG = "Your account is not active. Please activate your account";

	/**
	 * This field holds the value of USER_NOT_EXIST.
	 */
	public static final String USER_NOT_EXIST_MSG_CODE = "203";

	/**
	 * This field holds the value of USER_NOT_EXIST_CODE.
	 */
	public static final String USER_NOT_EXIST_CODE = "SIGN_IN_PRIMARY_EMAIL_USER_NOT_EXISTS_ERR_TEXT";

	/**
	 * This field holds the value of USER_NOT_EXIST_MSG.
	 */
	public static final String USER_NOT_EXIST_MSG = "User does not exist. Please register in the system.";

	/**
	 * This field holds the value of INTERNAL_SERVER_ERROR.
	 */
	public static final String INTERNAL_SERVER_ERROR = "UNABLE_PROCESS_REQ_ERR_TEXT";

	public static final String FIRST_TIME_LOGIN = "LOGIN_INTR_SCREEN_ERR_TEXT";

	public static final String FIRST_TIME_LOGIN_MSG = "First Time Login Text";

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
			UserLoginService userLoginService) {
		super(new AntPathRequestMatcher(urlMapping));
		this.tokenAuthenticationService = tokenAuthenticationService;
		setAuthenticationManager(authenticationManager);
		//this.registrationService = registrationService;
		this.userLoginService = userLoginService;
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
		try {
			return getAuthenticationManager().authenticate(loginToken);
		} catch (final AuthenticationServiceException e) {
			unsuccessfulAuthentication(request, response, e);
		}
		return null;
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

		User almUser = userLoginService.searchUserInALM(unp.getUsername());

		ErrorPOJO errorPOJO = null;
		User userDetails = null;

		if (!StringUtils.equalsIgnoreCase(StatelessLoginFilter.ADMIN,
				unp.getType())) {

			if (almUser.getTermsOfUseFlg().equalsIgnoreCase("Y")
					&& almUser.getStatus().equalsIgnoreCase(
							AuthorServicesConstants.VERIFY_ACCOUNT_ACTIVE)) {
				
				/* Temporarily commenting this till we get ParticipantByALMId  working...   */
				/*if (!userLoginService.searchUserInParticipantByALMId(almUser
						.getUserId())) {
					registrationService.doFinalCreate(almUser.getUserId(),"false");
				}*/
				userDetails = userLoginService.getUserDetailsFromParticipantService(unp.getUsername());

			} else if (almUser.getTermsOfUseFlg().equalsIgnoreCase("N")
					&& almUser.getStatus().equalsIgnoreCase(
							AuthorServicesConstants.VERIFY_ACCOUNT_ACTIVE)) {

				errorPOJO = new ErrorPOJO(
						StatelessLoginFilter.FIRST_TIME_LOGIN,
						StatelessLoginFilter.FIRST_TIME_LOGIN_MSG);

			} else if (almUser.getTermsOfUseFlg().equalsIgnoreCase("Y")
					&& almUser
							.getStatus()
							.equalsIgnoreCase(
									AuthorServicesConstants.VERIFY_ACCOUNT_AWAITING_ACTIVATION)) {

				unsuccessfulAuthentication(request, response,
						new AuthenticationServiceException(
								StatelessLoginFilter.ACCOUNT_INACTIVE_CODE));

			}
		}
		
		

		final UserLogin user = new UserLogin();
		if(userDetails != null) {
			user.setUserId(userDetails.getUserId());
			user.setFirstName(userDetails.getFirstName());
			user.setLastName(userDetails.getLastName());
			user.setOrcidId(userDetails.getOrcidId());
			user.setAlmUserId(almUser.getAlmUserId());
		}
		

		response.setContentType(StatelessLoginFilter.APPLICATION_JSON_CHARSET_UTF_8);
		response.setHeader(StatelessLoginFilter.CACHE_CONTROL,
				StatelessLoginFilter.NO_CACHE);
		response.getWriter().write(
				new Gson().toJson(new Service(StatelessLoginFilter.SUCCESS,
						user, errorPOJO)));

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
		if (StringUtils.equalsIgnoreCase(
				StatelessLoginFilter.NOT_ADMIN_MESSAGE, failed.getMessage())) {
			error = new ErrorPOJO(StatelessLoginFilter.NOT_ADMIN_CODE,
					StatelessLoginFilter.NOT_ADMIN_MESSAGE);
		} else if (StatelessLoginFilter.LOCKED.equalsIgnoreCase(failed
				.getMessage())) {
			error = new ErrorPOJO(StatelessLoginFilter.USER_LOCKED_CODE,
					StatelessLoginFilter.USER_LOCKED_MESSAGE);
		} else if (StatelessLoginFilter.ACCOUNT_INACTIVE_CODE
				.equalsIgnoreCase(failed.getMessage())) {
			error = new ErrorPOJO(StatelessLoginFilter.ACCOUNT_INACTIVE_CODE,
					StatelessLoginFilter.ACCOUNT_INACTIVE_MSG);
		} else if (StatelessLoginFilter.INTERNAL_SERVER_ERROR
				.equalsIgnoreCase(failed.getMessage())) {
			error = new ErrorPOJO(StatelessLoginFilter.INTERNAL_SERVER_ERROR,
					AuthorServicesConstants.SERVERERRORMESSAGE);
		} else if (StatelessLoginFilter.USER_NOT_EXIST_MSG_CODE
				.equalsIgnoreCase(failed.getMessage())) {
			error = new ErrorPOJO(StatelessLoginFilter.USER_NOT_EXIST_CODE,
					StatelessLoginFilter.USER_NOT_EXIST_MSG);
		} else {
			error = new ErrorPOJO(StatelessLoginFilter.INVALID_LOGIN_CODE,
					StatelessLoginFilter.INVALID_LOGIN_MESSAGE);
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
