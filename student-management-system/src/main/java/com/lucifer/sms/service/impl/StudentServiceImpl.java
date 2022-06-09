package com.lucifer.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lucifer.sms.entity.Student;
import com.lucifer.sms.repository.StudentRepository;
import com.lucifer.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

//	Since we are using constructor-Injection with only one constructor so we can avoid @Autowired annotation.
	private StudentRepository studentRepository;
	
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public Student getStudentDetailsbyId(Long id) {
		return studentRepository.findById(id).get();
	}

	@Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
	}

}
