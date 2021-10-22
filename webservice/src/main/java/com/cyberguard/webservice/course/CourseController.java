package com.cyberguard.webservice.course;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cyberguard.webservice.course.Course.CourseInfo;
import com.cyberguard.webservice.major.Major;
import com.cyberguard.webservice.major.MajorService;


@RequestMapping(value="/courses")
@RestController
public class CourseController {
	
	//service variable
	private final CourseService courseService;
	private final MajorService majorService;
	
	//constructor
	@Autowired
	public CourseController(CourseService courseService, MajorService majorService) {
		this.courseService = courseService;
		this.majorService = majorService;
	}
	
	@GetMapping
	public Collection<CourseInfo> getCourses(@RequestParam("major") long major) {
		//Major majorObject = majorService.getOne(major);
		return courseService.getCoursesByMajor(major);
	}//end of get majors
	
	


}
