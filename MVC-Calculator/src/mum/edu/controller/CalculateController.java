package mum.edu.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;






import mum.edu.domain.InputDomain;
import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.controller.Controller;
import mum.edu.validator.CalculateValidator;



public class CalculateController implements Controller{
	
	@AutoWired
	CalculateValidator calculateValidator;
	
	public String inputCalculate(HttpServletRequest request, 
			HttpServletResponse response) {
	
		return "/WEB-INF/jsp/CalculateForm.jsp";
	}
	
	
	public String saveCalculate(InputDomain inputDomain, HttpServletRequest request, 
			HttpServletResponse response) {
		
		List<String> errors = calculateValidator.validate(inputDomain);
		System.out.println("before Submission");
				
		if(errors.isEmpty()){
			System.out.println("after Submission");
			request.setAttribute("inputdomain", inputDomain);
			return "/WEB-INF/jsp/CalculateShow.jsp";
		}else{
			request.setAttribute("errors", errors);
			request.setAttribute("inputDOMAIN", inputDomain);
			return "/WEB-INF/jsp/CalculateForm.jsp";
		}
		
		
        
 	}

}
