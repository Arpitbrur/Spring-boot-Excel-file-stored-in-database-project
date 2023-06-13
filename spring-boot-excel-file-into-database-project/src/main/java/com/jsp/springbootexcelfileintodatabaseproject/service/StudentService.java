package com.jsp.springbootexcelfileintodatabaseproject.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.springbootexcelfileintodatabaseproject.dto.Student;
import com.jsp.springbootexcelfileintodatabaseproject.helper.Helper;
import com.jsp.springbootexcelfileintodatabaseproject.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository repository;
	
	public void save(MultipartFile file) {
		try {
			List<Student> students= Helper.convertExcelToListOfStudent(file.getInputStream());
			
			this.repository.saveAll(students);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public List<Student> getAllStudent(){
		return this.repository.findAll();
	}
}
