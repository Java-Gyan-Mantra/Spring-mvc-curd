package com.dugu.dev.acc.sr.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.dugu.dev.acc.sr.form.RegistrationForm;
import com.dugu.dev.acc.sr.web.model.RegistrationModel;
import com.dugu.dev.acc.sr.web.service.StudentManagementServices;
import com.dugu.dev.acc.sr.web.validator.RegistrationValidator;

@Controller
public class StudentManagementController {
	@Autowired(required = true)
	private StudentManagementServices service;
	@Autowired(required = true)
	private RegistrationValidator validator;

	@RequestMapping(value = "/saveRegistration.aspx", method = RequestMethod.GET)
	public String getRegistrationPage(Model model) {
		RegistrationForm registrationForm = new RegistrationForm();
		model.addAttribute("registrationForm", registrationForm);
		return "registration";
	}

	@RequestMapping(value = "/saveRegistration.aspx", method = RequestMethod.POST)
	public String register(
			@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			Model model, BindingResult errors) {
		String response = "";
		if (validator.supports(registrationForm.getClass())) {
			validator.validate(registrationForm, errors);
			if (errors.hasErrors()) {
				return "registration";
			}
		}
		response = service.register(registrationForm);
		model.addAttribute("response", response);
		List<RegistrationModel> users = service.getUsers();
		model.addAttribute("users", users);
		return "results";

	}

	@RequestMapping(value = "/delete.aspx")
	public String delete(@RequestParam("id") String id, Model model) {
		int userId = Integer.parseInt(id);
		String deleteResponse = service.deleteRecord(userId);
		model.addAttribute("deleteResponse", deleteResponse);
		List<RegistrationModel> users = service.getUsers();
		model.addAttribute("users", users);
		return "results";
	}

	@RequestMapping(value = "/edit.aspx")
	public String update(@RequestParam("id") String id, Model model) {
		int userId = Integer.parseInt(id);
		String response = "";
		RegistrationModel registrationModel = service.getUser(userId);
		model.addAttribute("registrationModel", registrationModel);
		if (registrationModel == null) {
			response = "User Not Found";
			model.addAttribute("response", response);
		} else {
			response = "Update Your Current status";
			model.addAttribute("response", response);
		}

		return "update";
	}

	@RequestMapping(value = "/update.aspx")
	public String update(
			@RequestParam("userId") String userId,
			@ModelAttribute("registrationForm") RegistrationForm registrationForm,
			Model model) {
		String data = service
				.update(Integer.parseInt(userId), registrationForm);
		List<RegistrationModel> users = service.getUsers();
		model.addAttribute("users", users);
		model.addAttribute("data", data);
		return "results";
	}
}
