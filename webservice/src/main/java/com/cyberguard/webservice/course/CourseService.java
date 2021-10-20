package com.cyberguard.webservice.course;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cyberguard.webservice.course.Course.CourseInfo;

@Service
public class CourseService {
	private final CourseRepository courseRepository;

	
	public CourseService(CourseRepository courseRepository) {
		this.courseRepository = courseRepository;
			
	}


	
	public Collection<CourseInfo> getCoursesByMajor(long major) 
	{
	//	return null;
		return courseRepository.findAllByMajors_ID(major);
	}//end of get majors


}
