package com.cyberguard.webservice.course;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyberguard.webservice.course.Course.CourseInfo;
import com.cyberguard.webservice.major.MajorService;
import com.cyberguard.webservice.student.Student;
import com.cyberguard.webservice.student.StudentService;


@RequestMapping(value="/courses")
@RestController
public class CourseController {
	
	//service variable
	private final CourseService courseService;
	private final MajorService majorService;
	private final StudentService studentService;
	
	//constructor
	@Autowired
	public CourseController(CourseService courseService, MajorService majorService, StudentService studentService) {
		this.courseService = courseService;
		this.majorService = majorService;
		this.studentService = studentService;
	}
	
	@GetMapping
	public Collection<CourseInfo> getCourses(@RequestParam("major") long major) {
		//get the current student
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object name = auth.getName();
		Student student = (Student) studentService.loadUserByUsername(name.toString());
		
		
		//return the courses with the major subtracted by the courses taken by the student
		return courseService.getCoursesByMajor(major, student.getId());
	}//end of get majors
	
	


}
