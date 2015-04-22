package com.wiley.gr.ace.authorservices.services.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.wiley.gr.ace.authorservices.model.Security;
import com.wiley.gr.ace.authorservices.model.Service;
import com.wiley.gr.ace.authorservices.persistence.context.PersistenceBeanConfig;
import com.wiley.gr.ace.authorservices.persistence.entity.UserSecurityDetails;
import com.wiley.gr.ace.authorservices.persistence.services.DashBoardDao;
import com.wiley.gr.ace.authorservices.services.service.DashBoardService;

public class DashBoardServiceImpl implements DashBoardService {
	private static ApplicationContext context = new AnnotationConfigApplicationContext(
			PersistenceBeanConfig.class);
	DashBoardDao dashBoardDao=(DashBoardDao)context.getBean("DashBoardDao");
	@Override
	public List getAllAuthorArticles() {
		// TODO Auto-generated method stub
		return dashBoardDao.getAllAuthorArticles();	 
	}
	@Override
	public Service getProfileMeter(int userId) {

		Service service = new Service();
		Security security=new Security();
		List<UserSecurityDetails> test=dashBoardDao.getProfileMeter(userId);
		System.out.println("========="+test.size());
        security.setSecurityQuestion1(test.get(0).getSecurityQuestion());
        security.setSecurityAnswer1(test.get(0).getSecurityAnswer());
        security.setSecurityQuestion2(test.get(1).getSecurityQuestion());
        security.setSecurityAnswer2(test.get(1).getSecurityAnswer());
        if((null==security.getSecurityQuestion1()||null==security.getSecurityAnswer1()) && (null==security.getSecurityQuestion2()&& null==security.getSecurityAnswer2())) {
        	service.setStatus("Please Fill All Questions and Answers");
        	return service;
        }
        else if(null==security.getSecurityQuestion1()&& null==security.getSecurityAnswer1())
        {
        	service.setStatus("question1 and answer1 is missed");
        	return service;
        }else if(null==security.getSecurityQuestion2()&& null==security.getSecurityAnswer2()){
        	
        	service.setStatus("question2 and answer2 is missed");
        	return service;
        }else{
        	service.setStatus("everything is fine ");
        	return service;
        
        }
				
	}

}
