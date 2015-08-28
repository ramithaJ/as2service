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

import com.wiley.gr.ace.authorservices.web.controllers.OpenAccessController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:testmvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class OpenAccessControllerTest {
	
	@Autowired
    private OpenAccessController openAccessController;
	
	@Autowired
	 private MockMvc mockMvc;
	 
	 @Before  
	 public void init() {
			this.mockMvc = MockMvcBuilders.standaloneSetup(openAccessController).build();
		}  

	 @Test
	 public void viewOpenAccess() throws Exception
	 {
	mockMvc.perform(get("/openaccess/view/{userId}/{orderId}")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
			  
			  .andExpect(jsonPath("$.status").value("SUCCESS"))
			  .andExpect(jsonPath("$.payload.finalAmount.amount").value(""))
			  .andExpect(jsonPath("$.payload.finalAmount.currency").value(""))
			  .andExpect(jsonPath("$.payload.amountPayable.amount").value("11.01"))
			  .andExpect(jsonPath("$.payload.amountPayable.currency").value("USD"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.firstName").value("John Wiley"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.lastName").value("John Wiley"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.department").value("IT"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.addressLine1").value("hoboken"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.addressLine2").value("hoboken"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.city").value("jersey"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.state").value("New Jersey"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.postCode").value("07500"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.country.countryCode").value(""))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.country.countryName").value("USA"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.phoneNumber").value("999-999-9909"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.emailId").value("wiley@wiley.com"))
			  
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.firstName").value("John Wiley"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.lastName").value("John Wiley"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.department").value("IT"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.addressLine1").value("hoboken"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.addressLine2").value("hoboken"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.city").value("jersey"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.state").value("New Jersey"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.postCode").value("07500"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.country.countryCode").value(""))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.country.countryName").value("USA"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.phoneNumber").value("999-999-9909"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.emailId").value("wiley@wiley.com"))
			  
			  .andExpect(jsonPath("$.payload.journalDetails.journalId").value("Journal1234"))
			  .andExpect(jsonPath("$.payload.journalDetails.journalTitle").value("ABC"))
			  .andExpect(jsonPath("$.payload.discountDetails.institutionId").value(""))
			  .andExpect(jsonPath("$.payload.discountDetails.societyId").value("code"))
			  .andExpect(jsonPath("$.payload.discountDetails.otherDiscounts").value(""))
			  .andExpect(jsonPath("$.payload.discountDetails.promoCode").value("PROMOCODE9999"))
			  .andExpect(jsonPath("$.payload.discountDetails.originalFunder").value(""))
			  .andExpect(jsonPath("$.payload.discountDetails.institutionName").value(""))
			  .andExpect(jsonPath("$.payload.discountDetails.societyName").value(""))
			  .andExpect(jsonPath("$.payload.taxPercentage").value("0.00"))			  
			  
			  .andExpect(jsonPath("$.payload.taxDetails.taxExemptionNumber").value("000111"))		
			  .andExpect(jsonPath("$.payload.taxDetails.taxCodeExpiryDate").value("2015-06-11T01:43:26.195+08:30"))		
			  .andExpect(jsonPath("$.payload.taxDetails.vatIdNumber").value("887228"))		
			  .andExpect(jsonPath("$.payload.taxDetails.vatExemptionNumber").value("000111"))		
			  .andExpect(jsonPath("$.payload.taxDetails.taxCountryCode").value("001"))		
			  
			  .andExpect(jsonPath("$.payload.paymentMethod").value("CREDIT_CARD"))		
			  .andExpect(jsonPath("$.payload.articleDetails.articleTitle").value("ArticleTitle"))		
			  .andExpect(jsonPath("$.payload.articleDetails.articleAID").value("ABC"))		
			  .andExpect(jsonPath("$.payload.authorName").value("name"))	
			  .andExpect(jsonPath("$.payload.quoteDetail.prices.price").value("10.02"))	
			  .andExpect(jsonPath("$.payload.quoteDetail.prices.currency").value("USD"))	
			  .andExpect(jsonPath("$.payload.billingSameAsCorrespondenceAddress").value("false"))	
			  .andExpect(jsonPath("$.payload.taxAmount.amount").value(""))	
			  .andExpect(jsonPath("$.payload.taxAmount.currency").value(""))	
			  
			  .andExpect(jsonPath("$.payload.orderEditable").value("true"))	
			  .andExpect(jsonPath("$.payload.invoiceAvailable").value("false"))	
			  
			  .andExpect(jsonPath("$.payload.discountDetail.discountType").value("special"))	
			  .andExpect(jsonPath("$.payload.discountDetail.discountPercent").value("20"))	
			  .andExpect(jsonPath("$.payload.discountDetail.discountAmount").value("12.33"))	
			  
			  .andExpect(jsonPath("$.payload.licenseSignedStatus").value("false"))	
			  .andExpect(jsonPath("$.payload.licenceSigned").value("false"));
			 		
	 }
	 
	 @Test
	 public void validateAddress() throws Exception
	 {
	mockMvc.perform(post("/openaccess/validate/address")
			  .contentType(MediaType.APPLICATION_JSON)
			  .content("{ \"addressDetails\": [ { \"correspondenceAddress\": { \"title\": \"Mr\", \"firstName\": \"John\", \"lastName\": \"AuthorServices\", \"suffix\": \"Jr\", \"department\": \"AS2.0\", \"addressLine1\": \"Virtusa\", \"addressLine2\": \"consulting Pvt Ltd\", \"city\": \"Hyderabad\", \"state\": \"Telangana\", \"postCode\": \"500032\", \"country\": { \"countryCode\": \"country1\", \"countryName\": \"India\" }, \"phoneNumber\": \"1234567890\", \"faxNumber\": \"123789456\", \"addressFag\": \"Y\" } }, { \"billingAddress\": { \"title\": \"Mr\", \"firstName\": \"John\", \"lastName\": \"AuthorServices\", \"suffix\": \"Jr\", \"department\": \"AS2.0\", \"addressLine1\": \"Virtusa\", \"addressLine2\": \"consulting Pvt Ltd\", \"city\": \"Hyderabad\", \"state\": \"Telangana\", \"postCode\": \"500032\", \"country\": { \"countryCode\": \"country1\", \"countryName\": \"India\" }, \"phoneNumber\": \"1234567890\", \"faxNumber\": \"123789456\", \"addressFag\": \"Y\" } } ] }".getBytes()))
			  .andExpect(status().isOk())
	
	.andExpect(jsonPath("$.status").value("success"));
			  
	 }
	 
	 @Test
	 public void validateVatTaxDetails() throws Exception
	 {
	mockMvc.perform(post("/openaccess/validate/taxDetails")
			  .contentType(MediaType.APPLICATION_JSON)
			  .content("{ \"taxDetails\": { \"taxCountryCode\": \"USA\", \"taxExemptionNumber\": \"2345432\", \"taxCodeExpiryDate\": \"05-23-2017\" } }".getBytes()))
			  .andExpect(status().isOk())
	
	.andExpect(jsonPath("$.status").value("success"));
			  
	 }
}
