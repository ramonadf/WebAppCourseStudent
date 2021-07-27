package com.s2e.application.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s2e.application.model.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

	Collection<Course> findById(int id);




}
