package com.ahi.service;

import java.util.List;

import com.ahi.AHCustomException;
import com.ahi.entity.AhiUser;
import com.ahi.model.UserModel;
import com.ahi.web.to.PasswordConfirmation;

public interface UserService {

	void saveUser(String loginId, UserModel user) throws Exception;
	
	UserModel getUser(String username);
	
	List<UserModel> getUsers();
	
	void changePassword(String loginId, PasswordConfirmation passwordConfirmation) throws Exception;

//	UserModel addUser(UserModel userModel) throws AHCustomException;

	UserModel updateUser(UserModel userModel) throws AHCustomException;

	UserModel addUser(UserModel um, String userId) throws AHCustomException;
	
}
