package com.springboot.students.recordmanagement.Service;

import java.util.List;

import com.springboot.students.recordmanagement.Entity.Roles;
import com.springboot.students.recordmanagement.Entity.Students;
import com.springboot.students.recordmanagement.Entity.Users;

public interface StudentService {
	
	public List<Students> findAll();
	
	public Students getById(int id);
	
	public void save(Students student);
	
	public void deleteById(int id);
	
	public Users saveUser(Users user);
	
	public Roles saveRole(Roles role);
	

}
