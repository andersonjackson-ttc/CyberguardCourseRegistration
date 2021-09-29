package com.cyberguard.webservice.major;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class MajorService
{
	
	private final MajorRepository majorRepository;

	
	public MajorService(MajorRepository majorRepository) {
		this.majorRepository = majorRepository;
	}





	public List<Major> getMajors() 
	{
		return majorRepository.findAll();
	}//end of get majors
	
	
	
}
