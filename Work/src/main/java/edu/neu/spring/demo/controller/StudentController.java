/**
 * 
 */
package edu.neu.spring.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.spring.demo.Util;
import edu.neu.spring.demo.entity.Student;
import edu.neu.spring.demo.service.StudentService;

/**
 * @author pratiknakave
 *
 */
@RestController
public class StudentController {
	@Autowired
	StudentService studentService;
	
	//private int id = 1;
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		System.out.println("Get all Students called");
		return studentService.getAllStudents();
	}
	@GetMapping("/retrieveStudent/{id}")
	public Student retrieveStudent(@PathVariable long id) throws Exception {
		System.out.println("Getting Student with id " + id);
		return studentService.getStudentById(id);
	}
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable long id) throws Exception {
		System.out.println("Deleting Student with id " + id);
		studentService.deleteStudentById(id);
	}
	@PostMapping("/addStudent")
	public void addStudent() throws Exception {
		System.out.println("Adding a student");
		long id = studentService.getAllStudents().size();
		Student emp = new Student(id+1,Util.nameGenerator(),Util.nameGenerator(),Util.nameGenerator()+"@gmail.com");
		studentService.createOrUpdateStudent(emp);
	}

}
