package com.cyberguard.webservice.student;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly =true)
public interface StudentRepository extends JpaRepository<Student, Long> {
	Optional<Student> findByUsername(String username);
	Student getStudentByUsername(String username);
}
