package com.springboot.students.recordmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.students.recordmanagement.Entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
	
	@Query("SELECT u FROM Users u WHERE u.username=?1")
	public Users getUserByUserName(String username);

}
