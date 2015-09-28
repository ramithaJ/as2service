package com.wiley.gr.ace.authorservices.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.gr.ace.authorservices.exception.ASException;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;

/**
 * The Class ArticleUtilController.
 */
@RestController
@RequestMapping(value = "/articleutil")
public class ArticleUtilController {

    /** logger configured. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(ArticleUtilController.class);

    /** The article assignment service. */
    @Autowired(required = true)
    private ArticleAssignmentService articleAssignmentService;

    /** The Is invited article error code. */
    @Value("${ArticleUtilController.IsInvitedArticle.code}")
    private String invitedArticleErrorCode;

    /** The Is invited article error message. */
    @Value("${ArticleUtilController.IsInvitedArticle.message}")
    private String invitedArticleErrorMessage;

    /** The input parameter not found. */
    @Value("${inputParameterNotFound.message}")
    private String inputParameterNotFound;

    /** The no data found. */
    @Value("${noDataFound.message}")
    private String noDataFound;

    /**
     * Gets the article invitation status.
     *
     * @param dhId
     *            the dh id
     * @return the article invitation status
     */
    @RequestMapping(value = "/getinvitestatus/{dhId}")
    public final Service getArticleInvitationStatus(
            @PathVariable("dhId") final String dhId) {
        Service service = new Service();
        if (!StringUtils.isEmpty(dhId)) {
            try {
                if (articleAssignmentService.checkIfArticleInvited(dhId)) {
                    service.setStatus("SUCCESS");
                } else {
                    LOGGER.info("Article Info Details Not Found");
                    service.setStatus("SUCCESS");
                    service.setPayload(noDataFound);
                }
            } catch (Exception e) {
                LOGGER.error("Print Stack Trace- ", e);
                throw new ASException(invitedArticleErrorCode,
                        invitedArticleErrorMessage);
            }
        } else {
            LOGGER.info("input Parameter emailId is Not Found");
            service.setStatus("FAILURE");
            service.setPayload(inputParameterNotFound);
        }
        return service;
    }
}
