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
public class CoursesTakenController {

	//service variable
		public final CourseService courseService;
		public final MajorService majorService;
		public final StudentService studentService;
		
		
		//constructor
		@Autowired
		public CoursesTakenController(CourseService courseService, MajorService majorService, StudentService studentService) {
			this.courseService = courseService;
			this.majorService = majorService;
			this.studentService = studentService;
		}
	@RequestMapping(value = "/editCourses", method = RequestMethod.POST)
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
				courses2.add(new Course(courses[j]));
			}
			student.getCourses().addAll(courses2);
			studentService.save(student);
			
			return "index";
	}
	
	
}
