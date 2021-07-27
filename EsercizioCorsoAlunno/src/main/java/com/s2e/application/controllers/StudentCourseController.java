package com.s2e.application.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2e.application.model.Course;
import com.s2e.application.model.Student;
import com.s2e.application.repositories.CourseRepository;
import com.s2e.application.repositories.StudentRepository;

@RestController
public class StudentCourseController {
	
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;

	@PostMapping("/courses/{course_id}/students/{student_id}")
	public void subscribeStudentToCourse(@PathVariable("course_id") int idC,
										 @PathVariable("student_id") int idS){
		Course course = courseRepository.getById(idC);
		Student student = studentRepository.getById(idS);
		course.subscribeStudent(student);
		courseRepository.save(course);
	}
	
	@DeleteMapping("/courses/{course_id}/students/{student_id}")
	public void deleteStudentFromCourses (@PathVariable("student_id") int idS, 
										  @PathVariable("course_id") int idC) {
		Course course = courseRepository.getById(idC);
		Student student = studentRepository.getById(idS);
		course.deleteStudent(student);
		courseRepository.save(course);
	}
	
	@GetMapping("/students/{student_id}/courses")
	public Collection<Course> getStudentIdByCourse(@PathVariable("student_id") int id){
		Student student = studentRepository.getById(id);
		return student.getCourses();
	}
	
	
	@GetMapping("/courses/students/{student_id}")
	public Collection<Course> getCourseByStudentId(@PathVariable("student_id") int id){
		Student student = studentRepository.getById(id);
		return student.getCourses();
	}
	
	@GetMapping("/students/courses/{course_id}")
	public Collection<Student> getStudentByCourseID(@PathVariable("course_id") int id){
		Course course = courseRepository.getById(id);
		return course.getStudents();
	}
	
	
	
	
		
	
}
