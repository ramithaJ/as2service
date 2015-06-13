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


import com.wiley.gr.ace.authorservices.web.controllers.ASDataController;



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
public class ASDataControllerTest {
	
	@Autowired
	private ASDataController asDataController;
	
	//ASDataController asDataController = new ASDataController();
		
	@Autowired
	private MockMvc mockMvc;
	
	@Before  
	public void init() {  
		this.mockMvc = MockMvcBuilders.standaloneSetup(asDataController).build();
		}  
	
	@Test
	public void getTitles() throws Exception {
		mockMvc.perform(
				get("/asdata/titles/").contentType(MediaType.APPLICATION_JSON))
						
				//.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].titleName").value("TITLE1"))
				.andExpect(jsonPath("$.payload[0].titleId").value("Mr"))
				
				.andExpect(jsonPath("$.payload[1].titleName").value("TITLE2"))
				.andExpect(jsonPath("$.payload[1].titleId").value("Mrs"))
		
				.andExpect(jsonPath("$.payload[2].titleName").value("TITLE3"))
				.andExpect(jsonPath("$.payload[2].titleId").value("Miss"))
		
				.andExpect(jsonPath("$.payload[3].titleName").value("TITLE4"))
				.andExpect(jsonPath("$.payload[3].titleId").value("Ms"))
		
				.andExpect(jsonPath("$.payload[4].titleName").value("TITLE5"))
				.andExpect(jsonPath("$.payload[4].titleId").value("Dr"));
	}
	
	@Test
	public void getSuffixes() throws Exception {
		mockMvc.perform(
				get("/asdata/suffixes/").contentType(MediaType.APPLICATION_JSON))
						
				//.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].suffixId").value("SUFFIX1"))
				.andExpect(jsonPath("$.payload[0].suffixName").value("Jr"))
				
				.andExpect(jsonPath("$.payload[1].suffixId").value("SUFFIX2"))
				.andExpect(jsonPath("$.payload[1].suffixName").value("Sr"))
				
				.andExpect(jsonPath("$.payload[2].suffixId").value("SUFFIX3"))
				.andExpect(jsonPath("$.payload[2].suffixName").value("Miss"))
				
				.andExpect(jsonPath("$.payload[3].suffixId").value("SUFFIX4"))
				.andExpect(jsonPath("$.payload[3].suffixName").value("Ms"))
				
				.andExpect(jsonPath("$.payload[4].suffixId").value("SUFFIX5"))
				.andExpect(jsonPath("$.payload[4].suffixName").value("Dr"));
				
				
	}
	
	
	@Test
	public void getIndustries() throws Exception {
		mockMvc.perform(
				get("/asdata/industries").contentType(MediaType.APPLICATION_JSON))
						
				//.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].industryId").value("561311"))
				.andExpect(jsonPath("$.payload[0].industryName").value("Employment Placement Agencies"))
				
				
				.andExpect(jsonPath("$.payload[1].industryId").value("561312"))
				.andExpect(jsonPath("$.payload[1].industryName").value("Executive Search Services"))
				
				.andExpect(jsonPath("$.payload[2].industryId").value("561320"))
				.andExpect(jsonPath("$.payload[2].industryName").value("Temporary Help Services"))
				
				.andExpect(jsonPath("$.payload[3].industryId").value("561330"))
				.andExpect(jsonPath("$.payload[3].industryName").value("Professional Employer Organizations"))
				
				.andExpect(jsonPath("$.payload[4].industryId").value("561410"))
				.andExpect(jsonPath("$.payload[4].industryName").value("Document Preparation Services"))
				
				.andExpect(jsonPath("$.payload[5].industryId").value("561421"))
				.andExpect(jsonPath("$.payload[5].industryName").value("Telephone Answering Services"))
				
				
				.andExpect(jsonPath("$.payload[6].industryId").value("561422"))
				.andExpect(jsonPath("$.payload[6].industryName").value("Telemarketing Bureaus and Other Contact Centers "))
				
				
				.andExpect(jsonPath("$.payload[7].industryId").value("561431"))
				.andExpect(jsonPath("$.payload[7].industryName").value("Private Mail Centers"))
				
				
				.andExpect(jsonPath("$.payload.industryId").value("561439"))
				.andExpect(jsonPath("$.payload.industryName").value("Other Business Service Centers (including Copy Shops)	"))
				
				.andExpect(jsonPath("$.payload.industryId").value("561440"))
				.andExpect(jsonPath("$.payload.industryName").value("Collection Agencies"));
				
						
	}
	
	
	@Test
	public void getUserRoles() throws Exception {
		mockMvc.perform(
				get("/asdata/roles").contentType(MediaType.APPLICATION_JSON))
						
				//.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].roleId").value("7"))
				.andExpect(jsonPath("$.payload[0].roleName").value("Product Support Admins"))
				.andExpect(jsonPath("$.payload[0].roleDescription").value("Responsible for maintaining products. Maintain non-reference product details which is specific for Author Services."))
				.andExpect(jsonPath("$.payload[0].adminRole").value("false"))
				
				.andExpect(jsonPath("$.payload[1].roleId").value("8"))
				.andExpect(jsonPath("$.payload[1].roleName").value("Marketing Admins"))
				.andExpect(jsonPath("$.payload[1].roleDescription").value("Responsible for maintaining static information and help content."))
				.andExpect(jsonPath("$.payload[1].adminRole").value("false"))
				
				.andExpect(jsonPath("$.payload[2].roleId").value("9"))
				.andExpect(jsonPath("$.payload[2].roleName").value("Production Editors"))
				.andExpect(jsonPath("$.payload[2].roleDescription").value("Helps manage licenses (Copyrights)."))
				.andExpect(jsonPath("$.payload[2].adminRole").value("false"))
				
				.andExpect(jsonPath("$.payload[3].roleId").value("5"))
				.andExpect(jsonPath("$.payload[3].roleName").value("Super Admins"))
				.andExpect(jsonPath("$.payload[3].roleDescription").value("Helps manage all admin roles. Responsible for maintaining user roles and permissions."))
				.andExpect(jsonPath("$.payload[3].adminRole").value("false"))
				
				.andExpect(jsonPath("$.payload[4].roleId").value("1"))
				.andExpect(jsonPath("$.payload[4].roleName").value("Author"))
				.andExpect(jsonPath("$.payload[4].roleDescription").value("Author new content and submit to Wiley,Sign copyright license etc"))
				.andExpect(jsonPath("$.payload[4].adminRole").value("false"))
				
				
				.andExpect(jsonPath("$.payload[5].roleId").value("6"))
				.andExpect(jsonPath("$.payload[5].roleName").value("AOS Admin"))
				.andExpect(jsonPath("$.payload[5].roleDescription").value("Responsible for providing customer support. Help resolve login/user account, OO, OA, License related issues."))
				.andExpect(jsonPath("$.payload[5].adminRole").value("false"));
				
				
	}
	
	
	@Test
	 public void getSecurityQuestions() throws Exception
	 {
	mockMvc.perform(get("asdata/securityQuestions")
			  .contentType(MediaType.APPLICATION_JSON))
			  
			 .andExpect(jsonPath("$.payload").isArray())
			 .andExpect(jsonPath("$.payload[0].id").value("SEQ4"))
			 .andExpect(jsonPath("$.payload[0].description").value("What is name of your elementary/primary school?"))
	
	 		 .andExpect(jsonPath("$.payload[1].id").value("SEQ5"))
	 		 .andExpect(jsonPath("$.payload[1].description").value("What is your University Mascot?"))
	 		 
			 .andExpect(jsonPath("$.payload[2].id").value("SEQ6"))
			 .andExpect(jsonPath("$.payload[2].description").value("What is the name of your favorite childhood teacher?"))
			 
			 .andExpect(jsonPath("$.payload[3].id").value("SEQ8"))
			 .andExpect(jsonPath("$.payload[3].description").value("What is the country of your ultimate dream vacation?"))			 
			 		
			 .andExpect(jsonPath("$.payload[4].id").value("SEQ9"))
			 .andExpect(jsonPath("$.payload[4].description").value("What is the name of your favorite childhood teacher?"))	
	 
			 .andExpect(jsonPath("$.payload[5].id").value("SEQ10"))
			 .andExpect(jsonPath("$.payload[5].description").value("What kind of super prower you want?"))
			 
			 .andExpect(jsonPath("$.payload[6].id").value("SEQ1"))
			 .andExpect(jsonPath("$.payload[6].description").value("What is your mother’s maiden name?"))
			 
			 
			 .andExpect(jsonPath("$.payload[7].id").value("SEQ2"))
			 .andExpect(jsonPath("$.payload[7].description").value("In what city were you born?"))			 
			 
			 .andExpect(jsonPath("$.payload[8].id").value("SEQ3"))
			 .andExpect(jsonPath("$.payload[8].description").value("What is your first pet’s name?"))			 
			 
			 .andExpect(jsonPath("$.payload[9].id").value("SEQ7"))
			 .andExpect(jsonPath("$.payload[9].description").value("What was the make and model of your first car?"));			 
			 
				 
	 }
	

	@Test
	public void getJobCategories() throws Exception {
		mockMvc.perform(
				get("/asdata/jobCategories").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].jobCategoryId").value("11-1011"))
				.andExpect(jsonPath("$.payload[0].jobCategoryName").value("CHIEF EXECUTIVES"))
				
				.andExpect(jsonPath("$.payload[1].jobCategoryId").value("11-1011"))
				.andExpect(jsonPath("$.payload[1].jobCategoryName").value("CHIEF EXECUTIVES"))
				
				.andExpect(jsonPath("$.payload[2].jobCategoryId").value("11-1021"))
				.andExpect(jsonPath("$.payload[2].jobCategoryName").value("GENERAL AND OPERATIONS MANAGERS"))
				
				.andExpect(jsonPath("$.payload[3].jobCategoryId").value("11-1021"))
				.andExpect(jsonPath("$.payload[3].jobCategoryName").value("GENERAL AND OPERATIONS MANAGERS"))
				
				.andExpect(jsonPath("$.payload[4].jobCategoryId").value("11-1021"))
				.andExpect(jsonPath("$.payload[4].jobCategoryName").value("GENERAL AND OPERATIONS MANAGERS"))
				
				.andExpect(jsonPath("$.payload[5].jobCategoryId").value("11-1021"))
				.andExpect(jsonPath("$.payload[5].jobCategoryName").value("GENERAL AND OPERATIONS MANAGERS"))
				
				.andExpect(jsonPath("$.payload[6].jobCategoryId").value("11-1021"))
				.andExpect(jsonPath("$.payload[6].jobCategoryName").value("GENERAL AND OPERATIONS MANAGERS"))
				
				.andExpect(jsonPath("$.payload[7].jobCategoryId").value("11-1021"))
				.andExpect(jsonPath("$.payload[7].jobCategoryName").value("GENERAL AND OPERATIONS MANAGERS"))
				
				
				.andExpect(jsonPath("$.payload[8].jobCategoryId").value("11-1031"))
				.andExpect(jsonPath("$.payload[8].jobCategoryName").value("LEGISLATORS"))
				
				.andExpect(jsonPath("$.payload[9].jobCategoryId").value("11-1031"))
				.andExpect(jsonPath("$.payload[9].jobCategoryName").value("LEGISLATORS"));
	}
	
	@Test
	public void getCountries() throws Exception {
		mockMvc.perform(
				get("/asdata/countries").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].countryCode").value("ABW"))
				.andExpect(jsonPath("$.payload[0].countryName").value("ARUBA"))
				
				.andExpect(jsonPath("$.payload[1].countryCode").value("AFG"))
				.andExpect(jsonPath("$.payload[1].countryName").value("AFGHANISTAN"))
	
				.andExpect(jsonPath("$.payload[2].countryCode").value("AGO"))
				.andExpect(jsonPath("$.payload[2].countryName").value("ANGOLA"))
					
				
				.andExpect(jsonPath("$.payload[3].countryCode").value("AIA"))
				.andExpect(jsonPath("$.payload[3].countryName").value("ANGUILLA"))
					
				.andExpect(jsonPath("$.payload[4].countryCode").value("ALA"))
				.andExpect(jsonPath("$.payload[4].countryName").value("ALAND ISLANDS"))
					
				
				.andExpect(jsonPath("$.payload[5].countryCode").value("ALB"))
				.andExpect(jsonPath("$.payload[5].countryName").value("ALBANIA"))
					
				
				.andExpect(jsonPath("$.payload[6].countryCode").value("AND"))
				.andExpect(jsonPath("$.payload[6].countryName").value("ANDORRA"))
					
				.andExpect(jsonPath("$.payload[7].countryCode").value("ANT"))
				.andExpect(jsonPath("$.payload[7].countryName").value("NETHERLANDS ANTILLES"))
					
				
				.andExpect(jsonPath("$.payload[8].countryCode").value("ARE"))
				.andExpect(jsonPath("$.payload[8].countryName").value("UNITED ARAB EMIRATES"))
					

				.andExpect(jsonPath("$.payload[9].countryCode").value("ARG"))
				.andExpect(jsonPath("$.payload[9].countryName").value("ARGENTINA"));
					
	}
	
	@Test
	public void getStates() throws Exception {
		mockMvc.perform(
				get("/asdata/states/1234/").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].stateCode").value("BAL"))
				.andExpect(jsonPath("$.payload[0].stateName").value("Balkh"))
				
				.andExpect(jsonPath("$.payload[1].stateCode").value("BAM"))
				.andExpect(jsonPath("$.payload[1].stateName").value("BÄÅmyÄÅn"))
				
				.andExpect(jsonPath("$.payload[2].stateCode").value("BDG"))
				.andExpect(jsonPath("$.payload[2].stateName").value("BÄÅdghÄ«s"))
				
				.andExpect(jsonPath("$.payload[3].stateCode").value("BDS"))
				.andExpect(jsonPath("$.payload[3].stateName").value("BadakhshÄÅn"))
				
				.andExpect(jsonPath("$.payload[4].stateCode").value("BGL"))
				.andExpect(jsonPath("$.payload[4].stateName").value("BaghlÄÅn"))
				
				.andExpect(jsonPath("$.payload[5].stateCode").value("DAY"))
				.andExpect(jsonPath("$.payload[5].stateName").value("DÄÅykundÄ«"))
				
				.andExpect(jsonPath("$.payload[6].stateCode").value("FRA"))
				.andExpect(jsonPath("$.payload[6].stateName").value("FarÄÅh"))
		
				
				.andExpect(jsonPath("$.payload[7].stateCode").value("FYB"))
				.andExpect(jsonPath("$.payload[7].stateName").value("FÄÅryÄÅb"))
				
				.andExpect(jsonPath("$.payload[8].stateCode").value("GHA"))
				.andExpect(jsonPath("$.payload[8].stateName").value("GhaznÄ«"))
				
				.andExpect(jsonPath("$.payload[9].stateCode").value("GHO"))
				.andExpect(jsonPath("$.payload[9].stateName").value("GhÅçr"));
				
					
	}

	@Test
	public void getInstitutions() throws Exception {
		mockMvc.perform(
				get("/asdata/institutions/").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].institutionId").value("1"))
				.andExpect(jsonPath("$.payload[0].institutionName").value("Institution1"))
				
				.andExpect(jsonPath("$.payload[1].institutionId").value("2"))
				.andExpect(jsonPath("$.payload[1].institutionName").value("Institution2"))
								
				.andExpect(jsonPath("$.payload[2].institutionId").value("3"))
				.andExpect(jsonPath("$.payload[2].institutionName").value("Institution3"))

				.andExpect(jsonPath("$.payload[3].institutionId").value("4"))
				.andExpect(jsonPath("$.payload[3].institutionName").value("Institution4"))

				.andExpect(jsonPath("$.payload[4].institutionId").value("5"))
				.andExpect(jsonPath("$.payload[4].institutionName").value("Institution5"));
								
	}
	
	
	@Test
	public void getDepartments() throws Exception {
		mockMvc.perform(
				get("/asdata/departments/").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].departmentId").value("1"))
				.andExpect(jsonPath("$.payload[0].departmentName").value("Department1"))
				
				.andExpect(jsonPath("$.payload[1].departmentId").value("2"))
				.andExpect(jsonPath("$.payload[1].departmentName").value("Department2"))
				
				.andExpect(jsonPath("$.payload[2].departmentId").value("3"))
				.andExpect(jsonPath("$.payload[2].departmentName").value("Department3"))

				.andExpect(jsonPath("$.payload[3].departmentId").value("4"))
				.andExpect(jsonPath("$.payload[3].departmentName").value("Department4"))
				
				.andExpect(jsonPath("$.payload[4].departmentId").value("5"))
				.andExpect(jsonPath("$.payload[4].departmentName").value("Department5"));				
								
	}
	
	@Test
	public void getResearchFunders() throws Exception {
		mockMvc.perform(
				get("/userprofile/researchFunders/{userId}").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].researchFunderId").value("1234"))
				.andExpect(jsonPath("$.payload[0].researchFunderName").value("Funder1"))
				.andExpect(jsonPath("$.payload[0].researchFunderName.grantNumber[0]").value("12"))
				.andExpect(jsonPath("$.payload[0].researchFunderName.grantNumber[1]").value("13"))
				.andExpect(jsonPath("$.payload[0].researchFunderName.grantNumber[2]").value("14"))
				
				.andExpect(jsonPath("$.payload[0].researchFunderId").value("1235"))
				.andExpect(jsonPath("$.payload[1].researchFunderName").value("Funder2"))
				.andExpect(jsonPath("$.payload[2].researchFunderName.grantNumber[0]").value("15"))
				.andExpect(jsonPath("$.payload[3].researchFunderName.grantNumber[1]").value("16"));

								
	}
	
	
	@Test
	public void getArticles() throws Exception {
		mockMvc.perform(
				get("/asdata/articles/").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].articleId").value("1"))
				.andExpect(jsonPath("$.payload[0].articleName").value("Article1"))

				.andExpect(jsonPath("$.payload[1].articleId").value("2"))
				.andExpect(jsonPath("$.payload[1].articleName").value("Article2"))
				
				.andExpect(jsonPath("$.payload[2].articleId").value("3"))
				.andExpect(jsonPath("$.payload[2].articleName").value("Article3"))
				
				.andExpect(jsonPath("$.payload[3].articleId").value("4"))
				.andExpect(jsonPath("$.payload[3].articleName").value("Article4"))
				
				.andExpect(jsonPath("$.payload[4].articleId").value("5"))
				.andExpect(jsonPath("$.payload[4].articleName").value("Article5"));
								
	}
	
	
	@Test
	public void getAdminRoles() throws Exception {
		mockMvc.perform(
				get("/asdata/getRoles/").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].roleId").value("5"))
				.andExpect(jsonPath("$.payload[0].roleName").value("Super Admins"))
				
				.andExpect(jsonPath("$.payload[0].roleId").value("6"))
				.andExpect(jsonPath("$.payload[0].roleName").value("AOS Admin"));
										
	}
	
	@Test
	public void getAdminAccessReasons() throws Exception {
		mockMvc.perform(
				get("/asdata/getAccessReasons/").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload[0].accessId").value("ACC1"))
				.andExpect(jsonPath("$.payload[0].accessReason").value("Provide User Support"))
				
				.andExpect(jsonPath("$.payload[1].accessId").value("ACC2"))
				.andExpect(jsonPath("$.payload[1].accessReason").value("Provide Product Support"))
				
				.andExpect(jsonPath("$.payload[2].accessId").value("ACC3"))
				.andExpect(jsonPath("$.payload[2].accessReason").value("Provide OnlineOpen Support"))
				
				.andExpect(jsonPath("$.payload[3].accessId").value("ACC4"))
				.andExpect(jsonPath("$.payload[3].accessReason").value("Provide Open Access Support"))
				
				.andExpect(jsonPath("$.payload[4].accessId").value("ACC5"))
				.andExpect(jsonPath("$.payload[4].accessReason").value("Provide License Support"));						
										
	}
	
	
}
