package com.springboot.students.recordmanagement.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name="student")
public class Students {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;
	
	@Column(name="Student_name")
	private String studentName;
	
	@Column(name="Department")
	private String departmentName;
	
	@Column(name="Country")
	private String countryName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public Students(int id, String studentName, String departmentName, String countryName) {
		super();
		this.id = id;
		this.studentName = studentName;
		this.departmentName = departmentName;
		this.countryName = countryName;
	}

	public Students() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", studentName=" + studentName + ", departmentName=" + departmentName
				+ ", countryName=" + countryName + "]";
	}

	
	
}
