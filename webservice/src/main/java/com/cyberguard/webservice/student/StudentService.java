package com.cyberguard.webservice.student;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;
@Service
public class StudentService implements UserDetailsService 
{
	
	private final StudentRepository studentRepository;
	private final static String USER_NOT_FOUND = "user with username %s not found";
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	

	
	public StudentService(StudentRepository studentRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.studentRepository = studentRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		
	}

	


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		return studentRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND, username)));
	}

	public void signUpStudent(Student student) {
		boolean exists = studentRepository.findByUsername(student.getUsername()).isPresent();
		
		if (exists)
			throw new IllegalStateException("Username already taken");
		
		String encodedPassword = bCryptPasswordEncoder.encode(student.getPassword());
		student.setPassword(encodedPassword);
		student.setPassword(student.getPassword());
		student.setMajor(student.getMajor());
		studentRepository.save(student);
	}
}
