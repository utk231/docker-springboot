package com.tricon.Student.daoimpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.tricon.Student.dao.IStudentDao;
import com.tricon.Student.model.Student;

@Repository
public class StudentDao implements IStudentDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final String FETCH_STUDENT = "select * from student";

	@Override
	public List<Student> getUser() {
		return this.jdbcTemplate.query(FETCH_STUDENT, new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setAddress(rs.getString("address"));
				return s;
			}
		});
	}

	@Override
	public Student getUserbyId(int id) {
		// TODO Auto-generated method stub
		return this.jdbcTemplate.queryForObject("select * from student where id =  " + id, new RowMapper<Student>() {
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setAddress(rs.getString("address"));
				return s;
			}
		});
	}

	@Override
	public Student addUser(Student stud) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.execute("insert into student (id, name, address) Values(' " + stud.getId() + "','"
				+ stud.getName() + "','" + stud.getAddress() + "')");
		return this.jdbcTemplate.queryForObject("select * from student where id =  " + stud.getId(),
				new RowMapper<Student>() {
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student s = new Student();
						s.setId(rs.getInt("id"));
						s.setName(rs.getString("name"));
						s.setAddress(rs.getString("address"));
						return s;
					}
				});
	}

	@Override
	public void removeUser(int stud) {
		// TODO Auto-generated method stub
		this.jdbcTemplate.execute("DELETE FROM student WHERE id =  " + stud);

	}
	@Override
	public 	String updateUser(Student stud) {
		
		this.jdbcTemplate.execute("UPDATE `student`.`student` SET `name` = ' " + stud.getName() + "', `address` = ' " + stud.getAddress()+"' WHERE (`id` = '"+stud.getId()+ "')");
		
		return "Updated Successfully";
	}
}
