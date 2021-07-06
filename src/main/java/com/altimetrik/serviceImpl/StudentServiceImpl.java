package com.altimetrik.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.altimetrik.model.Student;
import com.altimetrik.repository.StudentRepo;
import com.altimetrik.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	@Transactional
	public Object saveStudent(Student student) {
		Map<String, String> map=new HashMap<>();
		if(student.getName().isEmpty())
		{
			map.put("status", "error");
			map.put("msg","please enter the Name");
		}else
		{
			map.put("status", "200");
			map.put("msg","Success");
			studentRepo.save(student);
		}
		
		return map;
	}

	@Override
	@Transactional
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepo.findAll();
	}

	@Override
	@Transactional
	public Student getStudentById(int id) {
		return studentRepo.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Object updateStudent(Student student) {
		Map<String, String> map=new HashMap<>();
		if(student.getName().isEmpty())
		{
			map.put("status", "error");
			map.put("msg","please enter the Name");
		}else
		{
			map.put("status", "200");
			map.put("msg","Data updated successfully");
			studentRepo.saveAndFlush(student);
		}
		
		return map;
	}

	@Override
	@Transactional
	public List<Student> getAllStudentByCollegeName(Student student) {
		// TODO Auto-generated method stub
		return studentRepo.getStudentsByCollegeName(student.getCollegeName());
	}

	@Override
	@Transactional
	public Object getName() {
		// TODO Auto-generated method stub
		Map<String, Object> map=new HashMap<String, Object>();
		map.put("name", "Anugrakha");
		return map;
	}

}
