package com.tricon.Student.service;

import java.util.List;

import com.tricon.Student.model.Student;

public interface IStudentService {
	public List<Student>  getUser();
	public Student  getUserbyId(int id);
	Student addUser(Student sim);
	public void removeUser(int sim);
	
	String updateUser(Student sim);
}
