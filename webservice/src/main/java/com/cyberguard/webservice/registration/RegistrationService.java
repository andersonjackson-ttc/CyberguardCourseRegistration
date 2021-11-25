package com.cyberguard.webservice.registration;

import org.springframework.stereotype.Service;

import com.cyberguard.webservice.student.Student;
import com.cyberguard.webservice.student.StudentService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {
	
	private final StudentService studentService;
	
	public void register(RegistrationRequest request) {
		// TODO Auto-generated method stub
		studentService.signUpStudent(new Student(request.getUsername(), request.getPassword(), request.getMajor()));
	}

}
