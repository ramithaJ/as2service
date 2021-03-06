/*******************************************************************************
 * Copyright (c) 2015 John Wiley & Sons, Inc. All rights reserved.
 *
 * All material contained herein is proprietary to John Wiley & Sons 
 * and its third party suppliers, if any. The methods, techniques and 
 * technical concepts contained herein are considered trade secrets 
 * and confidential and may be protected by intellectual property laws.  
 * Reproduction or distribution of this material, in whole or in part, 
 * is strictly forbidden except by express prior written permission 
 * of John Wiley & Sons.
 *******************************************************************************/
package com.wiley.gr.ace.authorservices.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;

/**
 * This class serves as a global exception handler for all controller classes.
 * 
 * @author virtusa version 1.0
 */
@ControllerAdvice
public class ASExceptionController {

    /**
     * This field holds the value of LOGGER.
     */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ASExceptionController.class);

    /**
     * This field holds the value of internalErrorCode.
     */
    public static final String INTERNALERRORCODE = "UNABLE_PROCESS_REQ_ERR_TEXT";

    /**
     * This field holds the value of PRINTSTACKTRACE
     */
    private static final String PRINTSTACKTRACE = "Print Stack Trace-";

    /**
     * This field holds the value of FAILURE
     */
    private static final String FAILURE = "FAILURE";

    /**
     * This method is used to handle ASException.
     *
     * @param asException
     *            the as exception
     * @return the service
     * @return.
     */
    @ExceptionHandler(ASException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public final Service handleASException(final ASException asException) {

        LOGGER.info("Inside handleASException metod");

        Service response = new Service();
        LOGGER.error("Error Trace - ", asException);
        response.setStatus(FAILURE);
        ErrorPOJO errorPojo = new ErrorPOJO();
        String errorCode = asException.getErrorCode();
        if (errorCode != null && !errorCode.isEmpty()) {
            errorPojo.setCode(errorCode);
        }
        errorPojo.setMessage(asException.getDescription());
        response.setError(errorPojo);
        return response;

    }

    /**
     * This method is used to handle Exception.
     *
     * @param exception
     *            the exception
     * @return the service
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public final Service handleException(final Exception exception) {

        LOGGER.info("Inside handleException method");
        LOGGER.error(PRINTSTACKTRACE, exception);
        Service response = new Service();
        response.setStatus(FAILURE);
        ErrorPOJO errorPojo = new ErrorPOJO();
        errorPojo.setCode(INTERNALERRORCODE);
        errorPojo.setMessage(exception.getMessage());
        response.setError(errorPojo);

        return response;

    }

    /**
     * This method is used to handle Exception.
     * 
     * @param userException
     *            - Input value
     * @return service..
     */
    @ExceptionHandler(UserException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public final Service handleUserException(final UserException userException) {

        LOGGER.info("Inside handleUserException method");
        Service response = new Service();
        LOGGER.error("Error Trace - ", userException);
        response.setStatus(FAILURE);
        ErrorPOJO errorPojo = new ErrorPOJO();
        String errorCode = userException.getErrorCode();
        if (errorCode != null && !errorCode.isEmpty()) {
            errorPojo.setCode(errorCode);
        }
        errorPojo.setMessage(userException.getDescription());
        response.setError(errorPojo);
        return response;

    }

    @ExceptionHandler(LicenseException.class)
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public final Service handleLicenseException(
            final LicenseException licenseException) {

        LOGGER.info("Inside handleLicenseException method");
        Service response = new Service();
        LOGGER.error(PRINTSTACKTRACE, licenseException);
        response.setStatus(FAILURE);
        ErrorPOJO errorPojo = new ErrorPOJO();
        String errorCode = licenseException.getErrorKey();
        if (errorCode != null && !errorCode.isEmpty()) {
            errorPojo.setErrorKey(errorCode);
        }
        errorPojo.setMessage(licenseException.getDescription());
        response.setError(errorPojo);
        return response;

    }

}
