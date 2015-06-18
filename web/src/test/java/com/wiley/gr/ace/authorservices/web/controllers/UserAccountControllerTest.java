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
public class UserAccountControllerTest {
	
	@Autowired
	private UserAccountControllerTest userAccountControllerTest;
	
	//UserAccountControllerTest userAccountControllerTest = new UserAccountControllerTest();
		
	@Autowired
	private MockMvc mockMvc;
	
	@Before  
	public void init() {  
		this.mockMvc = MockMvcBuilders.standaloneSetup(userAccountControllerTest).build();
		}  
	
	@Test
	public void getProfileInformation() throws Exception {
		mockMvc.perform(
				get("/userAccount/profileInfo/2000/").contentType(MediaType.APPLICATION_JSON))
						
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload.title").value("Mr"))
				.andExpect(jsonPath("$.payload.firstName").value("John"))
				.andExpect(jsonPath("$.payload.middleName").value("Wiley"))
				.andExpect(jsonPath("$.payload.lastName").value("AuthorServices"))
				.andExpect(jsonPath("$.payload.suffix").value("Jr"))
				.andExpect(jsonPath("$.payload.alternateName").value("AS2.0"))
				.andExpect(jsonPath("$.payload.primaryEmailAddr").value("john@gmail.com"))
				.andExpect(jsonPath("$.payload.recoveryEmailAddress").value("wiley@gmail.com"))
				.andExpect(jsonPath("$.payload.industry").value("Wiley"))
				.andExpect(jsonPath("$.payload.jobCategory").value("Publication"))
				.andExpect(jsonPath("$.payload.orcidID").value("12345"))
				.andExpect(jsonPath("$.payload.visibleAttributes[0]").value("FirstName"))
				.andExpect(jsonPath("$.payload.visibleAttributes[1]").value("LastName"))
				.andExpect(jsonPath("$.payload.visibleAttributes[2]").value("primaryEmailAddress"))
				.andExpect(jsonPath("$.payload.searchFullName").value("false"))
				.andExpect(jsonPath("$.payload.termsOfUseFlg").value("Y"))
				.andExpect(jsonPath("$.payload.firstName").value("John"))
				.andExpect(jsonPath("$.payload.firstName").value("John"));
		
		
	}
	
	@Test
	public void updateProfileInformation() throws Exception {
		mockMvc.perform(
				post("/userAccount/profileInfo/2000/").contentType(MediaType.APPLICATION_JSON)
					.content("{\"profileInformation"
							+ "{\"title\":\"Mr\", \"firstName\":\"John\", \"middleName\":\"Wiley\", \"lastName\":\"AuthorServices\", \"suffix\":\"Jr\",   \"alternateName\":\"AS2.0\", \"industry\":\"Wiley\", \"jobCategory\":\"Publication\", \"orcidID\":\"12345\", \"termsOfUseFlg\":\"Y\",\"primaryEmailAddr\":\"john@gmail.com\",\"recoveryEmailAddress\":\"wiley@gmail.com\", "
							+ "[\"FirstName\", \"LastName\", \"primaryEmailAddress\" ]}  }"
							.getBytes()))
				
				
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload").value("true"));
				
		
	}
	
	@Test
	public void updateEmail() throws Exception {
		mockMvc.perform(
				post("/userAccount/emailDetails/2000/").contentType(MediaType.APPLICATION_JSON)
					.content("{\"profileInformation"
							+ "{\"primaryEmailAddr\":\"john@gmail.com\", \"recoveryEmailAddress\":\"wiley@gmail.com\"}  }"
							.getBytes()))
				
				
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload").value("true"));
				
		
	}
	
	
	@Test
	public void getEmailDetails() throws Exception {
		mockMvc.perform(
				get("/userAccount/emailDetails/2000/").contentType(MediaType.APPLICATION_JSON))
									
				
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload.primaryEmailAddr").value("john@gmail.com"))
				.andExpect(jsonPath("$.payload.recoveryEmailAddress").value("wiley@gmail.com"))
				.andExpect(jsonPath("$.payload.searchFullName").value("false"));
				
	}
	
	
	@Test
	public void getUserAddresses() throws Exception {
		mockMvc.perform(
				get("/userAccount/userAddresses/2000").contentType(MediaType.APPLICATION_JSON))
									
				
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].title").value("Mr"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].firstName").value("John"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].lastName").value("AuthorServices"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].suffix").value("Jr"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].department").value("AS2.0"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].addressLine1").value("Virtusa"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].addressLine2").value("consulting Pvt Ltd"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].city").value("Hyderabad"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].state").value("Telangana"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].postCode").value("500032"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].country[0].countryCode").value("country1"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].country[0].countryName").value("India"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].phoneNumber").value("1234567890"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].faxNumber").value("123789456"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[0].addressFag").value("Y"))
		
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].title").value("Mr"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].firstName").value("John"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].lastName").value("AuthorServices"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].suffix").value("Jr"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].department").value("AS2.0"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].addressLine1").value("Virtusa"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].addressLine2").value("consulting Pvt Ltd"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].city").value("Hyderabad"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].state").value("Telangana"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].postCode").value("500032"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].country[0].countryCode").value("country1"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].country[0].countryName").value("India"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].phoneNumber").value("1234567890"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].faxNumber").value("123789456"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[1].addressFag").value("Y"))
		
		
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].title").value("Mr"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].firstName").value("John"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].lastName").value("AuthorServices"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].suffix").value("Jr"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].department").value("AS2.0"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].addressLine1").value("Virtusa"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].addressLine2").value("consulting Pvt Ltd"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].city").value("Hyderabad"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].state").value("Telangana"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].postCode").value("500032"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].country[0].countryCode").value("country1"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].country[0].countryName").value("India"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].phoneNumber").value("1234567890"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].faxNumber").value("123789456"))
				.andExpect(jsonPath("$.payload.correspondenceAddress[2].addressFag").value("Y"));
	}
	
	@Test
	public void updateUserAddresses() throws Exception {
		mockMvc.perform(
				post("/userAccount/userAddresses/2000/").contentType(MediaType.APPLICATION_JSON)
					.content("{\"addressDetails\"["
							+ "{\"correspondenceAddress\" {"
							+ "\"title\" : \" Mr\", \"firstName\" : \" John\", \"lastName\" : \" AuthorServices\",\"suffix\" : \" Jr\", \"Institution\" : \" Wiley\", \"department\" : \" AS2.0\", \"addressLine1\" : \" Virtusa\",\"addressLine2\" : \" consulting Pvt Ltd\",\"city\" : \" Hyderabad\",\"state\" : \" Telangana\",\"postCode\" : \" 500032\","
							+ " country { \"countryCode\" : \" country1\", \"countryName\" : \" India\"}"
							+ " \"phoneNumber\" : \" 1234567890\", \"faxNumber\" : \" 123789456\", \"addressFag\" : \" Y\"} },"
							+ "{\"billingAddress\" {"
							+ "\"title\" : \" Mr\", \"firstName\" : \" John\", \"lastName\" : \" AuthorServices\",\"suffix\" : \" Jr\", \"Institution\" : \" Wiley\", \"department\" : \" AS2.0\", \"addressLine1\" : \" Virtusa\",\"addressLine2\" : \" consulting Pvt Ltd\",\"city\" : \" Hyderabad\",\"state\" : \" Telangana\",\"postCode\" : \" 500032\","
							+ " country { \"countryCode\" : \" country1\", \"countryName\" : \" India\"}"
							+ "\"phoneNumber\" : \" 1234567890\", \"faxNumber\" : \" 123789456\", \"addressFag\" : \" Y\"} },"
							+ "{\"shippingAddress\" {"
							+ "\"title\" : \" Mr\", \"firstName\" : \" John\", \"lastName\" : \" AuthorServices\",\"suffix\" : \" Jr\", \"Institution\" : \" Wiley\", \"department\" : \" AS2.0\", \"addressLine1\" : \" Virtusa\",\"addressLine2\" : \" consulting Pvt Ltd\",\"city\" : \" Hyderabad\",\"state\" : \" Telangana\",\"postCode\" : \" 500032\","
							+ " country { \"countryCode\" : \" country1\", \"countryName\" : \" India\"}"
							+ "\"phoneNumber\" : \" 1234567890\", \"faxNumber\" : \" 123789456\", \"addressFag\" : \" Y\"}] }"
							.getBytes()))
				
				
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload").value("true"));
				
		
	}
	
	
	@Test
	public void updateSecurityDetails() throws Exception {
		mockMvc.perform(
				post("/userAccount/secutiryDetails/update").contentType(MediaType.APPLICATION_JSON)
					.content("{\"emailId\" : \"shiva@gmail.com\" \"securityDetails\":[{ \"securityQuestionId\": \"SEQ1\", \"securityQuestion\": \"What is name of your elementary/primary school?\",\"securityAnswer\": \"Vivekananda vidhya nikethan\" }"
							+ "{ \"securityQuestionId\": \"SEQ2\",\"securityQuestion\": \"What is the country of your ultimate dream vacation?\", \"securityAnswer\": \"U.S\"} ],"
							+"  \"password\": \"Password\" }"
							.getBytes()))
				
				
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload").value("true"));
				
		
	}
	
	
	@Test
	public void updateUserId() throws Exception {
		mockMvc.perform(
				post("/userAccount/updateUserId").contentType(MediaType.APPLICATION_JSON)
					.content("{\"oldEmailId\" : \"shiva@gmail.com\" \"newEmailId\": \"nani@gmail.com\" }"
							.getBytes()))
				
				
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.status").value("SUCCESS"))
				.andExpect(jsonPath("$.payload").value("true"));
				
		
	}
	
}	