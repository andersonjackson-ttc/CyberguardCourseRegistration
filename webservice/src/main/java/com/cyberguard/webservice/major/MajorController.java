package com.cyberguard.webservice.major;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/major")
public class MajorController {
	
	//service variable
	private final MajorService majorService;
	
	//constructor
	@Autowired
	public MajorController(MajorService majorService) {
		this.majorService = majorService;
	}
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping
	public List<Major> getMajors() {
		return majorService.getMajors();
	}//end of get majors


	
	

}
