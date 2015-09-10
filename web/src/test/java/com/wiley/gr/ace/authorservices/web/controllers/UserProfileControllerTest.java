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


import com.wiley.gr.ace.authorservices.web.controllers.UserProfileController;


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
public class UserProfileControllerTest {
	
	@Autowired
	private UserProfileController userProfileController;
	
	//UserProfileController userProfileController = new UserProfileController();
		
	//@Autowired
	private MockMvc mockMvc;
	
	@Before  
	public void init() {  
		this.mockMvc = MockMvcBuilders.standaloneSetup(userProfileController).build();
		}  
	
	@Test
	public void getAffiliationsList() throws Exception {
		mockMvc.perform(
				get("/userprofile/affiliations/2000").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].affiliationId").value("10895"))
				.andExpect(jsonPath("$.payload[0].institutionId").value("Institution1"))
				.andExpect(jsonPath("$.payload[0].departmentId").value("Department1"))
				.andExpect(jsonPath("$.payload[0].city").value("Hyderabad"))
				.andExpect(jsonPath("$.payload[0].stateCode").value("1234"))
				.andExpect(jsonPath("$.payload[0].countryCode").value("123456"))
				.andExpect(jsonPath("$.payload[0].startDate").value("1335205543511"))
				.andExpect(jsonPath("$.payload[0].endDate").value("1337797543511"))

				.andExpect(jsonPath("$.payload[1].affiliationId").value("258947"))
				.andExpect(jsonPath("$.payload[1].institutionId").value("Institution2"))
				.andExpect(jsonPath("$.payload[1].departmentId").value("Department2"))
				.andExpect(jsonPath("$.payload[1].city").value("Secundrabad"))
				.andExpect(jsonPath("$.payload[1].stateCode").value("123456"))
				.andExpect(jsonPath("$.payload[1].countryCode").value("1234567"))
				.andExpect(jsonPath("$.payload[1].startDate").value("1337797543511"))
				.andExpect(jsonPath("$.payload[1].endDate").value("1340475943511"));
						
				
	}
	
	@Test
	public void getCoAuthorsList() throws Exception {
		mockMvc.perform(
				get("/userprofile/coAuthors/2000").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].coAuthorId").value("123456789"))
				.andExpect(jsonPath("$.payload[0].title").value("Mr"))
				.andExpect(jsonPath("$.payload[0].firstName").value("john"))
				.andExpect(jsonPath("$.payload[0].lastName").value("wiley"))
				.andExpect(jsonPath("$.payload[0].emailId").value("john@gmail.com"))
				.andExpect(jsonPath("$.payload[0].phone").value("1235948766"))
				.andExpect(jsonPath("$.payload[0].institutionName").value("wiley"))
				.andExpect(jsonPath("$.payload[0].departmentName").value("john"))

				.andExpect(jsonPath("$.payload[1].coAuthorId").value("1234789"))
				.andExpect(jsonPath("$.payload[1].title").value("Mr"))
				.andExpect(jsonPath("$.payload[1].firstName").value("john2"))
				.andExpect(jsonPath("$.payload[1].lastName").value("wiley2"))
				.andExpect(jsonPath("$.payload[1].emailId").value("john2@gmail.com"))
				.andExpect(jsonPath("$.payload[1].phone").value("1235948722"))
				.andExpect(jsonPath("$.payload[1].institutionName").value("wiley2"))
				.andExpect(jsonPath("$.payload[1].departmentName").value("john2"));
						
				
	}
	
	@Test
	public void getSocieties() throws Exception {
		mockMvc.perform(
				get("/userprofile/societies/{UserId}").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].societyId").value("123456"))
				.andExpect(jsonPath("$.payload[0].societyName").value("Society1"))
				.andExpect(jsonPath("$.payload[0].membershipNumber").value("12345"))
				.andExpect(jsonPath("$.payload[0].promoCode").value("5927"))
				.andExpect(jsonPath("$.payload[0].startDate").value("1327343143511"))
				.andExpect(jsonPath("$.payload[0].endDate").value("1330021543511"))
				
				.andExpect(jsonPath("$.payload[1].societyId").value("759874"))
				.andExpect(jsonPath("$.payload[1].societyName").value("Society2"))
				.andExpect(jsonPath("$.payload[1].membershipNumber").value("1234567"))
				.andExpect(jsonPath("$.payload[1].promoCode").value("8292"))
				.andExpect(jsonPath("$.payload[1].startDate").value("1353695143511"))
				.andExpect(jsonPath("$.payload[1].endDate").value("1351016743511"));
								
	}
	
	@Test
    public void updateSocietyDetails() throws Exception{
	 mockMvc.perform(
			 post("/userprofile/societies/{userId}").contentType(MediaType.APPLICATION_JSON)
               .content("{ \"societyId\": \"id1\", \"societyName\": \"Society1\",\"membershipNumber\": \"12345\",\"promoCode\": \"5927\",\"startDate\": \"1353695143511\", \"endDate\": \"1353695143511\"  "         		
               		+ " }"
               		.getBytes()))
               		.andExpect(status().isOk())
					.andExpect(jsonPath("$.status").value("SUCCESS")); 	
	}
	 
	
	@Test
	public void getMyInterests() throws Exception {
		mockMvc.perform(
				get("/userprofile/interests/2000/").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].aoeId").value("AOE001"))
				.andExpect(jsonPath("$.payload[0].aoeCategory").value("Chemistry"))
				.andExpect(jsonPath("$.payload[0].aoeName").value("BioChemistry"))
				
				.andExpect(jsonPath("$.payload[1].aoeId").value("AOE112"))
				.andExpect(jsonPath("$.payload[1].aoeCategory").value("Robotics"))
				.andExpect(jsonPath("$.payload[1].aoeName").value("Robotics"));
				

	}
	
	@Test
	public void getAreasOfInterests() throws Exception {
		mockMvc.perform(
				get("/userprofile/interests/{userId}").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].aoeId").value("AOE001"))
				.andExpect(jsonPath("$.payload[0].aoeCategory").value("Chemistry"))
				.andExpect(jsonPath("$.payload[0].aoeName").value("BioChemistry"))			
				
				.andExpect(jsonPath("$.payload[1].aoeId").value("AOE112"))
				.andExpect(jsonPath("$.payload[1].aoeCategory").value("Robotics"))
				.andExpect(jsonPath("$.payload[1].aoeName").value("Robotics"));						
				
								
	}
	
	
	
	@Test
	public void getPreferredJournals() throws Exception {
		mockMvc.perform(
				get("/userprofile/preferredJournals/2000").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].journalId").value("101"))
				.andExpect(jsonPath("$.payload[0].journalTitle").value("TTest"))

				.andExpect(jsonPath("$.payload[1].journalId").value("102"))
				.andExpect(jsonPath("$.payload[1].journalTitle").value("TTest2"));			
						
				
	}
	
	@Test
	public void searchPreferredJournals() throws Exception {
		mockMvc.perform(
				get("/userprofile/preferredJournals/{userId}").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].journalId").value("101"))
				.andExpect(jsonPath("$.payload[0].journalTitle").value("TTest"));			
						
				
	}
	
	@Test
	public void getListOfAlerts() throws Exception {
		mockMvc.perform(
				get("/userprofile/alerts/{userId}").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload.alertsList.alertId").value("123"))
				.andExpect(jsonPath("$.payload.alertsList.alertName").value("Test"))
				.andExpect(jsonPath("$.payload.alertsList.onScreen").value("false"))
				.andExpect(jsonPath("$.payload.alertsList.email").value("true"))
				
				
				.andExpect(jsonPath("$.payload.emailsList").value("test@gmail.com"));
			
	}
	
	@Test
	public void getResearchFundersList() throws Exception {
		mockMvc.perform(
				get("/userprofile/researchFunders/2000").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload.researchFunderId").value("1234"))
				.andExpect(jsonPath("$.payload.researchFunderName").value("Funder1"))
				.andExpect(jsonPath("$.payload.grantNumber[0]").value("12"))
				.andExpect(jsonPath("$.payload.grantNumber[1]").value("13"))
				.andExpect(jsonPath("$.payload.grantNumber[2]").value("14"))
				
				.andExpect(jsonPath("$.payload.researchFunderId").value("12345"))
				.andExpect(jsonPath("$.payload.researchFunderName").value("Funder2"))
				.andExpect(jsonPath("$.payload.grantNumber[0]").value("15"))
				.andExpect(jsonPath("$.payload.grantNumber[1]").value("16"));

	}
	
	@Test
    public void updateAlerts() throws Exception{
	 mockMvc.perform(
			 post("/userprofile/alerts").contentType(MediaType.APPLICATION_JSON)
               .content("{ \"alertId\": \"11\", "
               		+ "\"alertName\": \"Article Submitted\", "
               		+ "\"onScreen\": \"false\", "
               		+ "\"email\": \"true\" }"
               		.getBytes()))
               		.andExpect(status().isOk())
					.andExpect(jsonPath("$.status").value("SUCCESS")); 		
 
 }

	
	@Test
	public void updateAffiliation() throws Exception {
		mockMvc.perform(
				post("userprofile/affiliations/2000/1234/").contentType(MediaType.APPLICATION_JSON)
				 .content("{ \"affiliations\" { " 
               		+ "\"institutionId\": \"Institution1\", \"departmentId\": \"Department1\",\"city\": \"Hyderabad\",\"stateCode\": \"1234\",\"countryCode\": \"123456\",\"startDate\": \"2012-11-23T18:25:43.511Z\",\"endDate\": \"2012-11-23T18:25:43.511Z\" "
               		+ " }"
               		.getBytes()))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload").value("true"));
				

	}
	
	@Test
	public void updateResearchFunder() throws Exception {
		mockMvc.perform(
				post("userprofile/researchFunder/2000/").contentType(MediaType.APPLICATION_JSON)
				 .content("{ \"researchFunders\" { " 
               		+ "\"researchFunderId\": \"2345\", \"researchFunderName\": \"Funder1\",\"grantNumber\": [\"12\",\"13\",\"14\"] "
               		+ " }"
               		.getBytes()))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload").value("true"));
				

	}
	
	@Test
	public void updateCoAuthors() throws Exception {
		mockMvc.perform(
				post("/userprofile/coAuthors/2000/").contentType(MediaType.APPLICATION_JSON)
				.content("{ \"coAuthors\" { " 
               		+ "\"title\": \"Mr\", \"firstName\": \"john\",\"lastName\": \"wiley\",\"emailId\": \"john@gmail.com\",\"phone\": \"1235948766\",\"institutionName\": \"wiley\",\"departmentName\": \"john\" " 
               		+ " }"
               		.getBytes()))	
				
				
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"));

	}
	
	
	 @Test
	    public void deletePreferredJournals() throws Exception{
		 mockMvc.perform(
				 post("/userprofile/preferredJournals/").contentType(MediaType.APPLICATION_JSON)
				 .content(""))
				 .andExpect(status().isOk())
				 .andExpect(jsonPath("$.status").value("SUCCESS"));

}
	
}	