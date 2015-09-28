/**
 * 
 */
package com.wiley.gr.ace.authorservices.web.controllers;

/**
 * @author virtusa
 *
 */
//import org.junit.Before;
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

import com.wiley.gr.ace.authorservices.web.controllers.UpdateUserController;


//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:testmvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class UpdateUserControllerTest {
	
	@Autowired
	private UpdateUserController updateUserController;
	
	//UpdateUserControllerTest updateUserControllerTest = new UpdateUserControllerTest();
		
	//@Autowired
	private MockMvc mockMvc;
	
	@Before  
	public void init() {  
		this.mockMvc = MockMvcBuilders.standaloneSetup(updateUserController).build();
		}  
	
	@Test
    public void updateOrcidId() throws Exception{
	 mockMvc.perform(
			 post("/user/update/orcid/{orcidId}/{userId}").contentType(MediaType.APPLICATION_JSON)
               .content("{ \"emailId\": \"john%40wiley.com\" }"
               		.getBytes()))
               		.andExpect(status().isOk())
					.andExpect(jsonPath("$.status").value("SUCCESS"))
					.andExpect(jsonPath("$.payload").value("true")); 	
	}
}