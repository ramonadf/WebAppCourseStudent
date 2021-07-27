package com.s2e.application;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.s2e.application.model.Student;
import com.s2e.application.repositories.StudentRepository;

import static org.junit.Assert.*;

@SpringBootTest
class ApplicationTests {

	@Autowired
	StudentRepository studentRepo;

	@Test
	void givenStudents_studentsReceived_status200() throws ClientProtocolException, IOException {

		// compilo la richiesta http
		HttpUriRequest request = new HttpGet("http://localhost:4202/students");

		// eseguo la richiesta http
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);

		// controllo che lo stato sia 200
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));

	}

	@Test
	void givenCourse_coursesReceived_status200() throws ClientProtocolException, IOException {
		HttpUriRequest request = new HttpGet("http://localhost:4202/courses");
		HttpResponse httpResponse = HttpClientBuilder.create().build().execute(request);
		assertThat(httpResponse.getStatusLine().getStatusCode(), equalTo(HttpStatus.SC_OK));
	}

	@Test
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

}
