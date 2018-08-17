package com.tricon.Student.dao;

import java.util.List;

import com.tricon.Student.model.Student;

public interface IStudentDao {
	public List<Student> getUser();

	public Student getUserbyId(int id);

	public Student addUser(Student stud);
	
	public void removeUser(int stud);
	
	public String updateUser(Student stud);

	
}
