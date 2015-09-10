/**
 * 
 */
package com.wiley.gr.ace.authorservices.web.controllers;

/**
 * @author virtusa
 *
 */

//import org.junit.Before;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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

import com.wiley.gr.ace.authorservices.web.controllers.OrcidController;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:mvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class OrcidControllerTest {
	
		@Autowired
		private OrcidController orcidController;

	// OrcidController orcidController = new OrcidController();

		private MockMvc mockMvc;

		@Before
		public void init() {
			this.mockMvc = MockMvcBuilders.standaloneSetup(orcidController).build();
		}

		@Test
		 public void getorcidURL() throws Exception {
				mockMvc.perform(
						get("/user/orcid/url").contentType(MediaType.APPLICATION_JSON))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.status").value("SUCCESS"))
						.andExpect(jsonPath("$.payload").value("https://sandbox.orcid.org/oauth/authorize?client_id=APP-EU26CF7K2HTG34SV&response_type=code&scope=/authenticate&redirect_uri=http://www.vinay.com:8080/orcid/index.jsp"));
		 }	

		
		@Test
		public void getOrcidDetails() throws Exception {
				mockMvc.perform(
						get("/user/orcid/profile").contentType(MediaType.APPLICATION_JSON)
						.content("Type = registration/userupdate (for reg UC use registration/ for update use UC userupdate)"
								+ " Code = authorization code which you receive from callback"
								.getBytes()))
						.andExpect(status().isOk())
						.andExpect(jsonPath("$.status").value("SUCCESS"))
						.andExpect(jsonPath("$.payload.firstName").value("Vinay"))
						.andExpect(jsonPath("$.payload.lastName").value("Kumar"))
						.andExpect(jsonPath("$.payload.primaryEmailAddress").value("kondavinay@gmail.com"))
						.andExpect(jsonPath("$.payload.orcidID").value("0000-0003-3247-3163"))
						.andExpect(jsonPath("$.payload.searchFullName").value("false"))
						.andExpect(jsonPath("$.payload.address.correspondenceaddress.country.countryCode").value("IN"))
						.andExpect(jsonPath("$.payload.address.correspondenceaddress.country.countryName").value("INDIA"));
		}			

}
