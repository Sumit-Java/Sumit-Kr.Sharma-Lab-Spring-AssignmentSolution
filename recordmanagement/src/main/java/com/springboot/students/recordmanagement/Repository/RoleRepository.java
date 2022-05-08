package com.springboot.students.recordmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.students.recordmanagement.Entity.Roles;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Integer>{

}
