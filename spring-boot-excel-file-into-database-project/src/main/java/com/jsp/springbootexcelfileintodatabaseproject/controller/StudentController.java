package com.jsp.springbootexcelfileintodatabaseproject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jsp.springbootexcelfileintodatabaseproject.dto.Student;
import com.jsp.springbootexcelfileintodatabaseproject.helper.Helper;
import com.jsp.springbootexcelfileintodatabaseproject.service.StudentService;



@RestController
@CrossOrigin("*")
public class StudentController {

	@Autowired
	private StudentService service;

	
	@PostMapping("/student/upload")
	public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file){
		if(Helper.checkExcelFormat(file)) {
			this.service.save(file);
			return ResponseEntity.ok(Map.of("message", "file is uploading and data is stored in db"));
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please upload excel file only");
	}
	
	
	@GetMapping("/student")
	public List<Student> getAllStudent(){
		return this.service.getAllStudent();
	}
	
}
