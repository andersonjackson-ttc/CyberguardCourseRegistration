package com.cyberguard.webservice.course;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.cyberguard.webservice.course.Course.CourseInfo;
import com.cyberguard.webservice.student.Student;

@Repository
public interface CourseRepository extends JpaRepository<Course, String> {
	@Query(value = "SELECT c.COURSE_ID, c.Course_Name "
			+ "FROM courses c INNER JOIN major_courses mc ON c.Course_ID = mc.Course_ID INNER JOIN majors m ON mc.ID = m.ID "
			+ "WHERE m.ID = ?1 "
			+ "AND "
			+ "c.Course_ID  NOT IN "
			+ "("
			+ "    select sc.Course_ID "
			+ "    from student_courses sc "
			+ "    inner join student s on s.id  = sc.ID "
			+ "    where s.id = ?2 "
			+ ")"
			+ " AND c.Course_ID NOT IN "
			+ "("
			+ "		select ec.Course_ID "
			+ "   	from student_enrolled_courses ec "
			+ "		inner join student s on s.id = ec.id "
			+ "		where s.id = ?2"
			+ ") "
			+ "GROUP BY c.Course_ID, c.Course_Name", nativeQuery = true)
	//@Query(value = "SELECT C.COURSE_ID,c.Course_Section, c.Course_Name FROM courses c, major_courses mc, majors m WHERE c.Course_ID = mc.Course_ID AND mc.ID = m.ID AND m.ID = ?1", nativeQuery = true)
	List<CourseInfo> findAllByMajors_ID(long major, Long student_id);
	
	@Query(value="SELECT * FROM courses c WHERE c.Course_ID = ?1", nativeQuery=true)
	CourseInfo findByCourse_IDInfo(String username);
	
	//Course findByCourse_ID(String Course_ID);
	@Query(value="SELECT * FROM courses c WHERE c.Course_ID = ?1", nativeQuery=true)
	Course findByCourse_ID(String username);
	
	@Query(value="SELECT  COUNT(*) "
	+ "FROM courses_prereq p "
	+ "INNER JOIN courses c ON p.course_id = c.course_id "
	+ "WHERE p.Course_ID = ?1", nativeQuery=true)
	int seePreReq(String Course);
	
	@Query(value=" SELECT COUNT(*) from courses_prereq p where p.Course_ID = ?1 "
			+ " AND (p.Course_Prereq IN"
			+ "     ("
			
			+ "         select co.Course_ID "
			+ "         from student_courses co "
			+ "         WHERE  co.Course_ID = p.Course_Prereq AND co.ID = ?2 "
			+ "     )"
			+ " OR p.Course_Prereq IN "
			+ "     ("
			+ "         select se.Course_ID "
			+ "         from student_enrolled_courses se "
			+ "         WHERE  se.Course_ID = p.Course_Prereq AND se.ID = ?2"
			+ ""
			+ "     )"
			+ ")"
			+ "", nativeQuery=true)
	int preReqExists(String course, Long username);
	

	

}
