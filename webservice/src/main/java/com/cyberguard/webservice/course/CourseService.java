package com.cyberguard.webservice.course;

import java.util.Collection;

import org.springframework.stereotype.Service;

import com.cyberguard.webservice.course.Course.CourseInfo;

@Service
public class CourseService {
	private final CourseRepository courseRepository;

	
	public CourseService(CourseRepository courseRepository/* CoursesPreReqRepository coursesPreReqRepository*/) {
		this.courseRepository = courseRepository;

			
	}


	
	public Collection<CourseInfo> getCoursesByMajor(long major, Long student_id) 
	{
	//	return null;
		return courseRepository.findAllByMajors_ID(major, student_id);
	}//end of get majors
	
	
	//get course by course ID
	public Course findCourseByCourse_ID(String Course_ID) {
		
		return courseRepository.findByCourse_ID(Course_ID);
	}
	
	
	//get course by course ID info to filter in CourseController
	public CourseInfo findByCourse_IDInfo(String Course_ID) {
		
		return courseRepository.findByCourse_IDInfo(Course_ID);
	}
	
	
	//see if the student has passed the pre-req
	public boolean seeNoPreReq(String course, Long username) 
	{
		int check = courseRepository.seePreReq(course);
		
		
		if (check > 0) {
			int met = courseRepository.preReqExists(course, username);
			if(met > 0) {
				return true;
			} else {
				return false;
			}
			
			
		} else {
			return true;
		}
		

		
		
	} 



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
