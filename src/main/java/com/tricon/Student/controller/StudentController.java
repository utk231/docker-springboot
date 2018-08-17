package com.tricon.Student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tricon.Student.model.Student;
import com.tricon.Student.service.IStudentService;

@RestController
public class StudentController {

	@Autowired
	private IStudentService  student;
	
	@RequestMapping("/user")
	public List<Student> getUser() {
		System.out.println("Inside: Controller");
		return student.getUser();
	}
		@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
		public Student getUserbyId(@PathVariable int id) {
			System.out.println("Inside: Controller");
			return student.getUserbyId(id);
	}
		@RequestMapping(value = "/user", method = RequestMethod.POST)
		public Student addUser(@RequestBody Student stud) {
			System.out.println("Inside: Controller");
			return student.addUser(stud);
	
}
		@RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
		public String removeUser(@PathVariable int id) {
			System.out.println("Inside: Controller");
			student.removeUser(id);
			return "Deleted Successfully";
}
		@RequestMapping(value = "/user", method = RequestMethod.PUT)
		public String updateUser(@RequestBody Student stud) {
			System.out.println("Inside: Controller");
			
			return student.updateUser(stud);
		}
}

