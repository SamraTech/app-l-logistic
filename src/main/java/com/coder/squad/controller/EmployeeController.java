package com.coder.squad.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.coder.squad.model.Employee;
import com.coder.squad.service.EmpService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmpService service;
	@GetMapping("/excel")
	public ModelAndView showExcel() {
		
		System.out.println("Come to exvcel");
		ModelAndView view = new ModelAndView("employee");
		List<Employee> all = service.getAll();
		view.addObject("list", all);
		view.setView(new EmployeeExcelView());
		
		return view;

	}
	@GetMapping("/pdf")
	public ModelAndView showPdf() {
		ModelAndView view = new ModelAndView("employee");
		List<Employee> all = service.getAll();
		view.addObject("list", all);
		view.setView(new EmployeePdfView());
		return view;
		
	}

	@GetMapping("/register")
	public String registerForm(Model model) {

		Employee emp = new Employee();
		model.addAttribute("employee", emp);
		return "employee";
	}
	@PostMapping("/save")
	public String saveEmp(@ModelAttribute ("employee") Employee emp,Model model) {
		Integer saveemp = service.saveemp(emp);
		model.addAttribute("msg",saveemp);
		return "employee";
		
	}
}
