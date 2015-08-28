package com.wiley.gr.ace.authorservices.web.controllers;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;





import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;

import com.wiley.gr.ace.authorservices.web.controllers.ArticleAssignmentController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:testmvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class ArticleAssignmentControllerTest {
	
	@Autowired
    private ArticleAssignmentController articleAssignmentController;
	
	
	@Autowired
	private MockMvc mockMvc;
	 
	@Before  
	public void init() {
			this.mockMvc = MockMvcBuilders.standaloneSetup(articleAssignmentController).build();
		}  
	
	@Test
	 public void getArticleInfo() throws Exception
	 {
	mockMvc.perform(get("/article/confirm/display/{emailId}")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
			  
			  .andExpect(jsonPath("$.status").value("SUCCESS"))
			  .andExpect(jsonPath("$.payload.articleInfo.articleAuthId").value("1000"))
			  .andExpect(jsonPath("$.payload.articleInfo.articleDetails.articleId").value("3"))
			  .andExpect(jsonPath("$.payload.articleInfo.articleDetails.articleTitle").value("AS Article"))
			  .andExpect(jsonPath("$.payload.articleInfo.articleDetails.publicationDate").value("10-JAN-2014"))
			  .andExpect(jsonPath("$.payload.articleInfo.articleUserRoleDetails.roleCode").value("010"))
			  .andExpect(jsonPath("$.payload.articleInfo.articleUserRoleDetails.roleName").value("Author"))
			  .andExpect(jsonPath("$.payload.articleInfo.articleAuthId").value("1000"))
			  .andExpect(jsonPath("$.payload.articleInfo.articleAuthId.articleDetails.articleId").value("4"))
			  .andExpect(jsonPath("$.payload.articleInfo.articleAuthId.articleDetails.articleId").value("AS Article"))
			  .andExpect(jsonPath("$.payload.articleInfo.articleAuthId.articleDetails.articleId").value("10-JAN-2014"))
			  .andExpect(jsonPath("$.payload.articleInfo.articleUserRoleDetails.roleCode").value("010"))
			  .andExpect(jsonPath("$.payload.articleInfo.articleUserRoleDetails.roleName").value("Author"));
					 		
	 }
	
	
	@Test
	 public void associationConfirmation() throws Exception
	 {
		
		mockMvc.perform(post("/article/confirm/association")
				  .contentType(MediaType.APPLICATION_JSON)
				  .content("{\"taskId\": \"55\", \"isAssociationConfirmed\": \"true\"}".getBytes()))
				  .andExpect(status().isOk())
				  .andExpect(jsonPath("$.status").value("SUCCESS"))
				  .andExpect(jsonPath("$.payload").value("true"));
	 }
	
	
	@Test
	 public void viewAssignedArticle() throws Exception
	 {
		
		mockMvc.perform(get("/article/confirm/view/{emailId}")
				  .contentType(MediaType.APPLICATION_JSON))
				  .andExpect(status().isOk())
				  .andExpect(jsonPath("$.status").value("SUCCESS"))
				  .andExpect(jsonPath("$.payload").value("true"))
		.andExpect(jsonPath("$.payload.articleData.journal.dhId").value("Journal1234"))
		.andExpect(jsonPath("$.payload.articleData.journal.journalTitle").value("ABC Journal"))
		.andExpect(jsonPath("$.payload.articleData.journal.journalDoi").value("10.1002"))
		.andExpect(jsonPath("$.payload.articleData.journal.issn").value("999-1231-100"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.dhId").value("1111"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.articleTitle").value("ABC Article"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.email").value("john@wiley.com"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.articleDoi").value("10.1002"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.publicationDate").value("1-1-2014"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.acceptanceDate").value("1-1-2014"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAcceptedInOO").value("Makee OO"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName").value("john"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.articleCoAuthors").value("Mike"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.articleCoAuthors").value("clarke"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.issue").value("9999"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.volume").value("8877"))
		.andExpect(jsonPath("$.payload.articleData.articleDetails.editorialRefCode").value("234"))
		.andExpect(jsonPath("$.payload.articleData.order.ooUniqueId").value("9876"))
		.andExpect(jsonPath("$.payload.articleData.publication.publicationStatus").value("Request OO"))
		.andExpect(jsonPath("$.payload.articleData.publication.modifiedDate").value("2-2-2014"))
		.andExpect(jsonPath("$.payload.articleData.publication.publicationPath").value("From AS2.0"));
		
	 }
}
