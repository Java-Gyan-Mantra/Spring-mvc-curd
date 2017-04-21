package com.dugu.dev.acc.sr.web.dao;

import java.util.List;

import com.dugu.dev.acc.sr.form.RegistrationForm;
import com.dugu.dev.acc.sr.web.model.RegistrationModel;

public interface StudentManagementDao {

	public void saveRegistration(RegistrationModel model);

	public List<RegistrationModel> getRegisterUser();

	public int deleteRecord(int userId);

	//public String updateRecord(int userId);
	public RegistrationModel getUser(int userId);

	String updateRecord(int userId, RegistrationForm registrationForm);

}
