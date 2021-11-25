package com.cyberguard.webservice.course;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.cyberguard.webservice.major.Major;
import com.cyberguard.webservice.student.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "courses")
public class Course {
	@Id
	public String Course_ID;
	
	@ManyToMany(mappedBy = "courses")
	Set<Major> majors = new HashSet<>();
	
	
	@ManyToMany(mappedBy = "courses")
	Set<Student> students = new HashSet<>();
	public String Course_Section;
	public String Course_Name;
	
	
	public Course() {
		
	}
	
	public Course(String id, String courseSection, String courseName) {
		this.Course_ID = id;
		this.Course_Section = courseSection;
		this.Course_Name = courseName;
		System.out.println("Success");
	}
	public Course(String id)
	{
		this.Course_ID = id; 
	}
	
	//interface to get the desired attributes
	public interface CourseInfo {
		String getCourse_ID();
		String getCourse_Name();
	}

	public String getCourse_ID() {
		return Course_ID;
	}

	public void setCourse_ID(String course_ID) {
		Course_ID = course_ID;
	}

	public Set<Major> getMajors() {
		return majors;
	}

	public void setMajors(Set<Major> majors) {
		this.majors = majors;
	}

	public String getCourse_Section() {
		return Course_Section;
	}

	public void setCourse_Section(String course_Section) {
		Course_Section = course_Section;
	}

	public String getCourse_Name() {
		return Course_Name;
	}

	public void setCourse_Name(String course_Name) {
		Course_Name = course_Name;
	}



	
	
	
	

}
