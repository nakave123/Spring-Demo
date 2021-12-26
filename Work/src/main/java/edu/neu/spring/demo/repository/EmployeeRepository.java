/**
 * 
 */
package edu.neu.spring.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.neu.spring.demo.entity.Employee;

/**
 * @author pratiknakave
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	Optional<Employee> findById(long Id);
	List<Employee> findAll();
}
