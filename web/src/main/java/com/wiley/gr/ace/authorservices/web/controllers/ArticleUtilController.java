package com.wiley.gr.ace.authorservices.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wiley.gr.ace.authorservices.model.ErrorPOJO;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.services.service.ArticleAssignmentService;

@RequestMapping(value = "/articleutil")
public class ArticleUtilController {

	@Autowired(required = true)
	private ArticleAssignmentService articleAssignmentService;
	
	@RequestMapping(value="/getinvitestatus/{dhId}")
	public @ResponseBody Service getArticleInvitationStatus(@PathVariable("dhId") Integer dhId){
		Service service = new Service();
		try{
			if(articleAssignmentService.checkIfArticleInvited(dhId)){
				service.setStatus("SUCCESS");
			} else {
				service.setStatus("FAILURE");
				ErrorPOJO err = new ErrorPOJO();
				err.setCode(179);
				err.setMessage("Article is not invited in AS");
				service.setError(err);
			}
		} catch (Exception e) {
			service.setStatus("ERROR");
			ErrorPOJO err = new ErrorPOJO();
			err.setCode(171);
			err.setMessage("Fetching article status encounter exception");
			service.setError(err);
		}
		
		return service;
	}
}
