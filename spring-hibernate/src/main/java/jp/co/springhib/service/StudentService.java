package jp.co.springhib.service;

import java.util.List;

import jp.co.springhib.domain.Student;

public interface StudentService {
	
	boolean saveStudent(Student student) throws Exception;
	
	boolean updateStudent(Student student);
	
	boolean deleteStudent(Student student);
	
	List<Student> getStudents();
	
	Student getStudentById(Student student);

}
