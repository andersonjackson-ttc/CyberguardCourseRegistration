package com.cyberguard.webservice.major;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyberguard.webservice.course.Course;
import com.cyberguard.webservice.course.CourseRepository;

@Service
public class MajorService
{
	
	private final MajorRepository majorRepository;
	private final CourseRepository courseRepository;

	
	public MajorService(MajorRepository majorRepository, CourseRepository courseRepository) {
		this.majorRepository = majorRepository;
		this.courseRepository = courseRepository;
	}





	public List<Major> getMajors() 
	{
		return majorRepository.findAll();
	}//end of get majors





	public Major getMajor(Long iD) {
		// TODO Auto-generated method stub
		return majorRepository.getOne(iD);
	}





	public Major getOne(Long iD) {
		
		return majorRepository.getById(iD);
	}
	


	
	
	
}
