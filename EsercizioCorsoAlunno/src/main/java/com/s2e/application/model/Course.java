package com.s2e.application.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="COURSE")
public class Course {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name="CFU")
	private int CFU;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "student_course", 
			joinColumns = @JoinColumn(name = "course_id", 
			referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name = "student_id", 
			referencedColumnName = "id")
			)
	@JsonBackReference
	private Set<Student> students;
	
	public Course() {
		
	}
	
	public Course(int id, String name, String description, int cFU, Set<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.CFU = cFU;
		this.students = students;
	}
	
	
	public void setAttributes (Course course) {
		this.name=course.name;
		this.description=course.description;
		this.CFU=course.CFU;
		this.students=course.students;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCFU() {
		return CFU;
	}
	public void setCFU(int cFU) {
		CFU = cFU;
	}
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public void subscribeStudent(Student student) {
		students.add(student);
		
	}

	public void deleteStudent(Student student) {
		students.remove(student);
		
	}


	

	
	}
		