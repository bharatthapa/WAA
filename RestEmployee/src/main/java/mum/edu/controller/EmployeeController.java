package mum.edu.controller;

import mum.edu.domain.Employee;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping({"/","/employee"})
public class EmployeeController {
	
	@RequestMapping("/")
	public String display() {
		
		return "employee";
	}
		
	@RequestMapping(value = "/add", method = RequestMethod.POST)	
	public @ResponseBody Employee add(@RequestBody Employee employee)  {

		return employee;
	}
}
