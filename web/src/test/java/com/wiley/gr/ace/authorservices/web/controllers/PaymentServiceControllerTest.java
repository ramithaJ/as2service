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

import com.wiley.gr.ace.authorservices.web.controllers.PaymentServiceController;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:testmvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class PaymentServiceControllerTest {
	
	@Autowired
    private PaymentServiceController paymentServiceController;
	
	
	
	
	@Autowired
	 private MockMvc mockMvc;
	 
	 @Before  
	 public void init() {
			this.mockMvc = MockMvcBuilders.standaloneSetup(paymentServiceController).build();
		}  

	 @Test
	 public void getWPGConfiguration() throws Exception
	 {
	mockMvc.perform(post("/payment/wpg/config/{orderId}")
			  .contentType(MediaType.APPLICATION_JSON)
			  .content("{\"emailId\":\"ssaraf@wiley.com\", \"password\":\"Sripad1234\"}".getBytes()))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("success"));
			 		
	 }
	 
	 @Test
	 public void redirectWpgResponse() throws Exception
	 {
	mockMvc.perform(post("/payment/wpg/details")
			  .contentType(MediaType.APPLICATION_JSON)
			  .content("{\"emailId\":\"ssaraf@wiley.com\", \"password\":\"Sripad1234\"}".getBytes()))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("success"));
			 		
	 }
}
