package com.altimetrik.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.model.Student;
import com.altimetrik.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	
	//@RequestMapping(value = "/saveStudent",method = RequestMethod.POST)
	@PostMapping("/saveStudent")
	public Object insertStdent(@RequestBody Student student)
	{
		return(studentService.saveStudent(student));
	}
	
	//@GetMapping("/getStudents")
	@RequestMapping(value = "/getStudents", method = RequestMethod.GET)
	public List<Student> getAllStudents()
	{
		return(studentService.getAllStudent());
	}
	
	@GetMapping("/getStudents/{id}")
	public Student getStudentById(@PathVariable int id)
	{
		return(studentService.getStudentById(id));
	}
	
	@PutMapping("/updateStudent")
	public Object updateStdent(@RequestBody Student student)
	{
		return(studentService.updateStudent(student));
	}
	
	@PostMapping("/getDetailsByCollegeName")
	public List<Student> getAllStudentsByName(@RequestBody Student student)
	{
		return(studentService.getAllStudentByCollegeName(student));
	}
	
	@GetMapping("/getName")
	public Object  getName() {
		return studentService.getName();
		
	}
	
	 
	
	

}
