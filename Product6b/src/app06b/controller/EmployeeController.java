package app06b.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import app06b.domain.Employee;

@org.springframework.stereotype.Controller

public class EmployeeController {
	
	private static final Log logger = LogFactory.getLog(EmployeeController.class);
		
	@RequestMapping(value={"/","/employee_input"})
	public String inputEmployee(Employee employee) {  // What's the puropse of Employee employee
	
		System.out.println("Employee name \t" + employee.getFirstName()); // null
		return "EmployeeForm";
	}

	@RequestMapping(value="/employee_save") // RequestMethod.POST not required.
	public String saveEmployee(@Valid @ModelAttribute  Employee employee, BindingResult bindingResult,
			Model model) {
 		//System.out.println("Employee name \t" + employee.getFirstName()); // sth
		if (bindingResult.hasErrors()) {
			return "EmployeeForm";
		}
		
//		 String[] suppressedFields = bindingResult.getSuppressedFields();
//		 if (suppressedFields.length > 0) {
//		 throw new RuntimeException("You've attempted to bind fields that haven't been allowed in initBinder(): "
//		 + StringUtils.addStringToArray(suppressedFields, ", "));
//		 }
		
		
		// save product here
		// YA this redundant line has obstructed the jsp page to be saved 
	   // model.addAttribute("employee", employee);
	    
	   
		return "EmployeeDetails";
	}
	
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
//         binder.setDisallowedFields("id");
//        binder.setRequiredFields("username", "password", "emailAddress");
        logger.info("initBinderin EmployeeController");
    }
}
