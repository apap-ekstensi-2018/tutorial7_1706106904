package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.dao.StudentDAO;
import com.example.model.StudentModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class StudentServiceRest implements StudentService{
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public StudentModel selectStudent(String npm) {
		log.info ("REST - select student with npm {}", npm);
		return studentDAO.selectStudent(npm);
	}

	@Override
	public List<StudentModel> selectAllStudents() {
		log.info ("REST - select all student");
		return studentDAO.selectAllStudents();
	}

	@Override
	public boolean addStudent(StudentModel student) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStudent(String npm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStudent(StudentModel student) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
