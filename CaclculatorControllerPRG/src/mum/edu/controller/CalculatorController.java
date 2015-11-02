package mum.edu.controller;


import java.io.IOException;

import mum.edu.domain.Calculator;
import mum.edu.service.CalculatorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

 
@Controller
public class CalculatorController {
 
  @Autowired
  CalculatorService calculatorService;
  
  @RequestMapping(value={"/","/Calculator"} , method = RequestMethod.GET)
  public String inputCalc() throws Exception {
  
       return  "CalculatorForm" ;    
   }
   
  @RequestMapping(value= "/Calculator" , method = RequestMethod.POST)
  public String handleCalc(Calculator calculator, Model model,RedirectAttributes redirectAttributes ) throws Exception {
  
		if (calculator.getAdd1() != null &&
			 calculator.getAdd2() != null)
		     calculatorService.add(calculator);
 
		if (calculator.getMult1() != null &&
				 calculator.getMult2() != null)
			calculatorService.mult(calculator);

		redirectAttributes.addFlashAttribute( calculator);
 
        return  "redirect:results" ; 
   }
   
  
  @RequestMapping(value="/results", method = RequestMethod.GET)
  public String calculatorResults(Model model) throws IOException {

  	/*Calculator calculator = (Calculator)( ((ModelMap) model).get("calculator") );

  	if (calculator == null)
  		throw new IOException("The calculation is Obsolete, Try Again!");*/
  	  
        return "CalculatorView";
  }


 
}
