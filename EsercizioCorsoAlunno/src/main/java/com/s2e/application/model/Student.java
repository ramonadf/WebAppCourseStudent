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
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "STUDENT")
public class Student {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NAME")
	private String name;
	@Column(name = "SURNAME")
	private String surname;
	@Column(name = "MAIL")
	private String mail;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "student_course", 
			joinColumns = @JoinColumn (name = "student_id",
			referencedColumnName = "id"), 
			inverseJoinColumns = @JoinColumn(name="course_id",
			referencedColumnName = "id")
			)
	

	@JsonIgnore
	private Set<Course> courses;
	
	public Student() {
		
	}

	public Student(int id, String name, String surname, String mail, Set<Course> courses) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.mail = mail;
		this.courses = courses;
	}

	public int getIdStudent() {
		return id;
	}

	public void setIdStudent(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<Course> getCourses() {
		return courses;
	}



	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}


	public void setAttributes(Student student) {
		this.name=student.name;
		this.surname=student.surname;
		this.mail=student.mail;
		
	}
	
	
	
}
	
	
	