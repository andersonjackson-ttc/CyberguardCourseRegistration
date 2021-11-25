package com.cyberguard.webservice.course;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.cyberguard.webservice.course.Course.CourseInfo;
import com.cyberguard.webservice.student.Student;

@Service
public class CourseService {
	private final CourseRepository courseRepository;

	
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
			
	}


	
	public Collection<CourseInfo> getCoursesByMajor(long major, Long student_id) 
	{
	//	return null;
		return courseRepository.findAllByMajors_ID(major, student_id);
	}//end of get majors



/*
	public void saveCourse(Student studentS, @RequestParam("CourseTaken")String[] coursesTaken)
	{
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Object name = auth.getName();
		Student student = (Student) studentService.loadUserByUsername(name.toString());
		Student newStudent = new Student();
		String[] newCourseList = coursesTaken;
	}
*/
}
