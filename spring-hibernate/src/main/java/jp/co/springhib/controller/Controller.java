package jp.co.springhib.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.springhib.domain.Student;
import jp.co.springhib.service.StudentService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/v1")
public class Controller {
	
	@Autowired
	private StudentService studentService;

	@GetMapping("students")
	public List<Student> getStudents() {
		return studentService.getStudents();
	}
	
	@GetMapping("student/{id}")
	public Student getStudentById(@PathVariable("id") Integer id, @RequestBody Student student){
		student.setStudentId(id);		
		return studentService.getStudentById(student);
	}
	
	@PostMapping("save-student")
	public boolean saveStudent(@RequestBody Student student) throws Exception {
		return studentService.saveStudent(student);
	}
	
	@PostMapping("student/{id}")
	public boolean updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@DeleteMapping("delete-student/{id}")
	public boolean deleteStudent(@PathVariable("id") Integer id, @RequestBody Student student) {
		student.setStudentId(id);
		return studentService.deleteStudent(student);
	}
	
}
