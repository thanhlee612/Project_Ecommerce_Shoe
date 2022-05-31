package com.laptrinhjava.service.impl;

import javax.inject.Inject;

import com.laptrinhjava.dao.IUserDAO;
import com.laptrinhjava.dao.impl.UserDAO;
import com.laptrinhjava.model.UserModel;
import com.laptrinhjava.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;
	
	@Override
	public UserModel findByUsername(String username, String password, Integer status) {	
		return userDAO.findByUsername(username, password, status);
	}

}
