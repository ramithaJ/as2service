/**
 * 
 */
package com.wiley.gr.ace.authorservices.web.controllers;

/**
 * @author virtusa
 *
 */

//import org.junit.Before;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.wiley.gr.ace.authorservices.web.controllers.UserLoginController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testmvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class UserLoginControllerTest {

	@Autowired
	private UserLoginController userLoginController;

	//UserLoginController userLoginController = new UserLoginController();

	private MockMvc mockMvc;

	@Before
	public void init() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(userLoginController).build();
	}

	@Test
	public void login() throws Exception {
		mockMvc.perform(
				post("/user/login/").contentType(MediaType.APPLICATION_JSON)
						.content(
								"{\"emailId\":\"dwebb@hotmail.com\", \"password\":\"Password\"}"
										.getBytes()))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload.userId").value("1020"));
	}
	
	@Test
	public void validateSecurityQuestions() throws Exception {
		mockMvc.perform(
				post("/user/securityQuestions/validate").contentType(MediaType.APPLICATION_JSON)
						.content(
								"{\"emailId\":\"shiva@gmail.com\", \"securityDetails\": [ "
								+ "{ \"securityQuestion\" : \"What is name o44f your elementary/primary school?\", \"securityAnswer\" : \"Vivekananda vidhya nikethan\" }, "
								+ "{ \"securityQuestion\" : \"  What is the country of your ultimate dream vacation?\" , \"securityAnswer\" : \"U.\"} ] }"
										.getBytes()))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload.userId").value("1020"));
	}
	
	@Test
	public void userSecurityQuestions() throws Exception {
		mockMvc.perform(
				get("/user/userSecurityQuestions/shiva%40gmail.com/").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload.securityDetails[0].securityQuestionId").value("SecurityQuestion1"))
				.andExpect(jsonPath("$.payload.securityDetails[0].securityQuestion").value("What is name of your elementary/primary school?"))
				
				.andExpect(jsonPath("$.payload.securityDetails[1].securityQuestionId").value("SecurityQuestion2"))
				.andExpect(jsonPath("$.payload.securityDetails[1].securityQuestion").value("What is the country of your ultimate dream vacation?"));
	}
	
	@Test
	public void resetPassword() throws Exception {
		mockMvc.perform(
				post("/user/password/reset/").contentType(MediaType.APPLICATION_JSON)
						.content(
								"{\"emailId\":\"shiva@gmail.com\", \"securityDetails ["
								+ "{ \"securityQuestionId\":\"SEQ1\" , \"securityQuestion\":\"What is name of your elementary/primary school?\", \"securityAnswer\": \"Vivekananda vidhya nikethan\" \" },"
								+ "{ \"securityQuestionId\":\"SEQ2\" , \"securityQuestion\":\"What is the country of your ultimate dream vacation?\", \"securityAnswer\": \"U.S\" \" }],"
								+ "\"password\":\"Password\"}"
										.getBytes()))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload").value("true"));
	}
	
	@Test
	public void lockUser() throws Exception {
		mockMvc.perform(
				post("/user/lockUser/shiva%40gmail.com/").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload").value("true"));
	}
	
	@Test
	public void unLockUser() throws Exception {
		mockMvc.perform(
				post("/user/unLockUser/shiva%40gmail.com/").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload").value("true"));
	}
	
	@Test
	public void updatePassword() throws Exception {
		mockMvc.perform(
				post("/user/password/update").contentType(MediaType.APPLICATION_JSON)
				.content(
						"{\"emailId\":\"shiva@gmail.com\", \"oldPassword\":\"Password\" , \"newPassword\":\"PASSWORD\"}"
								.getBytes()))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("Success"))
				.andExpect(jsonPath("$.payload").value("true"));
	}
	
	
}
