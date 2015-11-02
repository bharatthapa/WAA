package com.packt.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.packt.webstore.domain.Employee;
import com.packt.webstore.service.EmployeeService;

@Controller
@RequestMapping({ "/employees" })
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/list")
	public String listEmployees(Model model) {
		
		model.addAttribute("employees", employeeService.listEmployees());

		return "employees";
	}

	@RequestMapping("/employee")
	public String getEmployeeByNumber(Model model,
			@RequestParam("id") int employeeId) {
		
		model.addAttribute("employee", employeeService.locateOneEmployeeByHisNumber(employeeId));
		return "employee";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addNewEmployee(@ModelAttribute("newEmployee") Employee newEmployee) {
		return "addEmployee";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String processAddNewEmployee(@ModelAttribute("newEmployee") Employee employeeToBeAdded) {

		return "redirect:/employees";
	}

}
