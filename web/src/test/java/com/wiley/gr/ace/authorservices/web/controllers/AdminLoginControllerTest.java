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
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.web.context.WebApplicationContext;





import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.wiley.gr.ace.authorservices.web.controllers.AdminLoginController;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration("classpath:testmvc-dispatcher-servlet.xml")
@WebAppConfiguration
public class AdminLoginControllerTest {
	
	@Autowired
    private AdminLoginController adminLoginController;
	
	
	//AdminLoginController adminLoginController = new AdminLoginController();
	
	@Autowired
	 private MockMvc mockMvc;
	 
	 @Before  
	 public void init() {
			this.mockMvc = MockMvcBuilders.standaloneSetup(adminLoginController).build();
		}  
	
	 @Test
	 public void login() throws Exception
	 {
	mockMvc.perform(post("/admin/login/")
			  .contentType(MediaType.APPLICATION_JSON)
			  .content("{\"emailId\":\"ssaraf@wiley.com\", \"password\":\"Sripad1234\"}".getBytes()))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("success"));
			 		
	 }
	 
	 @Test
	 public void createAdmin() throws Exception
	 {
	mockMvc.perform(post("/admin/create").contentType(MediaType.APPLICATION_JSON)
			.content("{\"emailId\": \"abcd@wiley.com\", \"rolesList\" : [\"1\",\"2\"], \"firstname\": \"Test\", \"lastname\":\"Test\" }".getBytes()))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("success"));
			 		
	 }
	 
	 @Test
	 public void requestAccess() throws Exception
	 {
	mockMvc.perform(post("/admin/requestAccess/rasinha@wiley.com/123")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("success"));
			 		
	 }
	 
	 @Test
	 public void getPermissions() throws Exception
	 {
	mockMvc.perform(get("/admin/permissions")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.rolesList.roleId").value("100"))
			  .andExpect(jsonPath("$.rolesList.roleName").value("sfsfff"))
			  .andExpect(jsonPath("$.rolesList.roleDescription").value(null))
			  .andExpect(jsonPath("$.rolesList.adminRole").value("false"));
			 		
	 }
	 
	 @Test
	 public void getPermissionsForRole() throws Exception
	 {
	mockMvc.perform(get("/admin/permissions/{roleId}")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.rolesList.sectionsList.sectionName").value("Admin"))
			  .andExpect(jsonPath("$.rolesList.sectionsList.permissionsList.permissionId").value("20"))
			  .andExpect(jsonPath("$.rolesList.sectionsList.permissionsList.permissionName").value("Create User Roles"))
			  .andExpect(jsonPath("$.rolesList.sectionsList.permissionsList.status").value("true"))
			  .andExpect(jsonPath("$.rolesList.sectionsList.permissionsList.permissionId").value("21"))
			  .andExpect(jsonPath("$.rolesList.sectionsList.permissionsList.permissionName").value("Modify User Roles"))
			  .andExpect(jsonPath("$.rolesList.sectionsList.permissionsList.status").value("true"));
	 }
	 
	 @Test
	 public void addOrUpdateUserRole() throws Exception
	 {
			mockMvc.perform(post("/admin/permissions")
					  .contentType(MediaType.APPLICATION_JSON)
					  .content("{\"role\":{"
					  		+ "\"roleId\":\"0\",   \"roleName\":\"Ravi\", \"roleDescription\":\"Test Role\", \"adminRole\":\"true\"},  \"permissionsMap\" : {\"0\" :  [ \"1\", \"2\",\"3\",\"4\",\"5\", \"17\",\"20\" ]".getBytes()))
			  .andExpect(status().isOk())
			  //.andExpect(status().isCreated())
			  .andExpect(jsonPath("$.status").value("SUCCESS"));
			
	 }
	 
	 
	 @Test
	 public void findUser() throws Exception
	 {
	mockMvc.perform(get("/admin/findUser/{emailId}")
			  .contentType(MediaType.APPLICATION_JSON))
			  .andExpect(status().isOk())
			  
			  .andExpect(jsonPath("$.status").value("success"))
			  .andExpect(jsonPath("$.payload.firstname").value("Ravi"))
			  .andExpect(jsonPath("$.payload.lastname").value("Sinha"));
			 		
	 }
}
