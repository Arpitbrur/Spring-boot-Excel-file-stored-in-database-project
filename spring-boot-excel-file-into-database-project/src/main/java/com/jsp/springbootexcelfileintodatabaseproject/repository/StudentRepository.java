package com.jsp.springbootexcelfileintodatabaseproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springbootexcelfileintodatabaseproject.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
