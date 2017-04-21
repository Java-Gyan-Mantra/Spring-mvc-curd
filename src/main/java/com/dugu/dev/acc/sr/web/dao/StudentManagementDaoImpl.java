package com.dugu.dev.acc.sr.web.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dugu.dev.acc.sr.form.RegistrationForm;
import com.dugu.dev.acc.sr.web.model.RegistrationModel;

@Repository
public class StudentManagementDaoImpl implements StudentManagementDao {
	@Autowired(required = true)
	private SessionFactory factory;

	@Override
	public void saveRegistration(RegistrationModel model) {
		getSession().saveOrUpdate(model);
	}

	private Session getSession() {
		Session session = null;
		if (factory.getCurrentSession() == null) {
			session = factory.openSession();
		} else {
			session = factory.getCurrentSession();
		}
		return session;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistrationModel> getRegisterUser() {
		return getSession().createCriteria(RegistrationModel.class).list();
	}

	@Override
	public int deleteRecord(int userId) {
		int status;
		RegistrationModel model = (RegistrationModel) getSession()
				.createCriteria(RegistrationModel.class)
				.add(Restrictions.eq("userId", userId)).uniqueResult();
		if (model != null) {
			getSession().delete(model);
			status = 1;
		} else {
			status = 0;
		}
		return status;
	}

	@Override
	public String updateRecord(int userId, RegistrationForm registrationForm) {
		String status = null;
		RegistrationModel model = (RegistrationModel) getSession()
				.createCriteria(RegistrationModel.class)
				.add(Restrictions.eq("userId", userId)).uniqueResult();
		if (model != null) {
			model.setFirstName(registrationForm.getFirstName());
			model.setLastName(registrationForm.getLastName());
			model.setUserName(registrationForm.getUserName());
			model.setEmailId(registrationForm.getEmailId());
			model.setPhone(registrationForm.getPhone());
			model.setLocation(registrationForm.getLocation());
			getSession().update(model);
			status = "Updated successfully";
		} else {
			status = "Update Activity Error";
		}
		return status;
	}

	@Override
	public RegistrationModel getUser(int userId) {
		return (RegistrationModel) getSession()
				.createCriteria(RegistrationModel.class)
				.add(Restrictions.eq("userId", userId)).uniqueResult();
	}
}
