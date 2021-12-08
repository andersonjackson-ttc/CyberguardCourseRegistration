package com.cyberguard.webservice.course;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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




@RestController
public class CourseController {
	
	//service variable
	public final CourseService courseService;
	public final MajorService majorService;
	public final StudentService studentService;
	
	
	//constructor
	@Autowired
	public CourseController(CourseService courseService, MajorService majorService, StudentService studentService) {
		this.courseService = courseService;
		this.majorService = majorService;
		this.studentService = studentService;
	}
	
	@RequestMapping(value="/courses")
	@GetMapping
	public Collection<CourseInfo> getCourses(@RequestParam("major") long major) {
		//get the current student
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object name = auth.getName();
		Student student = (Student) studentService.loadUserByUsername(name.toString());
		major = student.getMajor();
		
		//filter courses that have pre-requisites
		Collection<CourseInfo> courses = courseService.getCoursesByMajor(major, student.getId());

		Iterator<CourseInfo> iter = courses.iterator();
		while(iter.hasNext()) {
			if(!(courseService.seeNoPreReq(iter.next().getCourse_ID(), student.getId()))) {
				iter.remove();
			}
		}
			
		
		//return the courses with the major subtracted by the courses taken by the student
		return courses;
	}//end of get majors

	
	
	


}
