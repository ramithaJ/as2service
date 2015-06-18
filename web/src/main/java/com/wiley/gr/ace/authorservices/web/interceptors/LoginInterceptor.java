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

package com.wiley.gr.ace.authorservices.web.interceptors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.external.util.AuthorServicesUtil;
import com.wiley.gr.ace.authorservices.external.util.RestServiceInvokerUtil;
import com.wiley.gr.ace.authorservices.model.Login;
import com.wiley.gr.ace.authorservices.services.service.AdminLoginService;

/**
 * @author virtusa version 1.0
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {

    /**
     * AdminLoginService bean.
     */
    @Autowired(required = true)
    AdminLoginService adminLoginService;

    /**
     * this method will call the LDAP/AD authentication service.
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {

        String payLoad = AuthorServicesUtil.readStream(
                request.getInputStream(), 100);
        String token = "";
        JSONObject postJSON = new JSONObject(payLoad);
        Login login = new Login();
        login.setEmailId(postJSON.getString("emailId"));
        login.setPassword(postJSON.getString("password"));
        request.setAttribute("emailId", login.getEmailId());
        try {

            token = RestServiceInvokerUtil.invokeService(
                    "http://10.201.64.81:8080/service/v1/auth/authenticate",
                    HttpMethod.POST, "Login", login);
            System.out.println("Token from Authentication Service:::" + token);
            if (token != null
                    && adminLoginService.validateEmail(login.getEmailId())) {

                if (request.getCookies() != null
                        && request.getCookies().length > 0) {

                    Cookie existingCookie = request.getCookies()[0];
                    existingCookie.setMaxAge(0);
                    response.addCookie(existingCookie);
                } else {
                    Cookie cookie = new Cookie("AUTH_TOKEN", token);
                    cookie.setMaxAge(21600);
                    cookie.setHttpOnly(false);
                    response.addCookie(cookie);
                }
            }

        } catch (ASException e) {
            throw new ASException(e.getErrorCode(), e.getDescription());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Inside Exception block");
            throw new ASException();
        }
        return super.preHandle(request, response, handler);
    }

    /**
     * postHandle method.
     */
    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("Inside postHandle of LoginInterceptor");
        super.postHandle(request, response, handler, modelAndView);
    }

}
