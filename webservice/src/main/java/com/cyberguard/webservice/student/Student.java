package com.cyberguard.webservice.student;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cyberguard.webservice.course.Course;
import com.cyberguard.webservice.course.Course.CourseInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@Setter
public class Student implements UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private String username;
	private String password;
	private int major;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_courses",
			joinColumns = @JoinColumn(name = "ID", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "Course_ID", referencedColumnName = "Course_ID")
			)
	public Set<Course> courses = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
			name = "student_enrolled_courses",
			joinColumns = @JoinColumn(name = "ID", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "Course_ID", referencedColumnName = "Course_ID")
			)
	public Set<Course> enrolledCourses = new HashSet<>();
	
	public Student() {
		
	}
	 
	public Student(String username, String password, int major) {
		this.username = username;
		this.password = password;
		this.major = major;
	}


	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority("student");
		return Collections.singletonList(authority);
	}
	public void setID(Long id)
	{
		id = id;
	}
	public Long getID()
	{
		return id;
	}
	public int getMajor()
	{
		return major;
	}
	
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}
	public Long getId() {
		return id;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Collection<Course> getCourses() {
		// TODO Auto-generated method stub
		return courses;
	}
	
	public Collection<Course> getEnrolledCourses() {
		// TODO Auto-generated method stub
		return enrolledCourses;
	}
	
	
	

	
}
