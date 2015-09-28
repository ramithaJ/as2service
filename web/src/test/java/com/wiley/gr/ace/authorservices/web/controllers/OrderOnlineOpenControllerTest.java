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

import com.wiley.gr.ace.authorservices.web.controllers.OrderOnlineOpenController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:testmvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class OrderOnlineOpenControllerTest {
	
	@Autowired
    private OrderOnlineOpenController orderOnlineOpenController;
	
	
	@Autowired
	 private MockMvc mockMvc;
	 
	 @Before  
	 public void init() {
			this.mockMvc = MockMvcBuilders.standaloneSetup(orderOnlineOpenController).build();
		}  
	
	 @Test
	 public void initiateOnline() throws Exception
	 {
	mockMvc.perform(get("/onlineopen/initiateOnline/8011047/1")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("SUCCESS"))
			  .andExpect(jsonPath("$.payload.articleDetails.articleTitle").value("Experiment on genetical diseases"))
			  .andExpect(jsonPath("$.payload.articleDetails.articleAID").value("1"))
			  .andExpect(jsonPath("$.payload.quoteDetail.prices[0].price").value("3000.00"))
			  .andExpect(jsonPath("$.payload.quoteDetail.prices[0].currency").value("USD"))
			  .andExpect(jsonPath("$.payload.quoteDetail.prices[1].price").value("2772.00"))
			  .andExpect(jsonPath("$.payload.quoteDetail.prices[1].currency").value("EUR"))
			  .andExpect(jsonPath("$.payload.quoteDetail.prices[2].price").value("2011.00"))
			  .andExpect(jsonPath("$.payload.quoteDetail.prices[2].currency").value("GBP"))
			  
			  .andExpect(jsonPath("$.payload.journalDetails.journalId").value("4"))
			  .andExpect(jsonPath("$.payload.journalDetails.journalTitle").value("British Journal of Dermatology"))
			  
			  .andExpect(jsonPath("$.payload.authorName").value("John AuthorServices"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.title").value("Mr"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.firstName").value("John"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.lastName").value("AuthorServices"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.department").value("AS2.0"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.addressLine1").value("Virtusa"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.addressLine2").value("consulting Pvt Ltd"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.city").value("Hyderabad"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.state").value("Telangana"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.postCode").value("500032"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.country.countryCode").value("country1"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.country.countryName").value("country1"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.phoneNumber").value("1234567890"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.faxNumber").value("123789456"))
			  .andExpect(jsonPath("$.payload.addressDetails.billingAddress.addressFag").value("Y"))
			  
			  
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.title").value("Mr"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.firstName").value("John"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.lastName").value("AuthorServices"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.department").value("AS2.0"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.addressLine1").value("Virtusa"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.addressLine2").value("consulting Pvt Ltd"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.city").value("Hyderabad"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.state").value("Telangana"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.postCode").value("500032"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.country.countryCode").value("country1"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.country.countryName").value("country1"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.phoneNumber").value("1234567890"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.faxNumber").value("123789456"))
			  .andExpect(jsonPath("$.payload.addressDetails.contactAddress.addressFag").value("Y"))
			  
			  .andExpect(jsonPath("$.payload.discountsAllowed").value("true"))
			  .andExpect(jsonPath("$.payload.additionalDiscountAllowed").value("true"));		
	 }
	 
	 @Test
	 public void saveOnlineOpenOrder() throws Exception
	 {
	mockMvc.perform(post("/onlineopen/saveLater/{userId}").contentType(MediaType.APPLICATION_JSON)
			.content("{ \"articleDetails\": { \"articleId\": \"1\", \"articleTitle\": \"RegionalvariationsofbasalcellcarcinomaincidenceintheU.K.usingTheHealthImprovementNetworkdatabase\" }, \"journalDetails\": { \"journalId\": \"JU5XB\", \"journalTitle\": \"BritishJournalofDermatology\" }, \"authorName\": \"A.Musah\", \"quoteDetail\": { \"prices\": [ { \"price\": \"3000.00\", \"currency\": \"USD\" }, { \"price\": \"2772.00\", \"currency\": \"EUR\" }, { \"price\": \"2011.00\", \"currency\": \"GBP\" "

+ "} ] }, \"funderDetails\": [ { \"researchFunderId\": \"F0123\", \"woaAccountId\": \"WOA001\", \"funderId\": \"RF001\", \"grants\": [ { \"grantNumber\": \"456\", \"recipients\": [ { \"recipeintId\": \"AA001\", \"recipientId\": \"AA002\" } ] }, { \"grantNumber\": \"232\", \"recipients\": [ { \"recipeintId\": \"AA003\", \"recipientId\": \"AA042\" } ] } ] } ], \"discountDetails\": [ { \"societyId\": \"SOC001\", \"promoCode\": \"XCVBNM\", \"institutionId\": \"INST001\", \"otherDiscounts\": \"\" }, { \"societyId\": \"SOC001\", \"promoCode\": \"XCVBNM\", \"institutionId\": \"INST001\", \"otherDiscounts\": \"\" } ], \"paymentMethod\": \"Invoice\", \"discountsApplicable\": \"true\", \"billingSameAsCorrespondenceAddress\": \"false\", \"addressDetails\": { "

+ "\"contactAddress\": { \"title\": \"Mr\", \"firstName\": \"John\", \"lastName\": \"AuthorServices\", \"suffix\": \"Jr\", \"department\": \"AS2.0\", \"addressLine1\": \"Virtusa\", \"addressLine2\": \"consulting Pvt Ltd\", \"city\": \"Hyderabad\", \"state\": \"Telangana\", \"postCode\": \"500032\", \"country\": { \"countryCode\": \"country1\", \"countryName\": \"India\" }, \"phoneNumber\": \"1234567890\", \"faxNumber\": \"123789456\", \"addressFag\": \"Y\" } }, \"billingAddress\": { \"title\": \"Mr\", \"firstName\": \"John\", \"lastName\": \"AuthorServices\", \"suffix\": \"Jr\", \"department\": \"AS2.0\", \"addressLine1\": \"Virtusa\", \"addressLine2\": \"consulting Pvt Ltd\", \"city\": \"Hyderabad\", \"state\": \"Telangana\", \"postCode\": \"500032\", \"country\": { \"countryCode\": \"country1\", \"countryName\": \"India\" }, \"phoneNumber\": \"1234567890\", \"faxNumber\": \"123789456\", \"addressFag\": \"Y\" }, \"taxDetails\": { \"taxCountryCode\": \"USA\", \"taxExemptionNumber\": \"2345432\", \"taxCodeExpiryDate\": \"05-23-2017\" }, \"amountPayable\": { \"amount\": \"3000\", \"currency\": \"USD\" },"

+ "\"taxPercentage\": \"10\", \"finalAmount\": { \"amount\": \"3300\", \"currency\": \"USD\" } }".getBytes()))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("success"));
			 		
	 }
	 
	 @Test
	 public void submitOnlineOpenOrder() throws Exception
	 {
	mockMvc.perform(post("/onlineopen/submit").contentType(MediaType.APPLICATION_JSON)
			.content("{ \"articleDetails\": { \"articleId\": \"1\", \"articleTitle\": \"RegionalvariationsofbasalcellcarcinomaincidenceintheU.K.usingTheHealthImprovementNetworkdatabase\" }, \"journalDetails\": { \"journalId\": \"JU5XB\", \"journalTitle\": \"BritishJournalofDermatology\" }, \"authorName\": \"A.Musah\", \"quoteDetail\": { \"prices\": [ { \"price\": \"3000.00\", \"currency\": \"USD\" }, { \"price\": \"2772.00\", \"currency\": \"EUR\" }, { \"price\": \"2011.00\", \"currency\": \"GBP\" "

+ "} ] }, \"funderDetails\": [ { \"researchFunderId\": \"F0123\", \"woaAccountId\": \"WOA001\", \"funderId\": \"RF001\", \"grants\": [ { \"grantNumber\": \"456\", \"recipients\": [ { \"recipeintId\": \"AA001\", \"recipientId\": \"AA002\" } ] }, { \"grantNumber\": \"232\", \"recipients\": [ { \"recipeintId\": \"AA003\", \"recipientId\": \"AA042\" } ] } ] } ], \"discountDetails\": [ { \"societyId\": \"SOC001\", \"promoCode\": \"XCVBNM\", \"institutionId\": \"INST001\", \"otherDiscounts\": \"\" }, { \"societyId\": \"SOC001\", \"promoCode\": \"XCVBNM\", \"institutionId\": \"INST001\", \"otherDiscounts\": \"\" } ], \"paymentMethod\": \"Invoice\", \"discountsApplicable\": \"true\", \"billingSameAsCorrespondenceAddress\": \"false\", \"addressDetails\": { "

+ "\"contactAddress\": { \"title\": \"Mr\", \"firstName\": \"John\", \"lastName\": \"AuthorServices\", \"suffix\": \"Jr\", \"department\": \"AS2.0\", \"addressLine1\": \"Virtusa\", \"addressLine2\": \"consulting Pvt Ltd\", \"city\": \"Hyderabad\", \"state\": \"Telangana\", \"postCode\": \"500032\", \"country\": { \"countryCode\": \"country1\", \"countryName\": \"India\" }, \"phoneNumber\": \"1234567890\", \"faxNumber\": \"123789456\", \"addressFag\": \"Y\" } }, \"billingAddress\": { \"title\": \"Mr\", \"firstName\": \"John\", \"lastName\": \"AuthorServices\", \"suffix\": \"Jr\", \"department\": \"AS2.0\", \"addressLine1\": \"Virtusa\", \"addressLine2\": \"consulting Pvt Ltd\", \"city\": \"Hyderabad\", \"state\": \"Telangana\", \"postCode\": \"500032\", \"country\": { \"countryCode\": \"country1\", \"countryName\": \"India\" }, \"phoneNumber\": \"1234567890\", \"faxNumber\": \"123789456\", \"addressFag\": \"Y\" }, \"taxDetails\": { \"taxCountryCode\": \"USA\", \"taxExemptionNumber\": \"2345432\", \"taxCodeExpiryDate\": \"05-23-2017\" }, \"amountPayable\": { \"amount\": \"3000\", \"currency\": \"USD\" },"

+ "\"taxPercentage\": \"10\", \"finalAmount\": { \"amount\": \"3300\", \"currency\": \"USD\" } }".getBytes()))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("success"));
			 		
	 }
	 
	 
	 @Test
	 public void getOnlineOpenOrderDetails() throws Exception
	 {
	mockMvc.perform(get("/onlineopen/view/123/111")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
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
			  .andExpect(jsonPath("$.payload.funderDetails.woaAccountId").value("code"))
			  .andExpect(jsonPath("$.payload.funderDetails.funderId").value(""))
			  .andExpect(jsonPath("$.payload.funderDetails.researchFunderId").value(""))
			  .andExpect(jsonPath("$.payload.funderDetails.researchFunderName").value(""))
			  .andExpect(jsonPath("$.payload.funderDetails.grants.grantNumber").value(""))
			  .andExpect(jsonPath("$.payload.funderDetails.grants.recipientsList.recipientId").value(""))
			 
			  .andExpect(jsonPath("$.payload.taxDetails.taxExemptionNumber").value("000111"))
			  .andExpect(jsonPath("$.payload.taxDetails.taxCodeExpiryDate").value("2015-06-11T01:43:26.195+08:30"))
			  .andExpect(jsonPath("$.payload.taxDetails.vatIdNumber").value("887228"))
			  .andExpect(jsonPath("$.payload.taxDetails.vatExemptionNumber").value("000111"))
			  .andExpect(jsonPath("$.payload.taxDetails.taxCountryCode").value("001"))
			  
			  .andExpect(jsonPath("$.payload.paymentMethod").value("CREDIT_CARD"))
			  .andExpect(jsonPath("$.payload.articleDetails.articleTitle").value("ArticleTitle"))
			  .andExpect(jsonPath("$.payload.articleDetails.articleAID").value("ABC"))
			  .andExpect(jsonPath("$.payload.authorName").value("name"))
			  .andExpect(jsonPath("$.payload.paymentMethod").value("CREDIT_CARD"))
			  .andExpect(jsonPath("$.payload.quoteDetail.prices.price").value("10.02"))
			  .andExpect(jsonPath("$.payload.quoteDetail.prices.currency").value("USD"))
			  .andExpect(jsonPath("$.payload.billingSameAsCorrespondenceAddress").value("false"))
			  
			  .andExpect(jsonPath("$.payload.taxAmount.amount").value(""))
			  .andExpect(jsonPath("$.payload.taxAmount.currency").value(""))
			  
			  .andExpect(jsonPath("$.payload.orderEditable").value("true"))
			  .andExpect(jsonPath("$.payload.invoiceAvailable").value("false"))
			  .andExpect(jsonPath("$.payload.licenseSignedStatus").value("false"))
			  .andExpect(jsonPath("$.payload.licenceSigned").value("false"))
			  ;  
			  
			 		
	 }
	 
	 @Test
	 public void cancelOnlineOpenOrder() throws Exception
	 {
	mockMvc.perform(post("/onlineopen/cancel/{userId}/{orderId}")
			  .contentType(MediaType.APPLICATION_JSON)
			  .content("{ \"orderId\":\"OO123\" }".getBytes()))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("success"));
			 		
	 } 
	 
	 @Test
	 public void getFundersList() throws Exception
	 {
	mockMvc.perform(get("/onlineopen/fundersList")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
	          .andExpect(jsonPath("$.status").value("success"))
	          .andExpect(jsonPath("$.payload.funderDetails.funderId").value("RF001"))
	          .andExpect(jsonPath("$.payload.funderDetails.funderName").value("University of Derks"));	 	
			  
	 }		  
	 
	 @Test
	 public void getWOAFunders() throws Exception
	 {
	mockMvc.perform(get("/onlineopen/woaFunders")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
	          .andExpect(jsonPath("$.status").value("success"))
	          .andExpect(jsonPath("$.payload.woaFunders[0].woaFunderId").value("1234"))
	          .andExpect(jsonPath("$.payload.woaFunders[0].woaFunderName").value("Wiley"))
	          .andExpect(jsonPath("$.payload.woaFunders[0].allRestricted").value("true"));
	          
	 }	
	 
	 @Test
	 public void getGrantRecipients() throws Exception
	 {
	mockMvc.perform(get("/onlineopen/grantRecipients/{articleId}")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
	          .andExpect(jsonPath("$.status").value("success"))
	          .andExpect(jsonPath("$.payload.coAuthors.coAuthorId").value("woa001"))
	          .andExpect(jsonPath("$.payload.coAuthors.coAuthorName").value("University of Derks"));
	          
	 }	
	 
	 @Test
	 public void getDiscountedSocieties() throws Exception
	 {
	mockMvc.perform(get("/onlineopen/discountedSocieties/{dhId}")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
	          .andExpect(jsonPath("$.status").value("success"))
	          .andExpect(jsonPath("$.payload.societies.societyId").value("soc001"))
	          .andExpect(jsonPath("$.payload.societies.societyName").value("Society1"));
	          
	 }
	 
	 @Test
	 public void getSocieties() throws Exception
	 {
	mockMvc.perform(get("/onlineopen/societies")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
	          .andExpect(jsonPath("$.status").value("success"))
	          .andExpect(jsonPath("$.payload.discountDetails.societyId").value("soc001"))
	          .andExpect(jsonPath("$.payload.discountDetails.promoCode").value("XCVBNM"))
			  .andExpect(jsonPath("$.payload.discountDetails.institutionId").value("INST001"))
			  .andExpect(jsonPath("$.payload.discountDetails.otherDiscounts").value(""))
			  .andExpect(jsonPath("$.payload.discountDetails.societyId").value("soc001"))
    		  .andExpect(jsonPath("$.payload.discountDetails.promoCode").value("XCVBNM"))
    		  .andExpect(jsonPath("$.payload.discountDetails.institutionId").value("INST001"))
    		  .andExpect(jsonPath("$.payload.discountDetails.otherDiscounts").value(""));

	 }
	 
	 
	 
	 @Test
	 public void getAllOrders() throws Exception
	 {
	mockMvc.perform(get("/onlineopen/allOrders/{orderId}")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
	          .andExpect(jsonPath("$.status").value("success"))
	          .andExpect(jsonPath("$.payload.OrdersList.status").value("Cancelled"))
	          .andExpect(jsonPath("$.payload.OrdersList.orderId").value("3345"))
	          .andExpect(jsonPath("$.payload.OrdersList.articleId").value("AA001100"))
	          .andExpect(jsonPath("$.payload.OrdersList.dateSubmitted").value("03-12-2011"))
	          .andExpect(jsonPath("$.payload.OrdersList.articleTitle").value("Impact of Genetical Changes"))
	          .andExpect(jsonPath("$.payload.OrdersList.amountCharged.amount").value("233.23"))
	          .andExpect(jsonPath("$.payload.OrdersList.amountCharged.currency").value("USD"))
	          .andExpect(jsonPath("$.payload.OrdersList.status").value("Cancelled"))
	          .andExpect(jsonPath("$.payload.OrdersList.orderId").value("4555"))
	          .andExpect(jsonPath("$.payload.OrdersList.articleId").value("AA001100"))
	          .andExpect(jsonPath("$.payload.OrdersList.dateSubmitted").value("03-12-2011"))
	          .andExpect(jsonPath("$.payload.OrdersList.articleTitle").value("Impact of Chromosomal Changes"))
	          .andExpect(jsonPath("$.payload.OrdersList.amountCharged.amount").value("33.23"))
	          .andExpect(jsonPath("$.payload.OrdersList.amountCharged.currency").value("GBP"));
    
	 }
	 
	 @Test
	 public void getInstitutionDiscounts() throws Exception
	 {
	mockMvc.perform(get("/onlineopen/institutionDiscounts/{dhId}")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
	          .andExpect(jsonPath("$.status").value("success"))
	          .andExpect(jsonPath("$.payload.institutionDiscounts[0].institutionId").value("INST001"))
	          .andExpect(jsonPath("$.payload.institutionDiscounts[0].institutionName").value("Department of Numerology"))
	          .andExpect(jsonPath("$.payload.institutionDiscounts[1].institutionId").value("INST002"))
	          .andExpect(jsonPath("$.payload.institutionDiscounts[1].institutionName").value("Department of ThermoPhysics"));
	        
	 }
	 
	 @Test
	 public void validateFunderDetails() throws Exception
	 {
	mockMvc.perform(post("/onlineopen/validate/funderDetails")
			  .contentType(MediaType.APPLICATION_JSON)
			  .content("{ \"funderDetails\": [ { \"researchFunderId\": \"F0123\", \"woaAccountId\": \"WOA001\", \"funderId\": \"RF001\", \"grants\": [ { \"grantNumber\": \"456\", \"recipients\": [ { \"recipeintId\": \"AA001\", \"recipientId\": \"AA002\" } ] }, { \"grantNumber\": \"232\", \"recipients\": [ { \"recipeintId\": \"AA003\", \"recipientId\": \"AA042\" } ] } ] } ] }".getBytes()))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("success"));
			 		
	 }
	 
	 @Test
	 public void validateAddressDetails() throws Exception
	 {
	mockMvc.perform(post("/onlineopen/validate/address/{userId}")
			  .contentType(MediaType.APPLICATION_JSON)
			  .content("{ \"addressDetails\": [ { \"correspondenceAddress\": { \"title\": \"Mr\", \"firstName\": \"John\", \"lastName\": \"AuthorServices\", \"suffix\": \"Jr\", \"department\": \"AS2.0\", \"addressLine1\": \"Virtusa\", \"addressLine2\": \"consulting Pvt Ltd\", \"city\": \"Hyderabad\", \"state\": \"Telangana\", \"postCode\": \"500032\", \"country\": { \"countryCode\": \"country1\", \"countryName\": \"India\" }, \"phoneNumber\": \"1234567890\", \"faxNumber\": \"123789456\", \"addressFag\": \"Y\" } }, { \"billingAddress\": { \"title\": \"Mr\", \"firstName\": \"John\", \"lastName\": \"AuthorServices\", \"suffix\": \"Jr\", \"department\": \"AS2.0\", \"addressLine1\": \"Virtusa\", \"addressLine2\": \"consulting Pvt Ltd\", \"city\": \"Hyderabad\", \"state\": \"Telangana\", \"postCode\": \"500032\", \"country\": { \"countryCode\": \"country1\", \"countryName\": \"India\" }, \"phoneNumber\": \"1234567890\", \"faxNumber\": \"123789456\", \"addressFag\": \"Y\" } } ] }".getBytes()))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("success"));
			 		
	 }
	 
	 
	 @Test
	 public void validateTaxDetails() throws Exception
	 {
	mockMvc.perform(post("/onlineopen/validate/taxDetails/{userId}")
			  .contentType(MediaType.APPLICATION_JSON)
			  .content("{ \"taxDetails\": { \"taxCountryCode\": \"USA\", \"taxExemptionNumber\": \"2345432\", \"taxCodeExpiryDate\": \"05-23-2017\" } }".getBytes()))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("success"));
			 		
	 }
	 
	 
	 @Test
	 public void processAllRestrictedFunderWOAAccounts() throws Exception
	 {
	mockMvc.perform(post("/onlineopen/woaFunder/{id}}")
			  .contentType(MediaType.APPLICATION_JSON)
			  .content("{ \"taxDetails\": { \"taxCountryCode\": \"USA\", \"taxExemptionNumber\": \"2345432\", \"taxCodeExpiryDate\": \"05-23-2017\" } }".getBytes()))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("success"));
			 		
	 }
}
