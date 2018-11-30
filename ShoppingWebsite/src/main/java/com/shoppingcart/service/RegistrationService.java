package com.shoppingcart.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingcart.dao.UserDao;
import com.shoppingcart.model.User;

@Service
@Transactional
public class RegistrationService {
	@Autowired
	UserDao userDao;
	
	public String addUser(User user) {
		if(userDao.existsByEmail(user.getEmail())) {
			return "userexists";
		}
		else if(user.getPassword().length()<6) {
			return "Weak Password";
		}
		else {
			userDao.save(user);
			return "success";
		}
	}
	public String login(User user) {
		if(userDao.existsByEmail(user.getEmail())&&userDao.existsByPassword(user.getPassword())) {
			return "success";
		}
		else {
			return "failure";
		}
	}
}
