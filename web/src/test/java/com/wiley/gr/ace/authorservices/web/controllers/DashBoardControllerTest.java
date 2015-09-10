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
	
		@Autowired (required = true)
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
					.andExpect(jsonPath("$.payload.dashBoardInfo.dashBoardInfo").value("0"));
					
		}
		
		@Test
		public void getAllAuthorArticles() throws Exception {
			mockMvc.perform(
					get("/dashboard/view/{userId}").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.status").value("SUCCESS"))
					.andExpect(jsonPath("$.payload.articleData.articleUserRole").value("COAUTHOR"))
					.andExpect(jsonPath("$.payload.articleData.articleUserRole.journal.journalTitle").value("AsJournal"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleId").value("2"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleTitle").value("AsArticle"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleDoi").value("5555"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.publicationDate").value("20-JAN-2015"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.acceptanceDate").value("22-JAN-2015"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAcceptedInOO").value("OnlineOpen"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName").value("John"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName.articleCoAuthors[0]").value("Mickey"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName.articleCoAuthors[1]").value("HONUR"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName.articleCoAuthors[2]").value("Javeb"))
					.andExpect(jsonPath("$.payload.articleData.licenseStatus").value("Sign License Agreement"))
					.andExpect(jsonPath("$.payload.articleData.orderPaymentStatus.openAccessStatus").value("Make Open Access"))
					.andExpect(jsonPath("$.payload.articleData.orderPaymentStatus.onlineOpenStatus").value("Make Online Open Order"))
					.andExpect(jsonPath("$.payload.articleData.orderPaymentStatus.availableActions").value("VI, ROO"));
				
		}
		
		@Test
		public void getProductionDetails() throws Exception {
			mockMvc.perform(
					get("/dashboard/production/{userId}").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.status").value("SUCCESS"))
					.andExpect(jsonPath("$.payload.articleData.articleUserRole").value("COAUTHOR"))
					.andExpect(jsonPath("$.payload.articleData.articleUserRole.journal.journalTitle").value("AsJournal"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleId").value("2"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleTitle").value("AsArticle"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleDoi").value("5555"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.publicationDate").value("20-JAN-2015"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.acceptanceDate").value("22-JAN-2015"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAcceptedInOO").value("OnlineOpen"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName").value("John"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName.articleCoAuthors[0]").value("Mickey"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName.articleCoAuthors[1]").value("HONUR"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName.articleCoAuthors[2]").value("Javeb"))
					
					.andExpect(jsonPath("$.payload.articleData.production.productionStatus").value("Article accepted on"))
					.andExpect(jsonPath("$.payload.articleData.production.productionStatusDate").value("25-JAN-2015"));
					
				
		}
		
		@Test
		public void getPublishedArticleDetails() throws Exception {
			mockMvc.perform(
					get("/dashboard/published/{userId}").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.status").value("SUCCESS"))
					.andExpect(jsonPath("$.payload.articleData.articleUserRole").value("COAUTHOR"))
					.andExpect(jsonPath("$.payload.articleData.articleUserRole.journal.journalTitle").value("AsJournal"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleId").value("3"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleTitle").value("AsArticle"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleDoi").value("5555"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.publicationDate").value("20-JAN-2015"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.acceptanceDate").value("22-JAN-2015"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAcceptedInOO").value("OnlineOpen"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName").value("John"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName.articleCoAuthors[0]").value("Mickey"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName.articleCoAuthors[1]").value("HONUR"))
					.andExpect(jsonPath("$.payload.articleData.articleDetails.articleAuthorName.articleCoAuthors[2]").value("Javeb"))
					
					.andExpect(jsonPath("$.payload.articleData.publication.publicationStatus").value("Make OO"))
					.andExpect(jsonPath("$.payload.articleData.publication.modifiedDate").value("2015-07-15 07:47:32.192"));
						
		}

		@Test
		public void getEmailCommunicationHistory() throws Exception {
			mockMvc.perform(
					get("/dashboard/communication/{userId}").contentType(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.status").value("SUCCESS"))
					.andExpect(jsonPath("$.payload.invitationCommunicationDetails.userId").value("1000"))
					.andExpect(jsonPath("$.payload.invitationCommunicationDetails.inviationId").value("2"))
					.andExpect(jsonPath("$.payload.invitationCommunicationDetails.emailId").value("jo@gmail.com"))
					.andExpect(jsonPath("$.payload.invitationCommunicationDetails.articleId").value("10001"))
					.andExpect(jsonPath("$.payload.invitationCommunicationDetails.sentDate").value("2016-06-02"))
					
					.andExpect(jsonPath("$.payload.notifications.id").value("1"))
					.andExpect(jsonPath("$.payload.notifications.template.id").value("232"))
					.andExpect(jsonPath("$.payload.notifications.template.body").value("HHelloTest"))
					.andExpect(jsonPath("$.payload.notifications.template.tagl2").value("tt2"))
					.andExpect(jsonPath("$.payload.notifications.template.appId").value("111"))
					.andExpect(jsonPath("$.payload.notifications.template.description").value("Hello"))
					.andExpect(jsonPath("$.payload.notifications.template.tagl1").value("t1"))
					
					.andExpect(jsonPath("$.payload.notifications.senderId").value("sandy"))
					.andExpect(jsonPath("$.payload.notifications.senderEmail").value("email@vir.com"))
					.andExpect(jsonPath("$.payload.notifications.type").value("email"))
					.andExpect(jsonPath("$.payload.notifications.unread").value("n"))
					
					.andExpect(jsonPath("$.payload.notifications.notificationRecipients.notificationId").value("1"))
					.andExpect(jsonPath("$.payload.notifications.notificationRecipients.email").value("rec@vir.com"))
					.andExpect(jsonPath("$.payload.notifications.notificationRecipients.userId").value("deepu"));
					
					
		}
}
