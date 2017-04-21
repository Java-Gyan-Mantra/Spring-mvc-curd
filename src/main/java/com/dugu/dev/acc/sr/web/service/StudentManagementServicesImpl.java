package com.dugu.dev.acc.sr.web.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dugu.dev.acc.sr.form.RegistrationForm;
import com.dugu.dev.acc.sr.web.dao.StudentManagementDao;
import com.dugu.dev.acc.sr.web.model.RegistrationModel;

@Service
@Transactional
public class StudentManagementServicesImpl implements StudentManagementServices {
	@Autowired(required = true)
	private StudentManagementDao dao;

	@Override
	public String register(RegistrationForm registrationForm) {
		String message = null;
		if (registrationForm != null) {
			RegistrationModel model = new RegistrationModel();
			model.setFirstName(registrationForm.getFirstName());
			model.setLastName(registrationForm.getLastName());
			model.setUserName(registrationForm.getUserName());
			model.setPassword(registrationForm.getPassword());
			model.setConfirmedPassword(registrationForm.getConfirmPassword());
			model.setEmailId(registrationForm.getEmailId());
			model.setPhone(registrationForm.getPhone());
			model.setLocation(registrationForm.getLocation());
			dao.saveRegistration(model);
			message = "Registration Successfull....";
		} else {
			message = "Error Occures while processing Registration";
		}
		return message;
	}

	@Override
	public List<RegistrationModel> getUsers() {
		return dao.getRegisterUser();
	}

	@Override
	public String deleteRecord(int userId) {
		String deleteResponse = "";
		int status = dao.deleteRecord(userId);
		if (status == 1) {
			deleteResponse = "Record deleted successfully...";
		} else {
			deleteResponse = "Some technical issue try latter";
		}
		return deleteResponse;
	}

	@Override
	public String update(int id, RegistrationForm registrationForm) {
		return dao.updateRecord(id, registrationForm);
	}

	@Override
	public RegistrationModel getUser(int id) {
		return dao.getUser(id);

	}
}