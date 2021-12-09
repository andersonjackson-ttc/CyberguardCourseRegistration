package com.cyberguard.webservice.course;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyberguard.webservice.major.MajorService;
import com.cyberguard.webservice.student.Student;
import com.cyberguard.webservice.student.StudentService;

@Controller
public class TakeCoursesController {

	//service variable
		public final CourseService courseService;
		public final MajorService majorService;
		public final StudentService studentService;
		
		
		//constructor
		@Autowired
		public TakeCoursesController(CourseService courseService, MajorService majorService, StudentService studentService) {
			this.courseService = courseService;
			this.majorService = majorService;
			this.studentService = studentService;
		}
		

		
		
	@RequestMapping(value = "/completeCourses", method = RequestMethod.POST)
	public String editCoursesTaken(@RequestParam("CourseTaken")String[] checkboxValue)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object name = auth.getName();
		Student student = (Student) studentService.loadUserByUsername(name.toString());
		String[] courses = new String[checkboxValue.length];
			for(int i = 0 ; i < checkboxValue.length; i++)
			{
				
				courses[i] = checkboxValue[i];
				
			}
			Collection<Course> courses2 = student.getCourses();
			for(int j = 0; j < courses.length; j++)
				
			{
				courses2.add(courseService.findCourseByCourse_ID(courses[j]));
			}
			student.getCourses().addAll(courses2);
			studentService.save(student);
			
			return "index";
	}
	
	@RequestMapping(value = "editCourses"/*"/enrollCourses"*/, method = RequestMethod.POST)
	public String enrollCourses(@RequestParam("CourseTaken")String[] checkboxValue) 
	{
		//load student
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object name = auth.getName();
		Student student = (Student) studentService.loadUserByUsername(name.toString());
		//create courses variable
		String[] courses = new String[checkboxValue.length];
			for(int i = 0 ; i < checkboxValue.length; i++)
			{

				courses[i] = checkboxValue[i];

			}
			//fetch enrolled courses table
			Collection<Course> courses2 = student.getEnrolledCourses();
			for(int j = 0; j < courses.length; j++)
				
			{
				courses2.add(courseService.findCourseByCourse_ID(courses[j]));
			}
			student.getEnrolledCourses().addAll(courses2);
			studentService.save(student);
			
			return "index";
	}
	
	
}
