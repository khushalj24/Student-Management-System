package com.example.sms.Dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.sms.Entity.Student;

@Repository
public class StudentDao {

	@Autowired 
	SessionFactory sf;
	
	
	public ArrayList<Student> getstudents() {
		Session session = sf.openSession();
		Criteria criteria = session.createCriteria(Student.class);
		ArrayList<Student> al = (ArrayList<Student>) criteria.list();
		session.close();
		return al;
	}


	public void insertstudent(Student student) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.save(student);
		tr.commit();
		session.close();
	}


	public void updatestudent(Student student) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		session.update(student);
		tr.commit();
		session.close();
		
	}


	public void deletestudent(long id) {
		Session session = sf.openSession();
		Transaction tr = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		tr.commit();
		session.close();	
	}


	public Student getstudentbyid(long id) {
		Session session = sf.openSession();
	    Student student = session.get(Student.class, id);
	    session.close();
	    return student ;
		
	}
	
	
}
