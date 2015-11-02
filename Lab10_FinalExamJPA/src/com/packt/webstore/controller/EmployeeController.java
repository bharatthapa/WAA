package com.packt.webstore.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.packt.webstore.domain.Employee;
import com.packt.webstore.service.EmployeeService;

@Controller
@RequestMapping({ "/employees" })
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@RequestMapping("/list")
	public String listEmployees(Model model) {
		model.addAttribute("employees", this.service.findAll());
		return "employees";
	}

	@RequestMapping("/employee")
	public String getEmployeeByNumber(Model model,
			@RequestParam("id") int employeeId) {
		try {
			model.addAttribute("employee",
					service.getEmployeeByNumber(employeeId));
		} catch (IllegalArgumentException ex) {
			model.addAttribute("error", ex.getMessage());
		}
		return "employee";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNewEmployee(
			@ModelAttribute("newEmployee") Employee newEmployee) {
		return "addEmployee";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewEmployee(
			@Valid @ModelAttribute("newEmployee") Employee employeeToBeAdded,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		if (bindingResult.hasErrors()) {
			return "addEmployee";
		}
		try {
			this.service.add(employeeToBeAdded);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
			redirectAttributes.addFlashAttribute("error", ex.getMessage());
			return "addEmployee";
		}
		return "redirect:/employees";
	}

}
