/**
 * 
 */
package edu.neu.spring.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.neu.spring.demo.Util;
import edu.neu.spring.demo.entity.Employee;
import edu.neu.spring.demo.service.EmployeeService;

/**
 * @author pratiknakave
 *
 */

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	List<Employee> empList = new ArrayList<>();
	private int id = 1;
	
	
//	@GetMapping("/allEmployees")
//	   public ResponseEntity<Object> getProduct() {
//		System.out.println("Employees called");
//	      return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
//	   }
	
	@GetMapping("/employees")
	public List<Employee> getEmployees(){
		System.out.println("Get all Employees called");
		return employeeService.getAllEmployees();
	}
	@GetMapping("/retrieveEmployee/{id}")
	public Employee retrieveEmployee(@PathVariable long id) throws Exception {
		System.out.println("Getting Employee with id " + id);
		return employeeService.getEmployeeById(id);
	}
	@DeleteMapping("/deleteEmployee/{id}")
	public void deleteEmployee(@PathVariable long id) throws Exception {
		System.out.println("Deleting Employee with id " + id);
		employeeService.deleteEmployeeById(id);
	}
	@PostMapping("/addEmployee")
	public void addEmployee() throws Exception {
		System.out.println("Adding an employee");
		long id = employeeService.getAllEmployees().size();
		Employee emp = new Employee(id+1,Util.nameGenerator(),Util.nameGenerator(),Util.nameGenerator()+"@gmail.com",
				Util.imageGenerator());
		employeeService.createOrUpdateEmployee(emp);
	}
//	@PostMapping(value="/add")
//    public ResponseEntity<Employee> createOrUpdateEmployee() throws Exception {
//		System.out.println("Adding an employee");
//		long id = employeeService.getAllEmployees().size();
//		Employee employee = new Employee(id+1,nameGenerator(),nameGenerator(),ageGenerator());
//        Employee updated = employeeService.createOrUpdateEmployee(employee);
//        return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
//    }
	
	
	@RequestMapping("/insertEmployee")
	public void insertEmployee() {
		empList.add(new Employee(id++,Util.nameGenerator(),Util.nameGenerator(),Util.nameGenerator()+"@gmail.com", 
				Util.imageGenerator()));
		System.out.println("Employee added");
	}
	
	@RequestMapping("/getEmployee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		System.out.println("Getting Employee with id " + id);
		return empList.get(id-1);
	}
	
	@RequestMapping("/getAllEmployees")
	public List<Employee> getAllEmployees() {
		System.out.println("Getting all Employee list");
		return empList;
	}
	
	@RequestMapping("/removeEmployee/{id}")
	public void removeEmployee(@PathVariable int id) {
		 empList.remove(id-1);
		 System.out.println("Employee removed");
	}
	
}
