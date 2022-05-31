package com.laptrinhjava.service;

import com.laptrinhjava.model.UserModel;

public interface IUserService {
	UserModel findByUsername(String username, String passwordd, Integer statuss);
}
