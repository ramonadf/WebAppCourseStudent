package com.s2e.application.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s2e.application.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	Collection<Student> findById(int id);

	


	
	

	



}
