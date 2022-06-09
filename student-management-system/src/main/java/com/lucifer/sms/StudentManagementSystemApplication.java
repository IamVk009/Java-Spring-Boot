package com.lucifer.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucifer.sms.repository.StudentRepository;

/* 
 * Here we are implementing CommandLineRunner interface, which provides run method that executes when we 
 * run our spring boot application.
*/
@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
//			Student s1 = new Student("Jeff", "Bezos" , "jeffy@amazon.com");
//			studentRepository.save(s1);
//			
//			Student s2 = new Student("Elon", "Musk", "Elon.Musk@spacex.com");
//			studentRepository.save(s2);
//			
//			Student s3 = new Student("Bill", "Gates", "Bill.Gates@microsoft.com");
//			studentRepository.save(s3);
//		
	}

}
