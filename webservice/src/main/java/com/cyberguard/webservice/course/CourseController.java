package com.cyberguard.webservice.course;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
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
		
		
		//return the courses with the major subtracted by the courses taken by the student
		return courseService.getCoursesByMajor(major, student.getId());
	}//end of get majors
	
	public void saveCourse(Student student, @RequestParam("CourseTaken")String[] coursesTaken)
	{
		Student newStudent = new Student();
		String[] newCourseList = coursesTaken;
	}
	
	@RequestMapping(value = "/editCourses", method = RequestMethod.POST)
	public String editCoursesTaken(@RequestParam("CourseTaken")String[] checkboxValue)
	{
		
			for(int i = 0 ; i < checkboxValue.length; i++)
			{
				return checkboxValue[i];
			}
				

		return "nothing";
	}


}
