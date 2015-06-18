/**
 * 
 */
package com.wiley.gr.ace.authorservices.web.controllers;

/**
 * @author virtusa
 *
 */
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;





import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;


import com.wiley.gr.ace.authorservices.web.controllers.RegistrationController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testmvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class RegistrationControllerTest {
	
	@Autowired
	private RegistrationController registrationController;
	
//	RegistrationController registrationController = new RegistrationController();
		
	
	private MockMvc mockMvc;
	
	@Before  
	public void init() {  
		this.mockMvc = MockMvcBuilders.standaloneSetup(registrationController).build();
		}  

	@Test
	public void checkUserExists() throws Exception {
		mockMvc.perform(
				get("/registration/verify/email").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("FAILURE"))
				.andExpect(jsonPath("$.payload.firstname").value("No Data"))
				.andExpect(jsonPath("$.payload.lastName").value("No Data"))
				.andExpect(jsonPath("$.payload.primaryEmailAddr").value("No@gmail.com"))
				.andExpect(jsonPath("$.payload.searchFullName").value("false"))
				.andExpect(jsonPath("$.payload.country.countryName").value("No Data"))
				.andExpect(jsonPath("$.error.code").value("203"))
				.andExpect(jsonPath("$.error.message").value("Email address exists in the system but not registered with AS 2.0"));
				
	}		
	
	@Test
	public void createUserwithfullname() throws Exception {
		mockMvc.perform(
				post("/registration/register").contentType(MediaType.APPLICATION_JSON)
				.content("{\"primaryEmailAddr\":\"dishari.de@gmail.com\", \"firstName\":\"Dishari\"  \"lastName\":\"De\" \"country\": "
						+ "{ \"countryCode\":\"Test\", \"countryName\":\"Test\" }  \"password\":\"password\", \"termsOfUseFlg\":\"Y\" , \"searchFullName\":\"true\"}"
							
							.getBytes()))		
				//.andExpect(status().isOk())
			
				.andExpect(jsonPath("$.status").value("FAILURE"))
				.andExpect(jsonPath("$.payload.firstname").value("No Data"))
				.andExpect(jsonPath("$.payload.lastName").value("No Data"))
				.andExpect(jsonPath("$.payload.primaryEmailAddr").value("No@gmail.com"))
				.andExpect(jsonPath("$.payload.searchFullName").value("false"))
				.andExpect(jsonPath("$.payload.country.countryName").value("No Data"))
				.andExpect(jsonPath("$.error.code").value("205"))
				.andExpect(jsonPath("$.error.message").value("Firstname and Lastname already exists"));
		
				
	}		
	
	@Test
	public void createUserwithoutfullname() throws Exception {
		mockMvc.perform(
				post("/registration/register").contentType(MediaType.APPLICATION_JSON)
				.content("{\"primaryEmailAddr\":\"dishari.de@gmail.com\", \"firstName\":\"Dishari\"  \"lastName\":\"De\" \"country\": "
						+ "{ \"countryCode\":\"Test\", \"countryName\":\"Test\" }  \"password\":\"password\", \"termsOfUseFlg\":\"Y\" , \"searchFullName\":\"false\"}"
							
							.getBytes()))		
				//.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"));
						
				
	}	
	
	@Test
	public void getInvitationRecord1121() throws Exception {
		
		
		mockMvc.perform(
				get("/registration/invitation/1121").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload.guid").value("1121"))
				.andExpect(jsonPath("$.payload.firstName").value("Max"))
				.andExpect(jsonPath("$.payload.lastName").value("Justice"))
				.andExpect(jsonPath("$.payload.emailAddress").value("madmaxfury@hotmail.com"))
				.andExpect(jsonPath("$.payload.userType").value("COAUTHOR"))
				.andExpect(jsonPath("$.payload.status").value("PENDING"));
		
		
	}		
	
	@Test
	public void getInvitationRecord1122() throws Exception {
		mockMvc.perform(
				get("/registration/invitation/1122").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload.guid").value("1122"))
				.andExpect(jsonPath("$.payload.firstName").value("Jason"))
				.andExpect(jsonPath("$.payload.lastName").value("Bourne"))
				.andExpect(jsonPath("$.payload.emailAddress").value("dwebb76@gmail.com"))
				.andExpect(jsonPath("$.payload.userType").value("AUTHOR"))
				.andExpect(jsonPath("$.payload.status").value("PENDING"));
				
	}		
	
	@Test
	public void getInvitationRecord1123() throws Exception {
		mockMvc.perform(
				get("/registration/invitation/1123").contentType(MediaType.APPLICATION_JSON))
						
				//.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("FAILURE"))
				.andExpect(jsonPath("$.error.code").value("301"))
				.andExpect(jsonPath("$.message").value("User Already Registered"));
				
				
	}	
	
	

}	