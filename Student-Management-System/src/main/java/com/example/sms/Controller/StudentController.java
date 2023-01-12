package com.example.sms.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.sms.Entity.Student;
import com.example.sms.Service.StudentService;

@Controller
public class StudentController {
   
	@Autowired 
	StudentService ser;	
	
    //students page
	@GetMapping("/students")
	public ModelAndView help(@ModelAttribute Student student) {
		System.out.println("this is controller");
		ArrayList<Student> al = ser.getstudents();
		Student student1= new Student();
		ModelAndView mv = new ModelAndView();
		mv.addObject("student",student1);
		mv.addObject("students", al);
		mv.setViewName("students");
		return mv;	
	   }
	
	//student object is send to Add Student page
	@GetMapping("/students/new")
	public String createStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "createstudent";	
	}

	//request for adding new student
	@PostMapping("/students")
	public ModelAndView addstudent(@ModelAttribute Student student) {
		    ser.insertstudent(student);
		  
		  ArrayList<Student> al = ser.getstudents();
			ModelAndView mv1 = new ModelAndView();
			mv1.addObject("students", al);
			mv1.setViewName("students");
			 return mv1 ;
		}

	@GetMapping("/students/edit/{id}")
	public String editStudent(@PathVariable long id , Model model) {
		Student student = ser.getstudentbyid(id);
		model.addAttribute("student",student);
		return "editstudent";	
	}
	
	
	//request for Updating existing student
	@PostMapping("/students/editpage/{id}")
	public ModelAndView editstudent(@PathVariable long id ,@ModelAttribute Student student) {
		
		//Get existing student from database by id
		Student existingStudent = ser.getstudentbyid(id);
		  existingStudent.setFirstName(student.getFirstName());
		  existingStudent.setLastName(student.getLastName());
		  existingStudent.setEmail(student.getEmail());
		  
		//Save existing student object
		  ser.updatestudent(existingStudent);
		  
		  ArrayList<Student> al = ser.getstudents();
			ModelAndView mv1 = new ModelAndView();
			mv1.addObject("students", al);
			mv1.setViewName("students");
			 return mv1 ;
		}
	
	//request for deleting a student
	@GetMapping("/students/delete/{id}")
  public ModelAndView deletestudent(@PathVariable long id) {
	      ser.deletestudent(id);
	     
	   ArrayList<Student> al = ser.getstudents();	     
	   ModelAndView mv3 = new ModelAndView();
	    mv3.addObject("students", al);
	    mv3.setViewName("students");
	    return mv3 ;
  }
	
	
	
	
	
}
