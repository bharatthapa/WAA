package mum.edu.validator;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import mum.edu.domain.Calculator;

@Service("calculateValidator")
public class CalculateValidatorImpl implements CalculateValidator{

	@Override
	public List<String> validate(Object object) {
		
		List<String> errors = new ArrayList<String>();
		
		Calculator calculator = (Calculator)object;
		
		if(calculator.getSum1()==null || calculator.getSum2()==null)
			errors.add(" One of the sum Field is Empty !");
		
		if(calculator.getMul1()==null || calculator.getMul2()==null)
		    errors.add(" One of the multiply Field is Empty !");
		
		return errors;
	}

}
