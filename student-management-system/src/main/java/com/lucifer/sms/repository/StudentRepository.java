package com.lucifer.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucifer.sms.entity.Student;

/* 
	Here JpaRepository takes 2 different arguments - 
	1] Data Type of Entity Class (i.e. Student) 
	2] Data Type of Primary Key (i.e. Long Id)
	
	Also we don't have to add @Repository Annotation since JpaRepository already has it.
*/
public interface StudentRepository extends JpaRepository<Student, Long> {

}
