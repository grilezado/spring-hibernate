package jp.co.springhib.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jp.co.springhib.domain.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean saveStudent(Student student) {
		boolean status = false;
		try {
		sessionFactory.getCurrentSession().save(student);
		status = true;
		} catch (Exception e) {
			throw e;
		}
		return status;
	}

	@Override
	public boolean updateStudent(Student student) {		
		boolean status = false;
		try {
		sessionFactory.getCurrentSession().update(student);
		status = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public List<Student> getStudents() {
		Session session = sessionFactory.getCurrentSession();		
		//hql name of the class and the variables of the class
		Query<Student> student = session.createQuery(" FROM Student ", Student.class);
		
		List<Student> list = student.getResultList();
		
		if(list == null) {
			return new ArrayList<>();
		}
		
		return list;
	}

	@Override
	public Student getStudentById(Student student) {
		Student stud = sessionFactory.getCurrentSession().get(Student.class, student.getStudentId());
//		Query<Student> query = 
//				session.createQuery(" FROM Student where student_id = :student_id", Student.class);
//		query.setParameter("student_id", student.getStudentId());
//		List<Student> list = query.getResultList();
		return stud;		
	}

	@Override
	public boolean deleteStudent(Student student) {
		boolean status = false;
		try {
			sessionFactory.getCurrentSession().delete(student);
			status = true;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return status;	
	}

}
