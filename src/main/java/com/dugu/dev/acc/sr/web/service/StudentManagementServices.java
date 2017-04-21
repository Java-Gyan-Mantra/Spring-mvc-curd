package com.dugu.dev.acc.sr.web.service;

import java.util.List;

import com.dugu.dev.acc.sr.form.RegistrationForm;
import com.dugu.dev.acc.sr.web.model.RegistrationModel;

public interface StudentManagementServices {

	public String register(RegistrationForm registrationForm);
	public List<RegistrationModel> getUsers();
	public String deleteRecord(int userId);
	//public String update(int id);
	public RegistrationModel getUser(int id) ;
	String update(int id, RegistrationForm registrationForm);
}
