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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testmvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class DashBoardControllerTest {
	
		@Autowired
		private DashboardController dashboardController;

		//DashBoardController dashBoardController = new DashBoardController();

		private MockMvc mockMvc;

		@Before
		public void init() {
			this.mockMvc = MockMvcBuilders.standaloneSetup(dashboardController).build();
		}

		@Test
		public void getProfileMeter() throws Exception {
			mockMvc.perform(
					get("/dashboard/profilemeter/{userId}").contentType(MediaType.APPLICATION_JSON))
							
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.status").value("SUCCESS"))
					.andExpect(jsonPath("$.payload.profileMeterMessage").value(""))
					.andExpect(jsonPath("$.payload.dashBoardInfo.id").value("security"))
					.andExpect(jsonPath("$.payload.dashBoardInfo.dashBoardInfoMessage").value("No Security Details"))
					
					.andExpect(jsonPath("$.payload.dashBoardInfo.id").value("email"))
					.andExpect(jsonPath("$.payload.dashBoardInfo.dashBoardInfoMessage").value("No Secondary Email(Recovery Email Addr)"))
					
					.andExpect(jsonPath("$.payload.dashBoardInfo.id").value("orcid"))
					.andExpect(jsonPath("$.payload.dashBoardInfo.dashBoardInfoMessage").value("No Orcid ID"))
					
					.andExpect(jsonPath("$.payload.dashBoardInfo.id").value("my-interests"))
					.andExpect(jsonPath("$.payload.dashBoardInfo.dashBoardInfoMessage").value("No Areas Of Expertizes(Interests) Details"))
					
					.andExpect(jsonPath("$.payload.dashBoardInfo.id").value("affiliations"))
					.andExpect(jsonPath("$.payload.dashBoardInfo.dashBoardInfoMessage").value("No Affiliation Details"))
					
					.andExpect(jsonPath("$.payload.dashBoardInfo.id").value("societies"))
					.andExpect(jsonPath("$.payload.dashBoardInfo.dashBoardInfoMessage").value("No Society Details"))
					
					.andExpect(jsonPath("$.payload.dashBoardInfo.id").value("research-funder"))
					.andExpect(jsonPath("$.payload.dashBoardInfo.dashBoardInfoMessage").value("No Research Funders Details"))
					
					.andExpect(jsonPath("$.status").value("SUCCESS"))
					.andExpect(jsonPath("$.payload.profileMeterMessage").value("Profile Completed"))
					.andExpect(jsonPath("$.payload.dashBoardInfo.dashBoardInfo").value("0"))					;
					
		}
		
}
