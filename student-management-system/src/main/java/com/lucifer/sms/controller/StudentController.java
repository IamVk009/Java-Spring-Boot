package com.lucifer.sms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.lucifer.sms.entity.Student;
import com.lucifer.sms.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentService;

//	Since we are using constructor-Injection with only one constructor so we can avoid @Autowired annotation.
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
//	Handler method to handle list students and return model and view.
	@GetMapping("/students")
	public String ListStudents(Model model) {
		model.addAttribute("students", studentService.getAllStudents());
		return "students"; // Here students is a view name.
	}
	
//	Handler method to create new student request.
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
//		Here we are creating empty student object to store student form data.
		Student student = new Student();
		model.addAttribute("student", student);
		return "create_student";
	}
	
//	Here @ModelAttribute annotation is used to directly bind the form data to the object.
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentService.getStudentDetailsbyId(id));
		return "edit_student";
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, 
			@ModelAttribute("student") Student student,
			Model model) {
//		Get Existing student details by Id.
		Student existingStudent = studentService.getStudentDetailsbyId(id);
		
//		Update Existing student details.
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
			
		studentService.updateStudent(existingStudent);
		return "redirect:/students";
	}
	
//	Handler Method to handle delete student request.
	@GetMapping("/students/delete/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
}

/*
 	> Spring boot will have to configure a view resolver for thymeleaf. But we don't have to manually create a 
 	  view resolver bean for thymeleaf, because Spring Boot will automatically configure a view resolver for thymeleaf
 	  as soon as it will find thymeleaf dependency in pom.xml
 	
 	> Also spring boot will try to find all the thymeleaf templates under src/main/resources/templates folder,
 	  hence we need to keep all the thymeleaf templates under src/main/resources/templates folder.
*/
