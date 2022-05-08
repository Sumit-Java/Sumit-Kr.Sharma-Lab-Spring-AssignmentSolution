package com.springboot.students.recordmanagement.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.students.recordmanagement.Entity.Roles;
import com.springboot.students.recordmanagement.Entity.Students;
import com.springboot.students.recordmanagement.Entity.Users;
import com.springboot.students.recordmanagement.Repository.RoleRepository;
import com.springboot.students.recordmanagement.Repository.StudentRepository;
import com.springboot.students.recordmanagement.Repository.UserRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	BCryptPasswordEncoder bcryptEncoder;

	@Override
	public List<Students> findAll() {

		return studentRepository.findAll();
	}

	@Override
	public Students getById(int id) {

		Students theStudent = studentRepository.getById(id);
		return theStudent;

	}

	@Override
	public void save(Students student) {
		studentRepository.save(student);

	}

	@Override
	public void deleteById(int id) {
		studentRepository.deleteById(id);

	}

	@Override
	public Users saveUser(Users user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return userRepository.save(user);

	}

	@Override
	public Roles saveRole(Roles role) {
		return roleRepository.save(role);
	}

}
