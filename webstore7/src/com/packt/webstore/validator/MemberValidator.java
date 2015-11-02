package com.packt.webstore.validator;

 	import org.springframework.validation.Errors;
	import org.springframework.validation.ValidationUtils;
	import org.springframework.validation.Validator;

	import com.packt.webstore.domain.Member;

	public class MemberValidator implements Validator {

		@Override
		public boolean supports(Class<?> c) {
			return Member.class.isAssignableFrom(c);
		}

		@Override
		public void validate(Object command, Errors errors) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "Member.firstname.empty");
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "LastName", "Member.lastname.empty");
 			Member member = (Member)command;
			if( member.getMemberNumber() == null ||
					member.getMemberNumber() <= 0)
				errors.rejectValue("memberNumber","Member.Number.lessthan");
			if( member.getAge() <  18)
				errors.rejectValue("age","Member.age");
 		}

 	}
