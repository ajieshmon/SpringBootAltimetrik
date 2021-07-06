package com.altimetrik.service;

import com.altimetrik.model.Student;
import java.util.*;

public interface StudentService {
	
	public Object saveStudent(Student student);
	public List<Student> getAllStudent();
	public Student getStudentById(int id);
	public Object updateStudent(Student student);
	public List<Student> getAllStudentByCollegeName(Student student);
	public Object getName();

}
