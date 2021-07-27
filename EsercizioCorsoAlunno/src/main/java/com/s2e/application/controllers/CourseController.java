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

import com.s2e.application.model.Course;

import com.s2e.application.repositories.CourseRepository;

@RestController
public class CourseController {
	
	@Autowired
	CourseRepository repo;
	
	
	@GetMapping("/courses")
	public Collection<Course> getAllCourse() {
		return repo.findAll();
	}
//upload
	@PostMapping("/courses")
	public void saveCourse(@RequestBody Course course) {
		repo.save(course);
	}
	
	@GetMapping("/courses/{course_id}")
	public Collection<Course> getCourse(@PathVariable("course_id") int id){
		return repo.findById(id);	
	}
		
	@DeleteMapping("/courses/{course_id}")
	public void deleteCourse(@PathVariable("course_id") int id) {
		repo.deleteById(id);
	}
	
	@PutMapping("/courses/{course_id}")
	public void updateCourse(@PathVariable("course_id") int id, @RequestBody Course course) {
		Course oldCourse = repo.getById(id);
		oldCourse.setAttributes(course);
		repo.save(oldCourse);
	}
	
	

	
	



	

}
