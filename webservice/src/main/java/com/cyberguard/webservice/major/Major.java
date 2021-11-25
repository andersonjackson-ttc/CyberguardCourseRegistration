package com.cyberguard.webservice.major;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cyberguard.webservice.course.Course;
import com.cyberguard.webservice.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "majors")
public class Major {
	@Id
	private Long ID;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name="major_courses",
			joinColumns = @JoinColumn(name = "ID", referencedColumnName = "ID"),
			inverseJoinColumns = @JoinColumn(name = "Course_ID", referencedColumnName = "Course_ID")
			)
	
	private Set<Course> courses = new HashSet<>();
	
	

	

	private String Major_Name;
	
	
	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}

	public String getMajor_Name() {
		return Major_Name;
	}

	public void setMajor_Name(String major_Name) {
		Major_Name = major_Name;
	}

	public Major() {
		
	}
	
	public Major(Long id, String name) {
		this.ID = id;
		this.Major_Name = name;
		System.out.println("Success");
	}


	
	
	
	

}
