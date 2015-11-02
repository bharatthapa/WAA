package mum.edu.validator;

import java.util.ArrayList;
import java.util.List;

import mum.edu.domain.InputDomain;

public class CalculateValidatorImpl implements CalculateValidator{

	@Override
	public List<String> validate(Object object) {
		
		List<String> errors = new ArrayList<String>();
		
		InputDomain inputDomain = (InputDomain)object;
		
		if(inputDomain.getSum1()==null || inputDomain.getSum2()==null)
				
			errors.add(" One of the sum Field is Empty !");
		if(inputDomain.getMul1()==null || inputDomain.getMul2()==null)
		 errors.add(" One of the multiply Field is Empty !");
		
		return errors;
	}

}
