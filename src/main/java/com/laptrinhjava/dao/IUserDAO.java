package com.laptrinhjava.dao;

import com.laptrinhjava.model.UserModel;

public interface IUserDAO extends GenericDAO<UserModel> {
	UserModel findByUsername(String username, String password, Integer status);
}
