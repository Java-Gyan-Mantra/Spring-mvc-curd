package com.dugu.dev.acc.sr.web.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.dugu.dev.acc.sr.form.RegistrationForm;

@Component
public class RegistrationValidator implements Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String MOBILE_PATTERN = "[7-9][0-9]{9}";

	@Override
	public boolean supports(Class<?> classType) {
		return classType.isAssignableFrom(RegistrationForm.class);
	}

	@Override
	public void validate(Object form, Errors errors) {
		RegistrationForm registrationForm = (RegistrationForm) form;
		if (registrationForm.getFirstName().isEmpty()) {
			errors.rejectValue("firstName", "empty.firstName");
		}
		if (registrationForm.getLastName().isEmpty()) {
			errors.rejectValue("lastName", "empty.lastName");
		}
		if (registrationForm.getUserName().isEmpty()
				|| registrationForm.getUserName().length() < 2) {
			errors.rejectValue("userName", "invalid.userName");
		}
		if (!registrationForm.getPassword().equals(
				registrationForm.getConfirmPassword())) {
			errors.rejectValue("password", "mismatch.password");
		}
		if (!(registrationForm.getEmailId().matches(EMAIL_PATTERN))) {
			errors.rejectValue("emailId", "invalid.emailId");
		}
		if (!(registrationForm.getPhone().matches(MOBILE_PATTERN))) {
			errors.rejectValue("phone", "invalid.phone");
		}
		if(registrationForm.getLocation().isEmpty()){
			errors.rejectValue("location", "invalid.location");	
		}
	}
}
