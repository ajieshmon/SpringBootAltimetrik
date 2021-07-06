package com.altimetrik.app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.altimetrik.controller.StudentController;
import com.altimetrik.model.Student;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class RestfulApicrudApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	protected <T> T mapFromJson(String json, Class<T> clazz)
		      throws JsonParseException, JsonMappingException, IOException {
		      ObjectMapper objectMapper = new ObjectMapper();
		      return objectMapper.readValue(json, clazz);
		   }
	protected String mapToJson(Object obj) throws JsonProcessingException {
	      ObjectMapper objectMapper = new ObjectMapper();
	      return objectMapper.writeValueAsString(obj);
	   }

	
	/*
	 * @Test public void testGetName() throws Exception {
	 * mockMvc.perform(get("/getName")) .andExpect(status().isOk())
	 * .andExpect(jsonPath("$.name").value("Anu")); }
	 */
	
	/*
	 * @Test public void testCreateStudent() throws Exception {
	 * 
	 * String uri="/saveStudent"; Student s=new Student(); s.setName("Sundari");
	 * s.setCollegeName("SSN"); s.setCgpa(8.58);
	 * 
	 * String inputJson=mapToJson(s);
	 * 
	 * MvcResult mvcResult=mockMvc.perform(MockMvcRequestBuilders.post(uri)
	 * .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn(
	 * );
	 * 
	 * int status=mvcResult.getResponse().getStatus();
	 * System.out.println("Status="+status); assertEquals(200, status); String
	 * msg=JsonPath.read(mvcResult.getResponse().getContentAsString(),"$.msg");
	 * System.out.println("Mesage:"+msg); assertEquals(msg, "Success");
	 * 
	 * 
	 * }
	 */
	
	
	  @Test 
	  public void testGetStudnet()throws Exception 
	  { 
		  String uri ="/getStudents"; 
		  MvcResult mvcResult =mockMvc.perform(MockMvcRequestBuilders.get(uri)
				  .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	  
	  int status = mvcResult.getResponse().getStatus(); 
	  assertEquals(200, status);
	  String content = mvcResult.getResponse().getContentAsString();
	  Student student[]=mapFromJson(content, Student[].class);
	  assertTrue(student.length >0);
	  
	  }
	 
	
	@Test
	public void testGetstudentById()throws Exception
	{
		String uri = "/getStudents/8";
	       MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(uri)
	          .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	       
	       int status = mvcResult.getResponse().getStatus();
	       assertEquals(200, status);
	       String content = mvcResult.getResponse().getContentAsString();
	       System.out.println(content);
	       String name= JsonPath.read(mvcResult.getResponse().getContentAsString(), "$.name");
	       System.out.println("--"+name);
	       assertEquals(name, "Aruna");

	}

	

}
