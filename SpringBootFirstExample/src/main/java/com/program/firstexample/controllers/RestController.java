package com.program.firstexample.controllers;

import java.util.List;

import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.program.firstexample.models.Student;
import com.program.firstexample.repository.StudentRepository;

@org.springframework.web.bind.annotation.RestController
public class RestController {
	private StudentRepository studentRepository;

	@Autowired
	public RestController(StudentRepository studentRepository) {
		this.studentRepository = studentRepository;
	}

	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	@ResponseBody
	public String saveStudent(@RequestBody Student student) {
		// System.out.println(student.toString());
		studentRepository.save(student);
		return "Student Saved Successfully";
	}

	@RequestMapping("/student")
	@ResponseBody
	public List<Student> student(@QueryParam(value = "name") String name) {
		if (name == null)
			return (List<Student>) studentRepository.findAll();
		else
			return (List<Student>) studentRepository.findByname(name);
	}
}
