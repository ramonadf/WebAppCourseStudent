package com.s2e.application;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.google.gson.Gson;
import com.s2e.application.model.Course;
import com.s2e.application.model.Student;
import com.s2e.application.repositories.CourseRepository;
import com.s2e.application.repositories.StudentRepository;

import static org.junit.Assert.*;

@SpringBootTest
class ApplicationTests {

	@Autowired
	StudentRepository studentRepo;

	@Autowired
	CourseRepository courseRepo;

	@Test //@GetMapping("/students")
	void givenStudents_studentsReceived_status200() throws ClientProtocolException, IOException {

		// compilo la richiesta http
		HttpUriRequest request = new HttpGet("http://localhost:4202/students");

		// eseguo la richiesta http
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// controllo che lo stato sia 200
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));

	}

	@Test //@GetMapping("/courses")
	void givenCourse_coursesReceived_status200() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:4202/courses");
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}

	@Test //@PostMapping("/students")
	void postNewStudent() throws ClientProtocolException, IOException {
		Student student = new Student(0, "Maria", "Luce", "maria.luce@mail.com", null);
		Gson gson = new Gson();
		String json = gson.toJson(student);
		HttpUriRequest request = RequestBuilder.create("POST").setUri("http://localhost:4202/students")
				.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON)).build();
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		Student s = studentRepo.getById(0);
		assertNotNull(s);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));

	}

	@Test //@DeleteMapping("/students/{student_id}")
	void givenStudentsDelete_deleteById() throws ClientProtocolException, IOException {

		int idTest = 1;
		HttpUriRequest request = new HttpDelete("http://localhost:4202/students" + idTest);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
		Student deleted = null;
		try {
			deleted = studentRepo.getById(idTest);
		} catch (Exception e) {
		}
		assertEquals(deleted, null);

	}

	@Test //@GetMapping("/courses/students/{student_id}")
	void givenCourseStudent_coursesReceived_status200() throws ClientProtocolException, IOException {
		int idTest = 2;
		HttpUriRequest request = new HttpGet("http://localhost:4202/courses/students/" + idTest);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}

	@Test //@DeleteMapping("/courses/{course_id}")
	void givenCoursesDelete_deleteById() throws ClientProtocolException, IOException {

		int idTest = 1;
		HttpUriRequest request = new HttpDelete("http://localhost:4202/courses" + idTest);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
		Course deleted = null;
		try {
			deleted = courseRepo.getById(idTest);
		} catch (Exception e) {
		}
		assertEquals(deleted, null);

	}

	@Test //@PostMapping("/courses")
	void postNewCourse() throws ClientProtocolException, IOException {
		Course course = new Course(0, "PROGRAMMAZIONE AGLI OGGETTI", "Corso di informatica 2", 6, null);
		Gson gson = new Gson();
		String json = gson.toJson(course);
		HttpUriRequest request = RequestBuilder.create("POST").setUri("http://localhost:4202/courses")
				.setEntity(new StringEntity(json, ContentType.APPLICATION_JSON)).build();
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		Course c = courseRepo.getById(0);
		assertNotNull(c);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}
	
	@Test //@GetMapping("/courses/{course_id}")
	void givenCourseId_coursesReceived_status200() throws ClientProtocolException, IOException {
		int idTest = 3;
		HttpUriRequest request = new HttpGet("http://localhost:4202/courses" + idTest);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}
	
	@Test //@GetMapping("/students/{student_id}")
	void givenStudentId_coursesReceived_status200() throws ClientProtocolException, IOException {
		int idTest = 7;
		HttpUriRequest request = new HttpGet("http://localhost:4202/students" + idTest);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}
	
	@Test //@GetMapping("/students/{student_id}/courses")
	void givenCoursesByStudentId_coursesReceived_status200() throws ClientProtocolException, IOException {
		int idTest = 5;
		HttpUriRequest request = new HttpGet("http://localhost:4202/students/" + idTest + "/courses");
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}
	
	@Test //@GetMapping("/students/courses/{course_id}")
	void givenStudentByCourseId_coursesReceived_status200() throws ClientProtocolException, IOException {
		int idTest = 4;
		HttpUriRequest request = new HttpGet("http://localhost:4202/students/courses" + idTest);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}
	
	@Test //@DeleteMapping("/courses/{course_id}/students/{student_id}")
	void givenStudentDeleteFromCourse_deleteById() throws ClientProtocolException, IOException {

		int idTestCourse = 5;
		int idTestStudent = 3;
		HttpUriRequest request = new HttpDelete("http://localhost:4202/courses" + idTestCourse + "/students/" + idTestStudent);
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
		Student deleted = null;
		try {
			deleted = studentRepo.getById(idTestStudent);
		} catch (Exception e) {
		}
		assertEquals(deleted, null);

	}

	

}
