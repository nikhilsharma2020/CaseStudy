package com.basha.model.service;

import java.sql.SQLException;

import com.basha.bean.Users;

public interface UserService {

	boolean signUp(Users user) throws ClassNotFoundException, SQLException;
	Users signIn(Users users) throws ClassNotFoundException, SQLException;
}
