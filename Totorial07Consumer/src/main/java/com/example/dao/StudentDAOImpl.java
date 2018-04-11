package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.StudentModel;
import com.example.service.StudentServiceRest;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public StudentModel selectStudent(String npm) {
		StudentModel student = 
				restTemplate.getForObject
				("http://localhost:8080/rest/student/view/"+npm,
				StudentModel.class);
		
		return student;
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		ResponseEntity<List<StudentModel>> res =
				restTemplate.exchange("http://localhost:8080/rest/student/viewall",
				HttpMethod.GET, null,
				new ParameterizedTypeReference<List<StudentModel>>() {});
	
		HttpStatus statusCode = res.getStatusCode();
		HttpHeaders headers = res.getHeaders();
		
		log.info ("REST - select all student - code status: "+statusCode);
		log.info ("REST - select all student - content type: "+headers.getContentType());
		
		List<StudentModel> selectAllStudents = res.getBody(); 
		return selectAllStudents;
	}

}
