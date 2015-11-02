package mum.edu.contorllers;

import java.util.List;

import mum.edu.domain.Calculator;
import mum.edu.validator.CalculateValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CalculatorController {
	
	@Autowired
	@Qualifier("calculateValidator")
	CalculateValidator calculateValidator;
	
	
//	public CalculatorController(CalculateValidator calculateValidator) {
//		this.calculateValidator=calculateValidator;
//	}

	@RequestMapping(value = "/")
	public String inputCalculator() {

		return "CalculateForm";
	}

	@RequestMapping(value = "/saveCalculate", method = RequestMethod.POST)
	public String saveCalculator(Model model, @ModelAttribute("calculator1") Calculator calculator) {
		
		List<String> errors = calculateValidator.validate(calculator);
		System.out.println("error size" + errors.size());
		if(errors.isEmpty()){
			//model.addAttribute("data", calculator);

			return "CalculateShow";
		}

		else{
			model.addAttribute("errors", errors);
			//model.addAttribute("data1", calculator);
			return "CalculateForm";
		}
	}

}
