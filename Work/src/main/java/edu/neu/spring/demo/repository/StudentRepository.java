/**
 * 
 */
package edu.neu.spring.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.neu.spring.demo.entity.Student;

/**
 * @author pratiknakave
 *
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

	Optional<Student> findById(long Id);
	List<Student> findAll();
}
