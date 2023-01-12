package com.example.sms.Service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.sms.Dao.StudentDao;
import com.example.sms.Entity.Student;

@Service
public class StudentService {

	@Autowired
	StudentDao dao;
	
	public ArrayList<Student> getstudents() {
		ArrayList<Student> al = dao.getstudents();
		return al;
	}

	public void insertstudent(Student student) {
		dao.insertstudent(student);
	}

	
	public void updatestudent(Student student) {
		dao.updatestudent(student);	
	}

	public void deletestudent(long id) {
		dao.deletestudent(id);	
	}

	public Student getstudentbyid(long id) {
	     return 	dao.getstudentbyid(id);
	}
	
	
	
}
