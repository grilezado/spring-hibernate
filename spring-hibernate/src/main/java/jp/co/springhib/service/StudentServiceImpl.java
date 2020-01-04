package jp.co.springhib.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.springhib.dao.StudentDao;
import jp.co.springhib.domain.Student;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;
	
	@Override
	public boolean updateStudent(Student student) {		
		return studentDao.updateStudent(student);
	}

	@Override
	public boolean deleteStudent(Student student) {
		return studentDao.deleteStudent(student);
	}

	@Override
	public List<Student> getStudents() {
		List<Student> student =  studentDao.getStudents();
		return student;
	}

	@Override
	public Student getStudentById(Student student) {
		return studentDao.getStudentById(student);
	}

	@Override
	public boolean saveStudent(Student student) throws Exception {
		return studentDao.saveStudent(student);
	}

}
