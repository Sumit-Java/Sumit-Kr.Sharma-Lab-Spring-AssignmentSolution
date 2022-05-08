package com.springboot.students.recordmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springboot.students.recordmanagement")
public class StudentRecordManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentRecordManagementApplication.class, args);
	}

}
