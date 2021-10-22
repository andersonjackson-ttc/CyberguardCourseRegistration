package com.cyberguard.webservice.major;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cyberguard.webservice.course.Course;

@Repository
public interface MajorRepository extends JpaRepository<Major, Long>{
	
	
}
