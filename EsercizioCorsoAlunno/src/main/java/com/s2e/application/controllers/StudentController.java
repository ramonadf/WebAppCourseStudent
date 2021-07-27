package com.s2e.application.controllers;

import java.util.Collection;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.application.model.Student;
import com.s2e.application.repositories.StudentRepository;

@RestController
public class StudentController {	
	
	@Autowired
	StudentRepository repo;
		
	@GetMapping("/students")
	public Collection<Student> getAllStudent() {
		return repo.findAll();
	}
	
	@PostMapping("/students")
	public void saveStudent(@RequestBody Student student) {
		repo.save(student);
	}
	
	@GetMapping("/students/{student_id}")
	public Collection<Student> getStudent(@PathVariable("student_id") int id){
		return repo.findById(id);	
	}
		
	@DeleteMapping("/students/{student_id}")
	public void deleteStudent(@PathVariable("student_id") int id) {
		repo.deleteById(id);
	}
	
	@PutMapping("/students/{student_id}")
	public void updateStudent(@PathVariable("student_id") int id, @RequestBody Student student) {
		Student oldStudent = repo.getById(id);
		oldStudent.setAttributes(student);
		repo.save(oldStudent);
	}
	
	
	
	
}
