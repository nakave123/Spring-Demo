/**
 * 
 */
package edu.neu.spring.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.neu.spring.demo.entity.Student;
import edu.neu.spring.demo.repository.StudentRepository;

/**
 * @author pratiknakave
 *
 */
@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public List<Student> getAllStudents()
    {
        List<Student> studentList = studentRepository.findAll();
         
        if(studentList.size() > 0) {
            return studentList;
        } else {
            return new ArrayList<Student>();
        }
    }
	
	public Student getStudentById(Long id) throws Exception 
    {
        Optional<Student> student = studentRepository.findById(id);
         
        if(student.isPresent()) {
            return student.get();
        } else {
            throw new Exception("No employee record exist for given id");
        }
    }
	
	public Student createOrUpdateStudent(Student entity) throws Exception 
    {
        Optional<Student> employee = studentRepository.findById(entity.getId());
         
        if(employee.isPresent()) 
        {
        	Student newEntity = employee.get();
            newEntity.setId(entity.getId());
            newEntity.setfName(entity.getfName());
            newEntity.setlName(entity.getlName());
            newEntity.setemail(entity.getemail());
            newEntity.setCategoryPhoto(entity.getCategoryPhoto());
            newEntity = studentRepository.save(newEntity);
             
            return newEntity;
        } else {
            entity = studentRepository.save(entity);
             
            return entity;
        }
    } 
     
    public void deleteStudentById(Long id) throws Exception 
    {
        Optional<Student> student = studentRepository.findById(id);
         
        if(student.isPresent()) 
        {
        	studentRepository.deleteById(id);
        } else {
            throw new Exception("No employee record exist for given id");
        }
    } 

}
