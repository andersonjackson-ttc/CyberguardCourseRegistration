package com.cyberguard.webservice.major;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity
@Table(name = "majors")
public class Major {
	@Id
	@SequenceGenerator(name = "major_sequence", sequenceName = "major_sequence", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "major_sequence")
	
	private Long id;
	private String name;
	
	
	public Major() {
		
	}
	
	public Major(Long id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("Success");
	}


	
	
	
	

}
