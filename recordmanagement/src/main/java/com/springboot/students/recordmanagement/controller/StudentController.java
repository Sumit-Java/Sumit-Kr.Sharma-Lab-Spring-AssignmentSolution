package com.springboot.students.recordmanagement.controller;

import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springboot.students.recordmanagement.Entity.Students;
import com.springboot.students.recordmanagement.Service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("/list")
	public String getAllStudentList(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> currentPrincipalName = authentication.getAuthorities();
		System.out.println(currentPrincipalName);
		
		List<Students> allStudentsRecord = studentService.findAll();
		model.addAttribute("list", allStudentsRecord);

		return "main-page";
	}

	@GetMapping("/addStudent")
	public String addStudentForm(Model model, Students student) {
		model.addAttribute("newStudent", student);
		return "add-student";

	}

	@PostMapping("/savestudent")
	public String saveStudent(@ModelAttribute("newStudent") Students student) {
		studentService.save(student);
		return "redirect:/list";

	}

	@GetMapping("/delete")
	public String deleteStudent(@RequestParam("studentId") int id) {
		studentService.deleteById(id);
		return "redirect:/list";

	}

	@GetMapping("/update")
	public String updateStudent(@RequestParam("studentId") int id, Model model) {
		Students studentById = studentService.getById(id);
		model.addAttribute("updateStudent", studentById);

		return "update-student";

	}
	
		
}
