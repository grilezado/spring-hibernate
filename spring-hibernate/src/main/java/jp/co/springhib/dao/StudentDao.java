package jp.co.springhib.dao;

import java.util.List;

import jp.co.springhib.domain.Student;

public interface StudentDao {
	
	boolean saveStudent(Student student);
	
	boolean updateStudent(Student student);
	
	List<Student> getStudents();
	
	Student getStudentById(Student student);
	
	boolean deleteStudent(Student student);

}
